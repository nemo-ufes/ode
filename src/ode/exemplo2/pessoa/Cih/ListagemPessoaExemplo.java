package ode.exemplo2.pessoa.Cih;

import java.util.ArrayList;
import java.util.List;

import nucleo.comuns.visao.listagem.ListagemSimples;
import nucleo.comuns.visao.paginacao.NucleoListHeader;
import ode.exemplo2.pessoa.Cdp.PessoaExemplo;

public class ListagemPessoaExemplo extends ListagemSimples<PessoaExemplo> {

	@Override
	protected String[] recuperarDadosObjeto(PessoaExemplo objeto) {
		return new String[]{objeto.getNome(),objeto.getIdade()+"", objeto.getEmail()};
	}
	
	
	@Override
	public List<NucleoListHeader> definirColunasTabela() {
		
		List<NucleoListHeader> colunas = new ArrayList<NucleoListHeader>();
		colunas.add(new NucleoListHeader("Nome","nome","200px"));
		colunas.add(new NucleoListHeader("Idade","idade","60px"));
		colunas.add(new NucleoListHeader("Email","email","210px"));
		return colunas;
	}


}
