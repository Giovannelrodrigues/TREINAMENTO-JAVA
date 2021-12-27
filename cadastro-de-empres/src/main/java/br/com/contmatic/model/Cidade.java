package br.com.contmatic.model;

import static br.com.contmatic.util.constants.Constants.CODIGO_MAX_IBGE;
import static br.com.contmatic.util.constants.Constants.REGEX_SOMENTE_LETRAS;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MAX_CIDADE_ENDERECO;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MIN_CIDADE_ENDERECO;
import static br.com.contmatic.util.constants.Message.MENSAGEM_ERRO_REGEX_SOMENTE_LETRAS;
import static br.com.contmatic.util.validacoes.Validador.validarNulo;
import static br.com.contmatic.util.validacoes.Validador.validarNumeroMaximo;
import static br.com.contmatic.util.validacoes.Validador.validarRegex;
import static br.com.contmatic.util.validacoes.Validador.validarTamanhoMaximo;
import static br.com.contmatic.util.validacoes.Validador.validarTamanhoMinimo;
import static br.com.contmatic.util.validacoes.Validador.validarVazio;
import static br.com.contmatic.util.validacoes.Validador.validarZero;

import java.util.Objects;

public class Cidade {

	private Integer codigoIBGE;

	private String nome;

	private Estado estado;

	public Cidade(String nome, Integer codigoIBGE, Estado estado) {
		this.setNome(nome);
		this.setCodigoIBGE(codigoIBGE);
		this.setEstado(estado);
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		validarNulo(estado);
		validarVazio(estado);
		this.estado = estado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		validarNulo(nome);
		validarVazio(nome);
		validarTamanhoMaximo(nome, TAMANHO_MAX_CIDADE_ENDERECO);
		validarTamanhoMinimo(nome, TAMANHO_MIN_CIDADE_ENDERECO);
		validarRegex(nome, REGEX_SOMENTE_LETRAS, MENSAGEM_ERRO_REGEX_SOMENTE_LETRAS);
		this.nome = nome;
	}

	public Integer getCodigoIBGE() {
		return codigoIBGE;
	}

	public void setCodigoIBGE(Integer codigoIBGE) {
		validarNulo(codigoIBGE);
		validarVazio(codigoIBGE);
		validarZero(codigoIBGE);
		validarNumeroMaximo(codigoIBGE, CODIGO_MAX_IBGE);
		this.codigoIBGE = codigoIBGE;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoIBGE);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		return Objects.equals(codigoIBGE, other.codigoIBGE);
	}

	@Override
	public String toString() {
		return "Cidade [codigoIBGE=" + codigoIBGE + ", nome=" + nome + ", estado=" + estado + "]";
	}

}
