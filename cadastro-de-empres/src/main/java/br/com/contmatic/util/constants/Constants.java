package br.com.contmatic.util.constants;

public final class Constants {

	private Constants() {
	}

	// EMPRESA
	public static final Integer TAMANHO_CNPJ = 14;

	public static final Integer TAMANHO_MAX_RAZAO_SOCIAL = 100;
	public static final Integer TAMANHO_MIN_RAZAO_SOCIAL = 5;

	public static final Integer TAMANHO_MAX_NOME_FANTASIA = 100;
	public static final Integer TAMANHO_MIN_NOME_FANTASIA = 5;

	public static final Integer TAMANHO_MAX_LISTA_ENDERECO = 5;

	public static final Integer TAMANHO_MAX_LISTA_AMBIENTE_TRABALHO = 30;

	public static final Integer TAMANHO_MAX_LISTA_PRODUTO = 9999;

	public static final Integer TAMANHO_MAX_LISTA_USUARIOS = 15;

	// AMBIENTES TRABALHO
	public static final Integer TAMANHO_MAX_NOME_AMBIENTE_TRABALHO = 60;
	public static final Integer TAMANHO_MIN_NOME_AMBIENTE_TRABALHO = 3;

	public static final Integer TAMANHO_MAX_DESCRICAO_AMBIENTE_TRABALHO = 256;
	public static final Integer TAMANHO_MIN_DESCRICAO_AMBIENTE_TRABALHO = 3;

	public static final Integer TAMANHO_MAX_LISTA_SETORES_AMBIENTE_TRABALHO = 30;

	public static final Integer TAMANHO_MAX_LISTA_ENDERECOS_AMBIENTE_TRABALHO = 5;

	// SETOR
	public static final Integer TAMANHO_MAX_NOME_SETOR = 60;
	public static final Integer TAMANHO_MIN_NOME_SETOR = 3;

	public static final Integer TAMANHO_MAX_DESCRICAO_SETOR = 256;
	public static final Integer TAMANHO_MIN_DESCRICAO_SETOR = 3;

	public static final Integer TAMANHO_MAX_LISTA_FUNCIONARIOS_SETOR = 999;

	// FUNCIONARIO
	public static final Integer TAMANHO_CPF = 11;

	public static final Integer TAMANHO_MAX_NOME_FUNCIONARIO = 80;
	public static final Integer TAMANHO_MIN_NOME_FUNCIONARIO = 3;

	public static final Integer TAMANHO_MAX_LISTA_ENDERECOS_FUNCIONARIOS = 5;

	public static final Integer TAMANHO_DATA = 8;

	// PRODUTO
	public static final Integer TAMANHO_MAX_CODIGO_PRODUTO = 10;
	public static final Integer TAMANHO_MIN_CODIGO_PRODUTO = 1;

	public static final Integer TAMANHO_MAX_NOME_PRODUTO = 60;
	public static final Integer TAMANHO_MIN_NOME_PRODUTO = 3;

	public static final Integer TAMANHO_MAX_MARCA_PRODUTO = 60;
	public static final Integer TAMANHO_MIN_MARCA_PRODUTO = 3;

	public static final Integer TAMANHO_MAX_COR_PRODUTO = 30;
	public static final Integer TAMANHO_MIN_COR_PRODUTO = 2;

	public static final Integer QUANTIDADE_MAX_PRODUTO = 9999;

	public static final Double PRECO_MAX_PRODUTO = 99999999.99;

	// ENDERECO
	public static final Integer TAMANHO_CEP = 8;

	public static final Integer TAMANHO_MAX_LOGRADOURO_ENDERECO = 60;
	public static final Integer TAMANHO_MIN_LOGRADOURO_ENDERECO = 2;

	public static final Integer TAMANHO_MAX_COMPLEMENTO_ENDERECO = 30;
	public static final Integer TAMANHO_MIN_COMPLEMENTO_ENDERECO = 2;

	public static final Integer NUMERO_MAX_ENDERECO = 99999;

	public static final Integer TAMANHO_MAX_BAIRRO_ENDERECO = 60;
	public static final Integer TAMANHO_MIN_BAIRRO_ENDERECO = 2;

	// CIDADE
	public static final Integer TAMANHO_MAX_CIDADE_ENDERECO = 60;
	public static final Integer TAMANHO_MIN_CIDADE_ENDERECO = 3;

	public static final Integer CODIGO_MAX_IBGE = 9999999;

	// ESTADO
	public static final Integer TAMANHO_MAX_ESTADO_ENDERECO = 60;
	public static final Integer TAMANHO_MIN_ESTADO_ENDERECO = 3;

	public static final Integer TAMANHO_LISTA_MAX_CIDADES = 999;

	public static final Integer TAMANHO_MAX_SIGLA_ESTADO_ENDERECO = 2;
	public static final Integer TAMANHO_MIN_SIGLA_ESTADO_ENDERECO = 1;

	// TELEFONES
	public static final Integer TAMANHO_MAX_LISTA_TELEFONES = 5;

	// EMAIL
	public static final Integer TAMANHO_MAX_LISTA_EMAILS = 5;

	public static final Integer TAMANHO_MAX_EMAIL = 60;
	public static final Integer TAMANHO_MIN_EMAIL = 5;

	public static final String CARACTERE_OBRIGATORIO_EMAIL = "@";

	// CARGO
	public static final Integer TAMANHO_MAX_NOME_CARGO = 60;
	public static final Integer TAMANHO_MIN_NOME_CARGO = 3;

	public static final Integer TAMANHO_MAX_DESCRICAO_CARGO = 256;
	public static final Integer TAMANHO_MIN_DESCRICAO_CARGO = 3;

	// REGEX
	public static final String REGEX_SOMENTE_NUMEROS = "([0-9]*)";

	public static final String REGEX_SIGLA_ESTADO = "([A-Z]*)";

	public static final String REGEX_SOMENTE_LETRAS = "([a-zA-ZÁ-Úá-ú ]*)";

	public static final String REGEX_LETRAS_NUMEROS = "([a-zA-ZÁ-Úá-ú0-9 ]*)";

	public static final String REGEX_RAZAO_SOCIAL = "([A-Za-zÁ-Úá-ú.&, ]*)";

	public static final String REGEX_LETRAS_NUMEROS_PONTOS = "([a-zA-Z0-9á-úÁ-Ú,. ]*)";

	public static final String REGEX_SENHA = "(?=.*[a-z=])(?=.*[0-9])(?=.*[A-Z]).{8,30}";

	// VALIDADOR DOCUMENTOS
	public static final Integer QUANTIDADE_DIGITOS_CALCULO = 0;
	public static final Integer VALOR_INICIAL_SEQUENCIA = 2;

	public static final Integer INICIO_RANGE = 0;

	// AUDIT
	public static final Integer TAMANHO_MAX_CREATEBY = 60;
	public static final Integer TAMANHO_MIN_CREATEBY = 3;

	// USUARIO
	public static final Integer TAMANHO_MAX_SENHA_USUARIO = 30;
	public static final Integer TAMANHO_MIN_SENHA_USUARIO = 8;

	public static final Integer LOG_ROUNDS = 10;

	// VALIDADOR DATA

	public static final Integer IDADE_MINIMA = 14;
}
