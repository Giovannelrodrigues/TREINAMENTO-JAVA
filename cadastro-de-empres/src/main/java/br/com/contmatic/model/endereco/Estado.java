package br.com.contmatic.model.endereco;

import static br.com.contmatic.model.constants.mensagens.EstadoMessage.MESSAGE_CIDADES_IS_EMPTY;
import static br.com.contmatic.model.constants.mensagens.EstadoMessage.MESSAGE_CIDADES_LIST_MAX;
import static br.com.contmatic.model.constants.mensagens.EstadoMessage.MESSAGE_CIDADES_NOT_NULL;
import static br.com.contmatic.model.constants.mensagens.EstadoMessage.MESSAGE_NOME_NOT_BLANK;
import static br.com.contmatic.model.constants.mensagens.EstadoMessage.MESSAGE_NOME_NOT_NULL;
import static br.com.contmatic.model.constants.mensagens.EstadoMessage.MESSAGE_NOME_SOMENTE_LETRAS;
import static br.com.contmatic.model.constants.mensagens.EstadoMessage.MESSAGE_SIGLA_NOT_BLANK;
import static br.com.contmatic.model.constants.mensagens.EstadoMessage.MESSAGE_SIGLA_NOT_NULL;
import static br.com.contmatic.model.constants.mensagens.EstadoMessage.MESSAGE_SIGLA_REGEX;
import static br.com.contmatic.model.constants.mensagens.EstadoMessage.MESSAGE_TAMANHO_NOME_MAX;
import static br.com.contmatic.model.constants.mensagens.EstadoMessage.MESSAGE_TAMANHO_NOME_MIN;
import static br.com.contmatic.model.constants.mensagens.EstadoMessage.MESSAGE_TAMANHO_SIGLA;
import static br.com.contmatic.model.constants.numericas.EstadoConstants.TAMANHO_LISTA_MAX_CIDADES;
import static br.com.contmatic.model.constants.numericas.EstadoConstants.TAMANHO_MAX_ESTADO;
import static br.com.contmatic.model.constants.numericas.EstadoConstants.TAMANHO_MIN_ESTADO;
import static br.com.contmatic.model.constants.numericas.EstadoConstants.TAMANHO_SIGLA;
import static br.com.contmatic.model.constants.regex.BaseRegex.SOMENTE_LETRAS;
import static br.com.contmatic.model.constants.regex.EstadoRegex.REGEX_SIGLA_ESTADO;
import static br.com.contmatic.model.validacoes.Validador.validarListaVazia;
import static br.com.contmatic.model.validacoes.Validador.validarNulo;
import static br.com.contmatic.model.validacoes.Validador.validarRegex;
import static br.com.contmatic.model.validacoes.Validador.validarTamanho;
import static br.com.contmatic.model.validacoes.Validador.validarTamanhoMaximo;
import static br.com.contmatic.model.validacoes.Validador.validarTamanhoMaximoLista;
import static br.com.contmatic.model.validacoes.Validador.validarTamanhoMinimo;
import static br.com.contmatic.model.validacoes.Validador.validarVazio;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class Estado {

	private String nome;

	private String sigla;

	private List<Cidade> cidades;

	public Estado(String sigla) {
		this.setSigla(sigla);
	}

	public Estado(String sigla, String nome) {
		this.setNome(nome);
		this.setSigla(sigla);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		validarNulo(nome, MESSAGE_NOME_NOT_NULL);
		validarVazio(nome, MESSAGE_NOME_NOT_BLANK);
		validarTamanhoMaximo(nome, TAMANHO_MAX_ESTADO, MESSAGE_TAMANHO_NOME_MAX);
		validarTamanhoMinimo(nome, TAMANHO_MIN_ESTADO, MESSAGE_TAMANHO_NOME_MIN);
		validarRegex(nome, SOMENTE_LETRAS, MESSAGE_NOME_SOMENTE_LETRAS);
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		validarNulo(sigla, MESSAGE_SIGLA_NOT_NULL);
		validarVazio(sigla, MESSAGE_SIGLA_NOT_BLANK);
		validarTamanho(sigla, TAMANHO_SIGLA, MESSAGE_TAMANHO_SIGLA);
		validarRegex(sigla, REGEX_SIGLA_ESTADO, MESSAGE_SIGLA_REGEX);
		this.sigla = sigla;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		validarNulo(cidades, MESSAGE_CIDADES_NOT_NULL);
		validarListaVazia(cidades, MESSAGE_CIDADES_IS_EMPTY);
		validarTamanhoMaximoLista(cidades, TAMANHO_LISTA_MAX_CIDADES, MESSAGE_CIDADES_LIST_MAX);
		this.cidades = cidades;
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj, "nome", "cidades");
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, "nome", "cidades");
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toStringExclude(this, "cidades");
	}
}
