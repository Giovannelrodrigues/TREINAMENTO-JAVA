package br.com.contmatic.model.constants.regex;

public final class AuditRegex {
	
	private AuditRegex() {}

	public static final String REGEX_IP = "^((1?\\d{1,2}|2([0-4]\\d|5[0-5]))\\.){3}(1?\\d{1,2}|2([0-4]\\d|5[0-5]))$|^$";
}
