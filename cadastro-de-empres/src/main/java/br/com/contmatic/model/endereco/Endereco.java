package br.com.contmatic.model.endereco;

import static br.com.contmatic.model.constants.mensagens.EnderecoMessage.MESSAGE_BAIRRO_NOT_BLANK;
import static br.com.contmatic.model.constants.mensagens.EnderecoMessage.MESSAGE_BAIRRO_NOT_NULL;
import static br.com.contmatic.model.constants.mensagens.EnderecoMessage.MESSAGE_BAIRRO_REGEX;
import static br.com.contmatic.model.constants.mensagens.EnderecoMessage.MESSAGE_CEP_NOT_BLANK;
import static br.com.contmatic.model.constants.mensagens.EnderecoMessage.MESSAGE_CEP_NOT_NULL;
import static br.com.contmatic.model.constants.mensagens.EnderecoMessage.MESSAGE_CEP_SOMENTE_NUMEROS;
import static br.com.contmatic.model.constants.mensagens.EnderecoMessage.MESSAGE_CIDADE_NOT_NULL;
import static br.com.contmatic.model.constants.mensagens.EnderecoMessage.MESSAGE_COMPLEMENTO_NOT_BLANK;
import static br.com.contmatic.model.constants.mensagens.EnderecoMessage.MESSAGE_COMPLEMENTO_NOT_NULL;
import static br.com.contmatic.model.constants.mensagens.EnderecoMessage.MESSAGE_COMPLEMENTO_REGEX;
import static br.com.contmatic.model.constants.mensagens.EnderecoMessage.MESSAGE_ESTADO_NOT_NULL;
import static br.com.contmatic.model.constants.mensagens.EnderecoMessage.MESSAGE_LOGRADOURO_NOT_BLANK;
import static br.com.contmatic.model.constants.mensagens.EnderecoMessage.MESSAGE_LOGRADOURO_NOT_NULL;
import static br.com.contmatic.model.constants.mensagens.EnderecoMessage.MESSAGE_LOGRADOURO_REGEX;
import static br.com.contmatic.model.constants.mensagens.EnderecoMessage.MESSAGE_NUMERO_MAX;
import static br.com.contmatic.model.constants.mensagens.EnderecoMessage.MESSAGE_NUMERO_NOT_NULL;
import static br.com.contmatic.model.constants.mensagens.EnderecoMessage.MESSAGE_NUMERO_NOT_ZERO;
import static br.com.contmatic.model.constants.mensagens.EnderecoMessage.MESSAGE_TAMANHO_BAIRRO_MAX;
import static br.com.contmatic.model.constants.mensagens.EnderecoMessage.MESSAGE_TAMANHO_BAIRRO_MIN;
import static br.com.contmatic.model.constants.mensagens.EnderecoMessage.MESSAGE_TAMANHO_COMPLEMENTO_MAX;
import static br.com.contmatic.model.constants.mensagens.EnderecoMessage.MESSAGE_TAMANHO_COMPLEMENTO_MIN;
import static br.com.contmatic.model.constants.mensagens.EnderecoMessage.MESSAGE_TAMANHO_MAX_LOGRADOURO;
import static br.com.contmatic.model.constants.mensagens.EnderecoMessage.MESSAGE_TAMANHO_MIN_LOGRADOURO;
import static br.com.contmatic.model.constants.mensagens.EnderecoMessage.MESSAGE_TIPO_ENDERECO_NOT_NULL;
import static br.com.contmatic.model.constants.numericas.EnderecoConstants.NUMERO_MAX;
import static br.com.contmatic.model.constants.numericas.EnderecoConstants.TAMANHO_CEP;
import static br.com.contmatic.model.constants.numericas.EnderecoConstants.TAMANHO_MAX_BAIRRO;
import static br.com.contmatic.model.constants.numericas.EnderecoConstants.TAMANHO_MAX_COMPLEMENTO;
import static br.com.contmatic.model.constants.numericas.EnderecoConstants.TAMANHO_MAX_LOGRADOURO;
import static br.com.contmatic.model.constants.numericas.EnderecoConstants.TAMANHO_MIN_BAIRRO;
import static br.com.contmatic.model.constants.numericas.EnderecoConstants.TAMANHO_MIN_COMPLEMENTO;
import static br.com.contmatic.model.constants.numericas.EnderecoConstants.TAMANHO_MIN_LOGRADOURO;
import static br.com.contmatic.model.constants.regex.BaseRegex.ALFANUMERICO_PONTOS;
import static br.com.contmatic.model.constants.regex.BaseRegex.SOMENTE_LETRAS;
import static br.com.contmatic.model.constants.regex.BaseRegex.SOMENTE_NUMEROS;
import static br.com.contmatic.model.validacoes.Validador.validarNulo;
import static br.com.contmatic.model.validacoes.Validador.validarNumeroMaximo;
import static br.com.contmatic.model.validacoes.Validador.validarRegex;
import static br.com.contmatic.model.validacoes.Validador.validarTamanho;
import static br.com.contmatic.model.validacoes.Validador.validarTamanhoMaximo;
import static br.com.contmatic.model.validacoes.Validador.validarTamanhoMinimo;
import static br.com.contmatic.model.validacoes.Validador.validarVazio;
import static br.com.contmatic.model.validacoes.Validador.validarZero;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import br.com.contmatic.model.auditoria.Auditoria;

public class Endereco extends Auditoria {

	private String cep;

	private String logradouro;

	private Integer numero;

	private String bairro;

	private Cidade cidade;

	private Estado estado;

	private String complemento;

	private TipoEndereco tipoEndereco;
	
	public Endereco(String cep, String logradouro, Integer numero, String bairro, Cidade cidade, Estado estado, TipoEndereco tipoEndereco) {
		this.setCep(cep);
		this.setLogradouro(logradouro);
		this.setNumero(numero);
		this.setBairro(bairro);
		this.setCidade(cidade);
		this.setEstado(estado);
		this.setTipoEndereco(tipoEndereco);
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		validarNulo(cep, MESSAGE_CEP_NOT_NULL);
		validarVazio(cep, MESSAGE_CEP_NOT_BLANK);
		validarRegex(cep, SOMENTE_NUMEROS, MESSAGE_CEP_SOMENTE_NUMEROS);
		validarTamanho(cep, TAMANHO_CEP, MESSAGE_CEP_SOMENTE_NUMEROS);
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		validarNulo(logradouro, MESSAGE_LOGRADOURO_NOT_NULL);
		validarVazio(logradouro, MESSAGE_LOGRADOURO_NOT_BLANK);
		validarTamanhoMaximo(logradouro, TAMANHO_MAX_LOGRADOURO, MESSAGE_TAMANHO_MAX_LOGRADOURO);
		validarTamanhoMinimo(logradouro, TAMANHO_MIN_LOGRADOURO, MESSAGE_TAMANHO_MIN_LOGRADOURO);
		validarRegex(logradouro, ALFANUMERICO_PONTOS, MESSAGE_LOGRADOURO_REGEX);
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		validarNulo(complemento, MESSAGE_COMPLEMENTO_NOT_NULL);
		validarVazio(complemento, MESSAGE_COMPLEMENTO_NOT_BLANK);
		validarTamanhoMaximo(complemento, TAMANHO_MAX_COMPLEMENTO, MESSAGE_TAMANHO_COMPLEMENTO_MAX);
		validarTamanhoMinimo(complemento, TAMANHO_MIN_COMPLEMENTO, MESSAGE_TAMANHO_COMPLEMENTO_MIN);
		validarRegex(complemento, ALFANUMERICO_PONTOS, MESSAGE_COMPLEMENTO_REGEX);
		this.complemento = complemento;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		validarNulo(numero, MESSAGE_NUMERO_NOT_NULL);
		validarZero(numero, MESSAGE_NUMERO_NOT_ZERO);
		validarNumeroMaximo(numero, NUMERO_MAX, MESSAGE_NUMERO_MAX);
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		validarNulo(bairro, MESSAGE_BAIRRO_NOT_NULL);
		validarVazio(bairro, MESSAGE_BAIRRO_NOT_BLANK);
		validarTamanhoMaximo(bairro, TAMANHO_MAX_BAIRRO, MESSAGE_TAMANHO_BAIRRO_MAX);
		validarTamanhoMinimo(bairro, TAMANHO_MIN_BAIRRO, MESSAGE_TAMANHO_BAIRRO_MIN);
		validarRegex(bairro, SOMENTE_LETRAS, MESSAGE_BAIRRO_REGEX);
		this.bairro = bairro;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		validarNulo(cidade, MESSAGE_CIDADE_NOT_NULL);
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		validarNulo(estado, MESSAGE_ESTADO_NOT_NULL);
		this.estado = estado;
	}

	public TipoEndereco getTipoEndereco() {
		return tipoEndereco;
	}

	public void setTipoEndereco(TipoEndereco tipoEndereco) {
		validarNulo(tipoEndereco, MESSAGE_TIPO_ENDERECO_NOT_NULL);
		this.tipoEndereco = tipoEndereco;
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
