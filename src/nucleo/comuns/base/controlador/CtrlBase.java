package nucleo.comuns.base.controlador;

import nucleo.comuns.util.NucleoMensagens;
import nucleo.comuns.visao.principal.JanelaSimples;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

public abstract class CtrlBase extends Window {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	///caminho de todas as janelas simples utilizadas no sistema	
	public static final String CAMINHO_JANELA_SIMPLES = "/visao/principal/janelaSimples.zul";

	public JanelaSimples factoryJanelaSimples() {

		return (JanelaSimples) Executions.createComponents(CAMINHO_JANELA_SIMPLES, null, null);
	}

	public void confirmaSimNao(String mensagemConfirmacao,EventListener eventListenerConfirma)
	throws InterruptedException {
		Messagebox.show(mensagemConfirmacao, NucleoMensagens
				.getMensagem(NucleoMensagens.TERMO_CONFIRMACAO), Messagebox.YES
				| Messagebox.NO, Messagebox.QUESTION,eventListenerConfirma) ;

	}


	public void mostrarJanelaInformacao(String mensagem)
	throws InterruptedException {

		Messagebox.show(mensagem, NucleoMensagens
				.getMensagem(NucleoMensagens.TERMO_INFORMACAO), Messagebox.OK,
				Messagebox.INFORMATION);

	}

	public void mostrarJanelaAviso(String mensagem) throws InterruptedException {

		Messagebox.show(mensagem, NucleoMensagens
				.getMensagem(NucleoMensagens.TERMO_AVISO), 1,
				Messagebox.INFORMATION);

	}

	public abstract void configurarComponentes();

}
