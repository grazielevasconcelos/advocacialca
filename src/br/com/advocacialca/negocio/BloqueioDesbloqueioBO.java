package br.com.advocacialca.negocio;

import java.util.List;

import br.com.advocacialca.beans.BloqueioDesbloqueioBean;
import br.com.advocacialca.factory.DAOFactory;
import br.com.advocacialca.jdbc.OracleBloqueioDesbloqueioDAO;

public class BloqueioDesbloqueioBO {
	public void cadastrar(BloqueioDesbloqueioBean bloqDesbloqBean) {
		OracleBloqueioDesbloqueioDAO dao = (OracleBloqueioDesbloqueioDAO) DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getBloqueioDesbloqueioDAO();
		dao.cadastrar(bloqDesbloqBean);
	}
	public void atualizar(BloqueioDesbloqueioBean bloqDesbloqBean) {
		OracleBloqueioDesbloqueioDAO dao = (OracleBloqueioDesbloqueioDAO) DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getBloqueioDesbloqueioDAO();
		dao.atualizar(bloqDesbloqBean);

	}
	public void remover(long cdBloqDesbloq) {
		OracleBloqueioDesbloqueioDAO dao = (OracleBloqueioDesbloqueioDAO) DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getBloqueioDesbloqueioDAO();
		dao.remover(cdBloqDesbloq);
	}
	public BloqueioDesbloqueioBean consultar(long cdBloqDesbloq) {
		OracleBloqueioDesbloqueioDAO dao = (OracleBloqueioDesbloqueioDAO) DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getBloqueioDesbloqueioDAO();
		return dao.consultar(cdBloqDesbloq);
	}
	public List<BloqueioDesbloqueioBean> listar() {
		OracleBloqueioDesbloqueioDAO dao = (OracleBloqueioDesbloqueioDAO) DAOFactory.getDAOFactory(DAOFactory.TipoBD.ORACLE).getBloqueioDesbloqueioDAO();
		return dao.listar();
	}

}