package br.com.contmatic.model;

import static br.com.contmatic.util.validacoes.Validador.validarAtributoGenericoAceitandoNulo;
import static br.com.contmatic.util.validacoes.Validador.validarAtributoNome;
import static br.com.contmatic.util.validacoes.Validador.validarLista;
import static br.com.contmatic.util.validacoes.Validador.validarObjetoNulo;
import static br.com.contmatic.util.validacoes.ValidadorCNPJ.validarCNPJ;

import java.util.List;
import java.util.Objects;

public class Empresa {
	
	private String nomeFantasia;
	
	private String razaoSocial;
	
	private String cnpj;
	
	private Contato contato;
	
	private Endereco endereco;
	
	private List<AmbienteTrabalho> ambientesTrabalhos;
	
	private List<Produto> produtos;
	
	public Empresa(String razaoSocial, String cnpj, String nomeFantasia, Endereco endereco, Contato contato) {
		this.setRazaoSocial(razaoSocial);
		this.setCnpj(cnpj);
		this.setNomeFantasia(nomeFantasia);
		this.setEndereco(endereco);
		this.setContato(contato);
	}
	
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	
	public void setNomeFantasia(String nomeFantasia) {
		validarAtributoGenericoAceitandoNulo(nomeFantasia);
		this.nomeFantasia = nomeFantasia;
	}
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	
	public void setRazaoSocial(String razaoSocial) {
		validarAtributoNome(razaoSocial);
		this.razaoSocial = razaoSocial;
	}
	
	public String getCnpj() {
		return this.cnpj;
	}
	
	public void setCnpj(String cnpj) {
		validarCNPJ(cnpj);
		this.cnpj = cnpj;
	}
	
	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		validarObjetoNulo(contato);
		this.contato = contato;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		validarObjetoNulo(endereco);
		this.endereco = endereco;
	}
	
	public List<AmbienteTrabalho> getAmbientesTrabalhos() {
		return this.ambientesTrabalhos;
	}
	
	public void setAmbientesTrabalhos(List<AmbienteTrabalho> ambientesTrabalhos) {
		validarLista(ambientesTrabalhos);
		this.ambientesTrabalhos = ambientesTrabalhos;
	}

	public List<Produto> getProdutos() {
		return this.produtos;
	}
	
	public void setProdutos(List<Produto> produtos) {
		validarLista(produtos);
		this.produtos = produtos;
	}

	@Override
	public String toString() {
		return "Empresa [nomeFantasia=" + nomeFantasia + ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj
				+ ", contato=" + contato + ", endereco=" + endereco + ", ambientesTrabalhos=" + ambientesTrabalhos
				+ ", produtos=" + produtos + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cnpj);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		return Objects.equals(cnpj, other.cnpj);
	}
	
}
