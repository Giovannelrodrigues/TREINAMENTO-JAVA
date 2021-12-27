package br.com.contmatic.util.constants;

public final class Message {

	private Message() {
	}

	public static final String MENSAGEM_ERRO_REGEX_SOMENTE_LETRAS_MAIUSCULAS = "Campo aceita somente maiusculas";
	public static final String MENSAGEM_ERRO_REGEX_SOMENTE_LETRAS = "Campo aceita somente letras minuscula e maiusculas";
	public static final String MENSAGEM_ERRO_REGEX_SOMENTE_NUMEROS = "Campo aceita somente numeros";
	public static final String MENSAGEM_ERRO_REGEX_LETRAS_NUMEROS = "Campo aceita somente de letras minuscula, maiusculas e numeros";

	// EMPRESA
	public static final String MENSAGEM_ERRO_REGEX_RAZAO_SOCIAL = "A raz�o social n�o atende aos requisitos, campo aceita somente letras, numeros, & e .";

	// VALIDADOR
	public static final String MENSAGEM_CAMPO_OBRIGATORIOS_NAO_PODEM_SER_VAZIO = "Campos obrig�torios n�o podem ser vazios";

	public static final String MENSAGEM_CAMPO_OBRIGATORIOS_NAO_PODE_SER_NULO = "Campos obrig�torios n�o podem ser nulos";

	public static final String MENSAGEM_TODOS_CARACTERES_REPETIDOS = "Campo n�o pode ter todos caracteres repetidos";

	public static final String MENSAGEM_NUMERO_MAX_ATIGINDO = "Numero maximo atingido, digite um numero menor que ";

	public static final String CAMPO_DEVE_CONTER = "Campo deve conter ";
	// TAMANHO CAMPO
	public static final String MENSAGEM_TAMANHO_INVALIDO = "Tamanho inv�lido";

	public static final String MENSAGEM_LISTA_NAO_PODE_SER_VAZIA = "Lista n�o pode ser vazia";

	public static final String MENSAGEM_CAMPO_NAO_PODE_SER_0 = "Campos n�o pode ser 0";

	// VALIDADOR CNPJ
	public static final String MENSAGEM_CNPJ_INVALIDO = "CNPJ inv�lido";

	// VALIDADOR CPF
	public static final String MENSAGEM_CPF_INVALIDO = "CPF inv�lido";

	// USUARIO
	public static final String MENSAGEM_SENHA_FRACA = "Senha deve conter letra Maiuscula, Minuscula e Numero";

	public static final String MENSAGEM_SENHA_INVALIDA = "Senha inválida";

	// DATA
	public static final String DATA_INVALIDA = "Data Invalida";

	// IDADE
	public static final String MENSAGEM_IDADE_MINIMA = "Você não possui idade suficente. Você deve ter mais de 14 anos";

	// FELEFONE
	public static final String MENSAGEM_TAMANHO_INVALIDO_TELEFONE = "Telefone n�o pode ter tamanho diferente de 10 ou 11 caracteres";

}
