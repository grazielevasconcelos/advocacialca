package br.com.advocacialca.negocio;

import java.util.List;

import br.com.advocacialca.beans.AdvogadoBean;
import br.com.advocacialca.factory.DAOFactory;
import br.com.advocacialca.jdbc.OracleAdvogadoDAO;

/**
 * Classe de negócio de um Advogado
 * @version 1.0
 * @author Pixel
 */

public class AdvogadoBO {
	
	//Métodos da classe
	
	 /**
	  *  Método para cadastrar um Advogado
	  *  @param AdvogadoBean Código do advogado
	  */
		
	public void cadastrar (AdvogadoBean advBean){
		OracleAdvogadoDAO dao = (OracleAdvogadoDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getAdvogadoDAO();
		dao.cadastrar(advBean);
	}
	
	 /**
	  *  Método para alterar um Advogado
	  *  @param AdvogadoBean Código do advogado
	  */
	
	public void atualizar (AdvogadoBean advBean){
		OracleAdvogadoDAO dao = (OracleAdvogadoDAO) DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getAdvogadoDAO();
		dao.atualizar(advBean);
	}
	
	 /**
	  *  Método para remover um Advogado
	  *  @param cdAdvogado Código do advogado
	  */
	
	public void remover (int cdAdvogado){
		OracleAdvogadoDAO dao = (OracleAdvogadoDAO) DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getAdvogadoDAO();
		dao.remover(cdAdvogado);
	}
	
	 /**
	  *  Método para consultar um Advogado
	  *  @param cdAdvogado Código do advogado
	  *  @return cdAdvogado Informações do advogado  
	  */
	
	public AdvogadoBean consultar(int cdAdvogado){
		OracleAdvogadoDAO dao = (OracleAdvogadoDAO) DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getAdvogadoDAO();
		return dao.consultar(cdAdvogado);
	}
	
	 /**
	  *  Método para listar o(s) Advogado(s)
	  *  @param AdvogadoBean Código do Advogado
	  *  @return List<AdvogadoBean> Lista de advogados
	  */
	
	public List<AdvogadoBean> listar(){
		OracleAdvogadoDAO dao = (OracleAdvogadoDAO) DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getAdvogadoDAO();
		return dao.listar();
	}
	
	 /**
	  *  Método para listar o(s) Advogado(s) por processo
	  *  @param nrProcesso Código do processo
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
