package br.com.advocacialca.negocio;

import java.util.List;

import br.com.advocacialca.beans.AdvogadoHonorarioBean;
import br.com.advocacialca.beans.ProcessoBean;
import br.com.advocacialca.beans.RespostaCRUD;
import br.com.advocacialca.factory.DAOFactory;
import br.com.advocacialca.jdbc.OracleAdvogadoHonorarioDAO;
import br.com.advocacialca.jdbc.OracleAdvogadoProcessoDAO;

public class AdvogadoHonorarioBO {
	
	public RespostaCRUD cadastrar(AdvogadoHonorarioBean advogadoHonorarioBean) {
		
		RespostaCRUD resp = null;
		
		HistBloqDesbloqBO histBO = new HistBloqDesbloqBO();
		
		ProcessoBean processoBean = advogadoHonorarioBean.getProcesso();
		
		boolean processoBloqueado = histBO.verificarProcessoEstaBloqueado(processoBean);
		
		if (processoBloqueado) {
			resp = new RespostaCRUD(false, "O processo " + processoBean.getNrProcesso() + " se encontra bloqueado.");
		} else {
			OracleAdvogadoHonorarioDAO dao = (OracleAdvogadoHonorarioDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getAdvogadoHonorarioDAO();
			return dao.cadastrar(advogadoHonorarioBean);
		}
		
		return resp;
	}
	
	public void atualizar(AdvogadoHonorarioBean tipoCobrancaBean)
	{
		OracleAdvogadoHonorarioDAO dao = (OracleAdvogadoHonorarioDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getAdvogadoHonorarioDAO();
		dao.atualizar(tipoCobrancaBean);		
	}
	
	public void remover(int idProcesso)
	{
		OracleAdvogadoHonorarioDAO dao = (OracleAdvogadoHonorarioDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getAdvogadoHonorarioDAO();
		dao.remover(idProcesso);		
	}
	
	public AdvogadoHonorarioBean consultar(int idProcesso)
	{
		OracleAdvogadoHonorarioDAO dao = (OracleAdvogadoHonorarioDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getAdvogadoHonorarioDAO();
		return dao.consultar(idProcesso);
	}
	
	public List<AdvogadoHonorarioBean> listar(int idAdvogado)
	{
		OracleAdvogadoHonorarioDAO dao = (OracleAdvogadoHonorarioDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getAdvogadoHonorarioDAO();
		return dao.listar(idAdvogado);
	}
	
}
