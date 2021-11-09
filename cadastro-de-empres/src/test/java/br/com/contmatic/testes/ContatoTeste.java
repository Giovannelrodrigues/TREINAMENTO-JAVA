package br.com.contmatic.testes;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.contmatic.enums.TipoTelefone;
import br.com.contmatic.model.Contato;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContatoTeste {
	
	private static Contato contatoBefore;
	
	private static final String EMAIL = "cont@contmatic.com";
	
	private static final String TELEFONE = "11996300338";
	
	private static final String VAZIO = "";
	
	private static final String CARACTERES_150 = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
	
	@Before
	public void antesDeCadaTeste() {
		contatoBefore = new Contato(EMAIL, TELEFONE);
	}
	
	//CONSTRUTORES
	
	@Test
	public void testeA_deve_instanciar_objeto_contato_corretamente_preenchendo_todos_os_campos() {
		assertEquals(EMAIL, contatoBefore.getEmail());
		assertEquals(TELEFONE, contatoBefore.getTelefone());
	}
	
	//NULO
	
	@Test (expected = IllegalArgumentException.class)
	public void testeB_nao_deve_instanciar_objeto_contato_passando_email_nulo() {
		new Contato(null, TELEFONE);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testeC_nao_deve_instanciar_objeto_contato_passando_telefone_nulo() {
		new Contato(EMAIL, null);
	}
	
	//VAZIO
	
	
	@Test (expected = IllegalStateException.class)
	public void testeD_nao_deve_instanciar_objeto_contato_passando_email_vazio() {
		new Contato(VAZIO, TELEFONE);
	}
	
	@Test (expected = IllegalStateException.class)
	public void testeE_nao_deve_instanciar_objeto_contato_passando_telefone_vazio() {
		new Contato(EMAIL, VAZIO);
	}
	
	//CARACTERES
	
	@Test (expected = IllegalStateException.class)
	public void testeF_nao_deve_instanciar_objeto_contato_passando_email_com_mais_de_cem_caracteres() {
		new Contato(CARACTERES_150, TELEFONE);
	}
	
	@Test (expected = IllegalStateException.class)
	public void testeG_nao_deve_instanciar_objeto_contato_passando_telefone_com_mais_de_11_caracteres() {
		new Contato(EMAIL, "01234567890123456789");
	}
	
	@Test (expected = IllegalStateException.class)
	public void testeH_nao_deve_instanciar_objeto_contato_passando_telefone_com_menos_de_10_caracteres() {
		new Contato(EMAIL, "123456");
	}
	
	//SETTERS
	
	@Test
	public void testeI_deve_atribuir_um_novo_valor_para_email() {
		final String email = "giovanne.cont@contmatic.com";
		contatoBefore.setEmail(email);
		assertEquals(email, contatoBefore.getEmail());
	}
	
	@Test
	public void testeJ_deve_atribuir_um_novo_valor_para_telefone() {
		final String telefone = "1159160668";
		contatoBefore.setTelefone(telefone);
		assertEquals(telefone, contatoBefore.getTelefone());
	}
	
	@Test
	public void testeK_deve_atribuir_um_novo_valor_para_telefone_fixo() {
		final String telefone = "1159160668";
		contatoBefore.setTelefone(telefone);
		assertEquals(TipoTelefone.FIXO, contatoBefore.getTipoTelefone());
	}
	
	@Test
	public void testeL_deve_atribuir_um_novo_valor_para_telefone_celular() {
		final String telefone = "11959160668";
		contatoBefore.setTelefone(telefone);
		assertEquals(TipoTelefone.CELULAR, contatoBefore.getTipoTelefone());
	}
	
	//GETTERS
	
	@Test
	public void testeM_deve_retornar_o_valor_email() {
		assertEquals(EMAIL, contatoBefore.getEmail());
	}
	
	@Test
	public void testeN_deve_retornar_o_valor_telefone() {
		assertEquals(TELEFONE, contatoBefore.getTelefone());
	}
	
	@Test
	public void testeO_deve_retornar_o_valor_tipo_telefone() {
		assertEquals(TipoTelefone.CELULAR, contatoBefore.getTipoTelefone());
	}
	
	//TIMEOUT
	
	@Test
	public void testeP_deve_validar_se_para_criar_um_objeto_contato_demora_menos_que_2_segundos() {
		assertTimeout(Duration.ofSeconds(2), () -> {new Contato(EMAIL, TELEFONE);});
	}
	
	@Test
	public void testeQ_deve_validar_se_para_pegar_o_valor_de_um_objeto_contato_demora_menos_que_2_segundos() {
		assertTimeout(Duration.ofSeconds(2), () -> {contatoBefore.getEmail();});
	}

	//TO STRING
	@Test
	public void testeR_deve_validar_se_ao_usar_o_metodos_to_string_ele_traz_email() {
		String result = contatoBefore.toString();
		assertThat(result, containsString(contatoBefore.getEmail()));
	}
	
	@Test
	public void testeS_deve_validar_se_ao_usar_o_metodos_to_string_ele_traz_telefone() {
		String result = contatoBefore.toString();
		assertThat(result, containsString(contatoBefore.getTelefone()));
	}
	
	@Test
	public void testeT_deve_validar_se_ao_usar_o_metodos_to_string_ele_traz_tipo_telefone() {
		String result = contatoBefore.toString();
		assertThat(result, containsString(String.valueOf(contatoBefore.getTipoTelefone())));
	}
	
	//EQUALS
	
	@Test
	public void testeU_deve_validar_equals_do_objeto_contato() {
		Contato contato1 = new Contato(EMAIL, TELEFONE);
		Contato contato2 = new Contato(EMAIL, TELEFONE);
		boolean resp = contato1.equals(contato2);
		assertTrue(resp);
	}
	
	@Test
	public void testeV_deve_validar_equals_do_objeto_contato__passando_nulo() {
		boolean resp = contatoBefore.equals(null);
		assertFalse(resp);
	}
	
	@Test
	public void testeW_deve_validar_equals_do_objeto_contato_passando_a_propria_classe() {
		@SuppressWarnings("unlikely-arg-type")
		boolean resp = contatoBefore.equals(contatoBefore.getClass());
		assertFalse(resp);
	}
	
	@Test
	public void testeX_deve_validar_equals_do_objeto_contato_passando_this() {
		boolean resp = contatoBefore.equals(contatoBefore);
		assertTrue(resp);
	}
	
	//HASHCODE
	@Test
	public void testeY_deve_validar_hashcode_do_objeto_contato() {
		Contato contato1 = new Contato(EMAIL, TELEFONE);
		Contato contato2 = new Contato(EMAIL, TELEFONE);
		assertTrue(contato1.equals(contato2) && contato2.equals(contato1));
		boolean resp = contato2.hashCode() == contato1.hashCode();
		assertTrue(resp);
	}
}
