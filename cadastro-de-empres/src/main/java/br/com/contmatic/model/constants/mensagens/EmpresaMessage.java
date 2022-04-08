package br.com.contmatic.model.constants.mensagens;

import static br.com.contmatic.model.constants.numericas.EmpresaConstants.TAMANHO_CNPJ;
import static br.com.contmatic.model.constants.numericas.EmpresaConstants.TAMANHO_MAX_LISTA_AMBIENTE_TRABALHO;
import static br.com.contmatic.model.constants.numericas.EmpresaConstants.TAMANHO_MAX_LISTA_EMAILS;
import static br.com.contmatic.model.constants.numericas.EmpresaConstants.TAMANHO_MAX_LISTA_ENDERECO;
import static br.com.contmatic.model.constants.numericas.EmpresaConstants.TAMANHO_MAX_LISTA_PRODUTO;
import static br.com.contmatic.model.constants.numericas.EmpresaConstants.TAMANHO_MAX_LISTA_TELEFONES;
import static br.com.contmatic.model.constants.numericas.EmpresaConstants.TAMANHO_MAX_NOME_FANTASIA;
import static br.com.contmatic.model.constants.numericas.EmpresaConstants.TAMANHO_MAX_RAZAO_SOCIAL;
import static br.com.contmatic.model.constants.numericas.EmpresaConstants.TAMANHO_MIN_NOME_FANTASIA;
import static br.com.contmatic.model.constants.numericas.EmpresaConstants.TAMANHO_MIN_RAZAO_SOCIAL;

public final class EmpresaMessage {

	private EmpresaMessage() {
	}
	
	public static final String MESSAGE_CNPJ_NOTNULL = "O cnpj não pode ser nulo";
	public static final String MESSAGE_CNPJ_NOTBLANK = "O cnpj não pode ser vazio";
	public static final String MESSAGE_TAMANHO_CNPJ = String.format("O cnpj deve conter %s numeros", TAMANHO_CNPJ);
	public static final String MESSAGE_CNPJ_REGEX = "O cnpj aceita apenas números";
	public static final String MENSAGEM_CNPJ_CARACTERES_REPETIDOS = "O cnpj não pode ter todos caracteres repetidos";
	
	public static final String MESSAGE_RAZAO_SOCIAL_NOTNULL = "A razão social não pode ser nulo";
	public static final String MESSAGE_RAZAO_SOCIAL_NOTBLANK = "A razão social não pode ser vazio";
	public static final String MESSAGE_TAMANHO_MAX_RAZAO_SOCIAL = String.format("A razão social não pode conter mais que %s caracteres.", TAMANHO_MAX_RAZAO_SOCIAL);
	public static final String MESSAGE_TAMANHO_MIN_RAZAO_SOCIAL = String.format("A razão social não pode conter menos que %s caracteres!", TAMANHO_MIN_RAZAO_SOCIAL);
	public static final String MENSAGEM_RAZAO_SOCIAL_REGEX = "A razão social aceita texto alfanumerico, pontos e o (&) comercial";
	
	public static final String MESSAGE_NOME_FANTASIA_NOTNULL = "O nome fantasia não pode ser nulo";
	public static final String MESSAGE_NOME_FANTASIA_NOTBLANK = "O nome fantasia não pode ser vazio";
	public static final String MESSAGE_TAMANHO_MAX_NOME_FANTASIA = String.format("O nome fantasia não pode conter mais que %s caracteres", TAMANHO_MAX_NOME_FANTASIA);
	public static final String MESSAGE_TAMANHO_MIN_NOME_FANTASIA = String.format("O nome fantasia não pode conter menos que %s caracteres", TAMANHO_MIN_NOME_FANTASIA);

	public static final String MESSAGE_ENDERECOS_NOT_NULL = "A lista de enderecos não pode ser nulo";
	public static final String MESSAGE_ENDERECOS_IS_EMPTY = "A lista de enderecos não pode ser vazia";
	public static final String MESSAGE_ENDERECOS_LIST_MAX = String.format("A lista de enderecos não pode ser maior que %s", TAMANHO_MAX_LISTA_ENDERECO);
	
	public static final String MESSAGE_AMBIENTE_TRABALHO_NOT_NULL = "A lista de ambientes não pode ser nulo";
	public static final String MESSAGE_AMBIENTE_TRABALHO_IS_EMPTY = "A lista de ambientes não pode ser vazia";
	public static final String MESSAGE_AMBIENTE_TRABALHO_LIST_MAX = String.format("A lista de ambientes não pode ser maior que %s", TAMANHO_MAX_LISTA_AMBIENTE_TRABALHO);
	
	public static final String MESSAGE_PRODUTOS_NOT_NULL = "A lista de produtos não pode ser nulo";
	public static final String MESSAGE_PRODUTOS_IS_EMPTY = "A lista de produtos não pode ser vazia";
	public static final String MESSAGE_PRODUTOS_LIST_MAX = String.format("A lista de produtos não pode ser maior que %s", TAMANHO_MAX_LISTA_PRODUTO);
	
	public static final String MESSAGE_TELEFONES_NOT_NULL = "A lista de telefones não pode ser nulo";
	public static final String MESSAGE_TELEFONES_IS_EMPTY = "A lista de telefones não pode ser vazia";
	public static final String MESSAGE_TELEFONES_LIST_MAX = String.format("A lista de telefones não pode ser maior que %s", TAMANHO_MAX_LISTA_TELEFONES);
	
	public static final String MESSAGE_EMAILS_NOT_NULL = "A lista de emails não pode ser nulo";
	public static final String MESSAGE_EMAILS_IS_EMPTY = "A lista de emails não pode ser vazia";
	public static final String MESSAGE_EMAILS_LIST_MAX = String.format("A lista de emails não pode ser maior que %s", TAMANHO_MAX_LISTA_EMAILS);

	public static final String MESSAGE_ATIVO_NOT_NULL = "o campo ativo não pode ser nulo";
}
