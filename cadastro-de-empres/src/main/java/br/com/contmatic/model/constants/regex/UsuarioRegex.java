package br.com.contmatic.model.constants.regex;

public final class UsuarioRegex {
	
	private UsuarioRegex() {};
	
	public static final String REGEX_SENHA = "(?=.*[a-z=])(?=.*[0-9])(?=.*[A-Z]).{8,30}";
}
