package br.com.contmatic.model.constants.mensagens;

import static br.com.contmatic.model.constants.numericas.EmailConstants.TAMANHO_MAX_EMAIL;
import static br.com.contmatic.model.constants.numericas.EmailConstants.TAMANHO_MIN_EMAIL;

public final class EmailMessage {

	private EmailMessage() {
	}
	
	public static final String MESSAGE_EMAIL_NOT_NULL = "O email não pode ser nulo";
	public static final String MESSAGE_EMAIL_NOT_BLANK = "O email não pode ser vazio";
	public static final String MESSAGE_TAMANHO_EMAIL_MAX = String.format("O email não pode conter mais de %s caracteres", TAMANHO_MAX_EMAIL);
	public static final String MESSAGE_TAMANHO_EMAIL_MIN = String.format("O email não pode conter menos de %s caracteres", TAMANHO_MIN_EMAIL);
	public static final String MESSAGE_REGEX_EMAIL = "Email inválido";

	public static final String MESSAGE_TIPO_NOT_NULL = "O tipo do email não pode ser nulo";
}
