package br.com.contmatic.testes.validacoes;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import br.com.contmatic.model.Cargo;
import br.com.contmatic.model.Contato;
import br.com.contmatic.model.Endereco;
import br.com.contmatic.model.Funcionario;

@RunWith(Parameterized.class)
public class TestesValidadorCpf {
	
	private final String input;
	
	private final Contato contato = new Contato("gio@contmatic.com", "11996300338");
	
	private final Endereco endereco = new Endereco("12243670", "Rua Major Vaz", "Predio empresa", 157, "Vila Adyana", "São paulo", "São paulo");
	
	private final Cargo cargo = new Cargo("Programador", "desenvolver aplicações");
	
	private final Funcionario funcionario = new Funcionario("Giovanne Lisboa Rodrigues", "67523518052", endereco, contato, cargo);

	
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{"35004500008"}, {"350.045.000-08"}, {"67520008BCA"}, {"675200"}, {"00000000000"}, {"11111111111"}, {"22222222222"}, {"33333333333"}, {"44444444444"}, {"55555555555"}, {"66666666666"}, {"77777777777"}, {"88888888888"}, {"99999999999"}
		});
	}
	
	public TestesValidadorCpf(String input) {
		this.input = input;
	}
	
	@Test (expected = IllegalStateException.class)
	public void testeA_nao_deve_atribuir_nenhum_valor_ao_cpf_digitando_valores_invalidos() {
		funcionario.setCpf(input);
	}
	
}