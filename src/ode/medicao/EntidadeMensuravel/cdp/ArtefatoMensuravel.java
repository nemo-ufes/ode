package ode.medicao.EntidadeMensuravel.cdp;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import ode.conhecimento.processo.cdp.KArtefato;

@Entity
public class ArtefatoMensuravel extends EntidadeMensuravel<KArtefato>{

	private final TipoEntidadeMensuravel tipo = TipoEntidadeMensuravel.ARTEFATO;
	
	
	@Override
	public TipoEntidadeMensuravel recuperaTipo() {
		return tipo;
	}


	@Override
	public KArtefato getEntidade() {
		return entidade;
	}


	@Override
	public void setEntidade(KArtefato entidade) {
		this.entidade = entidade;
	}

}
