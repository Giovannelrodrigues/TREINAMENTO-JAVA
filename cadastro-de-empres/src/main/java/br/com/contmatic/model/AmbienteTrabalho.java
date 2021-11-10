package br.com.contmatic.model;

import static br.com.contmatic.util.validacoes.Validador.validarAtributoGenerico;
import static br.com.contmatic.util.validacoes.Validador.validarAtributoGenericoAceitandoNulo;
import static br.com.contmatic.util.validacoes.Validador.validarLista;
import static br.com.contmatic.util.validacoes.Validador.validarObjetoNulo;

import java.util.List;
import java.util.Objects;

import br.com.contmatic.enums.TipoEstabelecimento;

public class AmbienteTrabalho {
	
	private String nome;
	
	private String descricao;
	
	private TipoEstabelecimento tipo;
	
	private List<Setor> setores;
	
	public AmbienteTrabalho(String nome, TipoEstabelecimento tipo, String descricao){
		this.setNome(nome);
		this.setTipoEstabelecimento(tipo);
		this.setDescricao(descricao);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		validarAtributoGenerico(nome);
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		validarAtributoGenericoAceitandoNulo(descricao);
		this.descricao = descricao;
	}

	public TipoEstabelecimento getTipoEstabelecimento() {
		return this.tipo;
	}
	
	public void setTipoEstabelecimento(TipoEstabelecimento tipo) {
		validarObjetoNulo(tipo);
		this.tipo = tipo;
	}
	
	public List<Setor> getSetores() {
		return this.setores;
	}
	
	public void setSetores(List<Setor> setores) {
		validarLista(setores);
		this.setores = setores;
	}

	@Override
	public String toString() {
		return "AmbienteTrabalho [nome=" + nome + ", descricao=" + descricao + ", tipos=" + tipo + ", setores="
				+ setores + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AmbienteTrabalho other = (AmbienteTrabalho) obj;
		return Objects.equals(nome, other.nome);
	}
}
