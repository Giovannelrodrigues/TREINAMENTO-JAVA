package br.com.contmatic.testes.usuario;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.contmatic.model.Email;
import br.com.contmatic.model.usuario.Usuario;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteUsuario {

	private static Usuario usuarioBefore;

	private static final Email EMAIL = new Email("giovannelrodrigues@gmail.com");

	private static final String SENHA = "123Abc123Abc";

	@Before
	public void antesDeCadaTeste() {
		usuarioBefore = new Usuario(EMAIL, SENHA);
	}

	// CONSTRUTOR
	@Test
	public void teste01_deve_instaciar_um_objeto_usuario() {
		assertEquals(EMAIL, usuarioBefore.getEmail());
		assertEquals(SENHA, usuarioBefore.getSenha());
	}

	// Email
	@Test
	public void teste02_deve_retornar_o_email() {
		assertEquals(EMAIL, usuarioBefore.getEmail());
	}

	@Test
	public void teste03_deve_atribuir_novo_email() {
		Email email = new Email("novo.email@gmail.com");
		usuarioBefore.setEmail(email);
		assertEquals(email, usuarioBefore.getEmail());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste04_nao_deve_atribuir_novo_email_passando_nulo() {
		usuarioBefore.setEmail(null);
	}

	// SENHA
	@Test
	public void teste05_deve_atribuir_nova_senha() {
		String senha = "1723seNHA";
		usuarioBefore.setSenha(senha);
		assertEquals(senha, usuarioBefore.getSenha());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste06_nao_deve_atribuir_nova_senha_passando_nulo() {
		usuarioBefore.setSenha(null);
	}

	@Test(expected = IllegalStateException.class)
	public void teste07_nao_deve_atribuir_nova_senha_passando_string_vazia() {
		usuarioBefore.setSenha("    ");
	}

	@Test(expected = IllegalStateException.class)
	public void teste09_nao_deve_atribuir_nova_senha_passando_string_sem_letras_maiusculas() {
		usuarioBefore.setSenha("senha123456");
	}

	@Test(expected = IllegalStateException.class)
	public void teste10_nao_deve_atribuir_nova_senha_passando_string_sem_letras_minusculas() {
		usuarioBefore.setSenha("SENHA123456");
	}

	@Test(expected = IllegalStateException.class)
	public void teste11_nao_deve_atribuir_nova_senha_passando_string_sem_numero() {
		usuarioBefore.setSenha("SENHAsenhaSenha");
	}

	@Test(expected = IllegalStateException.class)
	public void teste12_nao_deve_atribuir_nova_senha_com_mais_de_30_caracteres() {
		usuarioBefore.setSenha("SENHAsenhaSenhaSENHAsenha12345SENHAsenhaSenha");
	}

	@Test(expected = IllegalStateException.class)
	public void teste13_nao_deve_atribuir_nova_senha_com_menos_de_8_caracteres() {
		usuarioBefore.setSenha("Se123");
	}

	// TO STRING
	@Test
	public void teste14_deve_retornar_o_email_do_usuario_no_to_string() {
		String result = usuarioBefore.toString();
		assertThat(result, containsString(String.valueOf(usuarioBefore.getEmail())));
	}

	// HASHCODE
	@Test
	public void teste15_deve_retornar_o_mesmo_hashcode_para_usuarios_iguais() {
		Usuario usuario1 = new Usuario(EMAIL, SENHA);
		Usuario usuario2 = new Usuario(EMAIL, SENHA);
		boolean resp = usuario1.hashCode() == usuario2.hashCode();
		assertTrue(resp);
	}

	@Test
	public void teste16_deve_retornar_o_mesmo_hashcode_para_usuarios_com_mesmo_email_e_senha_diferente() {
		Usuario usuario1 = new Usuario(EMAIL, SENHA);
		Usuario usuario2 = new Usuario(EMAIL, "testeTeste123");
		boolean resp = usuario1.hashCode() == usuario2.hashCode();
		assertTrue(resp);
	}

	@Test
	public void teste17_nao_deve_retornar_o_mesmo_hashcode_para_usuarios_com_email_diferentes() {
		Usuario usuario1 = new Usuario(EMAIL, SENHA);
		Usuario usuario2 = new Usuario(new Email("giovane@gio.com"), SENHA);
		boolean resp = usuario1.hashCode() == usuario2.hashCode();
		assertFalse(resp);
	}

	// EQUALS
	@Test
	public void teste18_deve_retornar_true_quando_usar_equals_passado_usuarios_com_mesmo_email() {
		Usuario usuario1 = new Usuario(EMAIL, SENHA);
		Usuario usuario2 = new Usuario(EMAIL, "123Tri123");
		boolean resp = usuario1.equals(usuario2);
		assertTrue(resp);
	}

	@Test
	public void teste19_deve_retornar_falso_quando_usar_equals_passado_nulo() {
		boolean resp = usuarioBefore.equals(null);
		assertFalse(resp);
	}

	@Test
	public void teste20_deve_retornar_falso_quando_usar_equals_passado_object() {
		boolean resp = usuarioBefore.equals(new Object());
		assertFalse(resp);
	}

	@Test
	public void teste21_deve_retornar_true_quando_usar_equals_passado_o_proprio_objeto() {
		boolean resp = usuarioBefore.equals(usuarioBefore);
		assertTrue(resp);
	}

}
