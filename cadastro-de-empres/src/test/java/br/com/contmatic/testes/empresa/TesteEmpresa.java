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
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.contmatic.model.commons.Cidade;
import br.com.contmatic.model.commons.Email;
import br.com.contmatic.model.commons.Endereco;
import br.com.contmatic.model.commons.Estado;
import br.com.contmatic.model.commons.Telefone;
import br.com.contmatic.model.empresa.AmbienteTrabalho;
import br.com.contmatic.model.empresa.Empresa;
import br.com.contmatic.model.empresa.Produto;
import br.com.contmatic.model.enums.TipoEndereco;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteEmpresa {

	private static final Email EMAIL = new Email("giovannelrodrigues@gmail.com");

	private static Empresa empresaBefore;

	private static final String CNPJ = "63516934000109";

	private static final LocalDateTime LOCAL_TIME = LocalDateTime.of(2017, Month.FEBRUARY, 3, 6, 30, 40, 50000);

	@Before
	public void antesDeCadaTeste() {
		empresaBefore = new Empresa(CNPJ);
		empresaBefore.setCreatedBy(EMAIL);
		empresaBefore.setCreateDate(LOCAL_TIME);
		empresaBefore.setLastByUpdadeNotify(EMAIL);
		empresaBefore.setLastDateUpdadeNotify(LOCAL_TIME);
	}

	// CONSTRUTOR
	@Test
	public void teste01_deve_instaciar_uma_empresa_usando_construtor_obrigatorio() {
		assertEquals(CNPJ, empresaBefore.getCnpj());
	}

	// CNPJ
	@Test
	public void teste02_deve_atribuir_um_novo_cnpj_valido() {
		String cnpj = "71311703000189";
		empresaBefore.setCnpj(cnpj);
		assertEquals(cnpj, empresaBefore.getCnpj());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste03_nao_deve_atribuir_um_novo_cnpj_passando_nulo() {
		empresaBefore.setCnpj(null);
	}

	@Test(expected = IllegalStateException.class)
	public void teste04_nao_deve_atribuir_um_novo_cnpj_passando_string_vazia() {
		empresaBefore.setCnpj("   ");
	}

	@Test(expected = IllegalStateException.class)
	public void teste05_nao_deve_atribuir_um_novo_cnpj_passando_mais_de_14_caracteres() {
		empresaBefore.setCnpj("123123123123123");
	}

	@Test(expected = IllegalStateException.class)
	public void teste06_nao_deve_atribuir_um_novo_cnpj_passando_menos_de_14_caracteres() {
		empresaBefore.setCnpj("123123123123");
	}

	@Test(expected = IllegalStateException.class)
	public void teste07_nao_deve_atribuir_um_novo_cnpj_passando_formatado() {
		empresaBefore.setCnpj("63.516.934/0001-09");
	}

	@Test(expected = IllegalStateException.class)
	public void teste08_nao_deve_atribuir_um_novo_cnpj_passando_letra() {
		empresaBefore.setCnpj("123123ABC12345");
	}

	@Test(expected = IllegalStateException.class)
	public void teste09_nao_deve_atribuir_um_novo_cnpj_passando_numeros_repetidos() {
		empresaBefore.setCnpj("99999999999999");
	}

	@Test(expected = IllegalStateException.class)
	public void teste10_nao_deve_atribuir_um_novo_cnpj_passando_cnpj_invalido() {
		empresaBefore.setCnpj("12345678912314");
	}

	// RAZAO SOCIAL
	@Test
	public void teste11_deve_atribuir_um_valor_para_razao_social() {
		String razao_social = "SOFTMATIC SISTEMAS AUTOMATICOS DE INFORMATICA LTDA.";
		empresaBefore.setRazaoSocial(razao_social);
		assertEquals(razao_social, empresaBefore.getRazaoSocial());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste12_nao_deve_atribuir_um_valor_para_razao_social_pasando_nulo() {
		empresaBefore.setRazaoSocial(null);
	}

	@Test(expected = IllegalStateException.class)
	public void teste13_nao_deve_atribuir_um_valor_para_razao_social_passando_string_vazia() {
		empresaBefore.setRazaoSocial("    ");
	}

	@Test(expected = IllegalStateException.class)
	public void teste14_nao_deve_atribuir_um_valor_para_razao_social_passando_mais_de_100_caracteres() {
		empresaBefore.setRazaoSocial(
				"12345seixs12345seixs12345seixs12345seixs12345seixs12345seixs12345seixs12345seixs12345seixs12345seixs12345seixs");
	}

	@Test(expected = IllegalStateException.class)
	public void teste15_nao_deve_atribuir_um_valor_para_razao_social_passando_menos_de_5_caracteres() {
		empresaBefore.setRazaoSocial("123");
	}

	@Test(expected = IllegalStateException.class)
	public void teste16_nao_deve_atribuir_um_valor_para_razao_social_passando_caracteres_diferente_de_ponto_e_ecomercial() {
		empresaBefore.setRazaoSocial("SOFTMATIC @ SISTEMAS # AUTOMATICOS & INFORMATICA ! LTDA.");
	}

	// NOME FANTASIA
	@Test
	public void teste17_deve_atribuir_um_valor_para_nome_fantasia() {
		String nome_fantasia = "Contmatic Phoenix";
		empresaBefore.setNomeFantasia(nome_fantasia);
		assertEquals(nome_fantasia, empresaBefore.getNomeFantasia());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste18_nao_deve_atribuir_um_valor_para_nome_fantasia_pasando_nulo() {
		empresaBefore.setNomeFantasia(null);
	}

	@Test(expected = IllegalStateException.class)
	public void teste19_nao_deve_atribuir_um_valor_para_nome_fantasia_passando_string_vazia() {
		empresaBefore.setNomeFantasia("  ");
	}

	@Test(expected = IllegalStateException.class)
	public void teste20_nao_deve_atribuir_um_valor_para_nome_fantasia_passando_mais_de_100_caracteres() {
		empresaBefore.setNomeFantasia(
				"12345seixs12345seixs12345seixs12345seixs12345seixs12345seixs12345seixs12345seixs12345seixs12345seixs12345seixs");
	}

	@Test(expected = IllegalStateException.class)
	public void teste21_nao_deve_atribuir_um_valor_para_nome_fantasia_passando_menos_de_5_caracteres() {
		empresaBefore.setNomeFantasia("123");
	}

	// LISTA ENDERECO EMPRESA
	@Test
	public void teste22_deve_atribuir_um_valor_para_lista_endereco() {
		List<Endereco> enderecos = new ArrayList<Endereco>();
		enderecos.add(new Endereco("04852510", "rua x", 194, "JD lucelia",
				new Cidade("São Paulo", 24584, new Estado("São Paulo", "SP")), new Estado("São Paulo", "SP"),
				TipoEndereco.COMERCIAL));
		empresaBefore.setEnderecos(enderecos);
		assertEquals(enderecos, empresaBefore.getEnderecos());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste23_nao_deve_atribuir_um_valor_para_lista_endereco_passando_nulo() {
		empresaBefore.setEnderecos(null);
	}

	@Test(expected = IllegalStateException.class)
	public void teste24_nao_deve_atribuir_um_valor_para_lista_endereco_passando_lista_vazia() {
		List<Endereco> enderecos = new ArrayList<Endereco>();
		empresaBefore.setEnderecos(enderecos);
	}

	@Test(expected = IllegalStateException.class)
	public void teste25_deve_atribuir_um_valor_para_lista_endereco_com_mais_de_5_enderecos() {
		List<Endereco> enderecos = new ArrayList<Endereco>();
		for (int index = 6; index != 0; index--) {
			enderecos.add(new Endereco("04852510", "rua x", 194, "JD lucelia",
					new Cidade("São Paulo", 24584, new Estado("São Paulo", "SP")), new Estado("São Paulo", "SP"),
					TipoEndereco.COMERCIAL));
		}
		empresaBefore.setEnderecos(enderecos);
	}

	// LISTA AMBIENTES TRABALHOS
	@Test
	public void teste26_deve_atribuir_um_valor_para_lista_ambientes_trabalhos() {
		List<AmbienteTrabalho> ambientes = new ArrayList<AmbienteTrabalho>();
		ambientes.add(new AmbienteTrabalho("Recusos Humanos", empresaBefore));
		empresaBefore.setAmbientesTrabalhos(ambientes);
		assertEquals(ambientes, empresaBefore.getAmbientesTrabalhos());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste27_nao_deve_atribuir_um_valor_para_lista_ambientes_passando_nulo() {
		empresaBefore.setAmbientesTrabalhos(null);
	}

	@Test(expected = IllegalStateException.class)
	public void teste28_nao_deve_atribuir_um_valor_para_lista_ambientes_passando_lista_vazia() {
		List<AmbienteTrabalho> ambientes = new ArrayList<AmbienteTrabalho>();
		empresaBefore.setAmbientesTrabalhos(ambientes);
	}

	@Test(expected = IllegalStateException.class)
	public void teste29_deve_atribuir_um_valor_para_lista_ambientes_coma_mais_de_30_ambientes() {
		List<AmbienteTrabalho> ambientes = new ArrayList<AmbienteTrabalho>();
		for (int index = 31; index != 0; index--) {
			ambientes.add(new AmbienteTrabalho("Recusos Humanos", empresaBefore));
		}
		empresaBefore.setAmbientesTrabalhos(ambientes);
	}

	// LISTA DE PRODUTOS
	@Test
	public void teste30_deve_atribuir_uma_nova_lista_de_produtos() {
		List<Produto> produtos = new ArrayList<Produto>();
		produtos.add(new Produto("123-abc", empresaBefore));
		empresaBefore.setProdutos(produtos);
		assertEquals(produtos, empresaBefore.getProdutos());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste31_nao_deve_atribuir_uma_nova_lista_de_produtos_passando_nulo() {
		empresaBefore.setProdutos(null);
	}

	@Test(expected = IllegalStateException.class)
	public void teste32_nao_deve_atribuir_uma_nova_lista_de_produtos_lista_vazia() {
		List<Produto> produtos = new ArrayList<Produto>();
		empresaBefore.setProdutos(produtos);
	}

	@Test(expected = IllegalStateException.class)
	public void teste33_deve_atribuir_uma_nova_lista_de_produtos_coma_mais_de_30_produtos() {
		List<Produto> produtos = new ArrayList<Produto>();
		for (int index = 10000; index != 0; index--) {
			produtos.add(new Produto("123-abc", empresaBefore));
		}
		empresaBefore.setProdutos(produtos);
	}

	// LISTA TELEFONE
	@Test
	public void teste34_deve_atribuir_uma_nova_lista_de_telefone() {
		List<Telefone> telefones = new ArrayList<Telefone>();
		telefones.add(new Telefone("1159160668"));
		empresaBefore.setTelefones(telefones);
		assertEquals(telefones, empresaBefore.getTelefones());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste35_nao_deve_atribuir_uma_nova_lista_de_telefone_passando_nulo() {
		empresaBefore.setTelefones(null);
	}

	@Test(expected = IllegalStateException.class)
	public void teste36_nao_deve_atribuir_uma_nova_lista_de_telefone_lista_vazia() {
		List<Telefone> telefones = new ArrayList<Telefone>();
		empresaBefore.setTelefones(telefones);
	}

	@Test(expected = IllegalStateException.class)
	public void teste37_nao_deve_atribuir_uma_nova_lista_de_telefones_coma_mais_de_5_telefones() {
		List<Telefone> telefones = new ArrayList<Telefone>();
		for (int index = 7; index != 0; index--) {
			telefones.add(new Telefone("1159160668"));
		}
		empresaBefore.setTelefones(telefones);
	}

	// LISTA EMAILS
	@Test
	public void teste38_deve_atribuir_uma_nova_lista_de_emails() {
		List<Email> emails = new ArrayList<Email>();
		emails.add(new Email("emailcont@cont.com"));
		empresaBefore.setEmails(emails);
		assertEquals(emails, empresaBefore.getEmails());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste39_nao_deve_atribuir_uma_nova_lista_de_emails_passando_nulo() {
		empresaBefore.setEmails(null);
	}

	@Test(expected = IllegalStateException.class)
	public void teste40_nao_deve_atribuir_uma_nova_lista_de_emails_lista_vazia() {
		List<Email> emails = new ArrayList<Email>();
		empresaBefore.setEmails(emails);
	}

	@Test(expected = IllegalStateException.class)
	public void teste41_nao_deve_atribuir_uma_nova_lista_de_telefones_coma_mais_de_5_telefones() {
		List<Email> emails = new ArrayList<Email>();
		for (int index = 7; index != 0; index--) {
			emails.add(new Email("emailcont@cont.com"));
		}
		empresaBefore.setEmails(emails);
	}

	// TO STRING
	@Test
	public void teste46_deve_retonar_cnpj_no_to_string() {
		String result = empresaBefore.toString();
		assertThat(result, containsString(empresaBefore.getCnpj()));
	}

	@Test
	public void teste47_deve_retonar_razao_social_no_to_string() {
		empresaBefore.setRazaoSocial("Softmatic Sistemas Automaticos de Informatica Ltda");
		String result = empresaBefore.toString();
		assertThat(result, containsString(empresaBefore.getRazaoSocial()));
	}

	@Test
	public void teste48_deve_retonar_nome_fantasia_no_to_string() {
		empresaBefore.setNomeFantasia("Contmatic Phoenix");
		String result = empresaBefore.toString();
		assertThat(result, containsString(empresaBefore.getNomeFantasia()));
	}

	@Test
	public void teste49_deve_retonar_lista_enderecos_no_to_string() {
		String result = empresaBefore.toString();
		assertThat(result, containsString(String.valueOf(empresaBefore.getEnderecos())));
	}

	@Test
	public void teste50_deve_retonar_lista_ambientes_no_to_string() {
		String result = empresaBefore.toString();
		assertThat(result, containsString(String.valueOf(empresaBefore.getAmbientesTrabalhos())));
	}

	@Test
	public void teste51_deve_retonar_lista_produtos_no_to_string() {
		String result = empresaBefore.toString();
		assertThat(result, containsString(String.valueOf(empresaBefore.getProdutos())));
	}

	@Test
	public void teste52_deve_retonar_lista_emails_no_to_string() {
		String result = empresaBefore.toString();
		assertThat(result, containsString(String.valueOf(empresaBefore.getEmails())));
	}

	@Test
	public void teste53_deve_retonar_lista_telefones_no_to_string() {
		String result = empresaBefore.toString();
		assertThat(result, containsString(String.valueOf(empresaBefore.getTelefones())));
	}

	// HASHCODE
	@Test
	public void teste41_deve_retornar_o_mesmo_hashcode_para_da_empresa_com_mesmo_cnpj() {
		Empresa empresa1 = new Empresa(CNPJ);
		Empresa empresa2 = new Empresa(CNPJ);
		boolean resp = empresa1.hashCode() == empresa2.hashCode();
		assertTrue(resp);
	}

	// EQUALS
	@Test
	public void teste42_deve_retornar_true_quando_usar_equals_passado_empresas_iguais() {
		Empresa empresa1 = new Empresa(CNPJ);
		Empresa empresa2 = new Empresa(CNPJ);
		boolean resp = empresa1.equals(empresa2);
		assertTrue(resp);
	}

	@Test
	public void teste43_deve_retornar_falso_quando_usar_equals_passado_empresa_com_cnpj_diferente_difentes() {
		Empresa empresa1 = new Empresa(CNPJ);
		Empresa empresa2 = new Empresa("45626047000101");
		boolean resp = empresa1.equals(empresa2);
		assertFalse(resp);
	}

	@Test
	public void teste44_deve_retornar_falso_quando_usar_equals_passado_nulo() {
		boolean resp = empresaBefore.equals(null);
		assertFalse(resp);
	}

	@Test
	public void teste45_deve_retornar_falso_quando_usar_equals_passado_object() {
		boolean resp = empresaBefore.equals(new Object());
		assertFalse(resp);
	}

	@Test
	public void teste46_deve_retornar_verdadeiro_quando_usar_equals_passado_o_proprio_objeto() {
		boolean resp = empresaBefore.equals(empresaBefore);
		assertTrue(resp);
	}

	// CREATE BY
	@Test
	public void teste47_deve_retornar_por_quem_foi_criado() {
		empresaBefore.setCreatedBy(EMAIL);
		assertEquals(EMAIL, empresaBefore.getCreatedBy());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste48_nao_deve_retornar_por_quem_foi_criado_passando_email_nulo() {
		empresaBefore.setCreatedBy(null);
	}

	// CREATE TIME
	@Test
	public void teste49_deve_retornar_quando_foi_criado() {
		empresaBefore.setCreateDate(LOCAL_TIME);
		assertEquals(LOCAL_TIME, empresaBefore.getCreateDate());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste50_nao_deve_retornar_por_quem_foi_criado_passando_create_by_nulo() {
		empresaBefore.setCreateDate(null);
	}

	// LAST BY UPDATE NOTIFY
	@Test
	public void teste51_deve_retornar_por_quem_foi_alterado() {
		empresaBefore.setLastByUpdadeNotify(EMAIL);
		assertEquals(EMAIL, empresaBefore.getLastByUpdadeNotify());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste52_nao_deve_retornar_por_quem_foi_alterado_passando_email_nulo() {
		empresaBefore.setCreatedBy(null);
	}

	// LAST DATE UPDATE NOTIFY
	@Test
	public void teste53_deve_retornar_quando_foi_alterado() {
		empresaBefore.setLastDateUpdadeNotify(LOCAL_TIME);
		assertEquals(LOCAL_TIME, empresaBefore.getLastDateUpdadeNotify());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste54_nao_deve_retornar_por_quem_foi_alterado_passando_create_by_nulo() {
		empresaBefore.setLastDateUpdadeNotify(null);
	}

	// TO STRING
	@Test
	public void teste55_deve_retornar_createby_no_to_string() {
		String result = empresaBefore.toString();
		assertThat(result, containsString(String.valueOf(empresaBefore.getCreatedBy())));
	}

	@Test
	public void teste56_deve_retornar_create_date_no_to_string() {
		String result = empresaBefore.toString();
		assertThat(result, containsString(String.valueOf(empresaBefore.getCreateDate())));
	}

	@Test
	public void teste57_deve_retornar_LastDateUpdadeNotify_no_to_string() {
		String result = empresaBefore.toString();
		assertThat(result, containsString(String.valueOf(empresaBefore.getLastDateUpdadeNotify())));
	}

	@Test
	public void teste58_deve_retornar_LastByUpdadeNotify_date_no_to_string() {
		String result = empresaBefore.toString();
		assertThat(result, containsString(String.valueOf(empresaBefore.getLastByUpdadeNotify())));
	}

	@Test
	@Ignore
	public void teste59_deve_retornar_verdadeiro_quando_usar_equals_passado_o_proprio_objeto() {
		boolean resp = empresaBefore.equals(empresaBefore);
		assertTrue(resp);
	}
}
