package ode.medicao.planejamentoMedicao.cci;

import java.util.Collection;

import ode._controleRecursoHumano.cgt.AplCadastrarRecursoHumano;
import ode._infraestruturaBase.ciu.CtrlBase;
import ode._infraestruturaCRUD.ciu.JanelaSimples;
import ode.conhecimento.processo.cgt.AplCadastrarKRecursoHumano;
import ode.conhecimentoMedicao.cdp.KMedida;
import ode.conhecimentoMedicao.cgd.KMedidaDAO;
import ode.controleProjeto.cdp.Projeto;
import ode.medicao.planejamentoMedicao.cdp.ObjetivoEstrategico;
import ode.medicao.planejamentoMedicao.cdp.PlanoMedicao;
import ode.medicao.planejamentoMedicao.cdp.PlanoMedicaoOrganizacao;
import ode.medicao.planejamentoMedicao.cgt.AplCadastrarObjetivoEstrategico;
import ode.medicao.planejamentoMedicao.cgt.AplElaborarPlanoMedicaoOrganizacao;
import ode.medicao.planejamentoMedicao.cgt.AplElaborarPlanoMedicaoProjeto;
import ode.medicao.planejamentoMedicao.cih.PainelPrincipalPlanoMedicao;
import ode.medicao.planejamentoMedicao.cih.PainelPrincipalPlanoMedicaoOganizacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public abstract class CtrlPlanoMedicao extends CtrlBase{
	
	protected String title;
	
	@Autowired
	AplElaborarPlanoMedicaoOrganizacao aplPlanoMedicaoOrganizacao;
	
	@Autowired
	AplElaborarPlanoMedicaoProjeto aplPlanoMedicaoProjeto;
	
	@Autowired
	AplCadastrarRecursoHumano aplRecursoHumano;
	
	@Autowired
	AplCadastrarObjetivoEstrategico aplKObjetivoEstrategico;
	
	@Autowired
	KMedidaDAO medidaDAO;
	
	
	
	protected JanelaSimples janelaPrincipal;
	protected PlanoMedicao objetoAtual;
	protected PainelPrincipalPlanoMedicao painel;
	
	public AplCadastrarRecursoHumano getAplRecursoHumano(){
		return aplRecursoHumano;
	}
	
	@Override
	public void iniciar() {
		configurarPainelPrincipal();
		abrePainelPrincipal();
	}
	
	protected void configurarPainelPrincipal(){
		painel = getPainelPrincipal();
	}

	protected void abrePainelPrincipal() {
		janelaPrincipal = factoryJanelaSimples();
		painel.setParent(janelaPrincipal);
		janelaPrincipal.setTitle("Plano de Medi��o");
		//definirTituloJanelaPrincipal();
		painel.montar();
		janelaPrincipal.mostrar();
	}

	protected void definirTituloJanelaPrincipal(){
		definirObjetoAtual();
		if(objetoAtual.isPersistente()){
			janelaPrincipal.setTitle(objetoAtual.toString());
		}else{
			janelaPrincipal.setTitle(this.title);
		}
	}
	
	protected abstract PainelPrincipalPlanoMedicao getPainelPrincipal() ;
	
	protected void definirObjetoAtual(){
		objetoAtual = novoPlanoMedicao(); 
	}

	public Collection<ObjetivoEstrategico> getObjetivosEstrategicos() {
		return aplKObjetivoEstrategico.recuperarTodos();
	}
	
	public abstract PlanoMedicao novoPlanoMedicao();
	
	public Collection<KMedida> recuperaMedidas(){
		return medidaDAO.recuperarTodos();
	}
}
