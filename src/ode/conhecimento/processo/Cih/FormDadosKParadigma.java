package ode.conhecimento.processo.Cih;

import java.util.ArrayList;
import java.util.List;

import nucleo.comuns.crud.visao.FormularioDadosCRUD;
import nucleo.comuns.crud.visao.GridDados;
import nucleo.comuns.excecao.NucleoRegraNegocioExcecao;
import nucleo.comuns.util.NucleoMensagens;
import nucleo.comuns.visao.componentes.NucleoTab;
import nucleo.comuns.visao.componentes.selecao.NucleoBandbox;
import ode.conhecimento.processo.Cdp.KParadigma;

import org.zkoss.zul.Textbox;

public class FormDadosKParadigma extends FormularioDadosCRUD<KParadigma>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1453567099986095491L;
	private Textbox tbNome = new Textbox();
	private Textbox tbDescricao = new Textbox();
	

	@SuppressWarnings("unchecked")
	@Override
	protected List definirTabs() {
		// Cria a nova lista
		List<NucleoTab> listaTabs = new ArrayList<NucleoTab>();

		// ////////////////////////////
		// Dados Cadastro
		// ////////////////////////////
		NucleoTab tabDadosCadastro = new NucleoTab();

		// Atribui o nome � tab
		tabDadosCadastro.setNomeTab(NucleoMensagens
				.getMensagem(NucleoMensagens.TERMO_DADOS_CADASTRO));

		// Atribui o conte�do � tab
		GridDados gridDadosCadastro = new GridDados();
		tbNome.setWidth("285px");
		tbNome.setMaxlength(100);		
		gridDadosCadastro.adicionarLinha(NucleoMensagens
				.getMensagem(NucleoMensagens.TERMO_NOME),tbNome);
		
		tbDescricao.setWidth("285px");
		tbDescricao.setMaxlength(500);
		tbDescricao.setHeight("145px");
		tbDescricao.setMultiline(true);
		gridDadosCadastro.adicionarLinha(NucleoMensagens
				.getMensagem(NucleoMensagens.TERMO_DESCRICAO),tbDescricao);		

		NucleoBandbox<KParadigma> band = new NucleoBandbox<KParadigma>(){

			@Override
			protected String[] definirTamanhosCabecalho() {
				return new String[]{"240px"};
			}

			@Override
			protected String[] definirTitulosCabecalho() {

				return new String[]{"Nome"};
			}

			@Override
			protected String[] recuperarDadosObjeto(KParadigma objeto) {
 
				return new String[]{objeto.getNome()};
			}
			
			
		};
		
		//adiciono o grid de dados na tab
		tabDadosCadastro.setConteudoTab(gridDadosCadastro);
		listaTabs.add(tabDadosCadastro);

		return listaTabs;
	}

	@Override
	protected void preencherDadosObjeto(KParadigma paradigma) {		
		paradigma.setNome(tbNome.getValue());
		paradigma.setDescricao(tbDescricao.getValue());
	}
	
	

	@Override
	protected void preencherDadosTela(KParadigma paradigma) throws NucleoRegraNegocioExcecao {
		
		tbNome.setValue(paradigma.getNome());
		tbDescricao.setValue(paradigma.getDescricao());
	}
	
	@Override
	protected void configurarConstraints() {
		tbNome.setConstraint("no empty");		
		tbDescricao.setConstraint("no empty");
				
	}
}