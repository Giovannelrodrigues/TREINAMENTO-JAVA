package br.com.contmatic.model.contato;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteEmail {

	private static Email emailBefore;

	private static final String EMAIL = "giovannerodrigues@gmail.com";

	@Before
	public void teste00_antes_de_cada_teste() {
		emailBefore = new Email(EMAIL);
	}

	@Test
	public void teste01_deve_setar_novo_email() {
		assertEquals(EMAIL, emailBefore.getEndereco());
	}

	// EMAIL
	@Test
	public void teste02_deve_setar_email() {
		String email = "gio@cont.com";
		emailBefore.setEndereco(email);
		assertEquals(email, emailBefore.getEndereco());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste03_nao_setar_email_passando_nulo() {
		emailBefore.setEndereco(null);
	}

	@Test(expected = IllegalStateException.class)
	public void teste04_nao_setar_email_passando_string_vazia() {
		emailBefore.setEndereco("   ");
	}

	@Test(expected = IllegalStateException.class)
	public void teste05_nao_deve_setar_email_passando_mais_de_100_caracteres() {
		emailBefore.setEndereco("giovannelrodriguesgiovannesgiovannelrodriguesgiovannelrodriguesgielrodriguesgiovannelrodriguesgiovannelrodrigues@gmail.com");
	}

	@Test(expected = IllegalStateException.class)
	public void teste06_nao_deve_setar_email_passando_menos_de_5_caracteres() {
		emailBefore.setEndereco("g@");
	}

	@Test(expected = IllegalStateException.class)
	public void teste07_nao_deve_setar_email_sem_passar_caractere_obrigatorio() {
		emailBefore.setEndereco("giovannelrodrigues.gmail.com");
	}
	
	//TIPO
	
	@Test
	public void teste08_deve_setar_tipo_email() {
		emailBefore.setTipo(TipoEmail.COMERCIAL);
		assertEquals(TipoEmail.COMERCIAL, emailBefore.getTipo());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void teste09_nao_deve_setar_tipo_email_passando_nullo() {
		emailBefore.setTipo(null);
	}

	// TO STRING
	@Test
	public void teste09_deve_retonar_email_no_to_string() {
		String result = emailBefore.toString();
		assertThat(result, containsString(emailBefore.getEndereco()));
	}
	
	@Test
	public void teste10_deve_retonar_tipo_no_to_string() {
		String result = emailBefore.toString();
		assertThat(result, containsString(String.valueOf(emailBefore.getTipo())));
	}

	// HASHCODE
	@Test
	public void teste11_deve_retornar_o_mesmo_hashcode_para_emails_iguais() {
		Email email1 = new Email(EMAIL);
		Email email2 = new Email(EMAIL);
		boolean resp = email1.hashCode() == email2.hashCode();
		assertTrue(resp);
	}
	
	@Test
	public void teste12_deve_retornar_diferente_hashcode_para_emails_diferentes() {
		Email email1 = new Email(EMAIL);
		Email email2 = new Email("giovannerodrigu@gmail.com");
		boolean resp = email1.hashCode() == email2.hashCode();
		assertFalse(resp);
	}
	
	@Test
	public void teste13_deve_retornar_o_hashcode_diferente_para_emails_iguais_de_tipos_diferentes() {
		Email email1 = new Email(EMAIL, TipoEmail.COMERCIAL);
		Email email2 = new Email(EMAIL, TipoEmail.PESSOAL);
		boolean resp = email1.hashCode() == email2.hashCode();
		assertTrue(resp);
	}

	// EQUALS
	@Test
	public void teste14_deve_retornar_true_quando_usar_equals_passado_emails_iguais() {
		Email email1 = new Email(EMAIL);
		Email email2 = new Email(EMAIL);
		boolean resp = email1.equals(email2);
		assertTrue(resp);
	}
	
	@Test
	public void teste15_deve_retornar_false_quando_usar_equals_passado_emails_diferentes() {
		Email email1 = new Email(EMAIL);
		Email email2 = new Email("GIO@GIOVANNE.COM");
		boolean resp = email1.equals(email2);
		assertFalse(resp);
	}
	
	@Test
	public void teste16_deve_retornar_true_quando_usar_equals_passado_emails_iguais_tipos_diferentes() {
		Email email1 = new Email(EMAIL, TipoEmail.COMERCIAL);
		Email email2 = new Email(EMAIL, TipoEmail.PESSOAL);
		boolean resp = email1.hashCode() == email2.hashCode();
		assertTrue(resp);
	}

	@Test
	public void teste17_deve_retornar_falso_quando_usar_equals_passado_nulo() {
		boolean resp = emailBefore.equals(null);
		assertFalse(resp);
	}

	@Test
	public void teste18_deve_retornar_falso_quando_usar_equals_passado_outro_objeto() {
		boolean resp = emailBefore.equals(new Object());
		assertFalse(resp);
	}

	@Test
	public void teste19_deve_retornar_true_quando_usar_equals_passado_o_proprio_objeto() {
		boolean resp = emailBefore.equals(emailBefore);
		assertTrue(resp);
	}

}
