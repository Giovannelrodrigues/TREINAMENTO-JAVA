package br.com.contmatic.model.empresa;

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
import static br.com.contmatic.model.constants.messages.ProdutoMessage.MESSAGE_CODIGO_NOT_BLANK;
import static br.com.contmatic.model.constants.messages.ProdutoMessage.MESSAGE_CODIGO_NOT_NULL;
import static br.com.contmatic.model.constants.messages.ProdutoMessage.MESSAGE_COR_NOT_BLANK;
import static br.com.contmatic.model.constants.messages.ProdutoMessage.MESSAGE_COR_NOT_NULL;
import static br.com.contmatic.model.constants.messages.ProdutoMessage.MESSAGE_COR_REGEX;
import static br.com.contmatic.model.constants.messages.ProdutoMessage.MESSAGE_EMPRESA_NOT_NULL;
import static br.com.contmatic.model.constants.messages.ProdutoMessage.MESSAGE_MARCA_NOT_BLANK;
import static br.com.contmatic.model.constants.messages.ProdutoMessage.MESSAGE_MARCA_NOT_NULL;
import static br.com.contmatic.model.constants.messages.ProdutoMessage.MESSAGE_NOME_NOT_NULL;
import static br.com.contmatic.model.constants.messages.ProdutoMessage.MESSAGE_NOME_REGEX;
import static br.com.contmatic.model.constants.messages.ProdutoMessage.MESSAGE_PRECO_MAX;
import static br.com.contmatic.model.constants.messages.ProdutoMessage.MESSAGE_PRECO_NOT_NULL;
import static br.com.contmatic.model.constants.messages.ProdutoMessage.MESSAGE_PRECO_ZERO;
import static br.com.contmatic.model.constants.messages.ProdutoMessage.MESSAGE_QUANTIDADE_MAX;
import static br.com.contmatic.model.constants.messages.ProdutoMessage.MESSAGE_QUANTIDADE_NOT_NULL;
import static br.com.contmatic.model.constants.messages.ProdutoMessage.MESSAGE_QUANTIDADE_ZERO;
import static br.com.contmatic.model.constants.messages.ProdutoMessage.MESSAGE_TAMANHO_CODIGO_MAX;
import static br.com.contmatic.model.constants.messages.ProdutoMessage.MESSAGE_TAMANHO_CODIGO_MIN;
import static br.com.contmatic.model.constants.messages.ProdutoMessage.MESSAGE_TAMANHO_COR_MAX;
import static br.com.contmatic.model.constants.messages.ProdutoMessage.MESSAGE_TAMANHO_COR_MIN;
import static br.com.contmatic.model.constants.messages.ProdutoMessage.MESSAGE_TAMANHO_MARCA_MAX;
import static br.com.contmatic.model.constants.messages.ProdutoMessage.MESSAGE_TAMANHO_MARCA_MIN;
import static br.com.contmatic.model.constants.messages.ProdutoMessage.MESSAGE_TAMANHO_NOME_MAX;
import static br.com.contmatic.model.constants.messages.ProdutoMessage.MESSAGE_TAMANHO_NOME_MIN;
import static br.com.contmatic.model.constants.regex.BaseRegex.ALFANUMERICO;
import static br.com.contmatic.model.constants.regex.BaseRegex.SOMENTE_LETRAS;
import static br.com.contmatic.model.validacoes.Validador.validarNulo;
import static br.com.contmatic.model.validacoes.Validador.validarNumeroMaximo;
import static br.com.contmatic.model.validacoes.Validador.validarRegex;
import static br.com.contmatic.model.validacoes.Validador.validarTamanhoMaximo;
import static br.com.contmatic.model.validacoes.Validador.validarTamanhoMinimo;
import static br.com.contmatic.model.validacoes.Validador.validarVazio;
import static br.com.contmatic.model.validacoes.Validador.validarZero;

import java.util.Objects;

import br.com.contmatic.model.commons.Audit;

public class Produto extends Audit {

	private String codigo;

	private String nome;

	private String marca;

	private String cor;

	private Double preco;

	private Integer quantidade;

	private Empresa empresa;

	public Produto(String codigo, Empresa empresa) {
		this.setCodigo(codigo);
		this.setEmpresa(empresa);
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		validarNulo(codigo, MESSAGE_CODIGO_NOT_NULL);
		validarVazio(codigo, MESSAGE_CODIGO_NOT_BLANK);
		validarTamanhoMaximo(codigo, TAMANHO_MAX_CODIGO, MESSAGE_TAMANHO_CODIGO_MAX);
		validarTamanhoMinimo(codigo, TAMANHO_MIN_CODIGO, MESSAGE_TAMANHO_CODIGO_MIN);
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		validarNulo(nome, MESSAGE_NOME_NOT_NULL);
		validarVazio(nome, MESSAGE_CODIGO_NOT_BLANK);
		validarTamanhoMaximo(nome, TAMANHO_MAX_NOME, MESSAGE_TAMANHO_NOME_MAX);
		validarTamanhoMinimo(nome, TAMANHO_MIN_NOME, MESSAGE_TAMANHO_NOME_MIN);
		validarRegex(nome, ALFANUMERICO, MESSAGE_NOME_REGEX);
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		validarNulo(marca, MESSAGE_MARCA_NOT_NULL);
		validarVazio(marca, MESSAGE_MARCA_NOT_BLANK);
		validarTamanhoMaximo(marca, TAMANHO_MAX_MARCA, MESSAGE_TAMANHO_MARCA_MAX);
		validarTamanhoMinimo(marca, TAMANHO_MIN_MARCA, MESSAGE_TAMANHO_MARCA_MIN);
		this.marca = marca;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		validarNulo(cor, MESSAGE_COR_NOT_NULL);
		validarVazio(cor, MESSAGE_COR_NOT_BLANK);
		validarTamanhoMaximo(cor, TAMANHO_MAX_COR, MESSAGE_TAMANHO_COR_MAX);
		validarTamanhoMinimo(cor, TAMANHO_MIN_COR, MESSAGE_TAMANHO_COR_MIN);
		validarRegex(cor, SOMENTE_LETRAS, MESSAGE_COR_REGEX);
		this.cor = cor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		validarNulo(quantidade, MESSAGE_QUANTIDADE_NOT_NULL);
		validarZero(quantidade, MESSAGE_QUANTIDADE_ZERO);
		validarNumeroMaximo(quantidade, QUANTIDADE_MAX, MESSAGE_QUANTIDADE_MAX);
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		validarNulo(preco, MESSAGE_PRECO_NOT_NULL);
		validarZero(preco, MESSAGE_PRECO_ZERO);
		validarNumeroMaximo(preco, PRECO_MAX, MESSAGE_PRECO_MAX);
		this.preco = preco;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		validarNulo(empresa, MESSAGE_EMPRESA_NOT_NULL);
		this.empresa = empresa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(codigo, other.codigo);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Produto [codigo=");
		builder.append(codigo);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", marca=");
		builder.append(marca);
		builder.append(", cor=");
		builder.append(cor);
		builder.append(", preco=");
		builder.append(preco);
		builder.append(", quantidade=");
		builder.append(quantidade);
		builder.append(", empresa=");
		builder.append(empresa);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
}
