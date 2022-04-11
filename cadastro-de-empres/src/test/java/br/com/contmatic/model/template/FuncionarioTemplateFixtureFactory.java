package br.com.contmatic.model.template;

import br.com.contmatic.model.contato.Email;
import br.com.contmatic.model.contato.Telefone;
import br.com.contmatic.model.empresa.Cargo;
import br.com.contmatic.model.empresa.Funcionario;
import br.com.contmatic.model.endereco.Endereco;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class FuncionarioTemplateFixtureFactory implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(Funcionario.class).addTemplate("valido", new Rule() {{
			add("cpf", "39199101840");
			add("nome", "Giovanne Lisboa Rodrigues");
			add("cargo", one(Cargo.class, "valido"));
			add("dataNacimento", "20062003");
			add("endereco", one(Endereco.class, "valido-funcionario"));
			add("telefones", has(1).of(Telefone.class, "valido-funcionario"));
			add("emails", has(1).of(Email.class, "valido-funcionario"));
		}});
	}

}
