package br.com.contmatic.model.constants.messages;

import static br.com.contmatic.model.constants.ProdutoConstants.PRECO_MAX;
import static br.com.contmatic.model.constants.ProdutoConstants.QUANTIDADE_MAX;
import static br.com.contmatic.model.constants.ProdutoConstants.TAMANHO_MAX_CODIGO;
import static br.com.contmatic.model.constants.ProdutoConstants.TAMANHO_MAX_COR;
import static br.com.contmatic.model.constants.ProdutoConstants.TAMANHO_MAX_MARCA;
import static br.com.contmatic.model.constants.ProdutoConstants.TAMANHO_MAX_NOME;
import static br.com.contmatic.model.constants.ProdutoConstants.TAMANHO_MIN_CODIGO;
import static br.com.contmatic.model.constants.ProdutoConstants.TAMANHO_MIN_COR;
import static br.com.contmatic.model.constants.ProdutoConstants.TAMANHO_MIN_MARCA;
import static br.com.contmatic.model.constants.ProdutoConstants.TAMANHO_MIN_NOME;

public final class ProdutoMessage {

	private ProdutoMessage() {
	}
	
	public static final String MESSAGE_CODIGO_NOT_NULL = "O codigo não pode ser nulo";
	public static final String MESSAGE_CODIGO_NOT_BLANK = "O codigo não pode ser vazio";
	public static final String MESSAGE_TAMANHO_CODIGO_MAX = "O codigo não pode conter mais de " + TAMANHO_MAX_CODIGO + " caracteres";
	public static final String MESSAGE_TAMANHO_CODIGO_MIN = "O codigo não pode conter menos de " + TAMANHO_MIN_CODIGO+ " caracteres";

	public static final String MESSAGE_NOME_NOT_NULL = "O nome não pode ser nulo";
	public static final String MESSAGE_NOME_NOT_BLANK = "O nome não pode ser vazio";
	public static final String MESSAGE_TAMANHO_NOME_MAX = "O nome não pode conter mais de " + TAMANHO_MAX_NOME + " caracteres";
	public static final String MESSAGE_TAMANHO_NOME_MIN = "O nome não pode conter menos de " + TAMANHO_MIN_NOME+ " caracteres";
	public static final String MESSAGE_NOME_REGEX = "O nome aceita apenas texto alfanumerico";
	
	public static final String MESSAGE_MARCA_NOT_NULL = "A marca não pode ser nulo";
	public static final String MESSAGE_MARCA_NOT_BLANK = "A marca não pode ser vazio";
	public static final String MESSAGE_TAMANHO_MARCA_MAX = "A marca não pode conter mais de " + TAMANHO_MAX_MARCA + " caracteres";
	public static final String MESSAGE_TAMANHO_MARCA_MIN = "A marca não pode conter menos de " + TAMANHO_MIN_MARCA+ " caracteres";
	
	public static final String MESSAGE_COR_NOT_NULL = "A cor não pode ser nulo";
	public static final String MESSAGE_COR_NOT_BLANK = "A cor não pode ser vazio";
	public static final String MESSAGE_TAMANHO_COR_MAX = "A cor não pode conter mais de " + TAMANHO_MAX_COR + " caracteres";
	public static final String MESSAGE_TAMANHO_COR_MIN = "A cor não pode conter menos de " + TAMANHO_MIN_COR+ " caracteres";
	public static final String MESSAGE_COR_REGEX = "A cor aceita apenas letras";
	
	public static final String MESSAGE_QUANTIDADE_NOT_NULL = "A quantidade não pode ser nulo";
	public static final String MESSAGE_QUANTIDADE_ZERO = "A quantidade não pode ser 0";
	public static final String MESSAGE_QUANTIDADE_MAX = "A quantidade não pode ser maior que " + QUANTIDADE_MAX;
	
	public static final String MESSAGE_PRECO_NOT_NULL = "A preco não pode ser nulo";
	public static final String MESSAGE_PRECO_ZERO = "A preco não pode ser 0";
	public static final String MESSAGE_PRECO_MAX = "A preco não pode ser maior que " + PRECO_MAX;
	
	public static final String MESSAGE_EMPRESA_NOT_NULL = "A empresa não pode ser nula";
}
	
