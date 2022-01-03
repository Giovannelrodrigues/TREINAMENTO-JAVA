package br.com.contmatic.util.validacoes;

import static br.com.contmatic.util.constants.Constants.INICIO_RANGE;
import static br.com.contmatic.util.constants.Constants.QUANTIDADE_DIGITOS_CALCULO;
import static br.com.contmatic.util.constants.Constants.VALOR_INICIAL_SEQUENCIA;
import static br.com.contmatic.util.constants.Message.CAMPO_DEVE_CONTER;
import static br.com.contmatic.util.constants.Message.MENSAGEM_CAMPO_NAO_PODE_SER_0;
import static br.com.contmatic.util.constants.Message.MENSAGEM_CAMPO_OBRIGATORIOS_NAO_PODEM_SER_VAZIO;
import static br.com.contmatic.util.constants.Message.MENSAGEM_CAMPO_OBRIGATORIOS_NAO_PODE_SER_NULO;
import static br.com.contmatic.util.constants.Message.MENSAGEM_ERRO_REGEX_SOMENTE_NUMEROS;
import static br.com.contmatic.util.constants.Message.MENSAGEM_LISTA_NAO_PODE_SER_VAZIA;
import static br.com.contmatic.util.constants.Message.MENSAGEM_NUMERO_MAX_ATIGINDO;
import static br.com.contmatic.util.constants.Message.MENSAGEM_TAMANHO_INVALIDO;
import static br.com.contmatic.util.constants.Message.MENSAGEM_TODOS_CARACTERES_REPETIDOS;

import java.util.List;
import java.util.stream.IntStream;

public class Validador {

	private Validador() {
	}

	public static void validarVazio(Object parametro) {
		if (parametro.toString().trim().isEmpty()) {
			throw new IllegalStateException(MENSAGEM_CAMPO_OBRIGATORIOS_NAO_PODEM_SER_VAZIO);
		}
	}

	public static void validarNulo(Object obj) {
		if (obj == null) {
			throw new IllegalArgumentException(MENSAGEM_CAMPO_OBRIGATORIOS_NAO_PODE_SER_NULO);
		}
	}

	public static void validarZero(double parametro) {
		if (parametro == 0) {
			throw new IllegalStateException(MENSAGEM_CAMPO_NAO_PODE_SER_0);
		}
	}

	public static void validarSomenteNumero(String parametro) {
		if (!parametro.matches("^\\d+$")) {
			throw new IllegalStateException(MENSAGEM_ERRO_REGEX_SOMENTE_NUMEROS);
		}
	}

	public static void validarTamanhoMaximo(String parametro, int tamanho) {
		if (parametro.length() > tamanho) {
			throw new IllegalStateException(MENSAGEM_TAMANHO_INVALIDO);
		}
	}

	public static void validarTamanhoMinimo(String parametro, int tamanho) {
		if (parametro.length() < tamanho) {
			throw new IllegalStateException(MENSAGEM_TAMANHO_INVALIDO);
		}
	}

	public static void validarTamanho(String parametro, int tamanho) {
		if (parametro.length() != tamanho) {
			throw new IllegalStateException(MENSAGEM_TAMANHO_INVALIDO);
		}
	}

	public static void validarRegex(String parametro, String regex, String messageErro) {
		if (!parametro.matches(regex)) {
			throw new IllegalStateException(messageErro);
		}
	}

	public static void validarNumeroMaximo(int parametro, int quantidadeMaxima) {
		if (parametro > quantidadeMaxima) {
			throw new IllegalStateException(MENSAGEM_NUMERO_MAX_ATIGINDO + quantidadeMaxima);
		}
	}

	public static void validarNumeroMaximo(double parametro, double quantidadeMaxima) {
		if (parametro > quantidadeMaxima) {
			throw new IllegalStateException(MENSAGEM_NUMERO_MAX_ATIGINDO + quantidadeMaxima);
		}
	}

	public static void stringContain(String parametro, String deveConter) {
		if (!parametro.contains(deveConter)) {
			throw new IllegalStateException(CAMPO_DEVE_CONTER + deveConter);
		}
	}

	// LISTA
	public static void validarListaVazia(List<?> parametro) {
		if (parametro.isEmpty()) {
			throw new IllegalStateException(MENSAGEM_LISTA_NAO_PODE_SER_VAZIA);
		}
	}

	public static void validarTamanhoMaximoLista(List<?> parametro, int tamanho) {
		if (parametro.size() > tamanho) {
			throw new IllegalStateException(MENSAGEM_LISTA_NAO_PODE_SER_VAZIA);
		}
	}

	// DOCUMENTOS
	protected static int calcularNumeroRegistro(String numRegistro, int quantidadeDigitos, int limiteSequencia,
			boolean inverterCaracteres) {
		int pularDigitos = QUANTIDADE_DIGITOS_CALCULO;

		if (inverterCaracteres) {
			numRegistro = inverterString(numRegistro);
			pularDigitos = quantidadeDigitos;
		}

		return (IntStream.of(checkValuesCompeted(numRegistro, quantidadeDigitos, limiteSequencia, pularDigitos)).sum());
	}

	private static int[] checkValuesCompeted(String numRegistro, int quantidadeDigitos, int limiteSequencia,
			int pularDigitos) {
		int[] valoresComputados = new int[numRegistro.length() - quantidadeDigitos];
		int valorSequencia = VALOR_INICIAL_SEQUENCIA;
		for (int index = 0; index < (numRegistro.length() - quantidadeDigitos); index++) {
			valoresComputados[index] = Character.getNumericValue(numRegistro.charAt(index + pularDigitos))
					* valorSequencia;
			valorSequencia++;
			if (valorSequencia > limiteSequencia)
				valorSequencia = VALOR_INICIAL_SEQUENCIA;
		}
		return valoresComputados;
	}

	public static void validarCaracteresRepetidos(Object parametro) {
		if (!IntStream.range(INICIO_RANGE, parametro.toString().length() - 1)
				.anyMatch(i -> parametro.toString().charAt(i) != parametro.toString().charAt(i + 1))) {
			throw new IllegalStateException(MENSAGEM_TODOS_CARACTERES_REPETIDOS);
		}
	}

	public static String inverterString(String numRegistro) {
		return new StringBuilder(numRegistro).reverse().toString();
	}

}
