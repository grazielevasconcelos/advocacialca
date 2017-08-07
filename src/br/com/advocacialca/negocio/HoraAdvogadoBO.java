package br.com.advocacialca.negocio;

import java.util.List;

import br.com.advocacialca.beans.HoraAdvogadoBean;
import br.com.advocacialca.factory.DAOFactory;
import br.com.advocacialca.factory.DAOFactory.TipoBD;
import br.com.advocacialca.jdbc.OracleHoraAdvogadoDAO;

public class HoraAdvogadoBO {

	public void cadastrar(HoraAdvogadoBean hrAdvBean){
		if(hrAdvBean.getVlHora() > 35){
			
		
		OracleHoraAdvogadoDAO dao = (OracleHoraAdvogadoDAO) DAOFactory.getDAOFactory(TipoBD.ORACLE).getHoraAdvogadoDAO();
		dao.cadastrar(hrAdvBean);
		}
	}
	public void atualizar(HoraAdvogadoBean hrAdvBean) {
		if(hrAdvBean.getVlHora() > 35){
		OracleHoraAdvogadoDAO dao = (OracleHoraAdvogadoDAO) DAOFactory.getDAOFactory(TipoBD.ORACLE).getHoraAdvogadoDAO();
		dao.atualizar(hrAdvBean);
		}
	}

	public void remover(int cdHistorico) {
		OracleHoraAdvogadoDAO dao = (OracleHoraAdvogadoDAO) DAOFactory.getDAOFactory(TipoBD.ORACLE).getHoraAdvogadoDAO();
		dao.remover(cdHistorico);
	}

	public HoraAdvogadoBean consultar(int cdHistorico) {
		OracleHoraAdvogadoDAO dao = (OracleHoraAdvogadoDAO) DAOFactory.getDAOFactory(TipoBD.ORACLE).getHoraAdvogadoDAO();
		return dao.consultar(cdHistorico);
	}

	public List<HoraAdvogadoBean> listar() {
		OracleHoraAdvogadoDAO dao = (OracleHoraAdvogadoDAO) DAOFactory.getDAOFactory(TipoBD.ORACLE).getHoraAdvogadoDAO();
		return dao.listar();
	}
	
	
	
}
