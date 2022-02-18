package br.com.contmatic.model.validacoes;

public final class ValidadorTelefone {
	
	private static final String MENSAGEM_TAMANHO_INVALIDO_TELEFONE = "Telefone n�o pode ter tamanho diferente de 10 ou 11 caracteres";
	
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
