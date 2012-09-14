package ode.gerenciaConhecimento.ciu;

import java.util.Collection;

import ode.gerenciaConhecimento.cdp.ItemConhecimento;
import ode.gerenciaConhecimento.cdp.Tema;

import org.hibernate.mapping.Column;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Button;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listhead;
import org.zkoss.zul.Listheader;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Vbox;
import org.zkoss.zul.Window;


public class JanPaginasAmarelasBuscarPessoas extends Window {

	CtrlGerenciaConhecimento ctrlGerenciaConhecimento;
	
	Tabpanel tabpanelBucar = new Tabpanel();
	Listbox listboxTemasRelacionados = new Listbox();
	Listbox listboxItensCriados = new Listbox();
	Listbox listboxItensAvaliados = new Listbox();
	Listbox listboxItensValorados = new Listbox();
	Textbox textboxNome = new Textbox();

	
	public JanPaginasAmarelasBuscarPessoas(CtrlGerenciaConhecimento ctrl) {
		// TODO Auto-generated constructor stub
		
		ctrlGerenciaConhecimento = ctrl;
		
		criarJanPaginasAmarelasBuscarPessoas();
	}
	
	public void criarTabboxBuscar(){
		
		Grid grid = new Grid();
		//grid.setSizedByContent(true);
		Rows rows = new Rows();
		
		rows.setParent(grid);
		grid.setParent(tabpanelBucar);
		
		Row rowNome = new Row();
		Label labelNome = new Label("Nome");
		
		textboxNome.setWidth("340px");
		
		labelNome.setParent(rowNome);
		textboxNome.setParent(rowNome);
		rowNome.setParent(rows);
		

		//////////////////////////////////////////
		// Temas relacionados
		//////////////////////////////////////////
		Row linhaTemasRelacionados = new Row();

		Label labelTemasRelacionados = new Label("Temas Relacionados: ");

		listboxTemasRelacionados.setMultiple(true);
		listboxTemasRelacionados.setCheckmark(true);
		listboxTemasRelacionados.setHeight("140px");

		Listhead colunasTemasRelacionados = new Listhead();
		Listheader colunaTitulo1 = new Listheader("T�tulo");

		colunaTitulo1.setParent(colunasTemasRelacionados);
		colunasTemasRelacionados.setParent(listboxTemasRelacionados);
	
		// Preenche temas no listbox
		Collection<Tema> temas = ctrlGerenciaConhecimento.aplCadastrarTema.recuperarTodos();
		for(Tema tema : temas){
			Listitem listitem = new Listitem(tema.getNome());
			listitem.setValue(tema);
			listitem.setParent(listboxTemasRelacionados);
		}

		labelTemasRelacionados.setParent(linhaTemasRelacionados);
		listboxTemasRelacionados.setParent(linhaTemasRelacionados);

		linhaTemasRelacionados.setParent(rows);
		
		//////////////////////////////////////////
		// Itens criados
		//////////////////////////////////////////
		Row linhaItensCriados = new Row();

		Label labelItensCriados = new Label("Itens Criados");

		listboxItensCriados.setMultiple(true);
		listboxItensCriados.setCheckmark(true);

		Listhead colunasItensCriados = new Listhead();
		Listheader colunaTitulo4 = new Listheader("T�tulo");

		listboxItensCriados.setMultiple(true);
		listboxItensCriados.setCheckmark(true);
		
		colunasItensCriados.setParent(listboxItensCriados);
		colunaTitulo4.setParent(colunasItensCriados);

		// Preenche itens no listbox
		Collection<ItemConhecimento> itensCriados = ctrlGerenciaConhecimento.aplCadastrarItemConhecimento.recuperarTodos();
		for (ItemConhecimento item : itensCriados){
			Listitem listitem = new Listitem(item.getTitulo());
			listitem.setValue(item);
			listitem.setParent(listboxItensCriados);
		}
		
		labelItensCriados.setParent(linhaItensCriados);
		listboxItensCriados.setParent(linhaItensCriados);
		
		linhaItensCriados.setParent(rows);
		
		//////////////////////////////////////////
		// Itens avaliados
		//////////////////////////////////////////
		Row linhaItensAvaliados = new Row();

		Label labelItensAvaliados = new Label("Itens Avaliados");

		listboxItensAvaliados.setMultiple(true);
		listboxItensAvaliados.setCheckmark(true);

		Listhead colunasItensAvaliados = new Listhead();
		Listheader colunaTitulo3 = new Listheader("T�tulo");

		listboxItensAvaliados.setMultiple(true);
		listboxItensAvaliados.setCheckmark(true);
		
		colunasItensAvaliados.setParent(listboxItensAvaliados);
		colunaTitulo3.setParent(colunasItensAvaliados);

		// Preenche itens no listbox
		Collection<ItemConhecimento> itensAvaliados = ctrlGerenciaConhecimento.aplCadastrarItemConhecimento.recuperarTodos();
		for (ItemConhecimento item : itensAvaliados){
			Listitem listitem = new Listitem(item.getTitulo());
			listitem.setValue(item);
			listitem.setParent(listboxItensAvaliados);
		}
		
		labelItensAvaliados.setParent(linhaItensAvaliados);
		listboxItensAvaliados.setParent(linhaItensAvaliados);
		
		linhaItensAvaliados.setParent(rows);
		
		//////////////////////////////////////////
		// Itens valorados
		//////////////////////////////////////////
		Row linhaItensValorados = new Row();

		Label labelItensValorados = new Label("Itens Avaliados");

		listboxItensValorados.setMultiple(true);
		listboxItensValorados.setCheckmark(true);

		Listhead colunasItensValorados = new Listhead();
		Listheader colunaTitulo2 = new Listheader("T�tulo");

		listboxItensValorados.setMultiple(true);
		listboxItensValorados.setCheckmark(true);
		
		colunasItensValorados.setParent(listboxItensValorados);
		colunaTitulo2.setParent(colunasItensValorados);

		// Preenche itens no listbox
		Collection<ItemConhecimento> itensValorados = ctrlGerenciaConhecimento.aplCadastrarItemConhecimento.recuperarTodos();
		for (ItemConhecimento item : itensValorados){
			Listitem listitem = new Listitem(item.getTitulo());
			listitem.setValue(item);
			listitem.setParent(listboxItensValorados);
		}
		
		labelItensValorados.setParent(linhaItensValorados);
		listboxItensValorados.setParent(linhaItensValorados);
		
		linhaItensValorados.setParent(rows);
	}
	
	public void criarJanPaginasAmarelasBuscarPessoas(){
		
		this.setTitle("P�ginas Amarelas - Buscar");
		this.setBorder("normal");
	//	this.setHeight("320px");
		
		Vbox vboxBuscar = new Vbox();
		vboxBuscar.setWidth("100%");
		
		Tabbox tabboxBuscar = new Tabbox();
		tabboxBuscar.setHeight("400px");
		Tabs tabsBuscar = new Tabs();
		Tab tabBuscar = new Tab("Buscar Pessoas");
		
		tabBuscar.setParent(tabsBuscar);
		tabsBuscar.setParent(tabboxBuscar);
		
		Tabpanels tabpanelsBuscar = new Tabpanels();
		
		tabpanelBucar.setStyle("overflow:auto;");
		tabpanelBucar.setParent(tabpanelsBuscar);
		tabpanelsBuscar.setParent(tabboxBuscar);
		
		tabboxBuscar.setParent(vboxBuscar);
		
		criarTabboxBuscar();
		
		///////////////////
		// Botoes
		///////////////////
		Button botaoBuscar = new Button("Buscar");
		Button botaoCancelar = new Button("Cancelar");
		Toolbar toolbarInferior = new Toolbar();

		botaoBuscar.addEventListener("onClick", new EventListener() {

			@Override
			public void onEvent(Event arg0) throws Exception {
				// TODO Auto-generated method stub
				ctrlGerenciaConhecimento.exibirJanelaPaginasAmarelasResultadoPesquisa();
			}
		});
		
		botaoCancelar.addEventListener("onClick", new EventListener() {
			
			@Override
			public void onEvent(Event arg0) throws Exception {
				// TODO Auto-generated method stub
				
				
			}
		});


		toolbarInferior.setStyle("border:0px;background:white;");
		toolbarInferior.setAlign("end");

		toolbarInferior.appendChild(botaoBuscar);
		toolbarInferior.appendChild(botaoCancelar);

		toolbarInferior.setParent(vboxBuscar);
		
		vboxBuscar.setParent(this);
		
		
	}
	
}