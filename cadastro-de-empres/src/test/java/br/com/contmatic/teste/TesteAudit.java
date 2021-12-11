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

import br.com.contmatic.model.Audit;
import br.com.contmatic.model.Email;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteAudit {

	private static final Email EMAIL = new Email("giovannelrodrigues@gmail.com");

	private static Audit auditBefore;

	private static final LocalDateTime LOCAL_TIME = LocalDateTime.of(2017, Month.FEBRUARY, 3, 6, 30, 40, 50000);

	@Before
	public void antesDeCadaTeste() {
		auditBefore = new Audit(EMAIL, LOCAL_TIME);
	}

	@Test
	public void teste01_deve_instanciar_uma_nova_classe_audit() {
		assertEquals(LOCAL_TIME, auditBefore.getCreateDate());
	}

	// CREATE BY
	@Test
	public void teste02_deve_retornar_por_quem_foi_criado() {
		assertEquals(EMAIL, auditBefore.getCreatedBy());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste03_nao_deve_retornar_por_quem_foi_criado_passando_email_nulo() {
		auditBefore.setCreatedBy(null);
	}

	// CREATE TIME
	@Test
	public void teste04_deve_retornar_quando_foi_criado() {
		assertEquals(LOCAL_TIME, auditBefore.getCreateDate());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void teste05_nao_deve_retornar_por_quem_foi_criado_passando_create_by_nulo() {
		auditBefore.setCreateDate(null);
	}
	
	//LAST BY UPDATE NOTIFY
	@Test
	public void teste06_deve_retornar_por_quem_foi_alterado() {
		auditBefore.setLastByUpdadeNotify(EMAIL);
		assertEquals(EMAIL, auditBefore.getLastByUpdadeNotify());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste07_nao_deve_retornar_por_quem_foi_alterado_passando_email_nulo() {
		auditBefore.setCreatedBy(null);
	}
	
	// LAST DATE UPDATE NOTIFY
	@Test
	public void teste08_deve_retornar_quando_foi_alterado() {
		auditBefore.setLastDateUpdadeNotify(LOCAL_TIME);
		assertEquals(LOCAL_TIME, auditBefore.getLastDateUpdadeNotify());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void teste09_nao_deve_retornar_por_quem_foi_alterado_passando_create_by_nulo() {
		auditBefore.setLastDateUpdadeNotify(null);
	}

	// TO STRING
	@Test
	public void teste10_deve_retornar_createby_no_to_string() {
		String result = auditBefore.toString();
		assertThat(result, containsString(String.valueOf(auditBefore.getCreatedBy())));
	}

	@Test
	public void teste11_deve_retornar_createa_date_no_to_string() {
		String result = auditBefore.toString();
		assertThat(result, containsString(String.valueOf(auditBefore.getCreateDate())));
	}
	
	@Test
	public void teste12_deve_retornar_LastDateUpdadeNotify_no_to_string() {
		String result = auditBefore.toString();
		assertThat(result, containsString(String.valueOf(auditBefore.getLastDateUpdadeNotify())));
	}

	@Test
	public void teste13_deve_retornar_LastByUpdadeNotify_date_no_to_string() {
		String result = auditBefore.toString();
		assertThat(result, containsString(String.valueOf(auditBefore.getLastByUpdadeNotify())));
	}

	// HASH CODE
	@Test
	public void teste14_deve_retornar_true_no_hashcode_ao_instanciar__exatamente_ao_mesmo_tempo() {
		Audit audit1 = new Audit(EMAIL, LOCAL_TIME);
		boolean resp = audit1.hashCode() == auditBefore.hashCode();
		assertTrue(resp);
	}

	@Test
	public void teste15_deve_retornar_false_no_hashcode_ao_instanciar_tempo_diferente() {
		long delay = 10;
		new Thread(() -> {
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		Audit audit1 = new Audit(EMAIL, LocalDateTime.now());
		boolean resp = audit1.hashCode() == auditBefore.hashCode();
		assertFalse(resp);
	}

	@Test
	public void teste16_deve_retornar_false_no_hashcode_ao_instanciar_com_email_diferentes() {
		Audit audit1 = new Audit(new Email("giova@gmail.com"), LOCAL_TIME);
		boolean resp = audit1.hashCode() == auditBefore.hashCode();
		assertFalse(resp);
	}

	// EQUALS
	@Test
	public void teste17_deve_retornar_true_quando_usar_equals_passado_audits_iguais() {
		Audit audit1 = new Audit(EMAIL, LOCAL_TIME);
		boolean resp = auditBefore.equals(audit1);
		assertTrue(resp);
	}
	
	@Test
	public void teste18_deve_retornar_true_quando_usar_equals_passado_email_igual_tempo_diferente() {
		Audit audit1 = new Audit(EMAIL, LocalDateTime.of(2018, Month.FEBRUARY, 6, 3, 25, 40, 50000));
		boolean resp = auditBefore.equals(audit1);
		assertFalse(resp);
	}
	
	@Test
	public void teste19_deve_retornar_true_quando_usar_equals_passado_email_igual_tempo_diferente() {
		Audit audit1 = new Audit(new Email("giova@gmail.com"), LOCAL_TIME);
		boolean resp = auditBefore.equals(audit1);
		assertFalse(resp);
	}

	@Test
	public void teste20_deve_retornar_falso_quando_usar_equals_passado_nulo() {
		boolean resp = auditBefore.equals(null);
		assertFalse(resp);
	}

	@Test
	public void teste21_deve_retornar_falso_quando_usar_equals_passado_object() {
		boolean resp = auditBefore.equals(new Object());
		assertFalse(resp);
	}

	@Test
	public void teste22_deve_retornar_true_quando_usar_equals_passado_o_proprio_objeto() {
		boolean resp = auditBefore.equals(auditBefore);
		assertTrue(resp);
	}
}
