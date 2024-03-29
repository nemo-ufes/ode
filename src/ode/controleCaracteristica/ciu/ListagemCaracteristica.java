package ode.controleCaracteristica.ciu;

import java.util.ArrayList;
import java.util.List;

import ode._infraestruturaCRUD.ciu.ListagemSimples;
import ode._infraestruturaCRUD.ciu.NucleoListHeader;
import ode.controleCaracteristica.cdp.Caracteristica;

public class ListagemCaracteristica extends ListagemSimples<Caracteristica> {

	private static final long serialVersionUID = 8580487562426512786L; 
	
	@Override
	protected String[] recuperarDadosObjeto(Caracteristica objeto) {
		return new String[]{objeto.getNome(), objeto.getDescricao()};
	}
	
	
	@Override
	public List<NucleoListHeader> definirColunasTabela() {
		
		List<NucleoListHeader> colunas = new ArrayList<NucleoListHeader>();
		colunas.add(new NucleoListHeader("Nome","nome","200px"));
		colunas.add(new NucleoListHeader("Descri��o","descricao","380px"));
		return colunas;
	}
}