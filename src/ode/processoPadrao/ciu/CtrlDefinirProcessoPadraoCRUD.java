package ode.processoPadrao.ciu;

import ode._infraestruturaCRUD.cgt.AplCRUD;
import ode._infraestruturaCRUD.ciu.CtrlCRUD;
import ode._infraestruturaCRUD.ciu.FormularioDadosCRUD;
import ode._infraestruturaCRUD.ciu.PainelCRUD;
import ode.processoPadrao.cdp.CompPP;
import ode.processoPadrao.cgt.AplDefinirProcessoPadrao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CtrlDefinirProcessoPadraoCRUD extends CtrlCRUD<CompPP> {

	public static String TIPO_COMPP_PROCESSO_COMPLEXO = "CompPP Processo Complexo";
	public static String TIPO_COMPP_PROCESSO_SIMPLES = "CompPP Processo Simples";
	public static String TIPO_COMPP_MACROATIVIDADE = "CompPP Macroatividade";

	/** Janela Principal do ambiente de defini��o de processo padr�o. */
	@Override
	public void iniciar() {
		super.iniciar();
	}

	@Autowired
	AplDefinirProcessoPadrao aplDefinirProcessoPadrao;

	public AplDefinirProcessoPadrao getAplDefinirProcessoPadrao() {
		return aplDefinirProcessoPadrao;
	}

	public void setAplDefinirProcessoPadrao(
			AplDefinirProcessoPadrao aplDefinirProcessoPadrao) {
		this.aplDefinirProcessoPadrao = aplDefinirProcessoPadrao;
	}

	// lembrar que o controlador eh melhor injetado pelo spring
	@Override
	public AplCRUD<CompPP> definirAplCRUD() {
		return aplDefinirProcessoPadrao;
	}

	@Override
	public PainelCRUD<CompPP> definirPainelCRUD() {
		return new PainelCrudDefinirProcessoPadrao();

	}

	@Override
	public CompPP factoryObjetoDados() {
		return new CompPP();
	}

	@Override
	public FormularioDadosCRUD<CompPP> definirFormularioCadastro() {
		return new FormDadosDefinirProcessoPadrao();
	}

	@Override
	public String definirTituloJanelaDados() {
		return "Componente Processo Padr�o";
	}

	@Override
	public String definirTituloJanelaPrincipal() {
		return "Componentes Processo Padr�o";
	}

}