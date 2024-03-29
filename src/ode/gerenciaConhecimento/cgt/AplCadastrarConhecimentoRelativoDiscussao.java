package ode.gerenciaConhecimento.cgt;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import ode._infraestruturaBase.cgd.DAOBase;
import ode._infraestruturaBase.excecao.NucleoRegraNegocioExcecao;
import ode._infraestruturaCRUD.cgt.AplCRUD;
import ode.conhecimento.processo.cdp.KAtividade;
import ode.controleProjeto.cdp.Projeto;
import ode.gerenciaConhecimento.cdp.ConhecimentoRelativoDiscussao;
import ode.gerenciaConhecimento.cdp.ItemConhecimento;
import ode.gerenciaConhecimento.cdp.Tema;
import ode.gerenciaConhecimento.cgd.ConhecimentoRelativoDiscussaoDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = NucleoRegraNegocioExcecao.class)
public class AplCadastrarConhecimentoRelativoDiscussao extends
		AplCRUD<ConhecimentoRelativoDiscussao> {

	@Autowired
	private ConhecimentoRelativoDiscussaoDAO conhecimentoRelativoDiscussaoDAO;
	
	@Override
	public DAOBase<ConhecimentoRelativoDiscussao> getNucleoDaoBase() {
		return conhecimentoRelativoDiscussaoDAO;
	}
	
	public List<ConhecimentoRelativoDiscussao> buscar(String expressao,
			Date dataCriacaoInicial,
			Date dataCriacaoFinal,
			Date dataUltimoAcessoInicial,
			Date dataUltimoAcessoFinal,
			Long quantidadeAcessosMinimo,
			Long quantidadeAcessosMaximo,
			Long quantidadeValoracoesMinimo,
			Long quantidadeValoracoesMaximo,
			BigDecimal percentualValoracoesPositivasMinima,
			BigDecimal percentualValoracoesPositivasMaxima,
			BigDecimal percentualValoracoesNegativasMinima,
			BigDecimal percentualValoracoesNegativasMaxima,
			String tipoItemConhecimento,
			Collection<Projeto> projetos,
			Collection<KAtividade> atividades,
			Collection<Tema> temas){
		
		return conhecimentoRelativoDiscussaoDAO.buscar(expressao, dataCriacaoInicial, dataCriacaoFinal, dataUltimoAcessoInicial, dataUltimoAcessoFinal, quantidadeAcessosMinimo, quantidadeAcessosMaximo, quantidadeValoracoesMinimo, quantidadeValoracoesMaximo, percentualValoracoesPositivasMinima, percentualValoracoesPositivasMaxima, percentualValoracoesNegativasMinima, percentualValoracoesNegativasMaxima, tipoItemConhecimento, projetos, atividades, temas);
		
	}
	
	public List<ConhecimentoRelativoDiscussao> recuperarOrdenadoPorQuantidadeAcesso(){

		List<ConhecimentoRelativoDiscussao> itens = this.conhecimentoRelativoDiscussaoDAO.recuperarOrdenadoPorQuantidadeAcesso(); 

		// Recupera os tres primeiros
		List<ConhecimentoRelativoDiscussao> novosItens = new ArrayList<ConhecimentoRelativoDiscussao>();
		if (itens.size() >= 1)
			novosItens.add(itens.get(0));
		if (itens.size() >= 2)
			novosItens.add(itens.get(1));
		if (itens.size() >= 3)
			novosItens.add(itens.get(2));

		return novosItens;
	}

	public List<ConhecimentoRelativoDiscussao> recuperarOrdenadoPorDataCriacaoMaisRecente(){

		List<ConhecimentoRelativoDiscussao> itens = this.conhecimentoRelativoDiscussaoDAO.recuperarOrdenadoPorDataCriacaoMaisRecente(); 

		// Recupera os tres primeiros
		List<ConhecimentoRelativoDiscussao> novosItens = new ArrayList<ConhecimentoRelativoDiscussao>();
		if (itens.size() >= 1)
			novosItens.add(itens.get(0));
		if (itens.size() >= 2)
			novosItens.add(itens.get(1));
		if (itens.size() >= 3)
			novosItens.add(itens.get(2));

		return novosItens;
	}

	public int recuperarQuantidadeTotal(){
		return this.conhecimentoRelativoDiscussaoDAO.recuperarQuantidadeTotal();
	}
	
	public List<ItemConhecimento> recuperarConhecimentoRelativoDiscussaoDisponiveis(){
		return this.conhecimentoRelativoDiscussaoDAO.recuperarConhecimentoRelativoDiscussaoDisponiveis();
	}
	
}
