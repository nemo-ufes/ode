package ode._controleProcesso.cdp;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import ode._infraestruturaBase.cdp.ObjetoPersistente;
import ode.controleProjeto.cdp.Projeto;

@Entity
public class ProcessoProjetoGeral extends ObjetoPersistente {

	private static final long serialVersionUID = 1L;
	
	private Projeto projeto;

	@OneToOne
	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

}
