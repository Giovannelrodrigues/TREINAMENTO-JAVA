package br.com.contmatic.model.auditoria;

import static br.com.contmatic.model.constants.mensagens.AuditMessage.MESSAGE_CREATED_BY_NOT_NULL;
import static br.com.contmatic.model.constants.mensagens.AuditMessage.MESSAGE_CREATED_DATE_NOT_NULL;
import static br.com.contmatic.model.constants.mensagens.AuditMessage.MESSAGE_CREATED_IP_NOT_BLANK;
import static br.com.contmatic.model.constants.mensagens.AuditMessage.MESSAGE_CREATED_IP_NOT_NULL;
import static br.com.contmatic.model.constants.mensagens.AuditMessage.MESSAGE_REGEX_IP;
import static br.com.contmatic.model.constants.mensagens.AuditMessage.MESSAGE_UPDATED_BY_NOT_NULL;
import static br.com.contmatic.model.constants.mensagens.AuditMessage.MESSAGE_UPDATED_DATE_NOT_NULL;
import static br.com.contmatic.model.constants.mensagens.AuditMessage.MESSAGE_UPDATED_IP_NOT_BLANK;
import static br.com.contmatic.model.constants.mensagens.AuditMessage.MESSAGE_UPDATED_IP_NOT_NULL;
import static br.com.contmatic.model.constants.regex.AuditRegex.REGEX_IP;
import static br.com.contmatic.model.validacoes.Validador.validarNulo;
import static br.com.contmatic.model.validacoes.Validador.validarRegex;
import static br.com.contmatic.model.validacoes.Validador.validarVazio;
import static br.com.contmatic.model.validacoes.ValidadorData.validarDataAntiga;
import static br.com.contmatic.model.validacoes.ValidadorData.validarMaxDate;

import java.time.LocalDateTime;

import org.apache.commons.lang3.builder.ToStringBuilder;

import br.com.contmatic.model.contato.Email;

public abstract class Auditoria {

	private Email createdBy;

	private LocalDateTime createDate;

	private String createdIp;

	private Email updatedBy;

	private LocalDateTime updatedDate;

	private String updatedIp;

	public Email getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Email createdBy) {
		validarNulo(createdBy, MESSAGE_CREATED_BY_NOT_NULL);
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		validarNulo(createDate, MESSAGE_CREATED_DATE_NOT_NULL);
		validarDataAntiga(createDate);
		validarMaxDate(createDate);
		this.createDate = createDate;
	}

	public String getCreatedIp() {
		return createdIp;
	}

	public void setCreatedIp(String createdIp) {
		validarNulo(createdIp, MESSAGE_CREATED_IP_NOT_NULL);
		validarVazio(createdIp, MESSAGE_CREATED_IP_NOT_BLANK);
		validarRegex(createdIp, REGEX_IP, MESSAGE_REGEX_IP);
		this.createdIp = createdIp;
	}

	public Email getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdateBy(Email updateBy) {
		validarNulo(updateBy, MESSAGE_UPDATED_BY_NOT_NULL);
		this.updatedBy = updateBy;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		validarNulo(updatedDate, MESSAGE_UPDATED_DATE_NOT_NULL);
		validarDataAntiga(updatedDate);
		validarMaxDate(updatedDate);
		this.updatedDate = updatedDate;
	}

	public String getUpdatedIp() {
		return updatedIp;
	}

	public void setUpdatedIp(String updatedIp) {
		validarNulo(updatedIp, MESSAGE_UPDATED_IP_NOT_NULL);
		validarVazio(updatedIp, MESSAGE_UPDATED_IP_NOT_BLANK);
		validarRegex(updatedIp, REGEX_IP, MESSAGE_REGEX_IP);
		this.updatedIp = updatedIp;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
