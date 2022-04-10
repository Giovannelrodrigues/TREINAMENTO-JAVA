package br.com.contmatic.testeMain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import br.com.contmatic.model.auditoria.TesteAudit;
import br.com.contmatic.model.contato.TesteEmail;
import br.com.contmatic.model.contato.TesteTelefone;
import br.com.contmatic.model.empresa.TesteAmbienteTrabalho;
import br.com.contmatic.model.empresa.TesteCargo;
import br.com.contmatic.model.empresa.TesteEmpresa;
import br.com.contmatic.model.empresa.TesteFuncionario;
import br.com.contmatic.model.empresa.TesteProduto;
import br.com.contmatic.model.empresa.TesteSetor;
import br.com.contmatic.model.endereco.TesteCidade;
import br.com.contmatic.model.endereco.TesteEndereco;
import br.com.contmatic.model.endereco.TesteEstado;
import br.com.contmatic.model.usuario.TesteUsuario;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	TesteUsuario.class,
	TesteEmpresa.class,
	TesteEndereco.class,
	TesteAmbienteTrabalho.class,
	TesteProduto.class,
	TesteTelefone.class,
	TesteEmail.class,
	TesteSetor.class,
	TesteCargo.class,
	TesteFuncionario.class,
	TesteEstado.class,
	TesteCidade.class,
	TesteAudit.class
	})
public class Teste {
	 
}

