package br.com.contmatic.testes;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.contmatic.enums.TipoEstabelecimento;
import br.com.contmatic.model.AmbienteTrabalho;
import br.com.contmatic.model.Setor;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestesAmbienteTrabalho {
	
	static AmbienteTrabalho ambienteBefore;
	
	private static String NOME = "Recursos Humanos";
	
	private static String DESCRICAO = "Contrata��o e demis�o de pessoas";
	
	private static final String VAZIO = "";
	
	private static final String CARACTERES_150 = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
	
	private static final String CARACTERES_300 = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
	
	private static String NOME_SETOR = "Contas a pagar";
	
	private static String DESCRICAO_SETOR = "gerenciar contas da empresa";
	
	@Before
	public void antesDeCadaTeste() {
		List<Setor> setores = new ArrayList<>();
		setores.add(new Setor(NOME_SETOR, DESCRICAO_SETOR));
		ambienteBefore = new AmbienteTrabalho(NOME, TipoEstabelecimento.PROPRIO, DESCRICAO);
		ambienteBefore.setSetores(setores);
	}
	
	//CONSTRUTORES
	@Test
	public void testeA_deve_instanciar_objeto_ambiente_empresa_corretamente_preenchendo_todos_os_campos() {
		assertEquals(NOME, ambienteBefore.getNome());
		assertEquals(DESCRICAO, ambienteBefore.getDescricao());
		assertEquals(TipoEstabelecimento.PROPRIO, ambienteBefore.getTipoEstabelecimento());
	}
	
	//VAZIO
	
	@Test
	public void testeB_deve_instanciar_objeto_ambiente_empresa_passando_descricao_vazio() {
		AmbienteTrabalho ambiente = new AmbienteTrabalho(NOME, TipoEstabelecimento.TERCEIRO, VAZIO);
		assertNotNull(ambiente);
	}
	
	@Test (expected = IllegalStateException.class)
	public void testeC_nao_deve_instanciar_objeto_ambiente_preenchendo_nome_vazio() {
		new AmbienteTrabalho(VAZIO, TipoEstabelecimento.TERCEIRO, DESCRICAO);
	}
	
	
	//NULO
	
	@Test (expected = IllegalArgumentException.class)
	public void testeD_nao_deve_instanciar_objeto_ambiente_preenchendo_tipo_estabelecimento_nulo() {
		new AmbienteTrabalho(NOME, null, DESCRICAO);
	}
	
	@Test
	public void testeE_deve_instanciar_objeto_ambiente_passando_descricao_nulo() {
		AmbienteTrabalho ambiente = new AmbienteTrabalho(NOME, TipoEstabelecimento.TERCEIRO, null);
		assertNotNull(ambiente);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testeF_nao_deve_instanciar_objeto_ambiente_preenchendo_nome_nulo() {
		new AmbienteTrabalho(null, TipoEstabelecimento.TERCEIRO, DESCRICAO);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testeG_nao_deve_instanciar_objeto_ambiente_preenchendo_tipo_nulo() {
		new AmbienteTrabalho(null, TipoEstabelecimento.TERCEIRO, DESCRICAO);
	}
	
	//CARACTERES
	
	@Test (expected = IllegalStateException.class)
	public void testeI_nao_deve_instanciar_objeto_ambiente_preenchendo_nome_com_mais_de_100_caracteres() {
		new AmbienteTrabalho(CARACTERES_150,TipoEstabelecimento.TERCEIRO, DESCRICAO);
	} 
	
	@Test (expected = IllegalStateException.class)
	public void testeJ_nao_deve_instanciar_objeto_ambiente_preenchendo_descricao_com_mais_de_256_caracteres() {
		new AmbienteTrabalho(NOME, TipoEstabelecimento.TERCEIRO, CARACTERES_300);
	}
	
	//SETTERS
	
	@Test
	public void testeK_deve_atribuir_um_valor_para_nome() {
		final String nome = "Financeiro";
		ambienteBefore.setNome(nome);
		assertEquals(nome, ambienteBefore.getNome());
	}
	
	@Test
	public void testeL_deve_atribuir_um_valor_para_descricao() {
		final String descricao = "cuidar do dinheiro da empresa, contas a pagar, contas a receber";
		ambienteBefore.setDescricao(descricao);
		assertEquals(descricao, ambienteBefore.getDescricao());
	}
	
	@Test
	public void testeM_deve_atribuir_um_valor_para_tipo_do_ambiente() {
		ambienteBefore.setTipoEstabelecimento(TipoEstabelecimento.TERCEIRO);
		assertEquals(TipoEstabelecimento.TERCEIRO, ambienteBefore.getTipoEstabelecimento());
	}
	
	//SETTER LISTA
	
	@Test
	public void testeN_deve_atribuir_uma_nova_lista_setor() {
		List<Setor> setores = new ArrayList<>();
		setores.add(new Setor(NOME_SETOR, DESCRICAO_SETOR));
		ambienteBefore.setSetores(setores);
		assertNotNull(ambienteBefore.getSetores());	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testeO_nao_deve_atribuir_uma_setores_passando_nulo() {
		ambienteBefore.setSetores(null);
	}
	
	@Test (expected = IllegalStateException.class)
	public void testeP_nao_deve_atribuir_uma_lista_setores_passando_array_vazio() {
		List<Setor> setores = new ArrayList<Setor>();
		ambienteBefore.setSetores(setores);
	}
	
	//GETTERS
	
	@Test
	public void testeQ_deve_pegar_nome_do_objeto_ambiente_trabalho() {
		assertEquals(NOME, ambienteBefore.getNome());
	}
	
	@Test
	public void testeR_deve_pegar_descricao_do_objeto_ambiente_trabalho() {
		assertEquals(DESCRICAO, ambienteBefore.getDescricao());
	}
	
	@Test
	public void testeS_deve_pegar_tipo_estabelecimento_do_objeto_ambiente_trabalho() {
		assertEquals(TipoEstabelecimento.PROPRIO, ambienteBefore.getTipoEstabelecimento());
	}
	
	@Test
	public void testeT_deve_pegar_lista_setores_do_objeto_ambiente_trabalho() {
		List<Setor> setores = new ArrayList<>();
		setores.add(new Setor(NOME_SETOR, DESCRICAO_SETOR));
		assertEquals(setores, ambienteBefore.getSetores());
	}
	
	//TIMEOUT
	
	@Test
	public void testeU_deve_validar_se_para_criar_um_objeto_ambiente_trabalho_demora_menos_que_2_segundos() {
		assertTimeout(Duration.ofSeconds(2), () -> {new AmbienteTrabalho(NOME, TipoEstabelecimento.TERCEIRO, DESCRICAO);});
	}
	
	@Test
	public void testeV_deve_validar_se_para_pegar_o_valor_de_um_objeto_ambiente_trabalho_demora_menos_que_2_segundos() {
		assertTimeout(Duration.ofSeconds(2), () -> {ambienteBefore.getNome();});
	}
	
	//TOSTRING
	
	@Test
	public void testeW_deve_retornar_nome_quando_usar_metodo_to_string() {
		String result = ambienteBefore.toString();
		assertThat(result, containsString(ambienteBefore.getNome()));
	}
	
	@Test
	public void testeX_deve_retornar_tipo_do_estabelecimento_quando_usar_metodo_to_string() {
		String result = ambienteBefore.toString();
		assertThat(result, containsString(String.valueOf(ambienteBefore.getTipoEstabelecimento())));
	}
	
	@Test
	public void testeY_deve_retornar_descricao_quando_usar_metodo_to_string() {
		String result = ambienteBefore.toString();
		assertThat(result, containsString(ambienteBefore.getDescricao()));
	}
	
	@Test
	public void testeZ_deve_retornar_lista_de_setores_quando_usar_metodo_to_string() {
		String result = ambienteBefore.toString();
		assertThat(result, containsString("setores"));
	}
	
	//EQUALS
	
	@Test
	public void testeAA_deve_validar_equals_do_objeto_ambiente_trabalho() {
		AmbienteTrabalho ambiente1 = new AmbienteTrabalho(NOME, TipoEstabelecimento.PROPRIO, DESCRICAO);
		AmbienteTrabalho ambiente2 = new AmbienteTrabalho(NOME, TipoEstabelecimento.PROPRIO, DESCRICAO);
		boolean resp = ambiente1.equals(ambiente2);
		assertTrue(resp);
	}
	
	@Test
	public void testeAB_deve_validar_equals_do_objeto_ambiente_trabalho_passando_nulo() {
		boolean resp = ambienteBefore.equals(null);
		assertFalse(resp);
	}
	
	@Test
	public void testeAC_deve_validar_equals_do_objeto_ambiente_trabalho_passando_a_propria_classe() {
		@SuppressWarnings("unlikely-arg-type")
		boolean resp = ambienteBefore.equals(ambienteBefore.getClass());
		assertFalse(resp);
	}
	
	@Test
	public void testeAD_deve_validar_equals_do_objeto_ambiente_trabalho_passando_this() {
		boolean resp = ambienteBefore.equals(ambienteBefore);
		assertTrue(resp);
	}

	//HASHCODE
	@Test
	public void testeAE_deve_validar_hashcode_do_objeto_empresa() {
		AmbienteTrabalho ambiente1 = new AmbienteTrabalho(NOME, TipoEstabelecimento.PROPRIO, DESCRICAO);
		AmbienteTrabalho ambiente2 = new AmbienteTrabalho(NOME, TipoEstabelecimento.PROPRIO, DESCRICAO);
		assertTrue(ambiente1.equals(ambiente2) && ambiente2.equals(ambiente1));
		boolean resp = ambiente2.hashCode() == ambiente1.hashCode();
		assertTrue(resp);
	}
	
}
