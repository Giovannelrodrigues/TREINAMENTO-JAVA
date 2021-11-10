package br.com.contmatic.testes;



import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.contmatic.model.Cargo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestesCargo {
	
	public static Cargo cargoBefore;
	
	private static final String NOME = "Programador full stack";
	
	private static final String DESCRICAO = "Programador full stack";
	
	private static final String VAZIO = "  ";
	
	private static final String CARACTERES_150 = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
	
	private static final String CARACTERES_300 = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
	
	@Before
	public void antesDeCadaTeste() {
		cargoBefore = new Cargo(NOME, DESCRICAO);
	}
	
	@Test
	public void testeA_deve_instaciar_um_produto_corretamente_com_todos_os_campos() {
		assertEquals(NOME, cargoBefore.getNome());
		assertEquals(DESCRICAO, cargoBefore.getDescricao());
	}
	
	@Test
	public void testeB_deve_instaciar_um_produto_corretamente_passando_descricao_nulo() {
		Cargo cargo = new Cargo(NOME, null);
		assertNotNull(cargo);
		assertEquals(NOME, cargo.getNome());
	}
	
	//VAZIO
	
	@Test (expected = IllegalStateException.class)
	public void testeC_nao_deve_instaciar_um_produto_passando_nome_vazio() {
		new Cargo(VAZIO, DESCRICAO);
	}
	
	@Test
	public void testeD_deve_instaciar_um_produto_passando_descricao_vazio() {
		Cargo cargo = new Cargo(NOME, VAZIO);
		assertNotNull(cargo);
	}
	
	//NULO
	
	@Test (expected = IllegalArgumentException.class)
	public void testeE_nao_deve_instaciar_um_produto_passando_nome_nulo() {
		new Cargo(null, DESCRICAO);
	}
	
	//CARACTERES
	
	@Test (expected = IllegalStateException.class)
	public void testeF_nao_deve_instaciar_um_produto_passando_nome_com_mais_de_100_caracteres() {
		new Cargo(CARACTERES_150, DESCRICAO);
	}
	
	@Test (expected = IllegalStateException.class)
	public void testeG_nao_deve_instaciar_um_produto_passando_descricao_com_mais_de_256_caracteres() {
		new Cargo(CARACTERES_300, DESCRICAO);
	}
	
	//SETTER
	
	@Test
	public void testeH_deve_atribuir_um_valor_para_nome() {
		final String nome = "programador front end";
		cargoBefore.setNome(nome);
		assertEquals(nome, cargoBefore.getNome());
	}
	
	@Test
	public void testeI_deve_atribuir_um_valor_para_nome() {
		final String descricao = "desenvolver interface";
		cargoBefore.setDescricao(descricao);
		assertEquals(descricao, cargoBefore.getDescricao());
	}
	
	//GETTER
	
	@Test
	public void testeJ_deve_pegar_nome_do_objeto_cargo() {
		assertEquals(NOME, cargoBefore.getNome());
	}
	
	@Test
	public void testeK_deve_pegar_descricao_do_objeto_cargo() {
		assertEquals(DESCRICAO, cargoBefore.getDescricao());
	}

	//TIMEOUT
	
	@Test
	public void testeL_deve_validar_se_para_criar_um_objeto_produto_demora_menos_que_2_segundos() {
		assertTimeout(Duration.ofSeconds(2), () -> { new Cargo(NOME, DESCRICAO);});
	}
	
	@Test
	public void testeM_deve_validar_se_para_pegar_o_valor_de_um_objeto_produto_demora_menos_que_2_segundos() {
		assertTimeout(Duration.ofSeconds(2), () -> { cargoBefore.getNome();});
	}
	
	//TO STRING
	
	@Test
	public void testeN_deve_validar_se_ao_usar_o_metodos_to_string_ele_traz_nome() {
		String result = cargoBefore.toString();
		assertThat(result, containsString(cargoBefore.getNome()));
	}
	
	@Test
	public void testeO_deve_validar_se_ao_usar_o_metodos_to_string_ele_traz_descricao() {
		String result = cargoBefore.toString();
		assertThat(result, containsString(cargoBefore.getDescricao()));
	}
	
	//EQUALS
	
	@Test
	public void testeP_deve_validar_equals_do_objeto_cargo() {
		Cargo cargo1 = new Cargo(NOME, DESCRICAO);
		Cargo cargo2 = new Cargo(NOME, DESCRICAO);
		boolean resp = cargo1.equals(cargo2);
		assertTrue(resp);
	}
	
	@Test
	public void testeQ_deve_validar_equals_do_objeto_produto_passando_nulo() {
		boolean resp = cargoBefore.equals(null);
		assertFalse(resp);
	}
	
	@Test
	public void testeR_deve_validar_equals_do_objeto_produto_passando_a_propria_classe() {
		@SuppressWarnings("unlikely-arg-type")
		boolean resp = cargoBefore.equals(cargoBefore.getClass());
		assertFalse(resp);
	}
	
	@Test
	public void testeS_deve_validar_equals_do_objeto_produto_passando_this() {
		boolean resp = cargoBefore.equals(cargoBefore);
		assertTrue(resp);
	}
	
	//HASHCODE
	@Test
	public void testeT_deve_validar_hashcode_do_objeto_cargo() {
		Cargo cargo1 = new Cargo(NOME, DESCRICAO);
		Cargo cargo2 = new Cargo(NOME, DESCRICAO);
		assertTrue(cargo1.equals(cargo2) && cargo2.equals(cargo1));
		boolean resp = cargo2.hashCode() == cargo1.hashCode();
		assertTrue(resp);
	}
}
