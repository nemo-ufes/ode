package nucleo.comuns.autenticacao.acegi.aplicacao;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import nucleo.comuns.autenticacao.acegi.dominio.NucleoPessoa;
import nucleo.comuns.autenticacao.acegi.persistencia.NucleoPessoaDAO;
import nucleo.comuns.excecao.NucleoExcecao;
import nucleo.comuns.excecao.NucleoRegraNegocioExcecao;
import nucleo.comuns.util.NucleoMensagens;

import ode.nucleo.cgd.NucleoDAOBase;
import ode.nucleo.cgt.NucleoAplCadastroBaseImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Transactional(rollbackFor = NucleoExcecao.class)
public class AplCadastrarNucleoPessoaImpl extends
		NucleoAplCadastroBaseImpl<NucleoPessoa> implements AplCadastrarNucleoPessoa {

	@Autowired
	private NucleoPessoaDAO nucleoPessoaDAO;
	
	public NucleoPessoaDAO getNucleoPessoaDAO() {
		return nucleoPessoaDAO;
	}

	public void setNucleoPessoaDAO(NucleoPessoaDAO nucleoPessoaDAO) {
		this.nucleoPessoaDAO = nucleoPessoaDAO;
	}
	
	@Override
	protected void antesIncluirNovo(NucleoPessoa objeto)
			throws NucleoRegraNegocioExcecao {

		// Verifica se existe outra pessoa com o mesmo email
		if (((NucleoPessoaDAO) this.getNucleoDaoBase()).recuperarPorEmail(objeto
				.getEmail()) != null) {
			throw new NucleoRegraNegocioExcecao(NucleoMensagens
					.getMensagem(NucleoMensagens.MSG_EXISTE_PESSOA_MESMO_EMAIL),
					null);
		}
	}

	@Override
	protected void antesAlterarDados(NucleoPessoa objeto)
			throws NucleoRegraNegocioExcecao {

		// Verifica se existe pessoa com o mesmo e-mail
		NucleoPessoa nucleoPessoaPersistido = ((NucleoPessoaDAO) this
				.getNucleoDaoBase()).recuperarPorEmail(objeto.getEmail());
		if (nucleoPessoaPersistido != null) {
			if (!nucleoPessoaPersistido.getId().equals(objeto.getId())) {
				throw new NucleoRegraNegocioExcecao(
						NucleoMensagens
								.getMensagem(NucleoMensagens.MSG_EXISTE_PESSOA_MESMO_EMAIL),
						null);
			}
		}
	}

	public Collection<NucleoPessoa> recuperarTodos() {
		List<NucleoPessoa> pessoas = (List<NucleoPessoa>) super.recuperarTodos();
		Collections.sort(pessoas, new ComparaNucleoPessoa());
		return pessoas;
	}

	private class ComparaNucleoPessoa implements Comparator<NucleoPessoa> {

		public int compare(NucleoPessoa objeto1, NucleoPessoa objeto2) {
			return objeto1.getNome().compareToIgnoreCase(objeto2.getNome());
		}
	}

	@Override
	public NucleoDAOBase<NucleoPessoa> getNucleoDaoBase() {
		return nucleoPessoaDAO;
	}
}
