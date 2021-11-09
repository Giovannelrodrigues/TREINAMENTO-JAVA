package br.com.contmatic.testeMain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import br.com.contmatic.testes.SetorTeste;
import br.com.contmatic.testes.validacoes.ValidadorCepTeste;
import br.com.contmatic.testes.validacoes.ValidadorCnpjTeste;
import br.com.contmatic.testes.validacoes.ValidadorCpfTeste;
import br.com.contmatic.testes.validacoes.ValidadorTelefoneTeste;
import br.com.contmatic.testes.AmbienteTrabalhoTeste;
import br.com.contmatic.testes.CargoTeste;
import br.com.contmatic.testes.ContatoTeste;
import br.com.contmatic.testes.EmpresaTeste;
import br.com.contmatic.testes.EnderecoTeste;
import br.com.contmatic.testes.FuncionarioTeste;
import br.com.contmatic.testes.ProdutoTeste;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	SetorTeste.class,
	CargoTeste.class,
	ProdutoTeste.class,
	ContatoTeste.class,
	EmpresaTeste.class,
	EnderecoTeste.class,
	FuncionarioTeste.class,
	ValidadorCepTeste.class,
	ValidadorCpfTeste.class,
	ValidadorCnpjTeste.class,
	AmbienteTrabalhoTeste.class,
	ValidadorTelefoneTeste.class})
public class Teste {
	
}
