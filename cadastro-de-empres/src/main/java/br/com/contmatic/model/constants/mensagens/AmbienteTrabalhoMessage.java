package br.com.contmatic.model.constants.mensagens;

import static br.com.contmatic.model.constants.numericas.AmbienteTrabalhoConstants.TAMANHO_MAX_DESCRICAO;
import static br.com.contmatic.model.constants.numericas.AmbienteTrabalhoConstants.TAMANHO_MAX_LISTA_ENDERECOS;
import static br.com.contmatic.model.constants.numericas.AmbienteTrabalhoConstants.TAMANHO_MAX_LISTA_SETORES;
import static br.com.contmatic.model.constants.numericas.AmbienteTrabalhoConstants.TAMANHO_MAX_NOME;
import static br.com.contmatic.model.constants.numericas.AmbienteTrabalhoConstants.TAMANHO_MIN_DESCRICAO;
import static br.com.contmatic.model.constants.numericas.AmbienteTrabalhoConstants.TAMANHO_MIN_NOME;

public final class AmbienteTrabalhoMessage {

	private AmbienteTrabalhoMessage() {
	}
	
	public static final String MESSAGE_NOME_NOTNULL = "O nome do ambiente não pode ser nulo";
	public static final String MESSAGE_NOME_NOTBLANK = "O nome do ambiente não pode ser vazio";
	public static final String MESSAGE_NOME_REGEX = "O nome do ambiente aceita apenas letras";
	public static final String MESSAGE_TAMANHO_MAX_NOME = String.format("O nome do ambiente não pode conter mais que %s caracteres.", TAMANHO_MAX_NOME);
	public static final String MESSAGE_TAMANHO_MIN_NOME = String.format("O nome do ambiente não pode conter menos que %s caracteres.", TAMANHO_MIN_NOME);
	
	public static final String MESSAGE_DESCRICAO_NOTNULL = "A descricao não pode ser nulo";
	public static final String MESSAGE_DESCRICAO_NOTBLANK = "A descricao do ambiente não pode ser vazio";
	public static final String MESSAGE_TAMANHO_MAX_DESCRICAO = String.format("A descricao do ambiente não pode conter mais que %s caracteres", TAMANHO_MAX_DESCRICAO);
	public static final String MESSAGE_TAMANHO_MIN_DESCRICAO = String.format("A descricao do ambiente não pode conter menos que %s caracteres", TAMANHO_MIN_DESCRICAO);
	
	public static final String MESSAGE_TIPO_NOTNULL = "O tipo do ambiente não pode ser nulo";
	
	public static final String MESSAGE_SETORES_NOT_NULL = "A lista de setores não pode ser nulo";
	public static final String MESSAGE_SETORES_IS_EMPTY = "A lista de setores não pode ser vazia";
	public static final String MESSAGE_SETORES_LIST_MAX = String.format("A lista de setores não pode ser maior que %s", TAMANHO_MAX_LISTA_SETORES);
	
	public static final String MESSAGE_ENDERECOS_NOT_NULL = "A lista de enderecos não pode ser nulo";
	public static final String MESSAGE_ENDERECOS_IS_EMPTY = "A lista de enderecos não pode ser vazia";
	public static final String MESSAGE_ENDERECOS_LIST_MAX = String.format("A lista de enderecos não pode ser maior que %s", TAMANHO_MAX_LISTA_ENDERECOS);
	
	public static final String MESSAGE_EMPRESA_NOT_NULL = "A empresa não pode ser nula";

}
