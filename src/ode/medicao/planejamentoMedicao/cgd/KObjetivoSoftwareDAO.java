package ode.medicao.planejamentoMedicao.cgd;

import java.util.Collection;

import ode._infraestruturaBase.cgd.DAOBase;
import ode.medicao.planejamentoMedicao.cdp.KObjetivoMedicao;
import ode.medicao.planejamentoMedicao.cdp.KObjetivoSoftware;

public interface KObjetivoSoftwareDAO extends DAOBase<KObjetivoSoftware>{

	Collection<KObjetivoMedicao> getObjetivosMedicao(
			KObjetivoSoftware objetoCadastro);
	
}