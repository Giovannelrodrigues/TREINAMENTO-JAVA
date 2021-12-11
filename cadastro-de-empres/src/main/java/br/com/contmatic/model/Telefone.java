package br.com.contmatic.model;

import static br.com.contmatic.util.validacoes.Validador.validarNulo;
import static br.com.contmatic.util.validacoes.Validador.validarSomenteNumero;
import static br.com.contmatic.util.validacoes.Validador.validarVazio;
import static br.com.contmatic.util.validacoes.ValidadorTelefone.validarTamanhoTelefone;

import java.time.LocalDateTime;
import java.util.Objects;

import br.com.contmatic.enums.TipoTelefone;

public class Telefone extends Audit {

	private String numeroTelefone;

	private TipoTelefone tipoTelefone;

	public Telefone(Email email, LocalDateTime dataCriacao, String numeroTelefone) {
		super(email, dataCriacao);
		this.setTelefone(numeroTelefone);
	}

	public Telefone(Email email, LocalDateTime dataCriacao, String numeroTelefone, TipoTelefone tipoTelefone) {
		this(email, dataCriacao, numeroTelefone);
		this.setTipoTelefone(tipoTelefone);
	}

	public String getTelefone() {
		return numeroTelefone;
	}

	public void setTelefone(String numeroTelefone) {
		validarNulo(numeroTelefone);
		validarVazio(numeroTelefone);
		validarSomenteNumero(numeroTelefone);
		validarTamanhoTelefone(numeroTelefone);
		this.numeroTelefone = numeroTelefone;
	}

	public TipoTelefone getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(TipoTelefone tipoTelefone) {
		validarNulo(tipoTelefone);
		this.tipoTelefone = tipoTelefone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numeroTelefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefone other = (Telefone) obj;
		return Objects.equals(numeroTelefone, other.numeroTelefone);
	}

	@Override
	public String toString() {
		return "Telefone [numeroTelefone=" + numeroTelefone + ", tipoTelefone=" + tipoTelefone + "]";
	}

}
