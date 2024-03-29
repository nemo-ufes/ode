package ode.gerenciaConhecimento.cgd;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import ode._infraestruturaBase.cgd.DAOBase;
import ode.conhecimento.processo.cdp.KAtividade;
import ode.controleProjeto.cdp.Projeto;
import ode.gerenciaConhecimento.cdp.ConhecimentoRelativoDiscussao;
import ode.gerenciaConhecimento.cdp.ItemConhecimento;
import ode.gerenciaConhecimento.cdp.Tema;

public interface ConhecimentoRelativoDiscussaoDAO extends
DAOBase<ConhecimentoRelativoDiscussao> {

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
			Collection<Tema> temas);

	public List<ConhecimentoRelativoDiscussao> recuperarOrdenadoPorQuantidadeAcesso();

	public List<ConhecimentoRelativoDiscussao> recuperarOrdenadoPorDataCriacaoMaisRecente();

	public int recuperarQuantidadeTotal();
	
	public List<ItemConhecimento> recuperarConhecimentoRelativoDiscussaoDisponiveis();

}
