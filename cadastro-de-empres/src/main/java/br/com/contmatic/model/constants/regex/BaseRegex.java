package br.com.contmatic.model.constants.regex;

public final class BaseRegex {
	
	private BaseRegex() {}
	
	public static final String SOMENTE_NUMEROS = "([0-9]*)";
	
	public static final String SOMENTE_LETRAS = "([a-zA-ZÁ-Úá-ú ]*)";
	
	public static final String ALFANUMERICO = "([a-zA-ZÁ-Úá-ú0-9 ]*)";
	
	public static final String ALFANUMERICO_PONTOS = "([a-zA-Z0-9á-úÁ-Ú,. ]*)";
}
