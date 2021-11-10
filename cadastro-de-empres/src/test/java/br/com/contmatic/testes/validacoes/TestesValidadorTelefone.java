package br.com.contmatic.testes.validacoes;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import br.com.contmatic.model.Contato;

@RunWith(Parameterized.class)
public class TestesValidadorTelefone {
	
	private final String input;
	
	private final Contato contato = new Contato("gio@contmatic.com", "11996300338");
	
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{"164.156"}, {"12345"}, {"1234567891011"}, {"123ABC456"}
		});
	}
	
	public TestesValidadorTelefone(String input) {
		this.input = input;
	}
	
	@Test (expected = IllegalStateException.class)
	public void testeA_nao_deve_atribuir_nenhum_valor_ao_telefone_digitando_valores_invalidos() {
		contato.setTelefone(input);
	}
	
}