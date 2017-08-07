package br.com.advocacialca.negocio;

import java.util.List;

import br.com.advocacialca.beans.AdvogadoProcessoBean;
import br.com.advocacialca.beans.ProcessoBean;
import br.com.advocacialca.beans.RespostaCRUD;
import br.com.advocacialca.factory.DAOFactory;
import br.com.advocacialca.jdbc.OracleAdvogadoProcessoDAO;

public class AdvogadoProcessoBO {
	
	public RespostaCRUD cadastrar(AdvogadoProcessoBean advogadoProcesso) {

		RespostaCRUD resp = null;
		
		HistBloqDesbloqBO histBO = new HistBloqDesbloqBO();
		
		ProcessoBean processoBean = advogadoProcesso.getProcesso();
		
		boolean processoBloqueado = histBO.verificarProcessoEstaBloqueado(processoBean);
		
		if (processoBloqueado) {
			resp = new RespostaCRUD(false, "O processo " + processoBean.getNrProcesso() + " se encontra bloqueado.");
		} else {
			OracleAdvogadoProcessoDAO dao = (OracleAdvogadoProcessoDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getAdvogadoProcessoDAO();
			return dao.cadastrar(advogadoProcesso);
		}
		
		return resp;
	}
	
	public void atualizar(AdvogadoProcessoBean advogadoProcesso){
		OracleAdvogadoProcessoDAO dao = (OracleAdvogadoProcessoDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getAdvogadoProcessoDAO();
		dao.atualizar(advogadoProcesso);
	}
	
	public AdvogadoProcessoBean consultar(int nrProcesso, int cdPessoaAdvogado){
		OracleAdvogadoProcessoDAO dao = (OracleAdvogadoProcessoDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getAdvogadoProcessoDAO();
		return dao.consultar(nrProcesso, cdPessoaAdvogado);
	}
	
	public List<AdvogadoProcessoBean> listar(int nrProcesso){
		OracleAdvogadoProcessoDAO dao = (OracleAdvogadoProcessoDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getAdvogadoProcessoDAO();
		return dao.listar(nrProcesso);
	}

}
