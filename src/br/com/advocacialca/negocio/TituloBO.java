package br.com.advocacialca.negocio;

import java.util.List;

import br.com.advocacialca.beans.TituloBean;
import br.com.advocacialca.factory.DAOFactory;
import br.com.advocacialca.jdbc.OracleTituloDAO;

public class TituloBO {

	public void cadastrar(TituloBean tituloBean)
	{
		OracleTituloDAO dao = (OracleTituloDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getTituloDAO();
		dao.cadastrar(tituloBean);
	}
	
	public void atualizar(TituloBean tituloBean)
	{
		OracleTituloDAO dao = (OracleTituloDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getTituloDAO();
		dao.atualizar(tituloBean);		
	}
	
	public void remover(int idTitulo)
	{
		OracleTituloDAO dao = (OracleTituloDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getTituloDAO();
		dao.remover(idTitulo);		
	}
	
	public TituloBean consultar(int idTitulo)
	{
		OracleTituloDAO dao = (OracleTituloDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getTituloDAO();
		return dao.consultar(idTitulo);
	}
	
	public List<TituloBean> listar(int nrProcesso)
	{
		OracleTituloDAO dao = (OracleTituloDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getTituloDAO();
		return dao.listar(nrProcesso);
	}
	
}
