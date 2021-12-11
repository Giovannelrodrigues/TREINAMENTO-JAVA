package br.com.contmatic.util.validacoes;

import static br.com.contmatic.util.constants.Constants.IDADE_MINIMA;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public final class ValidadorData {

	private ValidadorData() {
	}
	//IMPORT STATIC

	public static void validarDataNascimento(String data) {
		LocalDate dateFormated = isDataValid(data);
		validateMinimumAge(dateFormated);
	}

	private static LocalDate isDataValid(String data) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
			return LocalDate.parse(data, formatter);
		} catch (Exception e) {
			throw new IllegalStateException("Data Invalida");
		}
	}

	private static void validateMinimumAge(LocalDate data) {
		LocalDate today = LocalDate.now();
		Period periodo = Period.between(data, today);
		if (periodo.getYears() < IDADE_MINIMA) {
			throw new IllegalStateException("Você não possui idade suficente. Você deve ter mais de " + IDADE_MINIMA);
		}
	}

}
