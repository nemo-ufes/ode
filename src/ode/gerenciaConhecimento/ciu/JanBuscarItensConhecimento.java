package ode.gerenciaConhecimento.ciu;

import java.util.Collection;

import ode.conhecimento.processo.cdp.KAtividade;
import ode.controleProjeto.cdp.Projeto;
import ode.gerenciaConhecimento.cdp.ItemConhecimento;
import ode.gerenciaConhecimento.cdp.Tema;

import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listhead;
import org.zkoss.zul.Listheader;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Panel;
import org.zkoss.zul.Panelchildren;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

public class JanBuscarItensConhecimento extends Window {

	CtrlGerenciaConhecimento ctrlGerenciaConhecimento;

	Listbox listboxProjetosRelacionados = new Listbox();
	Listbox listboxKAtividadesRelacionadas = new Listbox();
	Listbox listboxTemasRelacionados = new Listbox();
	
	//o nome dos objetos n�o ficaram bons, se tiver outra id�ia...
	Textbox textboxExpressao = new Textbox("");
	Datebox dateboxInicial_1 = new Datebox();
	Datebox dateboxFinal_1 = new Datebox();
	Datebox dateboxInicial_2 = new Datebox();
	Datebox dateboxFinal_2 = new Datebox();
	Datebox dateboxInicial_3 = new Datebox();
	Datebox dateboxFinal_3 = new Datebox();
	Textbox textboxMinimo_1 = new Textbox("");
	Textbox textboxMaximo_1 = new Textbox("");
	Textbox textboxMinimo_2 = new Textbox("");
	Textbox textboxMaximo_2 = new Textbox("");
	Textbox textboxMinimo_3 = new Textbox("");
	Textbox textboxMaximo_3 = new Textbox("");
	Textbox textboxMinimo_4 = new Textbox("");
	Textbox textboxMaximo_4 = new Textbox("");
	Combobox combobox = new Combobox();
	
	JanBuscarItensConhecimento(CtrlGerenciaConhecimento ctrl){
		
		ctrlGerenciaConhecimento = ctrl;
		
		criarJanBuscarItensConhecimento();
		
	}
	
	void criarJanBuscarItensConhecimento(){
		
	
	//	this.setHeight("500px");
		this.setTitle("Buscar Itens de Conhecimento");
		this.setBorder("normal");
		
		Tabbox tabbox = new Tabbox();
		
		Tabs tabs = new Tabs();
		Tab tabCriterios = new Tab("Crit�rios");
		
		tabCriterios.setParent(tabs);
		tabs.setParent(tabbox);
		
		Tabpanels tabpanels = new Tabpanels();
		Tabpanel tabpanelCriterios = new Tabpanel();
		tabpanelCriterios.setHeight("400px");
		tabpanelCriterios.setStyle("overflow:auto;");
		
		Grid grid = new Grid();
		grid.setSizedByContent(true);
		Rows rows = new Rows();
		
		// --- cria linha Express�o --- //
		
		Row linhaExpressao = new Row();
		
		Label labelExpressao = new Label("Express�o:");
		
		textboxExpressao.setWidth("300px");
		
		labelExpressao.setParent(linhaExpressao);
		textboxExpressao.setParent(linhaExpressao);
		
		linhaExpressao.setParent(rows);
		
		// --- cria linha Data Cria��o --- //

		Row linhaDataCriacao = new Row();
		
		Label labelDataCriacao = new Label("Data de Cria��o:");
	
		Div divDataCriacao = new Div();
		Label labelInicial_1 = new Label("Inicial: ");
		Label labelFinal_1 = new Label(" Final: ");
		
		
		labelInicial_1.setParent(divDataCriacao);
		dateboxInicial_1.setParent(divDataCriacao);
		labelFinal_1.setParent(divDataCriacao);
		dateboxFinal_1.setParent(divDataCriacao);
		
		labelDataCriacao.setParent(linhaDataCriacao);
		divDataCriacao.setParent(linhaDataCriacao);
		
		linhaDataCriacao.setParent(rows);

		// --- cria linha Data Ultima Utiliza��o --- //
		
		Row linhaDataUltimaUtilizacao = new Row();
		
		Label labelDataUltimaUtilizacao = new Label("Data de �ltima Utiliza��o:");
	
		Div divDataUltimaUtilizacao = new Div();
		Label labelInicial_2 = new Label("Inicial: ");
		Label labelFinal_2 = new Label(" Final: ");
		
		labelInicial_2.setParent(divDataUltimaUtilizacao);
		dateboxInicial_2.setParent(divDataUltimaUtilizacao);
		labelFinal_2.setParent(divDataUltimaUtilizacao);
		dateboxFinal_2.setParent(divDataUltimaUtilizacao);
		
		labelDataUltimaUtilizacao.setParent(linhaDataUltimaUtilizacao);
		divDataUltimaUtilizacao.setParent(linhaDataUltimaUtilizacao);
		
		linhaDataUltimaUtilizacao.setParent(rows);
		
		// --- cria linha Data Ultimo Acesso --- //

		Row linhaDataUltimoAcesso = new Row();
		
		Label labelDataUltimoAcesso = new Label("Data de �ltimo Acesso:");
	
		Div divDataUltimoAcesso = new Div();
		Label labelInicial_3 = new Label("Inicial: ");
		Label labelFinal_3 = new Label(" Final: ");
		
		labelInicial_3.setParent(divDataUltimoAcesso);
		dateboxInicial_3.setParent(divDataUltimoAcesso);
		labelFinal_3.setParent(divDataUltimoAcesso);
		dateboxFinal_3.setParent(divDataUltimoAcesso);
		
		labelDataUltimoAcesso.setParent(linhaDataUltimoAcesso);
		divDataUltimoAcesso.setParent(linhaDataUltimoAcesso);
		
		linhaDataUltimoAcesso.setParent(rows);
		
		// --- cria linha Quantidade de Acessos --- //
		
		Row linhaQtdeAcessos = new Row();
		
		Label labelQtdeAcessos = new Label("Quantidade de Acessos:");
		
		Div divQtdeAcessos = new Div();
		Label labelMinimo_1 = new Label("M�nimo: ");
		textboxMinimo_1.setWidth("70px");
		Label labelMaximo_1 = new Label(" M�ximo: ");
		textboxMaximo_1.setWidth("70px");
		labelMinimo_1.setParent(divQtdeAcessos);
		textboxMinimo_1.setParent(divQtdeAcessos);
		labelMaximo_1.setParent(divQtdeAcessos);
		textboxMaximo_1.setParent(divQtdeAcessos);
		
		labelQtdeAcessos.setParent(linhaQtdeAcessos);
		divQtdeAcessos.setParent(linhaQtdeAcessos);
		
		linhaQtdeAcessos.setParent(rows);
		
		// --- cria linha Quantidade de Valora��es --- //

		Row linhaQtdeValoracoes = new Row();
		
		Label labelQtdeValoracoes = new Label("Quantidade de Valora��es:");
		
		Div divQtdeValoracoes = new Div();
		Label labelMinimo_2 = new Label("M�nimo: ");
		textboxMinimo_2.setWidth("70px");
		Label labelMaximo_2 = new Label(" M�ximo: ");
		textboxMaximo_2.setWidth("70px");
		
		labelMinimo_2.setParent(divQtdeValoracoes);
		textboxMinimo_2.setParent(divQtdeValoracoes);
		labelMaximo_2.setParent(divQtdeValoracoes);
		textboxMaximo_2.setParent(divQtdeValoracoes);
		
		labelQtdeValoracoes.setParent(linhaQtdeValoracoes);
		divQtdeValoracoes.setParent(linhaQtdeValoracoes);
		
		linhaQtdeValoracoes.setParent(rows);
		
		// --- cria linha Percentual de Valora��es Positivas --- //

		Row linhaPercentualValoracoesPositivas = new Row();
		
		Label labelPercentualValoracoesPositivas = new Label("Percentual de Valora��es Positivas:");
		
		Div divPercentualValoracoesPositivas = new Div();
		Label labelMinimo_3 = new Label("M�nimo: ");
		textboxMinimo_3.setWidth("70px");
		Label labelMaximo_3 = new Label(" %   M�ximo: ");
		textboxMaximo_3.setWidth("70px");
		Label labelPercente_3 = new Label(" %");
		
		labelMinimo_3.setParent(divPercentualValoracoesPositivas);
		textboxMinimo_3.setParent(divPercentualValoracoesPositivas);
		labelMaximo_3.setParent(divPercentualValoracoesPositivas);
		textboxMaximo_3.setParent(divPercentualValoracoesPositivas);
		labelPercente_3.setParent(divPercentualValoracoesPositivas);
		
		labelPercentualValoracoesPositivas.setParent(linhaPercentualValoracoesPositivas);
		divPercentualValoracoesPositivas.setParent(linhaPercentualValoracoesPositivas);
		
		linhaPercentualValoracoesPositivas.setParent(rows);
		
		// --- cria linha Percentual de Valora��es Negativas --- //

		Row linhaPercentualValoracoesNegativas = new Row();
		
		Label labelPercentualValoracoesNegativas = new Label("Percentual de Valora��es Positivas:");
		
		Div divPercentualValoracoesNegativas = new Div();
		Label labelMinimo_4 = new Label("M�nimo: ");
		textboxMinimo_4.setWidth("70px");
		Label labelMaximo_4 = new Label(" %   M�ximo: ");
		textboxMaximo_4.setWidth("70px");
		Label labelPercente_4 = new Label(" %");
		
		labelMinimo_4.setParent(divPercentualValoracoesNegativas);
		textboxMinimo_4.setParent(divPercentualValoracoesNegativas);
		labelMaximo_4.setParent(divPercentualValoracoesNegativas);
		textboxMaximo_4.setParent(divPercentualValoracoesNegativas);
		labelPercente_4.setParent(divPercentualValoracoesNegativas);
		
		labelPercentualValoracoesNegativas.setParent(linhaPercentualValoracoesNegativas);
		divPercentualValoracoesNegativas.setParent(linhaPercentualValoracoesNegativas);
		
		linhaPercentualValoracoesNegativas.setParent(rows);
		
		// --- cria linha Tipo de Item de Conhecimento --- //
		
		Row linhaTipoItemConhecimento = new Row();
		
		Label labelTipoItemConhecimento = new Label("Tipo de Item de Conhecimento:");
		
		combobox.setWidth("250px");
		Comboitem comboitemLicaoAprendida = new Comboitem("Li��o Aprendida");
		Comboitem comboitemConhecimentoRelativoDiscussao = new Comboitem("Conhecimento Relativo a uma Discuss�o");
		
		comboitemLicaoAprendida.setParent(combobox);
		comboitemConhecimentoRelativoDiscussao.setParent(combobox);
		
		labelTipoItemConhecimento.setParent(linhaTipoItemConhecimento);
		combobox.setParent(linhaTipoItemConhecimento);
		
		linhaTipoItemConhecimento.setParent(rows);
		
		//////////////////////////////////////////
		// Projetos relacionados
		//////////////////////////////////////////
		
		Row linhaProjetosRelacionados = new Row();

		Label labelProjetosRelacionados = new Label("Projetos Relacionados:");

		listboxProjetosRelacionados.setMultiple(true);
		listboxProjetosRelacionados.setCheckmark(true);

		Listhead colunasProjetosRelacionados = new Listhead();
		Listheader colunaNome = new Listheader("Nome");

		colunaNome.setParent(colunasProjetosRelacionados);
		colunasProjetosRelacionados.setParent(listboxProjetosRelacionados);

		// Adicionar itens no listbox projeto
		Collection<Projeto> projetos = ctrlGerenciaConhecimento.aplCadastrarProjeto.recuperarTodos();
		for (Projeto projeto : projetos) {
			Listitem listitem = new Listitem(projeto.getNome());
			listitem.setValue(projeto);
			listitem.setParent(listboxProjetosRelacionados);
		}

		labelProjetosRelacionados.setParent(linhaProjetosRelacionados);
		listboxProjetosRelacionados.setParent(linhaProjetosRelacionados);
		
		linhaProjetosRelacionados.setParent(rows);
		
		//////////////////////////////////////////
		// Atividades relacionadas
		//////////////////////////////////////////
		Row linhaAtividadesRelacionadas = new Row();

		Label labelAtividadesRelacionadas = new Label("Atividades Relacionadas: ");

		listboxKAtividadesRelacionadas.setMultiple(true);
		listboxKAtividadesRelacionadas.setCheckmark(true);

		Listhead colunasAtividadesRelacionadas = new Listhead();
		Listheader colunaTitulo2 = new Listheader("T�tulo");

		colunaTitulo2.setParent(colunasAtividadesRelacionadas);
		colunasAtividadesRelacionadas.setParent(listboxKAtividadesRelacionadas);

		// Adicionar itens no listbox katividade
		Collection<KAtividade> atividades = ctrlGerenciaConhecimento.aplCadastrarKAtividade.recuperarTodos();
		for(KAtividade atividade : atividades){
			Listitem listitem = new Listitem(atividade.getNome());
			listitem.setValue(atividade);
			listitem.setParent(listboxKAtividadesRelacionadas);
		}

		labelAtividadesRelacionadas.setParent(linhaAtividadesRelacionadas);
		listboxKAtividadesRelacionadas.setParent(linhaAtividadesRelacionadas);
		
		linhaAtividadesRelacionadas.setParent(rows);
		
		//////////////////////////////////////////
		// Temas relacionados
		//////////////////////////////////////////
		Row linhaTemasRelacionados = new Row();

		Label labelTemasRelacionados = new Label("Temas Relacionados: ");

		listboxTemasRelacionados.setMultiple(true);
		listboxTemasRelacionados.setCheckmark(true);

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
		
		rows.setParent(grid);
		grid.setParent(tabpanelCriterios);
		tabpanelCriterios.setParent(tabpanels);
		tabpanels.setParent(tabbox);
		
		tabbox.setParent(this);
		
	
	}
}
