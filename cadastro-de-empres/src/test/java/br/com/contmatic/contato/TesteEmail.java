package br.com.contmatic.contato;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.contmatic.model.contato.Email;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteEmail {

	private static Email emailBefore;

	private static final String EMAIL = "giovanne.rodrigues@cont@.com";

	@Before
	public void antesDeTodosOsTeste() {
		emailBefore = new Email(EMAIL);
	}

	@Test
	public void teste01_deve_instaciar_um_novo_email() {
		assertEquals(EMAIL, emailBefore.getEmail());
	}

	// EMAIL
	@Test
	public void teste02_deve_atribuir_um_novo_valor_para_email() {
		String email = "gio@cont.com";
		emailBefore.setEmail(email);
		assertEquals(email, emailBefore.getEmail());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste03_nao_deve_atribuir_um_novo_valor_para_email_passando_nulo() {
		emailBefore.setEmail(null);
	}

	@Test(expected = IllegalStateException.class)
	public void teste04_nao_deve_atribuir_um_novo_valor_para_email_passando_string_vazia() {
		emailBefore.setEmail("   ");
	}

	@Test(expected = IllegalStateException.class)
	public void teste05_nao_deve_atribuir_um_novo_valor_para_email_passando_mais_de_100_caracteres() {
		emailBefore.setEmail("giovannelrodriguesgiovannesgiovannelrodriguesgiovannelrodriguesgielrodriguesgiovannelrodriguesgiovannelrodrigues@gmail.com");
	}

	@Test(expected = IllegalStateException.class)
	public void teste06_nao_deve_atribuir_um_novo_valor_para_email_passando_menos_de_5_caracteres() {
		emailBefore.setEmail("g@");
	}

	@Test(expected = IllegalStateException.class)
	public void teste07_nao_deve_atribuir_um_novo_valor_para_email_sem_passar_caractere_obrigatorio() {
		emailBefore.setEmail("giovannelrodrigues.gmail.com");
	}

	// TO STRING
	@Test
	public void teste08_deve_retonar_email_no_to_string() {
		String result = emailBefore.toString();
		assertThat(result, containsString(emailBefore.getEmail().toString()));
	}

	// HASHCODE
	@Test
	public void teste09_deve_retornar_o_mesmo_hashcode_para_emails_iguais() {
		Email email1 = new Email(EMAIL);
		Email email2 = new Email(EMAIL);
		boolean resp = email1.hashCode() == email2.hashCode();
		assertTrue(resp);
	}
	
	@Test
	public void teste10_deve_retornar_o_hashcode_diferente_para_emails_diferentes() {
		Email email1 = new Email(EMAIL);
		Email email2 = new Email("giovannerodri@gmail.com");
		boolean resp = email1.hashCode() == email2.hashCode();
		assertFalse(resp);
	}

	// EQUALS
	@Test
	public void teste10_deve_retornar_true_quando_usar_equals_passado_emails_iguais() {
		Email email1 = new Email(EMAIL);
		Email email2 = new Email(EMAIL);
		boolean resp = email1.equals(email2);
		assertTrue(resp);
	}
	
	@Test
	public void teste11_deve_retornar_false_quando_usar_equals_passado_emails_diferentes() {
		Email email1 = new Email(EMAIL);
		Email email2 = new Email("GIO@GIOVANNE.COM");
		boolean resp = email1.equals(email2);
		assertFalse(resp);
	}

	@Test
	public void teste12_deve_retornar_falso_quando_usar_equals_passado_nulo() {
		boolean resp = emailBefore.equals(null);
		assertFalse(resp);
	}

	@Test
	public void teste13_deve_retornar_falso_quando_usar_equals_passado_object() {
		boolean resp = emailBefore.equals(new Object());
		assertFalse(resp);
	}

	@Test
	public void teste14_deve_retornar_true_quando_usar_equals_passado_o_proprio_objeto() {
		boolean resp = emailBefore.equals(emailBefore);
		assertTrue(resp);
	}

}
