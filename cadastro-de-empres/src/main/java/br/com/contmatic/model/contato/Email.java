package br.com.contmatic.model.contato;

import static br.com.contmatic.model.constants.mensagens.EmailMessage.MESSAGE_EMAIL_NOT_BLANK;
import static br.com.contmatic.model.constants.mensagens.EmailMessage.MESSAGE_EMAIL_NOT_NULL;
import static br.com.contmatic.model.constants.mensagens.EmailMessage.MESSAGE_REGEX_EMAIL;
import static br.com.contmatic.model.constants.mensagens.EmailMessage.MESSAGE_TAMANHO_EMAIL_MAX;
import static br.com.contmatic.model.constants.mensagens.EmailMessage.MESSAGE_TAMANHO_EMAIL_MIN;
import static br.com.contmatic.model.constants.mensagens.EmailMessage.MESSAGE_TIPO_NOT_NULL;
import static br.com.contmatic.model.constants.numericas.EmailConstants.TAMANHO_MAX_EMAIL;
import static br.com.contmatic.model.constants.numericas.EmailConstants.TAMANHO_MIN_EMAIL;
import static br.com.contmatic.model.constants.regex.EmailRegex.REGEX_EMAIL;
import static br.com.contmatic.model.validacoes.Validador.validarNulo;
import static br.com.contmatic.model.validacoes.Validador.validarRegex;
import static br.com.contmatic.model.validacoes.Validador.validarTamanhoMaximo;
import static br.com.contmatic.model.validacoes.Validador.validarTamanhoMinimo;
import static br.com.contmatic.model.validacoes.Validador.validarVazio;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Email {

	private String endereco;

	private TipoEmail tipo;

	public Email(String email) {
		this.setEndereco(email);
	}

	public Email(String email, TipoEmail tipo) {
		this.setEndereco(email);
		this.setTipo(tipo);
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String enderecoEmail) {
		validarNulo(enderecoEmail, MESSAGE_EMAIL_NOT_NULL);
		validarVazio(enderecoEmail, MESSAGE_EMAIL_NOT_BLANK);
		validarTamanhoMaximo(enderecoEmail, TAMANHO_MAX_EMAIL, MESSAGE_TAMANHO_EMAIL_MAX);
		validarTamanhoMinimo(enderecoEmail, TAMANHO_MIN_EMAIL, MESSAGE_TAMANHO_EMAIL_MIN);
		validarRegex(enderecoEmail, REGEX_EMAIL, MESSAGE_REGEX_EMAIL);
		this.endereco = enderecoEmail;
	}

	public TipoEmail getTipo() {
		return tipo;
	}

	public void setTipo(TipoEmail tipo) {
		validarNulo(tipo, MESSAGE_TIPO_NOT_NULL);
		this.tipo = tipo;
	}
	
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj, "tipo");
	}
	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, "tipo");
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
