package br.com.contmatic.model.endereco;

import static br.com.contmatic.model.constants.mensagens.CidadeMessage.MESSAGE_CODIGO_IBGE_MAX;
import static br.com.contmatic.model.constants.mensagens.CidadeMessage.MESSAGE_CODIGO_IBGE_NOTBLANK;
import static br.com.contmatic.model.constants.mensagens.CidadeMessage.MESSAGE_CODIGO_IBGE_NOTNULL;
import static br.com.contmatic.model.constants.mensagens.CidadeMessage.MESSAGE_CODIGO_IBGE_ZERO;
import static br.com.contmatic.model.constants.mensagens.CidadeMessage.MESSAGE_ESTADO_NOTNULL;
import static br.com.contmatic.model.constants.mensagens.CidadeMessage.MESSAGE_NOME_NOTBLANK;
import static br.com.contmatic.model.constants.mensagens.CidadeMessage.MESSAGE_NOME_NOTNULL;
import static br.com.contmatic.model.constants.mensagens.CidadeMessage.MESSAGE_REGEX_NOME;
import static br.com.contmatic.model.constants.mensagens.CidadeMessage.MESSAGE_TAMANHO_MAX_NOME;
import static br.com.contmatic.model.constants.mensagens.CidadeMessage.MESSAGE_TAMANHO_MIN_NOME;
import static br.com.contmatic.model.constants.numericas.CidadeConstants.CODIGO_IBGE_MAX;
import static br.com.contmatic.model.constants.numericas.CidadeConstants.TAMANHO_MAX_NOME;
import static br.com.contmatic.model.constants.numericas.CidadeConstants.TAMANHO_MIN_NOME;
import static br.com.contmatic.model.constants.regex.BaseRegex.SOMENTE_LETRAS;
import static br.com.contmatic.model.validacoes.Validador.validarNulo;
import static br.com.contmatic.model.validacoes.Validador.validarNumeroMaximo;
import static br.com.contmatic.model.validacoes.Validador.validarRegex;
import static br.com.contmatic.model.validacoes.Validador.validarTamanhoMaximo;
import static br.com.contmatic.model.validacoes.Validador.validarTamanhoMinimo;
import static br.com.contmatic.model.validacoes.Validador.validarVazio;
import static br.com.contmatic.model.validacoes.Validador.validarZero;

import java.util.Objects;

public class Cidade {

	private Integer codigoIBGE;

	private String nome;

	private Estado estado;
	
	public Cidade(Integer codigoIBGE, Estado estado) {
		this.setCodigoIBGE(codigoIBGE);
		this.setEstado(estado);
	}
	
	public Cidade(String nome, Integer codigoIBGE, Estado estado) {
		this.setNome(nome);
		this.setCodigoIBGE(codigoIBGE);
		this.setEstado(estado);
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		validarNulo(estado, MESSAGE_ESTADO_NOTNULL);
		this.estado = estado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		validarNulo(nome, MESSAGE_NOME_NOTNULL);
		validarVazio(nome, MESSAGE_NOME_NOTBLANK);
		validarTamanhoMaximo(nome, TAMANHO_MAX_NOME, MESSAGE_TAMANHO_MAX_NOME);
		validarTamanhoMinimo(nome, TAMANHO_MIN_NOME, MESSAGE_TAMANHO_MIN_NOME);
		validarRegex(nome, SOMENTE_LETRAS , MESSAGE_REGEX_NOME);
		this.nome = nome;
	}

	public Integer getCodigoIBGE() {
		return codigoIBGE;
	}

	public void setCodigoIBGE(Integer codigoIBGE) {
		validarNulo(codigoIBGE, MESSAGE_CODIGO_IBGE_NOTNULL);
		validarVazio(codigoIBGE, MESSAGE_CODIGO_IBGE_NOTBLANK);
		validarZero(codigoIBGE, MESSAGE_CODIGO_IBGE_ZERO);
		validarNumeroMaximo(codigoIBGE, CODIGO_IBGE_MAX, MESSAGE_CODIGO_IBGE_MAX);
		this.codigoIBGE = codigoIBGE;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoIBGE, estado);
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
		return Objects.equals(codigoIBGE, other.codigoIBGE) && Objects.equals(estado, other.estado);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cidade [codigoIBGE=");
		builder.append(codigoIBGE);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", estado=");
		builder.append(estado);
		builder.append("]");
		return builder.toString();
	}
}
