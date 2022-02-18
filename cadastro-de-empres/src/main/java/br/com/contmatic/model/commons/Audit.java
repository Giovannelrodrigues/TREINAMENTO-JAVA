package br.com.contmatic.model.commons;

import static br.com.contmatic.model.constants.messages.AuditMessage.MESSAGE_CREATEDATE_NOT_NULL;
import static br.com.contmatic.model.constants.messages.AuditMessage.MESSAGE_CREATEDBY_NOT_NULL;
import static br.com.contmatic.model.constants.messages.AuditMessage.MESSAGE_LASTBYUPDATE_NOT_NULL;
import static br.com.contmatic.model.constants.messages.AuditMessage.MESSAGE_LASTDATEUPDATE_NOT_NULL;
import static br.com.contmatic.model.validacoes.Validador.validarNulo;

import java.time.LocalDateTime;

public class Audit {

	private Email createdBy;

	private LocalDateTime createDate;

	private Email lastByUpdadeNotify;

	private LocalDateTime lastDateUpdadeNotify;

	public Email getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Email createdBy) {
		validarNulo(createdBy, MESSAGE_CREATEDBY_NOT_NULL);
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		validarNulo(createDate, MESSAGE_CREATEDATE_NOT_NULL);
		this.createDate = createDate;
	}

	public Email getLastByUpdadeNotify() {
		return lastByUpdadeNotify;
	}

	public void setLastByUpdadeNotify(Email lastByUpdadeNotify) {
		validarNulo(lastByUpdadeNotify, MESSAGE_LASTBYUPDATE_NOT_NULL);
		this.lastByUpdadeNotify = lastByUpdadeNotify;
	}

	public LocalDateTime getLastDateUpdadeNotify() {
		return lastDateUpdadeNotify;
	}

	public void setLastDateUpdadeNotify(LocalDateTime lastDateUpdadeNotify) {
		validarNulo(lastDateUpdadeNotify, MESSAGE_LASTDATEUPDATE_NOT_NULL);
		this.lastDateUpdadeNotify = lastDateUpdadeNotify;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Audit [createdBy=");
		builder.append(createdBy);
		builder.append(", createDate=");
		builder.append(createDate);
		builder.append(", lastByUpdadeNotify=");
		builder.append(lastByUpdadeNotify);
		builder.append(", lastDateUpdadeNotify=");
		builder.append(lastDateUpdadeNotify);
		builder.append("]");
		return builder.toString();
	}
}
