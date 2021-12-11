package br.com.contmatic.util.validacoes;

import static br.com.contmatic.util.constants.Message.MENSAGEM_CPF_INVALIDO;
import static br.com.contmatic.util.validacoes.Validador.calcularNumeroRegistro;

public final class ValidadorCPF {

	private static final int DIVIDENTO_DIMINUENDO = 11;

	private static final int AJUSTE_TABELA_UNICODE = 48;

	private static final int DIGITO_VERIFICADOR = 9;

	private static final int LIMITE_SEQUENCIA_PRIMEIRO_DIGITO = 10;

	private static final int LIMITE_SEQUENCIA_SEGUNDO_DIGITO = 11;

	private static final int INDEX_PRIMEIRO_DIGITO = 9;

	private static final int INDEX_SEGUNDO_DIGITO = 10;

	private static final int QUANTIDADE_DE_DIGITOS_PRIMEIRO_CALCULO = 2;

	private static final int QUANTIDADE_DE_DIGITOS_SEGUNGO_CALCULO = 1;

	private static final boolean INVERTER_CARACTERES = true;

	private ValidadorCPF() {
	}

	public static void validarCPF(String cpf) {
		int resultDigito1 = calcularNumeroRegistro(cpf, QUANTIDADE_DE_DIGITOS_PRIMEIRO_CALCULO,
				LIMITE_SEQUENCIA_PRIMEIRO_DIGITO, INVERTER_CARACTERES);
		int resultDigito2 = calcularNumeroRegistro(cpf, QUANTIDADE_DE_DIGITOS_SEGUNGO_CALCULO,
				LIMITE_SEQUENCIA_SEGUNDO_DIGITO, INVERTER_CARACTERES);
		validarDigitos(cpf, resultDigito1, resultDigito2);
	}

	private static void validarDigitos(String cpf, int resultDigito1, int resultDigito2) {
		char digito1 = calcularDigitoVerificadorCPF(resultDigito1);
		char digito2 = calcularDigitoVerificadorCPF(resultDigito2);
		validarSeCpfEValido(cpf, digito1, digito2);
	}

	private static char calcularDigitoVerificadorCPF(int resultDigito) {
		int result = DIVIDENTO_DIMINUENDO - (resultDigito % DIVIDENTO_DIMINUENDO);
		return (char) (result > DIGITO_VERIFICADOR ? '0' : result + AJUSTE_TABELA_UNICODE);
	}

	private static void validarSeCpfEValido(String cpf, char digito1, char digito2) {
		if (cpf.charAt(INDEX_PRIMEIRO_DIGITO) != digito1 || cpf.charAt(INDEX_SEGUNDO_DIGITO) != digito2) {
			throw new IllegalStateException(MENSAGEM_CPF_INVALIDO);
		}
	}

}
