package br.com.contmatic.model.contato;

import static br.com.contmatic.model.constants.messages.TelefoneMessage.MESSAGE_TELEFONE_NOT_BLANK;
import static br.com.contmatic.model.constants.messages.TelefoneMessage.MESSAGE_TELEFONE_NOT_NULL;
import static br.com.contmatic.model.constants.messages.TelefoneMessage.MESSAGE_TELEFONE_SOMENTE_NUMERROS;
import static br.com.contmatic.model.constants.messages.TelefoneMessage.MESSAGE_TIPO_TELEFONE_NOT_NULL;
import static br.com.contmatic.model.constants.regex.BaseRegex.SOMENTE_NUMEROS;
import static br.com.contmatic.model.validacoes.Validador.validarNulo;
import static br.com.contmatic.model.validacoes.Validador.validarRegex;
import static br.com.contmatic.model.validacoes.Validador.validarVazio;
import static br.com.contmatic.model.validacoes.ValidadorTelefone.validarTamanhoTelefone;

import java.util.Objects;

import br.com.contmatic.model.auditoria.Audit;

public class Telefone extends Audit {

	private String numeroTelefone;

	private TipoTelefone tipoTelefone;

	public Telefone(String numeroTelefone) {
		this.setTelefone(numeroTelefone);
	}

	public Telefone(String numeroTelefone, TipoTelefone tipoTelefone) {
		this(numeroTelefone);
		this.setTipoTelefone(tipoTelefone);
	}

	public String getTelefone() {
		return numeroTelefone;
	}

	public void setTelefone(String numeroTelefone) {
		validarNulo(numeroTelefone, MESSAGE_TELEFONE_NOT_NULL);
		validarVazio(numeroTelefone, MESSAGE_TELEFONE_NOT_BLANK);
		validarRegex(numeroTelefone, SOMENTE_NUMEROS, MESSAGE_TELEFONE_SOMENTE_NUMERROS);
		validarTamanhoTelefone(numeroTelefone);
		this.numeroTelefone = numeroTelefone;
	}

	public TipoTelefone getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(TipoTelefone tipoTelefone) {
		validarNulo(tipoTelefone, MESSAGE_TIPO_TELEFONE_NOT_NULL);
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
		StringBuilder builder = new StringBuilder();
		builder.append("Telefone [numeroTelefone=");
		builder.append(numeroTelefone);
		builder.append(", tipoTelefone=");
		builder.append(tipoTelefone);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
