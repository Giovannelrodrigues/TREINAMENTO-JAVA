package br.com.contmatic.teste;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.contmatic.enums.TipoEndereco;
import br.com.contmatic.model.Cidade;
import br.com.contmatic.model.Email;
import br.com.contmatic.model.Endereco;
import br.com.contmatic.model.Estado;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteEndereco {

	private static final Email EMAIL = new Email("giovannelrodrigues@gmail.com");

	private static final LocalDateTime LOCAL_TIME = LocalDateTime.of(2017, Month.FEBRUARY, 3, 6, 30, 40, 50000);

	private static Endereco enderecoBefore;

	private static final String CEP = "03308050";

	private static final String LOGRADOURO = "Rua Visc. de Itaboraí";

	private static final String COMPLEMENTO = "PRÉDIO";

	private static final int NUMERO = 368;

	private static final String BAIRRO = "Vila Azevedo";

	private static final Estado ESTADO = new Estado("São Paulo", "SP");

	private static final Cidade CIDADE = new Cidade("São Paulo", 5215485, ESTADO);

	private static final TipoEndereco TIPO_ENDERECO = TipoEndereco.COMERCIAL;

	@Before
	public void antesDeCadaTeste() {
		enderecoBefore = new Endereco(CEP, LOGRADOURO, NUMERO, BAIRRO, CIDADE, ESTADO, TIPO_ENDERECO);
		enderecoBefore.setComplemento(COMPLEMENTO);
		enderecoBefore.setCreatedBy(EMAIL);
		enderecoBefore.setCreateDate(LOCAL_TIME);
		enderecoBefore.setLastByUpdadeNotify(EMAIL);
		enderecoBefore.setLastDateUpdadeNotify(LOCAL_TIME);
	}

	// CONSTRUTOR
	@Test
	public void teste01_deve_instaciar_um_novo_endereco_com_campos_obrigatorios() {
		Endereco endereco = new Endereco(CEP, LOGRADOURO, NUMERO, BAIRRO, CIDADE, ESTADO, TipoEndereco.RESIDENCIAL);
		assertEquals(CEP, endereco.getCep());
		assertEquals(LOGRADOURO, endereco.getLogradouro());
		assertEquals(NUMERO, endereco.getNumero());
		assertEquals(BAIRRO, endereco.getBairro());
		assertEquals(CIDADE, endereco.getCidade());
		assertEquals(TipoEndereco.RESIDENCIAL, endereco.getTipoEndereco());
	}

	@Test
	public void teste02_deve_instaciar_um_novo_endereco_com_todos_os_campos() {
		assertEquals(CEP, enderecoBefore.getCep());
		assertEquals(LOGRADOURO, enderecoBefore.getLogradouro());
		assertEquals(COMPLEMENTO, enderecoBefore.getComplemento());
		assertEquals(NUMERO, enderecoBefore.getNumero());
		assertEquals(BAIRRO, enderecoBefore.getBairro());
		assertEquals(CIDADE, enderecoBefore.getCidade());
		assertEquals(TIPO_ENDERECO, enderecoBefore.getTipoEndereco());
	}

	// CEP
	@Test
	public void teste03_deve_atribuir_um_novo_valor_para_cep() {
		String cep = "04852510";
		enderecoBefore.setCep(cep);
		assertEquals(cep, enderecoBefore.getCep());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste04_nao_deve_atribuir_um_novo_valor_para_cep_passando_nulo() {
		enderecoBefore.setCep(null);
	}

	@Test(expected = IllegalStateException.class)
	public void teste05_nao_deve_atribuir_um_novo_valor_para_cep_passando_string_vazia() {
		enderecoBefore.setCep("    ");
	}

	@Test(expected = IllegalStateException.class)
	public void teste06_nao_deve_atribuir_um_novo_valor_para_cep_passando_mais_de_8_caracteres() {
		enderecoBefore.setCep("0485251010");
	}

	@Test(expected = IllegalStateException.class)
	public void teste07_nao_deve_atribuir_um_novo_valor_para_cep_passando_menos_de_8_caracteres() {
		enderecoBefore.setCep("04852");
	}

	@Test(expected = IllegalStateException.class)
	public void teste08_nao_deve_atribuir_um_novo_valor_para_cep_passando_formatado() {
		enderecoBefore.setCep("04852-510");
	}

	@Test(expected = IllegalStateException.class)
	public void teste09_nao_deve_atribuir_um_novo_valor_para_cep_passando_letras() {
		enderecoBefore.setCep("0482A51A");
	}

	// LOGRADOURO
	@Test
	public void teste10_deve_atribuir_um_novo_valor_para_logradouro() {
		String logradouro = "Rua x";
		enderecoBefore.setLogradouro(logradouro);
		assertEquals(logradouro, enderecoBefore.getLogradouro());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste11_nao_deve_atribuir_um_novo_valor_para_logradouro_passando_nulo() {
		enderecoBefore.setLogradouro(null);
	}

	@Test(expected = IllegalStateException.class)
	public void teste12_nao_deve_atribuir_um_novo_valor_para_logradouro_passando_string_vazia() {
		enderecoBefore.setLogradouro("    ");
	}

	@Test(expected = IllegalStateException.class)
	public void teste13_nao_deve_atribuir_um_novo_valor_para_logradouro_passando_mais_de_60_caracteres() {
		enderecoBefore
				.setLogradouro("123456abcdef123456abcdef123456abcdef123456abcdef123456abcdef123456abcdef123456abcdef");
	}

	@Test(expected = IllegalStateException.class)
	public void teste14_nao_deve_atribuir_um_novo_valor_para_logradouro_passando_menos_de_2_caracteres() {
		enderecoBefore.setLogradouro("A");
	}

	@Test(expected = IllegalStateException.class)
	public void teste15_nao_deve_atribuir_um_novo_valor_para_logradouro_passando_caracteres_especiais() {
		enderecoBefore.setLogradouro("@@@@");
	}

	// COMPLEMENTO
	@Test
	public void teste16_deve_atribuir_um_novo_valor_para_complemento() {
		String complemento = "casa 3";
		enderecoBefore.setComplemento(complemento);
		assertEquals(complemento, enderecoBefore.getComplemento());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste17_nao_deve_atribuir_um_novo_valor_para_complemento_passando_nulo() {
		enderecoBefore.setComplemento(null);
	}

	@Test(expected = IllegalStateException.class)
	public void teste18_nao_deve_atribuir_um_novo_valor_para_complemento_passando_string_vazia() {
		enderecoBefore.setComplemento("    ");
	}

	@Test(expected = IllegalStateException.class)
	public void teste19_nao_deve_atribuir_um_novo_valor_para_complemento_passando_mais_de_30_caracteres() {
		enderecoBefore.setComplemento("12345abcde12345abcde12345abcde12345abcde");
	}

	@Test(expected = IllegalStateException.class)
	public void teste20_nao_deve_atribuir_um_novo_valor_para_complemento_passando_menos_de_2_caracteres() {
		enderecoBefore.setComplemento("a");
	}

	@Test(expected = IllegalStateException.class)
	public void teste21_nao_deve_atribuir_um_novo_valor_para_complemento_passando_caracteres_especiais() {
		enderecoBefore.setComplemento("@@###$$$$adad");
	}

	// NUMERO
	@Test
	public void teste22_deve_atribuir_um_novo_valor_para_numero() {
		int numero = 157;
		enderecoBefore.setNumero(numero);
		assertEquals(numero, enderecoBefore.getNumero());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste23_nao_deve_atribuir_um_novo_valor_para_numero_passando_nulo() {
		enderecoBefore.setNumero(null);
	}

	@Test(expected = IllegalStateException.class)
	public void teste24_nao_deve_atribuir_um_novo_valor_para_complemento_passando_0() {
		enderecoBefore.setNumero(0);
	}

	@Test(expected = IllegalStateException.class)
	public void teste25_nao_deve_atribuir_um_novo_valor_para_complemento_passando_mais_99999() {
		enderecoBefore.setNumero(100000);
	}

	// BAIRRO
	@Test
	public void teste26_deve_atribuir_um_novo_valor_para_bairro() {
		String bairro = "JD novo Jaú";
		enderecoBefore.setBairro(bairro);
		assertEquals(bairro, enderecoBefore.getBairro());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste27_nao_deve_atribuir_um_novo_valor_para_bairro_passando_nulo() {
		enderecoBefore.setBairro(null);
	}

	@Test(expected = IllegalStateException.class)
	public void teste28_nao_deve_atribuir_um_novo_valor_para_bairro_passando_string_vazia() {
		enderecoBefore.setBairro("    ");
	}

	@Test(expected = IllegalStateException.class)
	public void teste29_nao_deve_atribuir_um_novo_valor_para_bairro_passando_mais_de_60_caracteres() {
		enderecoBefore.setBairro("12345abcde12345abcde12345abcde12345abcde12345abcde12345abcde12345abcde12345abcde");
	}

	@Test(expected = IllegalStateException.class)
	public void teste30_nao_deve_atribuir_um_novo_valor_para_bairro_passando_menos_de_2_caracteres() {
		enderecoBefore.setBairro("a");
	}

	@Test(expected = IllegalStateException.class)
	public void teste31_nao_deve_atribuir_um_novo_valor_para_bairro_passando_caracteres_especiais() {
		enderecoBefore.setBairro("@saskas05$%#");
	}

	@Test(expected = IllegalStateException.class)
	public void teste32_nao_deve_atribuir_um_novo_valor_para_bairro_passando_numeros() {
		enderecoBefore.setBairro("12345678abc");
	}

	// CIDADE
	@Test
	public void teste33_deve_atribuir_um_novo_valor_para_cidade() {
		Cidade cidade = new Cidade("São Paulo", 5215485, ESTADO);
		enderecoBefore.setCidade(cidade);
		assertEquals(cidade, enderecoBefore.getCidade());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste34_nao_deve_atribuir_um_novo_valor_para_cidade_passando_nulo() {
		enderecoBefore.setCidade(null);
	}

	// Estado
	@Test
	public void teste35_deve_atribuir_um_novo_valor_para_estado() {
		Estado estado = new Estado("São Paulo", "SP");
		enderecoBefore.setEstado(estado);
		assertEquals(estado, enderecoBefore.getEstado());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste36_nao_deve_atribuir_um_novo_valor_para_estado_passando_nulo() {
		enderecoBefore.setEstado(null);
	}

	// TIPO ENDERECO
	@Test
	public void teste37_deve_atribuir_um_novo_valor_para_tipo_endereco() {
		TipoEndereco tipoEndereco = TipoEndereco.ENTREGA;
		enderecoBefore.setTipoEndereco(tipoEndereco);
		assertEquals(tipoEndereco, enderecoBefore.getTipoEndereco());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste38_nao_deve_atribuir_um_novo_valor_para_tipo_endereco_passando_nulo() {
		enderecoBefore.setCidade(null);
	}

	// TO STRING
	@Test
	public void teste39_deve_retornar_cep_ao_usar_to_string() {
		String result = enderecoBefore.toString();
		assertThat(result, containsString(enderecoBefore.getCep()));
	}

	@Test
	public void teste40_deve_retornar_logradouro_ao_usar_to_string() {
		String result = enderecoBefore.toString();
		assertThat(result, containsString(enderecoBefore.getLogradouro()));
	}

	@Test
	public void teste41_deve_retornar_complemento_ao_usar_to_string() {
		String result = enderecoBefore.toString();
		assertThat(result, containsString(enderecoBefore.getComplemento()));
	}

	@Test
	public void teste42_deve_retornar_numero_ao_usar_to_string() {
		String result = enderecoBefore.toString();
		assertThat(result, containsString(String.valueOf(enderecoBefore.getNumero())));
	}

	@Test
	public void teste43_deve_retornar_bairro_ao_usar_to_string() {
		String result = enderecoBefore.toString();
		assertThat(result, containsString(enderecoBefore.getBairro()));
	}

	@Test
	public void teste44_deve_retornar_cidade_ao_usar_to_string() {
		String result = enderecoBefore.toString();
		assertThat(result, containsString(String.valueOf(enderecoBefore.getCidade())));
	}

	@Test
	public void teste45_deve_retornar_tipo_endereco_ao_usar_to_string() {
		String result = enderecoBefore.toString();
		assertThat(result, containsString(String.valueOf(enderecoBefore.getTipoEndereco())));
	}

	// HASHCODE
	@Test
	public void teste46_deve_retornar_o_mesmo_hashcode_para_enderecos_sao_iguais() {
		Endereco endereco1 = new Endereco(CEP, LOGRADOURO, NUMERO, BAIRRO, CIDADE, ESTADO, TIPO_ENDERECO);
		Endereco endereco2 = new Endereco(CEP, LOGRADOURO, NUMERO, BAIRRO, CIDADE, ESTADO, TIPO_ENDERECO);
		boolean resp = endereco1.hashCode() == endereco2.hashCode();
		assertTrue(resp);
	}

	// EQUALS
	@Test
	public void teste47_deve_retornar_true_quando_usar_equals_passado_enderecos_iguais() {
		Endereco endereco1 = new Endereco(CEP, LOGRADOURO, NUMERO, BAIRRO, CIDADE, ESTADO, TIPO_ENDERECO);
		Endereco endereco2 = new Endereco(CEP, LOGRADOURO, NUMERO, BAIRRO, CIDADE, ESTADO, TIPO_ENDERECO);
		boolean resp = endereco1.equals(endereco2);
		assertTrue(resp);
	}

	@Test
	public void teste48_deve_retornar_true_quando_usar_equals_passado_tipos_enderecos_diferentes() {
		Endereco endereco1 = new Endereco(CEP, LOGRADOURO, NUMERO, BAIRRO, CIDADE, ESTADO, TIPO_ENDERECO);
		Endereco endereco2 = new Endereco(CEP, LOGRADOURO, NUMERO, BAIRRO, CIDADE, ESTADO, TipoEndereco.ENTREGA);
		boolean resp = endereco1.equals(endereco2);
		assertTrue(resp);
	}

	@Test
	public void teste49_deve_retornar_falso_quando_usar_equals_passado_nulo() {
		boolean resp = enderecoBefore.equals(null);
		assertFalse(resp);
	}

	@Test
	public void teste50_deve_retornar_falso_quando_usar_equals_passado_object() {
		boolean resp = enderecoBefore.equals(new Object());
		assertFalse(resp);
	}

	@Test
	public void teste51_deve_retornar_true_quando_usar_equals_passado_o_proprio_objeto() {
		boolean resp = enderecoBefore.equals(enderecoBefore);
		assertTrue(resp);
	}

	// CREATE BY
	@Test
	public void teste52_deve_retornar_por_quem_foi_criado() {
		enderecoBefore.setCreatedBy(EMAIL);
		assertEquals(EMAIL, enderecoBefore.getCreatedBy());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste53_nao_deve_retornar_por_quem_foi_criado_passando_email_nulo() {
		enderecoBefore.setCreatedBy(null);
	}

	// CREATE TIME
	@Test
	public void teste54_deve_retornar_quando_foi_criado() {
		enderecoBefore.setCreateDate(LOCAL_TIME);
		assertEquals(LOCAL_TIME, enderecoBefore.getCreateDate());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste55_nao_deve_retornar_por_quem_foi_criado_passando_create_by_nulo() {
		enderecoBefore.setCreateDate(null);
	}

	// LAST BY UPDATE NOTIFY
	@Test
	public void teste56_deve_retornar_por_quem_foi_alterado() {
		enderecoBefore.setLastByUpdadeNotify(EMAIL);
		assertEquals(EMAIL, enderecoBefore.getLastByUpdadeNotify());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste57_nao_deve_retornar_por_quem_foi_alterado_passando_email_nulo() {
		enderecoBefore.setCreatedBy(null);
	}

	// LAST DATE UPDATE NOTIFY
	@Test
	public void teste58_deve_retornar_quando_foi_alterado() {
		enderecoBefore.setLastDateUpdadeNotify(LOCAL_TIME);
		assertEquals(LOCAL_TIME, enderecoBefore.getLastDateUpdadeNotify());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste59_nao_deve_retornar_por_quem_foi_alterado_passando_create_by_nulo() {
		enderecoBefore.setLastDateUpdadeNotify(null);
	}

	// TO STRING
	@Test
	public void teste60_deve_retornar_createby_no_to_string() {
		String result = enderecoBefore.toString();
		assertThat(result, containsString(String.valueOf(enderecoBefore.getCreatedBy())));
	}

	@Test
	public void teste61_deve_retornar_create_date_no_to_string() {
		String result = enderecoBefore.toString();
		assertThat(result, containsString(String.valueOf(enderecoBefore.getCreateDate())));
	}

	@Test
	public void teste62_deve_retornar_LastDateUpdadeNotify_no_to_string() {
		String result = enderecoBefore.toString();
		assertThat(result, containsString(String.valueOf(enderecoBefore.getLastDateUpdadeNotify())));
	}

	@Test
	public void teste63_deve_retornar_LastByUpdadeNotify_date_no_to_string() {
		String result = enderecoBefore.toString();
		assertThat(result, containsString(String.valueOf(enderecoBefore.getLastByUpdadeNotify())));
	}

}
