package br.com.contmatic.model.usuario;

import static br.com.contmatic.model.constants.UsuarioConstants.TAMANHO_MAX_SENHA;
import static br.com.contmatic.model.constants.UsuarioConstants.TAMANHO_MIN_SENHA;
import static br.com.contmatic.model.constants.messages.UsuarioMessage.MENSAGEM_SENHA_FRACA;
import static br.com.contmatic.model.constants.messages.UsuarioMessage.MESSAGE_EMAIL_NOTNULL;
import static br.com.contmatic.model.constants.messages.UsuarioMessage.MESSAGE_SENHA_NOTBLANK;
import static br.com.contmatic.model.constants.messages.UsuarioMessage.MESSAGE_SENHA_NOTNULL;
import static br.com.contmatic.model.constants.messages.UsuarioMessage.MESSAGE_TAMANHO_MAX_SENHA;
import static br.com.contmatic.model.constants.messages.UsuarioMessage.MESSAGE_TAMANHO_MIN_SENHA;
import static br.com.contmatic.model.constants.regex.UsuarioRegex.REGEX_SENHA;
import static br.com.contmatic.model.validacoes.Validador.validarNulo;
import static br.com.contmatic.model.validacoes.Validador.validarRegex;
import static br.com.contmatic.model.validacoes.Validador.validarTamanhoMaximo;
import static br.com.contmatic.model.validacoes.Validador.validarTamanhoMinimo;
import static br.com.contmatic.model.validacoes.Validador.validarVazio;

import java.util.Objects;

import br.com.contmatic.model.contato.Email;

public class Usuario {

	private Email email;

	private String senha;

	public Usuario(Email email, String senha) {
		this.setEmail(email);
		this.setSenha(senha);
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		validarNulo(email, MESSAGE_EMAIL_NOTNULL);
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		validarNulo(senha, MESSAGE_SENHA_NOTNULL);
		validarVazio(senha, MESSAGE_SENHA_NOTBLANK);
		validarTamanhoMaximo(senha, TAMANHO_MAX_SENHA, MESSAGE_TAMANHO_MAX_SENHA);
		validarTamanhoMinimo(senha, TAMANHO_MIN_SENHA, MESSAGE_TAMANHO_MIN_SENHA);
		validarRegex(senha, REGEX_SENHA, MENSAGEM_SENHA_FRACA);
		this.senha = senha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(email, other.email);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Usuario [email=");
		builder.append(email);
		builder.append(", senha=");
		builder.append(senha);
		builder.append("]");
		return builder.toString();
	}	
}
