package br.com.contmatic.model.template;

import br.com.contmatic.model.empresa.Cargo;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class CargoTemplateFixtureFactory implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(Cargo.class).addTemplate("valido", new Rule() {{
			add("nome", "estágio de programador");
			add("descricao", "desenvolver e dar manuteção nos codigos");
		}});
	}

}
