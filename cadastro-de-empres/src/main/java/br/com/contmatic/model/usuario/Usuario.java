package br.com.contmatic.model.usuario;

import static br.com.contmatic.util.constants.Constants.TAMANHO_MAX_SENHA_USUARIO;
import static br.com.contmatic.util.constants.Constants.TAMANHO_MIN_SENHA_USUARIO;
import static br.com.contmatic.util.constants.Message.MENSAGEM_SENHA_FRACA;
import static br.com.contmatic.util.validacoes.Validador.validarNulo;
import static br.com.contmatic.util.validacoes.Validador.validarRegex;
import static br.com.contmatic.util.validacoes.Validador.validarTamanhoMaximo;
import static br.com.contmatic.util.validacoes.Validador.validarTamanhoMinimo;
import static br.com.contmatic.util.validacoes.Validador.validarVazio;

import java.util.Objects;

import br.com.contmatic.model.Email;

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
		validarNulo(email);
		validarVazio(email);
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		validarNulo(senha);
		validarVazio(senha);
		validarTamanhoMaximo(senha, TAMANHO_MAX_SENHA_USUARIO);
		validarTamanhoMinimo(senha, TAMANHO_MIN_SENHA_USUARIO);
		validarRegex(senha, "(?=.*[a-z=])(?=.*[0-9])(?=.*[A-Z]).{8,30}", MENSAGEM_SENHA_FRACA);
		this.senha = senha;
	}


	@Override
	public String toString() {
		return "Usuario [emailUsuario=" + email + "]";
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

}
