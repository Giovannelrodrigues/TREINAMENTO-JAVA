package br.com.contmatic.model;

import static br.com.contmatic.util.validacoes.Validador.validarAtributoDescricao;
import static br.com.contmatic.util.validacoes.Validador.validarAtributoGenerico;
import static br.com.contmatic.util.validacoes.Validador.validarObjetoNulo;

import java.util.List;
import java.util.Objects;

public class Setor {
	
	private String nome;
	
	private String descricao;
	
	private List<Funcionario> funcionarios;
	
	public Setor(String nome, String descricao){
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
		return descricao;
	}

	public void setDescricao(String descricao) {
		validarAtributoDescricao(descricao);
		this.descricao = descricao;
	}
	
	public List<Funcionario> getFuncionarios() {
		return this.funcionarios;
	}
	
	public void setFuncionarios(List<Funcionario> funcionario) {
		validarObjetoNulo(funcionario);
		this.funcionarios = funcionario;
	}
	
	@Override
	public String toString() {
		return "Setor [nome=" + nome + ", descricao=" + descricao + ", funcionarios=" + funcionarios + "]";
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
		Setor other = (Setor) obj;
		return Objects.equals(nome, other.nome);
	}
}
