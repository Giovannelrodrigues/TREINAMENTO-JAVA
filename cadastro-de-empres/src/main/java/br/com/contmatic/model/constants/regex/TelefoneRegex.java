package br.com.contmatic.model.constants.regex;

public final class TelefoneRegex {
	
	private TelefoneRegex() {}
	
	public static final String REGEX_DDI = "^(?:\\+)[0-9]{2}";
	
	public static final String REGEX_DDD = "\\d{2}";
}
