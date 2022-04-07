package br.com.contmatic.model.constants.mensagens;

public final class AuditMessage {

	private AuditMessage() {
	}
	
	public static final String MESSAGE_CREATED_BY_NOT_NULL = "O campo createdBy não pode ser nulo";
	
	public static final String MESSAGE_CREATED_DATE_NOT_NULL = "O campo createdDate não pode ser nulo";

	public static final String MESSAGE_UPDATED_BY_NOT_NULL = "O campo updatedBy não pode ser nulo";
	
	public static final String MESSAGE_UPDATED_DATE_NOT_NULL = "O campo updatedDate não pode ser nulo";
	
	public static final String MESSAGE_UPDATED_IP_NOT_NULL = "O campo updatedIp não pode ser nulo";
	
	public static final String MESSAGE_CREATED_IP_NOT_NULL = "O campo createdIp não pode ser nulo";
	
	public static final String MESSAGE_UPDATED_IP_NOT_BLANK = "O campo updatedIp não pode ser vazio";
	
	public static final String MESSAGE_CREATED_IP_NOT_BLANK = "O campo createdIp não pode ser vazio";
	
	public static final String MESSAGE_REGEX_IP = "Ip inválido, precisa ser formatado e com valores de ate 255 entre pontos";
}
