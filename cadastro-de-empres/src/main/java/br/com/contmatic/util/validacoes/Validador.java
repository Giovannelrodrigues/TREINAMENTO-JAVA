package br.com.contmatic.util.validacoes;

import java.util.List;
import java.util.stream.IntStream;

public final class Validador {
	

	//MENSAGEM ERRO
	private static final String MENSAGEM_CAMPO_OBRIGATORIOS_NAO_PODEM_SER_VAZIO = "Campos obrigátorios não podem ser vazios";

	private static final String MENSAGEM_CAMPO_OBRIGATORIOS_NAO_PODE_SER_NULO = "Campos obrigátorios não podem ser nulos";
	
	private static final String MENSAGEM_DIGITE_SOMENTE_NUMEROS = "Digite somente numeros";
	
	private static final String MENSAGEM_TODOS_CARACTERES_REPETIDOS = "Campo não pode ter todos caracteres repetidos";
	
	private static final String MENSAGEM_CAMPO_NAO_ACEITA_NUMEROS = "Campo não aceita numeros";
	
	//TAMANHO CAMPO
	
	private static final String MENSAGEM_TAMANHO_INVALIDO = "Tamanho inválido";
	
	private static final String MENSAGEM_LISTA_NAO_PODE_SER_VAZIA = "Lista não pode ser vazia";
	
	private static final String MENSAGEM_CAMPO_NAO_PODE_SER_0 = "Campos não pode ser 0";
	
	private static final int TAMANHO_MAX_DESCRICAO = 256;
	
	private static final int TAMANHO_MAX_GENERICO = 100;
	
	
	//TELEFONE
	private static final int TAMANHO_TELEFONE_FIXO = 10;
	
	private static final int TAMANHO_TELEFONE_CELULAR = 11;
	
	//CEP
	private static final int TAMANHO_CEP = 8;
	
	//CALCULO BASE DOCUMENTOS
	
	private static final int QUANTIDADE_DIGITOS_CALCULO = 0;
	
	private static final int VALOR_INICIAL_SEQUENCIA = 2;

	private Validador() {
	}
	
	
	public static void validarAtributoVazio(String parametro) {
		if(parametro.trim().isEmpty()) {
			throw new IllegalStateException(MENSAGEM_CAMPO_OBRIGATORIOS_NAO_PODEM_SER_VAZIO);
		}
	}

	public static void validarObjetoNulo(Object obj) {
		if(obj == null) {
			throw new IllegalArgumentException(MENSAGEM_CAMPO_OBRIGATORIOS_NAO_PODE_SER_NULO);
		}
	}
	
	public static void validarSeNumeroZero(double parametro) {
		if (parametro == 0) {
			throw new IllegalStateException(MENSAGEM_CAMPO_NAO_PODE_SER_0);
		}
	}
	
	public static void validarSomenteNumero(String parametro) {
		if (!parametro.matches("^\\d+$")) {
			throw new IllegalStateException(MENSAGEM_DIGITE_SOMENTE_NUMEROS);
		}
	}
	
	public static void validarTamanho(String parametro, int tamanho) {
		if(parametro.length() != tamanho) {
			throw new IllegalStateException(MENSAGEM_TAMANHO_INVALIDO);
		}
	}
	
	public static void validarSomenteLetra(String parametro) {
		if(!parametro.matches("^\\D+$")) {
			throw new IllegalStateException(MENSAGEM_CAMPO_NAO_ACEITA_NUMEROS);
		}
	}
	
	//LISTA
	public static void validarListaVazia(List<?> parametro) {
		if(parametro.isEmpty()) {
			throw new IllegalStateException(MENSAGEM_LISTA_NAO_PODE_SER_VAZIA);
		}
	}
	
	//TELEFONE
	public static void validarTelefone(String telefone) {
		validarObjetoNulo(telefone);
		validarSomenteNumero(telefone);
		if (telefone.length() != TAMANHO_TELEFONE_FIXO && telefone.length() != TAMANHO_TELEFONE_CELULAR) {
			throw new IllegalStateException(MENSAGEM_TAMANHO_INVALIDO);
		}
	}
	
	//VALIDAR CEP 
	public static void validarCEP(String cep) {
		validarObjetoNulo(cep);
		validarAtributoVazio(cep);
		validarTamanho(cep, TAMANHO_CEP);
	}
	
	//CAMPOS
	
	public static void validarAtributoGenerico(String parametro) {
		validarObjetoNulo(parametro);
		validarAtributoVazio(parametro);
		validarTamanho(parametro, TAMANHO_MAX_GENERICO);
	}
	
	public static void validarAtributoGenericoAceitandoNulo(String parametro) {
		if(parametro != null) {
			validarTamanho(parametro, TAMANHO_MAX_GENERICO);
		}
	}
	
	public static void validarAtributoDescricao(String parametro) {
		if(parametro != null) {
			validarAtributoVazio(parametro);
			validarTamanho(parametro, TAMANHO_MAX_DESCRICAO);
		}		
	}
	
	public static void validarAtributoNome(String parametro) {
		validarObjetoNulo(parametro);
		validarAtributoVazio(parametro);
		validarTamanho(parametro, TAMANHO_MAX_GENERICO);
		validarSomenteLetra(parametro);
	}
	
	public static void validarLista(List<?> parametro) {
		validarObjetoNulo(parametro);
		validarListaVazia(parametro);
	}
	
	//DOCUMENTOS
	protected static int calcularNumeroRegistro(String numRegistro, int quantidadeDigitos, int limiteSequencia, boolean inverterCaracteres) {
        int pularDigitos = QUANTIDADE_DIGITOS_CALCULO;
        
        if (inverterCaracteres) {
            numRegistro = new StringBuilder(numRegistro).reverse().toString();
            pularDigitos = quantidadeDigitos;
        }
        
        int[] valoresComputados = new int[numRegistro.length() - quantidadeDigitos];
   
        int valorSequencia = VALOR_INICIAL_SEQUENCIA;
        
        for (int index = 0; index < (numRegistro.length() - quantidadeDigitos); index++) {
            valoresComputados[index] = Character.getNumericValue(numRegistro.charAt(index + pularDigitos)) * valorSequencia;
            valorSequencia++;
            if (valorSequencia > limiteSequencia) valorSequencia = VALOR_INICIAL_SEQUENCIA;
        }
    
        return (IntStream.of(valoresComputados).sum());
	}
	
	public static void validarCaracteresRepetidos(Object parametro) {
		if(!IntStream.range(0, parametro.toString().length() - 1).anyMatch(i ->  parametro.toString().charAt(i) !=  parametro.toString().charAt(i + 1))) {
			throw new IllegalStateException(MENSAGEM_TODOS_CARACTERES_REPETIDOS);
		}
	}
	
	
}

