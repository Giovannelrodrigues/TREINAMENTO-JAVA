package br.com.contmatic.model.contato;

import static br.com.contmatic.model.constants.mensagens.TelefoneMessage.MESSAGE_DDD_NOT_BLANK;
import static br.com.contmatic.model.constants.mensagens.TelefoneMessage.MESSAGE_DDD_NOT_NULL;
import static br.com.contmatic.model.constants.mensagens.TelefoneMessage.MESSAGE_DDD_REGEX;
import static br.com.contmatic.model.constants.mensagens.TelefoneMessage.MESSAGE_DDI_NOT_BLANK;
import static br.com.contmatic.model.constants.mensagens.TelefoneMessage.MESSAGE_DDI_NOT_NULL;
import static br.com.contmatic.model.constants.mensagens.TelefoneMessage.MESSAGE_DDI_REGEX;
import static br.com.contmatic.model.constants.mensagens.TelefoneMessage.MESSAGE_TELEFONE_NOT_BLANK;
import static br.com.contmatic.model.constants.mensagens.TelefoneMessage.MESSAGE_TELEFONE_NOT_NULL;
import static br.com.contmatic.model.constants.mensagens.TelefoneMessage.MESSAGE_TELEFONE_SOMENTE_NUMERROS;
import static br.com.contmatic.model.constants.mensagens.TelefoneMessage.MESSAGE_TIPO_TELEFONE_NOT_NULL;
import static br.com.contmatic.model.constants.regex.BaseRegex.SOMENTE_NUMEROS;
import static br.com.contmatic.model.constants.regex.TelefoneRegex.REGEX_DDD;
import static br.com.contmatic.model.constants.regex.TelefoneRegex.REGEX_DDI;
import static br.com.contmatic.model.validacoes.Validador.validarNulo;
import static br.com.contmatic.model.validacoes.Validador.validarRegex;
import static br.com.contmatic.model.validacoes.Validador.validarVazio;
import static br.com.contmatic.model.validacoes.ValidadorTelefone.validarTamanhoTelefone;

import java.util.Objects;

import br.com.contmatic.model.auditoria.Auditoria;

public class Telefone extends Auditoria {
	
	private String ddi;
	
	private String ddd;
	
	private String numero;

	private TipoTelefone tipo;

	public Telefone(String ddi, String ddd, String numero) {
		this.setDdi(ddi);
		this.setDdd(ddd);
		this.setNumero(numero);
	}

	public Telefone(String ddi, String ddd, String numero, TipoTelefone tipo) {
		this(ddi, ddd, numero);
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
	
	
	public String getDdi() {
		return ddi;
	}

	public void setDdi(String ddi) {
		validarNulo(ddi, MESSAGE_DDI_NOT_NULL);
		validarVazio(ddi, MESSAGE_DDI_NOT_BLANK);
		validarRegex(ddi, REGEX_DDI, MESSAGE_DDI_REGEX);
		this.ddi = ddi;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		validarNulo(ddd, MESSAGE_DDD_NOT_NULL);
		validarVazio(ddd, MESSAGE_DDD_NOT_BLANK);
		validarRegex(ddd, REGEX_DDD, MESSAGE_DDD_REGEX);
		this.ddd = ddd;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ddd, ddi, numero);
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
		return Objects.equals(ddd, other.ddd) && Objects.equals(ddi, other.ddi) && Objects.equals(numero, other.numero);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Telefone [ddi=");
		builder.append(ddi);
		builder.append(", ddd=");
		builder.append(ddd);
		builder.append(", numero=");
		builder.append(numero);
		builder.append(", tipo=");
		builder.append(tipo);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
}
