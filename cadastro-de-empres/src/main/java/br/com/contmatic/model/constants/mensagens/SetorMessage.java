package br.com.contmatic.model.constants.mensagens;

import static br.com.contmatic.model.constants.numericas.SetorConstants.TAMANHO_MAX_DESCRICAO;
import static br.com.contmatic.model.constants.numericas.SetorConstants.TAMANHO_MAX_LISTA_FUNCIONARIOS;
import static br.com.contmatic.model.constants.numericas.SetorConstants.TAMANHO_MAX_NOME;
import static br.com.contmatic.model.constants.numericas.SetorConstants.TAMANHO_MIN_DESCRICAO;
import static br.com.contmatic.model.constants.numericas.SetorConstants.TAMANHO_MIN_NOME;

public final class SetorMessage {

	private SetorMessage() {
	}
	
	public static final String MESSAGE_NOME_NOTNULL = "O nome do setor não pode ser nulo";
	public static final String MESSAGE_NOME_NOTBLANK = "O nome do setor não pode ser vazio";
	public static final String MESSAGE_TAMANHO_MAX_NOME = String.format("O nome do setor não pode conter mais que %s caracteres", TAMANHO_MAX_NOME);
	public static final String MESSAGE_TAMANHO_MIN_NOME = String.format("O nome do setor não pode conter menos que %s caracteres", TAMANHO_MIN_NOME);
	public static final String MESSAGE_NOME_REGEX = "O nome do setor aceita apenas letras";

	public static final String MESSAGE_DESCRICAO_NOTNULL = "A descrição do setor não pode ser nulo";
	public static final String MESSAGE_DESCRICAO_NOTBLANK = "A descrição do setor não pode ser vazio";
	public static final String MESSAGE_TAMANHO_MAX_DESCRICAO = String.format("A descrição do setor não pode conter mais que %s caracteres", TAMANHO_MAX_DESCRICAO);
	public static final String MESSAGE_TAMANHO_MIN_DESCRICAO = String.format("A descrição do setor não pode conter menos que %s caracteres", TAMANHO_MIN_DESCRICAO);

	public static final String MESSAGE_FUCIONARIOS_NOT_NULL = "A lista de funcionarios não pode ser nulo";
	public static final String MESSAGE_FUCIONARIOS_IS_EMPTY = "A lista de funcionarios não pode ser vazia";
	public static final String MESSAGE_FUCIONARIOS_LIST_MAX = String.format("A lista de funcionarios não pode ser maior que %s", TAMANHO_MAX_LISTA_FUNCIONARIOS);

	public static final String MESSAGE_AMBIENTE_TRABALHO_NOTNULL = "O ambiente de trabalho não pode ser nulo";
}
