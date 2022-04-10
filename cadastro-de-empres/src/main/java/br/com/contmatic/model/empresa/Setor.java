package br.com.contmatic.model.empresa;

import static br.com.contmatic.model.constants.mensagens.SetorMessage.MESSAGE_AMBIENTE_TRABALHO_NOTNULL;
import static br.com.contmatic.model.constants.mensagens.SetorMessage.MESSAGE_DESCRICAO_NOTBLANK;
import static br.com.contmatic.model.constants.mensagens.SetorMessage.MESSAGE_DESCRICAO_NOTNULL;
import static br.com.contmatic.model.constants.mensagens.SetorMessage.MESSAGE_FUCIONARIOS_IS_EMPTY;
import static br.com.contmatic.model.constants.mensagens.SetorMessage.MESSAGE_FUCIONARIOS_LIST_MAX;
import static br.com.contmatic.model.constants.mensagens.SetorMessage.MESSAGE_FUCIONARIOS_NOT_NULL;
import static br.com.contmatic.model.constants.mensagens.SetorMessage.MESSAGE_NOME_NOTBLANK;
import static br.com.contmatic.model.constants.mensagens.SetorMessage.MESSAGE_NOME_NOTNULL;
import static br.com.contmatic.model.constants.mensagens.SetorMessage.MESSAGE_NOME_REGEX;
import static br.com.contmatic.model.constants.mensagens.SetorMessage.MESSAGE_TAMANHO_MAX_DESCRICAO;
import static br.com.contmatic.model.constants.mensagens.SetorMessage.MESSAGE_TAMANHO_MAX_NOME;
import static br.com.contmatic.model.constants.mensagens.SetorMessage.MESSAGE_TAMANHO_MIN_DESCRICAO;
import static br.com.contmatic.model.constants.mensagens.SetorMessage.MESSAGE_TAMANHO_MIN_NOME;
import static br.com.contmatic.model.constants.numericas.SetorConstants.TAMANHO_MAX_DESCRICAO;
import static br.com.contmatic.model.constants.numericas.SetorConstants.TAMANHO_MAX_LISTA_FUNCIONARIOS;
import static br.com.contmatic.model.constants.numericas.SetorConstants.TAMANHO_MAX_NOME;
import static br.com.contmatic.model.constants.numericas.SetorConstants.TAMANHO_MIN_DESCRICAO;
import static br.com.contmatic.model.constants.numericas.SetorConstants.TAMANHO_MIN_NOME;
import static br.com.contmatic.model.constants.regex.BaseRegex.SOMENTE_LETRAS;
import static br.com.contmatic.model.validacoes.Validador.validarListaVazia;
import static br.com.contmatic.model.validacoes.Validador.validarNulo;
import static br.com.contmatic.model.validacoes.Validador.validarRegex;
import static br.com.contmatic.model.validacoes.Validador.validarTamanhoMaximo;
import static br.com.contmatic.model.validacoes.Validador.validarTamanhoMaximoLista;
import static br.com.contmatic.model.validacoes.Validador.validarTamanhoMinimo;
import static br.com.contmatic.model.validacoes.Validador.validarVazio;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import br.com.contmatic.model.auditoria.Auditoria;

public class Setor extends Auditoria {

	private String nome;

	private String descricao;

	private List<Funcionario> funcionarios;

	private AmbienteTrabalho ambienteTrabalho;
	
	public Setor(String nome, AmbienteTrabalho ambienteTrabalho) {
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

	public List<Funcionario> getFuncionarios() {
		return this.funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionario) {
		validarNulo(funcionario, MESSAGE_FUCIONARIOS_NOT_NULL);
		validarListaVazia(funcionario, MESSAGE_FUCIONARIOS_IS_EMPTY);
		validarTamanhoMaximoLista(funcionario, TAMANHO_MAX_LISTA_FUNCIONARIOS, MESSAGE_FUCIONARIOS_LIST_MAX);
		this.funcionarios = funcionario;
	}

	public AmbienteTrabalho getAmbienteTrabalho() {
		return ambienteTrabalho;
	}

	public void setAmbienteTrabalho(AmbienteTrabalho ambienteTrabalho) {
		validarNulo(ambienteTrabalho, MESSAGE_AMBIENTE_TRABALHO_NOTNULL);
		this.ambienteTrabalho = ambienteTrabalho;
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}
	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
