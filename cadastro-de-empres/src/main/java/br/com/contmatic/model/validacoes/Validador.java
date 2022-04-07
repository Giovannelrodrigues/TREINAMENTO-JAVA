package br.com.contmatic.model.validacoes;
import java.util.List;
import java.util.stream.IntStream;

public class Validador {

	private Validador() {
	}

	public static void validarVazio(Object parametro, String message) {
		if (parametro.toString().trim().isEmpty()) {
			throw new IllegalStateException(message);
		}
	}

	public static void validarNulo(Object obj, String message) {
		if (obj == null) {
			throw new IllegalArgumentException(message);
		}
	}
	
	public static void validarZero(int parametro, String message) {
		if (parametro == 0) {
			throw new IllegalStateException(message);
		}
	}
	
	public static void validarZeroOrNegative(double parametro, String message) {
		if (parametro <= 0.0) {
			throw new IllegalStateException(message);
		}
	}

	public static void validarTamanhoMaximo(String parametro, int tamanho, String message) {
		if (parametro.length() > tamanho) {
			throw new IllegalStateException(message);
		}
	}

	public static void validarTamanhoMinimo(String parametro, int tamanho, String message) {
		if (parametro.length() < tamanho) {
			throw new IllegalStateException(message);
		}
	}

	public static void validarTamanho(String parametro, int tamanho, String message) {
		if (parametro.length() != tamanho) {
			throw new IllegalStateException(message);
		}
	}

	public static void validarRegex(String parametro, String regex, String messageErro) {
		if (!parametro.matches(regex)) {
			throw new IllegalStateException(messageErro);
		}
	}

	public static void validarNumeroMaximo(Integer parametro, Integer quantidadeMaxima, String message) {
		if (parametro > quantidadeMaxima) {
			throw new IllegalStateException(message);
		}
	}

	public static void validarNumeroMaximo(double parametro, double quantidadeMaxima, String message) {
		if (parametro > quantidadeMaxima) {
			throw new IllegalStateException(message);
		}
	}
	
	// LISTA
	public static void validarListaVazia(List<?> parametro, String message) {
		if (parametro.isEmpty()) {
			throw new IllegalStateException(message);
		}
	}

	public static void validarTamanhoMaximoLista(List<?> parametro, int tamanho, String message) {
		if (parametro.size() > tamanho) {
			throw new IllegalStateException(message);
		}
	}

	// DOCUMENTOS
	protected static int calcularNumeroRegistro(String numRegistro, int quantidadeDigitos, int limiteSequencia, boolean inverterCaracteres) {
		int pularDigitos = 0;
		if (inverterCaracteres) {
			numRegistro = inverterString(numRegistro);
			pularDigitos = quantidadeDigitos;
		}
		return (IntStream.of(checkValuesCompeted(numRegistro, quantidadeDigitos, limiteSequencia, pularDigitos)).sum());
	}

	private static int[] checkValuesCompeted(String numRegistro, int quantidadeDigitos, int limiteSequencia, int pularDigitos) {
		final Integer VALOR_INICIAL_SEQUENCIA = 2;
		
		int[] valoresComputados = new int[numRegistro.length() - quantidadeDigitos];
		int valorSequencia = VALOR_INICIAL_SEQUENCIA;
		for (int index = 0; index < (numRegistro.length() - quantidadeDigitos); index++) {
			valoresComputados[index] = Character.getNumericValue(numRegistro.charAt(index + pularDigitos)) * valorSequencia;
			valorSequencia++;
			if (valorSequencia > limiteSequencia)
				valorSequencia = VALOR_INICIAL_SEQUENCIA;
		}
		return valoresComputados;
	}
	
	public static void validarCaracteresRepetidos(Object parametro, String message) {
		final int INICIO_RANGE = 0;
		if (!IntStream.range(INICIO_RANGE, parametro.toString().length() - 1)
				.anyMatch(i -> parametro.toString().charAt(i) != parametro.toString().charAt(i + 1))) {
			throw new IllegalStateException(message);
		}
	}

	public static String inverterString(String numRegistro) {
		return new StringBuilder(numRegistro).reverse().toString();
	}
}
