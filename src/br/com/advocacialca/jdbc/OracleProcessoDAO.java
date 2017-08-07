package br.com.advocacialca.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.advocacialca.beans.ClienteBean;
import br.com.advocacialca.beans.ForumBean;
import br.com.advocacialca.beans.PessoaBean;
import br.com.advocacialca.beans.ProcessoBean;
import br.com.advocacialca.beans.RespostaCRUD;
import br.com.advocacialca.beans.TipoCausaBean;
import br.com.advocacialca.beans.TipoCobrancaBean;
import br.com.advocacialca.interfaces.IProcessoDAO;
import br.com.advocacialca.logs.Logs;

public class OracleProcessoDAO implements IProcessoDAO {
	
	public RespostaCRUD cadastrar(ProcessoBean processoBean) {
		
		RespostaCRUD resp = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO AM_PROCESSO (NR_Processo, CD_Pessoa_Forum, CD_Pessoa_Cliente, CD_Causa, CD_Cobranca, DS_Processo, DT_Abertura, DT_Fechamento, DD_Dia_Vencimento, DS_Observacao, CD_Resultado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			stmt = conn.prepareStatement(sql); 
			
			stmt.setInt(1, processoBean.getNrProcesso());
			stmt.setInt(2, processoBean.getForum().getPessoa().getCdPessoa());
			stmt.setInt(3, processoBean.getCliente().getPessoa().getCdPessoa());
			stmt.setInt(4, processoBean.getTipoCausa().getCdCausa());
			stmt.setInt(5, processoBean.getTipoCobranca().getCdCobranca());
			stmt.setString(6, String.valueOf(processoBean.getDsProcesso()));
			stmt.setDate(7, new java.sql.Date(processoBean.getDtAbertura().getTime().getTime()));
			stmt.setDate(8, new java.sql.Date(processoBean.getDtFechamento().getTime().getTime()));
			stmt.setInt(9, processoBean.getDdDiaVencimento());
			stmt.setString(10, String.valueOf(processoBean.getDsObservacao()));
			stmt.setInt(11, processoBean.getCdResultado());
			
			stmt.execute();
			
			conn.commit();
			conn.setAutoCommit(true);
			
			resp = new RespostaCRUD(true, "Processo cadastraro com sucesso.");
			
		} catch(Exception e) {
			
			resp = new RespostaCRUD(false, e.toString());
			
			Logs.logger.info("OracleProcessoDAO; public void cadastrar(ProcessoBean processoBean); " + e.toString());
			
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return resp;
	}

	public RespostaCRUD atualizar(ProcessoBean processoBean) {
		
		RespostaCRUD resp = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			
			String sql = "UPDATE AM_PROCESSO SET NR_Processo=?, CD_Pessoa_Forum=?, CD_Pessoa_Cliente=?, CD_Causa=?, CD_Cobranca=?, DS_Processo=?, DT_ABERTURA=?, DT_Fechamento=?, DD_Dia_Vencimento=?, CD_Resultado=?, DS_Observacao=? WHERE NR_Processo=?";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, processoBean.getNrProcesso());
			stmt.setInt(2, processoBean.getForum().getPessoa().getCdPessoa());
			stmt.setInt(3, processoBean.getCliente().getPessoa().getCdPessoa());
			stmt.setInt(4, processoBean.getTipoCausa().getCdCausa());
			stmt.setInt(5, processoBean.getTipoCobranca().getCdCobranca());
			stmt.setString(6, String.valueOf(processoBean.getDsProcesso()));
			stmt.setDate(7, new java.sql.Date(processoBean.getDtAbertura().getTime().getTime()));
			stmt.setDate(8, new java.sql.Date(processoBean.getDtFechamento().getTime().getTime()));
			stmt.setInt(9, processoBean.getDdDiaVencimento());
			stmt.setInt(10, processoBean.getCdResultado());
			stmt.setString(11, String.valueOf(processoBean.getDsObservacao()));
			stmt.setInt(12, processoBean.getNrProcesso());			
			
			stmt.execute();
			
			conn.commit();
			conn.setAutoCommit(true);
			
			resp = new RespostaCRUD(true, "Processo alterado com sucesso.");
			
		} catch (Exception e) {
			
			resp = new RespostaCRUD(false, e.toString());
			
			Logs.logger.info("OracleProcessoDAO; public void atualizar(ProcessoBean processoBean); " + e.toString());

			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			
			try {
				stmt.close();
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}

		return resp;
	}

	public void remover(int idProcesso) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			
			String sql = "DELETE FROM AM_PROCESSO WHERE NR_Processo = ?";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, idProcesso);
			
			stmt.execute();
			
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch(Exception e) {
			Logs.logger.info("OracleProcessoDAO; public void remover(int idProcesso); " + e.toString());
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			
			try {
				stmt.close();
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	public ProcessoBean consultar(int idProcesso) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ProcessoBean processoBean = null;
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			
			String sql = "SELECT" +
					" PROC.NR_Processo," +
					" PROC.CD_Pessoa_Forum," +
					" PROC.CD_Pessoa_Cliente," +
					" PROC.CD_Causa," +
					" PROC.CD_Cobranca," +
					" PROC.DS_Processo," +
					" PROC.DT_ABERTURA," +
					" PROC.DT_Fechamento," +
					" PROC.DD_Dia_Vencimento," +
					" PROC.CD_Resultado," +
					" PROC.DS_Observacao," +
					" FORUM.DS_FORUM," +
					" PESS_FORUM.NM_PESSOA NM_FORUM," +
					" PESS_CLIENTE.NM_PESSOA NM_CLIENTE," +
					" CLIENTE.NM_RAZAO_SOCIAL," +
					" CLIENTE.NR_CNPJ," +
					" CLIENTE.NR_INSC_ESTADUAL," +
					" CLIENTE.DS_EMAIL," +
					" CLIENTE.DS_PASSWORD," +
					" CAUSA.DS_CAUSA," +
					" COBR.DS_COBRANCA," +
					" COBR.TX_JUROS," +
					" COBR.VL_MORA_DIARIA" +
					" FROM" +
					" AM_PROCESSO PROC" +
					" INNER JOIN AM_FORUM FORUM" +
					" ON PROC.CD_Pessoa_Forum = FORUM.CD_Pessoa_Forum" +
					" INNER JOIN AM_PESSOA PESS_FORUM" +
					" ON FORUM.CD_Pessoa_Forum = PESS_FORUM.CD_Pessoa" +
					" INNER JOIN AM_PESSOA PESS_CLIENTE" +
					" ON PROC.CD_PESSOA_CLIENTE = PESS_CLIENTE.CD_PESSOA" +
					" INNER JOIN AM_CLIENTE CLIENTE" +
					" ON PROC.CD_PESSOA_CLIENTE = CLIENTE.CD_PESSOA_CLIENTE" +
					" INNER JOIN AM_TIPO_CAUSA CAUSA" +
					" ON PROC.CD_CAUSA = CAUSA.CD_CAUSA" +
					" INNER JOIN AM_TIPO_COBRANCA COBR" +
					" ON PROC.CD_COBRANCA = COBR.CD_COBRANCA" +
					" WHERE NR_PROCESSO = ?";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, idProcesso);
			
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				
				processoBean = new ProcessoBean();
				
				Calendar calAbertura = Calendar.getInstance();
				calAbertura.setTime(rs.getDate("DT_ABERTURA"));
				
				Calendar calFechamento = Calendar.getInstance();
				java.sql.Date dataFechamento = rs.getDate("DT_Fechamento");
				if (dataFechamento != null )
					calFechamento.setTime(dataFechamento);
				
				PessoaBean pessoaCliente = new PessoaBean();
				pessoaCliente.setCdPessoa(rs.getInt("CD_Pessoa_Cliente"));
				pessoaCliente.setNmPessoa(rs.getString("NM_CLIENTE"));
				
				ClienteBean cliente = new ClienteBean();
				cliente.setDsEmail(rs.getString("DS_EMAIL"));
				cliente.setDsPassword(rs.getString("DS_PASSWORD"));
				cliente.setNmRazaoSocial(rs.getString("NM_RAZAO_SOCIAL"));
				cliente.setNrCNPJ(rs.getLong("NR_CNPJ"));
				cliente.setNrInscEstadual(rs.getLong("NR_INSC_ESTADUAL"));
				cliente.setPessoa(pessoaCliente);
				
				PessoaBean forumPessoa = new PessoaBean();
				forumPessoa.setCdPessoa(rs.getInt("CD_Pessoa_Forum"));
				forumPessoa.setNmPessoa(rs.getString("NM_FORUM"));
				
				ForumBean forum = new ForumBean();
				forum.setDsForum(rs.getString("DS_FORUM"));
				forum.setPessoa(forumPessoa);
				
				TipoCausaBean tipoCausa = new TipoCausaBean();
				tipoCausa.setCdCausa(rs.getInt("CD_Causa"));
				tipoCausa.setDsCausa(rs.getString("DS_CAUSA"));
				
				TipoCobrancaBean tipoCobranca = new TipoCobrancaBean();
				tipoCobranca.setCdCobranca(rs.getInt("CD_Cobranca"));
				tipoCobranca.setDsCobranca(rs.getString("DS_COBRANCA"));
				tipoCobranca.setTxJuros(rs.getDouble("TX_JUROS"));
				tipoCobranca.setVlMoraDiaria(rs.getDouble("VL_MORA_DIARIA"));
				
				processoBean.setNrProcesso(idProcesso);
				processoBean.setForum(forum);
				processoBean.setCliente(cliente);
				processoBean.setTipoCausa(tipoCausa);
				processoBean.setTipoCobranca(tipoCobranca);
				processoBean.setDsProcesso(rs.getString("DS_Processo"));
				processoBean.setDtAbertura(calAbertura);
				processoBean.setDtFechamento(calFechamento);
				processoBean.setDdDiaVencimento(rs.getInt("DD_Dia_Vencimento"));
				processoBean.setCdResultado(rs.getInt("CD_Resultado"));
				processoBean.setDsObservacao(rs.getString("DS_Observacao"));
			}
			
		} catch(Exception e) {
			Logs.logger.info("OracleProcessoDAO; public ProcessoBean consultar(int idProcesso); " + e.toString());
			e.printStackTrace();
		} finally {
			
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return processoBean;
	}

	public List<ProcessoBean> listar(int idCliente) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<ProcessoBean> listaProcessoBean = null;
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			
			String sql = "SELECT" +
					" PROC.NR_Processo," +
					" PROC.CD_Pessoa_Forum," +
					" PROC.CD_Pessoa_Cliente," +
					" PROC.CD_Causa," +
					" PROC.CD_Cobranca," +
					" PROC.DS_Processo," +
					" PROC.DT_ABERTURA," +
					" PROC.DT_Fechamento," +
					" PROC.DD_Dia_Vencimento," +
					" PROC.CD_Resultado," +
					" PROC.DS_Observacao," +
					" FORUM.DS_FORUM," +
					" PESS_FORUM.NM_PESSOA NM_FORUM," +
					" PESS_CLIENTE.NM_PESSOA NM_CLIENTE," +
					" CLIENTE.NM_RAZAO_SOCIAL," +
					" CLIENTE.NR_CNPJ," +
					" CLIENTE.NR_INSC_ESTADUAL," +
					" CLIENTE.DS_EMAIL," +
					" CLIENTE.DS_PASSWORD," +
					" CAUSA.DS_CAUSA," +
					" COBR.DS_COBRANCA," +
					" COBR.TX_JUROS," +
					" COBR.VL_MORA_DIARIA" +
					" FROM" +
					" AM_PROCESSO PROC" +
					" INNER JOIN AM_FORUM FORUM" +
					" ON PROC.CD_Pessoa_Forum = FORUM.CD_Pessoa_Forum" +
					" INNER JOIN AM_PESSOA PESS_FORUM" +
					" ON FORUM.CD_Pessoa_Forum = PESS_FORUM.CD_Pessoa" +
					" INNER JOIN AM_PESSOA PESS_CLIENTE" +
					" ON PROC.CD_PESSOA_CLIENTE = PESS_CLIENTE.CD_PESSOA" +
					" INNER JOIN AM_CLIENTE CLIENTE" +
					" ON PROC.CD_PESSOA_CLIENTE = CLIENTE.CD_PESSOA_CLIENTE" +
					" INNER JOIN AM_TIPO_CAUSA CAUSA" +
					" ON PROC.CD_CAUSA = CAUSA.CD_CAUSA" +
					" INNER JOIN AM_TIPO_COBRANCA COBR" +
					" ON PROC.CD_COBRANCA = COBR.CD_COBRANCA" +
					" WHERE PROC.CD_Pessoa_Cliente = ?" +
					" ORDER BY PROC.NR_Processo";
			
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, idCliente);
			
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				if (listaProcessoBean == null)
					listaProcessoBean = new ArrayList<ProcessoBean>();
				
				ProcessoBean processoBean = new ProcessoBean(); 
				Calendar calAbertura = Calendar.getInstance();
				calAbertura.setTime(rs.getDate("DT_ABERTURA"));
				
				Calendar calFechamento = Calendar.getInstance();
				java.sql.Date dataFechamento = rs.getDate("DT_Fechamento");
				if (dataFechamento != null )
					calFechamento.setTime(dataFechamento);
				
				PessoaBean pessoaCliente = new PessoaBean();
				pessoaCliente.setCdPessoa(rs.getInt("CD_Pessoa_Cliente"));
				pessoaCliente.setNmPessoa(rs.getString("NM_CLIENTE"));
				
				ClienteBean cliente = new ClienteBean();
				cliente.setDsEmail(rs.getString("DS_EMAIL"));
				cliente.setDsPassword(rs.getString("DS_PASSWORD"));
				cliente.setNmRazaoSocial(rs.getString("NM_RAZAO_SOCIAL"));
				cliente.setNrCNPJ(rs.getLong("NR_CNPJ"));
				cliente.setNrInscEstadual(rs.getLong("NR_INSC_ESTADUAL"));
				cliente.setPessoa(pessoaCliente);
				
				PessoaBean forumPessoa = new PessoaBean();
				forumPessoa.setCdPessoa(rs.getInt("CD_Pessoa_Forum"));
				forumPessoa.setNmPessoa(rs.getString("NM_FORUM"));
				
				ForumBean forum = new ForumBean();
				forum.setDsForum(rs.getString("DS_FORUM"));
				forum.setPessoa(forumPessoa);
				
				TipoCausaBean tipoCausa = new TipoCausaBean();
				tipoCausa.setCdCausa(rs.getInt("CD_Causa"));
				tipoCausa.setDsCausa(rs.getString("DS_CAUSA"));
				
				TipoCobrancaBean tipoCobranca = new TipoCobrancaBean();
				tipoCobranca.setCdCobranca(rs.getInt("CD_Cobranca"));
				tipoCobranca.setDsCobranca(rs.getString("DS_COBRANCA"));
				tipoCobranca.setTxJuros(rs.getDouble("TX_JUROS"));
				tipoCobranca.setVlMoraDiaria(rs.getDouble("VL_MORA_DIARIA"));
				
				processoBean.setNrProcesso(rs.getInt("NR_Processo"));
				processoBean.setForum(forum);
				processoBean.setCliente(cliente);
				processoBean.setTipoCausa(tipoCausa);
				processoBean.setTipoCobranca(tipoCobranca);
				processoBean.setDsProcesso(rs.getString("DS_Processo"));
				processoBean.setDtAbertura(calAbertura);
				processoBean.setDtFechamento(calFechamento);
				processoBean.setDdDiaVencimento(rs.getInt("DD_Dia_Vencimento"));
				processoBean.setCdResultado(rs.getInt("CD_Resultado"));
				processoBean.setDsObservacao(rs.getString("DS_Observacao"));
				
				listaProcessoBean.add(processoBean);
			}
			
		} catch(Exception e) {
			Logs.logger.info("OracleProcessoDAO; public List<ProcessoBean> listar(int idCliente); " + e.toString());
			e.printStackTrace();
		} finally {
			
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return listaProcessoBean;
	}
	
	public List<ProcessoBean> listarPorAdvogado(int idAdvogado) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<ProcessoBean> listaProcessoBean = new ArrayList<ProcessoBean>();
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			
			String sql = "SELECT" +
					" PROC.NR_Processo," +
					" PROC.CD_Pessoa_Forum," +
					" PROC.CD_Pessoa_Cliente," +
					" PROC.CD_Causa," +
					" PROC.CD_Cobranca," +
					" PROC.DS_Processo," +
					" PROC.DT_ABERTURA," +
					" PROC.DT_Fechamento," +
					" PROC.DD_Dia_Vencimento," +
					" PROC.CD_Resultado," +
					" PROC.DS_Observacao," +
					" FORUM.DS_FORUM," +
					" PESS_FORUM.NM_PESSOA NM_FORUM," +
					" PESS_CLIENTE.NM_PESSOA NM_CLIENTE," +
					" CLIENTE.NM_RAZAO_SOCIAL," +
					" CLIENTE.NR_CNPJ," +
					" CLIENTE.NR_INSC_ESTADUAL," +
					" CLIENTE.DS_EMAIL," +
					" CLIENTE.DS_PASSWORD," +
					" CAUSA.DS_CAUSA," +
					" COBR.DS_COBRANCA," +
					" COBR.TX_JUROS," +
					" COBR.VL_MORA_DIARIA" +
					" FROM" +
					" AM_PROCESSO PROC" +
					" INNER JOIN AM_FORUM FORUM" +
					" ON PROC.CD_Pessoa_Forum = FORUM.CD_Pessoa_Forum" +
					" INNER JOIN AM_PESSOA PESS_FORUM" +
					" ON FORUM.CD_Pessoa_Forum = PESS_FORUM.CD_Pessoa" +
					" INNER JOIN AM_PESSOA PESS_CLIENTE" +
					" ON PROC.CD_PESSOA_CLIENTE = PESS_CLIENTE.CD_PESSOA" +
					" INNER JOIN AM_CLIENTE CLIENTE" +
					" ON PROC.CD_PESSOA_CLIENTE = CLIENTE.CD_PESSOA_CLIENTE" +
					" INNER JOIN AM_TIPO_CAUSA CAUSA" +
					" ON PROC.CD_CAUSA = CAUSA.CD_CAUSA" +
					" INNER JOIN AM_TIPO_COBRANCA COBR" +
					" ON PROC.CD_COBRANCA = COBR.CD_COBRANCA" +
					" INNER JOIN AM_ADVOGADO_PROCESSO ADV_PROC" +
					" ON PROC.NR_PROCESSO = ADV_PROC.NR_PROCESSO" +
					" WHERE ADV_PROC.CD_PESSOA_ADV = ?" +
					" ORDER BY PROC.NR_Processo";
			
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, idAdvogado);
			
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				ProcessoBean processoBean = new ProcessoBean(); 
				
				Calendar calAbertura = Calendar.getInstance();
				calAbertura.setTime(rs.getDate("DT_ABERTURA"));
				
				Calendar calFechamento = Calendar.getInstance();
				java.sql.Date dataFechamento = rs.getDate("DT_Fechamento");
				if (dataFechamento != null )
					calFechamento.setTime(dataFechamento);
				
				PessoaBean pessoaCliente = new PessoaBean();
				pessoaCliente.setCdPessoa(rs.getInt("CD_Pessoa_Cliente"));
				pessoaCliente.setNmPessoa(rs.getString("NM_CLIENTE"));
				
				ClienteBean cliente = new ClienteBean();
				cliente.setDsEmail(rs.getString("DS_EMAIL"));
				cliente.setDsPassword(rs.getString("DS_PASSWORD"));
				cliente.setNmRazaoSocial(rs.getString("NM_RAZAO_SOCIAL"));
				cliente.setNrCNPJ(rs.getLong("NR_CNPJ"));
				cliente.setNrInscEstadual(rs.getLong("NR_INSC_ESTADUAL"));
				cliente.setPessoa(pessoaCliente);
				
				PessoaBean forumPessoa = new PessoaBean();
				forumPessoa.setCdPessoa(rs.getInt("CD_Pessoa_Forum"));
				forumPessoa.setNmPessoa(rs.getString("NM_FORUM"));
				
				ForumBean forum = new ForumBean();
				forum.setDsForum(rs.getString("DS_FORUM"));
				forum.setPessoa(forumPessoa);
				
				TipoCausaBean tipoCausa = new TipoCausaBean();
				tipoCausa.setCdCausa(rs.getInt("CD_Causa"));
				tipoCausa.setDsCausa(rs.getString("DS_CAUSA"));
				
				TipoCobrancaBean tipoCobranca = new TipoCobrancaBean();
				tipoCobranca.setCdCobranca(rs.getInt("CD_Cobranca"));
				tipoCobranca.setDsCobranca(rs.getString("DS_COBRANCA"));
				tipoCobranca.setTxJuros(rs.getDouble("TX_JUROS"));
				tipoCobranca.setVlMoraDiaria(rs.getDouble("VL_MORA_DIARIA"));
				
				processoBean.setNrProcesso(rs.getInt("NR_Processo"));
				processoBean.setForum(forum);
				processoBean.setCliente(cliente);
				processoBean.setTipoCausa(tipoCausa);
				processoBean.setTipoCobranca(tipoCobranca);
				processoBean.setDsProcesso(rs.getString("DS_Processo"));
				processoBean.setDtAbertura(calAbertura);
				processoBean.setDtFechamento(calFechamento);
				processoBean.setDdDiaVencimento(rs.getInt("DD_Dia_Vencimento"));
				processoBean.setCdResultado(rs.getInt("CD_Resultado"));
				processoBean.setDsObservacao(rs.getString("DS_Observacao"));
				
				listaProcessoBean.add(processoBean);
			}
			
		} catch(Exception e) {
			Logs.logger.info("OracleProcessoDAO; public List<ProcessoBean> listarPorAdvogado(int idAdvogado); " + e.toString());
			e.printStackTrace();
		} finally {
			
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return listaProcessoBean;
	}

}
