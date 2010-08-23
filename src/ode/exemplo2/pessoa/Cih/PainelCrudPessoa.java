package ode.exemplo2.pessoa.Cih;

import nucleo.comuns.crud.visao.PainelCRUD;
import nucleo.comuns.visao.paginacao.ListagemPaginada;
import ode.exemplo2.pessoa.Cdp.PessoaExemplo;

public class PainelCrudPessoa extends PainelCRUD<PessoaExemplo> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8580487562426512786L;

	@Override
	public ListagemPaginada<PessoaExemplo> definirListagem() {
		ListagemPessoaExemplo listagem = new ListagemPessoaExemplo();
		return listagem;
	}

	

}