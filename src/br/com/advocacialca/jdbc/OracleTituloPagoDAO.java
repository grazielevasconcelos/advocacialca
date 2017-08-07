package br.com.advocacialca.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.advocacialca.beans.ProcessoBean;
import br.com.advocacialca.beans.RespostaCRUD;
import br.com.advocacialca.beans.TituloBean;
import br.com.advocacialca.beans.TituloPagoBean;
import br.com.advocacialca.interfaces.ITituloPagoDAO;
import br.com.advocacialca.logs.Logs;

public class OracleTituloPagoDAO implements ITituloPagoDAO {
	
   	public RespostaCRUD cadastrar(TituloPagoBean tituloPagoBean) {
		
   		RespostaCRUD resp = null;
   		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO AM_TITULO_PAGO (nr_titulo, dt_pagamento, vl_pago) VALUES (?,?,?)";
			
			stmt = conn.prepareStatement(sql);
            
			stmt.setInt(1, tituloPagoBean.getTitulo().getNrTitulo());
			stmt.setDate(2, new java.sql.Date(tituloPagoBean.getDtPagamento().getTime().getTime()));
			stmt.setDouble(3, tituloPagoBean.getVlPago());
			
			stmt.execute();
			
			conn.commit();
			conn.setAutoCommit(true);
			
			resp = new RespostaCRUD(true, "Pagamento efetuado com sucesso.");
			
		} catch(Exception e) {
			resp = new RespostaCRUD(false, e.toString());
			Logs.logger.info("OracleTituloPagoDAO; public void cadastrar(TituloPagoBean tituloPagoBean); " + e.toString());
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

	public void remover(int cdTitulo, Date dataTitulo) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			
			String sql = "DELETE FROM AM_TITULO_PAGO WHERE nr_titulo = ? AND dt_pagamento = ?";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, cdTitulo);
			stmt.setDate(2, dataTitulo);
			
			stmt.execute();
			
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch(Exception e) {
			Logs.logger.info("OracleTituloPagoDAO; public void remover(int cdTitulo, Date dataTitulo); " + e.toString());
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

	public TituloPagoBean consultar(int nrTitulo, Date dataTitulo) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		TituloBean tituloBean = null;
		ProcessoBean processoBean = null;
		TituloPagoBean tituloPagoBean = null;
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			
			String sql = "SELECT titulo.nr_titulo, titulo.nr_processo, " +
					"titulo.nr_agencia_cedente, titulo.dt_documento, " +
					"titulo.dt_vencimento, titulo.vl_documento, titulopago.dt_pagamento, " +
					"titulopago.vl_pago " +
					"FROM AM_TITULO_PAGO TITULOPAGO INNER JOIN" +
					" AM_TITULO TITULO ON TITULOPAGO.nr_titulo = TITULO.nr_titulo AND " +
					"titulopago.nr_titulo = ? AND " +
					"titulopago.dt_pagamento = ?";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, nrTitulo);
			stmt.setDate(2, dataTitulo);
			
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				tituloBean = new TituloBean();
				tituloBean.setNrTitulo(nrTitulo);
				
				processoBean = new ProcessoBean();
				processoBean.setNrProcesso(rs.getInt("nr_processo"));
				
				Calendar dtDoc = Calendar.getInstance();
				dtDoc.setTime(rs.getDate("dt_documento"));
				
				Calendar dtVenc = Calendar.getInstance();
				dtVenc.setTime(rs.getDate("dt_vencimento"));
				
				tituloBean.setProcesso(processoBean);
				tituloBean.setNrAgenciaCedente(rs.getInt("nr_agencia_cedente"));
				tituloBean.setDtDocumento(dtDoc);
				tituloBean.setDtVencimento(dtVenc);
				tituloBean.setVlDocumento(rs.getFloat("vl_documento"));
				
				tituloPagoBean = new TituloPagoBean();
				tituloPagoBean.setTitulo(tituloBean);
				
				Calendar cal = Calendar.getInstance();
				
				/*
				 * cal.setTime(rs.getDate("dt_pagamento"));
				 * Converte de Date para Calendar
				 */
				
				cal.setTime(rs.getDate("dt_pagamento"));
				
				tituloPagoBean.setDtPagamento(cal);
				tituloPagoBean.setVlPago(rs.getFloat("vl_pago"));
			}
			
		} catch(Exception e) {
			Logs.logger.info("OracleTituloPagoDAO; public TituloPagoBean consultar(int nrTitulo, Date dataTitulo); " + e.toString());
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
		
		return tituloPagoBean;
	}

	public List<TituloPagoBean> listar() {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<TituloPagoBean> listaTituloPagoBean = new ArrayList<TituloPagoBean>();
		TituloBean tituloBean = null;
		ProcessoBean processoBean = null;
		TituloPagoBean tituloPagoBean = null;
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			
			String sql = "SELECT titulo.nr_titulo, titulo.nr_processo, " +
					"titulo.nr_agencia_cedente, titulo.dt_documento, " +
					"titulo.dt_vencimento, titulo.vl_documento, titulopago.dt_pagamento, " +
					"titulopago.vl_pago " +
					"FROM AM_TITULO_PAGO TITULOPAGO INNER JOIN" +
					" AM_TITULO TITULO ON TITULOPAGO.nr_titulo = TITULO.nr_titulo";
			
			stmt = conn.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			
			
			while(rs.next()) {
				tituloBean = new TituloBean();
				tituloBean.setNrTitulo(rs.getInt("nr_titulo"));
				
				processoBean = new ProcessoBean();
				processoBean.setNrProcesso(rs.getInt("nr_processo"));
				
				Calendar dtDoc = Calendar.getInstance();
				dtDoc.setTime(rs.getDate("dt_documento"));
				
				Calendar dtVenc = Calendar.getInstance();
				dtVenc.setTime(rs.getDate("dt_vencimento"));
				
				tituloBean.setProcesso(processoBean);
				tituloBean.setNrAgenciaCedente(rs.getInt("nr_agencia_cedente"));
				tituloBean.setDtDocumento(dtDoc);
				tituloBean.setDtVencimento(dtVenc);
				tituloBean.setVlDocumento(rs.getFloat("vl_documento"));
				
				tituloPagoBean = new TituloPagoBean();
				tituloPagoBean.setTitulo(tituloBean);
				
				Calendar cal = Calendar.getInstance();
				
				/*
				 * cal.setTime(rs.getDate("dt_pagamento"));
				 * 
				 * Converte de Date para Calendar
				 */
				
				cal.setTime(rs.getDate("dt_pagamento"));
				
				tituloPagoBean.setDtPagamento(cal);
				tituloPagoBean.setVlPago(rs.getFloat("vl_pago"));
			}
			
		} catch(Exception e) {
			Logs.logger.info("OracleTituloPagoDAO; public List<TituloPagoBean> listar(); " + e.toString());
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
		
		return listaTituloPagoBean;
	}

}
