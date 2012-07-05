package ode.gerenciaConhecimento.ciu;

import java.util.Collection;

import ode._controleRecursoHumano.cdp.RecursoHumano;
import ode.gerenciaConhecimento.cdp.Tema;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Button;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listhead;
import org.zkoss.zul.Listheader;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Window;

public class JanMeusTemasDeInteresse extends Window {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Listbox listboxTemasRelacionados = new Listbox();
	
	CtrlGerenciaConhecimento ctrlGerenciaConhecimento;

	public JanMeusTemasDeInteresse(CtrlGerenciaConhecimento ctrlGerenciaConhecimento) {
		super();
		
		this.setTitle("Meus Temas de Intersse");
		this.setBorder("normal");
		
		Listhead colunasTemasRelacionados = new Listhead();
		Listheader colunaTituloTema = new Listheader("Temas de Interesse");

		colunaTituloTema.setParent(colunasTemasRelacionados);
		colunasTemasRelacionados.setParent(listboxTemasRelacionados);
		
		listboxTemasRelacionados.setMultiple(true);
		listboxTemasRelacionados.setCheckmark(true);

		// Preenche temas no listbox
		Collection<Tema> temas = ctrlGerenciaConhecimento.aplCadastrarTema.recuperarTodos();
		for (Tema tema : temas){
			Listitem listitem = new Listitem(tema.getNome());
			listitem.setValue(tema);
			listitem.setParent(listboxTemasRelacionados);
		}
		
		listboxTemasRelacionados.setParent(this);
		listboxTemasRelacionados.setHeight("300px");
		
		Button botaoSalvar = new Button("Salvar");
		Button botaoCancelar = new Button("Cancelar");
		
		botaoSalvar.addEventListener("onClick", new EventListener() {
			
			@Override
			public void onEvent(Event arg0) throws Exception {
				// TODO Auto-generated method stub
			}
		});

		Toolbar toolbarInferior = new Toolbar(); 
		toolbarInferior.setStyle("border:0px;background:white;");
		toolbarInferior.setAlign("end");

		toolbarInferior.appendChild(botaoSalvar);
		toolbarInferior.appendChild(botaoCancelar);

		toolbarInferior.setParent(this);
	}

}