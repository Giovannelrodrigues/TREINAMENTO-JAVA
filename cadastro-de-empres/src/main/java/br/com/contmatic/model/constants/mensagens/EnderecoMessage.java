package br.com.contmatic.model.constants.mensagens;

import static br.com.contmatic.model.constants.numericas.EnderecoConstants.NUMERO_MAX;
import static br.com.contmatic.model.constants.numericas.EnderecoConstants.TAMANHO_MAX_BAIRRO;
import static br.com.contmatic.model.constants.numericas.EnderecoConstants.TAMANHO_MAX_COMPLEMENTO;
import static br.com.contmatic.model.constants.numericas.EnderecoConstants.TAMANHO_MAX_LOGRADOURO;
import static br.com.contmatic.model.constants.numericas.EnderecoConstants.TAMANHO_MIN_BAIRRO;
import static br.com.contmatic.model.constants.numericas.EnderecoConstants.TAMANHO_MIN_COMPLEMENTO;
import static br.com.contmatic.model.constants.numericas.EnderecoConstants.TAMANHO_MIN_LOGRADOURO;

public final class EnderecoMessage {

	private EnderecoMessage() {
	}
	
	public static final String MESSAGE_CEP_NOT_NULL = "O cep não pode ser nulo";
	public static final String MESSAGE_CEP_NOT_BLANK = "O cep não pode ser vazio";
	public static final String MESSAGE_CEP_SOMENTE_NUMEROS= "O cep aceita apenas numeros";
	
	public static final String MESSAGE_LOGRADOURO_NOT_NULL = "O logradouro não pode ser nulo";
	public static final String MESSAGE_LOGRADOURO_NOT_BLANK = "O logradouro não pode ser vazio";
	public static final String MESSAGE_TAMANHO_MAX_LOGRADOURO = String.format("O logradouro não pode conter mais que %s caracteres", TAMANHO_MAX_LOGRADOURO);
	public static final String MESSAGE_TAMANHO_MIN_LOGRADOURO = String.format("O logradouro não pode conter menos que %s caracteres", TAMANHO_MIN_LOGRADOURO);
	public static final String MESSAGE_LOGRADOURO_REGEX = "O logradouro aceitas apenas texto alfanumérico e ponto e virgula";
	
	public static final String MESSAGE_COMPLEMENTO_NOT_NULL = "O logradouro não pode ser nulo";
	public static final String MESSAGE_COMPLEMENTO_NOT_BLANK = "O logradouro não pode ser vazio";
	public static final String MESSAGE_TAMANHO_COMPLEMENTO_MAX = String.format("O logradouro não pode conter mais que %s caracteres", TAMANHO_MAX_COMPLEMENTO);
	public static final String MESSAGE_TAMANHO_COMPLEMENTO_MIN= String.format("O logradouro não pode conter menos que %s caracteres", TAMANHO_MIN_COMPLEMENTO);
	public static final String MESSAGE_COMPLEMENTO_REGEX = "O logradouro aceitas apenas texto alfanumérico e ponto e virgula";
	
	public static final String MESSAGE_NUMERO_NOT_NULL = "O número não pode ser nulo";
	public static final String MESSAGE_NUMERO_NOT_ZERO = "O número não pode ser 0";
	public static final String MESSAGE_NUMERO_MAX = String.format("O número não pode ser maior que %s", NUMERO_MAX);
	
	public static final String MESSAGE_BAIRRO_NOT_NULL = "O bairro não pode ser nulo";
	public static final String MESSAGE_BAIRRO_NOT_BLANK = "O bairro não pode ser vazio";
	public static final String MESSAGE_TAMANHO_BAIRRO_MAX = String.format("O bairro não pode conter mais que %s caracteres", TAMANHO_MAX_BAIRRO);
	public static final String MESSAGE_TAMANHO_BAIRRO_MIN= String.format("O bairro não pode conter menos que %s caracteres", TAMANHO_MIN_BAIRRO);
	public static final String MESSAGE_BAIRRO_REGEX = "O logradouro aceitas apenas letras";
	
	public static final String MESSAGE_CIDADE_NOT_NULL = "O cidade não pode ser nulo";
	
	public static final String MESSAGE_ESTADO_NOT_NULL = "O estado não pode ser nulo";
	
	public static final String MESSAGE_TIPO_ENDERECO_NOT_NULL = "O tipo do endereço não pode ser nulo";
}
