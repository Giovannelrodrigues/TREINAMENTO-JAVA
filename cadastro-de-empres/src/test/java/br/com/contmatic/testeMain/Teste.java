package br.com.contmatic.testeMain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import br.com.contmatic.testes.usuario.TesteUsuario;
import br.com.contmatic.teste.TesteAudit;
import br.com.contmatic.teste.TesteCidade;
import br.com.contmatic.teste.TesteEmail;
import br.com.contmatic.teste.TesteEndereco;
import br.com.contmatic.teste.TesteEstado;
import br.com.contmatic.teste.TesteTelefone;
import br.com.contmatic.testes.empresa.TesteEmpresa;
import br.com.contmatic.testes.empresa.TesteFuncionario;
import br.com.contmatic.testes.empresa.TesteAmbienteTrabalho;
import br.com.contmatic.testes.empresa.TesteCargo;
import br.com.contmatic.testes.empresa.TesteProduto;
import br.com.contmatic.testes.empresa.TesteSetor;

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
	TesteAudit.class,
	TesteFuncionario.class,
	TesteEstado.class,
	TesteCidade.class
	})
public class Teste {
	
}

