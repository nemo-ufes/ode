package ode.conhecimento.processo.Cgt;

import nucleo.comuns.aplicacao.NucleoAplCadastroBaseImpl;
import nucleo.comuns.excecao.NucleoExcecao;
import nucleo.comuns.excecao.NucleoRegraNegocioExcecao;
import nucleo.comuns.persistencia.NucleoDAOBase;
import ode.conhecimento.processo.Cdp.KResultadoProcesso;
import ode.conhecimento.processo.Cgd.KResultadoProcessoDAO;
import ode.conhecimento.processo.Cgt.AplCadastrarKResultadoProcesso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = NucleoExcecao.class)
public class AplCadastrarKResultadoProcessoImpl extends NucleoAplCadastroBaseImpl<KResultadoProcesso> implements AplCadastrarKResultadoProcesso{

	@Autowired
	private KResultadoProcessoDAO kResultadoProcessoDAO;

	public KResultadoProcessoDAO getKResultadoProcessoDAO() {
		return kResultadoProcessoDAO;
	}
	
	public void setKResultadoProcessoDAO(KResultadoProcessoDAO kResultadoProcessoDAO) {
		this.kResultadoProcessoDAO = kResultadoProcessoDAO;
	}
	
	@Override
	protected void copiarValor(KResultadoProcesso objetoFonte, KResultadoProcesso objetoDestino) {
		objetoDestino.setNome(objetoFonte.getNome());
		objetoDestino.setDescricao(objetoFonte.getDescricao());
		objetoDestino.setKProcesso (objetoFonte.getKProcesso());
	}
	
	protected KResultadoProcesso alterarDados(KResultadoProcesso objeto) throws NucleoRegraNegocioExcecao {
		getNucleoDaoBase().merge(objeto);
		return objeto;
	}

	@Override
	public NucleoDAOBase<KResultadoProcesso> getNucleoDaoBase() {
		return kResultadoProcessoDAO;
	}
}