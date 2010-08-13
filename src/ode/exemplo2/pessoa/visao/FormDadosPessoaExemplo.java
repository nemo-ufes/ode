package ode.exemplo2.pessoa.visao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import nucleo.comuns.crud.visao.FormularioDadosCRUD;
import nucleo.comuns.crud.visao.GridDados;
import nucleo.comuns.excecao.NucleoRegraNegocioExcecao;
import nucleo.comuns.util.NucleoMensagens;
import nucleo.comuns.visao.componentes.NucleoTab;
import nucleo.comuns.visao.componentes.selecao.NucleoBandbox;
import ode.exemplo2.pessoa.controlador.CtrlPessoaCRUD;
import ode.exemplo2.pessoa.dominio.PessoaExemplo;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.event.PagingEvent;

public class FormDadosPessoaExemplo extends FormularioDadosCRUD<PessoaExemplo>{
	

	private Textbox tbNome = new Textbox();
	private Textbox tbSobrenome = new Textbox();
	private Textbox tbTelefone = new Textbox();
	private Textbox tbIdade = new Textbox();
	private Textbox tbEmail = new Textbox();
	

	NucleoBandbox<PessoaExemplo> bandPai;


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
		tbNome.setWidth("150px");
		tbNome.setMaxlength(50);		
		gridDadosCadastro.adicionarLinha(NucleoMensagens
				.getMensagem(NucleoMensagens.TERMO_NOME),tbNome);
		
		tbSobrenome.setWidth("150px");
		tbSobrenome.setMaxlength(10);
		gridDadosCadastro.adicionarLinha(NucleoMensagens
				.getMensagem(NucleoMensagens.TERMO_SOBRENOME),tbSobrenome);		

		
		tbTelefone.setWidth("150px");
		tbTelefone.setMaxlength(50);
		gridDadosCadastro.adicionarLinha(NucleoMensagens
				.getMensagem(NucleoMensagens.TERMO_TELEFONE),tbTelefone);
		
		
		tbIdade.setWidth("150px");
		tbIdade.setMaxlength(50);
		gridDadosCadastro.adicionarLinha(NucleoMensagens
				.getMensagem(NucleoMensagens.TERMO_IDADE),tbIdade);

		
		tbEmail.setWidth("150px");
		tbEmail.setMaxlength(50);
		gridDadosCadastro.adicionarLinha(NucleoMensagens
				.getMensagem(NucleoMensagens.TERMO_EMAIL),tbEmail);
		
		
		
		 bandPai = new NucleoBandbox<PessoaExemplo>(){
			
			
		
			@Override
			protected String[] definirTamanhosCabecalho() {

				return new String[]{"240px"};
			}

			@Override
			protected String[] definirTitulosCabecalho() {

				return new String[]{"Nome"};
			}

			@Override
			protected String[] recuperarDadosObjeto(PessoaExemplo objeto) {
 
				return new String[]{objeto.getNome()};
			}
			
			
		};
		
		Collection<PessoaExemplo> pessoas = ((CtrlPessoaCRUD) getControlador()).recuperarTodasPessoas();
		bandPai.preencherLista(pessoas);
		
		bandPai.addEventListener("onClick", new EventListener() {

			public void onEvent(Event event) {
				
				Collection<PessoaExemplo> pessoas = ((CtrlPessoaCRUD) getControlador()).recuperarTodasPessoas();
				bandPai.preencherLista(pessoas);
			

			}
		});
		
		gridDadosCadastro.adicionarLinha("Pai", bandPai);
		//adiciono o grid de dados na tab
		tabDadosCadastro.setConteudoTab(gridDadosCadastro);
		listaTabs.add(tabDadosCadastro);

		return listaTabs;
	}

	@Override
	protected void preencherDadosObjeto(PessoaExemplo pessoa) {		
		pessoa.setNome(tbNome.getValue());
		pessoa.setSobrenome(tbSobrenome.getValue());
		pessoa.setTelefone(tbTelefone.getValue());
		if ( tbIdade.getValue() != null)
		pessoa.setIdade(Integer.parseInt(tbIdade.getValue()));		
		pessoa.setEmail(tbEmail.getValue());
	}
	
	

	@Override
	protected void preencherDadosTela(PessoaExemplo pessoa) throws NucleoRegraNegocioExcecao {
		
		tbNome.setValue(pessoa.getNome());
		tbSobrenome.setValue(pessoa.getSobrenome());
		tbTelefone.setValue(pessoa.getTelefone());
		if (tbIdade.getValue() != null)
		tbIdade.setValue(String.valueOf(pessoa.getIdade()));
		tbEmail.setValue(pessoa.getEmail());
	}
	
	@Override
	protected void configurarConstraints() {
		tbNome.setConstraint("no empty");		
		tbSobrenome.setConstraint("no empty");
		tbTelefone.setConstraint("no empty");
		tbIdade.setConstraint("no negative, no zero");
		tbEmail.setConstraint("no empty");
				
	}
}