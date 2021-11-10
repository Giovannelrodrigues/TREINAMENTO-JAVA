package br.com.contmatic.model;

import static br.com.contmatic.util.validacoes.Validador.validarAtributoGenerico;
import static br.com.contmatic.util.validacoes.Validador.validarObjetoNulo;
import static br.com.contmatic.util.validacoes.Validador.validarTelefone;

import java.util.Objects;

import br.com.contmatic.enums.TipoTelefone;

public class Contato {
	
	private String telefone;
	
	private String email;
	
	private TipoTelefone tipo;
	
	public Contato(String email, String telefone) {
		this.setEmail(email);
		this.setTelefone(telefone);
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		validarTelefone(telefone);
		if(telefone.length() == 10) {
			this.setTipoTelefone(TipoTelefone.FIXO);
		} else {
			this.setTipoTelefone(TipoTelefone.CELULAR);
		}
		this.telefone = telefone;
	}
	
	public TipoTelefone getTipoTelefone() {
		return this.tipo;
	}
	
	private void setTipoTelefone(TipoTelefone telefoneTipo) {
		validarObjetoNulo(telefoneTipo);
		this.tipo = telefoneTipo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		validarAtributoGenerico(email);
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Contato [telefone=" + telefone + ", email=" + email + ", tipo=" + tipo + "]";
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
		Contato other = (Contato) obj;
		return Objects.equals(email, other.email);
	}
	
}
