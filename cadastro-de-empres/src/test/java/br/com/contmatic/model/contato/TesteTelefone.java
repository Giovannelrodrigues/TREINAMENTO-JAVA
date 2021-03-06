package br.com.contmatic.model.contato;

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

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteTelefone {

	private static Telefone telefoneBefore;

	private static final Email EMAIL = new Email("giovannelrodrigues@gmail.com");

	private static final String TELEFONE = "95845635";

	private static final String IP = "122.21.123.1";

	private static final LocalDateTime LOCAL_TIME = LocalDateTime.of(2023, Month.JUNE, 28, 6, 30, 40, 50000);

	@Before
	public void teste00_antes_de_cada_teste() {
		telefoneBefore = new Telefone("+55", "11", TELEFONE, TipoTelefone.CELULAR);
		telefoneBefore.setCreatedBy(EMAIL);
		telefoneBefore.setCreateDate(LOCAL_TIME);
		telefoneBefore.setCreatedBy(EMAIL);
		telefoneBefore.setUpdatedDate(LOCAL_TIME);
		telefoneBefore.setCreatedIp(IP);
		telefoneBefore.setUpdatedIp(IP);
	}

	// CONSTRUTOR
	@Test
	public void teste01_deve_um_telefone_corretamente_campos_obrigatorios() {
		Telefone telefone = new Telefone("+55", "11", TELEFONE);
		assertEquals(TELEFONE, telefone.getNumero());
	}

	@Test
	public void teste02_deve_instaciar_um_telefone_corretamente_todos_campos() {
		Telefone telefone = new Telefone("+55", "11", TELEFONE, TipoTelefone.CELULAR);
		assertEquals(TELEFONE, telefone.getNumero());
		assertEquals(TipoTelefone.CELULAR, telefone.getTipoTelefone());
	}

	// TELEFONE
	@Test
	public void teste03_deve_setar_numero() {
		String telefone = "11595876";
		telefoneBefore.setNumero(telefone);
		assertEquals(telefone, telefoneBefore.getNumero());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste04_nao_deve_setar_numero_passando_nulo() {
		telefoneBefore.setNumero(null);
	}

	@Test(expected = IllegalStateException.class)
	public void teste05_nao_deve_setar_numero_passando_vazio() {
		telefoneBefore.setNumero("   ");
	}

	@Test(expected = IllegalStateException.class)
	public void teste06_nao_deve_setar_numero_passando_caracteres_diferentes_de_numeros() {
		telefoneBefore.setNumero("123abcdfee");
	}

	@Test(expected = IllegalStateException.class)
	public void teste07_nao_deve_setar_numero_passando_menos_de_8_caracteres() {
		telefoneBefore.setNumero("12345");
	}

	@Test(expected = IllegalStateException.class)
	public void teste08_nao_deve_setar_numero_passando_mais_de_11_caracteres() {
		telefoneBefore.setNumero("1234567891011");
	}

	// TIPOTELEFONE
	@Test
	public void teste09_deve_setar_tipo_telefone() {
		TipoTelefone tipoTelefone = TipoTelefone.COMERCIAL;
		telefoneBefore.setTipoTelefone(tipoTelefone);
		assertEquals(tipoTelefone, telefoneBefore.getTipoTelefone());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste10_nao_deve_setar_tipo_telefone_passando_nulo() {
		telefoneBefore.setTipoTelefone(null);
	}

	// DDI
	@Test
	public void teste09_deve_setar_ddi() {
		String ddi = "+55";
		telefoneBefore.setDdi(ddi);
		;
		assertEquals(ddi, telefoneBefore.getDdi());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste10_nao_deve_setar_ddi_passando_nulo() {
		telefoneBefore.setDdi(null);
		;
	}

	@Test(expected = IllegalStateException.class)
	public void teste11_nao_deve_setar_ddi_passando_vazio() {
		telefoneBefore.setDdi("   ");
		;
	}

	@Test(expected = IllegalStateException.class)
	public void teste12_nao_deve_setar_ddi_sem_passa_prefixo_mais() {
		telefoneBefore.setDdi("44");
	}

	@Test
	public void teste13_deve_setar_ddd() {
		String ddd = "11";
		telefoneBefore.setDdd(ddd);
		;
		assertEquals(ddd, telefoneBefore.getDdd());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste14_nao_deve_setar_ddd_passando_nulo() {
		telefoneBefore.setDdd(null);
		;
	}

	@Test(expected = IllegalStateException.class)
	public void teste15_nao_deve_setar_ddd_passando_vazio() {
		telefoneBefore.setDdd("   ");
		;
	}

	// TO STRING
	@Test
	public void teste11_deve_retornar_telefone_ao_usar_to_string() {
		String result = telefoneBefore.toString();
		assertThat(result, containsString(telefoneBefore.getNumero()));
	}

	@Test
	public void teste12_deve_retornar_tipo_telefone_ao_usar_to_string() {
		String result = telefoneBefore.toString();
		assertThat(result, containsString(String.valueOf(telefoneBefore.getTipoTelefone())));
	}

	@Test
	public void teste13_deve_retornar_dados_auditoria_ao_usar_to_string() {
		String result = telefoneBefore.toString();
		assertThat(result, containsString(String.valueOf(telefoneBefore.getCreatedBy())));
	}

	// HASHCODE
	@Test
	public void teste13_deve_retornar_o_mesmo_hashcode_para_telefones_que_sao_iguais() {
		Telefone telefone1 = new Telefone("+55", "11", TELEFONE);
		Telefone telefone2 = new Telefone("+55", "11", TELEFONE);
		boolean resp = telefone1.hashCode() == telefone2.hashCode();
		assertTrue(resp);
	}

	@Test
	public void teste14_deve_retornar_false_no_hashcode_para_telefones_diferentes() {
		Telefone telefone1 = new Telefone("+55", "11", TELEFONE);
		Telefone telefone2 = new Telefone("+55", "11", "95916668");
		boolean resp = telefone1.hashCode() == telefone2.hashCode();
		assertFalse(resp);
	}

	@Test
	public void teste15_deve_retornar_o_mesmo_hashcode_para_telefones_que_sao_iguais_tipos_diferentes() {
		Telefone telefone1 = new Telefone("+55", "11", TELEFONE, TipoTelefone.CELULAR);
		Telefone telefone2 = new Telefone("+55", "11", TELEFONE, TipoTelefone.COMERCIAL);
		boolean resp = telefone1.hashCode() == telefone2.hashCode();
		assertTrue(resp);
	}

	// EQUALS
	@Test
	public void teste16_deve_retornar_true_quando_usar_equals_passado_telefones_iguais() {
		Telefone telefone1 = new Telefone("+55", "11", "59160668");
		Telefone telefone2 = new Telefone("+55", "11", "59160668");
		boolean resp = telefone1.equals(telefone2);
		assertTrue(resp);
	}

	@Test
	public void teste17_deve_retornar_false_quando_usar_equals_passado_telefones_diferentes() {
		Telefone telefone1 = new Telefone("+55", "11", "59160668");
		Telefone telefone2 = new Telefone("+55", "11", "59666668");
		boolean resp = telefone1.equals(telefone2);
		assertFalse(resp);
	}

	@Test
	public void teste18_deve_retornar_true_quando_usar_equals_passado_telefones_iguais_de_tipos_diferentes() {
		Telefone telefone1 = new Telefone("+55", "11", "59160668", TipoTelefone.CELULAR);
		Telefone telefone2 = new Telefone("+55", "11", "59160668", TipoTelefone.COMERCIAL);
		boolean resp = telefone1.equals(telefone2);
		assertTrue(resp);
	}

	@Test
	public void teste19_deve_retornar_falso_quando_usar_equals_passado_nulo() {
		boolean resp = telefoneBefore.equals(null);
		assertFalse(resp);
	}

	@Test
	public void teste20_deve_retornar_falso_quando_usar_equals_passado_outro_object() {
		boolean resp = telefoneBefore.equals(new Object());
		assertFalse(resp);
	}

	@Test
	public void teste21_deve_retornar_true_quando_usar_equals_passado_o_proprio_objeto() {
		boolean resp = telefoneBefore.equals(telefoneBefore);
		assertTrue(resp);
	}
}
