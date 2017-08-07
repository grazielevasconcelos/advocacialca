package br.com.advocacialca.negocio;

import java.sql.Date;
import java.util.List;

import br.com.advocacialca.beans.HistBloqDesbloqBean;
import br.com.advocacialca.beans.ProcessoBean;
import br.com.advocacialca.beans.RespostaCRUD;
import br.com.advocacialca.factory.DAOFactory;
import br.com.advocacialca.factory.DAOFactory.TipoBD;
import br.com.advocacialca.jdbc.OracleHistBloqDesbloqDAO;

public class HistBloqDesbloqBO {
	
	public RespostaCRUD cadastrar(HistBloqDesbloqBean hisBloDesbloqBean) {
		OracleHistBloqDesbloqDAO dao = (OracleHistBloqDesbloqDAO) DAOFactory.getDAOFactory(TipoBD.ORACLE).getHistBloqDesbloqDAO();
		return dao.cadastrar(hisBloDesbloqBean);
	}
	
	public void atualizar(HistBloqDesbloqBean hisBloDesbloqBean) {
		OracleHistBloqDesbloqDAO dao = (OracleHistBloqDesbloqDAO) DAOFactory.getDAOFactory(TipoBD.ORACLE).getHistBloqDesbloqDAO();
		dao.atualizar(hisBloDesbloqBean);
	}
	
	public void remover(ProcessoBean processo, Date dtBloqueioDesbloq) {
		OracleHistBloqDesbloqDAO dao = (OracleHistBloqDesbloqDAO) DAOFactory.getDAOFactory(TipoBD.ORACLE).getHistBloqDesbloqDAO();
		dao.remover(processo, dtBloqueioDesbloq);
	}
	
	public HistBloqDesbloqBean consultar(ProcessoBean processo,Date dtBloqueioDesbloq) {
		OracleHistBloqDesbloqDAO dao = (OracleHistBloqDesbloqDAO) DAOFactory.getDAOFactory(TipoBD.ORACLE).getHistBloqDesbloqDAO();
		return dao.consultar(processo, dtBloqueioDesbloq);
	}
	
	public List<HistBloqDesbloqBean> listar() {
		OracleHistBloqDesbloqDAO dao = (OracleHistBloqDesbloqDAO) DAOFactory.getDAOFactory(TipoBD.ORACLE).getHistBloqDesbloqDAO();
		return dao.listar();
	}
	
	public HistBloqDesbloqBean consultarPorProcesso(ProcessoBean processo) {
		OracleHistBloqDesbloqDAO dao = (OracleHistBloqDesbloqDAO) DAOFactory.getDAOFactory(TipoBD.ORACLE).getHistBloqDesbloqDAO();
		return dao.consultarPorProcesso(processo);
	}
	
	public boolean verificarProcessoEstaBloqueado(ProcessoBean processo) {
		HistBloqDesbloqBean bloqDesblocBean = this.consultarPorProcesso(processo);
		return (bloqDesblocBean != null && bloqDesblocBean.getBloqueioDesbloq().getCdBloqDesbloq() == 1);
	}
	
}
