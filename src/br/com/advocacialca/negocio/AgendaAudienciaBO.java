package br.com.advocacialca.negocio;

import java.util.List;

import br.com.advocacialca.beans.AgendaAudienciaBean;
import br.com.advocacialca.factory.DAOFactory;
import br.com.advocacialca.jdbc.OracleAgendaAudienciaDAO;

public class AgendaAudienciaBO {
	
	public void cadastrar(AgendaAudienciaBean agendaAudienciaBean)
	{
		OracleAgendaAudienciaDAO dao = (OracleAgendaAudienciaDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getAgendaAudienciaDAO();
		dao.cadastrar(agendaAudienciaBean);
	}
	
	public void atualizar(AgendaAudienciaBean agendaAudienciaBean)
	{
		OracleAgendaAudienciaDAO dao = (OracleAgendaAudienciaDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getAgendaAudienciaDAO();
		dao.atualizar(agendaAudienciaBean);		
	}
	
	public void remover(int idAgendaAudiencia)
	{
		OracleAgendaAudienciaDAO dao = (OracleAgendaAudienciaDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getAgendaAudienciaDAO();
		dao.remover(idAgendaAudiencia);		
	}
	
	public AgendaAudienciaBean consultar(int idAgendaAudiencia)
	{
		OracleAgendaAudienciaDAO dao = (OracleAgendaAudienciaDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getAgendaAudienciaDAO();
		return dao.consultar(idAgendaAudiencia);
	}
	
	public List<AgendaAudienciaBean> listar()
	{
		OracleAgendaAudienciaDAO dao = (OracleAgendaAudienciaDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getAgendaAudienciaDAO();
		return dao.listar();
	}
	
}
