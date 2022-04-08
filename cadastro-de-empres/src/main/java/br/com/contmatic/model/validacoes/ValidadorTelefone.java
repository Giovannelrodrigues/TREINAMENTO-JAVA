package br.com.contmatic.model.validacoes;

public final class ValidadorTelefone {
	
	private static final String MENSAGEM_TAMANHO_INVALIDO_TELEFONE = "Telefone inválido";
	
	private static final int TAMANHO_TELEFONE_FIXO = 8;

	private static final int TAMANHO_TELEFONE_CELULAR = 9;
	
	private static final int TAMANHO_TELEFONE_COMERCIAL = 11;

	private ValidadorTelefone() {
	}

	public static void validarTamanhoTelefone(String telefone) {
		if (telefone.length() != TAMANHO_TELEFONE_FIXO && telefone.length() != TAMANHO_TELEFONE_CELULAR && telefone.length() != TAMANHO_TELEFONE_COMERCIAL) {
			throw new IllegalStateException(MENSAGEM_TAMANHO_INVALIDO_TELEFONE);
		}
	}
}
