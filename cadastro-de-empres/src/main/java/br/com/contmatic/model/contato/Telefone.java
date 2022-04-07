package br.com.contmatic.model.contato;

import static br.com.contmatic.model.constants.mensagens.TelefoneMessage.MESSAGE_TELEFONE_NOT_BLANK;
import static br.com.contmatic.model.constants.mensagens.TelefoneMessage.MESSAGE_TELEFONE_NOT_NULL;
import static br.com.contmatic.model.constants.mensagens.TelefoneMessage.MESSAGE_TELEFONE_SOMENTE_NUMERROS;
import static br.com.contmatic.model.constants.mensagens.TelefoneMessage.MESSAGE_TIPO_TELEFONE_NOT_NULL;
import static br.com.contmatic.model.constants.regex.BaseRegex.SOMENTE_NUMEROS;
import static br.com.contmatic.model.validacoes.Validador.validarNulo;
import static br.com.contmatic.model.validacoes.Validador.validarRegex;
import static br.com.contmatic.model.validacoes.Validador.validarVazio;
import static br.com.contmatic.model.validacoes.ValidadorTelefone.validarTamanhoTelefone;

import java.util.Objects;

import br.com.contmatic.model.auditoria.Auditoria;

public class Telefone extends Auditoria {
	
	private String numero;

	private TipoTelefone tipo;

	public Telefone(String numero) {
		this.setNumero(numero);
	}

	public Telefone(String numeroTelefone, TipoTelefone tipo) {
		this(numeroTelefone);
		this.setTipoTelefone(tipo);
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		validarNulo(numero, MESSAGE_TELEFONE_NOT_NULL);
		validarVazio(numero, MESSAGE_TELEFONE_NOT_BLANK);
		validarRegex(numero, SOMENTE_NUMEROS, MESSAGE_TELEFONE_SOMENTE_NUMERROS);
		validarTamanhoTelefone(numero);
		this.numero = numero;
	}

	public TipoTelefone getTipoTelefone() {
		return tipo;
	}

	public void setTipoTelefone(TipoTelefone tipo) {
		validarNulo(tipo, MESSAGE_TIPO_TELEFONE_NOT_NULL);
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero);
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
		return Objects.equals(numero, other.numero);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Telefone [numero=");
		builder.append(numero);
		builder.append(", tipo=");
		builder.append(tipo);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
}
