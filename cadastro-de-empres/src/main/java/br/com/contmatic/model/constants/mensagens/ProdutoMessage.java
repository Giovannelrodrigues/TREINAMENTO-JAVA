package br.com.contmatic.model.constants.mensagens;

import static br.com.contmatic.model.constants.numericas.ProdutoConstants.PRECO_MAX;
import static br.com.contmatic.model.constants.numericas.ProdutoConstants.QUANTIDADE_MAX;
import static br.com.contmatic.model.constants.numericas.ProdutoConstants.TAMANHO_MAX_CODIGO;
import static br.com.contmatic.model.constants.numericas.ProdutoConstants.TAMANHO_MAX_COR;
import static br.com.contmatic.model.constants.numericas.ProdutoConstants.TAMANHO_MAX_MARCA;
import static br.com.contmatic.model.constants.numericas.ProdutoConstants.TAMANHO_MAX_NOME;
import static br.com.contmatic.model.constants.numericas.ProdutoConstants.TAMANHO_MIN_CODIGO;
import static br.com.contmatic.model.constants.numericas.ProdutoConstants.TAMANHO_MIN_COR;
import static br.com.contmatic.model.constants.numericas.ProdutoConstants.TAMANHO_MIN_MARCA;
import static br.com.contmatic.model.constants.numericas.ProdutoConstants.TAMANHO_MIN_NOME;

public final class ProdutoMessage {

	private ProdutoMessage() {
	}
	
	public static final String MESSAGE_CODIGO_NOT_NULL = "O codigo não pode ser nulo";
	public static final String MESSAGE_CODIGO_NOT_BLANK = "O codigo não pode ser vazio";
	public static final String MESSAGE_TAMANHO_CODIGO_MAX = String.format("O codigo não pode conter mais de %s caracteres", TAMANHO_MAX_CODIGO);
	public static final String MESSAGE_TAMANHO_CODIGO_MIN = String.format("O codigo não pode conter menos de %s caracteres", TAMANHO_MIN_CODIGO);

	public static final String MESSAGE_NOME_NOT_NULL = "O nome não pode ser nulo";
	public static final String MESSAGE_NOME_NOT_BLANK = "O nome não pode ser vazio";
	public static final String MESSAGE_TAMANHO_NOME_MAX = String.format("O nome não pode conter mais de %s caracteres", TAMANHO_MAX_NOME);
	public static final String MESSAGE_TAMANHO_NOME_MIN = String.format("O nome não pode conter menos de %s caracteres", TAMANHO_MIN_NOME);
	public static final String MESSAGE_NOME_REGEX = "O nome aceita apenas texto alfanumerico";
	
	public static final String MESSAGE_MARCA_NOT_NULL = "A marca não pode ser nulo";
	public static final String MESSAGE_MARCA_NOT_BLANK = "A marca não pode ser vazio";
	public static final String MESSAGE_TAMANHO_MARCA_MAX = String.format("A marca não pode conter mais de %s caracteres", TAMANHO_MAX_MARCA);
	public static final String MESSAGE_TAMANHO_MARCA_MIN = String.format("A marca não pode conter menos de %s caracteres", TAMANHO_MIN_MARCA);
	
	public static final String MESSAGE_COR_NOT_NULL = "A cor não pode ser nulo";
	public static final String MESSAGE_COR_NOT_BLANK = "A cor não pode ser vazio";
	public static final String MESSAGE_TAMANHO_COR_MAX = String.format("A cor não pode conter mais de %s caracteres", TAMANHO_MAX_COR);
	public static final String MESSAGE_TAMANHO_COR_MIN = String.format("A cor não pode conter menos de %s caracteres", TAMANHO_MIN_COR);
	public static final String MESSAGE_COR_REGEX = "A cor aceita apenas letras";
	
	public static final String MESSAGE_QUANTIDADE_NOT_NULL = "A quantidade não pode ser nulo";
	public static final String MESSAGE_QUANTIDADE_ZERO = "A quantidade não pode ser 0";
	public static final String MESSAGE_QUANTIDADE_MAX = String.format("A quantidade não pode ser maior que %s", QUANTIDADE_MAX);
	
	public static final String MESSAGE_PRECO_NOT_NULL = "A preco não pode ser nulo";
	public static final String MESSAGE_PRECO_ZERO = "A preco não pode ser 0";
	public static final String MESSAGE_PRECO_MAX = String.format("A preco não pode ser maior que %s", PRECO_MAX);
	
	public static final String MESSAGE_EMPRESA_NOT_NULL = "A empresa não pode ser nula";
}
	
