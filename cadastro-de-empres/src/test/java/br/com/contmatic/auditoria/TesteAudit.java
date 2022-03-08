package br.com.contmatic.auditoria;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.contmatic.model.contato.Email;
import br.com.contmatic.model.empresa.Empresa;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteAudit {

	private static Empresa empresaBefore;

	private static final Email EMAIL = new Email("giovanrodrigues@cont@.com");

	private static final LocalDateTime LOCAL_TIME_VALID = LocalDateTime.of(2023, Month.JUNE, 28, 6, 10, 40, 50000);

	private static final LocalDateTime LOCAL_TIME_ANTEIROR_HOJE = LocalDateTime.of(2021, Month.JANUARY, 6, 10, 40,
			50);

	private static final LocalDateTime LOCAL_TIME_MAX_INVALID = LocalDateTime.of(2028, Month.JUNE, 11, 6, 10, 40,
			50);

	@Before
	public void antesDeCadaTeste() {
		empresaBefore = new Empresa("75044357000170");
	}

	// CREATE BY
	@Test
	public void teste01_deve_atribuir_um_email_ao_createdby() {
		empresaBefore.setCreatedBy(EMAIL);
		assertEquals(EMAIL, empresaBefore.getCreatedBy());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste02_nao_deve_atribuir_um_email_ao_createdby_passando_nulo() {
		empresaBefore.setCreatedBy(null);
	}

	// LastByUpdadeNotify
	@Test
	public void teste03_deve_atribuir_um_email_ao_createdby() {
		empresaBefore.setLastByUpdadeNotify(EMAIL);
		assertEquals(EMAIL, empresaBefore.getLastByUpdadeNotify());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste04_nao_deve_atribuir_um_email_ao_lastByUpdateNotify_passando_nulo() {
		empresaBefore.setLastByUpdadeNotify(null);
	}

	// CREATE DATE
	@Test
	public void teste05_deve_atribuir_uma_data_ao_createdate() {
		empresaBefore.setCreateDate(LOCAL_TIME_VALID);
		assertEquals(LOCAL_TIME_VALID, empresaBefore.getCreateDate());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste06_nao_deve_atribuir_uma_data_ao_createdate_passando_nulo() {
		empresaBefore.setCreateDate(null);
	}

	@Test(expected = IllegalStateException.class)
	public void teste07_nao_deve_atribuir_uma_data_ao_createdate_passando_data_menor_que_hoje() {
		empresaBefore.setCreateDate(LOCAL_TIME_ANTEIROR_HOJE);
	}

	@Test(expected = IllegalStateException.class)
	public void teste08_nao_deve_atribuir_uma_data_ao_createdate_passando_data_maior_que_dois_anos() {
		empresaBefore.setCreateDate(LOCAL_TIME_MAX_INVALID);
	}
	
	// LATS BY UPDATE DATE
	@Test
	public void teste09_deve_atribuir_uma_data_ao_LastDateUpdadeNotify() {
		empresaBefore.setLastDateUpdadeNotify(LOCAL_TIME_VALID);
		assertEquals(LOCAL_TIME_VALID, empresaBefore.getLastDateUpdadeNotify());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste10_nao_deve_atribuir_uma_data_ao_LastDateUpdadeNotify_passando_nulo() {
		empresaBefore.setLastDateUpdadeNotify(null);
	}

	@Test(expected = IllegalStateException.class)
	public void teste11_nao_deve_atribuir_uma_data_ao_LastDateUpdadeNotify_passando_data_menor_que_hoje() {
		empresaBefore.setLastDateUpdadeNotify(LOCAL_TIME_ANTEIROR_HOJE);
	}

	@Test(expected = IllegalStateException.class)
	public void teste12_nao_deve_atribuir_uma_data_ao_LastDateUpdadeNotify_passando_data_maior_que_dois_anos() {
		empresaBefore.setLastDateUpdadeNotify(LOCAL_TIME_MAX_INVALID);
	}
}
