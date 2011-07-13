package ode.controleProcesso.cih;

import nucleo.comuns.visao.listagem.ListagemSimples;
import ode.controleProcesso.cdp.RecursoHumano;
import ode.nucleo.crud.cih.PainelCRUD;

public class PainelCRUDRecursoHumano extends PainelCRUD<RecursoHumano> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public ListagemSimples<RecursoHumano> definirListagem() {
		ListagemRecursoHumano listagem = new ListagemRecursoHumano();
		return listagem;
	}

}
