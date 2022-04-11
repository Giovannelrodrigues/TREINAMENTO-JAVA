package br.com.contmatic.model.template;

import br.com.contmatic.model.contato.Email;
import br.com.contmatic.model.contato.TipoEmail;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class EmailTemplateFixtureFactory implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(Email.class).addTemplate("valido", new Rule() {{
			add("endereco", "giovanne@gmail.com");
			add("tipo", TipoEmail.PESSOAL);
		}});
		Fixture.of(Email.class).addTemplate("valido-empresa", new Rule() {{
			add("endereco", "recusoshumanos@contmatic.com");
			add("tipo", TipoEmail.COMERCIAL);
		}});
		Fixture.of(Email.class).addTemplate("valido-funcionario", new Rule() {{
			add("endereco", "giovannelrodrigues@contmatic.com");
			add("tipo", TipoEmail.COMERCIAL);
		}});
	}

}
