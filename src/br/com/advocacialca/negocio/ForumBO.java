package br.com.advocacialca.negocio;

import java.util.List;

import br.com.advocacialca.beans.ForumBean;
import br.com.advocacialca.factory.DAOFactory;
import br.com.advocacialca.jdbc.OracleForumDAO;

public class ForumBO {
	
	public ForumBean consultar(int cdPessoaForum){
		
		OracleForumDAO dao = (OracleForumDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getForumDAO();
		
		return dao.consultar(cdPessoaForum);
	}
	
	public void cadastrar(ForumBean forumbean){
		
		OracleForumDAO dao = (OracleForumDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getForumDAO();
		
		dao.cadastrar(forumbean);		
		
	}
	
	public void atualizar(ForumBean forumbean){
		
		OracleForumDAO dao = (OracleForumDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getForumDAO();
		
		dao.atualizar(forumbean);
		
	}
	
	public void remover(int cdPessoaForum){
		
		OracleForumDAO dao = (OracleForumDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getForumDAO();
		
		dao.remover(cdPessoaForum);
		
	}
	
	public List<ForumBean> listar(){
		
		OracleForumDAO dao = (OracleForumDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getForumDAO();
		
		return dao.listar();
		
	}

}
