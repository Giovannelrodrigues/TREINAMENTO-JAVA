package br.com.contmatic.model.constants.messages;

import static br.com.contmatic.model.constants.UsuarioConstants.TAMANHO_MAX_SENHA;
import static br.com.contmatic.model.constants.UsuarioConstants.TAMANHO_MIN_SENHA;

public final class UsuarioMessage {

	private UsuarioMessage() {
	}
	
	public static final String MESSAGE_EMAIL_NOTNULL = "O email não pode ser nulo";
	
	public static final String MESSAGE_SENHA_NOTNULL = "A senha não pode ser nulo";
	public static final String MESSAGE_SENHA_NOTBLANK = "A senha não pode ser vazio";
	public static final String MESSAGE_TAMANHO_MAX_SENHA = "A senha não pode conter mais que " + TAMANHO_MAX_SENHA + " caracteres";
	public static final String MESSAGE_TAMANHO_MIN_SENHA = "A senha não pode conter menos que " + TAMANHO_MIN_SENHA + " caracteres";
	public static final String MENSAGEM_SENHA_FRACA = "A senha deve conter caracteres minusculos, maiusculos e numeros";

}
