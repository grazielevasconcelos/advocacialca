package br.com.advocacialca.negocio;

import java.util.List;

import br.com.advocacialca.beans.ProcessoBean;
import br.com.advocacialca.beans.RespostaCRUD;
import br.com.advocacialca.factory.DAOFactory;
import br.com.advocacialca.jdbc.OracleProcessoDAO;

public class ProcessoBO {

	public RespostaCRUD cadastrar(ProcessoBean processoBean)
	{
		RespostaCRUD resp = null;
		ProcessoBO processoBO = new ProcessoBO();
		
		ProcessoBean pb = processoBO.consultar(processoBean.getNrProcesso());

		if (pb == null) {
		
			OracleProcessoDAO dao = (OracleProcessoDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getProcessoDAO();
			resp = dao.cadastrar(processoBean);
		
		} else {
			
			String mensagem = "O processo de nœmero " + processoBean.getNrProcesso() + " j‡ foi cadastrado.";
			
			resp = new RespostaCRUD(false, mensagem);
		}
		
		return resp;
		
	}
	
	public RespostaCRUD atualizar(ProcessoBean processoBean) {
		
		RespostaCRUD resp = null;
		
		HistBloqDesbloqBO histBO = new HistBloqDesbloqBO();
		
		boolean processoBloqueado = histBO.verificarProcessoEstaBloqueado(processoBean);
		
		if (processoBloqueado) {
			resp = new RespostaCRUD(false, "O processo " + processoBean.getNrProcesso() + " se encontra bloqueado.");
		} else {
			OracleProcessoDAO dao = (OracleProcessoDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getProcessoDAO();
			resp = dao.atualizar(processoBean);
		}
		
		return resp;
	}
	
	public void remover(int idProcesso)
	{
		OracleProcessoDAO dao = (OracleProcessoDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getProcessoDAO();
		dao.remover(idProcesso);		
	}
	
	public ProcessoBean consultar(int idProcesso)
	{
		OracleProcessoDAO dao = (OracleProcessoDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getProcessoDAO();
		return dao.consultar(idProcesso);
	}
	
	public List<ProcessoBean> listar(int idCliente)
	{
		OracleProcessoDAO dao = (OracleProcessoDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getProcessoDAO();
		return dao.listar(idCliente);
	}
	
	public List<ProcessoBean> listarPorAdvogado(int idAdvogado)
	{
		OracleProcessoDAO dao = (OracleProcessoDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getProcessoDAO();
		return dao.listarPorAdvogado(idAdvogado);
	}
	
}
