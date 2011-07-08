package ode.conhecimento.processo.Cci;

import nucleo.comuns.aplicacao.NucleoAplCadastroBase;
import nucleo.comuns.crud.controlador.CtrlCRUD;
import nucleo.comuns.crud.visao.FormularioDadosCRUD;
import nucleo.comuns.crud.visao.PainelCRUD;
import ode.conhecimento.processo.Cdp.KProcesso;
import ode.conhecimento.processo.Cgt.AplCadastrarKProcesso;
import ode.conhecimento.processo.Cih.FormDadosKProcesso;
import ode.conhecimento.processo.Cih.PainelCrudKProcesso;

import org.zkoss.zkplus.spring.SpringUtil;

public class CtrlKProcessoCRUD extends CtrlCRUD<KProcesso> {
	@Override
	public void iniciar() {
		super.iniciar();
		alturaJanDados = "550px";
		larguraJandados = "600px";
		
	}

	//lembrar que o controlador eh melhor injetado pelo spring
	@Override
	public NucleoAplCadastroBase definirNucleoAplCadastroBase() {
		return (AplCadastrarKProcesso) SpringUtil
				.getBean("aplCadastrarKProcesso");
	}

	@Override
	public PainelCRUD definirPainelCRUD() {
		return new PainelCrudKProcesso();
		
	}


	@Override
	public KProcesso factoryObjetoDados() {
		return new KProcesso();
	}

	@Override
	public FormularioDadosCRUD definirFormularioCadastro() {
		return new FormDadosKProcesso();
	}

	@Override
	public String definirTituloJanelaDados() {
		return "Processo";
	}
	
	@Override
	public String definirTituloJanelaPrincipal() {
		return "Cadastro de Processo";
	}
}