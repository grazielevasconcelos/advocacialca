package br.com.advocacialca.negocio;

import java.util.List;

import br.com.advocacialca.beans.TipoCausaBean;
import br.com.advocacialca.factory.DAOFactory;
import br.com.advocacialca.jdbc.OracleTipoCausaDAO;

public class TipoCausaBO {

	public void cadastrar(TipoCausaBean tipoCausaBean)
	{
		OracleTipoCausaDAO dao = (OracleTipoCausaDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getTipoCausaDAO();
		dao.cadastrar(tipoCausaBean);
	}
	
	public void atualizar(TipoCausaBean tipoCausaBean)
	{
		OracleTipoCausaDAO dao = (OracleTipoCausaDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getTipoCausaDAO();
		dao.atualizar(tipoCausaBean);		
	}
	
	public void remover(int idTipoCausa)
	{
		OracleTipoCausaDAO dao = (OracleTipoCausaDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getTipoCausaDAO();
		dao.remover(idTipoCausa);		
	}
	
	public TipoCausaBean consultar(int idTipoCausa)
	{
		OracleTipoCausaDAO dao = (OracleTipoCausaDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getTipoCausaDAO();
		return dao.consultar(idTipoCausa);
	}
	
	public List<TipoCausaBean> listar()
	{
		OracleTipoCausaDAO dao = (OracleTipoCausaDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getTipoCausaDAO();
		return dao.listar();
	}
	
}