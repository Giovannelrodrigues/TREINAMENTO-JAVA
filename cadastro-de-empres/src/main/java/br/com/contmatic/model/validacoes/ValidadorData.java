package br.com.contmatic.model.validacoes;

import static java.time.LocalDate.now;
import static java.time.LocalDate.parse;
import static java.time.Period.between;
import static java.time.format.DateTimeFormatter.ofPattern;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public final class ValidadorData {

	private static final Integer IDADE_MINIMA = 14;

	private static final String FORMATO = "ddMMyyyy";

	private static final String MENSAGEM_DATA_INVALIDA = "Data Inválida";

	private static final String MENSAGEM_DATA_ANTEIROR_HOJE = "Data Inválida, não aceita data anterior a hoje.";

	private static final String MENSAGEM_DATA_MAX = "Data Inválida, data não pode ser maior que dois anos, apartir de hoje";

	private static final String MENSAGEM_IDADE_MINIMA = "Você não possui idade suficente. Você deve ter mais de 14 anos";

	private ValidadorData() {
	}

	public static void validarDataAntiga(LocalDateTime dateTime) {
		if (dateTime.isBefore(LocalDateTime.now())) {
			throw new IllegalStateException(MENSAGEM_DATA_ANTEIROR_HOJE);
		}
	}

	public static void validarMaxDate(LocalDateTime dateTime) {
		LocalDateTime today = LocalDateTime.now();
		LocalDateTime max = LocalDateTime.of(today.getYear() + 2, today.getMonth(), today.getDayOfMonth(),
				today.getHour(), today.getMinute(), today.getSecond(), today.getNano());
		if (max.isBefore(dateTime)) {
			throw new IllegalStateException(MENSAGEM_DATA_MAX);
		}
	}

	public static void validarDataNascimento(String data) {
		LocalDate dateFormated = isDataValid(data);
		validateMinimumAge(dateFormated);
	}

	private static LocalDate isDataValid(String data) {
		try {
			DateTimeFormatter formatter = ofPattern(FORMATO);
			return parse(data, formatter);
		} catch (Exception e) {
			throw new IllegalStateException(MENSAGEM_DATA_INVALIDA);
		}
	}

	private static void validateMinimumAge(LocalDate data) {
		LocalDate today = now();
		Period periodo = between(data, today);
		if (periodo.getYears() < IDADE_MINIMA) {
			throw new IllegalStateException(MENSAGEM_IDADE_MINIMA);
		}
	}
}
