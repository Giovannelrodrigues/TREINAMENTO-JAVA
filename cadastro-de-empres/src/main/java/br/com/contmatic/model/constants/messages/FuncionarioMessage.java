package br.com.contmatic.model.constants.messages;

import static br.com.contmatic.model.constants.FuncionarioConstants.TAMANHO_CPF;
import static br.com.contmatic.model.constants.FuncionarioConstants.TAMANHO_DATA_NASCIMENTO;
import static br.com.contmatic.model.constants.FuncionarioConstants.TAMANHO_MAX_LISTA_EMAILS;
import static br.com.contmatic.model.constants.FuncionarioConstants.TAMANHO_MAX_LISTA_TELEFONES;
import static br.com.contmatic.model.constants.FuncionarioConstants.TAMANHO_MAX_NOME;
import static br.com.contmatic.model.constants.FuncionarioConstants.TAMANHO_MIN_NOME;

public final class FuncionarioMessage {

	private FuncionarioMessage() {
	}
	
	public static final String MESSAGE_CPF_NOTNULL = "O cpf não pode ser nulo";
	public static final String MESSAGE_CPF_NOTBLANK = "O cpf não pode ser vazio";
	public static final String MESSAGE_TAMANHO_CPF = "O cpf deve conter " + TAMANHO_CPF + " numeros";
	public static final String MESSAGE_CPF_REGEX = "O cpf aceita apenas números";
	public static final String MENSAGEM_CPF_CARACTERES_REPETIDOS = "O cpf não pode ter todos caracteres repetidos";
	
	public static final String MESSAGE_NOME_NOTNULL = "O nome não pode ser nulo";
	public static final String MESSAGE_NOME_NOTBLANK = "O nome não pode ser vazio";
	public static final String MESSAGE_TAMANHO_MAX_NOME = "O nome não pode conter mais que " + TAMANHO_MAX_NOME + " caracteres";
	public static final String MESSAGE_TAMANHO_MIN_NOME = "O nome não pode conter menos que " + TAMANHO_MIN_NOME + " caracteres";
	public static final String MESSAGE_NOME_REGEX = "O nome aceita apenas letras";
	
	public static final String MESSAGE_ENDERECO_NOTNULL = "O endereço não pode ser nulo";
	
	public static final String MESSAGE_TELEFONES_NOT_NULL = "A lista de telefones não pode ser nulo";
	public static final String MESSAGE_TELEFONES_IS_EMPTY = "A lista de telefones não pode ser vazia";
	public static final String MESSAGE_TELEFONES_LIST_MAX = "A lista de telefones não pode ser maior que " + TAMANHO_MAX_LISTA_TELEFONES;
	
	public static final String MESSAGE_EMAILS_NOT_NULL = "A lista de emails não pode ser nulo";
	public static final String MESSAGE_EMAILS_IS_EMPTY = "A lista de emails não pode ser vazia";
	public static final String MESSAGE_EMAILS_LIST_MAX = "A lista de emails não pode ser maior que " + TAMANHO_MAX_LISTA_EMAILS;

	public static final String MESSAGE_CARGO_NOTNULL = "O cargo não pode ser nulo";
	
	public static final String MESSAGE_SETOR_NOTNULL = "O setor não pode ser nulo";
	
	public static final String MESSAGE_DATA_NASCIMENTO_NOTNULL = "A data de nascimento não pode ser nulo";
	public static final String MESSAGE_DATA_NASCIMENTO_NOTBLANK = "A data de nascimento não pode ser vazio";
	public static final String MESSAGE_TAMANHO_DATA_NASCIMENTO = "A data de nascimento deve conter " + TAMANHO_DATA_NASCIMENTO + " numeros";
	public static final String MESSAGE_DATA_NASCIMENTO_REGEX = "A data de nascimento aceita apenas numeros";
}