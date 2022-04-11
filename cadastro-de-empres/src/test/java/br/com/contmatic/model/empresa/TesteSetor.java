package br.com.contmatic.model.empresa;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.contmatic.model.contato.Email;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteSetor {

	private static final Email EMAIL = new Email("giovannelrodrigues@gmail.com");
	
	private static final String IP = "122.21.123.1";

	private static final LocalDateTime LOCAL_TIME = LocalDateTime.of(2023, Month.JUNE, 28, 6, 30, 40, 50000);

	private static AmbienteTrabalho ambienteBefore;

	private static Empresa empresaBefore;

	private static Setor setorBefore;

	private static final String NOME = "Departemendo de contas a receber";

	@Before
	public void antesDeCadaTestes() {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		empresaBefore = new Empresa("63516934000109");
		ambienteBefore = new AmbienteTrabalho("financeiro", empresaBefore);
		setorBefore = new Setor(NOME, ambienteBefore);
		funcionarios.add(new Funcionario("41326382004", setorBefore));
		setorBefore.setFuncionarios(funcionarios);
		setorBefore.setCreatedBy(EMAIL);
		setorBefore.setCreateDate(LOCAL_TIME);
		setorBefore.setUpdateBy(EMAIL);
		setorBefore.setUpdatedDate(LOCAL_TIME);
		setorBefore.setCreatedIp(IP);
		setorBefore.setUpdatedIp(IP);
	}

	// CONSTRUTOR
	@Test
	public void teste01_deve_instaciar_um_setor_com_campos_obrigatorios() {
		Setor setor = new Setor(NOME, ambienteBefore);
		assertEquals(NOME, setor.getNome());
		assertEquals(ambienteBefore, setor.getAmbienteTrabalho());
	}

	// NOME
	@Test
	public void teste02_deve_atribuir_um_novo_nome_para_setor() {
		String nome = "Desenv";
		setorBefore.setNome(nome);
		assertEquals(nome, setorBefore.getNome());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste03_nao_deve_atribuir_um_novo_nome_para_setor_passando_nulo() {
		setorBefore.setNome(null);
	}

	@Test(expected = IllegalStateException.class)
	public void teste04_nao_deve_atribuir_um_novo_nome_para_setor_passando_vazio() {
		setorBefore.setNome("    ");
	}

	@Test(expected = IllegalStateException.class)
	public void teste05_nao_deve_atribuir_um_novo_nome_para_setor_passando_mais_60_caracteres() {
		setorBefore.setNome("RH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RH");
	}

	@Test(expected = IllegalStateException.class)
	public void teste06_nao_deve_atribuir_um_novo_nome_para_setor_passando_menos_3_caracteres() {
		setorBefore.setNome("Ab");
	}

	@Test(expected = IllegalStateException.class)
	public void teste07_nao_deve_atribuir_um_novo_nome_para_setor_passando_caracteres_especiais() {
		setorBefore.setNome("RECURSO # HUMANOS");
	}

	@Test(expected = IllegalStateException.class)
	public void teste08_nao_deve_atribuir_um_novo_nome_para_setor_passando_numeros() {
		setorBefore.setNome("123456abc");
	}

	// DESCRICAO
	@Test
	public void teste09_deve_atribuir_uma_nova_descricao_para_setor() {
		String descricao = "Recrutamento e gerenciamento de pessoas";
		setorBefore.setDescricao(descricao);
		assertEquals(descricao, setorBefore.getDescricao());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste10_nao_deve_atribuir_uma_nova_descricao_para_setor_passando_nulo() {
		setorBefore.setDescricao(null);
	}

	@Test(expected = IllegalStateException.class)
	public void teste11_nao_deve_atribuir_uma_nova_descricao_para_setor_passando_vazio() {
		setorBefore.setDescricao("    ");
	}

	@Test(expected = IllegalStateException.class)
	public void teste12_nao_deve_atribuir_uma_nova_descricao_para_trabalho_passando_mais_256_caracteres() {
		setorBefore.setDescricao(
				"RH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RH");
	}

	@Test(expected = IllegalStateException.class)
	public void teste13_nao_deve_atribuir_um_novo_nome_para_setor_passando_menos_3_caracteres() {
		setorBefore.setNome("Ab");
	}

	@Test
	public void teste14_deve_atribuir_uma_nova_descricao_para_setor_passando_caracteres_especiais() {
		setorBefore.setDescricao("#Descricao");
		assertEquals("#Descricao", setorBefore.getDescricao());
	}

	@Test
	public void teste15_deve_atribuir_uma_nova_descricao_para_setor_passando_numeros() {
		setorBefore.setDescricao("101010");
		assertEquals("101010", setorBefore.getDescricao());
	}

	// LISTA FUNCIONARIOS
	@Test
	public void teste16_deve_atribuir_uma_nova_lista_funcionarios() {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		funcionarios.add(new Funcionario("41326382004", setorBefore));
		setorBefore.setFuncionarios(funcionarios);
		assertEquals(funcionarios, setorBefore.getFuncionarios());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste17_nao_deve_atribuir_uma_nova_lista_funcionarios_passando_nulo() {
		setorBefore.setFuncionarios(null);
	}

	@Test(expected = IllegalStateException.class)
	public void teste18_nao_deve_atribuir_uma_nova_lista_funcionarios_vazia() {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		setorBefore.setFuncionarios(funcionarios);
	}

	@Test(expected = IllegalStateException.class)
	public void teste19_nao_deve_atribuir_uma_nova_lista_funcionarios_com_mais_de_999_funcionarios() {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		for (int index = 1000; index != 0; index--) {
			funcionarios.add(new Funcionario("41326382004", setorBefore));
		}
		setorBefore.setFuncionarios(funcionarios);
	}

	// AMBIENTE TRABALHO
	@Test
	public void teste20_deve_atribuir_um_novo_ambiente_trabalho() {
		AmbienteTrabalho ambiente = new AmbienteTrabalho(NOME, empresaBefore);
		setorBefore.setAmbienteTrabalho(ambiente);
		assertEquals(ambiente, setorBefore.getAmbienteTrabalho());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste21_nao_deve_atribuir_uma_nova_descricao_para_setor_passando_nulo() {
		setorBefore.setAmbienteTrabalho(null);
	}

	// TO STRING
	@Test
	public void teste22_deve_retonar_nome_no_to_string() {
		String result = setorBefore.toString();
		assertThat(result, containsString(setorBefore.getNome()));
	}

	@Test
	public void teste23_deve_retonar_no_to_string() {
		setorBefore.setDescricao("teste teste");
		String result = setorBefore.toString();
		assertThat(result, containsString(setorBefore.getDescricao()));
	}

	@Test
	public void teste24_deve_retonar_lista_funcionarios_no_to_string() {
		String result = setorBefore.toString();
		assertThat(result, containsString(String.valueOf(setorBefore.getFuncionarios())));
	}

	// HASHCODE
	@Test
	public void teste25_deve_retornar_o_mesmo_hashcode_para_da_setor_com_mesmo_nome() {
		Setor setor1 = new Setor(NOME, ambienteBefore);
		Setor setor2 = new Setor(NOME, ambienteBefore);
		boolean resp = setor1.hashCode() == setor2.hashCode();
		assertTrue(resp);
	}

	@Test
	public void teste26_deve_retornar_false_hashcode_para_da_setor_com_nome_diferentes() {
		Setor setor1 = new Setor(NOME, ambienteBefore);
		Setor setor2 = new Setor("Teste test", ambienteBefore);
		boolean resp = setor1.hashCode() == setor2.hashCode();
		assertFalse(resp);
	}

	// EQUALS
	@Test
	public void teste27_deve_retornar_true_quando_usar_equals_passado_nome_iguais() {
		Setor setor1 = new Setor(NOME, ambienteBefore);
		Setor setor2 = new Setor(NOME, ambienteBefore);
		boolean resp = setor1.equals(setor2);
		assertTrue(resp);
	}

	@Test
	public void teste28_deve_retornar_false_quando_usar_equals_passado_nome_diferentes() {
		Setor setor1 = new Setor(NOME, ambienteBefore);
		Setor setor2 = new Setor("Teste teste", ambienteBefore);
		boolean resp = setor1.equals(setor2);
		assertFalse(resp);
	}

	@Test
	public void teste29_deve_retornar_falso_quando_usar_equals_passado_nulo() {
		boolean resp = setorBefore.equals(null);
		assertFalse(resp);
	}

	@Test
	public void teste30_deve_retornar_falso_quando_usar_equals_passado_object() {
		boolean resp = setorBefore.equals(new Object());
		assertFalse(resp);
	}

	@Test
	public void teste31_deve_retornar_verdadeiro_quando_usar_equals_passado_o_proprio_objeto() {
		boolean resp = setorBefore.equals(setorBefore);
		assertTrue(resp);
	}
}
