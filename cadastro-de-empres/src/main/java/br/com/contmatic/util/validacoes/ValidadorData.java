package br.com.contmatic.util.validacoes;

import static br.com.contmatic.util.constants.Constants.IDADE_MINIMA;
import static br.com.contmatic.util.constants.Message.DATA_INVALIDA;
import static br.com.contmatic.util.constants.Message.MENSAGEM_IDADE_MINIMA;
import static java.time.LocalDate.now;
import static java.time.LocalDate.parse;
import static java.time.Period.between;
import static java.time.format.DateTimeFormatter.ofPattern;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public final class ValidadorData {

	private static final String FORMATO = "ddMMyyyy";

	private ValidadorData() {
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
			throw new IllegalStateException(DATA_INVALIDA);
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
