package br.com.contmatic.testeMain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import br.com.contmatic.testes.TestesSetor;
import br.com.contmatic.testes.validacoes.TestesValidadorCep;
import br.com.contmatic.testes.validacoes.TestesValidadorCnpj;
import br.com.contmatic.testes.validacoes.TestesValidadorCpf;
import br.com.contmatic.testes.validacoes.TestesValidadorTelefone;
import br.com.contmatic.testes.TestesAmbienteTrabalho;
import br.com.contmatic.testes.TestesCargo;
import br.com.contmatic.testes.TestesContato;
import br.com.contmatic.testes.TestesEmpresa;
import br.com.contmatic.testes.TestesEndereco;
import br.com.contmatic.testes.TestesFuncionario;
import br.com.contmatic.testes.TestesProduto;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestesEmpresa.class,
	TestesProduto.class,
	TestesAmbienteTrabalho.class,
	TestesSetor.class,
	TestesFuncionario.class,
	TestesCargo.class,
	TestesContato.class,
	TestesEndereco.class,
	TestesValidadorCep.class,
	TestesValidadorCpf.class,
	TestesValidadorCnpj.class,
	TestesValidadorTelefone.class})
public class Teste {
	
}
