package br.com.contmatic.util.validacoes;

import static br.com.contmatic.util.validacoes.Validador.calcularNumeroRegistro;
import static br.com.contmatic.util.validacoes.Validador.validarCaracteresRepetidos;
import static br.com.contmatic.util.validacoes.Validador.validarObjetoNulo;
import static br.com.contmatic.util.validacoes.Validador.validarSomenteNumero;
import static br.com.contmatic.util.validacoes.Validador.validarTamanho;

public final class ValidadorCPF {
	
	private static final String MENSAGEM_CPF_INVALIDO = "CPF inválido";
	
	private static final int TAMANHO_CPF = 11;
	
	private static final int DIVIDENTO_DIMINUENDO = 11;
	
	private static final int AJUSTE_TABELA_UNICODE = 48;
	
	private static final int DIGITO_VERIFICADOR = 9;
	
	private static final int LIMITE_SEQUENCIA_PRIMEIRO_DIGITO = 10;
	
	private static final int LIMITE_SEQUENCIA_SEGUNDO_DIGITO = 11;
	
	private static final int INDEX_PRIMEIRO_DIGITO = 9;
	
	private static final int INDEX_SEGUNDO_DIGITO = 10;
	
	
	private ValidadorCPF(){
	}
	
	public static void validarCPF(String cpf) {
		validarObjetoNulo(cpf);
		validarTamanho(cpf, TAMANHO_CPF);
		validarSomenteNumero(cpf);
		validarCaracteresRepetidos(cpf);
		validadorCPF(cpf);
	}
	
	private static void validadorCPF(String cpf) {
		int resultDigito1 = calcularNumeroRegistro(cpf, 2, LIMITE_SEQUENCIA_PRIMEIRO_DIGITO, true);
		int resultDigito2 = calcularNumeroRegistro(cpf, 1, LIMITE_SEQUENCIA_SEGUNDO_DIGITO, true);
		validarDigitos(cpf, resultDigito1, resultDigito2);
	}
	
	private static void validarDigitos(String cpf, int resultDigito1, int resultDigito2) {
		char digito1 = calcularDigitoVerificadorCPF(resultDigito1);
		char digito2 = calcularDigitoVerificadorCPF(resultDigito2);
		validarSeCpfEValido(cpf, digito1,  digito2);
	}
	
	private static char calcularDigitoVerificadorCPF(int resultDigito) {
		int result = DIVIDENTO_DIMINUENDO - (resultDigito % DIVIDENTO_DIMINUENDO);
		return (char) (result > DIGITO_VERIFICADOR? '0' : result + AJUSTE_TABELA_UNICODE);
	}
	
	private static void validarSeCpfEValido(String cpf, char digito1, char digito2) {
		if(cpf.charAt(INDEX_PRIMEIRO_DIGITO) != digito1 || cpf.charAt(INDEX_SEGUNDO_DIGITO) != digito2) {
			throw new IllegalStateException(MENSAGEM_CPF_INVALIDO);
		}
	}
	
}
