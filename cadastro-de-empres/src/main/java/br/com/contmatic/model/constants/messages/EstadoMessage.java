package br.com.contmatic.model.constants.messages;

import static br.com.contmatic.model.constants.EstadoConstants.TAMANHO_LISTA_MAX_CIDADES;
import static br.com.contmatic.model.constants.EstadoConstants.TAMANHO_MAX_ESTADO;
import static br.com.contmatic.model.constants.EstadoConstants.TAMANHO_MIN_ESTADO;
import static br.com.contmatic.model.constants.EstadoConstants.TAMANHO_SIGLA;

public final class EstadoMessage {

	private EstadoMessage() {
	}
	
	public static final String MESSAGE_NOME_NOT_NULL = "O nome do estado não pode ser nulo";
	public static final String MESSAGE_NOME_NOT_BLANK = "O nome do estado não pode ser vazio";
	public static final String MESSAGE_TAMANHO_NOME_MAX = "O logradouro não pode conter mais que " + TAMANHO_MAX_ESTADO + " caracteres";
	public static final String MESSAGE_TAMANHO_NOME_MIN= "O logradouro não pode conter menos que " + TAMANHO_MIN_ESTADO +" caracteres";
	public static final String MESSAGE_NOME_SOMENTE_LETRAS = "O nome do estado aceita apenas letras";
	
	public static final String MESSAGE_SIGLA_NOT_NULL = "A sigla não pode ser nulo";
	public static final String MESSAGE_SIGLA_NOT_BLANK = "A sigla não pode ser vazio";
	public static final String MESSAGE_TAMANHO_SIGLA = "A sigla deve conter " + TAMANHO_SIGLA + " caracteres";
	public static final String MESSAGE_SIGLA_REGEX = "A sigla aceita apenas letras maiusculas";
	
	public static final String MESSAGE_CIDADES_NOT_NULL = "A lista de cidades não pode ser nulo";
	public static final String MESSAGE_CIDADES_IS_EMPTY = "A lista de cidades não pode ser vazia";
	public static final String MESSAGE_CIDADES_LIST_MAX = "A lista de cidades não pode ser maior que " + TAMANHO_LISTA_MAX_CIDADES;
}
