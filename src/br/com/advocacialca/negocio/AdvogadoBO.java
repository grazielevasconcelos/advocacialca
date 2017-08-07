package br.com.advocacialca.negocio;

import java.util.List;

import br.com.advocacialca.beans.AdvogadoBean;
import br.com.advocacialca.factory.DAOFactory;
import br.com.advocacialca.jdbc.OracleAdvogadoDAO;

/**
 * Classe de neg�cio de um Advogado
 * @version 1.0
 * @author Pixel
 */

public class AdvogadoBO {
	
	//M�todos da classe
	
	 /**
	  *  M�todo para cadastrar um Advogado
	  *  @param AdvogadoBean C�digo do advogado
	  */
		
	public void cadastrar (AdvogadoBean advBean){
		OracleAdvogadoDAO dao = (OracleAdvogadoDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getAdvogadoDAO();
		dao.cadastrar(advBean);
	}
	
	 /**
	  *  M�todo para alterar um Advogado
	  *  @param AdvogadoBean C�digo do advogado
	  */
	
	public void atualizar (AdvogadoBean advBean){
		OracleAdvogadoDAO dao = (OracleAdvogadoDAO) DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getAdvogadoDAO();
		dao.atualizar(advBean);
	}
	
	 /**
	  *  M�todo para remover um Advogado
	  *  @param cdAdvogado C�digo do advogado
	  */
	
	public void remover (int cdAdvogado){
		OracleAdvogadoDAO dao = (OracleAdvogadoDAO) DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getAdvogadoDAO();
		dao.remover(cdAdvogado);
	}
	
	 /**
	  *  M�todo para consultar um Advogado
	  *  @param cdAdvogado C�digo do advogado
	  *  @return cdAdvogado Informa��es do advogado  
	  */
	
	public AdvogadoBean consultar(int cdAdvogado){
		OracleAdvogadoDAO dao = (OracleAdvogadoDAO) DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getAdvogadoDAO();
		return dao.consultar(cdAdvogado);
	}
	
	 /**
	  *  M�todo para listar o(s) Advogado(s)
	  *  @param AdvogadoBean C�digo do Advogado
	  *  @return List<AdvogadoBean> Lista de advogados
	  */
	
	public List<AdvogadoBean> listar(){
		OracleAdvogadoDAO dao = (OracleAdvogadoDAO) DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getAdvogadoDAO();
		return dao.listar();
	}
	
	 /**
	  *  M�todo para listar o(s) Advogado(s) por processo
	  *  @param nrProcesso C�digo do processo
	  *  @return List<AdvogadoBean> Lista do(s) advogado(s) por processo
	  */
	
	public List<AdvogadoBean> listarPorProcesso(int nrProcesso){
		OracleAdvogadoDAO dao = (OracleAdvogadoDAO) DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getAdvogadoDAO();
		return dao.listarPorProcesso(nrProcesso);
	}
	
	public List<AdvogadoBean> obterPossiveisNovosAdvogados(int nrProcesso){
		OracleAdvogadoDAO dao = (OracleAdvogadoDAO) DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getAdvogadoDAO();
		return dao.obterPossiveisNovosAdvogados(nrProcesso);
	
	}
	
}
