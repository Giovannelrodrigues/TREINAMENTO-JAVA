package br.com.contmatic.testes.model.empresa;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.contmatic.model.contato.Email;
import br.com.contmatic.model.empresa.Empresa;
import br.com.contmatic.model.empresa.Produto;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteProduto {

	private static final Email EMAIL = new Email("giovannelrodrigues@gmail.com");

	private static final String IP = "122.21.123.1";

	private static final LocalDateTime LOCAL_TIME = LocalDateTime.of(2023, Month.JUNE, 28, 6, 30, 40, 50000);

	private static Produto produtoBefore;

	private static final String CODIGO = "1548-NB";

	private static final String NOME = "Cellphone 11 PRO Max";

	private static final String MARCA = "IPear";

	private static final String COR = "Vermelho";

	private static final int QUANTIDADE = 10;

	private static final BigDecimal PRECO = BigDecimal.valueOf(12.00);

	private static Empresa empresaBefore;

	private static final String CNPJ = "02240233000197";

	@Before
	public void antesDeCadaTestes() {
		empresaBefore = new Empresa(CNPJ);
		produtoBefore = new Produto(CODIGO, empresaBefore);
		produtoBefore.setNome(NOME);
		produtoBefore.setMarca(MARCA);
		produtoBefore.setCor(COR);
		produtoBefore.setQuantidade(QUANTIDADE);
		produtoBefore.setPreco(PRECO);
		produtoBefore.setCreatedBy(EMAIL);
		produtoBefore.setCreateDate(LOCAL_TIME);
		produtoBefore.setUpdateBy(EMAIL);
		produtoBefore.setUpdatedDate(LOCAL_TIME);
		produtoBefore.setCreatedIp(IP);
		produtoBefore.setUpdatedIp(IP);
	}

	@Test
	public void teste01_deve_instaciar_um_novo_produto() {
		assertEquals(CODIGO, produtoBefore.getCodigo());
		assertEquals(produtoBefore.getEmpresa(), empresaBefore);
	}

	// CODIGO
	@Test
	public void teste02_deve_atribuir_um_novo_codigo_para_produto() {
		String codigo = "1575-HK";
		produtoBefore.setCodigo(codigo);
		assertEquals(codigo, produtoBefore.getCodigo());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste03_nao_deve_atribuir_um_novo_codigo_para_produto_passando_nulo() {
		produtoBefore.setCodigo(null);
	}

	@Test(expected = IllegalStateException.class)
	public void teste04_nao_deve_atribuir_um_novo_codigo_para_produto_passando_vazio() {
		produtoBefore.setCodigo("   ");
	}

	@Test(expected = IllegalStateException.class)
	public void teste05_nao_deve_atribuir_um_novo_codigo_para_produto_passando_com_mais_de_10_caracteres() {
		produtoBefore.setCodigo("123456789101112");
	}

	@Test(expected = IllegalStateException.class)
	public void teste06_nao_deve_atribuir_um_novo_codigo_para_produto_passando_com_menos_de_1_caracteres() {
		produtoBefore.setCodigo("");
	}

	// NOME
	@Test
	public void teste07_deve_atribuir_um_novo_nome_para_produto() {
		String nome = "Celular X 11 Pro Max";
		produtoBefore.setNome(nome);
		assertEquals(nome, produtoBefore.getNome());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste08_nao_deve_atribuir_um_novo_nome_para_produto_passando_nulo() {
		produtoBefore.setNome(null);
	}

	@Test(expected = IllegalStateException.class)
	public void teste09_nao_deve_atribuir_um_novo_nome_para_produto_passando_vazio() {
		produtoBefore.setNome("   ");
	}

	@Test(expected = IllegalStateException.class)
	public void teste10_nao_deve_atribuir_um_novo_nome_para_produto_passando_com_mais_de_60_caracteres() {
		produtoBefore.setNome("AbcDeAbcDeAbcDeAbcDeAbcDeAbcDeAbcDeAbcDeAbcDeAbcDeAbcDeAbcDeAbcDeAbcDe");
	}

	@Test(expected = IllegalStateException.class)
	public void teste11_nao_deve_atribuir_um_novo_nome_para_produto_passando_com_menos_de_3_caracteres() {
		produtoBefore.setNome("Ab");
	}

	@Test
	public void teste12_nao_deve_atribuir_um_novo_nome_para_produto_passando_numeros_e_letras() {
		String nome = "Abacd123456";
		produtoBefore.setNome(nome);
		assertEquals(nome, produtoBefore.getNome());
	}

	@Test(expected = IllegalStateException.class)
	public void teste13_nao_deve_atribuir_um_novo_nome_para_produto_passando_caracteres_especiais() {
		produtoBefore.setNome("@@###$$$");
	}

	// MARCA
	@Test
	public void teste14_deve_atribuir_uma_nova_marca_para_produto() {
		String marca = "MyCell";
		produtoBefore.setMarca(marca);
		assertEquals(marca, produtoBefore.getMarca());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste15_nao_deve_atribuir_uma_nova_marca_para_produto_passando_nulo() {
		produtoBefore.setMarca(null);
	}

	@Test(expected = IllegalStateException.class)
	public void teste16_nao_deve_atribuir_uma_nova_marca_para_produto_passando_vazio() {
		produtoBefore.setMarca("   ");
	}

	@Test(expected = IllegalStateException.class)
	public void teste17_nao_deve_atribuir_uma_nova_marca_para_produto_passando_com_mais_de_60_caracteres() {
		produtoBefore.setMarca("AbcDeAbcDeAbcDeAbcDeAbcDeAbcDeAbcDeAbcDeAbcDeAbcDeAbcDeAbcDeAbcDeAbcDe");
	}

	@Test(expected = IllegalStateException.class)
	public void teste18_nao_deve_atribuir_uma_nova_marca_para_produto_passando_com_menos_de_3_caracteres() {
		produtoBefore.setMarca("Ab");
	}

	@Test
	public void teste19_deve_atribuir_uma_nova_marca_para_produto_passando_qualquer_caractere() {
		String marca = "9z Team";
		produtoBefore.setMarca(marca);
		assertEquals(marca, produtoBefore.getMarca());
	}

	// COR
	@Test
	public void teste20_deve_atribuir_uma_nova_cor_para_produto() {
		String cor = "Preto";
		produtoBefore.setCor(cor);
		assertEquals(cor, produtoBefore.getCor());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste21_nao_deve_atribuir_uma_nova_cor_para_produto_passando_nulo() {
		produtoBefore.setCor(null);
	}

	@Test(expected = IllegalStateException.class)
	public void testeP_nao_deve_atribuir_uma_nova_cor_para_produto_passando_vazio() {
		produtoBefore.setCor("   ");
	}

	@Test(expected = IllegalStateException.class)
	public void teste22_nao_deve_atribuir_uma_nova_cor_para_produto_passando_com_mais_de_30_caracteres() {
		produtoBefore.setCor("AbcDeAbcDeAbcDeAbcDeAbcDeAbcDeAbcDeAbcDeAbcD");
	}

	@Test(expected = IllegalStateException.class)
	public void teste23_nao_deve_atribuir_uma_nova_cor_para_produto_passando_com_menos_de_3_caracteres() {
		produtoBefore.setMarca("Ab");
	}

	// QUANTIDADE
	@Test
	public void teste24_deve_atribuir_uma_nova_quantidade_para_produto() {
		int quantidade = 10;
		produtoBefore.setQuantidade(quantidade);
		assertEquals(quantidade, produtoBefore.getQuantidade());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste25_nao_deve_atribuir_uma_nova_quantidade_para_produto_passando_nulo() {
		produtoBefore.setQuantidade(null);
	}

	@Test(expected = IllegalStateException.class)
	public void teste26_nao_deve_atribuir_uma_nova_quantidade_para_produto_passando_valor_0() {
		produtoBefore.setQuantidade(0);
	}

	@Test(expected = IllegalStateException.class)
	public void teste27_nao_deve_atribuir_uma_nova_quantidade_para_produto_passando_valor_maior_que_9999() {
		produtoBefore.setQuantidade(10000);
	}

	// PRECO

	@Test
	public void teste28_deve_atribuir_um_novo_preco_para_produto() {
		BigDecimal preco = BigDecimal.valueOf(1200.00);
		produtoBefore.setPreco(preco);
		assertEquals(preco, produtoBefore.getPreco());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste29_nao_deve_atribuir_um_novo_preco_para_produto_passando_nulo() {
		produtoBefore.setPreco(null);
	}

	@Test(expected = IllegalStateException.class)
	public void teste30_nao_deve_atribuir_um_novo_preco_para_produto_passando_valor_0() {
		produtoBefore.setPreco(BigDecimal.valueOf(0.0));
	}

	@Test(expected = IllegalStateException.class)
	public void teste31_nao_deve_atribuir_um_novo_preco_para_produto_passando_valor_maior_que_99999999_com_casas_descimais_99() {
		produtoBefore.setPreco(BigDecimal.valueOf(100000000.00));
	}

	// EMPRESA
	@Test
	public void teste32_deve_atribuir_uma_nova_empresa_para_produto() {
		String cnpj = "42543514000133";
		Empresa empresa = new Empresa(cnpj);
		produtoBefore.setEmpresa(empresa);
		assertEquals(empresa, produtoBefore.getEmpresa());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste33_nao_deve_atribuir_uma_nova_empresa_para_produto_passando_nulo() {
		produtoBefore.setEmpresa(null);
	}

	// TO STRINT
	@Test
	public void teste34_deve_retornar_codigo_no_to_string_de_produto() {
		String result = produtoBefore.toString();
		assertThat(result, containsString(produtoBefore.getCodigo()));
	}

	@Test
	public void teste35_deve_retornar_nome_no_to_string_de_produto() {
		String result = produtoBefore.toString();
		assertThat(result, containsString(produtoBefore.getNome()));
	}

	@Test
	public void teste36_deve_retornar_marca_no_to_string_de_produto() {
		String result = produtoBefore.toString();
		assertThat(result, containsString(produtoBefore.getMarca()));
	}

	@Test
	public void teste37_deve_retornar_cor_no_to_string_de_produto() {
		String result = produtoBefore.toString();
		assertThat(result, containsString(produtoBefore.getCor()));
	}

	@Test
	public void teste38_deve_retornar_preco_no_to_string_de_produto() {
		String result = produtoBefore.toString();
		assertThat(result, containsString(String.valueOf(produtoBefore.getPreco())));
	}

	@Test
	public void teste39_deve_retornar_quantidade_no_to_string_de_produto() {
		String result = produtoBefore.toString();
		assertThat(result, containsString(String.valueOf(produtoBefore.getQuantidade())));
	}

	@Test
	public void teste40_deve_retornar_empresa_no_to_string_de_produto() {
		String result = produtoBefore.toString();
		assertThat(result, containsString(String.valueOf(produtoBefore.getEmpresa())));
	}

	// HASHCODE
	@Test
	public void teste41_deve_retornar_o_mesmo_hashcode_para_da_produto_com_mesmo_codigo() {
		Produto produto1 = new Produto(CODIGO, empresaBefore);
		Produto produto2 = new Produto(CODIGO, empresaBefore);
		boolean resp = produto1.hashCode() == produto2.hashCode();
		assertTrue(resp);
	}

	// EQUALS
	@Test
	public void teste42_deve_retornar_true_quando_usar_equals_passado_produtos_iguais() {
		Produto produto1 = new Produto(CODIGO, empresaBefore);
		Produto produto2 = new Produto(CODIGO, empresaBefore);
		boolean resp = produto1.equals(produto2);
		assertTrue(resp);
	}

	@Test
	public void teste43_deve_retornar_falso_quando_usar_equals_passado_produtos_com_codigo_diferente_difentes() {
		Produto produto1 = new Produto(CODIGO, empresaBefore);
		Produto produto2 = new Produto("12345", empresaBefore);
		boolean resp = produto1.equals(produto2);
		assertFalse(resp);
	}

	@Test
	public void teste44_deve_retornar_falso_quando_usar_equals_passado_nulo() {
		boolean resp = produtoBefore.equals(null);
		assertFalse(resp);
	}

	@Test
	public void teste45_deve_retornar_falso_quando_usar_equals_passado_object() {
		boolean resp = produtoBefore.equals(new Object());
		assertFalse(resp);
	}

	@Test
	public void teste46_deve_retornar_verdadeiro_quando_usar_equals_passado_o_proprio_objeto() {
		boolean resp = produtoBefore.equals(produtoBefore);
		assertTrue(resp);
	}
}
