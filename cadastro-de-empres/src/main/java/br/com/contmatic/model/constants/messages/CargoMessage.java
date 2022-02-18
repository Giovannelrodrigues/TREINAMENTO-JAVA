package br.com.contmatic.model.constants.messages;

import static br.com.contmatic.model.constants.CargoConstants.TAMANHO_MAX_DESCRICAO;
import static br.com.contmatic.model.constants.CargoConstants.TAMANHO_MAX_NOME;
import static br.com.contmatic.model.constants.CargoConstants.TAMANHO_MIN_DESCRICAO;
import static br.com.contmatic.model.constants.CargoConstants.TAMANHO_MIN_NOME;

public final class CargoMessage {

	private CargoMessage() {
	}
	
	public static final String MESSAGE_NOME_NOTNULL = "O nome do cargo não pode ser nulo";
	public static final String MESSAGE_NOME_NOTBLANK = "O nome do cargo não pode ser vazio";
	public static final String MESSAGE_TAMANHO_MAX_NOME = "O nome do cargo não pode conter mais que " + TAMANHO_MAX_NOME + " caracteres";
	public static final String MESSAGE_TAMANHO_MIN_NOME = "O nome do cargo não pode conter menos que " + TAMANHO_MIN_NOME + " caracteres";
	public static final String MESSAGE_NOME_REGEX = "O nome do cargo aceita apenas letras";

	public static final String MESSAGE_DESCRICAO_NOTNULL = "A descrição do cargo não pode ser nulo";
	public static final String MESSAGE_DESCRICAO_NOTBLANK = "A descrição do cargo não pode ser vazio";
	public static final String MESSAGE_TAMANHO_MAX_DESCRICAO = "A descrição do cargo não pode conter mais que " + TAMANHO_MAX_DESCRICAO + " caracteres";
	public static final String MESSAGE_TAMANHO_MIN_DESCRICAO = "A descrição do cargo não pode conter menos que " + TAMANHO_MIN_DESCRICAO + " caracteres";
}
