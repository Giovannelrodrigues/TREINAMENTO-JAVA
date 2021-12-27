package br.com.contmatic.model;

import static br.com.contmatic.util.constants.Constants.NUMERO_MAX_ENDERECO;
import static br.com.contmatic.util.constants.Constants.REGEX_LETRAS_NUMEROS_PONTOS;
import static br.com.contmatic.util.constants.Constants.REGEX_SOMENTE_LETRAS;
import static br.com.contmatic.util.constants.Constants.TAMANHO_CEP;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MAX_BAIRRO_ENDERECO;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MAX_COMPLEMENTO_ENDERECO;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MAX_LOGRADOURO_ENDERECO;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MIN_BAIRRO_ENDERECO;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MIN_COMPLEMENTO_ENDERECO;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MIN_LOGRADOURO_ENDERECO;
import static br.com.contmatic.util.constants.Message.MENSAGEM_ERRO_REGEX_LETRAS_NUMEROS;
import static br.com.contmatic.util.constants.Message.MENSAGEM_ERRO_REGEX_SOMENTE_LETRAS;
import static br.com.contmatic.util.validacoes.Validador.validarNulo;
import static br.com.contmatic.util.validacoes.Validador.validarNumeroMaximo;
import static br.com.contmatic.util.validacoes.Validador.validarRegex;
import static br.com.contmatic.util.validacoes.Validador.validarSomenteNumero;
import static br.com.contmatic.util.validacoes.Validador.validarTamanho;
import static br.com.contmatic.util.validacoes.Validador.validarTamanhoMaximo;
import static br.com.contmatic.util.validacoes.Validador.validarTamanhoMinimo;
import static br.com.contmatic.util.validacoes.Validador.validarVazio;
import static br.com.contmatic.util.validacoes.Validador.validarZero;

import java.util.Objects;

import br.com.contmatic.enums.TipoEndereco;

public class Endereco extends Audit {

	private String cep;

	private String logradouro;

	private Integer numero;

	private String bairro;

	private Cidade cidade;

	private Estado estado;

	private String complemento;

	private TipoEndereco tipoEndereco;

	public Endereco(String cep, String logradouro, int numero, String bairro, Cidade cidade, Estado estado,
			TipoEndereco tipoEndereco) {
		this.setCep(cep);
		this.setLogradouro(logradouro);
		this.setNumero(numero);
		this.setBairro(bairro);
		this.setCidade(cidade);
		this.setEstado(estado);
		this.setTipoEndereco(tipoEndereco);
	}

	public Endereco(String cep, String logradouro, String complemento, int numero, String bairro, Cidade cidade,
			Estado estado, TipoEndereco tipoEndereco) {
		this(cep, logradouro, numero, bairro, cidade, estado, tipoEndereco);
		this.setComplemento(complemento);
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		validarNulo(cep);
		validarVazio(cep);
		validarSomenteNumero(cep);
		validarTamanho(cep, TAMANHO_CEP);
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		validarNulo(logradouro);
		validarVazio(logradouro);
		validarTamanhoMaximo(logradouro, TAMANHO_MAX_LOGRADOURO_ENDERECO);
		validarTamanhoMinimo(logradouro, TAMANHO_MIN_LOGRADOURO_ENDERECO);
		validarRegex(logradouro, REGEX_LETRAS_NUMEROS_PONTOS, MENSAGEM_ERRO_REGEX_LETRAS_NUMEROS);
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		validarNulo(complemento);
		validarVazio(complemento);
		validarTamanhoMaximo(complemento, TAMANHO_MAX_COMPLEMENTO_ENDERECO);
		validarTamanhoMinimo(complemento, TAMANHO_MIN_COMPLEMENTO_ENDERECO);
		validarRegex(complemento, REGEX_LETRAS_NUMEROS_PONTOS, MENSAGEM_ERRO_REGEX_LETRAS_NUMEROS);
		this.complemento = complemento;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		validarNulo(numero);
		validarZero(numero);
		validarNumeroMaximo(numero, NUMERO_MAX_ENDERECO);
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		validarNulo(bairro);
		validarVazio(bairro);
		validarTamanhoMaximo(bairro, TAMANHO_MAX_BAIRRO_ENDERECO);
		validarTamanhoMinimo(bairro, TAMANHO_MIN_BAIRRO_ENDERECO);
		validarRegex(bairro, REGEX_SOMENTE_LETRAS, MENSAGEM_ERRO_REGEX_SOMENTE_LETRAS);
		this.bairro = bairro;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		validarNulo(cidade);
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		validarNulo(estado);
		this.estado = estado;
	}

	public TipoEndereco getTipoEndereco() {
		return tipoEndereco;
	}

	public void setTipoEndereco(TipoEndereco tipoEndereco) {
		validarNulo(tipoEndereco);
		this.tipoEndereco = tipoEndereco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bairro, cep, cidade, complemento, logradouro, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(obj, other);
	}

	@Override
	public String toString() {
		return "Endereco [cep=" + cep + ", logradouro=" + logradouro + ", numero=" + numero + ", bairro=" + bairro
				+ ", estado=" + ", cidade=" + cidade + ", complemento=" + complemento + ", tipoEndereco=" + tipoEndereco
				+ ", audit()=" + super.toString() + "]";
	}
}
