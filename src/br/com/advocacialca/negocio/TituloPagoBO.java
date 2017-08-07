package br.com.advocacialca.negocio;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import br.com.advocacialca.beans.BloqueioDesbloqueioBean;
import br.com.advocacialca.beans.HistBloqDesbloqBean;
import br.com.advocacialca.beans.RespostaCRUD;
import br.com.advocacialca.beans.TituloPagoBean;
import br.com.advocacialca.factory.DAOFactory;
import br.com.advocacialca.jdbc.OracleTituloPagoDAO;

public class TituloPagoBO {
	
	public RespostaCRUD cadastrar(TituloPagoBean tituloPagoBean)
	{
		RespostaCRUD resp = null;
		
		OracleTituloPagoDAO dao = (OracleTituloPagoDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getTituloPagoDAO();
		resp = dao.cadastrar(tituloPagoBean); 
		
        HistBloqDesbloqBO histBloqDesbloqBO = new HistBloqDesbloqBO();
        
        HistBloqDesbloqBean historico = histBloqDesbloqBO.consultarPorProcesso(tituloPagoBean.getTitulo().getProcesso());
        
		if (historico != null && historico.getBloqueioDesbloq().getCdBloqDesbloq() == 1 ) {
		
			HistBloqDesbloqBean histBloqDesbloqBean = new HistBloqDesbloqBean();
			   
			BloqueioDesbloqueioBean bloqDesbloqBean = new BloqueioDesbloqueioBean();
			bloqDesbloqBean.setCdBloqDesbloq(2); //Desbloqueio.
			   
			Calendar cal = Calendar.getInstance();
			cal.set(2012, 10, 2); //Chumbado pra poder fazer o desbloqueio no mesmo dia... T‡ horr’vel, rs.
			   
			histBloqDesbloqBean.setProcesso(tituloPagoBean.getTitulo().getProcesso());
			histBloqDesbloqBean.setDtBloqueioDesbloq(cal);
			histBloqDesbloqBean.setBloqueioDesbloq(bloqDesbloqBean);
			   
			histBloqDesbloqBO.cadastrar(histBloqDesbloqBean);
		}
		
		return resp;
	}
	
	public void remover(int idProcesso, Date dataProcesso)
	{
		OracleTituloPagoDAO dao = (OracleTituloPagoDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getTituloPagoDAO();
		dao.remover(idProcesso, dataProcesso);		
	}
	
	public TituloPagoBean consultar(int idProcesso, Date dataProcesso)
	{
		OracleTituloPagoDAO dao = (OracleTituloPagoDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getTituloPagoDAO();
		return dao.consultar(idProcesso, dataProcesso);
	}
	
	public List<TituloPagoBean> listar()
	{
		OracleTituloPagoDAO dao = (OracleTituloPagoDAO)DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getTituloPagoDAO();
		return dao.listar();
	}
	
	
}
