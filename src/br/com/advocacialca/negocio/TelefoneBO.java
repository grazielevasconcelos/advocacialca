package br.com.advocacialca.negocio;

import java.util.List;

import br.com.advocacialca.beans.TelefoneBean;
import br.com.advocacialca.factory.DAOFactory;
import br.com.advocacialca.jdbc.OracleTelefoneDAO;

public class TelefoneBO {
	
	//consultar, cadastrar, atualizar, remover, listar
	
	public TelefoneBean consultar(long cdTelefone){
		OracleTelefoneDAO dao = (OracleTelefoneDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getTelefoneDAO();
		return dao.consultar(cdTelefone);
	}
	
	public void cadastrar(TelefoneBean telefoneBean){
		OracleTelefoneDAO dao = (OracleTelefoneDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getTelefoneDAO();
		dao.cadastrar(telefoneBean);
	}
	
	public void atualizar(TelefoneBean telefoneBean){
		OracleTelefoneDAO dao = (OracleTelefoneDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getTelefoneDAO();
		dao.atualizar(telefoneBean);
	}
	
	public void remover(long cdTelefone){
		OracleTelefoneDAO dao = (OracleTelefoneDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getTelefoneDAO();
		dao.remover(cdTelefone);
	}
	
	public List<TelefoneBean> listar(int idCliente){
		OracleTelefoneDAO dao = (OracleTelefoneDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getTelefoneDAO();
		return dao.listar(idCliente);
	}

}
