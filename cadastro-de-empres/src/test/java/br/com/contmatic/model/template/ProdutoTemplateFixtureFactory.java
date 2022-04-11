package br.com.contmatic.model.template;

import br.com.contmatic.model.empresa.Produto;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class ProdutoTemplateFixtureFactory implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(Produto.class).addTemplate("valido", new Rule() {{
			add("codigo", "6354700");
			add("nome", "Iphone 11 pro Max");
			add("marca", "Apple");
			add("cor", "rose");
			add("preco",  3999.90);
			add("quantidade", 7);
		}});
	}

}
