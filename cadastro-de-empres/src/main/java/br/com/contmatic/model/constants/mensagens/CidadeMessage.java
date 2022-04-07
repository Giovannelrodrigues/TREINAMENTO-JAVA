package br.com.contmatic.model.constants.mensagens;

import static br.com.contmatic.model.constants.numericas.CidadeConstants.CODIGO_IBGE_MAX;
import static br.com.contmatic.model.constants.numericas.CidadeConstants.TAMANHO_MAX_NOME;
import static br.com.contmatic.model.constants.numericas.CidadeConstants.TAMANHO_MIN_NOME;

public final class CidadeMessage {

	private CidadeMessage() {
	}
	
	public static final String MESSAGE_ESTADO_NOTNULL = "O estado não pode ser nulo";
	public static final String MESSAGE_ESTADO_NOTBLANK = "O estado não pode ser vazio";
	
	public static final String MESSAGE_NOME_NOTNULL = "O nome da cidade não pode ser nulo";
	public static final String MESSAGE_NOME_NOTBLANK = "O nome da cidade não pode ser vazio";
	public static final String MESSAGE_REGEX_NOME = "O nome da cidade aceita apenas letras";
	public static final String MESSAGE_TAMANHO_MAX_NOME = String.format("O nome não pode conter mais que %s caracteres", TAMANHO_MAX_NOME);
	public static final String MESSAGE_TAMANHO_MIN_NOME = String.format("O nome não pode conter menos que %s caracteres", TAMANHO_MIN_NOME);
	
	public static final String MESSAGE_CODIGO_IBGE_NOTNULL = "O codigo do IBGE não pode ser nulo";
	public static final String MESSAGE_CODIGO_IBGE_NOTBLANK = "O codigo do IBGE não pode ser vazio";
	public static final String MESSAGE_CODIGO_IBGE_ZERO = "O codigo do IBGE não pode ser zero";
	public static final String MESSAGE_CODIGO_IBGE_MAX = String.format("O codigo do IBGE não pode ser maior que %s", CODIGO_IBGE_MAX);
}
