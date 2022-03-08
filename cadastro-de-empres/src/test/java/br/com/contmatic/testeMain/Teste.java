package br.com.contmatic.testeMain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import br.com.contmatic.auditoria.TesteAudit;
import br.com.contmatic.contato.TesteEmail;
import br.com.contmatic.contato.TesteTelefone;
import br.com.contmatic.endereco.TesteCidade;
import br.com.contmatic.endereco.TesteEndereco;
import br.com.contmatic.endereco.TesteEstado;
import br.com.contmatic.testes.empresa.TesteAmbienteTrabalho;
import br.com.contmatic.testes.empresa.TesteCargo;
import br.com.contmatic.testes.empresa.TesteEmpresa;
import br.com.contmatic.testes.empresa.TesteFuncionario;
import br.com.contmatic.testes.empresa.TesteProduto;
import br.com.contmatic.testes.empresa.TesteSetor;
import br.com.contmatic.testes.usuario.TesteUsuario;

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

