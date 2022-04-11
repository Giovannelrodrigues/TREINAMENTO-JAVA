package br.com.contmatic.model.template;

import br.com.contmatic.model.empresa.AmbienteTrabalho;
import br.com.contmatic.model.empresa.Setor;
import br.com.contmatic.model.empresa.TipoAmbienteTrabalho;
import br.com.contmatic.model.endereco.Endereco;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class AmbienteTrabalhoTemplateFixtureFactory implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(AmbienteTrabalho.class).addTemplate("valido", new Rule() {{
			add("nome", "Recursos Humanos");
			add("descricao", "descricao cuidar da parte de contratos");
			add("tipo", TipoAmbienteTrabalho.PROPRIO);
			add("setores", has(1).of(Setor.class, "valido"));
			add("enderecos", has(1).of(Endereco.class, "valido"));
		}});
	}
}
