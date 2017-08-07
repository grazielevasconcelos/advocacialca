package br.com.advocacialca.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.advocacialca.beans.BloqueioDesbloqueioBean;
import br.com.advocacialca.beans.HistBloqDesbloqBean;
import br.com.advocacialca.beans.ProcessoBean;
import br.com.advocacialca.beans.RespostaCRUD;
import br.com.advocacialca.interfaces.IHistBloqDesbloqDAO;
import br.com.advocacialca.logs.Logs;


public class OracleHistBloqDesbloqDAO implements IHistBloqDesbloqDAO {

	@Override
	public RespostaCRUD cadastrar(HistBloqDesbloqBean hisBloDesbloqBean) {
		RespostaCRUD resp = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			String sql = null;
			
			sql = "INSERT INTO AM_HIST_PROC_BLOQ_DESBLOQ (nr_processo, dt_bloqueio_desbloq, cd_bloqueio_desbloq) VALUES (?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, hisBloDesbloqBean.getProcesso().getNrProcesso());
			stmt.setDate(2, new java.sql.Date(hisBloDesbloqBean.getDtBloqueioDesbloq().getTime().getTime()));
			stmt.setLong(3, hisBloDesbloqBean.getBloqueioDesbloq().getCdBloqDesbloq());
			
			stmt.execute();
			conn.commit();
			conn.setAutoCommit(true);
			
			resp = new RespostaCRUD(true, "Bloqueio efetuado com sucesso.");
			
		} catch (Exception e) {
			resp = new RespostaCRUD(false, e.toString());
			Logs.logger.info("OracleHistBloqDesbloqDAO; public void cadastrar(HistBloqDesbloqBean hisBloDesbloqBean); " + e.toString());
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}e.printStackTrace();
		}finally{
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resp;
	}

	@Override
	public void atualizar(HistBloqDesbloqBean hisBloDesbloqBean) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			String sql = null;
			
			sql = "UPDATE AM_HIST_PROC_BLOQ_DESBLOQ SET dt_bloqueio_desbloq = ?, cd_bloqueio_desbloq = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setDate(1, new java.sql.Date(hisBloDesbloqBean.getDtBloqueioDesbloq().getTime().getTime()));
			stmt.setLong(2, hisBloDesbloqBean.getBloqueioDesbloq().getCdBloqDesbloq());
			
			stmt.execute();
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch (Exception e) {
			Logs.logger.info("OracleHistBloqDesbloqDAO; public void atualizar(HistBloqDesbloqBean hisBloDesbloqBean); " + e.toString());
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}e.printStackTrace();
		}finally{
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}		

	@Override
	public void remover(ProcessoBean processo, Date dtBloqueioDesbloq) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			String sql = null;
			
			sql = "DELETE FROM AM_HIST_PROC_BLOQ_DESBLOQ WHERE nr_processo = ? AND dt_bloqueio_desbloq = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, processo.getNrProcesso());
			stmt.setDate(2, dtBloqueioDesbloq);
			
			stmt.execute();
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch (Exception e) {
			Logs.logger.info("OracleHistBloqDesbloqDAO; public void remover(ProcessoBean processo, Date dtBloqueioDesbloq); " + e.toString());
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}e.printStackTrace();
		}finally{
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public HistBloqDesbloqBean consultar(ProcessoBean processo,Date dtBloqueioDesbloq) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		HistBloqDesbloqBean histBloqDesbloqBean = null;
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			String sql = null;
			
			sql="SELECT HIST_BLOQ_DESBLOQ.NR_PROCESSO, "+
				"HIST_BLOQ_DESBLOQ.DT_BLOQUEIO_DESBLOQ, " +
				"HIST_BLOQ_DESBLOQ.CD_BLOQUEIO_DESBLOQ "+
				"FROM "+
				"AM_BLOQUEIO_DESBLOQ BLOQ_DESBLOQ, "+
				"AM_HIST_PROC_BLOQ_DESBLOQ HIST_BLOQ_DESBLOQ "+
				"WHERE BLOQ_DESBLOQ.CD_BLOQUEIO_DESBLOQ = HIST_BLOQ_DESBLOQ.CD_BLOQUEIO_DESBLOQ AND "+
				"HIST_BLOQ_DESBLOQ.NR_PROCESSO = 2 and  HIST_BLOQ_DESBLOQ.DT_BLOQUEIO_DESBLOQ = '25/09/2012'";
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, processo.getNrProcesso());
			stmt.setDate(2, dtBloqueioDesbloq);
			
			rs = stmt.executeQuery();
			
			Calendar cal = Calendar.getInstance();
			
			cal.setTime(dtBloqueioDesbloq);
			
			if(rs.last()){
				histBloqDesbloqBean  = new HistBloqDesbloqBean();
				histBloqDesbloqBean.setProcesso(processo);
				histBloqDesbloqBean.setDtBloqueioDesbloq(cal);
				histBloqDesbloqBean.getBloqueioDesbloq().setCdBloqDesbloq(rs.getLong("cd_bloqueio_desbloq"));
				
			}
		} 	 catch (Exception e) {
			Logs.logger.info("OracleHistBloqDesbloqDAO; public HistBloqDesbloqBean consultar(ProcessoBean processo,Date dtBloqueioDesbloq); " + e.toString());
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}e.printStackTrace();
		}finally{
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return histBloqDesbloqBean;
	}
	
	
	public HistBloqDesbloqBean consultarPorProcesso(ProcessoBean processo) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		HistBloqDesbloqBean histBloqDesbloqBean = null;
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			String sql = null;
			
			sql="SELECT HIST_BLOQ_DESBLOQ.NR_PROCESSO, "+
				"HIST_BLOQ_DESBLOQ.DT_BLOQUEIO_DESBLOQ, " +
				"HIST_BLOQ_DESBLOQ.CD_BLOQUEIO_DESBLOQ "+
				"FROM "+
				"AM_BLOQUEIO_DESBLOQ BLOQ_DESBLOQ, "+
				"AM_HIST_PROC_BLOQ_DESBLOQ HIST_BLOQ_DESBLOQ "+
				"WHERE BLOQ_DESBLOQ.CD_BLOQUEIO_DESBLOQ = HIST_BLOQ_DESBLOQ.CD_BLOQUEIO_DESBLOQ AND "+
				"HIST_BLOQ_DESBLOQ.NR_PROCESSO = ? " +
                "ORDER BY HIST_BLOQ_DESBLOQ.DT_BLOQUEIO_DESBLOQ";
                
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, processo.getNrProcesso());
			
			rs = stmt.executeQuery();
			
			Calendar cal = Calendar.getInstance();
			
			while(rs.next()){
				histBloqDesbloqBean  = new HistBloqDesbloqBean();
				histBloqDesbloqBean.setProcesso(processo);
				histBloqDesbloqBean.setDtBloqueioDesbloq(cal);
				BloqueioDesbloqueioBean bloqDesbloqBean = new BloqueioDesbloqueioBean();
				bloqDesbloqBean.setCdBloqDesbloq(rs.getLong("cd_bloqueio_desbloq"));
				histBloqDesbloqBean.setBloqueioDesbloq(bloqDesbloqBean);				
			}
            
		} 	 catch (Exception e) {
			Logs.logger.info("OracleHistBloqDesbloqDAO; public HistBloqDesbloqBean consultar(ProcessoBean processo,Date dtBloqueioDesbloq); " + e.toString());
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}e.printStackTrace();
		}finally{
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return histBloqDesbloqBean;
	}
	

	public List<HistBloqDesbloqBean> listar() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		HistBloqDesbloqBean histBloqDesbloqBean = null;
		List<HistBloqDesbloqBean> histBloqDesbloq = null;
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			String sql = null;
			
			histBloqDesbloq = new ArrayList<HistBloqDesbloqBean>();
			
			sql = "SELECT " +
				"PROC.NR_PROCESSO, " +
				"HIST_BLOQ_DESBLOQ.DT_BLOQUEIO_DESBLOQ, " +
				"BLOQ_DESBLOQ.CD_BLOQUEIO_DESBLOQ " +
				"FROM " +
				"AM_PROCESSO PROC " +
				"INNER JOIN AM_HIST_PROC_BLOQ_DESBLOQ HIST_BLOQ_DESBLOQ " +
				"ON PROC.NR_PROCESSO = HIST_BLOQ_DESBLOQ.NR_PROCESSO " +
				"INNER JOIN AM_BLOQUEIO_DESBLOQ BLOQ_DESBLOQ " +
				"ON HIST_BLOQ_DESBLOQ.CD_BLOQUEIO_DESBLOQ = BLOQ_DESBLOQ.CD_BLOQUEIO_DESBLOQ";

			stmt = conn.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			while(rs.next()){
				ProcessoBean procBean = new ProcessoBean();
				procBean.setNrProcesso(rs.getInt("nr_proceso"));
				
				BloqueioDesbloqueioBean bloqDesbloqBean = new BloqueioDesbloqueioBean();
				bloqDesbloqBean.setCdBloqDesbloq(rs.getLong("cd_bloqueio_desbloq"));
				
				Calendar cal = Calendar.getInstance();
				cal.setTime(rs.getDate("dt_bloqueio_desbloq"));

				histBloqDesbloqBean = new HistBloqDesbloqBean();
				histBloqDesbloqBean.setProcesso(procBean);
				histBloqDesbloqBean.setDtBloqueioDesbloq(cal);
				histBloqDesbloqBean.setBloqueioDesbloq(bloqDesbloqBean);
				
				histBloqDesbloq.add(histBloqDesbloqBean);
			}
			
				
		} catch (Exception e) {
			Logs.logger.info("OracleHistBloqDesbloqDAO; public List<HistBloqDesbloqBean> listar(); " + e.toString());
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}e.printStackTrace();
		}finally{
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return histBloqDesbloq;
	}

}
