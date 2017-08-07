package br.com.advocacialca.negocio;

import java.util.List;

import br.com.advocacialca.beans.TarefaBean;
import br.com.advocacialca.factory.DAOFactory;
import br.com.advocacialca.jdbc.OracleTarefaDAO;

public class TarefaBO {
	
	public TarefaBean consultar(int cdTarefa)
	{
		OracleTarefaDAO dao = (OracleTarefaDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getTarefaDAO();
		return dao.consultar(cdTarefa);
	}
	
	public void cadastrar(TarefaBean tarefaBean)
	{
		OracleTarefaDAO dao = (OracleTarefaDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getTarefaDAO();
		dao.cadastrar(tarefaBean);
	}
	
	public void atualizar(TarefaBean tarefaBean)
	{
		OracleTarefaDAO dao = (OracleTarefaDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getTarefaDAO();
		dao.atualizar(tarefaBean);		
	}
	
	public void remover(int cdTarefa)
	{
		OracleTarefaDAO dao = (OracleTarefaDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getTarefaDAO();
		dao.remover(cdTarefa);		
	}
	
	public List<TarefaBean> listar(){
		
		OracleTarefaDAO dao = (OracleTarefaDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getTarefaDAO();
		
		return dao.listar();
		
	}
	

}
