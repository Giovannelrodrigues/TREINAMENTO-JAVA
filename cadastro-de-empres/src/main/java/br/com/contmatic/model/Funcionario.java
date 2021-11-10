package br.com.contmatic.model;

import static br.com.contmatic.util.validacoes.Validador.validarAtributoNome;
import static br.com.contmatic.util.validacoes.Validador.validarObjetoNulo;
import static br.com.contmatic.util.validacoes.ValidadorCPF.validarCPF;

import java.util.Objects;

public class Funcionario {
	
	private String nome;
	
	private String cpf;
	
	private Endereco endereco;
	
	private Contato contato;
	 
	private Cargo cargo;
	
	public Funcionario(String nome, String cpf, Endereco endereco, Contato contato, Cargo cargo) {
		this.setNome(nome);
		this.setCpf(cpf);
		this.setEndereco(endereco);
		this.setCargo(cargo);
		this.setContato(contato);
	
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		validarAtributoNome(nome);
		this.nome = nome;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	public void setCpf(String cpf) {
		validarCPF(cpf);
		this.cpf = cpf;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		validarObjetoNulo(endereco);
		this.endereco = endereco;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		validarObjetoNulo(contato);
		this.contato = contato;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		validarObjetoNulo(cargo);
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", cpf=" + cpf + ", endereco=" + endereco + ", contato=" + contato
				+ ", cargo=" + cargo + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(cpf, other.cpf);
	}

}
