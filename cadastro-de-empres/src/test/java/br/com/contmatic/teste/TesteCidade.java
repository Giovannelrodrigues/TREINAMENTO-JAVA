package br.com.contmatic.teste;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.contmatic.model.Cidade;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteCidade {

	private static Cidade cidadeBefore;

	private static final String NOME_CIDADE = "São Paulo";

	@Before
	public void antesDeCadaTeste() {
		cidadeBefore = new Cidade(NOME_CIDADE);
	}

	@Test
	public void teste01_deve_instanciar_uma_nova_classe_cidade() {
		assertEquals(NOME_CIDADE, cidadeBefore.getNome());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste02_nao_deve_instanciar_nome_passando_nulo() {
		cidadeBefore.setNome(null);
	}

	@Test(expected = IllegalStateException.class)
	public void teste03_nao_deve_instanciar_nome_passando_string_vazia() {
		cidadeBefore.setNome("    ");
	}

	@Test(expected = IllegalStateException.class)
	public void teste04_nao_deve_instanciar_nome_passando_string_com_mais_de_60_caracteres() {
		cidadeBefore.setNome(
				"São Paulo São Paulo São Paulo São Paulo São Paulo São Paulo São Paulo São Paulo São Paulo São Paulo ");
	}

	@Test(expected = IllegalStateException.class)
	public void teste05_nao_deve_instanciar_nome_passando_string_com_menos_de_2_caracteres() {
		cidadeBefore.setNome("SP");
	}

	@Test(expected = IllegalStateException.class)
	public void teste06_nao_deve_instanciar_nome_passando_string_com_numeros() {
		cidadeBefore.setNome("SP 3");
	}

	@Test(expected = IllegalStateException.class)
	public void teste07_nao_deve_instanciar_nome_passando_string_com_caracteres() {
		cidadeBefore.setNome("SP &¨%");
	}

	// TO STRING
	@Test
	public void teste08_deve_retornar_nome_no_to_string() {
		String result = cidadeBefore.toString();
		assertThat(result, containsString(cidadeBefore.getNome()));
	}

	// HASH CODE
	@Test
	public void teste09_deve_retornar_true_no_hashcode_ao_instanciar_nomes_iguals() {
		Cidade cidade = new Cidade(NOME_CIDADE);
		boolean resp = cidade.hashCode() == cidadeBefore.hashCode();
		assertTrue(resp);
	}

	// EQUALS
	@Test
	public void teste10_deve_retornar_true_quando_usar_equals_passado_cidades_iguais() {
		Cidade cidade = new Cidade(NOME_CIDADE);
		boolean resp = cidadeBefore.equals(cidade);
		assertTrue(resp);
	}

	@Test
	public void teste11_deve_retornar_falso_quando_usar_equals_passado_nulo() {
		boolean resp = cidadeBefore.equals(null);
		assertFalse(resp);
	}

	@Test
	public void teste12_deve_retornar_falso_quando_usar_equals_passado_object() {
		boolean resp = cidadeBefore.equals(new Object());
		assertFalse(resp);
	}

	@Test
	public void teste13_deve_retornar_true_quando_usar_equals_passado_o_proprio_objeto() {
		boolean resp = cidadeBefore.equals(cidadeBefore);
		assertTrue(resp);
	}

}
