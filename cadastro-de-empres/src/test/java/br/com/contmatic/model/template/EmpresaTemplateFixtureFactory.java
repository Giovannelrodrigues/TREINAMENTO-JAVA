package br.com.contmatic.model.template;

import br.com.contmatic.model.contato.Email;
import br.com.contmatic.model.contato.Telefone;
import br.com.contmatic.model.empresa.AmbienteTrabalho;
import br.com.contmatic.model.empresa.Empresa;
import br.com.contmatic.model.empresa.Produto;
import br.com.contmatic.model.endereco.Endereco;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class EmpresaTemplateFixtureFactory implements TemplateLoader{

	@Override
	public void load() {
		Fixture.of(Empresa.class).addTemplate("valido", new Rule() {{
			add("cnpj", "63547001000170");
			add("nomeFantasia", "Contmatic Phoenix");
			add("razaoSocial", "Softmatic Sistemas Automaticos de Informatica Ltda");
			add("enderecos",  one(Endereco.class, "valido"));
			add("ambientesTrabalhos",  one(AmbienteTrabalho.class, "valido"));
			add("produtos", one(Produto.class, "valido"));
			add("telefones", one(Telefone.class, "valido"));
			add("emails", one(Email.class, "valido-empresa"));
			add("status", true);
		}});
	}

}
