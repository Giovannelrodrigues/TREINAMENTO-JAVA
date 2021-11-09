package br.com.contmatic.testes.validacoes;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import br.com.contmatic.model.Contato;
import br.com.contmatic.model.Empresa;
import br.com.contmatic.model.Endereco;

@RunWith(Parameterized.class)
public class ValidadorCnpjTeste {
	
	
	private final String input;
	
	private final Contato contato = new Contato("gio@contmatic.com", "11996300338");
	
	private final Endereco endereco = new Endereco("12243670", "Rua Major Vaz", "Predio empresa", 157, "Vila Adyana", "São paulo", "São paulo");
	
	private final Empresa empresa = new Empresa("SOFTMATIC ... LTDA", "58119371000177", "Contmatic phoenix", endereco, contato);
	
	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{"58119354785501"}, {"58.119.354/7855-01"}, {"5811937100AA"}, {"5811937100"}, {"11111111111111"}, {"22222222222222"}, {"33333333333333"}, {"44444444444444"}, {"55555555555555"}, {"66666666666666"},{"77777777777777"}, {"88888888888888"}, {"99999999999999"}, {"00000000000000"} 
		});
	}
	
	public ValidadorCnpjTeste(String input) {
		this.input = input;
	}
	
	@Test (expected = IllegalStateException.class)
	public void testeA_nao_deve_atribuir_valor_cnpj_passando_campos_invalidos(){
		empresa.setCnpj(input);
	}
}

