package br.com.contmatic.model.template;

import br.com.contmatic.model.contato.Telefone;
import br.com.contmatic.model.contato.TipoTelefone;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class TelefoneTemplateFixtureFactory implements TemplateLoader{

	@Override
	public void load() {
		Fixture.of(Telefone.class).addTemplate("valido", new Rule() {{
			add("ddi", "+55");
			add("ddd", "11");
			add("numero", "40901770");
			add("tipo", TipoTelefone.FIXO);
		}});
		Fixture.of(Telefone.class).addTemplate("valido-funcionario", new Rule() {{
			add("ddi", "+55");
			add("ddd", "11");
			add("numero", "996300338");
			add("tipo", TipoTelefone.CELULAR);
		}});
	}

}
