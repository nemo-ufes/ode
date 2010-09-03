package ode.conhecimento.processo.Cci;

import nucleo.comuns.aplicacao.NucleoAplCadastroBase;
import nucleo.comuns.crud.controlador.CtrlCRUD;
import nucleo.comuns.crud.visao.FormularioDadosCRUD;
import nucleo.comuns.crud.visao.PainelCRUD;
import nucleo.comuns.visao.principal.JanelaSimples;
import ode.conhecimento.processo.Cdp.KDominioAplicacao;
import ode.conhecimento.processo.Cgt.AplCadastrarKDominioAplicacao;
import ode.conhecimento.processo.Cih.FormDadosKDominioAplicacao;
import ode.conhecimento.processo.Cih.PainelCrudKDominioAplicacao;
import ode.conhecimento.processo.Cih.PainelSelecaoKDominioAplicacao;

import org.zkoss.zkplus.spring.SpringUtil;

public class CtrlKDominioAplicacaoCRUD extends CtrlCRUD<KDominioAplicacao> {
@Override
	public void iniciar() {
		super.iniciar();
		/*
		JanelaSimples jan = factoryJanelaSimples();				
		String titulo ="Teste Painel Selecao";
		PainelSelecaokDominioAplicacao p = new PainelSelecaokDominioAplicacao();		
		p.setParent(jan);
		jan.setTitle(titulo);
		jan.setWidth(getLarguraJandados());
		jan.setHeight(getAlturaJanDados());
		jan.mostrar();
		*/
		
	}

	//lembrar que o controlador eh melhor injetado pelo spring
	@Override
	public NucleoAplCadastroBase definirNucleoAplCadastroBase() {
		return (AplCadastrarKDominioAplicacao) SpringUtil
				.getBean("aplCadastrarKDominioAplicacao");
	}

	@Override
	public PainelCRUD definirPainelCRUD() {
		return new PainelCrudKDominioAplicacao();
		
	}


	@Override
	public KDominioAplicacao factoryObjetoDados() {
		return new KDominioAplicacao();
	}

	@Override
	public FormularioDadosCRUD definirFormularioCadastro() {
		return new FormDadosKDominioAplicacao();
	}

	@Override
	public String definirTituloJanelaDados() {
		return "kDominioAplicacao";
	}
	
	@Override
	public String definirTituloJanelaPrincipal() {
		return "Cadastro de kDominioAplicacao com Controlador";
	}
	



}