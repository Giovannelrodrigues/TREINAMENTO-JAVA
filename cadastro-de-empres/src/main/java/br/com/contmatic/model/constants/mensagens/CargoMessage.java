package br.com.contmatic.model.constants.mensagens;

import static br.com.contmatic.model.constants.numericas.CargoConstants.TAMANHO_MAX_DESCRICAO;
import static br.com.contmatic.model.constants.numericas.CargoConstants.TAMANHO_MAX_NOME;
import static br.com.contmatic.model.constants.numericas.CargoConstants.TAMANHO_MIN_DESCRICAO;
import static br.com.contmatic.model.constants.numericas.CargoConstants.TAMANHO_MIN_NOME;

public final class CargoMessage {

	private CargoMessage() {
	}
	
	public static final String MESSAGE_NOME_NOTNULL = "O nome do cargo não pode ser nulo";
	public static final String MESSAGE_NOME_NOTBLANK = "O nome do cargo não pode ser vazio";
	public static final String MESSAGE_TAMANHO_MAX_NOME = String.format("O nome do cargo não pode conter mais que %s caracteres", TAMANHO_MAX_NOME);
	public static final String MESSAGE_TAMANHO_MIN_NOME = String.format("O nome do cargo não pode conter menos que %s caracteres", TAMANHO_MIN_NOME);
	public static final String MESSAGE_NOME_REGEX = "O nome do cargo aceita apenas letras";

	public static final String MESSAGE_DESCRICAO_NOTNULL = "A descrição do cargo não pode ser nulo";
	public static final String MESSAGE_DESCRICAO_NOTBLANK = "A descrição do cargo não pode ser vazio";
	public static final String MESSAGE_TAMANHO_MAX_DESCRICAO = String.format("A descrição do cargo não pode conter mais que %s caracteres", TAMANHO_MAX_DESCRICAO);
	public static final String MESSAGE_TAMANHO_MIN_DESCRICAO = String.format("A descrição do cargo não pode conter menos que %s caracteres", TAMANHO_MIN_DESCRICAO);

	public static final String MESSAGE_AMBIENTE_TRABALHO_NOTNULL = "O ambiente de trabalho não pode ser nulo";
}
