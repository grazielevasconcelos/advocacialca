package br.com.advocacialca.negocio;

import java.util.List;


import br.com.advocacialca.beans.TipoTelefoneBean;
import br.com.advocacialca.factory.DAOFactory;
import br.com.advocacialca.jdbc.OracleTipoTelefoneDAO;


public class TipoTelefoneBO {

	public void cadastrar(TipoTelefoneBean tipoTelefoneBean)
	{
		OracleTipoTelefoneDAO dao = (OracleTipoTelefoneDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getTipoTelefoneDAO();
		dao.cadastrar(tipoTelefoneBean);
	}
	
	public void atualizar(TipoTelefoneBean tipoTelefoneBean)
	{
		OracleTipoTelefoneDAO dao = (OracleTipoTelefoneDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getTipoTelefoneDAO();
		dao.atualizar(tipoTelefoneBean);		
	}
	
	public void remover(int cdTipoTelefone)
	{
		OracleTipoTelefoneDAO dao = (OracleTipoTelefoneDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getTipoTelefoneDAO();
		dao.remover(cdTipoTelefone);		
	}
	
	public TipoTelefoneBean consultar(int cdTipoTelefone)
	{
		OracleTipoTelefoneDAO dao = (OracleTipoTelefoneDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getTipoTelefoneDAO();
		return dao.consultar(cdTipoTelefone);
	}
	
	public List<TipoTelefoneBean> listar()
	{
		OracleTipoTelefoneDAO dao = (OracleTipoTelefoneDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getTipoTelefoneDAO();
		return dao.listar();
	}
	
}