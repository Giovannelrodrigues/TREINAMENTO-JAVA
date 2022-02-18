package br.com.contmatic.model.constants.messages;

import static br.com.contmatic.model.constants.CidadeConstants.CODIGO_IBGE_MAX;
import static br.com.contmatic.model.constants.CidadeConstants.TAMANHO_MAX_NOME;
import static br.com.contmatic.model.constants.CidadeConstants.TAMANHO_MIN_NOME;

public final class CidadeMessage {

	private CidadeMessage() {
	}
	
	public static final String MESSAGE_ESTADO_NOTNULL = "O estado não pode ser nulo";
	public static final String MESSAGE_ESTADO_NOTBLANK = "O estado não pode ser vazio";
	
	public static final String MESSAGE_NOME_NOTNULL = "O nome da cidade não pode ser nulo";
	public static final String MESSAGE_NOME_NOTBLANK = "O nome da cidade não pode ser vazio";
	public static final String MESSAGE_REGEX_NOME = "O nome da cidade aceita apenas letras";
	public static final String MESSAGE_TAMANHO_MAX_NOME = "O nome não pode conter mais que " + TAMANHO_MAX_NOME + " caracteres";
	public static final String MESSAGE_TAMANHO_MIN_NOME = "O nome não pode conter menos que " + TAMANHO_MIN_NOME + " caracteres";
	
	public static final String MESSAGE_CODIGO_IBGE_NOTNULL = "O codigo do IBGE não pode ser nulo";
	public static final String MESSAGE_CODIGO_IBGE_NOTBLANK = "O codigo do IBGE não pode ser vazio";
	public static final String MESSAGE_CODIGO_IBGE_ZERO = "O codigo do IBGE não pode ser zero";
	public static final String MESSAGE_CODIGO_IBGE_MAX = "O codigo do IBGE não pode ser maior que " + CODIGO_IBGE_MAX;
}
