package br.com.contmatic.endereco;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.contmatic.model.endereco.Cidade;
import br.com.contmatic.model.endereco.Estado;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteCidade {

	private static Cidade cidadeBefore;

	private static Estado estadoBefore;

	private static final String NOME_CIDADE = "ACAIACA";

	private static final Integer CODIGO_IBGE = 3100401;

	private static final String NOME_ESTADO = "Minas Gerais";

	private static final String SIGLA_ESTADO = "MG";

	@Before
	public void antesDeTodosOsTeste() {
		estadoBefore = new Estado(NOME_ESTADO, SIGLA_ESTADO);
		cidadeBefore = new Cidade(NOME_CIDADE, CODIGO_IBGE, estadoBefore);
	}

	@Test
	public void teste01_deve_instanciar_uma_nova_classe_cidade() {
		assertEquals(NOME_CIDADE, cidadeBefore.getNome());
	}

	@Test
	public void teste02_deve_atribuir_um_novo_nome_para_cidade() {
		String nome = "São Paulo";
		cidadeBefore.setNome(nome);
		assertEquals(nome, cidadeBefore.getNome());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste03_nao_deve_atribuir_nome_passando_nulo() {
		cidadeBefore.setNome(null);
	}

	@Test(expected = IllegalStateException.class)
	public void teste04_nao_deve_atribuir_nome_passando_string_vazia() {
		cidadeBefore.setNome("    ");
	}

	@Test(expected = IllegalStateException.class)
	public void teste05_nao_deve_atribuir_nome_passando_string_com_mais_de_60_caracteres() {
		cidadeBefore.setNome(
				"São Paulo São Paulo São Paulo São Paulo São Paulo São Paulo São Paulo São Paulo São Paulo São Paulo ");
	}

	@Test(expected = IllegalStateException.class)
	public void teste06_nao_deve_atribuir_nome_passando_string_com_menos_de_3_caracteres() {
		cidadeBefore.setNome("SP");
	}

	@Test(expected = IllegalStateException.class)
	public void teste07_nao_deve_atribuir_nome_passando_string_com_numeros() {
		cidadeBefore.setNome("SP 3");
	}

	@Test(expected = IllegalStateException.class)
	public void teste08_nao_deve_atribuir_nome_passando_string_com_caracteres() {
		cidadeBefore.setNome("SP &¨%");
	}

	@Test
	public void teste09_deve_atribuir_um_nova_sigla_para_cidade_cidade() {
		Integer codigoIBGE = 123456;
		cidadeBefore.setCodigoIBGE(codigoIBGE);
		assertEquals(codigoIBGE, cidadeBefore.getCodigoIBGE());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste10_nao_deve_atribuir_sigla_passando_nulo() {
		cidadeBefore.setCodigoIBGE(null);
	}

	@Test(expected = IllegalStateException.class)
	public void teste11_nao_deve_atribuir_nome_passando_0() {
		cidadeBefore.setCodigoIBGE(0);
	}

	@Test(expected = IllegalStateException.class)
	public void teste12_nao_deve_atribuir_nome_passando_mais_9999999() {
		cidadeBefore.setCodigoIBGE(10000000);
	}

	@Test
	public void teste13_deve_atribuir_um_novo_estado_para_cidade_cidade() {
		Estado estado = new Estado("São Paulo", "SP");
		cidadeBefore.setEstado(estado);
		assertEquals(estado, cidadeBefore.getEstado());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste14_nao_deve_atribuir_novo_estado_passando_nulo() {
		cidadeBefore.setEstado(null);
	}

	// TO STRING
	@Test
	public void teste15_deve_retornar_nome_no_to_string() {
		String result = cidadeBefore.toString();
		assertThat(result, containsString(cidadeBefore.getNome()));
	}

	@Test
	public void teste16_deve_retornar_codigo_ibge_no_to_string() {
		String result = cidadeBefore.toString();
		assertThat(result, containsString(String.valueOf(cidadeBefore.getCodigoIBGE())));
	}

	@Test
	public void teste17_deve_retornar_estado_no_to_string() {
		String result = cidadeBefore.toString();
		assertThat(result, containsString(String.valueOf(cidadeBefore.getEstado())));
	}

	// HASH CODE
	@Test
	public void teste18_deve_retornar_true_no_hashcode_ao_instanciar_cidade_com_mesmo_codigo_ibge() {
		Cidade cidade = new Cidade(NOME_CIDADE, CODIGO_IBGE, estadoBefore);
		boolean resp = cidade.hashCode() == cidadeBefore.hashCode();
		assertTrue(resp);
	}
	
	@Test
	public void teste19_deve_retornar_false_no_hashcode_ao_instanciar_cidade_com_codigo_ibge_diferente() {
		Cidade cidade = new Cidade(NOME_CIDADE, 14785, estadoBefore);
		boolean resp = cidade.hashCode() == cidadeBefore.hashCode();
		assertFalse(resp);
	}

	// EQUALS
	
	@Test
	public void teste20_deve_retornar_true_quando_usar_equals_passado_cidades_com_mesmo_codigo_do_ibge() {
		Cidade cidade = new Cidade(NOME_CIDADE, CODIGO_IBGE, estadoBefore);
		boolean resp = cidadeBefore.equals(cidade);
		assertTrue(resp);
	}
	
	@Test
	public void teste21_deve_retornar_false_quando_usar_equals_passado_cidades_com_codigo_do_ibge_diferente() {
		Cidade cidade = new Cidade(NOME_CIDADE, 14785, estadoBefore);
		boolean resp = cidadeBefore.equals(cidade);
		assertFalse(resp);
	}
	
	@Test
	public void teste22_deve_retornar_falso_quando_usar_equals_passado_nulo() {
		boolean resp = cidadeBefore.equals(null);
		assertFalse(resp);
	}
	
	@Test
	public void teste23_deve_retornar_falso_quando_usar_equals_passado_object() {
		boolean resp = cidadeBefore.equals(new Object());
		assertFalse(resp);
	}

	@Test
	public void teste24_deve_retornar_true_quando_usar_equals_passado_o_proprio_objeto() {
		boolean resp = cidadeBefore.equals(cidadeBefore);
		assertTrue(resp);
	}

}
