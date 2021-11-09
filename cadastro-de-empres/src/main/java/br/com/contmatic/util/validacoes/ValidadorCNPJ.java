package br.com.contmatic.util.validacoes;

import static br.com.contmatic.util.validacoes.Validador.calcularNumeroRegistro;
import static br.com.contmatic.util.validacoes.Validador.validarCaracteresRepetidos;
import static br.com.contmatic.util.validacoes.Validador.validarObjetoNulo;
import static br.com.contmatic.util.validacoes.Validador.validarSomenteNumero;
import static br.com.contmatic.util.validacoes.Validador.validarTamanho;

public final class ValidadorCNPJ {
	
	private static final String MENSAGEM_CNPJ_INVALIDO = "CNPJ inválido";
	
	private static final int TAMANHO_CNPJ = 14;
	
	private static final int LIMITE_SEQUENCIA = 9;
	
	private static final int INDEX_PRIMEIRO_DIGITO = 12;
	
	private static final int INDEX_SEGUNDO_DIGITO = 13;
	
	private static final int DIMINUENDO_DIVIDENDO = 11;
	
	private static final int AJUSTE_TABELA_UNICODE = 48;
	
	private static final int DIGITO_VERIFICADOR = 9;
	
	private ValidadorCNPJ() {
	}
	
	public static void validarCNPJ(String cnpj) {
		validarObjetoNulo(cnpj);
		validarTamanho(cnpj, TAMANHO_CNPJ);
		validarSomenteNumero(cnpj);
		validarCaracteresRepetidos(cnpj);
		validadorCNPJ(cnpj);
	}
	
	private static void validadorCNPJ(String cnpj) {
		int resultDigito1 = calcularNumeroRegistro(cnpj, 2, LIMITE_SEQUENCIA, true);
		int resultDigito2 = calcularNumeroRegistro(cnpj, 1, LIMITE_SEQUENCIA, true);
		validarDigitos(cnpj, resultDigito1, resultDigito2);
	}
	
	private static void validarDigitos(String cnpj, int resultDigito1, int resultDigito2) {
		char digito1 = calcularDigitoVerificadorCNPJ(resultDigito1);
		char digito2 = calcularDigitoVerificadorCNPJ(resultDigito2);
		validarSeCnpjEValido(cnpj, digito1, digito2);
	}
	
	private static char calcularDigitoVerificadorCNPJ(int resultDigito) {
		int result = DIMINUENDO_DIVIDENDO - (resultDigito % DIMINUENDO_DIVIDENDO);
		return (char) (result > DIGITO_VERIFICADOR? '0' : result + AJUSTE_TABELA_UNICODE);
	}
	
	private static void validarSeCnpjEValido(String cnpj, char digito1, char digito2) {
		if(cnpj.charAt(INDEX_PRIMEIRO_DIGITO) != digito1 || cnpj.charAt(INDEX_SEGUNDO_DIGITO) != digito2) {
			throw new IllegalStateException(MENSAGEM_CNPJ_INVALIDO);
		}
	}
}
