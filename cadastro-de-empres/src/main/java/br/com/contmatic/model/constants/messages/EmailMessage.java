package br.com.contmatic.model.constants.messages;

import static br.com.contmatic.model.constants.EmailConstants.CARACTERE_OBRIGATORIO_EMAIL;
import static br.com.contmatic.model.constants.EmailConstants.TAMANHO_MAX_EMAIL;
import static br.com.contmatic.model.constants.EmailConstants.TAMANHO_MIN_EMAIL;

public final class EmailMessage {

	private EmailMessage() {
	}
	
	public static final String MESSAGE_EMAIL_NOT_NULL = "O email não pode ser nulo";
	public static final String MESSAGE_EMAIL_NOT_BLANK = "O email não pode ser vazio";
	public static final String MESSAGE_TAMANHO_EMAIL_MAX = "O email não pode conter mais de " + TAMANHO_MAX_EMAIL + " caracteres";
	public static final String MESSAGE_TAMANHO_EMAIL_MIN = "O email não pode conter menos de " + TAMANHO_MIN_EMAIL + " caracteres";
	public static final String MESSAGE_CARACTERE_OBRIGATORIO = "O email deve conter " + CARACTERE_OBRIGATORIO_EMAIL;
	
}
