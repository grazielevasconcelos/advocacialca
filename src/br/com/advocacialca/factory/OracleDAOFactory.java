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
import br.com.advocacialca.jdbc.OracleAdvogadoDAO;
import br.com.advocacialca.jdbc.OracleAdvogadoHonorarioDAO;
import br.com.advocacialca.jdbc.OracleAdvogadoProcessoDAO;
import br.com.advocacialca.jdbc.OracleAgendaAudienciaDAO;
import br.com.advocacialca.jdbc.OracleAutenticacaoDAO;
import br.com.advocacialca.jdbc.OracleBloqueioDesbloqueioDAO;
import br.com.advocacialca.jdbc.OracleClienteDAO;
import br.com.advocacialca.jdbc.OracleForumDAO;
import br.com.advocacialca.jdbc.OracleHistBloqDesbloqDAO;
import br.com.advocacialca.jdbc.OracleHoraAdvogadoDAO;
import br.com.advocacialca.jdbc.OracleItemRelatorioAudienciasDAO;
import br.com.advocacialca.jdbc.OracleItemRelatorioHonorariosDAO;
import br.com.advocacialca.jdbc.OraclePessoaDAO;
import br.com.advocacialca.jdbc.OracleProcessoDAO;
import br.com.advocacialca.jdbc.OracleTarefaDAO;
import br.com.advocacialca.jdbc.OracleTelefoneDAO;
import br.com.advocacialca.jdbc.OracleTipoCausaDAO;
import br.com.advocacialca.jdbc.OracleTipoCobrancaDAO;
import br.com.advocacialca.jdbc.OracleTipoTelefoneDAO;
import br.com.advocacialca.jdbc.OracleTituloDAO;
import br.com.advocacialca.jdbc.OracleTituloPagoDAO;

public class OracleDAOFactory extends DAOFactory {
	
	public IProcessoDAO getProcessoDAO() {
		return new OracleProcessoDAO();
	}
	
	public ITarefaDAO getTarefaDAO() {
		return new OracleTarefaDAO();
	}

	public IForumDAO getForumDAO() {
		return new OracleForumDAO();
	}
	
	public ITipoCausaDAO getTipoCausaDAO() {
		return new OracleTipoCausaDAO();
	}

	public ITituloDAO getTituloDAO() {
		return new OracleTituloDAO();
	}
	
	public IAgendaAudienciaDAO getAgendaAudienciaDAO() {
		return new OracleAgendaAudienciaDAO();
	}
	
	public IAdvogadoDAO getAdvogadoDAO(){
		return new OracleAdvogadoDAO();
	}
	
	public IClienteDAO getClienteDAO(){
		return new OracleClienteDAO();
	}
	
	public IHoraAdvogadoDAO getHoraAdvogadoDAO() {
		return new OracleHoraAdvogadoDAO();
	}

	public ITituloPagoDAO getTituloPagoDAO() {
		return new OracleTituloPagoDAO();
	}

	public ITipoCobrancaDAO getTipoCobrancaDAO() {
		return new OracleTipoCobrancaDAO();
	}
	
	public IBloqueioDesbloqueioDAO getBloqueioDesbloqueioDAO(){
		return new OracleBloqueioDesbloqueioDAO();
	}

	public ITipoTelefoneDAO getTipoTelefoneDAO() {
		return new OracleTipoTelefoneDAO();
	}
	
	public ITelefoneDAO getTelefoneDAO() {
		return new OracleTelefoneDAO();
	}
	
	public IPessoaDAO getPessoaDAO() {
		return new OraclePessoaDAO();
	}

	public IHistBloqDesbloqDAO getHistBloqDesbloqDAO() {
		return new OracleHistBloqDesbloqDAO();
	}
	
	public IItemRelatorioHonorariosDAO getItemRelatorioHonorariosDAO() {
		return new OracleItemRelatorioHonorariosDAO();
	}
	
	public IItemRelatorioAudienciasDAO getItemRelatorioAudienciasDAO() {
		return new OracleItemRelatorioAudienciasDAO();
	}

	public IAdvogadoHonorarioDAO getAdvogadoHonorarioDAO() {
		return new OracleAdvogadoHonorarioDAO();
	}

	public IAutenticacaoDAO getAutenticacaoDAO() {
		return new OracleAutenticacaoDAO();
	}
	
	public IAdvogadoProcessoDAO getAdvogadoProcessoDAO() {
		return new OracleAdvogadoProcessoDAO();
	}
}
