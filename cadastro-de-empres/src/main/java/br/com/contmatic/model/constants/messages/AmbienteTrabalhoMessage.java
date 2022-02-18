package br.com.contmatic.model.constants.messages;

import static br.com.contmatic.model.constants.AmbienteTrabalhoConstants.TAMANHO_MAX_DESCRICAO;
import static br.com.contmatic.model.constants.AmbienteTrabalhoConstants.TAMANHO_MAX_LISTA_ENDERECOS;
import static br.com.contmatic.model.constants.AmbienteTrabalhoConstants.TAMANHO_MAX_LISTA_SETORES;
import static br.com.contmatic.model.constants.AmbienteTrabalhoConstants.TAMANHO_MAX_NOME;
import static br.com.contmatic.model.constants.AmbienteTrabalhoConstants.TAMANHO_MIN_DESCRICAO;
import static br.com.contmatic.model.constants.AmbienteTrabalhoConstants.TAMANHO_MIN_NOME;

public final class AmbienteTrabalhoMessage {

	private AmbienteTrabalhoMessage() {
	}
	
	public static final String MESSAGE_NOME_NOTNULL = "O nome do ambiente não pode ser nulo";
	public static final String MESSAGE_NOME_NOTBLANK = "O nome do ambiente não pode ser vazio";
	public static final String MESSAGE_NOME_REGEX = "O nome do ambiente aceita apenas letras";
	public static final String MESSAGE_TAMANHO_MAX_NOME = "O nome do ambiente não pode conter mais que " + TAMANHO_MAX_NOME + " caracteres";
	public static final String MESSAGE_TAMANHO_MIN_NOME = "O nome do ambiente não pode conter menos que " + TAMANHO_MIN_NOME + " caracteres";
	
	public static final String MESSAGE_DESCRICAO_NOTNULL = "A descricao não pode ser nulo";
	public static final String MESSAGE_DESCRICAO_NOTBLANK = "A descricao do ambiente não pode ser vazio";
	public static final String MESSAGE_TAMANHO_MAX_DESCRICAO = "A descricao do ambiente não pode conter mais que " + TAMANHO_MAX_DESCRICAO + " caracteres";
	public static final String MESSAGE_TAMANHO_MIN_DESCRICAO = "A descricao do ambiente não pode conter menos que " + TAMANHO_MIN_DESCRICAO + " caracteres";
	
	public static final String MESSAGE_TIPO_NOTNULL = "O tipo do ambiente não pode ser nulo";
	
	public static final String MESSAGE_SETORES_NOT_NULL = "A lista de setores não pode ser nulo";
	public static final String MESSAGE_SETORES_IS_EMPTY = "A lista de setores não pode ser vazia";
	public static final String MESSAGE_SETORES_LIST_MAX = "A lista de setores não pode ser maior que " + TAMANHO_MAX_LISTA_SETORES;
	
	public static final String MESSAGE_ENDERECOS_NOT_NULL = "A lista de enderecos não pode ser nulo";
	public static final String MESSAGE_ENDERECOS_IS_EMPTY = "A lista de enderecos não pode ser vazia";
	public static final String MESSAGE_ENDERECOS_LIST_MAX = "A lista de enderecos não pode ser maior que " + TAMANHO_MAX_LISTA_ENDERECOS;
	
	public static final String MESSAGE_EMPRESA_NOT_NULL = "A empresa não pode ser nula";

}
