package br.com.contmatic.model.template;

import br.com.contmatic.model.endereco.Cidade;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class CidadeTemplateFixtureFactory implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(Cidade.class).addTemplate("valido", new Rule() {{
			add("codigoIBGE", 35);
			add("nome", "São Paulo");
		}});
	}

}
