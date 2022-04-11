package br.com.contmatic.model.template;

import br.com.contmatic.model.endereco.Cidade;
import br.com.contmatic.model.endereco.Endereco;
import br.com.contmatic.model.endereco.TipoEndereco;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class EnderecoTemplateFixtureFactory implements TemplateLoader{

	@Override
	public void load() {
		Fixture.of(Endereco.class).addTemplate("valido", new Rule() {{
			add("cep", "12243670");
			add("logradouro", "R Major Vaz");
			add("numero", 217);
			add("bairro", "Vila Adyana, Sao Jose Dos Campos");
			add("cidade", one(Cidade.class, "valido"));
			add("complemento", "prédio");
			add("tipo", TipoEndereco.COMERCIAL);
		}});
		Fixture.of(Endereco.class).addTemplate("valido-funcionario", new Rule() {{
			add("cep", "04852510");
			add("logradouro", "Rua Assurbaniapl");
			add("numero", 194);
			add("bairro", "JD lucelia");
			add("cidade", one(Cidade.class, "valido"));
			add("complemento", "casa 1");
			add("tipo", TipoEndereco.RESIDENCIAL);
		}});
	}

}
