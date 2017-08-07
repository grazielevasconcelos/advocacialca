package br.com.advocacialca.negocio;

import br.com.advocacialca.beans.AdvogadoBean;
import br.com.advocacialca.beans.PessoaBean;
import br.com.advocacialca.factory.DAOFactory;
import br.com.advocacialca.jdbc.OracleAutenticacaoDAO;

public class AutenticacaoBO {

	public PessoaBean logarSecretaria(String login, String senha)
	{
		OracleAutenticacaoDAO dao = (OracleAutenticacaoDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getAutenticacaoDAO();
		return dao.logarSecretaria(login, senha);
	}

	public AdvogadoBean logarAdvogado(String login, String senha)
	{
		OracleAutenticacaoDAO dao = (OracleAutenticacaoDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getAutenticacaoDAO();
		return dao.logarAdvogado(login, senha);
	}
	
}