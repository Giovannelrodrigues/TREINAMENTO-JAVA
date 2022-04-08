package br.com.contmatic.model.empresa;

import static br.com.contmatic.model.constants.mensagens.FuncionarioMessage.MENSAGEM_CPF_CARACTERES_REPETIDOS;
import static br.com.contmatic.model.constants.mensagens.FuncionarioMessage.MESSAGE_CARGO_NOTNULL;
import static br.com.contmatic.model.constants.mensagens.FuncionarioMessage.MESSAGE_CPF_NOTBLANK;
import static br.com.contmatic.model.constants.mensagens.FuncionarioMessage.MESSAGE_CPF_NOTNULL;
import static br.com.contmatic.model.constants.mensagens.FuncionarioMessage.MESSAGE_CPF_REGEX;
import static br.com.contmatic.model.constants.mensagens.FuncionarioMessage.MESSAGE_DATA_NASCIMENTO_NOTBLANK;
import static br.com.contmatic.model.constants.mensagens.FuncionarioMessage.MESSAGE_DATA_NASCIMENTO_NOTNULL;
import static br.com.contmatic.model.constants.mensagens.FuncionarioMessage.MESSAGE_DATA_NASCIMENTO_REGEX;
import static br.com.contmatic.model.constants.mensagens.FuncionarioMessage.MESSAGE_EMAILS_IS_EMPTY;
import static br.com.contmatic.model.constants.mensagens.FuncionarioMessage.MESSAGE_EMAILS_LIST_MAX;
import static br.com.contmatic.model.constants.mensagens.FuncionarioMessage.MESSAGE_EMAILS_NOT_NULL;
import static br.com.contmatic.model.constants.mensagens.FuncionarioMessage.MESSAGE_ENDERECO_NOTNULL;
import static br.com.contmatic.model.constants.mensagens.FuncionarioMessage.MESSAGE_NOME_NOTBLANK;
import static br.com.contmatic.model.constants.mensagens.FuncionarioMessage.MESSAGE_NOME_NOTNULL;
import static br.com.contmatic.model.constants.mensagens.FuncionarioMessage.MESSAGE_NOME_REGEX;
import static br.com.contmatic.model.constants.mensagens.FuncionarioMessage.MESSAGE_SETOR_NOTNULL;
import static br.com.contmatic.model.constants.mensagens.FuncionarioMessage.MESSAGE_TAMANHO_DATA_NASCIMENTO;
import static br.com.contmatic.model.constants.mensagens.FuncionarioMessage.MESSAGE_TAMANHO_MAX_NOME;
import static br.com.contmatic.model.constants.mensagens.FuncionarioMessage.MESSAGE_TAMANHO_MIN_NOME;
import static br.com.contmatic.model.constants.mensagens.FuncionarioMessage.MESSAGE_TELEFONES_IS_EMPTY;
import static br.com.contmatic.model.constants.mensagens.FuncionarioMessage.MESSAGE_TELEFONES_LIST_MAX;
import static br.com.contmatic.model.constants.mensagens.FuncionarioMessage.MESSAGE_TELEFONES_NOT_NULL;
import static br.com.contmatic.model.constants.numericas.FuncionarioConstants.TAMANHO_CPF;
import static br.com.contmatic.model.constants.numericas.FuncionarioConstants.TAMANHO_DATA_NASCIMENTO;
import static br.com.contmatic.model.constants.numericas.FuncionarioConstants.TAMANHO_MAX_LISTA_EMAILS;
import static br.com.contmatic.model.constants.numericas.FuncionarioConstants.TAMANHO_MAX_LISTA_TELEFONES;
import static br.com.contmatic.model.constants.numericas.FuncionarioConstants.TAMANHO_MAX_NOME;
import static br.com.contmatic.model.constants.numericas.FuncionarioConstants.TAMANHO_MIN_NOME;
import static br.com.contmatic.model.constants.regex.BaseRegex.SOMENTE_LETRAS;
import static br.com.contmatic.model.constants.regex.BaseRegex.SOMENTE_NUMEROS;
import static br.com.contmatic.model.validacoes.Validador.validarCaracteresRepetidos;
import static br.com.contmatic.model.validacoes.Validador.validarListaVazia;
import static br.com.contmatic.model.validacoes.Validador.validarNulo;
import static br.com.contmatic.model.validacoes.Validador.validarRegex;
import static br.com.contmatic.model.validacoes.Validador.validarTamanho;
import static br.com.contmatic.model.validacoes.Validador.validarTamanhoMaximo;
import static br.com.contmatic.model.validacoes.Validador.validarTamanhoMaximoLista;
import static br.com.contmatic.model.validacoes.Validador.validarTamanhoMinimo;
import static br.com.contmatic.model.validacoes.Validador.validarVazio;
import static br.com.contmatic.model.validacoes.ValidadorCPF.validarCPF;
import static br.com.contmatic.model.validacoes.ValidadorData.validarDataNascimento;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import br.com.contmatic.model.auditoria.Auditoria;
import br.com.contmatic.model.contato.Email;
import br.com.contmatic.model.contato.Telefone;
import br.com.contmatic.model.endereco.Endereco;

public class Funcionario extends Auditoria {

	private String cpf;

	private String nome;

	private Cargo cargo;

	private String dataNacimento;

	private Endereco endereco;

	private Set<Telefone> telefones;

	private List<Email> emails;

	private Setor setor;
	
	public Funcionario(String cpf) {
		this.setCpf(cpf);
	}

	public Funcionario(String cpf, Setor setor) {
		this.setCpf(cpf);
		this.setSetor(setor);
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		validarNulo(cpf, MESSAGE_CPF_NOTNULL);
		validarVazio(cpf, MESSAGE_CPF_NOTBLANK);
		validarRegex(cpf, SOMENTE_NUMEROS, MESSAGE_CPF_REGEX);
		validarTamanho(cpf, TAMANHO_CPF, MESSAGE_TAMANHO_MAX_NOME);
		validarCaracteresRepetidos(cpf, MENSAGEM_CPF_CARACTERES_REPETIDOS);
		validarCPF(cpf);
		this.cpf = cpf;
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		validarNulo(endereco, MESSAGE_ENDERECO_NOTNULL);
		this.endereco = endereco;
	}

	public Set<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<Telefone> telefones) {
		validarNulo(telefones, MESSAGE_TELEFONES_NOT_NULL);
		validarListaVazia(telefones, MESSAGE_TELEFONES_IS_EMPTY);
		validarTamanhoMaximoLista(telefones, TAMANHO_MAX_LISTA_TELEFONES, MESSAGE_TELEFONES_LIST_MAX);
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

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		validarNulo(cargo, MESSAGE_CARGO_NOTNULL);
		this.cargo = cargo;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		validarNulo(setor, MESSAGE_SETOR_NOTNULL);
		this.setor = setor;
	}

	public String getDataNacimento() {
		return dataNacimento;
	}

	public void setDataNacimento(String dataNacimento) {
		validarNulo(dataNacimento, MESSAGE_DATA_NASCIMENTO_NOTNULL);
		validarVazio(dataNacimento, MESSAGE_DATA_NASCIMENTO_NOTBLANK);
		validarTamanho(dataNacimento, TAMANHO_DATA_NASCIMENTO, MESSAGE_TAMANHO_DATA_NASCIMENTO);
		validarRegex(dataNacimento, SOMENTE_NUMEROS, MESSAGE_DATA_NASCIMENTO_REGEX);
		validarDataNascimento(dataNacimento);
		this.dataNacimento = dataNacimento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(cpf, other.cpf);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Funcionario [cpf=");
		builder.append(cpf);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", cargo=");
		builder.append(cargo);
		builder.append(", dataNacimento=");
		builder.append(dataNacimento);
		builder.append(", endereco=");
		builder.append(endereco);
		builder.append(", telefones=");
		builder.append(telefones);
		builder.append(", emails=");
		builder.append(emails);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
}
