package br.com.contmatic.testes.model.empresa;

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

import br.com.contmatic.model.contato.Email;
import br.com.contmatic.model.empresa.AmbienteTrabalho;
import br.com.contmatic.model.empresa.Cargo;
import br.com.contmatic.model.empresa.Empresa;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteCargo {

	private static final Email EMAIL = new Email("giovannelrodrigues@gmail.com");

	private static final LocalDateTime LOCAL_TIME = LocalDateTime.of(2023, Month.JUNE, 28, 6, 30, 40, 50000);

	private static final String IP = "122.21.123.1";

	private static Empresa empresaBefore;

	private static AmbienteTrabalho ambienteBefore;

	private static Cargo cargoBefore;

	private static final String NOME = "Desenvolver Frontend";

	private static final String DESCRICAO = "Atuar no devesenvolvimento de iterface do usuario";

	@Before
	public void teste00_antes_de_cada_teste() {
		empresaBefore = new Empresa("09535558000146");
		ambienteBefore = new AmbienteTrabalho("Desenv", empresaBefore);
		cargoBefore = new Cargo(NOME, ambienteBefore);
		cargoBefore.setDescricao(DESCRICAO);
		cargoBefore.setCreatedBy(EMAIL);
		cargoBefore.setCreateDate(LOCAL_TIME);
		cargoBefore.setCreatedBy(EMAIL);
		cargoBefore.setCreateDate(LOCAL_TIME);
		cargoBefore.setCreatedIp(IP);
		cargoBefore.setUpdatedIp(IP);
	}

	// CONSTRUTOR
	@Test
	public void teste01_deve_instaciar_um_cargo_com_campos_obrigatorios() {
		Cargo cargo = new Cargo(NOME, ambienteBefore);
		assertEquals(NOME, cargo.getNome());
	}

	@Test
	public void teste02_deve_atribuir_um_novo_nome_para_cargo() {
		String nome = "Recursos Humanos";
		cargoBefore.setNome(nome);
		assertEquals(nome, cargoBefore.getNome());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste03_nao_deve_atribuir_um_novo_nome_para_cargo_passando_nulo() {
		cargoBefore.setNome(null);
	}

	@Test(expected = IllegalStateException.class)
	public void teste04_nao_deve_atribuir_um_novo_nome_para_cargo_passando_vazio() {
		cargoBefore.setNome("    ");
	}

	@Test(expected = IllegalStateException.class)
	public void teste05_nao_deve_atribuir_um_novo_nome_para_cargo_passando_mais_60_caracteres() {
		cargoBefore.setNome("RH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RH");
	}

	@Test(expected = IllegalStateException.class)
	public void teste06_nao_deve_atribuir_um_novo_nome_para_cargo_passando_menos_3_caracteres() {
		cargoBefore.setNome("Ab");
	}

	@Test(expected = IllegalStateException.class)
	public void teste07_nao_deve_atribuir_um_novo_nome_para_cargo_passando_caracteres_especiais() {
		cargoBefore.setNome("RECURSO # HUMANOS");
	}

	@Test(expected = IllegalStateException.class)
	public void teste08_nao_deve_atribuir_um_novo_nome_para_cargo_passando_numeros() {
		cargoBefore.setNome("123456abc");
	}

	// DESCRICAO
	@Test
	public void teste09_deve_atribuir_uma_nova_descricao_para_cargo() {
		String descricao = "Recrutamento e gerenciamento de pessoas";
		cargoBefore.setDescricao(descricao);
		assertEquals(descricao, cargoBefore.getDescricao());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste10_nao_deve_atribuir_uma_nova_descricao_para_cargo_passando_nulo() {
		cargoBefore.setDescricao(null);
	}

	@Test(expected = IllegalStateException.class)
	public void teste11_nao_deve_atribuir_uma_nova_descricao_para_cargo_passando_vazio() {
		cargoBefore.setDescricao("    ");
	}

	@Test(expected = IllegalStateException.class)
	public void teste12_nao_deve_atribuir_uma_nova_descricao_para_trabalho_passando_mais_256_caracteres() {
		cargoBefore.setDescricao(
				"RH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RH");
	}

	@Test(expected = IllegalStateException.class)
	public void teste13_nao_deve_atribuir_um_novo_nome_para_cargo_passando_menos_3_caracteres() {
		cargoBefore.setNome("Ab");
	}

	@Test
	public void teste14_deve_atribuir_uma_nova_descricao_para_cargo_passando_caracteres_especiais() {
		cargoBefore.setDescricao("#Descricao");
		assertEquals("#Descricao", cargoBefore.getDescricao());
	}

	@Test
	public void teste15_deve_atribuir_uma_nova_descricao_para_cargo_passando_numeros() {
		cargoBefore.setDescricao("101010");
		assertEquals("101010", cargoBefore.getDescricao());
	}

	// AMBIENTE TRABALHO
	@Test
	public void teste09_deve_setar_ambiente() {
		AmbienteTrabalho ambienteTrabalho = new AmbienteTrabalho("Desenveeeeeeeee", empresaBefore);
		cargoBefore.setAmbienteTrabalho(ambienteTrabalho);
		assertEquals(ambienteTrabalho, cargoBefore.getAmbienteTrabalho());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void teste09_nao_deve_setar_ambiente_passando_nulo() {
		cargoBefore.setAmbienteTrabalho(null);
	}

	// TO STRING
	@Test
	public void teste16_deve_retornar_o_nome_do_cargo_no_to_string() {
		String result = cargoBefore.toString();
		assertThat(result, containsString(cargoBefore.getNome()));
	}

	@Test
	public void teste17_deve_retornar_a_descricao_do_cargo_no_to_string() {
		cargoBefore.setDescricao("desenvolver interfaces ao usuario");
		String result = cargoBefore.toString();
		assertThat(result, containsString(cargoBefore.getDescricao()));
	}

	// HASHCODE
	@Test
	public void teste18_deve_retornar_mesmo_hashcode_para_da_cargo_com_mesmo_nome_e_ambiente() {
		Cargo cargo1 = new Cargo(NOME, ambienteBefore);
		Cargo cargo2 = new Cargo(NOME, ambienteBefore);
		boolean resp = cargo1.hashCode() == cargo2.hashCode();
		assertTrue(resp);
	}

	@Test
	public void teste19_deve_retornar_hashcode_diferente_para_da_cargo_com_nome_diferente_ambiente_igual() {
		Cargo cargo1 = new Cargo(NOME, ambienteBefore);
		Cargo cargo2 = new Cargo("alouuu", ambienteBefore);
		boolean resp = cargo1.hashCode() == cargo2.hashCode();
		assertFalse(resp);
	}

	@Test
	public void teste20_deve_retornar_hashcode_diferente_para_da_cargo_com_nome_igual_ambiente_diferente() {
		Cargo cargo1 = new Cargo(NOME, ambienteBefore);
		Cargo cargo2 = new Cargo("alouuu", new AmbienteTrabalho("teste", new Empresa("55353249000172")));
		boolean resp = cargo1.hashCode() == cargo2.hashCode();
		assertFalse(resp);
	}

	// EQUALS
	@Test
	public void teste21_deve_retornar_true_quando_usar_equals_passado_nome_e_ambiente_iguais() {
		Cargo cargo1 = new Cargo(NOME, ambienteBefore);
		Cargo cargo2 = new Cargo(NOME, ambienteBefore);
		boolean resp = cargo1.equals(cargo2);
		assertTrue(resp);
	}

	@Test
	public void teste22_deve_retornar_falso_quando_usar_equals_passado_nome_cargo_difentes_e_ambiente_igual() {
		Cargo cargo1 = new Cargo(NOME, ambienteBefore);
		Cargo cargo2 = new Cargo("teste teste", ambienteBefore);
		boolean resp = cargo1.equals(cargo2);
		assertFalse(resp);
	}

	@Test
	public void teste23_deve_retornar_falso_quando_usar_equals_passado_nome_cargo_igual_e_ambiente_diferente() {
		Cargo cargo1 = new Cargo(NOME, ambienteBefore);
		Cargo cargo2 = new Cargo("teste teste", new AmbienteTrabalho("teste", new Empresa("55353249000172")));
		boolean resp = cargo1.equals(cargo2);
		assertFalse(resp);
	}

	@Test
	public void teste24_deve_retornar_falso_quando_usar_equals_passado_nulo() {
		boolean resp = cargoBefore.equals(null);
		assertFalse(resp);
	}

	@Test
	public void teste25_deve_retornar_falso_quando_usar_equals_passado_object() {
		boolean resp = cargoBefore.equals(new Object());
		assertFalse(resp);
	}

	@Test
	public void teste26_deve_retornar_verdadeiro_quando_usar_equals_passado_o_proprio_objeto() {
		boolean resp = cargoBefore.equals(cargoBefore);
		assertTrue(resp);
	}
}
