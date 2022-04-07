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

import java.util.Objects;

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
	public int hashCode() {
		return Objects.hash(endereco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Email other = (Email) obj;
		return Objects.equals(endereco, other.endereco);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Email [endereco=");
		builder.append(endereco);
		builder.append(", tipo=");
		builder.append(tipo);
		builder.append("]");
		return builder.toString();
	}
}
