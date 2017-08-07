package br.com.advocacialca.factory;

import br.com.advocacialca.interfaces.IAdvogadoDAO;
import br.com.advocacialca.interfaces.IAdvogadoHonorarioDAO;
import br.com.advocacialca.interfaces.IAdvogadoProcessoDAO;
import br.com.advocacialca.interfaces.IAgendaAudienciaDAO;
import br.com.advocacialca.interfaces.IAutenticacaoDAO;
import br.com.advocacialca.interfaces.IBloqueioDesbloqueioDAO;
import br.com.advocacialca.interfaces.IClienteDAO;
import br.com.advocacialca.interfaces.IForumDAO;
import br.com.advocacialca.interfaces.IHistBloqDesbloqDAO;
import br.com.advocacialca.interfaces.IHoraAdvogadoDAO;
import br.com.advocacialca.interfaces.IItemRelatorioAudienciasDAO;
import br.com.advocacialca.interfaces.IItemRelatorioHonorariosDAO;
import br.com.advocacialca.interfaces.IPessoaDAO;
import br.com.advocacialca.interfaces.IProcessoDAO;
import br.com.advocacialca.interfaces.ITarefaDAO;
import br.com.advocacialca.interfaces.ITelefoneDAO;
import br.com.advocacialca.interfaces.ITipoCausaDAO;
import br.com.advocacialca.interfaces.ITipoCobrancaDAO;
import br.com.advocacialca.interfaces.ITipoTelefoneDAO;
import br.com.advocacialca.interfaces.ITituloDAO;
import br.com.advocacialca.interfaces.ITituloPagoDAO;

public abstract class DAOFactory {
	
	public static enum TipoBD {ORACLE}
	private static DAOFactory oracleDAOFactory = null;
	
	public static DAOFactory getDAOFactory(TipoBD db){
		
		switch (db) {
			case ORACLE:
				if(oracleDAOFactory == null)
					oracleDAOFactory = new OracleDAOFactory();
				return oracleDAOFactory;
			
			default:
				return null;
		}
		
	}
	
	public abstract IProcessoDAO getProcessoDAO();
	public abstract ITarefaDAO getTarefaDAO();
	public abstract IForumDAO getForumDAO();
	public abstract ITipoCausaDAO getTipoCausaDAO();
	public abstract ITituloDAO getTituloDAO();
	public abstract IAgendaAudienciaDAO getAgendaAudienciaDAO();
	public abstract IAdvogadoDAO getAdvogadoDAO();
	public abstract IClienteDAO getClienteDAO();
	public abstract IHoraAdvogadoDAO getHoraAdvogadoDAO();
	public abstract ITituloPagoDAO getTituloPagoDAO();
	public abstract IBloqueioDesbloqueioDAO getBloqueioDesbloqueioDAO();
	public abstract ITipoCobrancaDAO getTipoCobrancaDAO();
	public abstract IAdvogadoHonorarioDAO getAdvogadoHonorarioDAO();
	public abstract ITipoTelefoneDAO getTipoTelefoneDAO();
	public abstract ITelefoneDAO getTelefoneDAO();
	public abstract IPessoaDAO getPessoaDAO();
	public abstract IHistBloqDesbloqDAO getHistBloqDesbloqDAO();
	public abstract IItemRelatorioHonorariosDAO getItemRelatorioHonorariosDAO();
	public abstract IItemRelatorioAudienciasDAO getItemRelatorioAudienciasDAO();
	public abstract IAutenticacaoDAO getAutenticacaoDAO();
	public abstract IAdvogadoProcessoDAO getAdvogadoProcessoDAO();
}