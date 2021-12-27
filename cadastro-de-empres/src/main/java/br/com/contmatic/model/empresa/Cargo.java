package br.com.contmatic.model.empresa;

import static br.com.contmatic.util.constants.Constants.REGEX_SOMENTE_LETRAS;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MAX_DESCRICAO_CARGO;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MAX_NOME_CARGO;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MIN_DESCRICAO_CARGO;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MIN_NOME_CARGO;
import static br.com.contmatic.util.constants.Message.MENSAGEM_ERRO_REGEX_SOMENTE_LETRAS;
import static br.com.contmatic.util.validacoes.Validador.validarNulo;
import static br.com.contmatic.util.validacoes.Validador.validarRegex;
import static br.com.contmatic.util.validacoes.Validador.validarTamanhoMaximo;
import static br.com.contmatic.util.validacoes.Validador.validarTamanhoMinimo;
import static br.com.contmatic.util.validacoes.Validador.validarVazio;

import java.util.Objects;

import br.com.contmatic.model.Audit;

public class Cargo extends Audit {

	private String nome;

	private String descricao;

	public Cargo(String nome) {
		this.setNome(nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		validarNulo(nome);
		validarVazio(nome);
		validarTamanhoMaximo(nome, TAMANHO_MAX_NOME_CARGO);
		validarTamanhoMinimo(nome, TAMANHO_MIN_NOME_CARGO);
		validarRegex(nome, REGEX_SOMENTE_LETRAS, MENSAGEM_ERRO_REGEX_SOMENTE_LETRAS);
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		validarNulo(descricao);
		validarVazio(descricao);
		validarTamanhoMaximo(descricao, TAMANHO_MAX_DESCRICAO_CARGO);
		validarTamanhoMinimo(descricao, TAMANHO_MIN_DESCRICAO_CARGO);
		this.descricao = descricao;
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

	@Override
	public String toString() {
		return "Cargo [nome=" + nome + ", descricao=" + descricao + ", audit()=" + super.toString() + "]";
	}
}
