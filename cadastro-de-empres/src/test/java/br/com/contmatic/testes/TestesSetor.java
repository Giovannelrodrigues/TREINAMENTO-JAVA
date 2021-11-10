package br.com.contmatic.testes;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.contmatic.model.Cargo;
import br.com.contmatic.model.Contato;
import br.com.contmatic.model.Endereco;
import br.com.contmatic.model.Funcionario;
import br.com.contmatic.model.Setor;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestesSetor {
	
	public static Setor setorBefore;
	
	private static String NOME = "FRONT END";
	
	private static String DESCRICAO =  "desenvolver interface para usuarios";

	private static String CARACTERES_150 =  "123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890";
	
	private static String CARACTERES_300 =  "123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890";

	private static final String EMAIL = "cont@contmatic.com";
	
	private static final String TELEFONE = "11996300338";
	
	private static final String CEP = "12243670";
	
	private static final String LOGRADOURO = "Rua Major Vaz";
			
	private static final String COMPLEMENTO = "Predio empresa";
	
	private static final Integer NUMERO = 157;
	
	private static final String BAIRRO = "Vila Adyana";
	
	private static final String CIDADE = "São paulo";
	
	private static final String ESTADO = "São paulo";
	
	@Before
	public void antesDeCadaTeste() {
		setorBefore = new Setor(NOME, DESCRICAO);
	}
	
	@Test
	public void testeA_deve_instaciar_o_objeto_setor_corretamente() {
		assertEquals(NOME, setorBefore.getNome());
		assertEquals(DESCRICAO, setorBefore.getDescricao());
	}
	
	//VAZIO
	
	@Test (expected = IllegalStateException.class)
	public void testeC_nao_deve_instanciar_objeto_setor_preenchendo_nome_vazio() {
		new Setor(" ", DESCRICAO);
	}
	
	//NULO
	
	@Test
	public void testeB_deve_instaciar_um_objeto_setor_corretamente_passando_descricao_nulo() {
		String descricao = null;
		Setor setor = new Setor(NOME, descricao);
		assertEquals(descricao, setor.getDescricao());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testeC_nao_deve_instanciar_objeto_setor_preenchendo_nome_nulo() {
		new Setor(null, DESCRICAO);
	}
	
	//CARACTERES
	
	@Test (expected = IllegalStateException.class)
	public void testeD_nao_deve_instanciar_objeto_setor_preenchendo_nome_com_mais_de_100_caracteres() {
		new Setor(CARACTERES_150, DESCRICAO);
	} 
	
	@Test (expected = IllegalStateException.class)
	public void testeE_nao_deve_instanciar_objeto_setor_preenchendo_descricao_com_mais_de_256_caracteres() {
		new Setor(NOME, CARACTERES_300);
	}
	
	//SETTERS
	
	@Test
	public void testeE_deve_atribuir_um_valor_para_nome() {
		final String nome = "BACK END";
		setorBefore.setNome(nome);
		assertEquals(nome, setorBefore.getNome());
	}
	
	@Test
	public void testeF_deve_atribuir_um_valor_para_descricao() {
		final String descricao = "cuida da funcionalidade dos apps";
		setorBefore.setDescricao(descricao);
		assertEquals(descricao, setorBefore.getDescricao());
	}

	//SETTER LISTA
	
	@Test
	public void testeG_deve_atribuir_uma_nova_lista_funcionarios() {
		Endereco endereco = new Endereco(CEP, LOGRADOURO, COMPLEMENTO, NUMERO, BAIRRO, ESTADO, CIDADE);
		Contato contato  = new Contato(EMAIL, TELEFONE);
		Cargo cargo = new Cargo("programandor full stack", "desenvolver aplicações web");
		List<Funcionario> funcionarios = new ArrayList<>();
		Funcionario funcionario = new Funcionario("giovanne", "39199101840", endereco, contato, cargo);
		funcionarios.add(funcionario);
		setorBefore.setFuncionarios(funcionarios);
		assertEquals(1, setorBefore.getFuncionarios().size());
	}
	
	
	//SETTER
	@Test
	public void testeH_deve_atribuir_um_novo_nome() {
		String nome = "QA";
		setorBefore.setNome(nome);
		assertEquals(nome, setorBefore.getNome());
	}
	
	@Test
	public void testeI_deve_atribuir_uma_nova_descricao() {
		String descricao = "mater qualidade e fazer teste";
		setorBefore.setDescricao(descricao);
		assertEquals(descricao, setorBefore.getDescricao());
	}
	
	
	//TIMEOUT
	
	@Test
	public void testeJ_deve_validar_se_para_criar_um_objeto_setor_demora_menos_que_2_segundos() {
		assertTimeout(Duration.ofSeconds(2), () -> {new Setor(NOME, DESCRICAO);});
	}
	
	@Test
	public void testeK_deve_validar_se_para_pegar_o_valor_de_um_objeto_setor_demora_menos_que_2_segundos() {
		assertTimeout(Duration.ofSeconds(2), () -> {setorBefore.getNome();});
	}
	
	//TO STRING
	
	@Test
	public void testeL_deve_validar_se_ao_usar_o_metodos_to_string_ele_traz_nome() {
		String result = setorBefore.toString();
		assertThat(result, containsString(setorBefore.getNome()));
	}
	
	@Test
	public void testeM_deve_validar_se_ao_usar_o_metodos_to_string_ele_traz_descricao() {
		String result = setorBefore.toString();
		assertThat(result, containsString(setorBefore.getDescricao()));
	}
	
	@Test
	public void testeT_deve_retornar_lista_de_funcionarios_quando_usar_metodo_to_string() {
		Endereco endereco = new Endereco(CEP, LOGRADOURO, COMPLEMENTO, NUMERO, BAIRRO, ESTADO, CIDADE);
		Contato contato  = new Contato(EMAIL, TELEFONE);
		Cargo cargo = new Cargo("programandor full stack", "desenvolver aplicações web");
		List<Funcionario> funcionarios = new ArrayList<>();
		Funcionario funcionario = new Funcionario("giovanne", "39199101840", endereco, contato, cargo);
		funcionarios.add(funcionario);
		setorBefore.setFuncionarios(funcionarios);
		String result = setorBefore.toString();
		assertThat(result, containsString("funcionarios"));
	}
	
	//EQUALS
	
	@Test
	public void testeU_deve_validar_equals_do_objeto_ambiente_trabalho() {
		Setor setor1 = new Setor(NOME, DESCRICAO);
		Setor setor2 = new Setor(NOME, DESCRICAO);
		boolean resp = setor1.equals(setor2);
		assertTrue(resp);
	}
	
	@Test
	public void testeV_deve_validar_equals_do_objeto_ambiente_trabalho_passando_nulo() {
		boolean resp = setorBefore.equals(null);
		assertFalse(resp);
	}
	
	@Test
	public void testeW_deve_validar_equals_do_objeto_ambiente_trabalho_passando_a_propria_classe() {
		@SuppressWarnings("unlikely-arg-type")
		boolean resp = setorBefore.equals(setorBefore.getClass());
		assertFalse(resp);
	}
	
	@Test
	public void testeX_deve_validar_equals_do_objeto_ambiente_trabalho_passando_this() {
		boolean resp = setorBefore.equals(setorBefore);
		assertTrue(resp);
	}

	//HASHCODE
	
	@Test
	public void testeY_deve_validar_hashcode_do_objeto_empresa() {
		Setor setor1 = new Setor(NOME, DESCRICAO);
		Setor setor2 = new Setor(NOME, DESCRICAO);
		assertTrue(setor1.equals(setor2) && setor2.equals(setor1));
		boolean resp = setor2.hashCode() == setor1.hashCode();
		assertTrue(resp);
	}

}
