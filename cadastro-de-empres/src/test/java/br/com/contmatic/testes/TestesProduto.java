package br.com.contmatic.testes;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.contmatic.model.Produto;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestesProduto {
	
	private static final String CODIGO = "I13PM";
	
	private static final String NOME = "Iphone 13 pro max";
	
	private static final String MARCAR = "Apple";
	
	private static final double PRECO = 6.799;
	
	private static final int QUANTIDADE = 12;
	
	private static final String COR = "Preto";
	
	private static final String VAZIO = "  ";
	
	private static final String CARACTERES_150 = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
	
	private static Produto produtoBefore;

	@Before
	public void astesDeCadateste() {
		produtoBefore = new Produto(CODIGO, NOME, MARCAR, PRECO, QUANTIDADE, COR);
	};
	
	
	@Test
	public void testeA_deve_instaciar_um_produto_corretamente_com_todos_os_campos() {
		assertEquals(CODIGO, produtoBefore.getCodigo());
		assertEquals(NOME, produtoBefore.getNome());
		assertEquals(MARCAR, produtoBefore.getMarca());
		assertEquals(PRECO, produtoBefore.getPreco());
		assertEquals(QUANTIDADE, produtoBefore.getQuantidade());
		assertEquals(COR, produtoBefore.getCor());
	}
	
	@Test
	public void testeB_deve_instaciar_um_produto_corretamente_com_cor_passando_nulo() {
		Produto produto = new Produto(CODIGO, NOME, MARCAR, PRECO, QUANTIDADE, COR);
		assertEquals(CODIGO, produto.getCodigo());
		assertEquals(NOME, produto.getNome());
		assertEquals(MARCAR, produto.getMarca());
		assertEquals(PRECO, produto.getPreco());
		assertEquals(QUANTIDADE, produto.getQuantidade());
		assertEquals(COR, produto.getCor());
	}
	
	//VAZIO
	
	@Test (expected = IllegalStateException.class)
	public void testeC_nao_deve_instaciar_um_objeto_produto_passando_codigo_vazio() {
		new Produto(VAZIO, NOME, MARCAR, PRECO, QUANTIDADE, COR);
	}
	
	@Test (expected = IllegalStateException.class)
	public void testeD_nao_deve_instaciar_um_objeto_produto_passando_nome_vazio() {
		new Produto(CODIGO, VAZIO, MARCAR, PRECO, QUANTIDADE, COR);
	}
	
	@Test (expected = IllegalStateException.class)
	public void testeE_nao_deve_instaciar_um_objeto_produto_passando_marca_vazio() {
		new Produto(CODIGO, NOME, VAZIO, PRECO, QUANTIDADE, COR);
	}
	
	@Test (expected = IllegalStateException.class)
	public void testeF_nao_deve_instaciar_um_objeto_produto_passando_preco_com_0() {
		new Produto(CODIGO, NOME, MARCAR, 0.0, QUANTIDADE, COR);
	}
	
	@Test (expected = IllegalStateException.class)
	public void testeG_nao_deve_instaciar_um_objeto_produto_passando_quantidade_com_0() {
		new Produto(CODIGO, NOME, MARCAR, PRECO, 0, COR);
	}
	
	//NULO
	
	@Test (expected = IllegalArgumentException.class)
	public void testeH_nao_deve_instaciar_um_objeto_produto_passando_codigo_nulo() {
		new Produto(null, NOME, MARCAR, PRECO, QUANTIDADE, COR);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testeI_nao_deve_instaciar_um_objeto_produto_passando_nome_nulo() {
		new Produto(CODIGO, null, MARCAR, PRECO, QUANTIDADE, COR);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testeJ_nao_deve_instaciar_um_objeto_produto_passando_marca_nulo() {
		new Produto(CODIGO, NOME, null, PRECO, QUANTIDADE, COR);
	}
	
	@Test (expected = NullPointerException.class)
	public void testeK_nao_deve_instaciar_um_objeto_produto_passando_null() {
		new Produto(CODIGO, NOME, MARCAR, null, QUANTIDADE, COR);
	}
	
	//CARACTERES
	
	@Test (expected = IllegalStateException.class)
	public void testeL_nao_deve_instaciar_um_objeto_produto_passando_codigo_com_mais_de_100_caracateres() {
		new Produto(CARACTERES_150, NOME, MARCAR, PRECO, QUANTIDADE, COR);
	}
	
	@Test (expected = IllegalStateException.class)
	public void testeM_nao_deve_instaciar_um_objeto_produto_passando_nome_com_mais_de_100_caracateres() {
		new Produto(CODIGO, CARACTERES_150, MARCAR, PRECO, QUANTIDADE, COR);
	}
	
	@Test (expected = IllegalStateException.class)
	public void testeN_nao_deve_instaciar_um_objeto_produto_passando_marca_com_mais_de_100_caracateres() {
		new Produto(CODIGO, NOME, CARACTERES_150, PRECO, QUANTIDADE, COR);
	}
	
	@Test (expected = IllegalStateException.class)
	public void testeO_nao_deve_instaciar_um_objeto_produto_passando_cor_com_mais_de_100_caracateres() {
		new Produto(CODIGO, NOME, MARCAR, PRECO, QUANTIDADE, CARACTERES_150);
	}
	
	//SETTERS

	@Test
	public void testeP_deve_atribuir_um_valor_para_codigo() {
		final String codigo = "IPHONE13PM";
		produtoBefore.setCodigo(codigo);
		assertEquals(codigo, produtoBefore.getCodigo());
	}
	
	@Test
	public void testeQ_deve_atribuir_um_valor_para_nome() {
		final String nome = "IPHONE 13 PRO";
		produtoBefore.setNome(nome);
		assertEquals(nome, produtoBefore.getNome());
	}
	
	@Test
	public void testeR_deve_atribuir_um_valor_para_marca() {
		final String marca = "SAMSUNG";
		produtoBefore.setMarca(marca);
		assertEquals(marca, produtoBefore.getMarca());
	}
	
	@Test
	public void testeS_deve_atribuir_um_valor_para_preco() {
		final double preco = 12.50;
		produtoBefore.setPreco(preco);
		assertEquals(preco, produtoBefore.getPreco());
	}
	
	@Test
	public void testeT_deve_atribuir_um_valor_para_quantidade() {
		final int quantidade = 12;
		produtoBefore.setQuantidade(quantidade);
		assertEquals(quantidade, produtoBefore.getQuantidade());
	}
	
	@Test
	public void testeU_deve_atribuir_um_valor_para_cor() {
		final String cor = "Vermelho";
		produtoBefore.setCor(cor);
		assertEquals(cor, produtoBefore.getCor());
	}
	
	//GETTERS
	
	@Test
	public void testeV_deve_pegar_codigo_do_objeto_empresa() {
		assertEquals(CODIGO, produtoBefore.getCodigo());
	}
	
	@Test
	public void testeW_deve_pegar_nome_do_objeto_empresa() {
		assertEquals(NOME, produtoBefore.getNome());
	}
	
	@Test
	public void testeX_deve_pegar_marca_do_objeto_empresa() {
		assertEquals(MARCAR, produtoBefore.getMarca());
	}
	
	@Test
	public void testeY_deve_pegar_preco_do_objeto_empresa() {
		assertEquals(PRECO, produtoBefore.getPreco());
	}
	
	@Test
	public void testeZ_deve_pegar_nome_do_objeto_empresa() {
		assertEquals(QUANTIDADE, produtoBefore.getQuantidade());
	}
	
	@Test
	public void testeAA_deve_pegar_cor_do_objeto_empresa() {
		assertEquals(COR, produtoBefore.getCor());
	}
	
	//TIMEOUT
	
	@Test
	public void testeAB_deve_validar_se_para_criar_um_objeto_produto_demora_menos_que_2_segundos() {
		assertTimeout(Duration.ofSeconds(2), () -> { new Produto(CODIGO, NOME, MARCAR, PRECO, QUANTIDADE, COR);});
	}
	
	@Test
	public void testeAC_deve_validar_se_para_pegar_o_valor_de_um_objeto_produto_demora_menos_que_2_segundos() {
		assertTimeout(Duration.ofSeconds(2), () -> { produtoBefore.getNome();});
	}
	
	//TO STRING
	@Test
	public void testeAD_deve_validar_se_ao_usar_o_metodos_to_string_ele_traz_codigo() {
		String result = produtoBefore.toString();
		assertThat(result, containsString(produtoBefore.getCodigo()));
	}
	
	@Test
	public void testeAE_deve_validar_se_ao_usar_o_metodos_to_string_ele_traz_nome() {
		String result = produtoBefore.toString();
		assertThat(result, containsString(produtoBefore.getNome()));
	}
	
	@Test
	public void testeAF_deve_validar_se_ao_usar_o_metodos_to_string_ele_traz_marca() {
		String result = produtoBefore.toString();
		assertThat(result, containsString(produtoBefore.getMarca()));
	}
	
	@Test
	public void testeAG_deve_validar_se_ao_usar_o_metodos_to_string_ele_traz_preco() {
		String result = produtoBefore.toString();
		assertThat(result, containsString(String.valueOf(produtoBefore.getPreco())));
	}
	
	@Test
	public void testeAH_deve_validar_se_ao_usar_o_metodos_to_string_ele_traz_quantidade() {
		String result = produtoBefore.toString();
		assertThat(result, containsString(String.valueOf(produtoBefore.getQuantidade())));
	}
	
	@Test
	public void testeAI_deve_validar_se_ao_usar_o_metodos_to_string_ele_traz_cor() {
		String result = produtoBefore.toString();
		assertThat(result, containsString(produtoBefore.getCor()));
	}
	
	//EQUALS
	
	@Test
	public void testeAJ_deve_validar_equals_do_objeto_produto() {
		Produto produto1 = new Produto(CODIGO, NOME, MARCAR, PRECO, QUANTIDADE, COR);
		Produto produto2 = new Produto(CODIGO, NOME, MARCAR, PRECO, QUANTIDADE, COR);
		boolean resp = produto1.equals(produto2);
		assertTrue(resp);
	}
	
	@Test
	public void testeAK_deve_validar_equals_do_objeto_produto_passando_nulo() {
		boolean resp = produtoBefore.equals(null);
		assertFalse(resp);
	}
	
	@Test
	public void testeAL_deve_validar_equals_do_objeto_produto_passando_a_propria_classe() {
		@SuppressWarnings("unlikely-arg-type")
		boolean resp = produtoBefore.equals(produtoBefore.getClass());
		assertFalse(resp);
	}
	
	@Test
	public void testeAM_deve_validar_equals_do_objeto_produto_passando_this() {
		boolean resp = produtoBefore.equals(produtoBefore);
		assertTrue(resp);
	}
	
	//HASHCODE
	@Test
	public void testeAN_deve_validar_hashcode_do_objeto_empresa() {
		Produto produto1 = new Produto(CODIGO, NOME, MARCAR, PRECO, QUANTIDADE, COR);
		Produto produto2 = new Produto(CODIGO, NOME, MARCAR, PRECO, QUANTIDADE, COR);
		assertTrue(produto1.equals(produto2) && produto2.equals(produto1));
		boolean resp = produto2.hashCode() == produto1.hashCode();
		assertTrue(resp);
	}
}
