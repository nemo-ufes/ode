package ode.conhecimento.processo.ciu;

import java.util.ArrayList;
import java.util.List;

import ode._infraestruturaBase.ciu.NucleoTab;
import ode._infraestruturaBase.excecao.NucleoRegraNegocioExcecao;
import ode._infraestruturaBase.util.NucleoMensagens;
import ode._infraestruturaCRUD.ciu.FormularioDadosCRUD;
import ode._infraestruturaCRUD.ciu.GridDados;
import ode.conhecimento.processo.cdp.KFerramentaSoftware;

import org.zkoss.zul.Textbox;

public class FormDadosKFerramentaSoftware extends
		FormularioDadosCRUD<KFerramentaSoftware> {

	private static final long serialVersionUID = 1L;
	private Textbox tbNome = new Textbox();
	private Textbox tbDescricao = new Textbox();

	@Override
	protected List<NucleoTab> definirTabs() {
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
		gridDadosCadastro
				.adicionarLinhaObrigatoria(
						NucleoMensagens.getMensagem(NucleoMensagens.TERMO_NOME),
						tbNome);

		tbDescricao.setWidth("285px");
		tbDescricao.setMaxlength(500);
		tbDescricao.setHeight("145px");
		tbDescricao.setMultiline(true);
		gridDadosCadastro.adicionarLinha(
				NucleoMensagens.getMensagem(NucleoMensagens.TERMO_DESCRICAO),
				tbDescricao);

		// adiciono o grid de dados na tab
		tabDadosCadastro.setConteudoTab(gridDadosCadastro);
		listaTabs.add(tabDadosCadastro);

		return listaTabs;
	}

	@Override
	protected void preencherDadosObjeto(KFerramentaSoftware ferramentasoftware) {
		ferramentasoftware.setNome(tbNome.getValue());
		ferramentasoftware.setDescricao(tbDescricao.getValue());
	}

	@Override
	protected void preencherDadosTela(KFerramentaSoftware ferramentasoftware)
			throws NucleoRegraNegocioExcecao {
		tbNome.setValue(ferramentasoftware.getNome());
		tbDescricao.setValue(ferramentasoftware.getDescricao());
	}

	@Override
	protected void configurarConstraints() {
		tbNome.setConstraint("no empty");
	}
}
