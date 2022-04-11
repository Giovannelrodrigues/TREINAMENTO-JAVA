package br.com.contmatic.model.template;

import br.com.contmatic.model.endereco.Cidade;
import br.com.contmatic.model.endereco.Estado;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class EstadoTemplateFixtureFactory implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(Estado.class).addTemplate("valido", new Rule() {{
			add("nome", "São Paulo");
			add("sigla", "SP");
			add("cidades", has(1).of(Cidade.class, "valido"));
		}});
	}

}
