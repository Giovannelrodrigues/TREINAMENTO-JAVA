package br.com.contmatic.model.template;

import br.com.contmatic.model.contato.Email;
import br.com.contmatic.model.empresa.Empresa;
import br.com.contmatic.model.usuario.Usuario;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class UsuarioTemplateFixtureFactory implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(Usuario.class).addTemplate("valido", new Rule() {{
			add("email", one(Email.class, "valido"));
			add("senha", "123Testando");
			add("empresas", has(1).of(Empresa.class, "valido"));
		}});
	}
}
