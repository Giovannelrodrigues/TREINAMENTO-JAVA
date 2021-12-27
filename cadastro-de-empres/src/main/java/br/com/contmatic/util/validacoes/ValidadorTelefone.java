package br.com.contmatic.util.validacoes;

import static br.com.contmatic.util.constants.Message.MENSAGEM_TAMANHO_INVALIDO_TELEFONE;

public final class ValidadorTelefone {
	
	private static final int TAMANHO_TELEFONE_FIXO = 10;

	private static final int TAMANHO_TELEFONE_CELULAR = 11;

	private ValidadorTelefone() {
	}

	public static void validarTamanhoTelefone(String telefone) {
		if (telefone.length() != TAMANHO_TELEFONE_FIXO && telefone.length() != TAMANHO_TELEFONE_CELULAR) {
			throw new IllegalStateException(MENSAGEM_TAMANHO_INVALIDO_TELEFONE);
		}
	}
}
