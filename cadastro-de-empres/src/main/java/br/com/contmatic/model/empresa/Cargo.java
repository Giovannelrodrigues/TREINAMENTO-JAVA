package br.com.contmatic.model.empresa;

import static br.com.contmatic.model.constants.mensagens.CargoMessage.MESSAGE_AMBIENTE_TRABALHO_NOTNULL;
import static br.com.contmatic.model.constants.mensagens.CargoMessage.MESSAGE_DESCRICAO_NOTBLANK;
import static br.com.contmatic.model.constants.mensagens.CargoMessage.MESSAGE_DESCRICAO_NOTNULL;
import static br.com.contmatic.model.constants.mensagens.CargoMessage.MESSAGE_NOME_NOTBLANK;
import static br.com.contmatic.model.constants.mensagens.CargoMessage.MESSAGE_NOME_NOTNULL;
import static br.com.contmatic.model.constants.mensagens.CargoMessage.MESSAGE_NOME_REGEX;
import static br.com.contmatic.model.constants.mensagens.CargoMessage.MESSAGE_TAMANHO_MAX_DESCRICAO;
import static br.com.contmatic.model.constants.mensagens.CargoMessage.MESSAGE_TAMANHO_MAX_NOME;
import static br.com.contmatic.model.constants.mensagens.CargoMessage.MESSAGE_TAMANHO_MIN_DESCRICAO;
import static br.com.contmatic.model.constants.mensagens.CargoMessage.MESSAGE_TAMANHO_MIN_NOME;
import static br.com.contmatic.model.constants.numericas.CargoConstants.TAMANHO_MAX_DESCRICAO;
import static br.com.contmatic.model.constants.numericas.CargoConstants.TAMANHO_MAX_NOME;
import static br.com.contmatic.model.constants.numericas.CargoConstants.TAMANHO_MIN_DESCRICAO;
import static br.com.contmatic.model.constants.numericas.CargoConstants.TAMANHO_MIN_NOME;
import static br.com.contmatic.model.constants.regex.BaseRegex.SOMENTE_LETRAS;
import static br.com.contmatic.model.validacoes.Validador.validarNulo;
import static br.com.contmatic.model.validacoes.Validador.validarRegex;
import static br.com.contmatic.model.validacoes.Validador.validarTamanhoMaximo;
import static br.com.contmatic.model.validacoes.Validador.validarTamanhoMinimo;
import static br.com.contmatic.model.validacoes.Validador.validarVazio;

import java.util.Objects;

import br.com.contmatic.model.auditoria.Auditoria;

public class Cargo extends Auditoria {

	private String nome;

	private String descricao;
	
	private AmbienteTrabalho ambienteTrabalho;

	public Cargo(String nome, AmbienteTrabalho ambienteTrabalho) {
		this.setNome(nome);
		this.setAmbienteTrabalho(ambienteTrabalho);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		validarNulo(nome, MESSAGE_NOME_NOTNULL);
		validarVazio(nome, MESSAGE_NOME_NOTBLANK);
		validarTamanhoMaximo(nome, TAMANHO_MAX_NOME, MESSAGE_TAMANHO_MAX_NOME);
		validarTamanhoMinimo(nome, TAMANHO_MIN_NOME, MESSAGE_TAMANHO_MIN_NOME);
		validarRegex(nome, SOMENTE_LETRAS, MESSAGE_NOME_REGEX);
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		validarNulo(descricao, MESSAGE_DESCRICAO_NOTNULL);
		validarVazio(descricao, MESSAGE_DESCRICAO_NOTBLANK);
		validarTamanhoMaximo(descricao, TAMANHO_MAX_DESCRICAO, MESSAGE_TAMANHO_MAX_DESCRICAO);
		validarTamanhoMinimo(descricao, TAMANHO_MIN_DESCRICAO, MESSAGE_TAMANHO_MIN_DESCRICAO);
		this.descricao = descricao;
	}
	
	public AmbienteTrabalho getAmbienteTrabalho() {
		return ambienteTrabalho;
	}

	public void setAmbienteTrabalho(AmbienteTrabalho ambienteTrabalho) {
		validarNulo(ambienteTrabalho, MESSAGE_AMBIENTE_TRABALHO_NOTNULL);
		this.ambienteTrabalho = ambienteTrabalho;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ambienteTrabalho, nome);
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
		return Objects.equals(ambienteTrabalho, other.ambienteTrabalho) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cargo [nome=");
		builder.append(nome);
		builder.append(", descricao=");
		builder.append(descricao);
		builder.append(", ambienteTrabalho=");
		builder.append(ambienteTrabalho);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
}
