package br.com.contmatic.model;

import static br.com.contmatic.util.validacoes.Validador.validarAtributoGenerico;
import static br.com.contmatic.util.validacoes.Validador.validarAtributoGenericoAceitandoNulo;
import static br.com.contmatic.util.validacoes.Validador.validarSeNumeroZero;

import java.util.Objects;


public class Produto {
	
	private String codigo;
	
	private String nome;
	
	private String marca;
	
	private String cor;
	
	private Double preco;
	
	private int quantidade;

	public Produto(String codigo, String nome, String marca , Double preco , int quantidade, String cor) {
		this.setCodigo(codigo);
		this.setNome(nome);
		this.setMarca(marca);
		this.setPreco(preco);
		this.setQuantidade(quantidade);
		this.setCor(cor);
	}
	
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		validarAtributoGenerico(codigo);
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		validarAtributoGenerico(nome);
		this.nome = nome;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		validarAtributoGenerico(marca);
		this.marca = marca;
	}
	
	public String getCor() {
		return cor;
	}
	
	public void setCor(String cor) {
		validarAtributoGenericoAceitandoNulo(cor);
		this.cor = cor;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		validarSeNumeroZero(quantidade);
		this.quantidade = quantidade;
	}
	
	public Double getPreco() {
		return preco;
	}
	
	public void setPreco(Double preco) {
		validarSeNumeroZero(preco);
		this.preco = preco;
	}
	
	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", nome=" + nome + ", marca=" + marca + ", cor=" + cor + ", preco=" + preco
				+ ", quantidade=" + quantidade + "]";
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
	
}
