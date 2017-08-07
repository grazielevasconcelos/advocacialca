package br.com.advocacialca.negocio;

import java.util.List;

import br.com.advocacialca.beans.ClienteBean;
import br.com.advocacialca.beans.TelefoneBean;
import br.com.advocacialca.factory.DAOFactory;
import br.com.advocacialca.jdbc.OracleClienteDAO;

public class ClienteBO {
	public void cadastrar (ClienteBean cliBean){
		OracleClienteDAO dao = (OracleClienteDAO) DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getClienteDAO();
		dao.cadastrar(cliBean);
	}
	public void atualizar (ClienteBean cliBean){
		OracleClienteDAO dao = (OracleClienteDAO) DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getClienteDAO();
		dao.atualizar(cliBean);
	}
	public void remover (int cdCliente){
		OracleClienteDAO dao = (OracleClienteDAO) DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getClienteDAO();
		dao.remover(cdCliente);
	}
	public ClienteBean consultar (int cdCliente){
		OracleClienteDAO dao = (OracleClienteDAO) DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getClienteDAO();
		return dao.consultar(cdCliente);
	}
	public List<ClienteBean> listar(){
		OracleClienteDAO dao = (OracleClienteDAO) DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getClienteDAO();
		return dao.listar();
				
	}
	
	public List<TelefoneBean> obterTelefoneCliente(int idCliente){
		TelefoneBO telClienteBO = new TelefoneBO();
		return telClienteBO.listar(idCliente);
	}
}
