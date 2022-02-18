package br.com.contmatic.model.commons;

import static br.com.contmatic.model.constants.EmailConstants.CARACTERE_OBRIGATORIO_EMAIL;
import static br.com.contmatic.model.constants.EmailConstants.TAMANHO_MAX_EMAIL;
import static br.com.contmatic.model.constants.EmailConstants.TAMANHO_MIN_EMAIL;
import static br.com.contmatic.model.constants.messages.EmailMessage.MESSAGE_CARACTERE_OBRIGATORIO;
import static br.com.contmatic.model.constants.messages.EmailMessage.MESSAGE_EMAIL_NOT_BLANK;
import static br.com.contmatic.model.constants.messages.EmailMessage.MESSAGE_EMAIL_NOT_NULL;
import static br.com.contmatic.model.constants.messages.EmailMessage.MESSAGE_TAMANHO_EMAIL_MAX;
import static br.com.contmatic.model.constants.messages.EmailMessage.MESSAGE_TAMANHO_EMAIL_MIN;
import static br.com.contmatic.model.validacoes.Validador.stringContain;
import static br.com.contmatic.model.validacoes.Validador.validarNulo;
import static br.com.contmatic.model.validacoes.Validador.validarTamanhoMaximo;
import static br.com.contmatic.model.validacoes.Validador.validarTamanhoMinimo;
import static br.com.contmatic.model.validacoes.Validador.validarVazio;

import java.util.Objects;

public class Email {

	private String enderecoEmail;

	public Email(String email) {
		this.setEmail(email);
	}

	public String getEmail() {
		return enderecoEmail;
	}

	public void setEmail(String email) {
		validarNulo(email, MESSAGE_EMAIL_NOT_NULL);
		validarVazio(email, MESSAGE_EMAIL_NOT_BLANK);
		validarTamanhoMaximo(email, TAMANHO_MAX_EMAIL, MESSAGE_TAMANHO_EMAIL_MAX);
		validarTamanhoMinimo(email, TAMANHO_MIN_EMAIL, MESSAGE_TAMANHO_EMAIL_MIN);
		stringContain(email, CARACTERE_OBRIGATORIO_EMAIL, MESSAGE_CARACTERE_OBRIGATORIO);
		this.enderecoEmail = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(enderecoEmail);
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
		return Objects.equals(enderecoEmail, other.enderecoEmail);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Email [enderecoEmail=");
		builder.append(enderecoEmail);
		builder.append("]");
		return builder.toString();
	}
}
