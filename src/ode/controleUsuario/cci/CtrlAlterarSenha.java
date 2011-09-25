package ode.controleUsuario.cci;

import ode.controleUsuario.cgt.AplCadastrarUsuario;
import ode.controleUsuario.cih.PainelAlterarSenha;
import ode.nucleo.cci.CtrlBase;
import ode.nucleo.crud.cih.JanelaSimples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CtrlAlterarSenha extends CtrlBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private AplCadastrarUsuario aplCadastrarUsuario;
	
	private JanelaSimples jan;
	
	private PainelAlterarSenha PainelAlterarSenha;

	@Override
	public void iniciar() {

		jan = factoryJanelaSimples();
		jan.setTitle("Alterar Senha");
		
		PainelAlterarSenha = new PainelAlterarSenha(this);
		PainelAlterarSenha.setParent(jan);
		
		jan.doOverlapped();
		
	}

	public void finalizar() {
		jan.detach();
		PainelAlterarSenha.detach();
		this.detach();
	}

	public AplCadastrarUsuario getAplCadastrarUsuario() {
		return aplCadastrarUsuario;
	}

	public void setAplCadastrarUsuario(AplCadastrarUsuario aplCadastrarUsuario) {
		this.aplCadastrarUsuario = aplCadastrarUsuario;
	}
	
}