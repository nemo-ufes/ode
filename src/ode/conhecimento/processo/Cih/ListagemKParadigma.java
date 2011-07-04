package ode.conhecimento.processo.Cih;

import java.util.ArrayList;
import java.util.List;

import nucleo.comuns.visao.listagem.ListagemSimples;
import nucleo.comuns.visao.paginacao.NucleoListHeader;
import ode.conhecimento.processo.Cdp.KParadigma;

public class ListagemKParadigma extends ListagemSimples<KParadigma> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -14597618633910372L;

	@Override
	public List<NucleoListHeader> definirColunasTabela() {
		List<NucleoListHeader> colunas = new ArrayList<NucleoListHeader>();
		colunas.add(new NucleoListHeader("Nome", "nome", "100px"));
		colunas.add(new NucleoListHeader("Descricao", "descricao", "300px"));
		return colunas;
	}

	@Override
	protected String[] recuperarDadosObjeto(KParadigma objeto) {
		return new String[] { objeto.getNome(), objeto.getDescricao() };
	}

}
