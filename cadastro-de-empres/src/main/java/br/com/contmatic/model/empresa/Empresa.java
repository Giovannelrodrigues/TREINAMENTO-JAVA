package br.com.contmatic.model.empresa;

import static br.com.contmatic.util.constants.Constants.REGEX_RAZAO_SOCIAL;
import static br.com.contmatic.util.constants.Constants.TAMANHO_CNPJ;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MAX_LISTA_AMBIENTE_TRABALHO;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MAX_LISTA_EMAILS;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MAX_LISTA_ENDERECO;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MAX_LISTA_PRODUTO;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MAX_LISTA_TELEFONES;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MAX_LISTA_USUARIOS;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MAX_NOME_FANTASIA;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MAX_RAZAO_SOCIAL;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MIN_NOME_FANTASIA;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MIN_RAZAO_SOCIAL;
import static br.com.contmatic.util.constants.Message.MENSAGEM_ERRO_REGEX_RAZAO_SOCIAL;
import static br.com.contmatic.util.validacoes.Validador.validarCaracteresRepetidos;
import static br.com.contmatic.util.validacoes.Validador.validarListaVazia;
import static br.com.contmatic.util.validacoes.Validador.validarNulo;
import static br.com.contmatic.util.validacoes.Validador.validarRegex;
import static br.com.contmatic.util.validacoes.Validador.validarSomenteNumero;
import static br.com.contmatic.util.validacoes.Validador.validarTamanho;
import static br.com.contmatic.util.validacoes.Validador.validarTamanhoMaximo;
import static br.com.contmatic.util.validacoes.Validador.validarTamanhoMaximoLista;
import static br.com.contmatic.util.validacoes.Validador.validarTamanhoMinimo;
import static br.com.contmatic.util.validacoes.Validador.validarVazio;
import static br.com.contmatic.util.validacoes.ValidadorCNPJ.validarCNPJ;

import java.util.List;
import java.util.Objects;

import br.com.contmatic.model.Audit;
import br.com.contmatic.model.Email;
import br.com.contmatic.model.Endereco;
import br.com.contmatic.model.Telefone;
import br.com.contmatic.model.usuario.Usuario;

public class Empresa extends Audit {

	private String cnpj;

	private String nomeFantasia;

	private String razaoSocial;

	private List<Endereco> enderecos;

	private List<AmbienteTrabalho> ambientesTrabalhos;

	private List<Produto> produtos;

	private List<Telefone> telefones;

	private List<Email> emails;

	private List<Usuario> usuarios;

	public Empresa(String cnpj) {
		this.setCnpj(cnpj);
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		validarNulo(cnpj);
		validarVazio(cnpj);
		validarTamanho(cnpj, TAMANHO_CNPJ);
		validarSomenteNumero(cnpj);
		validarCaracteresRepetidos(cnpj);
		validarCNPJ(cnpj);
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		validarNulo(razaoSocial);
		validarVazio(razaoSocial);
		validarTamanhoMaximo(razaoSocial, TAMANHO_MAX_RAZAO_SOCIAL);
		validarTamanhoMinimo(razaoSocial, TAMANHO_MIN_RAZAO_SOCIAL);
		validarRegex(razaoSocial, REGEX_RAZAO_SOCIAL, MENSAGEM_ERRO_REGEX_RAZAO_SOCIAL);
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		validarNulo(nomeFantasia);
		validarVazio(nomeFantasia);
		validarTamanhoMaximo(nomeFantasia, TAMANHO_MAX_NOME_FANTASIA);
		validarTamanhoMinimo(nomeFantasia, TAMANHO_MIN_NOME_FANTASIA);
		this.nomeFantasia = nomeFantasia;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		validarNulo(enderecos);
		validarListaVazia(enderecos);
		validarTamanhoMaximoLista(enderecos, TAMANHO_MAX_LISTA_ENDERECO);
		this.enderecos = enderecos;
	}

	public List<AmbienteTrabalho> getAmbientesTrabalhos() {
		return this.ambientesTrabalhos;
	}

	public void setAmbientesTrabalhos(List<AmbienteTrabalho> ambientesTrabalhos) {
		validarNulo(ambientesTrabalhos);
		validarListaVazia(ambientesTrabalhos);
		validarTamanhoMaximoLista(ambientesTrabalhos, TAMANHO_MAX_LISTA_AMBIENTE_TRABALHO);
		this.ambientesTrabalhos = ambientesTrabalhos;
	}

	public List<Produto> getProdutos() {
		return this.produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		validarNulo(produtos);
		validarListaVazia(produtos);
		validarTamanhoMaximoLista(produtos, TAMANHO_MAX_LISTA_PRODUTO);
		this.produtos = produtos;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		validarNulo(telefones);
		validarListaVazia(telefones);
		validarTamanhoMaximoLista(telefones, TAMANHO_MAX_LISTA_TELEFONES);
		this.telefones = telefones;
	}

	public List<Email> getEmails() {
		return emails;
	}

	public void setEmails(List<Email> emails) {
		validarNulo(emails);
		validarListaVazia(emails);
		validarTamanhoMaximoLista(emails, TAMANHO_MAX_LISTA_EMAILS);
		this.emails = emails;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		validarNulo(usuarios);
		validarListaVazia(usuarios);
		validarTamanhoMaximoLista(usuarios, TAMANHO_MAX_LISTA_USUARIOS);
		this.usuarios = usuarios;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cnpj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		return Objects.equals(cnpj, other.cnpj);
	}

	@Override
	public String toString() {
		return "Empresa [cnpj=" + cnpj + ", nomeFantasia=" + nomeFantasia + ", razaoSocial=" + razaoSocial
				+ ", enderecos=" + enderecos + ", ambientesTrabalhos=" + ambientesTrabalhos + ", produtos=" + produtos
				+ ", telefones=" + telefones + ", emails=" + emails + ", usuarios=" + usuarios + ", audit()="
				+ super.toString() + "]";
	}

}
