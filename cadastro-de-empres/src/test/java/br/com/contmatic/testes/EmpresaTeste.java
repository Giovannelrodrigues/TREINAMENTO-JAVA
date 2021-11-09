package br.com.contmatic.testes;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import java.time.Duration;

import org.junit.Before;
import org.junit.FixMethodOrder;

import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.contmatic.enums.TipoEstabelecimento;
import br.com.contmatic.model.AmbienteTrabalho;
import br.com.contmatic.model.Contato;
import br.com.contmatic.model.Empresa;
import br.com.contmatic.model.Endereco;
import br.com.contmatic.model.Produto;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmpresaTeste {
	
	private static Empresa empresaBefore;

	private static Endereco enderecoBefore;
	
	private static Contato contatoBefore;
	
	private static final String RAZAO_SOCIAL = "SOFTMATIC ... LTDA";
	
	private static final String CNPJ = "58119371000177";
	
	private static final String EMAIL = "cont@contmatic.com";
	
	private static final String TELEFONE = "11996300338";
	
	private static final String CEP = "12243670";
	
	private static final String LOGRADOURO = "Rua Major Vaz";
			
	private static final String COMPLEMENTO = "Predio empresa";
	
	private static final Integer NUMERO = 157;
	
	private static final String BAIRRO = "Vila Adyana";
	
	private static final String CIDADE = "São paulo";
	
	private static final String ESTADO = "São paulo";
	
	private static final String NOME_FANTASIA = "Contmatic phoenix";
	
	private static final String VAZIO = "  ";
	
	private static final String CARACTERES_150 = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
	
	@Before
	public void antesDeCadaTeste() {
		enderecoBefore = new Endereco(CEP, LOGRADOURO, COMPLEMENTO, NUMERO, BAIRRO, ESTADO, CIDADE);
		contatoBefore  = new Contato(EMAIL, TELEFONE);
		empresaBefore  = new Empresa(RAZAO_SOCIAL, CNPJ, NOME_FANTASIA, enderecoBefore , contatoBefore);
	}
	
	//CONSTRUTORES
	
	@Test
	public void testeA_deve_instanciar_objeto_empresa_corretamente_preenchendo_todos_os_campos() {
		assertEquals(RAZAO_SOCIAL, empresaBefore.getRazaoSocial());
		assertEquals(CNPJ, empresaBefore.getCnpj());
		assertEquals(NOME_FANTASIA, empresaBefore.getNomeFantasia());
		assertEquals(enderecoBefore, empresaBefore.getEndereco());
		assertEquals(contatoBefore, empresaBefore.getContato());
	}
	
	@Test
	public void testeB_deve_instanciar_objeto_empresa_corretamente_preenchendo_nome_fantasia_nulo() {
		Empresa empresa = new Empresa(RAZAO_SOCIAL, CNPJ, null, enderecoBefore , contatoBefore);
		assertNotNull(empresa);
		assertEquals(RAZAO_SOCIAL, empresa.getRazaoSocial());
		assertEquals(CNPJ, empresa.getCnpj());
		assertEquals(null, empresa.getNomeFantasia());
		assertEquals(enderecoBefore, empresa.getEndereco());
		assertEquals(contatoBefore, empresa.getContato());
	}
	
	//VAZIO
	
	@Test (expected = IllegalStateException.class)
	public void testeC_nao_deve_instanciar_objeto_empresa_preenchendo_razao_social_vazio() {
		new Empresa(VAZIO, CNPJ, NOME_FANTASIA, enderecoBefore , contatoBefore);
	}
	
	@Test (expected = IllegalStateException.class)
	public void testeD_nao_deve_instanciar_objeto_empresa_preenchendo_cnpj_vazio() {
		new Empresa(RAZAO_SOCIAL, VAZIO, NOME_FANTASIA, enderecoBefore , contatoBefore);
	}
	
	//NULO
	
	@Test (expected = IllegalArgumentException.class)
	public void testeE_nao_deve_instanciar_objeto_empresa_preenchendo_razao_social_nulo() {
		new Empresa(null, CNPJ, NOME_FANTASIA, enderecoBefore , contatoBefore);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testeF_nao_deve_instanciar_objeto_empresa_preenchendo_cnpj_nulo() {
		new Empresa(RAZAO_SOCIAL, null, NOME_FANTASIA, enderecoBefore , contatoBefore);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testeG_nao_deve_instanciar_objeto_empresa_preenchendo_endereco_nulo() {
		new Empresa(RAZAO_SOCIAL, CNPJ, NOME_FANTASIA, null , contatoBefore);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testeH_nao_deve_instanciar_objeto_empresa_preenchendo_contato_nulo() {
		new Empresa(RAZAO_SOCIAL, CNPJ, NOME_FANTASIA, enderecoBefore , null);
	}
	
	//CARACTERES
	
	@Test (expected = IllegalStateException.class)
	public void testeI_nao_deve_instanciar_objeto_empresa_preenchendo_razao_social_com_mais_de_100_caracteres() {
		new Empresa(CARACTERES_150, CNPJ, NOME_FANTASIA, enderecoBefore , contatoBefore);
	}
	
	@Test (expected = IllegalStateException.class)
	public void testeJ_nao_deve_instanciar_objeto_empresa_preenchendo_cnpj_com_mais_de_14_caracteres() {
		new Empresa(RAZAO_SOCIAL, CARACTERES_150, NOME_FANTASIA, enderecoBefore , contatoBefore);
	}
	
	@Test (expected = IllegalStateException.class)
	public void testeK_nao_deve_instanciar_objeto_empresa_preenchendo_nome_fantasia_com_mais_de_100_caracteres() {
		new Empresa(RAZAO_SOCIAL, CNPJ, CARACTERES_150, enderecoBefore , contatoBefore);
	}
	
	//CAMPOS SOMENTE LETRAS
	
	@Test (expected = IllegalStateException.class)
	public void testeL_nao_deve_atribuir_razao_social_passando_numero(){
		new Empresa("123teste", CNPJ, NOME_FANTASIA, enderecoBefore , contatoBefore);
	}
	
	//SETTERS

	@Test
	public void testeM_deve_atribuir_um_valor_para_razao_social() {
		final String razao_social = "Softmatic ltda";
		empresaBefore.setRazaoSocial(razao_social);
		assertEquals(razao_social, empresaBefore.getRazaoSocial());
	}
	
	@Test
	public void testeN_deve_atribuir_um_valor_para_cnpj() {
		final String cnpj = "27383589000100";
		empresaBefore.setCnpj(cnpj);
		assertEquals(cnpj, empresaBefore.getCnpj());
	}
	
	@Test
	public void testeO_deve_atribuir_um_valor_para_nome_fantasia() {
		final String nomeFantasia = "Contmatic";
		empresaBefore.setNomeFantasia(nomeFantasia);
		assertEquals(nomeFantasia, empresaBefore.getNomeFantasia());
	}
	
	@Test
	public void testeP_deve_atribuir_um_valor_para_endereco() {
		final Endereco endereco = new Endereco(CEP, LOGRADOURO, null, NUMERO, BAIRRO, ESTADO, CIDADE);
		empresaBefore.setEndereco(endereco);
		assertEquals(endereco, empresaBefore.getEndereco());
	}
	
	@Test
	public void testeQ_deve_atribuir_um_valor_para_contato() {
		final Contato contato = new Contato("contmatic@phoenix.com", TELEFONE);
		empresaBefore.setContato(contato);
		assertEquals(contato, empresaBefore.getContato());
	}
	
	//ADICONAR A LISTA
	
	@Test
	public void testeR_deve_adicionar_um_novo_ambiente_trabalho() {
		AmbienteTrabalho ambiente = new AmbienteTrabalho("RH", TipoEstabelecimento.PROPRIO, "RH");
		empresaBefore.adicionarAmbienteTrabalho(ambiente);
		assertEquals(1, empresaBefore.getAmbientesTrabalhos().size());
	}
	
	@Test
	public void testeS_deve_adicionar_um_novo_produto() {
		Produto produto = new Produto("AIRJ-52255-MD4", "AIR JORDAN 3 LOW", "AIR JORDA X NIKE", 1499.99, 12, "Preto - Vermelho");
		empresaBefore.adicionarProduto(produto);
		assertEquals(1, empresaBefore.getProdutos().size());
	}
	
	//GETTERS
	
	@Test
	public void testeT_deve_pegar_razao_social_do_objeto_empresa() {
		assertEquals(RAZAO_SOCIAL, empresaBefore.getRazaoSocial());
	}
	
	@Test
	public void testeU_deve_pegar_cnpj_do_objeto_empresa() {
		assertEquals(CNPJ, empresaBefore.getCnpj());
	}
	
	@Test
	public void testeV_deve_pegar_nome_fantasia_do_objeto_empresa() {
		assertEquals(NOME_FANTASIA , empresaBefore.getNomeFantasia());
	}
	
	@Test
	public void testeW_deve_pegar_endereco_do_objeto_empresa() {
		assertEquals(enderecoBefore , empresaBefore.getEndereco());
	}
	
	@Test
	public void testeX_deve_pegar_lista_de_ambientes_do_objeto_empresa() {
		assertNotNull(empresaBefore.getAmbientesTrabalhos());
	}
	
	@Test
	public void testeY_deve_pegar_lista_de_produtos_do_objeto_empresa() {
		assertNotNull(empresaBefore.getProdutos());
	}
	
	@Test
	public void testeZ_deve_pegar_contato_do_objeto_empresa() {
		assertEquals(contatoBefore , empresaBefore.getContato());
	}
	
	
	//TIMEOUT
	
	@Test
	public void testeAA_deve_validar_se_para_criar_um_objeto_empresa_demora_menos_que_2_segundos() {
		assertTimeout(Duration.ofSeconds(2), () -> {new Empresa(RAZAO_SOCIAL, CNPJ, NOME_FANTASIA, enderecoBefore , contatoBefore);});
	}
	
	@Test
	public void testeAB_deve_validar_se_para_pegar_o_valor_de_um_objeto_empresa_demora_menos_que_2_segundos() {
		assertTimeout(Duration.ofSeconds(2), () -> { empresaBefore.getRazaoSocial();});
	}
	
	//TO STRING
	@Test
	public void testeAC_deve_validar_se_ao_usar_o_metodos_to_string_ele_traz_razao_social() {
		String result = empresaBefore.toString();
		assertThat(result, containsString(empresaBefore.getRazaoSocial()));
	}
	
	@Test
	public void testeAD_deve_validar_se_ao_usar_o_metodos_to_string_ele_traz_cnpj() {
		String result = empresaBefore.toString();
		assertThat(result, containsString(empresaBefore.getCnpj()));
	}
	
	@Test
	public void testeAE_deve_validar_se_ao_usar_o_metodos_to_string_ele_traz_nome_fantasia() {
		String result = empresaBefore.toString();
		assertThat(result, containsString(empresaBefore.getNomeFantasia()));
	}
	
	@Test (expected = NullPointerException.class)
	public void testeAF_nao_deve_retornar_nome_fantasia_no_metodo_tostring_quando_instaciar_sem_passar_nome_fantasia() {
		Empresa empresa = new Empresa(RAZAO_SOCIAL, CNPJ, null, enderecoBefore , contatoBefore);
		String result = empresa.toString();
		assertThat(result, containsString(empresa.getNomeFantasia()));
	}
	
	@Test
	public void testeAG_deve_validar_se_to_string_traz_as_infomacoes_de_produtos() {
		Produto produto = new Produto("AIRJ-52255-MD4", "AIR JORDAN 3 LOW", "AIR JORDA X NIKE", 1499.99, 12, "Preto - Vermelho");
		empresaBefore.adicionarProduto(produto);
		String result = empresaBefore.toString();
		assertThat(result, containsString("produtos"));
	}
	
	@Test
	public void testeAH_deve_validar_se_to_string_traz_as_infomacoes_de_ambientes_trabalho() {
		AmbienteTrabalho ambiente = new AmbienteTrabalho("RH", TipoEstabelecimento.PROPRIO, "RH");
		empresaBefore.adicionarAmbienteTrabalho(ambiente);
		String result = empresaBefore.toString();
		assertThat(result, containsString("AmbienteTrabalho"));
	}
	
	//EQUALS
	
	@Test
	public void testeAI_deve_validar_equals_do_objeto_funcionario() {
		Empresa empresa1 = new Empresa(RAZAO_SOCIAL, CNPJ, NOME_FANTASIA, enderecoBefore , contatoBefore);
		Empresa empresa2 = new Empresa(RAZAO_SOCIAL, CNPJ, NOME_FANTASIA, enderecoBefore , contatoBefore);
		boolean resp = empresa1.equals(empresa2);
		assertTrue(resp);
	}
	
	@Test
	public void testeAJ_deve_validar_equals_do_objeto_funcionario_passando_nulo() {
		boolean resp = empresaBefore.equals(null);
		assertFalse(resp);
	}
	
	@Test
	public void testeAK_deve_validar_equals_do_objeto_funcionario_passando_a_propria_classe() {
		@SuppressWarnings("unlikely-arg-type")
		boolean resp = empresaBefore.equals(empresaBefore.getClass());
		assertFalse(resp);
	}
	
	@Test
	public void testeAL_deve_validar_equals_do_objeto_funcionario_passando_this() {
		boolean resp = empresaBefore.equals(empresaBefore);
		assertTrue(resp);
	}
	
	//HASHCODE
	@Test
	public void testeAM_deve_validar_hashcode_do_objeto_empresa() {
		Empresa empresa1 = new Empresa(RAZAO_SOCIAL, CNPJ, NOME_FANTASIA, enderecoBefore , contatoBefore);
		Empresa empresa2 = new Empresa(RAZAO_SOCIAL, CNPJ, NOME_FANTASIA, enderecoBefore , contatoBefore);
		assertTrue(empresa1.equals(empresa2) && empresa2.equals(empresa1));
		boolean resp = empresa2.hashCode() == empresa1.hashCode();
		assertTrue(resp);
	}

}
