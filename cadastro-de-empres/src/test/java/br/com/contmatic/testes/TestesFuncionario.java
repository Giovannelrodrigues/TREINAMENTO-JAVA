package br.com.contmatic.testes;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.contmatic.model.Cargo;
import br.com.contmatic.model.Contato;
import br.com.contmatic.model.Endereco;
import br.com.contmatic.model.Funcionario;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestesFuncionario {
	
	private static Funcionario funcionarioBefore;

	private static Endereco enderecoBefore;
	
	private static Contato contatoBefore;
	
	private static Cargo cargoBefore;
	
	private static final String NOME = "GIOVANNE LISBOA RODRIGUES";
	
	private static final String CPF = "39199101840";
	
	private static final String EMAIL = "giovanne@contmatic.com";
	
	private static final String TELEFONE = "11996300338";
	
	private static final String CEP = "12243670";
	
	private static final String LOGRADOURO = "Rua Major Vaz";
			
	private static final String COMPLEMENTO = "Predio empresa";
	
	private static final Integer NUMERO = 157;
	
	private static final String BAIRRO = "Vila Adyana";
	
	private static final String CIDADE = "São paulo";
	
	private static final String ESTADO = "São paulo";
	
	private static final String CARACTERES_150 = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
	
	
	@Before
	public void antesDeCadaTeste() {
		enderecoBefore = new Endereco(CEP, LOGRADOURO, COMPLEMENTO, NUMERO, BAIRRO, ESTADO, CIDADE);
		contatoBefore  = new Contato(EMAIL, TELEFONE);
		cargoBefore = new Cargo("programandor full stack", "desenvolver aplicações web");
		funcionarioBefore = new Funcionario(NOME, CPF, enderecoBefore, contatoBefore, cargoBefore);
	}
	
	
	@Test
	public void testeA_deve_instaciar_o_objeto_setor_corretamente() {
		assertEquals(NOME, funcionarioBefore.getNome());
		assertEquals(CPF, funcionarioBefore.getCpf());
		assertEquals(enderecoBefore, funcionarioBefore.getEndereco());
		assertEquals(contatoBefore, funcionarioBefore.getContato());
		assertEquals(cargoBefore, funcionarioBefore.getCargo());
	}
	
	//VAZIO
	
	@Test (expected = IllegalStateException.class)
	public void testeC_nao_deve_instanciar_objeto_funcionario_preenchendo_nome_vazio() {
		new Funcionario(" ", CPF, enderecoBefore, contatoBefore, cargoBefore);
	}
	
	@Test (expected = IllegalStateException.class)
	public void testeD_nao_deve_instanciar_objeto_funcionario_preenchendo_CPF_vazio() {
		new Funcionario(NOME, "", enderecoBefore, contatoBefore, cargoBefore);
	}
	
	//NULO
	
	@Test (expected = IllegalArgumentException.class)
	public void testeE_nao_deve_instanciar_objeto_funcionario_preenchendo_nome_nulo() {
		new Funcionario(null, CPF, enderecoBefore, contatoBefore, cargoBefore);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testeF_nao_deve_instanciar_objeto_funcionario_preenchendo_nome_cpf() {
		new Funcionario(NOME,  null, enderecoBefore, contatoBefore, cargoBefore);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testeG_nao_deve_instanciar_objeto_funcionario_preenchendo_nome_endereco() {
		new Funcionario(NOME, CPF, null, contatoBefore, cargoBefore);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testeH_nao_deve_instanciar_objeto_funcionario_preenchendo_nome_contato() {
		new Funcionario(NOME, CPF, enderecoBefore, null, cargoBefore);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testeI_nao_deve_instanciar_objeto_funcionario_preenchendo_nome_cargo() {
		new Funcionario(NOME, CPF, enderecoBefore, contatoBefore, null);
	}
	
	//CARACTERES
	
	@Test (expected = IllegalStateException.class)
	public void testeJ_nao_deve_instanciar_objeto_funcionario_preenchendo_nome_com_mais_de_100_caracteres() {
		new Funcionario(CARACTERES_150, CPF, enderecoBefore, contatoBefore, cargoBefore);
	} 
	
	//CAMPOS SOMENTE LETRAS
	
	@Test (expected = IllegalStateException.class)
	public void testeK_nao_deve_atribuir_nome_passando_numero(){
		new Funcionario("teste123", CPF, enderecoBefore, contatoBefore, cargoBefore);
	}
	
	//SETTERS
	
	@Test
	public void testeL_deve_atribuir_um_valor_para_nome() {
		final String nome = "Pedro";
		funcionarioBefore.setNome(nome);
		assertEquals(nome, funcionarioBefore.getNome());
	}
	
	@Test
	public void testeM_deve_atribuir_um_valor_para_cpf() {
		final String cpf = "75520804001";
		funcionarioBefore.setCpf(cpf);
		assertEquals(cpf, funcionarioBefore.getCpf());
	}
	
	@Test
	public void testeN_deve_atribuir_um_valor_para_endereco() {
		Endereco endereco = new Endereco(CEP, LOGRADOURO, COMPLEMENTO, NUMERO, BAIRRO, ESTADO, CIDADE);
		funcionarioBefore.setEndereco(endereco);
		assertEquals(endereco, funcionarioBefore.getEndereco());
	}
	
	@Test
	public void testeO_deve_atribuir_um_valor_para_contato() {
		Contato contato  = new Contato(EMAIL, TELEFONE);
		funcionarioBefore.setContato(contato);
		assertEquals(contato, funcionarioBefore.getContato());
	}
	
	@Test
	public void testeP_deve_atribuir_um_valor_para_cargo() {
		Contato contato  = new Contato(EMAIL, TELEFONE);
		funcionarioBefore.setContato(contato);
		assertEquals(contato, funcionarioBefore.getContato());
	}
	
	//TIMEOUT
	
	@Test
	public void testeQ_deve_validar_se_para_criar_um_objeto_funcionario_demora_menos_que_2_segundos() {
		assertTimeout(Duration.ofSeconds(2), () -> {new Funcionario(NOME, CPF, enderecoBefore, contatoBefore, cargoBefore);});
	}
	
	@Test
	public void testeR_deve_validar_se_para_pegar_o_valor_de_um_objeto_empresa_demora_menos_que_2_segundos() {
		assertTimeout(Duration.ofSeconds(2), () -> {funcionarioBefore.getNome();});
	}
	
	//TO STRING
	@Test
	public void testeS_deve_validar_se_ao_usar_o_metodos_to_string_ele_traz_nome() {
		String result = funcionarioBefore.toString();
		assertThat(result, containsString(funcionarioBefore.getNome()));
	}
	
	@Test
	public void testeT_deve_validar_se_ao_usar_o_metodos_to_string_ele_traz_cpf() {
		String result = funcionarioBefore.toString();
		assertThat(result, containsString(funcionarioBefore.getCpf()));
	}
	
	@Test
	public void testeU_deve_validar_se_ao_usar_o_metodos_to_string_ele_traz_endereco() {
		Funcionario funcionario = new Funcionario(NOME, CPF, enderecoBefore, contatoBefore, cargoBefore);
		String result = funcionario.toString();
		assertThat(result, containsString("endereco"));
	}
	
	@Test
	public void testeV_deve_validar_se_to_string_traz_as_infomacoes_de_contatos() {
		String result = funcionarioBefore.toString();
		assertThat(result, containsString("contato"));
	}
	
	
	@Test
	public void testeW_deve_validar_se_to_string_traz_as_infomacoes_de_produtos() {
		String result = funcionarioBefore.toString();
		assertThat(result, containsString("cargo"));
	}
	
	//EQUALS
	
	@Test
	public void testeX_deve_validar_equals_do_objeto_funcionario() {
		Funcionario funcionario1 = new Funcionario(NOME, CPF, enderecoBefore, contatoBefore, cargoBefore);
		Funcionario funcionario2 = new Funcionario(NOME, CPF, enderecoBefore, contatoBefore, cargoBefore);
		boolean resp = funcionario1.equals(funcionario2);
		assertTrue(resp);
	}
	
	@Test
	public void testeY_deve_validar_equals_do_objeto_funcionario_passando_nulo() {
		boolean resp = funcionarioBefore.equals(null);
		assertFalse(resp);
	}
	
	@Test
	public void testeZ_deve_validar_equals_do_objeto_funcionario_passando_a_propria_classe() {
		@SuppressWarnings("unlikely-arg-type")
		boolean resp = funcionarioBefore.equals(funcionarioBefore.getClass());
		assertFalse(resp);
	}
	
	@Test
	public void testeAA_deve_validar_equals_do_objeto_funcionario_passando_this() {
		boolean resp = funcionarioBefore.equals(funcionarioBefore);
		assertTrue(resp);
	}
	
	//HASHCODE
	@Test
	public void testeAB_deve_validar_hashcode_do_objeto_empresa() {
		Funcionario funcionario1 = new Funcionario(NOME, CPF, enderecoBefore, contatoBefore, cargoBefore);
		Funcionario funcionario2 = new Funcionario(NOME, CPF, enderecoBefore, contatoBefore, cargoBefore);
		assertTrue(funcionario1.equals(funcionario1) && funcionario2.equals(funcionario1));
		boolean resp = funcionario2.hashCode() == funcionario1.hashCode();
		assertTrue(resp);
	}
	
}
