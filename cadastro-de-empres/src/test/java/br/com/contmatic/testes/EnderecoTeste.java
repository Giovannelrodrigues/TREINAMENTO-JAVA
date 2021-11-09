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

import br.com.contmatic.model.Endereco;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EnderecoTeste {
	
	private static Endereco enderecoBefore;
	
	private static final String CEP = "12243670";
	
	private static final String LOGRADOURO = "Rua Major Vaz";
			
	private static final String COMPLEMENTO = "Predio empresa";
	
	private static final int NUMERO = 157;
	
	private static final String BAIRRO = "Vila Adyana";
	
	private static final String CIDADE = "São paulo";
	
	private static final String ESTADO = "São paulo";
	
	private static final String VAZIO = "  ";
	
	private static final String CARACTERES_150 = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
	
	@Before
	public void antesDeCadaTeste() {
		enderecoBefore = new Endereco(CEP, LOGRADOURO, COMPLEMENTO, NUMERO, BAIRRO, ESTADO, CIDADE);
	}
	
	@Test
	public void testeA_deve_instanciar_objeto_endereco_corretamente_preenchendo_todos_os_campos() {
		assertEquals(CEP, enderecoBefore.getCep());
		assertEquals(LOGRADOURO, enderecoBefore.getLogradouro());
		assertEquals(COMPLEMENTO, enderecoBefore.getComplemento());
		assertEquals(NUMERO, enderecoBefore.getNumero());
		assertEquals(BAIRRO, enderecoBefore.getBairro());
		assertEquals(CIDADE, enderecoBefore.getCidade());
		assertEquals(ESTADO, enderecoBefore.getEstado());
	}
	
	@Test
	public void testeB_deve_instanciar_objeto_endereco_corretamente_passando_complemento_nulo() {
		Endereco endereco = new Endereco(CEP, LOGRADOURO, null, NUMERO, BAIRRO, ESTADO, CIDADE);
		assertEquals(CEP, endereco.getCep());
		assertEquals(LOGRADOURO, endereco.getLogradouro());
		assertEquals(null, endereco.getComplemento());
		assertEquals(NUMERO, endereco.getNumero());
		assertEquals(BAIRRO, endereco.getBairro());
		assertEquals(CIDADE, endereco.getCidade());
		assertEquals(ESTADO, endereco.getEstado());
	}
	
	//VAZIO
	
	@Test
	public void testeC_deve_instanciar_objeto_preenchendo_complemento_vazio() {
		Endereco endereco = new Endereco(CEP, LOGRADOURO, VAZIO, NUMERO, BAIRRO, ESTADO, CIDADE);
		assertNotNull(endereco);
	}
	
	@Test (expected = IllegalStateException.class)
	public void testeD_nao_deve_instanciar_objeto_preenchendo_cep_vazio() {
		new Endereco(VAZIO, LOGRADOURO, COMPLEMENTO, NUMERO, BAIRRO, ESTADO, CIDADE);
	}
	
	@Test (expected = IllegalStateException.class)
	public void testeE_nao_deve_instanciar_objeto_preenchendo_logradouro_vazio() {
		new Endereco(CEP, VAZIO, COMPLEMENTO, NUMERO, BAIRRO, ESTADO, CIDADE);
	}
	
	@Test (expected = IllegalStateException.class)
	public void testeF_nao_deve_instanciar_objeto_preenchendo_numero_0() {
		new Endereco(CEP, LOGRADOURO, COMPLEMENTO, 0, BAIRRO, ESTADO, CIDADE);
	}
	@Test (expected = IllegalStateException.class)
	public void testeG_nao_deve_instanciar_objeto_preenchendo_bairro_vazio() {
		new Endereco(CEP, LOGRADOURO, COMPLEMENTO, NUMERO, VAZIO, ESTADO, CIDADE);
	}
	@Test (expected = IllegalStateException.class)
	public void testeH_nao_deve_instanciar_objeto_preenchendo_estado_vazio() {
		new Endereco(CEP, LOGRADOURO, COMPLEMENTO, NUMERO, BAIRRO, VAZIO, CIDADE);
	}
	@Test (expected = IllegalStateException.class)
	public void testeI_nao_deve_instanciar_objeto_preenchendo_cidade_vazio() {
		new Endereco(CEP, LOGRADOURO, COMPLEMENTO, NUMERO, BAIRRO, ESTADO, VAZIO);
	}
	
	//NULO
	
	@Test (expected = IllegalArgumentException.class)
	public void testeJ_nao_deve_instanciar_objeto_preenchendo_cep_nulo() {
		new Endereco(null, LOGRADOURO, COMPLEMENTO, NUMERO, BAIRRO, ESTADO, CIDADE);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testeK_nao_deve_instanciar_objeto_preenchendo_logradouro_nulo() {
		new Endereco(CEP, null, COMPLEMENTO, NUMERO, BAIRRO, ESTADO, CIDADE);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testeL_nao_deve_instanciar_objeto_preenchendo_bairro_null() {
		new Endereco(CEP, LOGRADOURO, COMPLEMENTO, NUMERO, null, ESTADO, CIDADE);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testeM_nao_deve_instanciar_objeto_preenchendo_estado_null() {
		new Endereco(CEP, LOGRADOURO, COMPLEMENTO, NUMERO, BAIRRO, null, CIDADE);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testeN_nao_deve_instanciar_objeto_preenchendo_cidade_null() {
		new Endereco(CEP, LOGRADOURO, COMPLEMENTO, NUMERO, BAIRRO, ESTADO, null);
	}
	//CARACTERES
	
	@Test (expected = IllegalStateException.class)
	public void testeO_nao_deve_instanciar_objeto_preenchendo_cep_com_mais_de_8_caracteres() {
		new Endereco("1234567890", LOGRADOURO, COMPLEMENTO, NUMERO, BAIRRO, ESTADO, CIDADE);
	}
	
	@Test (expected = IllegalStateException.class)
	public void testeP_nao_deve_instanciar_objeto_preenchendo_cep_com_menos_de_8_caracteres() {
		new Endereco("1234", LOGRADOURO, COMPLEMENTO, NUMERO, BAIRRO, ESTADO, CIDADE);
	}
	
	@Test (expected = IllegalStateException.class)
	public void testeQ_nao_deve_instanciar_objeto_preenchendo_complemento_com_mais_de_100_caracteres() {
		new Endereco(CEP, CARACTERES_150, COMPLEMENTO, NUMERO, BAIRRO, ESTADO, CIDADE);
	}
	
	@Test (expected = IllegalStateException.class)
	public void testeR_nao_deve_instanciar_objeto_preenchendo_bairro_com_mais_de_100_caracteres() {
		new Endereco(CEP, LOGRADOURO, CARACTERES_150, NUMERO, BAIRRO, ESTADO, CIDADE);
	}
	
	@Test (expected = IllegalStateException.class)
	public void testeS_nao_deve_instanciar_objeto_preenchendo_estado_com_mais_de_100_caracteres() {
		new Endereco(CEP, LOGRADOURO, COMPLEMENTO, NUMERO, CARACTERES_150, ESTADO, CIDADE);
	}
	
	@Test (expected = IllegalStateException.class)
	public void testeT_nao_deve_instanciar_objeto_preenchendo_cidade_com_mais_de_100_caracteres() {
		new Endereco(CEP, LOGRADOURO, COMPLEMENTO, NUMERO, BAIRRO, CARACTERES_150, CIDADE);
	}
	
	//SETTERS
	
	@Test
	public void testeU_deve_atribuir_um_valor_para_cep() {
		final String cep = "04548902";
		enderecoBefore.setCep(cep);
		assertEquals(cep, enderecoBefore.getCep());
	}
	
	@Test
	public void testeV_deve_atribuir_um_valor_para_logradouro() {
		final String logradouro = "Avenida Doutor Cardoso de Melo 1750";
		enderecoBefore.setLogradouro(logradouro);
		assertEquals(logradouro, enderecoBefore.getLogradouro());
	}
	
	@Test
	public void testeW_deve_atribuir_um_valor_para_complemento() {
		final String complemento = "casa 3";
		enderecoBefore.setComplemento(complemento);
		assertEquals(complemento, enderecoBefore.getComplemento());
	}
	
	@Test
	public void testeX_deve_atribuir_um_valor_para_numero() {
		final int numero = 15;
		enderecoBefore.setNumero(numero);
		assertEquals(numero, enderecoBefore.getNumero());
	}
	
	@Test
	public void testeY_deve_atribuir_um_valor_para_bairro() {
		final String bairo = "casa 3";
		enderecoBefore.setBairro(bairo);
		assertEquals(bairo, enderecoBefore.getBairro());
	}
	
	@Test
	public void testeZ_deve_atribuir_um_valor_para_estado() {
		final String estado = "São Paulo";
		enderecoBefore.setEstado(estado);
		assertEquals(estado, enderecoBefore.getEstado());
	}
	
	@Test
	public void testeAA_deve_atribuir_um_valor_para_cidade() {
		final String cidade = "São Paulo";
		enderecoBefore.setCidade(cidade);
		assertEquals(cidade, enderecoBefore.getCidade());
	}
	
	//GETTERS
	
	@Test
	public void testeAB_deve_pegar_cep_do_objeto_endereco() {
		assertEquals(CEP, enderecoBefore.getCep());
	}
	
	@Test
	public void testeAC_deve_pegar_logradouro_do_objeto_endereco() {
		assertEquals(LOGRADOURO, enderecoBefore.getLogradouro());
	}
	
	@Test
	public void testeAD_deve_pegar_complemento_do_objeto_endereco() {
		assertEquals(COMPLEMENTO , enderecoBefore.getComplemento());
	}
	
	@Test
	public void testeAE_deve_pegar_numero_do_objeto_endereco() {
		assertEquals(NUMERO , enderecoBefore.getNumero());
	}
	
	@Test
	public void testeAF_deve_pegar_bairro_do_objeto_endereco() {
		assertNotNull(BAIRRO, enderecoBefore.getBairro());
	}
	
	@Test
	public void testeAG_deve_pegar_cidade_do_objeto_endereco() {
		assertNotNull(CIDADE, enderecoBefore.getCidade());
	}
	
	@Test
	public void testeAH_deve_pegar_estado_do_objeto_endereco() {
		assertEquals(ESTADO , enderecoBefore.getEstado());
	}
	
	//TIMEOUT
	
	@Test
	public void testeAI_deve_validar_se_para_criar_um_objeto_endereco_demora_menos_que_2_segundos() {
		assertTimeout(Duration.ofSeconds(2), () -> {new Endereco(CEP, LOGRADOURO, COMPLEMENTO, NUMERO, BAIRRO, ESTADO, CIDADE);;});
	}
	
	@Test
	public void testeAJ_deve_validar_se_para_pegar_o_valor_de_um_objeto_endereco_demora_menos_que_2_segundos() {
		assertTimeout(Duration.ofSeconds(2), () -> { enderecoBefore.getCep();});
	}
	
	//TO STRING
	
	@Test
	public void testeAK_deve_validar_se_ao_usar_o_metodos_to_string_ele_traz_cep() {
		String result = enderecoBefore.toString();
		assertThat(result, containsString(enderecoBefore.getCep()));
	}
	
	@Test
	public void testeAL_deve_validar_se_ao_usar_o_metodos_to_string_ele_traz_logradouro() {
		String result = enderecoBefore.toString();
		assertThat(result, containsString(enderecoBefore.getLogradouro()));
	}
	
	@Test
	public void testeAM_deve_validar_se_ao_usar_o_metodos_to_string_ele_traz_complemento() {
		String result = enderecoBefore.toString();
		assertThat(result, containsString(enderecoBefore.getComplemento()));
	}
	
	@Test
	public void testeAN_deve_validar_se_ao_usar_o_metodos_to_string_ele_traz_numero() {
		String result = enderecoBefore.toString();
		assertThat(result, containsString(String.valueOf(enderecoBefore.getNumero())));
	}
	
	@Test
	public void testeAO_deve_validar_se_ao_usar_o_metodos_to_string_ele_traz_bairro() {
		String result = enderecoBefore.toString();
		assertThat(result, containsString(enderecoBefore.getBairro()));
	}
	
	@Test
	public void testeAP_deve_validar_se_ao_usar_o_metodos_to_string_ele_traz_cidade() {
		String result = enderecoBefore.toString();
		assertThat(result, containsString(enderecoBefore.getCidade()));
	}
	
	@Test
	public void testeAQ_deve_validar_se_ao_usar_o_metodos_to_string_ele_traz_estado() {
		String result = enderecoBefore.toString();
		assertThat(result, containsString(enderecoBefore.getEstado()));
	}
	//EQUALS
	
	@Test
	public void testeAR_deve_validar_equals_do_objeto_endereco() {
		Endereco endereco1 = new Endereco(CEP, LOGRADOURO, COMPLEMENTO, NUMERO, BAIRRO, ESTADO, CIDADE);
		Endereco endereco2 = new Endereco(CEP, LOGRADOURO, COMPLEMENTO, NUMERO, BAIRRO, ESTADO, CIDADE);
		boolean resp = endereco1.equals(endereco2);
		assertTrue(resp);
	}
	
	@Test
	public void testeAS_deve_validar_equals_do_objeto_endereco_passando_nulo() {
		boolean resp = enderecoBefore.equals(null);
		assertFalse(resp);
	}
	
	@Test
	public void testeAJ_deve_validar_equals_do_objeto_endereco_passando_a_propria_classe() {
		@SuppressWarnings("unlikely-arg-type")
		boolean resp = enderecoBefore.equals(enderecoBefore.getClass());
		assertFalse(resp);
	}
	
	@Test
	public void testeAK_deve_validar_equals_do_objeto_endereco_passando_this() {
		boolean resp = enderecoBefore.equals(enderecoBefore);
		assertTrue(resp);
	}
	
	//HASHCODE
	@Test
	public void testeAL_deve_validar_hashcode_do_objeto_endereco() {
		Endereco endereco1 = new Endereco(CEP, LOGRADOURO, COMPLEMENTO, NUMERO, BAIRRO, ESTADO, CIDADE);
		Endereco endereco2 = new Endereco(CEP, LOGRADOURO, COMPLEMENTO, NUMERO, BAIRRO, ESTADO, CIDADE);
		assertTrue(endereco1.equals(endereco2) && endereco2.equals(endereco1));
		boolean resp = endereco2.hashCode() == endereco1.hashCode();
		assertTrue(resp);
	}
}
