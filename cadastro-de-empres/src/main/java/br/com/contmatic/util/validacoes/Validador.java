package br.com.contmatic.util.validacoes;

import java.util.stream.IntStream;

public final class Validador {
	

	//MENSAGEM ERRO
	private static final String MENSAGEM_CAMPO_OBRIGATORIOS_NAO_PODEM_SER_VAZIO = "Campos obrigátorios não podem ser vazios";

	private static final String MENSAGEM_CAMPO_OBRIGATORIOS_NAO_PODE_SER_NULO = "Campos obrigátorios não podem ser nulos";
	
	private static final String MENSAGEM_CAMPO_DEVE_TER_LIMITES_100_CARACTERES = "Limite de 100 caracteres";
	
	private static final String MENSAGEM_CAMPO_DEVE_TER_LIMITES_256_CARACTERES = "Limite de 256 caracteres";
	
	private static final String MENSAGEM_DIGITE_SOMENTE_NUMEROS = "Digite somente numeros";
	
	private static final String MENSAGEM_TODOS_CARACTERES_REPETIDOS = "Campo não pode ter todos caracteres repetidos";
	
	private static final String MENSAGEM_CAMPO_NAO_PODE_SER_0 = "Campos não pode ser 0";
	
	private static final String MENSAGEM_CAMPO_NAO_ACEITA_NUMEROS = "Campo não aceita numeros";
	
	private static final String MENSAGEM_TAMANHO_INVALIDO = "Tamanho inválido";
	
	
	//TAMANHO CAMPO
	private static final int TAMANHO_MAX_DESCRICAO = 256;
	
	private static final int TAMANHO_MAX_GENERICO = 100;
	
	//TELEFONE
	private static final int TAMANHO_TELEFONE_FIXO = 10;
	
	private static final int TAMANHO_TELEFONE_CELULAR = 11;
	
	//CEP
	
	private static final int TAMANHO_CEP = 8;

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
	
	public static void validarTamanhoAtributoGenerico(String parametro) {
		if(parametro.length() >= TAMANHO_MAX_GENERICO) {
			throw new IllegalStateException(MENSAGEM_CAMPO_DEVE_TER_LIMITES_100_CARACTERES);
		}
	}
	
	public static void validarTamanhoDescricao(String parametro) {
		if(parametro.length() >= TAMANHO_MAX_DESCRICAO) {
			throw new IllegalStateException(MENSAGEM_CAMPO_DEVE_TER_LIMITES_256_CARACTERES);
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
		validarTamanhoAtributoGenerico(parametro);
	}
	
	public static void validarAtributoGenericoAceitandoNulo(String parametro) {
		if(parametro != null) {
			validarTamanhoAtributoGenerico(parametro);
		}
	}
	
	public static void validarAtributoDescricao(String parametro) {
		if(parametro != null) {
			validarAtributoVazio(parametro);
			validarTamanhoDescricao(parametro);
		}		
	}
	
	public static void validarAtributoNome(String parametro) {
		validarObjetoNulo(parametro);
		validarAtributoVazio(parametro);
		validarTamanhoAtributoGenerico(parametro);
		validarSomenteLetra(parametro);
	}
	
	//DOCUMENTOS
	
	protected static int calcularNumeroRegistro(String numRegistro, int quantidadeDigitos, int limiteSequencia, boolean inverterCaracteres) {
        int digitoVerificador = 0;
        int pularDigitos = 0;
        
        if (inverterCaracteres) {
            numRegistro = new StringBuilder(numRegistro).reverse().toString();
            pularDigitos = quantidadeDigitos;
        }
        
        int[] valoresComputados = new int[numRegistro.length() - quantidadeDigitos];
   
        int valorSequencia = 2;
        
        for (int index = 0; index < (numRegistro.length() - quantidadeDigitos); index++) {
            valoresComputados[index] = Character.getNumericValue(numRegistro.charAt(index + pularDigitos)) * valorSequencia;
            valorSequencia++;
            if (valorSequencia > limiteSequencia) valorSequencia = 2;
        }
        
        digitoVerificador = (IntStream.of(valoresComputados).sum());
        return digitoVerificador;
	}
	
	public static void validarCaracteresRepetidos(Object parametro) {
		if(!IntStream.range(0, parametro.toString().length() - 1).anyMatch(i ->  parametro.toString().charAt(i) !=  parametro.toString().charAt(i + 1))) {
			throw new IllegalStateException(MENSAGEM_TODOS_CARACTERES_REPETIDOS);
		}
	}
}

