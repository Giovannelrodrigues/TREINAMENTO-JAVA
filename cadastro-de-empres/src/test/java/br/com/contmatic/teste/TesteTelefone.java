package br.com.contmatic.teste;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.contmatic.enums.TipoTelefone;
import br.com.contmatic.model.Email;
import br.com.contmatic.model.Telefone;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteTelefone {

	private static Telefone telefoneBefore;
	
	private static final Email EMAIL = new Email("giovannelrodrigues@gmail.com");

	private static final String TELEFONE = "1195845635";
	
	private static final LocalDateTime LOCAL_TIME = LocalDateTime.of(2017, Month.FEBRUARY,3,6,30,40,50000);

	@Before
	public void antesDeCadaTeste() {
		telefoneBefore = new Telefone(EMAIL, LOCAL_TIME ,TELEFONE, TipoTelefone.CELULAR);
	}

	// CONSTRUTOR
	@Test
	public void teste01_deve_instaciar_um_telefone_corretamente_campos_obrigatorios() {
		Telefone telefone = new Telefone(EMAIL, LOCAL_TIME, TELEFONE);
		assertEquals(TELEFONE, telefone.getTelefone());
	}

	@Test
	public void teste02_deve_instaciar_um_telefone_corretamente_todos_campos() {
		assertEquals(TELEFONE, telefoneBefore.getTelefone());
		assertEquals(TipoTelefone.CELULAR, telefoneBefore.getTipoTelefone());
	}

	// TELEFONE
	@Test
	public void teste03_deve_atribuir_um_novo_valor_para_telefone() {
		String telefone = "1159587630";
		telefoneBefore.setTelefone(telefone);
		assertEquals(telefone, telefoneBefore.getTelefone());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste04_nao_deve_atribuir_um_novo_valor_para_telefone_passando_nulo() {
		telefoneBefore.setTelefone(null);
	}

	@Test(expected = IllegalStateException.class)
	public void teste05_nao_deve_atribuir_um_novo_valor_para_telefone_passando_vazio() {
		telefoneBefore.setTelefone("   ");
	}

	@Test(expected = IllegalStateException.class)
	public void teste06_nao_deve_atribuir_um_novo_valor_para_telefone_passando_caracteres_diferentes_de_numeros() {
		telefoneBefore.setTelefone("123abcdfee");
	}

	@Test(expected = IllegalStateException.class)
	public void teste07_nao_deve_atribuir_um_novo_valor_para_telefone_passando_menos_de_10_caracteres() {
		telefoneBefore.setTelefone("123456789");
	}

	@Test(expected = IllegalStateException.class)
	public void teste08_nao_deve_atribuir_um_novo_valor_para_telefone_passando_mais_de_11_caracteres() {
		telefoneBefore.setTelefone("1234567891011");
	}

	// TIPO TELEFONE
	@Test
	public void teste09_deve_atribuir_um_novo_valor_para_tipo_telefone() {
		TipoTelefone tipoTelefone = TipoTelefone.COMERCIAL;
		telefoneBefore.setTipoTelefone(tipoTelefone);
		assertEquals(tipoTelefone, telefoneBefore.getTipoTelefone());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste10_nao_deve_atribuir_um_novo_valor_para_tipo_telefone_passando_nulo() {
		telefoneBefore.setTelefone(null);
	}

	// TO STRING
	@Test
	public void teste11_deve_retornar_telefone_ao_usar_to_string() {
		String result = telefoneBefore.toString();
		assertThat(result, containsString(telefoneBefore.getTelefone()));
	}

	@Test
	public void teste12_deve_retornar_tipo_telefone_ao_usar_to_string() {
		String result = telefoneBefore.toString();
		assertThat(result, containsString(String.valueOf(telefoneBefore.getTipoTelefone())));
	}

	// HASHCODE
	@Test
	public void teste13_deve_retornar_o_mesmo_hashcode_para_telefones_que_sao_iguais() {
		Telefone telefone1 = new Telefone(EMAIL, LOCAL_TIME, TELEFONE);
		Telefone telefone2 = new Telefone(EMAIL, LOCAL_TIME, TELEFONE);
		boolean resp = telefone1.hashCode() == telefone2.hashCode();
		assertTrue(resp);
	}

	@Test
	public void teste14_deve_retornar_false_no_hashcode_para_telefones_diferentes() {
		Telefone telefone1 = new Telefone(EMAIL, LOCAL_TIME, TELEFONE);
		Telefone telefone2 = new Telefone(EMAIL, LOCAL_TIME, "11959160668");
		boolean resp = telefone1.hashCode() == telefone2.hashCode();
		assertFalse(resp);
	}

	// EQUALS
	@Test
	public void teste15_deve_retornar_true_quando_usar_equals_passado_telefones_iguais() {
		Telefone telefone1 = new Telefone(EMAIL, LOCAL_TIME, "1159160668");
		Telefone telefone2 = new Telefone(EMAIL, LOCAL_TIME, "1159160668");
		boolean resp = telefone1.equals(telefone2);
		assertTrue(resp);
	}

	@Test
	public void teste16_deve_retornar_falso_quando_usar_equals_passado_nulo() {
		boolean resp = telefoneBefore.equals(null);
		assertFalse(resp);
	}

	@Test
	public void teste17_deve_retornar_falso_quando_usar_equals_passado_object() {
		boolean resp = telefoneBefore.equals(new Object());
		assertFalse(resp);
	}

	@Test
	public void teste18_deve_retornar_true_quando_usar_equals_passado_o_proprio_objeto() {
		boolean resp = telefoneBefore.equals(telefoneBefore);
		assertTrue(resp);
	}

}
