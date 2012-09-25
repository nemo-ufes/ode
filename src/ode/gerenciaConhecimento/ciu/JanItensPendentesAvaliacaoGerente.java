package ode.gerenciaConhecimento.ciu;

import java.text.SimpleDateFormat;
import java.util.Collection;

import ode._controleRecursoHumano.cdp.RecursoHumano;
import ode.gerenciaConhecimento.cdp.ConhecimentoRelativoDiscussao;
import ode.gerenciaConhecimento.cdp.ItemConhecimento;
import ode.gerenciaConhecimento.cdp.LicaoAprendida;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Button;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listhead;
import org.zkoss.zul.Listheader;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Vbox;
import org.zkoss.zul.Window;

public class JanItensPendentesAvaliacaoGerente extends Window {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	CtrlGerenciaConhecimento ctrlGerenciaConhecimento;
	
	Label labelQtdeItens = new Label();
	Label labelQtdeItensValor = new Label("0");
	Listbox listboxQtdeItens = new Listbox();
	Listitem listitem;
	Listcell listcellRadio;
	Listcell listcellTitulo;
	Listcell listcellInformacoes;
	Label labelAutor;
	Label labelDataCriacao;
	Label labelTipo;
	Listcell listcellAvaliadoresSelecionados;
	Label labelQtdeAvaliacoesRealizadas = new Label("0");
	
	public JanItensPendentesAvaliacaoGerente(CtrlGerenciaConhecimento ctrl) {
		// TODO Auto-generated constructor stub
		
		ctrlGerenciaConhecimento = ctrl;
		
		criarJanItensPendentesAvaliacaoGerente();
	}
	
	public void criarJanItensPendentesAvaliacaoGerente(){
		
		this.setTitle("Itens Pendentes de Avalia��o");
		this.setBorder("normal");
		
		Vbox vbox = new Vbox();
		vbox.setWidth("100%");
			
		labelQtdeItens.setParent(vbox);
		
		//listbox	
		Listhead colunas = new Listhead();;
		Listheader colunaRadioButton = new Listheader(" ");
		colunaRadioButton.setWidth("30px");
		Listheader colunaTitulo = new Listheader("T�tulo");
		colunaTitulo.setWidth("120px");
		Listheader colunaInformacoes = new Listheader("Informa��es");
		colunaInformacoes.setWidth("250px");
		Listheader colunaAvaliadoresSelecionados = new Listheader("Avaliadores Selecionados");
		colunaAvaliadoresSelecionados.setWidth("100%");
		
		listboxQtdeItens.setMultiple(false);
		listboxQtdeItens.setCheckmark(true);
		listboxQtdeItens.setSizedByContent(true);
		listboxQtdeItens.setHeight("150px");
		
		colunaRadioButton.setParent(colunas);
		colunaTitulo.setParent(colunas);
		colunaInformacoes.setParent(colunas);
		colunaAvaliadoresSelecionados.setParent(colunas);
		colunas.setParent(listboxQtdeItens);
		
		preencherListboxItensPendentesAvaliacao();
		listboxQtdeItens.setParent(vbox);
		
		//Bot�es
		Button botaoVisualizar = new Button("Visualizar");
		Button botaoAvaliar = new Button("Avaliar");
		Button botaoSelecionarEspecialistas = new Button("Selecionar Especialistas");
		Button botaoAprovar = new Button("Aprovar");
		Button botaoRejeitar = new Button("Rejeitar");
		Toolbar toolbarInferior = new Toolbar();
		
		botaoVisualizar.addEventListener("onClick", new EventListener() {
			
			@Override
			public void onEvent(Event arg0) throws Exception {
				// TODO Auto-generated method stub
				
				Object object = new Object();
						
				if(listboxQtdeItens.getSelectedItem() == null){
					Messagebox messageboxSalvar = new Messagebox();
					messageboxSalvar.show("Por favor, selecione um Item de Conhecimento", "Informa��o", Messagebox.OK, messageboxSalvar.INFORMATION);
				}else{
					object = listboxQtdeItens.getSelectedItem().getValue();
					ctrlGerenciaConhecimento.exibirJanelaVisualizarItemConhecimento((ItemConhecimento)object);
				}
			}
		});
		
		botaoSelecionarEspecialistas.addEventListener("onClick", new EventListener() {
			
			@Override
			public void onEvent(Event arg0) throws Exception {
				// TODO Auto-generated method stub
				if (listboxQtdeItens.getSelectedItem() != null){
					
					// Coloca o item de conhecimento na sessao para selecionar seus avaliadores
					ctrlGerenciaConhecimento.colocarItemConhecimentoSessao((ItemConhecimento)listboxQtdeItens.getSelectedItem().getValue());
					
					ctrlGerenciaConhecimento.exibirJanelaPaginasAmarelasBuscarPessoas();
					
				}else{
					Messagebox messageboxSalvar = new Messagebox();
					messageboxSalvar.show("Por favor, selecione um Item de Conhecimento", "Informa��o", Messagebox.OK, messageboxSalvar.INFORMATION);
				}
				
			}
		});
		
		botaoAvaliar.addEventListener("onClick", new EventListener() {
			
			@Override
			public void onEvent(Event arg0) throws Exception {
				// TODO Auto-generated method stub
				
				if (listboxQtdeItens.getSelectedItem() != null){
					ctrlGerenciaConhecimento.exibirJanelaAvaliarItemConhecimento((ItemConhecimento)listboxQtdeItens.getSelectedItem().getValue());
				}else{
					Messagebox messageboxSalvar = new Messagebox();
					messageboxSalvar.show("Por favor, selecione um Item de Conhecimento", "Informa��o", Messagebox.OK, messageboxSalvar.INFORMATION);
				}
			}
		});
		
		toolbarInferior.setStyle("border:0px;background:white;");
		toolbarInferior.setAlign("end");
			
		toolbarInferior.appendChild(botaoVisualizar);
		toolbarInferior.appendChild(botaoAvaliar);
		toolbarInferior.appendChild(botaoSelecionarEspecialistas);
		toolbarInferior.appendChild(botaoAprovar);
		toolbarInferior.appendChild(botaoRejeitar);
		vbox.appendChild(toolbarInferior);

		vbox.setParent(this);
		
	}
	
	public void preencherListboxItensPendentesAvaliacao(){
		
		// fiz recuperar todos somente para teste
		Collection<ItemConhecimento> itens = ctrlGerenciaConhecimento.recuperarItensConhecimentoPendentesPorUsuarioAtual();
		for (ItemConhecimento item : itens){
			listitem = new Listitem();
			listitem.setValue(item);
			preencherLinhaListbox(item);
			listitem.setParent(listboxQtdeItens);
		}
		
		labelQtdeItens.setValue("Quantidade de Itens: " + itens.size());
		
	}
	
	public void preencherLinhaListbox(ItemConhecimento item){
		
		//coluna radio
		listcellRadio = new Listcell("");
		listcellRadio.setParent(listitem);
		
		//coluna titulo
		listcellTitulo = new Listcell(item.getTitulo());
		listcellTitulo.setParent(listitem);
		
		//coluna informa��es
		Vbox vboxInformacoes = new Vbox();
		
		listcellInformacoes = new Listcell();
		
		labelAutor = new Label(item.getAutor().getNome());
		labelAutor.setParent(vboxInformacoes);
		
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy"); 
		labelDataCriacao = new Label(formatador.format(item.getDataCriacao()));
		labelDataCriacao.setParent(vboxInformacoes);
		
		if(item instanceof LicaoAprendida){
			labelTipo = new Label("Li��o Aprendida");
			labelTipo.setParent(vboxInformacoes);
		}
		if(item instanceof ConhecimentoRelativoDiscussao){
			labelTipo = new Label("Conhecimento Relativo a uma Discuss�o");
			labelTipo.setParent(vboxInformacoes);
		}
		
		vboxInformacoes.setParent(listcellInformacoes);
		listcellInformacoes.setParent(listitem);
		
		//coluna Avaliadores Selecionados
		Vbox vboxAvaliadoresSelecionados = new Vbox();
		
		listcellAvaliadoresSelecionados = new Listcell();
		
		Label labelAvaliadores = new Label("Avaliadores:");
		labelAvaliadores.setParent(vboxAvaliadoresSelecionados);
		
		Collection<RecursoHumano> itens = item.getAvaliadores();
		for (RecursoHumano recurso : itens){
			Label labelNomeAutor = new Label();
			labelNomeAutor.setValue(recurso.getNome());
			labelNomeAutor.setParent(vboxAvaliadoresSelecionados);
		}
		
		Label labelAvaliacoesRealizadas = new Label("Avalia��es Realizadas: " + item.getAvaliacoes().size());
		labelAvaliacoesRealizadas.setParent(vboxAvaliadoresSelecionados);
		
		vboxAvaliadoresSelecionados.setParent(listcellAvaliadoresSelecionados);
		listcellAvaliadoresSelecionados.setParent(listitem);
		
		
	}
}
