package br.com.contmatic.model.empresa;

import static br.com.contmatic.model.constants.mensagens.EmpresaMessage.MENSAGEM_CNPJ_CARACTERES_REPETIDOS;
import static br.com.contmatic.model.constants.mensagens.EmpresaMessage.MENSAGEM_RAZAO_SOCIAL_REGEX;
import static br.com.contmatic.model.constants.mensagens.EmpresaMessage.MESSAGE_AMBIENTE_TRABALHO_IS_EMPTY;
import static br.com.contmatic.model.constants.mensagens.EmpresaMessage.MESSAGE_AMBIENTE_TRABALHO_LIST_MAX;
import static br.com.contmatic.model.constants.mensagens.EmpresaMessage.MESSAGE_AMBIENTE_TRABALHO_NOT_NULL;
import static br.com.contmatic.model.constants.mensagens.EmpresaMessage.MESSAGE_CNPJ_NOTBLANK;
import static br.com.contmatic.model.constants.mensagens.EmpresaMessage.MESSAGE_CNPJ_NOTNULL;
import static br.com.contmatic.model.constants.mensagens.EmpresaMessage.MESSAGE_CNPJ_REGEX;
import static br.com.contmatic.model.constants.mensagens.EmpresaMessage.MESSAGE_EMAILS_IS_EMPTY;
import static br.com.contmatic.model.constants.mensagens.EmpresaMessage.MESSAGE_EMAILS_LIST_MAX;
import static br.com.contmatic.model.constants.mensagens.EmpresaMessage.MESSAGE_EMAILS_NOT_NULL;
import static br.com.contmatic.model.constants.mensagens.EmpresaMessage.MESSAGE_ENDERECOS_IS_EMPTY;
import static br.com.contmatic.model.constants.mensagens.EmpresaMessage.MESSAGE_ENDERECOS_LIST_MAX;
import static br.com.contmatic.model.constants.mensagens.EmpresaMessage.MESSAGE_ENDERECOS_NOT_NULL;
import static br.com.contmatic.model.constants.mensagens.EmpresaMessage.MESSAGE_NOME_FANTASIA_NOTNULL;
import static br.com.contmatic.model.constants.mensagens.EmpresaMessage.MESSAGE_PRODUTOS_IS_EMPTY;
import static br.com.contmatic.model.constants.mensagens.EmpresaMessage.MESSAGE_PRODUTOS_LIST_MAX;
import static br.com.contmatic.model.constants.mensagens.EmpresaMessage.MESSAGE_PRODUTOS_NOT_NULL;
import static br.com.contmatic.model.constants.mensagens.EmpresaMessage.MESSAGE_RAZAO_SOCIAL_NOTBLANK;
import static br.com.contmatic.model.constants.mensagens.EmpresaMessage.MESSAGE_RAZAO_SOCIAL_NOTNULL;
import static br.com.contmatic.model.constants.mensagens.EmpresaMessage.MESSAGE_STATUS_NOT_NULL;
import static br.com.contmatic.model.constants.mensagens.EmpresaMessage.MESSAGE_TAMANHO_CNPJ;
import static br.com.contmatic.model.constants.mensagens.EmpresaMessage.MESSAGE_TAMANHO_MAX_NOME_FANTASIA;
import static br.com.contmatic.model.constants.mensagens.EmpresaMessage.MESSAGE_TAMANHO_MAX_RAZAO_SOCIAL;
import static br.com.contmatic.model.constants.mensagens.EmpresaMessage.MESSAGE_TAMANHO_MIN_NOME_FANTASIA;
import static br.com.contmatic.model.constants.mensagens.EmpresaMessage.MESSAGE_TAMANHO_MIN_RAZAO_SOCIAL;
import static br.com.contmatic.model.constants.mensagens.EmpresaMessage.MESSAGE_TELEFONES_IS_EMPTY;
import static br.com.contmatic.model.constants.mensagens.EmpresaMessage.MESSAGE_TELEFONES_NOT_NULL;
import static br.com.contmatic.model.constants.numericas.EmpresaConstants.TAMANHO_CNPJ;
import static br.com.contmatic.model.constants.numericas.EmpresaConstants.TAMANHO_MAX_LISTA_AMBIENTE_TRABALHO;
import static br.com.contmatic.model.constants.numericas.EmpresaConstants.TAMANHO_MAX_LISTA_EMAILS;
import static br.com.contmatic.model.constants.numericas.EmpresaConstants.TAMANHO_MAX_LISTA_ENDERECO;
import static br.com.contmatic.model.constants.numericas.EmpresaConstants.TAMANHO_MAX_LISTA_PRODUTO;
import static br.com.contmatic.model.constants.numericas.EmpresaConstants.TAMANHO_MAX_LISTA_TELEFONES;
import static br.com.contmatic.model.constants.numericas.EmpresaConstants.TAMANHO_MAX_NOME_FANTASIA;
import static br.com.contmatic.model.constants.numericas.EmpresaConstants.TAMANHO_MAX_RAZAO_SOCIAL;
import static br.com.contmatic.model.constants.numericas.EmpresaConstants.TAMANHO_MIN_NOME_FANTASIA;
import static br.com.contmatic.model.constants.numericas.EmpresaConstants.TAMANHO_MIN_RAZAO_SOCIAL;
import static br.com.contmatic.model.constants.regex.BaseRegex.SOMENTE_NUMEROS;
import static br.com.contmatic.model.constants.regex.EmpresaRegex.REGEX_RAZAO_SOCIAL;
import static br.com.contmatic.model.validacoes.Validador.validarCaracteresRepetidos;
import static br.com.contmatic.model.validacoes.Validador.validarListaVazia;
import static br.com.contmatic.model.validacoes.Validador.validarNulo;
import static br.com.contmatic.model.validacoes.Validador.validarRegex;
import static br.com.contmatic.model.validacoes.Validador.validarTamanho;
import static br.com.contmatic.model.validacoes.Validador.validarTamanhoMaximo;
import static br.com.contmatic.model.validacoes.Validador.validarTamanhoMaximoLista;
import static br.com.contmatic.model.validacoes.Validador.validarTamanhoMinimo;
import static br.com.contmatic.model.validacoes.Validador.validarVazio;
import static br.com.contmatic.model.validacoes.ValidadorCNPJ.validarCNPJ;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import br.com.contmatic.model.auditoria.Auditoria;
import br.com.contmatic.model.contato.Email;
import br.com.contmatic.model.contato.Telefone;
import br.com.contmatic.model.endereco.Endereco;

public class Empresa extends Auditoria {

	private String cnpj;

	private String nomeFantasia;

	private String razaoSocial;

	private List<Endereco> enderecos;

	private List<AmbienteTrabalho> ambientesTrabalhos;

	private List<Produto> produtos;

	private Set<Telefone> telefones;

	private List<Email> emails;
			
	private Boolean status;

	public Empresa(String cnpj) {
		this.setCnpj(cnpj);
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		validarNulo(cnpj, MESSAGE_CNPJ_NOTNULL);
		validarVazio(cnpj, MESSAGE_CNPJ_NOTBLANK);
		validarRegex(cnpj, SOMENTE_NUMEROS, MESSAGE_CNPJ_REGEX);
		validarTamanho(cnpj, TAMANHO_CNPJ, MESSAGE_TAMANHO_CNPJ);
		validarCaracteresRepetidos(cnpj, MENSAGEM_CNPJ_CARACTERES_REPETIDOS);
		validarCNPJ(cnpj);
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		validarNulo(razaoSocial, MESSAGE_RAZAO_SOCIAL_NOTNULL);
		validarVazio(razaoSocial, MESSAGE_RAZAO_SOCIAL_NOTBLANK);
		validarTamanhoMaximo(razaoSocial, TAMANHO_MAX_RAZAO_SOCIAL, MESSAGE_TAMANHO_MAX_RAZAO_SOCIAL);
		validarTamanhoMinimo(razaoSocial, TAMANHO_MIN_RAZAO_SOCIAL, MESSAGE_TAMANHO_MIN_RAZAO_SOCIAL);
		validarRegex(razaoSocial, REGEX_RAZAO_SOCIAL, MENSAGEM_RAZAO_SOCIAL_REGEX);
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		validarNulo(nomeFantasia, MESSAGE_NOME_FANTASIA_NOTNULL);
		validarVazio(nomeFantasia, MESSAGE_CNPJ_NOTBLANK);
		validarTamanhoMaximo(nomeFantasia, TAMANHO_MAX_NOME_FANTASIA, MESSAGE_TAMANHO_MAX_NOME_FANTASIA);
		validarTamanhoMinimo(nomeFantasia, TAMANHO_MIN_NOME_FANTASIA, MESSAGE_TAMANHO_MIN_NOME_FANTASIA);
		this.nomeFantasia = nomeFantasia;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		validarNulo(enderecos, MESSAGE_ENDERECOS_NOT_NULL);
		validarListaVazia(enderecos, MESSAGE_ENDERECOS_IS_EMPTY);
		validarTamanhoMaximoLista(enderecos, TAMANHO_MAX_LISTA_ENDERECO, MESSAGE_ENDERECOS_LIST_MAX);
		this.enderecos = enderecos;
	}

	public List<AmbienteTrabalho> getAmbientesTrabalhos() {
		return this.ambientesTrabalhos;
	}

	public void setAmbientesTrabalhos(List<AmbienteTrabalho> ambientesTrabalhos) {
		validarNulo(ambientesTrabalhos, MESSAGE_AMBIENTE_TRABALHO_NOT_NULL);
		validarListaVazia(ambientesTrabalhos, MESSAGE_AMBIENTE_TRABALHO_IS_EMPTY);
		validarTamanhoMaximoLista(ambientesTrabalhos, TAMANHO_MAX_LISTA_AMBIENTE_TRABALHO,
				MESSAGE_AMBIENTE_TRABALHO_LIST_MAX);
		this.ambientesTrabalhos = ambientesTrabalhos;
	}

	public List<Produto> getProdutos() {
		return this.produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		validarNulo(produtos, MESSAGE_PRODUTOS_NOT_NULL);
		validarListaVazia(produtos, MESSAGE_PRODUTOS_IS_EMPTY);
		validarTamanhoMaximoLista(produtos, TAMANHO_MAX_LISTA_PRODUTO, MESSAGE_PRODUTOS_LIST_MAX);
		this.produtos = produtos;
	}

	public Set<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<Telefone> telefones) {
		validarNulo(telefones, MESSAGE_TELEFONES_NOT_NULL);
		validarListaVazia(telefones, MESSAGE_TELEFONES_IS_EMPTY);
		validarTamanhoMaximoLista(telefones, TAMANHO_MAX_LISTA_TELEFONES, MESSAGE_TELEFONES_IS_EMPTY);
		this.telefones = telefones;
	}

	public List<Email> getEmails() {
		return emails;
	}

	public void setEmails(List<Email> emails) {
		validarNulo(emails, MESSAGE_EMAILS_NOT_NULL);
		validarListaVazia(emails, MESSAGE_EMAILS_IS_EMPTY);
		validarTamanhoMaximoLista(emails, TAMANHO_MAX_LISTA_EMAILS, MESSAGE_EMAILS_LIST_MAX);
		this.emails = emails;
	}
	
	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		validarNulo(status, MESSAGE_STATUS_NOT_NULL);
		this.status = status;
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj, "nomeFantasia", "razaoSocial", "enderecos", "ambientesTrabalhos", "produtos", "telefones", "emails", "status");
	}
	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, "nomeFantasia", "razaoSocial", "enderecos", "ambientesTrabalhos", "produtos", "telefones", "emails", "status");
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
