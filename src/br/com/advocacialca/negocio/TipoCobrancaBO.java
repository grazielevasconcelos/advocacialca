package br.com.advocacialca.negocio;

import java.util.List;

import br.com.advocacialca.beans.TipoCobrancaBean;
import br.com.advocacialca.factory.DAOFactory;
import br.com.advocacialca.jdbc.OracleTipoCobrancaDAO;

public class TipoCobrancaBO {
	
	public void cadastrar(TipoCobrancaBean tipoCobrancaBean)
	{
		OracleTipoCobrancaDAO dao = (OracleTipoCobrancaDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getTipoCobrancaDAO();
		dao.cadastrar(tipoCobrancaBean);
	}
	
	public void atualizar(TipoCobrancaBean tipoCobrancaBean)
	{
		OracleTipoCobrancaDAO dao = (OracleTipoCobrancaDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getTipoCobrancaDAO();
		dao.atualizar(tipoCobrancaBean);		
	}
	
	public void remover(int idProcesso)
	{
		OracleTipoCobrancaDAO dao = (OracleTipoCobrancaDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getTipoCobrancaDAO();
		dao.remover(idProcesso);		
	}
	
	public TipoCobrancaBean consultar(int idProcesso)
	{
		OracleTipoCobrancaDAO dao = (OracleTipoCobrancaDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getTipoCobrancaDAO();
		return dao.consultar(idProcesso);
	}
	
	public List<TipoCobrancaBean> listar()
	{
		OracleTipoCobrancaDAO dao = (OracleTipoCobrancaDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getTipoCobrancaDAO();
		return dao.listar();
	}

	
}
