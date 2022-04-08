package br.com.contmatic.model.constants.mensagens;

public final class TelefoneMessage {

	private TelefoneMessage() {
	}
	
	public static final String MESSAGE_TELEFONE_NOT_NULL = "O telefone não pode ser nulo";
	public static final String MESSAGE_TELEFONE_NOT_BLANK = "O telefone não pode ser vazio";
	public static final String MESSAGE_TELEFONE_SOMENTE_NUMERROS = "O nome do estado aceita apenas numeros";
	
	public static final String MESSAGE_TIPO_TELEFONE_NOT_NULL = "O tipo do telefone não pode ser nulo";
	
	public static final String MESSAGE_DDI_NOT_NULL = "O ddi do telefone não pode ser nulo";
	public static final String MESSAGE_DDI_NOT_BLANK = "O ddi do telefone não pode ser vazio";
	public static final String MESSAGE_DDI_REGEX = "O ddi está inválido";
	
	public static final String MESSAGE_DDD_NOT_NULL = "O ddd do telefone não pode ser nulo";
	public static final String MESSAGE_DDD_NOT_BLANK = "O ddd do telefone não pode ser vazio";
	public static final String MESSAGE_DDD_REGEX = "O ddd está inválido";
}
