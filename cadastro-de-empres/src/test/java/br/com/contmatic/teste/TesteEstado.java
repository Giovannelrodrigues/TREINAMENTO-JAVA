package br.com.contmatic.teste;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.contmatic.model.commons.Cidade;
import br.com.contmatic.model.commons.Estado;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteEstado {

	private static Estado estadoBefore;

	private static final String NOME_ESTADO = "Minas Gerais";

	private static final String SIGLA_ESTADO = "MG";

	@Before
	public void antesDeCadaTeste() {
		estadoBefore = new Estado(NOME_ESTADO, SIGLA_ESTADO);
	}

	@Test
	public void teste01_deve_instanciar_uma_nova_classe_estado() {
		assertEquals(NOME_ESTADO, estadoBefore.getNome());
	}

	public void teste02__deve_atribuir_um_novo_nome_() {
		String nome = "São paulo";
		estadoBefore.setNome(nome);
		assertEquals(nome, estadoBefore.getNome());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste03_nao_deve_atribuir_nome_passando_nulo() {
		estadoBefore.setNome(null);
	}

	@Test(expected = IllegalStateException.class)
	public void teste04_nao_deve_atribuir_nome_passando_string_vazia() {
		estadoBefore.setNome("    ");
	}

	@Test(expected = IllegalStateException.class)
	public void teste05_nao_deve_atribuir_nome_passando_string_com_mais_de_60_caracteres() {
		estadoBefore.setNome(
				"São Paulo São Paulo São Paulo São Paulo São Paulo São Paulo São Paulo São Paulo São Paulo São Paulo ");
	}

	@Test(expected = IllegalStateException.class)
	public void teste06_nao_deve_atribuir_nome_passando_string_com_menos_de_2_caracteres() {
		estadoBefore.setNome("SP");
	}

	@Test(expected = IllegalStateException.class)
	public void teste07_nao_deve_atribuir_nome_passando_string_com_numeros() {
		estadoBefore.setNome("SP 3");
	}

	@Test(expected = IllegalStateException.class)
	public void teste08_nao_deve_atribuir_nome_passando_string_com_caracteres() {
		estadoBefore.setNome("SP &¨%");
	}

	@Test
	public void teste09__deve_atribuir__uma_nova_sigla() {
		String sigla = "SP";
		estadoBefore.setSigla(sigla);
		assertEquals(sigla, estadoBefore.getSigla());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste10_nao_deve_atribuir_sigla_passando_nulo() {
		estadoBefore.setSigla(null);
	}

	@Test(expected = IllegalStateException.class)
	public void teste11_nao_deve_atribuir_sigla_passando_string_vazia() {
		estadoBefore.setSigla("    ");
	}

	@Test(expected = IllegalStateException.class)
	public void teste12_nao_deve_atribuir_sigla_passando_mais_de_dois_caracteres() {
		estadoBefore.setSigla("ABC");
	}

	@Test(expected = IllegalStateException.class)
	public void teste13_nao_deve_atribuir_sigla_passando_caracteres_minusculos() {
		estadoBefore.setSigla("aB");
	}

	@Test(expected = IllegalStateException.class)
	public void teste14_nao_deve_atribuir_sigla_passando_caracteres_numericos() {
		estadoBefore.setSigla("A1");
	}

	@Test(expected = IllegalStateException.class)
	public void teste15_nao_deve_atribuir_sigla_passando_caracteres_especiais() {
		estadoBefore.setSigla("A#");
	}

	// LIST CIDADE
	@Test
	public void teste16_deve_atribuir_uma_nova_lista_de_cidade() {
		List<Cidade> cidades = new ArrayList<Cidade>();
		cidades.add(new Cidade("São Carlos", 1234548, estadoBefore));
		estadoBefore.setCidades(cidades);
		assertEquals(cidades, estadoBefore.getCidades());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste17_nao_deve_atribuir_uma_nova_lista_de_cidade_passando_nulo() {
		estadoBefore.setCidades(null);
	}

	@Test(expected = IllegalStateException.class)
	public void teste18_nao_deve_atribuir_uma_nova_lista_de_cidade_vazia() {
		List<Cidade> cidades = new ArrayList<Cidade>();
		estadoBefore.setCidades(cidades);
	}

	@Test(expected = IllegalStateException.class)
	public void teste19_nao_deve_atribuir_uma_nova_lista_de_cidade_passando_mais_de_1000_cidades() {
		List<Cidade> cidades = new ArrayList<Cidade>();
		for (int cont = 0; cont < 1000; cont++) {
			cidades.add(new Cidade("São Roque", 12345, estadoBefore));
		}
		estadoBefore.setCidades(cidades);
	}

	// TO STRING
	@Test
	public void teste20_deve_retornar_nome_no_to_string() {
		String result = estadoBefore.toString();
		assertThat(result, containsString(estadoBefore.getNome()));
	}

	@Test
	public void teste21_deve_retornar_sigla_no_to_string() {
		String result = estadoBefore.toString();
		assertThat(result, containsString(estadoBefore.getSigla()));
	}

	// HASH CODE
	@Test
	public void teste22_deve_retornar_true_no_hashcode_ao_atribuir_nomes_iguals() {
		Estado estado = new Estado(NOME_ESTADO, SIGLA_ESTADO);
		boolean resp = estado.hashCode() == estadoBefore.hashCode();
		assertTrue(resp);
	}

	// EQUALS
	@Test
	public void teste23_deve_retornar_true_quando_usar_equals_passado_estados_iguais() {
		Estado estado = new Estado(NOME_ESTADO, SIGLA_ESTADO);
		boolean resp = estadoBefore.equals(estado);
		assertTrue(resp);
	}

	@Test
	public void teste24_deve_retornar_falso_quando_usar_equals_passado_nulo() {
		boolean resp = estadoBefore.equals(null);
		assertFalse(resp);
	}

	@Test
	public void teste25_deve_retornar_falso_quando_usar_equals_passado_object() {
		boolean resp = estadoBefore.equals(new Object());
		assertFalse(resp);
	}

	@Test
	public void teste26_deve_retornar_true_quando_usar_equals_passado_o_proprio_objeto() {
		boolean resp = estadoBefore.equals(estadoBefore);
		assertTrue(resp);
	}

}
