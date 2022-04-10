package br.com.contmatic.model.empresa;

import static br.com.contmatic.model.constants.mensagens.AmbienteTrabalhoMessage.MESSAGE_DESCRICAO_NOTBLANK;
import static br.com.contmatic.model.constants.mensagens.AmbienteTrabalhoMessage.MESSAGE_DESCRICAO_NOTNULL;
import static br.com.contmatic.model.constants.mensagens.AmbienteTrabalhoMessage.MESSAGE_EMPRESA_NOT_NULL;
import static br.com.contmatic.model.constants.mensagens.AmbienteTrabalhoMessage.MESSAGE_ENDERECOS_LIST_MAX;
import static br.com.contmatic.model.constants.mensagens.AmbienteTrabalhoMessage.MESSAGE_NOME_NOTBLANK;
import static br.com.contmatic.model.constants.mensagens.AmbienteTrabalhoMessage.MESSAGE_NOME_NOTNULL;
import static br.com.contmatic.model.constants.mensagens.AmbienteTrabalhoMessage.MESSAGE_NOME_REGEX;
import static br.com.contmatic.model.constants.mensagens.AmbienteTrabalhoMessage.MESSAGE_SETORES_IS_EMPTY;
import static br.com.contmatic.model.constants.mensagens.AmbienteTrabalhoMessage.MESSAGE_SETORES_LIST_MAX;
import static br.com.contmatic.model.constants.mensagens.AmbienteTrabalhoMessage.MESSAGE_SETORES_NOT_NULL;
import static br.com.contmatic.model.constants.mensagens.AmbienteTrabalhoMessage.MESSAGE_TAMANHO_MAX_DESCRICAO;
import static br.com.contmatic.model.constants.mensagens.AmbienteTrabalhoMessage.MESSAGE_TAMANHO_MAX_NOME;
import static br.com.contmatic.model.constants.mensagens.AmbienteTrabalhoMessage.MESSAGE_TAMANHO_MIN_DESCRICAO;
import static br.com.contmatic.model.constants.mensagens.AmbienteTrabalhoMessage.MESSAGE_TAMANHO_MIN_NOME;
import static br.com.contmatic.model.constants.mensagens.AmbienteTrabalhoMessage.MESSAGE_TIPO_NOTNULL;
import static br.com.contmatic.model.constants.numericas.AmbienteTrabalhoConstants.TAMANHO_MAX_DESCRICAO;
import static br.com.contmatic.model.constants.numericas.AmbienteTrabalhoConstants.TAMANHO_MAX_LISTA_ENDERECOS;
import static br.com.contmatic.model.constants.numericas.AmbienteTrabalhoConstants.TAMANHO_MAX_LISTA_SETORES;
import static br.com.contmatic.model.constants.numericas.AmbienteTrabalhoConstants.TAMANHO_MAX_NOME;
import static br.com.contmatic.model.constants.numericas.AmbienteTrabalhoConstants.TAMANHO_MIN_DESCRICAO;
import static br.com.contmatic.model.constants.numericas.AmbienteTrabalhoConstants.TAMANHO_MIN_NOME;
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
import br.com.contmatic.model.constants.mensagens.AmbienteTrabalhoMessage;
import br.com.contmatic.model.endereco.Endereco;

public class AmbienteTrabalho extends Auditoria {

	private String nome;

	private String descricao;

	private TipoAmbienteTrabalho tipo;

	private List<Setor> setores;

	private List<Endereco> enderecos;

	private Empresa empresa;

	public AmbienteTrabalho(String nome, Empresa empresa) {
		this.setNome(nome);
		this.setEmpresa(empresa);
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

	public TipoAmbienteTrabalho getTipo() {
		return this.tipo;
	}

	public void setTipo(TipoAmbienteTrabalho tipo) {
		validarNulo(tipo, MESSAGE_TIPO_NOTNULL);
		this.tipo = tipo;
	}

	public List<Setor> getSetores() {
		return this.setores;
	}

	public void setSetores(List<Setor> setores) {
		validarNulo(setores, MESSAGE_SETORES_NOT_NULL);
		validarListaVazia(setores, MESSAGE_SETORES_IS_EMPTY);
		validarTamanhoMaximoLista(setores, TAMANHO_MAX_LISTA_SETORES, MESSAGE_SETORES_LIST_MAX);
		this.setores = setores;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		validarNulo(enderecos, AmbienteTrabalhoMessage.MESSAGE_ENDERECOS_NOT_NULL);
		validarListaVazia(enderecos, AmbienteTrabalhoMessage.MESSAGE_ENDERECOS_IS_EMPTY);
		validarTamanhoMaximoLista(enderecos, TAMANHO_MAX_LISTA_ENDERECOS, MESSAGE_ENDERECOS_LIST_MAX);
		this.enderecos = enderecos;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		validarNulo(empresa, MESSAGE_EMPRESA_NOT_NULL);
		this.empresa = empresa;
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
