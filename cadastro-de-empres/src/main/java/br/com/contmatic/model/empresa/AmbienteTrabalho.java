package br.com.contmatic.model.empresa;

import static br.com.contmatic.util.constants.Constants.REGEX_SOMENTE_LETRAS;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MAX_DESCRICAO_AMBIENTE_TRABALHO;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MAX_LISTA_ENDERECOS_AMBIENTE_TRABALHO;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MAX_LISTA_SETORES_AMBIENTE_TRABALHO;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MAX_NOME_AMBIENTE_TRABALHO;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MIN_DESCRICAO_AMBIENTE_TRABALHO;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MIN_NOME_AMBIENTE_TRABALHO;
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

import br.com.contmatic.enums.TipoEstabelecimento;
import br.com.contmatic.model.Audit;
import br.com.contmatic.model.Email;
import br.com.contmatic.model.Endereco;

public class AmbienteTrabalho extends Audit {

	private String nome;

	private String descricao;

	private TipoEstabelecimento tipoEstabelecimento;

	private List<Setor> setores;

	private List<Endereco> enderecos;

	private Empresa empresa;

	public AmbienteTrabalho(Email email, LocalDateTime dataCriacao, String nome, Empresa empresa) {
		super(email, dataCriacao);
		this.setNome(nome);
		this.setEmpresa(empresa);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		validarNulo(nome);
		validarVazio(nome);
		validarTamanhoMaximo(nome, TAMANHO_MAX_NOME_AMBIENTE_TRABALHO);
		validarTamanhoMinimo(nome, TAMANHO_MIN_NOME_AMBIENTE_TRABALHO);
		validarRegex(nome, REGEX_SOMENTE_LETRAS, nome);
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		validarNulo(descricao);
		validarVazio(descricao);
		validarTamanhoMaximo(descricao, TAMANHO_MAX_DESCRICAO_AMBIENTE_TRABALHO);
		validarTamanhoMinimo(descricao, TAMANHO_MIN_DESCRICAO_AMBIENTE_TRABALHO);
		this.descricao = descricao;
	}

	public TipoEstabelecimento getTipoEstabelecimento() {
		return this.tipoEstabelecimento;
	}

	public void setTipoEstabelecimento(TipoEstabelecimento tipoEstabelecimento) {
		validarNulo(tipoEstabelecimento);
		this.tipoEstabelecimento = tipoEstabelecimento;
	}

	public List<Setor> getSetores() {
		return this.setores;
	}

	public void setSetores(List<Setor> setores) {
		validarNulo(setores);
		validarListaVazia(setores);
		validarTamanhoMaximoLista(setores, TAMANHO_MAX_LISTA_SETORES_AMBIENTE_TRABALHO);
		this.setores = setores;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		validarNulo(enderecos);
		validarListaVazia(enderecos);
		validarTamanhoMaximoLista(enderecos, TAMANHO_MAX_LISTA_ENDERECOS_AMBIENTE_TRABALHO);
		this.enderecos = enderecos;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		validarNulo(empresa);
		this.empresa = empresa;
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
		AmbienteTrabalho other = (AmbienteTrabalho) obj;
		return Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "AmbienteTrabalho [nome=" + nome + ", descricao=" + descricao + ", tipoEstabelecimento="
				+ tipoEstabelecimento + ", setores=" + setores + ", enderecos=" + enderecos + ", empresa=" + empresa
				+ "]";
	}

}
