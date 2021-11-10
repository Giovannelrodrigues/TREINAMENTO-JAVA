package br.com.contmatic.model;

import static br.com.contmatic.util.validacoes.Validador.validarAtributoGenerico;
import static br.com.contmatic.util.validacoes.Validador.validarAtributoGenericoAceitandoNulo;
import static br.com.contmatic.util.validacoes.Validador.validarCEP;
import static br.com.contmatic.util.validacoes.Validador.validarSeNumeroZero;

import java.util.Objects;

public class Endereco {
	
	private String cep;
	
	private String logradouro;
	
	private String complemento;
	
	private Integer numero;
	
	private String bairro;
	
	private String estado;
	
	private String cidade;
	
	
	public Endereco(String cep, String logradouro, String complemento, int numero, String bairro, String estado,  String cidade) {
		this.setCep(cep);
		this.setLogradouro(logradouro);
		this.setNumero(numero);
		this.setBairro(bairro);
		this.setEstado(estado);
		this.setCidade(cidade);
		this.setComplemento(complemento);
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		validarCEP(cep);
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		validarAtributoGenerico(logradouro);
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		validarAtributoGenericoAceitandoNulo(complemento);
		this.complemento = complemento;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		validarSeNumeroZero(numero);
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		validarAtributoGenerico(bairro);
		this.bairro = bairro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		validarAtributoGenerico(estado);
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		validarAtributoGenerico(cidade);
		this.cidade = cidade;
	}
	
	@Override
	public String toString() {
		return "Endereco [cep=" + cep + ", logradouro=" + logradouro + ", complemento=" + complemento + ", numero="
				+ numero + ", bairro=" + bairro + ", estado=" + estado + ", cidade=" + cidade + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(bairro, cep, cidade, estado, logradouro, numero);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(obj, other);
	}
	
}
