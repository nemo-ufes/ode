package ode.conhecimento.processo.Cih;

import nucleo.comuns.crud.visao.PainelCRUD;
import nucleo.comuns.visao.paginacao.ListagemPaginada;
import ode.conhecimento.processo.Cdp.TipoKArtefato;

public class PainelCrudTipoKArtefato extends PainelCRUD<TipoKArtefato> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6782246290526691057L;

	@Override
	public ListagemPaginada<TipoKArtefato> definirListagem() {
		ListagemTipoKArtefato listagem = new ListagemTipoKArtefato();
		return listagem;
	}

}