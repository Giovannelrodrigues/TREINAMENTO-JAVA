package br.com.contmatic.model;

import static br.com.contmatic.util.validacoes.Validador.validarNulo;

import java.time.LocalDateTime;
import java.util.Objects;

public class Audit {

	private Email createdBy;

	private LocalDateTime createDate;

	private Email lastByUpdadeNotify;

	private LocalDateTime lastDateUpdadeNotify;

	public Audit(Email email, LocalDateTime dataCriacao) {
		this.setCreatedBy(email);
		this.setCreateDate(dataCriacao);
	}

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
	public int hashCode() {
		return Objects.hash(createDate, createdBy);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Audit other = (Audit) obj;
		return Objects.equals(createDate, other.createDate) && Objects.equals(createdBy, other.createdBy);
	}

	@Override
	public String toString() {
		return "Audit [createdBy=" + createdBy + ", createDate=" + createDate + ", lastByUpdadeNotify="
				+ lastByUpdadeNotify + ", lastDateUpdadeNotify=" + lastDateUpdadeNotify + "]";
	}

}
