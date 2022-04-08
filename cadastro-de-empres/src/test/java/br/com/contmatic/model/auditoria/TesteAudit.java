package br.com.contmatic.model.auditoria;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
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

	private static final Email EMAIL = new Email("giovannerodrigues@hotmail.com");
			
	private static final String IP = "192.168.4.193";

	private static final LocalDateTime LOCAL_TIME_VALID = LocalDateTime.of(2023, Month.JUNE, 28, 6, 10, 40, 50000);

	private static final LocalDateTime LOCAL_TIME_ANTEIROR_HOJE = LocalDateTime.of(2021, Month.JANUARY, 6, 10, 40, 50);

	private static final LocalDateTime LOCAL_TIME_MAX_INVALID = LocalDateTime.of(2028, Month.JUNE, 11, 6, 10, 40, 50);

	@Before
	public void teste00_antes_de_cada_test() {
		empresaBefore = new Empresa("75044357000170");
	}

	//CREATEBY
	@Test
	public void teste01_deve_setar_createdby() {
		empresaBefore.setCreatedBy(EMAIL);
		assertEquals(EMAIL, empresaBefore.getCreatedBy());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste02_nao_deve_setar_createdby_passando_nulo() {
		empresaBefore.setCreatedBy(null);
	}

	//UPDATEDBY
	@Test
	public void teste03_deve_setar_updatedby() {
		empresaBefore.setUpdateBy(EMAIL);
		assertEquals(EMAIL, empresaBefore.getUpdatedBy());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste04_nao_deve_setar_updatedby_passando_nulo() {
		empresaBefore.setUpdateBy(null);
	}

	//CREATEDDATE
	@Test
	public void teste05_deve_setar_data_ao_createdate() {
		empresaBefore.setCreateDate(LOCAL_TIME_VALID);
		assertEquals(LOCAL_TIME_VALID, empresaBefore.getCreateDate());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste06_nao_deve_setar_createdate_passando_nulo() {
		empresaBefore.setCreateDate(null);
	}

	@Test(expected = IllegalStateException.class)
	public void teste07_nao_deve_setar_createdate_passando_data_menor_que_hoje() {
		empresaBefore.setCreateDate(LOCAL_TIME_ANTEIROR_HOJE);
	}

	@Test(expected = IllegalStateException.class)
	public void teste08_nao_deve_setar_createdate_passando_data_maior_que_dois_anos() {
		empresaBefore.setCreateDate(LOCAL_TIME_MAX_INVALID);
	}
	
	//UPDATEDDATE
	@Test
	public void teste09_deve_setar_data_ao_updateddate() {
		empresaBefore.setUpdatedDate(LOCAL_TIME_VALID);
		assertEquals(LOCAL_TIME_VALID, empresaBefore.getUpdatedDate());
	}

	@Test(expected = IllegalArgumentException.class)
	public void teste10_nao_deve_setar_updateddate_passando_nulo() {
		empresaBefore.setUpdatedDate(null);
	}

	@Test(expected = IllegalStateException.class)
	public void teste11_nao_deve_setar_updateddate_passando_data_menor_que_hoje() {
		empresaBefore.setUpdatedDate(LOCAL_TIME_ANTEIROR_HOJE);
	}

	@Test(expected = IllegalStateException.class)
	public void teste12_nao_deve_setar_updateddate_passando_data_maior_que_dois_anos() {
		empresaBefore.setUpdatedDate(LOCAL_TIME_MAX_INVALID);
	}
	
	//CREATEDIP
	@Test
	public void teste13_deve_setar_createdip() {
		empresaBefore.setCreatedIp(IP);
		assertEquals(IP, empresaBefore.getCreatedIp());
	}
	
	@Test(expected = IllegalStateException.class)
	public void teste15_nao_deve_setar_createdip_passando_sem_formatacao() {
		String IP_NOT_FORMATED = "192146032323";
		empresaBefore.setCreatedIp(IP_NOT_FORMATED);
	}
	
	@Test(expected = IllegalStateException.class)
	public void teste16_nao_deve_setar_createdip_passando_mais_que_15_caracteres() {
		String IP_INVALID_LEGTH = "19214603232331313";
		empresaBefore.setCreatedIp(IP_INVALID_LEGTH);
	}
	
	@Test(expected = IllegalStateException.class)
	public void teste17_nao_deve_setar_createdip_passando_menos_que_7_caracteres() {
		String IP_INVALID_LEGTH = "19214";
		empresaBefore.setCreatedIp(IP_INVALID_LEGTH);
	}
	
	//UPDATEDIP
	@Test
	public void teste18_deve_setar_updatedip() {
		empresaBefore.setUpdatedIp(IP);
		assertEquals(IP, empresaBefore.getUpdatedIp());
	}
	
	@Test(expected = IllegalStateException.class)
	public void teste19_nao_deve_setar_updatedip_passando_sem_formatacao() {
		String IP_NOT_FORMATED = "192146032323";
		empresaBefore.setUpdatedIp(IP_NOT_FORMATED);
	}
	
	@Test(expected = IllegalStateException.class)
	public void teste20_nao_deve_setar_updatedip_passando_mais_que_15_caracteres() {
		String IP_INVALID_MAX_LENGTH = "1921463424242424242413";
		empresaBefore.setUpdatedIp(IP_INVALID_MAX_LENGTH);
	}
	
	@Test(expected = IllegalStateException.class)
	public void teste21_nao_deve_setar_updatedip_passando_menos_que_7_caracteres() {
		String IP_INVALID_MIN_LENGTH = "113134";
		empresaBefore.setUpdatedIp(IP_INVALID_MIN_LENGTH);
	}
	
	// TO STRING
	@Test
	public void teste22_deve_retornar_createby_no_to_string() {
		String result = empresaBefore.toString();
		assertThat(result, containsString(String.valueOf(empresaBefore.getCreatedBy())));
	}

	@Test
	public void teste23_deve_retornar_create_date_no_to_string() {
		String result = empresaBefore.toString();
		assertThat(result, containsString(String.valueOf(empresaBefore.getCreateDate())));
	}

	@Test
	public void teste24_deve_retornar_updatedby_no_to_string() {
		String result = empresaBefore.toString();
		assertThat(result, containsString(String.valueOf(empresaBefore.getUpdatedBy())));
	}

	@Test
	public void teste25_deve_retornar_updatedby_date_no_to_string() {
		String result = empresaBefore.toString();
		assertThat(result, containsString(String.valueOf(empresaBefore.getUpdatedDate())));
	}
	
	@Test
	public void teste26_deve_retornar_createdip_no_to_string() {
		String result = empresaBefore.toString();
		assertThat(result, containsString(String.valueOf(empresaBefore.getCreatedIp())));
	}

	@Test
	public void teste27_deve_retornar_updatedip_date_no_to_string() {
		String result = empresaBefore.toString();
		assertThat(result, containsString(String.valueOf(empresaBefore.getUpdatedIp())));
	}
}
