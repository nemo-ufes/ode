package nucleo.comuns.crud.controlador;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import nucleo.comuns.aplicacao.NucleoAplCadastroBase;
import nucleo.comuns.base.controlador.CtrlBase;
import nucleo.comuns.crud.visao.FormularioDadosCRUD;
import nucleo.comuns.crud.visao.FormularioDadosCRUD.ModoExibicao;
import nucleo.comuns.crud.visao.PainelCRUD;
import nucleo.comuns.excecao.CtrlExcecoes;
import nucleo.comuns.excecao.NucleoRegraNegocioExcecao;
import nucleo.comuns.persistencia.ObjetoPagina;
import nucleo.comuns.persistencia.ObjetoPersistente;
import nucleo.comuns.persistencia.ResultadoPaginado;
import nucleo.comuns.util.NucleoMensagens;
import nucleo.comuns.visao.listagem.IAtualizaPesquisa;
import nucleo.comuns.visao.paginacao.IAtualizadorPesquisaPaginada;
import nucleo.comuns.visao.principal.JanelaSimples;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;

public abstract class CtrlCRUD<T extends ObjetoPersistente> extends CtrlBase
		implements IAtualizaPesquisa {

	// iniciar componentes
	// definir
	// validar

	/**
	 * Interface de aplicaçãoo usada para cadastros básicos (CRUD)
	 */
	private NucleoAplCadastroBase<T> nucleoAplCadastroBase;

	protected PainelCRUD<T> painelCRUD;

	protected FormularioDadosCRUD<T> formularioDados;

	protected JanelaSimples janDados;

	protected String alturaJanPrincipal = "450px";

	protected String larguraJanPrincipal = "590px";

	protected String alturaJanDados = "250px";

	protected String larguraJandados = "300px";

	public CtrlCRUD() {
	}

	public void iniciar() {
		configurarComponentes();
		mostrarJanelaPrincipal();
	}

	public void configurarComponentes() {

		definirComponentesExtensao();
		validarComponentesExtensao();

		painelCRUD.setControlador(this);
		painelCRUD.configurarComponentes();
	}

	protected void definirComponentesExtensao() {
		nucleoAplCadastroBase = definirNucleoAplCadastroBase();
		painelCRUD = definirPainelCRUD();
	}

	protected void validarComponentesExtensao() {

		if (painelCRUD == null)
			throw CtrlExcecoes.factoryExcecaoDefinicao("painelCRUD",
					this.getClass());

		if (nucleoAplCadastroBase == null)
			throw CtrlExcecoes.factoryExcecaoDefinicao("nucleoAplCadastroBase",
					this.getClass());

	}

	public void setNucleoAplCadastroBase(
			NucleoAplCadastroBase<T> nucleoAplCadastroBase) {
		this.nucleoAplCadastroBase = nucleoAplCadastroBase;
	}

	public NucleoAplCadastroBase<T> getNucleoAplCadastroBase() {
		return nucleoAplCadastroBase;
	}

	/*
	public void atualizarPesquisa(ObjetoPagina pagina) {

		ResultadoPaginado resultado = null;
		
			resultado = getNucleoAplCadastroBase().recuperarTodosPaginado(
					pagina);
		// atualizo os objetos e preencho a nova listagem
		painelCRUD.getListagemPaginada().setResultadoAtualizarPesquisa(
				resultado);

	}
	*/

	public void mostrarJanelaPrincipal() {
		JanelaSimples jan = factoryJanelaSimples();
		painelCRUD.setParent(jan);
		String titulo = definirTituloJanelaPrincipal();
		jan.setTitle(titulo);
		jan.setWidth(larguraJanPrincipal);
		jan.setHeight(alturaJanPrincipal);

		jan.mostrar();
		// apos mostrar a janela principal, recupera os objetos para pesquisa
	//	atualizarPesquisa(painelCRUD.getListagemPaginada().getPagina());
		
		atualizarPesquisa();
	}

	public void atualizarPesquisa() {
		Collection<T> objetos =getNucleoAplCadastroBase().recuperarTodos();		
		painelCRUD.getListagem().atualizar(objetos);
		
	}

	public void acaoExcluir() {
		validarExcluir();
	}

	public void validarExcluir() {
		Set<Listitem> itensSelecionados = painelCRUD.getListagem()
				.getSelecionados();
		try {
			// verifica se o número de itens selecionados é maior que zero.
			if (itensSelecionados.size() > 0) {

				String mensagemConfirmacao;

				if (itensSelecionados.size() > 1) {
					mensagemConfirmacao = NucleoMensagens
							.getMensagem(NucleoMensagens.MSG_CONFIRMACAO_EXCLUSAO_PLURAL);
				} else {
					mensagemConfirmacao = NucleoMensagens
							.getMensagem(NucleoMensagens.MSG_CONFIRMACAO_EXCLUSAO_SINGULAR);
				}

				confirmaSimNao(mensagemConfirmacao, new EventListener() {
					
						public void onEvent(Event evt) {
							switch (((Integer) evt.getData()).intValue()) {
							case Messagebox.YES:
							
								excluir(painelCRUD.getListagem().getSelecionados());
								break; //the No button is pressed

							case Messagebox.NO:
							
								break; //the No button is pressed

							default:


							}

						
					}
				});

			} else {

				mostrarJanelaInformacao(NucleoMensagens
						.getMensagem(NucleoMensagens.MSG_NENHUM_ELEMENTO_SELECIONADO));

			}

		} catch (Exception e) {
			CtrlExcecoes.tratarExcecao(e);
		}

	}

	protected void excluir(Set<Listitem> objetosSelecionados) {

		// Exclui os itens selecionados

		Set<T> objetosConvertidosSelecionados = converterObjetos(objetosSelecionados);
		try {
			getNucleoAplCadastroBase().excluir(objetosConvertidosSelecionados);
			// apos excluir recupera os objetos para pesquisa

			mostrarJanelaInformacao(NucleoMensagens
					.getMensagem(NucleoMensagens.MSG_DADOS_SALVOS_SUCESSO));
			//atualizarPesquisa(painelCRUD.getListagemPaginada().getPagina());
			atualizarPesquisa();

		} catch (NucleoRegraNegocioExcecao e) {
			CtrlExcecoes
					.exibirJanelaErro("N�o foi possivel excluir os objetos");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	protected Set<T> converterObjetos(Set<Listitem> itensSelecionados) {

		Set<T> listaRetorno = new HashSet<T>();
		Iterator<Listitem> itItensSelecionados = itensSelecionados.iterator();

		while (itItensSelecionados.hasNext()) {
			Listitem itemSelecionado = itItensSelecionados.next();
			T objeto = (T) itemSelecionado.getValue();
			listaRetorno.add(objeto);
		}

		return listaRetorno;

	}

	public void acaoNovo() {

		mostrarFormulario(ModoExibicao.NOVO);
	}

	public void mostrarFormulario(ModoExibicao modoExibicao) {

		janDados = factoryJanelaSimples();
		String titulo = definirTituloJanelaDados();
		janDados.setTitle(titulo);
		janDados.setHeight(alturaJanDados);
		janDados.setWidth(larguraJandados);

		formularioDados = definirFormularioCadastro();
		formularioDados.setControlador(this);
		formularioDados.setParent(janDados);
		formularioDados.configurarComponentes();
		formularioDados.setModoExibicao(modoExibicao);

		try {

			if (modoExibicao == ModoExibicao.NOVO) {
				formularioDados.setObjetoCadastroDados(factoryObjetoDados());
			} else {
				// Se nao eh novo, tenho que recuperar o objeto do banco
				T objetoSelecionado = painelCRUD.getListagem()
						.getSelecionado();
				// atualizo a referencia do objetoSelecionado
				objetoSelecionado = nucleoAplCadastroBase
						.recuperarPorId(objetoSelecionado.getId());

				formularioDados.setObjetoCadastroDados(objetoSelecionado);
				// copio os dados do objeto pro formulario
				formularioDados.atualizarDadosTela();
			}

			janDados.mostrar();

		} catch (Exception e) {
			CtrlExcecoes.tratarExcecao(e);
		}

	}

	public void acaoAbrir() {
		mostrarFormulario(ModoExibicao.EDITAR);

	}

	public void acaoSalvar() {
		try {
			// passo os dados do formulario para o objeto antes de pega-lo
			formularioDados.atualizarObjeto();
			T objetoCadastro = formularioDados.getObjetoCadastroDados();
			nucleoAplCadastroBase.salvar(objetoCadastro);
			// /atualiza a pesquisa e fecha a janela
			//atualizarPesquisa(painelCRUD.getListagemPaginada().getPagina());
			atualizarPesquisa();
			janDados.onClose();

		} catch (Exception e) {
			CtrlExcecoes.tratarExcecao(e);
		}

	}

	public abstract String definirTituloJanelaDados();

	public abstract NucleoAplCadastroBase<T> definirNucleoAplCadastroBase();

	public abstract PainelCRUD<T> definirPainelCRUD();

	public abstract String definirTituloJanelaPrincipal();

	public abstract FormularioDadosCRUD<T> definirFormularioCadastro();

	public abstract T factoryObjetoDados();

	public String getAlturaJanPrincipal() {
		return alturaJanPrincipal;
	}

	public void setAlturaJanPrincipal(String alturaJanPrincipal) {
		this.alturaJanPrincipal = alturaJanPrincipal;
	}

	public String getLarguraJanPrincipal() {
		return larguraJanPrincipal;
	}

	public void setLarguraJanPrincipal(String larguraJanPrincipal) {
		this.larguraJanPrincipal = larguraJanPrincipal;
	}

	public String getAlturaJanDados() {
		return alturaJanDados;
	}

	public void setAlturaJanDados(String alturaJanDados) {
		this.alturaJanDados = alturaJanDados;
	}

	public String getLarguraJandados() {
		return larguraJandados;
	}

	public void setLarguraJandados(String larguraJandados) {
		this.larguraJandados = larguraJandados;
	}

}
