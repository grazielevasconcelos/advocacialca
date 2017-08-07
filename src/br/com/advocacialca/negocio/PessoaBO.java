package br.com.advocacialca.negocio;

import java.util.List;

import br.com.advocacialca.beans.PessoaBean;
import br.com.advocacialca.factory.DAOFactory;
import br.com.advocacialca.jdbc.OraclePessoaDAO;

public class PessoaBO {
	public void cadastrar (PessoaBean pesBean){
		OraclePessoaDAO dao = (OraclePessoaDAO) DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getPessoaDAO();
		dao.cadastrar(pesBean);
	}
	public void atualizar (PessoaBean pesBean){
		OraclePessoaDAO dao = (OraclePessoaDAO) DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getPessoaDAO();
		dao.atualizar(pesBean);
	}
	public void remover (int cdPessoa){
		OraclePessoaDAO dao = (OraclePessoaDAO) DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getPessoaDAO();
		dao.remover(cdPessoa);
	}
	public PessoaBean consultar (int cdPessoa){
		OraclePessoaDAO dao = (OraclePessoaDAO) DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getPessoaDAO();
		return dao.consultar(cdPessoa);
	}
	public List<PessoaBean> listar(){
		OraclePessoaDAO dao = (OraclePessoaDAO) DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getPessoaDAO();
		return dao.listar();
				
	}
}
