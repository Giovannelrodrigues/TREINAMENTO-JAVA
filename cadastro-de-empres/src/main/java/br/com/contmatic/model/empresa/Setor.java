package br.com.contmatic.model.empresa;

import static br.com.contmatic.util.constants.Constants.REGEX_SOMENTE_LETRAS;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MAX_DESCRICAO_SETOR;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MAX_LISTA_FUNCIONARIOS_SETOR;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MAX_NOME_SETOR;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MIN_DESCRICAO_SETOR;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MIN_NOME_SETOR;
import static br.com.contmatic.util.constants.Message.MENSAGEM_ERRO_REGEX_SOMENTE_LETRAS;
import static br.com.contmatic.util.validacoes.Validador.validarListaVazia;
import static br.com.contmatic.util.validacoes.Validador.validarNulo;
import static br.com.contmatic.util.validacoes.Validador.validarRegex;
import static br.com.contmatic.util.validacoes.Validador.validarTamanhoMaximo;
import static br.com.contmatic.util.validacoes.Validador.validarTamanhoMaximoLista;
import static br.com.contmatic.util.validacoes.Validador.validarTamanhoMinimo;
import static br.com.contmatic.util.validacoes.Validador.validarVazio;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import br.com.contmatic.model.Audit;
import br.com.contmatic.model.Email;

public class Setor extends Audit {

	private String nome;

	private String descricao;

	private List<Funcionario> funcionarios;

	private AmbienteTrabalho ambienteTrabalho;

	public Setor(Email email, LocalDateTime dataCriacao, String nome, AmbienteTrabalho ambienteTrabalho) {
		super(email, dataCriacao);
		this.setNome(nome);
		this.setAmbienteTrabalho(ambienteTrabalho);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		validarNulo(nome);
		validarVazio(nome);
		validarTamanhoMaximo(nome, TAMANHO_MAX_NOME_SETOR);
		validarTamanhoMinimo(nome, TAMANHO_MIN_NOME_SETOR);
		validarRegex(nome, REGEX_SOMENTE_LETRAS, MENSAGEM_ERRO_REGEX_SOMENTE_LETRAS);
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		validarNulo(descricao);
		validarVazio(descricao);
		validarTamanhoMaximo(descricao, TAMANHO_MAX_DESCRICAO_SETOR);
		validarTamanhoMinimo(descricao, TAMANHO_MIN_DESCRICAO_SETOR);
		this.descricao = descricao;
	}

	public List<Funcionario> getFuncionarios() {
		return this.funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionario) {
		validarNulo(funcionario);
		validarListaVazia(funcionario);
		validarTamanhoMaximoLista(funcionario, TAMANHO_MAX_LISTA_FUNCIONARIOS_SETOR);
		this.funcionarios = funcionario;
	}

	public AmbienteTrabalho getAmbienteTrabalho() {
		return ambienteTrabalho;
	}

	public void setAmbienteTrabalho(AmbienteTrabalho ambienteTrabalho) {
		validarNulo(ambienteTrabalho);
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
		Setor other = (Setor) obj;
		return Objects.equals(ambienteTrabalho, other.ambienteTrabalho) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Setor [nome=" + nome + ", descricao=" + descricao + ", funcionarios=" + funcionarios + "]";
	}
	
}
