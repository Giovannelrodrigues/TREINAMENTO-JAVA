package br.com.contmatic.util.validacoes;

import static br.com.contmatic.util.constants.Message.MENSAGEM_CNPJ_INVALIDO;
import static br.com.contmatic.util.validacoes.Validador.calcularNumeroRegistro;

public final class ValidadorCNPJ {

	private static final int LIMITE_SEQUENCIA = 9;

	private static final int INDEX_PRIMEIRO_DIGITO = 12;

	private static final int INDEX_SEGUNDO_DIGITO = 13;

	private static final int DIMINUENDO_DIVIDENDO = 11;

	private static final int AJUSTE_TABELA_UNICODE = 48;

	private static final int DIGITO_VERIFICADOR = 9;

	private static final int QUANTIDADE_DE_DIGITOS_PRIMEIRO_CALCULO = 2;

	private static final int QUANTIDADE_DE_DIGITOS_SEGUNGO_CALCULO = 1;

	private static final boolean INVERTER_CARACTERES = true;

	private ValidadorCNPJ() {
	}

	public static void validarCNPJ(String cnpj) {
		int resultDigito1 = calcularNumeroRegistro(cnpj, QUANTIDADE_DE_DIGITOS_PRIMEIRO_CALCULO, LIMITE_SEQUENCIA,
				INVERTER_CARACTERES);
		int resultDigito2 = calcularNumeroRegistro(cnpj, QUANTIDADE_DE_DIGITOS_SEGUNGO_CALCULO, LIMITE_SEQUENCIA,
				INVERTER_CARACTERES);
		calcularDigitosBase(cnpj, resultDigito1, resultDigito2);

	}

	private static void calcularDigitosBase(String cnpj, int resultDigito1, int resultDigito2) {
		char digito1 = calcularDigitoVerificadorCNPJ(resultDigito1);
		char digito2 = calcularDigitoVerificadorCNPJ(resultDigito2);
		cnpjEValido(cnpj, digito1, digito2);
	}

	private static char calcularDigitoVerificadorCNPJ(int resultDigito) {
		int result = DIMINUENDO_DIVIDENDO - (resultDigito % DIMINUENDO_DIVIDENDO);
		return (char) (result > DIGITO_VERIFICADOR ? '0' : result + AJUSTE_TABELA_UNICODE);
	}

	private static void cnpjEValido(String cnpj, char digito1, char digito2) {
		if (cnpj.charAt(INDEX_PRIMEIRO_DIGITO) != digito1 || cnpj.charAt(INDEX_SEGUNDO_DIGITO) != digito2) {
			throw new IllegalStateException(MENSAGEM_CNPJ_INVALIDO);
		}
	}

}
