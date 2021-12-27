package br.com.contmatic.model;

import static br.com.contmatic.util.constants.Constants.REGEX_SIGLA_ESTADO;
import static br.com.contmatic.util.constants.Constants.REGEX_SOMENTE_LETRAS;
import static br.com.contmatic.util.constants.Constants.TAMANHO_LISTA_MAX_CIDADES;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MAX_ESTADO_ENDERECO;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MAX_SIGLA_ESTADO_ENDERECO;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MIN_ESTADO_ENDERECO;
import static br.com.contmatic.util.constants.Message.MENSAGEM_ERRO_REGEX_SOMENTE_LETRAS;
import static br.com.contmatic.util.constants.Message.MENSAGEM_ERRO_REGEX_SOMENTE_LETRAS_MAIUSCULAS;
import static br.com.contmatic.util.validacoes.Validador.validarListaVazia;
import static br.com.contmatic.util.validacoes.Validador.validarNulo;
import static br.com.contmatic.util.validacoes.Validador.validarRegex;
import static br.com.contmatic.util.validacoes.Validador.validarTamanhoMaximo;
import static br.com.contmatic.util.validacoes.Validador.validarTamanhoMaximoLista;
import static br.com.contmatic.util.validacoes.Validador.validarTamanhoMinimo;
import static br.com.contmatic.util.validacoes.Validador.validarVazio;

import java.util.List;
import java.util.Objects;

public class Estado {

	private String nome;

	private String sigla;

	private List<Cidade> cidades;

	public Estado(String nome, String sigla) {
		this.setNome(nome);
		this.setSigla(sigla);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		validarNulo(nome);
		validarVazio(nome);
		validarTamanhoMaximo(nome, TAMANHO_MAX_ESTADO_ENDERECO);
		validarTamanhoMinimo(nome, TAMANHO_MIN_ESTADO_ENDERECO);
		validarRegex(nome, REGEX_SOMENTE_LETRAS, MENSAGEM_ERRO_REGEX_SOMENTE_LETRAS);
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		validarNulo(sigla);
		validarVazio(sigla);
		validarTamanhoMaximo(sigla, TAMANHO_MAX_SIGLA_ESTADO_ENDERECO);
		validarTamanhoMinimo(sigla, TAMANHO_MAX_SIGLA_ESTADO_ENDERECO);
		validarRegex(sigla, REGEX_SIGLA_ESTADO, MENSAGEM_ERRO_REGEX_SOMENTE_LETRAS_MAIUSCULAS);
		this.sigla = sigla;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		validarNulo(cidades);
		validarListaVazia(cidades);
		validarTamanhoMaximoLista(cidades, TAMANHO_LISTA_MAX_CIDADES);
		this.cidades = cidades;
	}

	@Override
	public int hashCode() {
		return Objects.hash(sigla);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estado other = (Estado) obj;
		return Objects.equals(sigla, other.sigla);
	}

	@Override
	public String toString() {
		return "Estado [nome=" + nome + ", sigla=" + sigla + "]";
	}

}
