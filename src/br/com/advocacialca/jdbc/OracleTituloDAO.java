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
import br.com.advocacialca.beans.TipoCausaBean;
import br.com.advocacialca.beans.TipoCobrancaBean;
import br.com.advocacialca.beans.TituloBean;
import br.com.advocacialca.interfaces.ITituloDAO;
import br.com.advocacialca.logs.Logs;

public class OracleTituloDAO implements ITituloDAO {

	public void cadastrar(TituloBean tituloBean) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO AM_TITULO (nr_processo, nr_agencia_cedente, dt_documento, dt_vencimento," +
					" vl_documento) VALUES (?, ?, ?, ?, ?)";
			
			stmt = conn.prepareStatement(sql); 
			
			stmt.setInt(1, tituloBean.getProcesso().getNrProcesso());
			stmt.setInt(2, tituloBean.getNrAgenciaCedente());
			stmt.setDate(3, new java.sql.Date (tituloBean.getDtDocumento().getTime().getTime()));
			stmt.setDate(4, new java.sql.Date (tituloBean.getDtVencimento().getTime().getTime()));
			stmt.setFloat(5, tituloBean.getVlDocumento());
			
			stmt.execute();
			
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch(Exception e) {
			Logs.logger.info("OracleTituloDAO; public void cadastrar(TituloBean tituloBean); " + e.toString());
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

	public void atualizar(TituloBean tituloBean) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			
			String sql = "UPDATE AM_TITULO SET nr_processo=?, nr_agencia_cedente=?, dt_documento=?," +
					" dt_vencimento=?, vl_documento=? WHERE nr_titulo=?";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, tituloBean.getProcesso().getNrProcesso());
			stmt.setInt(2, tituloBean.getNrAgenciaCedente());
			stmt.setDate(3, new java.sql.Date (tituloBean.getDtDocumento().getTime().getTime()));
			stmt.setDate(4, new java.sql.Date (tituloBean.getDtVencimento().getTime().getTime()));
			stmt.setFloat(5, tituloBean.getVlDocumento());
			stmt.setInt(6, tituloBean.getNrTitulo());
			
			stmt.execute();
			
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch(Exception e) {
			Logs.logger.info("OracleTituloDAO; public void atualizar(TituloBean tituloBean); " + e.toString());
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

	public void remover(int idTitulo) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			
			String sql = "DELETE FROM AM_TITULO WHERE nr_titulo=?";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, idTitulo);
			
			stmt.execute();
			
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch(Exception e) {
			Logs.logger.info("OracleTituloDAO; public void remover(int idTitulo); " + e.toString());
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

	public TituloBean consultar(int idTitulo) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		TituloBean tituloBean = null;
		ProcessoBean processoBean = null;
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			
			String sql = "SELECT" +
					" TITULO.nr_agencia_cedente," + 
					" TITULO.dt_documento," +
					" TITULO.dt_vencimento," +
					" TITULO.vl_documento," +
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
					" COBR.VL_MORA_DIARIA, " + 
					" (((COBR.TX_JUROS/100)* TITULO.vl_documento)+TITULO.vl_documento) TOTAL, "+
					" (((COBR.TX_JUROS/100)* TITULO.vl_documento)+TITULO.vl_documento) + ((sysdate - TITULO.dt_vencimento) * COBR.VL_MORA_DIARIA) TOTAL_MORA " +
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
					" INNER JOIN AM_TITULO TITULO" +
					" ON TITULO.nr_processo = PROC.nr_processo " +
					" WHERE TITULO.nr_titulo = ?";
			 
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, idTitulo);
			
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				
				Calendar calAbertura = Calendar.getInstance();
				calAbertura.setTime(rs.getDate("DT_ABERTURA"));
				
				Calendar calFechamento = Calendar.getInstance();
				java.sql.Date dataFechamento = rs.getDate("DT_Fechamento");
				if (dataFechamento != null )
					calFechamento.setTime(dataFechamento);
				
				Calendar dtDoc = Calendar.getInstance();
				dtDoc.setTime(rs.getDate("dt_documento"));
				
				Calendar dtVenc = Calendar.getInstance();
				dtVenc.setTime(rs.getDate("dt_vencimento"));
				
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
				
				processoBean = new ProcessoBean();
				
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
				
				tituloBean = new TituloBean();
				tituloBean.setNrTitulo(idTitulo);
				tituloBean.setProcesso(processoBean);
				tituloBean.setNrAgenciaCedente(rs.getInt("nr_agencia_cedente"));
				tituloBean.setDtDocumento(dtDoc);
				tituloBean.setDtVencimento(dtVenc);
				tituloBean.setVlDocumento(rs.getFloat("vl_documento"));
				Calendar dataPagamento = Calendar.getInstance();
				
				long dataPag = dataPagamento.getTimeInMillis()/ (24 * 60 * 60);
				long dataVenci = dtVenc.getTimeInMillis()/(24 * 60 * 60);
				
				if(dataPag > dataVenci){
					tituloBean.setTotal(rs.getDouble("TOTAL_MORA"));
				}else{
					tituloBean.setTotal(rs.getDouble("TOTAL"));
				}
			}
		
		} catch(Exception e) {
			Logs.logger.info("OracleTituloDAO; public TituloBean consultar(int idTitulo); " + e.toString());
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
		return tituloBean;
	}
	
	public List<TituloBean> listar(int nrProcesso) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		TituloBean tituloBean = null;
		ProcessoBean processoBean = null;
		List<TituloBean> listaTituloBean = null;
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			
			String sql = "SELECT" +
					" TITULO.nr_titulo," +
					" TITULO.nr_agencia_cedente," + 
					" TITULO.dt_documento," +
					" TITULO.dt_vencimento," +
					" TITULO.vl_documento," +
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
					" COBR.VL_MORA_DIARIA, " +
					" (((COBR.TX_JUROS/100)* TITULO.vl_documento)+TITULO.vl_documento) TOTAL, "+
					" (((COBR.TX_JUROS/100)* TITULO.vl_documento)+TITULO.vl_documento) + ((sysdate - TITULO.dt_vencimento) * COBR.VL_MORA_DIARIA) TOTAL_MORA " +
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
					" INNER JOIN AM_TITULO TITULO" +
					" ON TITULO.nr_processo = PROC.nr_processo " +
					" WHERE PROC.nr_processo = ?" +
					" AND TITULO.nr_titulo NOT IN (SELECT NR_TITULO FROM AM_TITULO_PAGO)" + 
					" ORDER BY TITULO.dt_documento";
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, nrProcesso);
			rs = stmt.executeQuery();
			
			listaTituloBean = new ArrayList<TituloBean>();
			
			while (rs.next()) {
				
				Calendar calAbertura = Calendar.getInstance();
				calAbertura.setTime(rs.getDate("DT_ABERTURA"));
				
				Calendar calFechamento = Calendar.getInstance();
				java.sql.Date dataFechamento = rs.getDate("DT_Fechamento");
				if (dataFechamento != null )
					calFechamento.setTime(dataFechamento);
				
				Calendar dtDoc = Calendar.getInstance();
				dtDoc.setTime(rs.getDate("dt_documento"));
				
				Calendar dtVenc = Calendar.getInstance();
				dtVenc.setTime(rs.getDate("dt_vencimento"));
				
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
				
				processoBean = new ProcessoBean();
				
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
				
				tituloBean = new TituloBean();
				tituloBean.setNrTitulo(rs.getInt("nr_titulo"));
				tituloBean.setProcesso(processoBean);
				tituloBean.setNrAgenciaCedente(rs.getInt("nr_agencia_cedente"));
				tituloBean.setDtDocumento(dtDoc);
				tituloBean.setDtVencimento(dtVenc);
				tituloBean.setVlDocumento(rs.getFloat("vl_documento"));
				Calendar dataPagamento = Calendar.getInstance();
				
				long dataPag = dataPagamento.getTimeInMillis()/ (24 * 60 * 60);
				long dataVenci = dtVenc.getTimeInMillis()/(24 * 60 * 60);
				
				if(dataPag > dataVenci){
					tituloBean.setTotal(rs.getDouble("TOTAL_MORA"));
				}else{
					tituloBean.setTotal(rs.getDouble("TOTAL"));
				}
				
				listaTituloBean.add(tituloBean);
			}
			
		} catch(Exception e) {
			Logs.logger.info("OracleTituloDAO; public List<TituloBean> listar(int nrProcesso); " + e.toString());
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
		
		return listaTituloBean;
	}

}