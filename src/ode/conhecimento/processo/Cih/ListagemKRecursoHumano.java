package ode.conhecimento.processo.Cih;

import java.util.ArrayList;
import java.util.List;

import nucleo.comuns.visao.paginacao.ListagemPaginada;
import nucleo.comuns.visao.paginacao.NucleoListHeader;
import ode.conhecimento.processo.Cdp.KAtividade;
import ode.conhecimento.processo.Cdp.KDominioAplicacao;
import ode.conhecimento.processo.Cdp.KRecursoHumano;


public class ListagemKRecursoHumano extends ListagemPaginada<KRecursoHumano> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 767335923010066407L;


	@Override
	protected String[] recuperarDadosObjeto(KRecursoHumano objeto) {
		return new String[]{objeto.getNome(),objeto.getDescricao()};
	}
	
	
	@Override
	public List<NucleoListHeader> definirColunasTabela() {
		
		List<NucleoListHeader> colunas = new ArrayList<NucleoListHeader>();
		colunas.add(new NucleoListHeader("Nome","nome","200px"));
		colunas.add(new NucleoListHeader("Descricao","descricao","400px"));
		return colunas;
	}


}
