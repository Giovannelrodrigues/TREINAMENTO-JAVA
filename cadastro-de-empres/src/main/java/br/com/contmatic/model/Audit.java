package br.com.contmatic.model;

import static br.com.contmatic.util.validacoes.Validador.validarNulo;

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
		validarNulo(createdBy);
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		validarNulo(createDate);
		this.createDate = createDate;
	}

	public Email getLastByUpdadeNotify() {
		return lastByUpdadeNotify;
	}

	public void setLastByUpdadeNotify(Email lastByUpdadeNotify) {
		validarNulo(lastByUpdadeNotify);
		this.lastByUpdadeNotify = lastByUpdadeNotify;
	}

	public LocalDateTime getLastDateUpdadeNotify() {
		return lastDateUpdadeNotify;
	}

	public void setLastDateUpdadeNotify(LocalDateTime lastDateUpdadeNotify) {
		validarNulo(lastDateUpdadeNotify);
		this.lastDateUpdadeNotify = lastDateUpdadeNotify;
	}

	@Override
	public String toString() {
		return "Audit [createdBy=" + createdBy + ", createDate=" + createDate + ", lastByUpdadeNotify="
				+ lastByUpdadeNotify + ", lastDateUpdadeNotify=" + lastDateUpdadeNotify + "]";
	}

}
