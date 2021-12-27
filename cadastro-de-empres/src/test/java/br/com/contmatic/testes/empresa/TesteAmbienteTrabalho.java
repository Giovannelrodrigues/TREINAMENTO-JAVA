package br.com.contmatic.testes.empresa;

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

import br.com.contmatic.enums.TipoEndereco;
import br.com.contmatic.enums.TipoEstabelecimento;
import br.com.contmatic.model.Cidade;
import br.com.contmatic.model.Email;
import br.com.contmatic.model.Endereco;
import br.com.contmatic.model.Estado;
import br.com.contmatic.model.empresa.AmbienteTrabalho;
import br.com.contmatic.model.empresa.Empresa;
import br.com.contmatic.model.empresa.Setor;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteAmbienteTrabalho {

	private static final Email EMAIL = new Email("giovannelrodrigues@gmail.com");

	private static final LocalDateTime LOCAL_TIME = LocalDateTime.of(2017, Month.FEBRUARY, 3, 6, 30, 40, 50000);

	private static Empresa empresaBefore;

	private static final String CNPJ = "63516934000109";

	private static AmbienteTrabalho ambienteBefore;

	private static final String NOME = "Desenvolvimento";

	@Before
	public void antesDeCadaTeste() {
		empresaBefore = new Empresa(CNPJ);
		ambienteBefore = new AmbienteTrabalho(NOME, empresaBefore);
		ambienteBefore.setCreatedBy(EMAIL);
		ambienteBefore.setCreateDate(LOCAL_TIME);
		ambienteBefore.setLastByUpdadeNotify(EMAIL);
		ambienteBefore.setLastDateUpdadeNotify(LOCAL_TIME);
	}

	// CONSTRUTOR
	@Test
	public void teste01_deve_instaciar_um_ambiente_trabalho_com_campos_obrigatorios() {
		AmbienteTrabalho ambiente = new AmbienteTrabalho(NOME, empresaBefore);
		assertEquals(NOME, ambiente.getNome());
		assertEquals(empresaBefore, ambiente.getEmpresa());
	}

	// NOME
	@Test
	public void teste02_deve_atribuir_um_novo_nome_para_ambiente_trabalho() {
		String nome = "Recursos Humanos";
		ambienteBefore.setNome(nome);
		assertEquals(nome, ambienteBefore.getNome());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste03_nao_deve_atribuir_um_novo_nome_para_ambiente_trabalho_passando_nulo() {
		ambienteBefore.setNome(null);
	}

	@Test(expected = IllegalStateException.class)
	public void teste04_nao_deve_atribuir_um_novo_nome_para_ambiente_trabalho_passando_vazio() {
		ambienteBefore.setNome("    ");
	}

	@Test(expected = IllegalStateException.class)
	public void teste05_nao_deve_atribuir_um_novo_nome_para_ambiente_trabalho_passando_mais_60_caracteres() {
		ambienteBefore.setNome("RH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RH");
	}

	@Test(expected = IllegalStateException.class)
	public void teste06_nao_deve_atribuir_um_novo_nome_para_ambiente_trabalho_passando_menos_3_caracteres() {
		ambienteBefore.setNome("Ab");
	}

	@Test(expected = IllegalStateException.class)
	public void teste07_nao_deve_atribuir_um_novo_nome_para_ambiente_trabalho_passando_caracteres_especiais() {
		ambienteBefore.setNome("RECURSO # HUMANOS");
	}

	@Test(expected = IllegalStateException.class)
	public void teste08_nao_deve_atribuir_um_novo_nome_para_ambiente_trabalho_passando_numeros() {
		ambienteBefore.setNome("123456abc");
	}

	// DESCRICAO
	@Test
	public void teste09_deve_atribuir_uma_nova_descricao_para_ambiente_trabalho() {
		String descricao = "Recrutamento e gerenciamento de pessoas";
		ambienteBefore.setDescricao(descricao);
		assertEquals(descricao, ambienteBefore.getDescricao());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste10_nao_deve_atribuir_uma_nova_descricao_para_ambiente_trabalho_passando_nulo() {
		ambienteBefore.setDescricao(null);
	}

	@Test(expected = IllegalStateException.class)
	public void teste11_nao_deve_atribuir_uma_nova_descricao_para_ambiente_trabalho_passando_vazio() {
		ambienteBefore.setDescricao("    ");
	}

	@Test(expected = IllegalStateException.class)
	public void teste12_nao_deve_atribuir_uma_nova_descricao_para_trabalho_passando_mais_256_caracteres() {
		ambienteBefore.setDescricao(
				"RH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RHRH RH");
	}

	@Test(expected = IllegalStateException.class)
	public void teste13_nao_deve_atribuir_um_novo_nome_para_ambiente_trabalho_passando_menos_3_caracteres() {
		ambienteBefore.setNome("Ab");
	}

	@Test
	public void teste14_deve_atribuir_uma_nova_descricao_para_ambiente_trabalho_passando_caracteres_especiais() {
		ambienteBefore.setDescricao("#Descricao");
		assertEquals("#Descricao", ambienteBefore.getDescricao());
	}

	@Test
	public void teste15_deve_atribuir_uma_nova_descricao_para_ambiente_trabalho_passando_numeros() {
		ambienteBefore.setDescricao("101010");
		assertEquals("101010", ambienteBefore.getDescricao());
	}

	// TIPO ESTABELECIMENTO
	@Test
	public void teste16_deve_atribuir_um_novo_tipo_estabelecimento_para_ambiente_trabalho() {
		ambienteBefore.setTipoEstabelecimento(TipoEstabelecimento.PROPRIO);
		assertEquals(TipoEstabelecimento.PROPRIO, ambienteBefore.getTipoEstabelecimento());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste17_NAO_deve_atribuir_um_novo_tipo_estabelecimento_para_ambiente_trabalho_passando_nulo() {
		ambienteBefore.setTipoEstabelecimento(null);
	}

	// LISTA SETORES
	@Test
	public void teste18_deve_atribuir_uma_nova_lista_setores_para_ambiente_trabalho() {
		List<Setor> setores = new ArrayList<Setor>();
		setores.add(new Setor("desenvolvimento front end", ambienteBefore));
		ambienteBefore.setSetores(setores);
		assertEquals(setores, ambienteBefore.getSetores());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste19_nao_deve_atribuir_uma_nova_lista_setores_para_ambiente_trabalho_passando_nulo() {
		ambienteBefore.setSetores(null);
	}

	@Test(expected = IllegalStateException.class)
	public void teste20_nao_deve_atribuir_uma_nova_lista_setores_para_ambiente_trabalho_passando_lista_vazia() {
		ambienteBefore.setSetores(new ArrayList<Setor>());
	}

	@Test(expected = IllegalStateException.class)
	public void teste21_nao_deve_atribuir_uma_nova_lista_setores_para_ambiente_trabalho_passando_mais_de_30_ambientes() {
		List<Setor> setores = new ArrayList<Setor>();
		for (int index = 31; index != 0; index--) {
			setores.add(new Setor(NOME, ambienteBefore));
		}
		ambienteBefore.setSetores(setores);
	}

	// LISTA ENDERECOS
	@Test
	public void teste22_deve_atribuir_uma_nova_lista_de_enderecos_para_ambiente_trabalho() {
		List<Endereco> enderecos = new ArrayList<Endereco>();
		enderecos.add(new Endereco("04852510", "rua x", 194, "JD lucelia",
				new Cidade("São Paulo", 24584, new Estado("São Paulo", "SP")), new Estado("São Paulo", "SP"),
				TipoEndereco.COMERCIAL));
		ambienteBefore.setEnderecos(enderecos);
		assertEquals(enderecos, ambienteBefore.getEnderecos());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste23_nao_deve_atribuir_uma_nova_lista_de_enderecos_para_ambiente_trabalho_passando_nulo() {
		ambienteBefore.setEnderecos(null);
	}

	@Test(expected = IllegalStateException.class)
	public void teste24_nao_deve_atribuir_uma_nova_lista_de_enderecos_para_ambiente_trabalho_passando_lista_vazia() {
		ambienteBefore.setEnderecos(new ArrayList<Endereco>());
	}

	@Test(expected = IllegalStateException.class)
	public void teste25_nao_deve_atribuir_uma_nova_lista_de_enderecos_para_ambiente_trabalho_passando_mais_de_5_enderecos() {
		List<Endereco> enderecos = new ArrayList<Endereco>();
		for (int index = 6; index != 0; index--) {
			enderecos.add(new Endereco("04852510", "rua x", 194, "JD lucelia",
					new Cidade("São Paulo", 24584, new Estado("São Paulo", "SP")), new Estado("São Paulo", "SP"),
					TipoEndereco.COMERCIAL));
		}
		ambienteBefore.setEnderecos(enderecos);
	}

	// TO STRING
	@Test
	public void teste26_deve_retornar_o_nome_do_ambiente_no_to_string() {
		String result = ambienteBefore.toString();
		assertThat(result, containsString(ambienteBefore.getNome()));
	}

	@Test
	public void teste27_deve_retornar_a_descricao_do_ambiente_no_to_string() {
		ambienteBefore.setDescricao("desenvolver interfaces ao usuario");
		String result = ambienteBefore.toString();
		assertThat(result, containsString(ambienteBefore.getDescricao()));
	}

	@Test
	public void teste28_deve_retornar_a_empresa_que_o_ambiente_pertence_no_to_string() {
		String result = ambienteBefore.toString();
		assertThat(result, containsString(String.valueOf(ambienteBefore.getEmpresa())));
	}

	@Test
	public void teste29_deve_retornar_a_lista_de_endereco_do_ambiente_no_to_string() {
		String result = ambienteBefore.toString();
		assertThat(result, containsString(String.valueOf(ambienteBefore.getEnderecos())));
	}

	@Test
	public void teste30_deve_retornar_a_lista_de_setores_do_ambiente_no_to_string() {
		String result = ambienteBefore.toString();
		assertThat(result, containsString(String.valueOf(ambienteBefore.getSetores())));
	}

	@Test
	public void teste31_deve_retornar_tipo_do_estabelecimento_do_ambiente_no_to_string() {
		String result = ambienteBefore.toString();
		assertThat(result, containsString(String.valueOf(ambienteBefore.getTipoEstabelecimento())));
	}

	// HASHCODE

	@Test
	public void teste32_deve_retornar_o_mesmo_hashcode_para_da_ambiente_com_mesmo_nome() {
		AmbienteTrabalho ambiente1 = new AmbienteTrabalho(NOME, empresaBefore);
		AmbienteTrabalho ambiente2 = new AmbienteTrabalho(NOME, empresaBefore);
		boolean resp = ambiente1.hashCode() == ambiente2.hashCode();
		assertTrue(resp);
	}

	// EQUALS
	@Test
	public void teste33_deve_retornar_true_quando_usar_equals_passado_ambientes_iguais() {
		AmbienteTrabalho ambiente1 = new AmbienteTrabalho(NOME, empresaBefore);
		AmbienteTrabalho ambiente2 = new AmbienteTrabalho(NOME, empresaBefore);
		boolean resp = ambiente1.equals(ambiente2);
		assertTrue(resp);
	}

	@Test
	public void teste34_deve_retornar_falso_quando_usar_equals_passado_nome_ambientes_difentes() {
		AmbienteTrabalho ambiente1 = new AmbienteTrabalho(NOME, empresaBefore);
		AmbienteTrabalho ambiente2 = new AmbienteTrabalho("Recursos Humanos", empresaBefore);
		boolean resp = ambiente1.equals(ambiente2);
		assertFalse(resp);
	}

	@Test
	public void teste35_deve_retornar_falso_quando_usar_equals_passado_nulo() {
		boolean resp = ambienteBefore.equals(null);
		assertFalse(resp);
	}

	@Test
	public void teste36_deve_retornar_falso_quando_usar_equals_passado_object() {
		boolean resp = ambienteBefore.equals(new Object());
		assertFalse(resp);
	}

	@Test
	public void teste37_deve_retornar_verdadeiro_quando_usar_equals_passado_o_proprio_objeto() {
		boolean resp = ambienteBefore.equals(ambienteBefore);
		assertTrue(resp);
	}

	// CREATE BY
	@Test
	public void teste38_deve_retornar_por_quem_foi_criado() {
		ambienteBefore.setCreatedBy(EMAIL);
		assertEquals(EMAIL, ambienteBefore.getCreatedBy());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste39_nao_deve_retornar_por_quem_foi_criado_passando_email_nulo() {
		ambienteBefore.setCreatedBy(null);
	}

	// CREATE TIME
	@Test
	public void teste40_deve_retornar_quando_foi_criado() {
		ambienteBefore.setCreateDate(LOCAL_TIME);
		assertEquals(LOCAL_TIME, ambienteBefore.getCreateDate());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste41_nao_deve_retornar_por_quem_foi_criado_passando_create_by_nulo() {
		ambienteBefore.setCreateDate(null);
	}

	// LAST BY UPDATE NOTIFY
	@Test
	public void teste42_deve_retornar_por_quem_foi_alterado() {
		ambienteBefore.setLastByUpdadeNotify(EMAIL);
		assertEquals(EMAIL, ambienteBefore.getLastByUpdadeNotify());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste43_nao_deve_retornar_por_quem_foi_alterado_passando_email_nulo() {
		ambienteBefore.setCreatedBy(null);
	}

	// LAST DATE UPDATE NOTIFY
	@Test
	public void teste44_deve_retornar_quando_foi_alterado() {
		ambienteBefore.setLastDateUpdadeNotify(LOCAL_TIME);
		assertEquals(LOCAL_TIME, ambienteBefore.getLastDateUpdadeNotify());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste45_nao_deve_retornar_por_quem_foi_alterado_passando_create_by_nulo() {
		ambienteBefore.setLastDateUpdadeNotify(null);
	}

	// TO STRING
	@Test
	public void teste46_deve_retornar_createby_no_to_string() {
		String result = ambienteBefore.toString();
		assertThat(result, containsString(String.valueOf(ambienteBefore.getCreatedBy())));
	}

	@Test
	public void teste47_deve_retornar_create_date_no_to_string() {
		String result = ambienteBefore.toString();
		assertThat(result, containsString(String.valueOf(ambienteBefore.getCreateDate())));
	}

	@Test
	public void teste48_deve_retornar_LastDateUpdadeNotify_no_to_string() {
		String result = ambienteBefore.toString();
		assertThat(result, containsString(String.valueOf(ambienteBefore.getLastDateUpdadeNotify())));
	}

	@Test
	public void teste49_deve_retornar_LastByUpdadeNotify_date_no_to_string() {
		String result = ambienteBefore.toString();
		assertThat(result, containsString(String.valueOf(ambienteBefore.getLastByUpdadeNotify())));
	}

}