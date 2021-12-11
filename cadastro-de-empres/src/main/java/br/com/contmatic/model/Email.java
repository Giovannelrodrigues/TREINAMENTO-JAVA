package br.com.contmatic.model;

import static br.com.contmatic.util.constants.Constants.CARACTERE_OBRIGATORIO_EMAIL;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MAX_EMAIL;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MIN_EMAIL;
import static br.com.contmatic.util.validacoes.Validador.stringContain;
import static br.com.contmatic.util.validacoes.Validador.validarNulo;
import static br.com.contmatic.util.validacoes.Validador.validarTamanhoMaximo;
import static br.com.contmatic.util.validacoes.Validador.validarTamanhoMinimo;
import static br.com.contmatic.util.validacoes.Validador.validarVazio;

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
		validarNulo(email);
		validarVazio(email);
		validarTamanhoMaximo(email, TAMANHO_MAX_EMAIL);
		validarTamanhoMinimo(email, TAMANHO_MIN_EMAIL);
		stringContain(email, CARACTERE_OBRIGATORIO_EMAIL);
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
		return "Email [email=" + enderecoEmail + "]";
	}
}
