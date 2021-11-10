package br.com.contmatic.model;

import static br.com.contmatic.util.validacoes.Validador.validarAtributoDescricao;
import static br.com.contmatic.util.validacoes.Validador.validarAtributoGenerico;

import java.util.Objects;

public class Cargo {
	
	private String nome;
	
	private String descricao;
	
	
	public Cargo(String nome, String descricao) {
		this.setNome(nome);
		this.setDescricao(descricao);
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		validarAtributoGenerico(nome);
		this.nome = nome;
	}

	public String getDescricao() {
		validarAtributoDescricao(descricao);
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return "Cargo [nome=" + nome + ", descricao=" + descricao + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cargo other = (Cargo) obj;
		return Objects.equals(nome, other.nome);
	}
	
}
