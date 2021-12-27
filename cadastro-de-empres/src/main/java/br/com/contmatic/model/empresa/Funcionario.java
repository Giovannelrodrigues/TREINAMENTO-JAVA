package br.com.contmatic.model.empresa;

import static br.com.contmatic.util.constants.Constants.REGEX_SOMENTE_LETRAS;
import static br.com.contmatic.util.constants.Constants.TAMANHO_CPF;
import static br.com.contmatic.util.constants.Constants.TAMANHO_DATA;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MAX_LISTA_EMAILS;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MAX_LISTA_TELEFONES;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MAX_NOME_FUNCIONARIO;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MIN_NOME_FUNCIONARIO;
import static br.com.contmatic.util.constants.Message.MENSAGEM_ERRO_REGEX_SOMENTE_LETRAS;
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
import static br.com.contmatic.util.validacoes.ValidadorCPF.validarCPF;
import static br.com.contmatic.util.validacoes.ValidadorData.validarDataNascimento;

import java.util.List;
import java.util.Objects;

import br.com.contmatic.model.Audit;
import br.com.contmatic.model.Email;
import br.com.contmatic.model.Endereco;
import br.com.contmatic.model.Telefone;

public class Funcionario extends Audit {

	private String cpf;

	private String nome;

	private Cargo cargo;

	private String dataNacimento;

	private Endereco endereco;

	private List<Telefone> telefones;

	private List<Email> emails;

	private Setor setor;

	public Funcionario(String cpf, Setor setor) {
		this.setCpf(cpf);
		this.setSetor(setor);
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		validarNulo(cpf);
		validarVazio(cpf);
		validarTamanho(cpf, TAMANHO_CPF);
		validarSomenteNumero(cpf);
		validarCaracteresRepetidos(cpf);
		validarCPF(cpf);
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		validarNulo(nome);
		validarVazio(nome);
		validarTamanhoMaximo(nome, TAMANHO_MAX_NOME_FUNCIONARIO);
		validarTamanhoMinimo(nome, TAMANHO_MIN_NOME_FUNCIONARIO);
		validarRegex(nome, REGEX_SOMENTE_LETRAS, MENSAGEM_ERRO_REGEX_SOMENTE_LETRAS);
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		validarNulo(endereco);
		this.endereco = endereco;
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

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		validarNulo(cargo);
		this.cargo = cargo;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		validarNulo(setor);
		this.setor = setor;
	}

	public String getDataNacimento() {
		return dataNacimento;
	}

	public void setDataNacimento(String dataNacimento) {
		validarNulo(dataNacimento);
		validarVazio(dataNacimento);
		validarTamanho(dataNacimento, TAMANHO_DATA);
		validarSomenteNumero(dataNacimento);
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
		return "Funcionario [cpf=" + cpf + ", nome=" + nome + ", cargo=" + cargo + ", dataNacimento=" + dataNacimento
				+ ", endereco=" + endereco + ", telefones=" + telefones + ", emails=" + emails + ", audit()="
				+ super.toString() + "]";
	}
}
