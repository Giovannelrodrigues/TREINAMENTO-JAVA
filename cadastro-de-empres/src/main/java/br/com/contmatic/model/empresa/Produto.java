package br.com.contmatic.model.empresa;

import static br.com.contmatic.util.constants.Constants.PRECO_MAX_PRODUTO;
import static br.com.contmatic.util.constants.Constants.QUANTIDADE_MAX_PRODUTO;
import static br.com.contmatic.util.constants.Constants.REGEX_LETRAS_NUMEROS;
import static br.com.contmatic.util.constants.Constants.REGEX_SOMENTE_LETRAS;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MAX_CODIGO_PRODUTO;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MAX_COR_PRODUTO;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MAX_MARCA_PRODUTO;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MAX_NOME_PRODUTO;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MIN_CODIGO_PRODUTO;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MIN_COR_PRODUTO;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MIN_MARCA_PRODUTO;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MIN_NOME_PRODUTO;
import static br.com.contmatic.util.constants.Message.MENSAGEM_ERRO_REGEX_SOMENTE_LETRAS;
import static br.com.contmatic.util.validacoes.Validador.validarNulo;
import static br.com.contmatic.util.validacoes.Validador.validarNumeroMaximo;
import static br.com.contmatic.util.validacoes.Validador.validarRegex;
import static br.com.contmatic.util.validacoes.Validador.validarTamanhoMaximo;
import static br.com.contmatic.util.validacoes.Validador.validarTamanhoMinimo;
import static br.com.contmatic.util.validacoes.Validador.validarVazio;
import static br.com.contmatic.util.validacoes.Validador.validarZero;

import java.util.Objects;

import br.com.contmatic.model.Audit;

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
		validarNulo(codigo);
		validarVazio(codigo);
		validarTamanhoMaximo(codigo, TAMANHO_MAX_CODIGO_PRODUTO);
		validarTamanhoMinimo(codigo, TAMANHO_MIN_CODIGO_PRODUTO);
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		validarNulo(nome);
		validarVazio(nome);
		validarTamanhoMaximo(nome, TAMANHO_MAX_NOME_PRODUTO);
		validarTamanhoMinimo(nome, TAMANHO_MIN_NOME_PRODUTO);
		validarRegex(nome, REGEX_LETRAS_NUMEROS, MENSAGEM_ERRO_REGEX_SOMENTE_LETRAS);
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		validarNulo(marca);
		validarVazio(marca);
		validarTamanhoMaximo(marca, TAMANHO_MAX_MARCA_PRODUTO);
		validarTamanhoMinimo(marca, TAMANHO_MIN_MARCA_PRODUTO);
		this.marca = marca;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		validarNulo(cor);
		validarVazio(cor);
		validarTamanhoMaximo(cor, TAMANHO_MAX_COR_PRODUTO);
		validarTamanhoMinimo(cor, TAMANHO_MIN_COR_PRODUTO);
		validarRegex(cor, REGEX_SOMENTE_LETRAS, MENSAGEM_ERRO_REGEX_SOMENTE_LETRAS);
		this.cor = cor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		validarNulo(quantidade);
		validarZero(quantidade);
		validarNumeroMaximo(quantidade, QUANTIDADE_MAX_PRODUTO);
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		validarNulo(preco);
		validarZero(preco);
		validarNumeroMaximo(preco, PRECO_MAX_PRODUTO);
		this.preco = preco;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		validarNulo(empresa);
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
		return "Produto [codigo=" + codigo + ", nome=" + nome + ", marca=" + marca + ", cor=" + cor + ", preco=" + preco
				+ ", quantidade=" + quantidade + ", empresa=" + empresa + ", audit()=" + super.toString() + "]";
	}
}
