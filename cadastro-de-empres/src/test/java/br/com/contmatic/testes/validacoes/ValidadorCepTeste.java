package br.com.contmatic.testes.validacoes;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import br.com.contmatic.model.Endereco;

@RunWith(Parameterized.class)
public class ValidadorCepTeste {
	
	private final String input;
	
	private final Endereco endereco = new Endereco("12243670", "Rua Major Vaz", "Predio empresa", 157, "Vila Adyana", "São paulo", "São paulo");
	
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{"123456"}, {"1234567891011"}, {"123456AAA"}, {"12.365.240-56"}
		});
	}
	
	public ValidadorCepTeste(String input) {
		this.input = input;
	}
	
	@Test (expected = IllegalStateException.class)
	public void testeA_nao_deve_atribuir_nenhum_valor_ao_cep_digitando_valores_invalidos() {
		endereco.setCep(input);
	}
	
}