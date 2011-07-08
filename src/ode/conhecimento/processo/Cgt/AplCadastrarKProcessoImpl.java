package ode.conhecimento.processo.Cgt;

import nucleo.comuns.aplicacao.NucleoAplCadastroBaseImpl;
import nucleo.comuns.excecao.NucleoExcecao;
import nucleo.comuns.excecao.NucleoRegraNegocioExcecao;
import nucleo.comuns.persistencia.NucleoDAOBase;
import ode.conhecimento.processo.Cdp.KProcesso;
import ode.conhecimento.processo.Cgd.KProcessoDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = NucleoExcecao.class)
public class AplCadastrarKProcessoImpl extends NucleoAplCadastroBaseImpl<KProcesso> 
				implements AplCadastrarKProcesso {

	@Autowired
	private KProcessoDAO kProcessoDAO;

	public KProcessoDAO getKProcessoDAO() {
		return kProcessoDAO;
	}

	public void setKProcessoDAO(KProcessoDAO kProcessoDAO) {
		this.kProcessoDAO = kProcessoDAO;
	}

	@Override
	protected void copiarValor(KProcesso objetoFonte, KProcesso objetoDestino) {
		objetoDestino.setNome(objetoFonte.getNome());
		objetoDestino.setDescricao(objetoFonte.getDescricao());
		objetoDestino.setProposito(objetoFonte.getProposito());
		objetoDestino.setSigla(objetoFonte.getSigla());
		objetoDestino.setEhEngenharia(objetoFonte.isEhEngenharia());
		objetoDestino.setKTipoInteracao(objetoFonte.getKTipoInteracao());
		objetoDestino.setCategoria(objetoFonte.getCategoria());
		objetoDestino.setKResultadoProcesso(objetoFonte.getKResultadoProcesso());
	}

	protected KProcesso alterarDados(KProcesso objeto) throws NucleoRegraNegocioExcecao {
		getNucleoDaoBase().merge(objeto);
		//Retorna objetoPersistido;
		return objeto;
	}
	
	@Override
	public NucleoDAOBase<KProcesso> getNucleoDaoBase() {
		return kProcessoDAO;
	}
}