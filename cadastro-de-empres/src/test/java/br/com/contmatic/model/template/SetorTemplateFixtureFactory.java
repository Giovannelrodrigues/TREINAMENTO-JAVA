package br.com.contmatic.model.template;

import br.com.contmatic.model.empresa.Funcionario;
import br.com.contmatic.model.empresa.Setor;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class SetorTemplateFixtureFactory implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(Setor.class).addTemplate("valido", new Rule() {{
			add("nome", "Recrutamento e Seleção");
			add("descricao", "fazer entrvistas e selecionar os mais capacitados para integrar nos times");
			add("funcionarios", has(1).of(Funcionario.class, "valido"));
		}});
	}

}
