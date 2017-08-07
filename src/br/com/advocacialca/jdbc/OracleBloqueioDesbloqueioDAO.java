package br.com.advocacialca.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.advocacialca.beans.BloqueioDesbloqueioBean;
import br.com.advocacialca.interfaces.IBloqueioDesbloqueioDAO;
import br.com.advocacialca.logs.Logs;


public class OracleBloqueioDesbloqueioDAO implements IBloqueioDesbloqueioDAO{

	@Override
	public void cadastrar(BloqueioDesbloqueioBean bloqDesbloqBean) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			String sql = null;
			
			sql="INSERT INTO AM_BLOQUEIO_DESBLOQ (cd_bloqueio_desbloq, ds_bloqueio_desbloq) VALUES(?,?)";
			stmt = conn.prepareStatement(sql);
			
			stmt.setLong(1, bloqDesbloqBean.getCdBloqDesbloq());
			stmt.setString(2, bloqDesbloqBean.getDsBloqDesbloq());
			
			stmt.execute();
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch (Exception e) {
			Logs.logger.info("OracleBloqueioDesbloqueioDAO; public void cadastrar (BloqueioDesbloqueioBean bloqDesbloqBean); " + e.toString());
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
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
	public void atualizar(BloqueioDesbloqueioBean bloqDesbloqBean) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			String sql = null;
			
			sql="UPDATE AM_BLOQUEIO_DESBLOQ SET ds_bloqueio_desbloq = ? WHERE cd_bloqueio_desbloq = ? ";
			stmt = conn.prepareStatement(sql);
			
			stmt.setLong(1, bloqDesbloqBean.getCdBloqDesbloq());
			stmt.setString(2, bloqDesbloqBean.getDsBloqDesbloq());
			
			stmt.execute();
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch (Exception e) {
			Logs.logger.info("OracleBloqueioDesbloqueioDAO; public void atualizar (BloqueioDesbloqueioBean bloqDesbloqBean); " + e.toString());
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
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
	public void remover(long cdBloqDesbloq) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			String sql = null;
			
			sql = "DELETE FROM AM_BLOQUEIO_DESBLOQ WHERE cd_bloqueio_desbloq = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, cdBloqDesbloq);
			
			stmt.execute();
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch (Exception e) {
			Logs.logger.info("OracleBloqueioDesbloqueioDAO; public void remover (long cdBloqDesbloq); " + e.toString());
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
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
	public BloqueioDesbloqueioBean consultar(long cdBloqDesbloq) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		BloqueioDesbloqueioBean bloqDesbloqBean = new BloqueioDesbloqueioBean();
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			String sql = null;
			
			sql = "SELECT ds_bloqueio_desbloq FROM AM_BLOQUEIO_DESBLOQ WHERE cd_bloqueio_desbloq = ?" ;
			stmt = conn.prepareStatement(sql);
			
			stmt.setLong(1, cdBloqDesbloq);
			
			rs = stmt.executeQuery();
			
			if(rs.next()){
				bloqDesbloqBean.setCdBloqDesbloq(cdBloqDesbloq);
				bloqDesbloqBean.setDsBloqDesbloq(rs.getString("ds_bloqueio_desbloq"));
			}
			
		} catch (Exception e) {
			Logs.logger.info("OracleBloqueioDesbloqueioDAO; BloqueioDesbloqueioBean consultar(long cdBloqDesbloq); " + e.toString());
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return bloqDesbloqBean;
	}
	
	@Override
	public List<BloqueioDesbloqueioBean> listar() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		BloqueioDesbloqueioBean bloqDesbloqBean = null;
		List <BloqueioDesbloqueioBean> bloqDesbloq = null;
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			String sql = null;
			
			sql = "SELECT cd_bloqueio_desbloq, ds_bloqueio_desbloq FROM AM_BLOQUEIO_DESBLOQ";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			bloqDesbloq = new ArrayList<BloqueioDesbloqueioBean>();
			
			while(rs.next()){
				bloqDesbloqBean = new BloqueioDesbloqueioBean();
				bloqDesbloqBean.setCdBloqDesbloq(rs.getLong("cd_bloqueio_desbloq"));
				bloqDesbloqBean.setDsBloqDesbloq(rs.getString("ds_bloqueio_desbloq"));
				bloqDesbloq.add(bloqDesbloqBean);
			}
			
		} catch (Exception e) {
			Logs.logger.info("OracleBloqueioDesbloqueioDAO; List<BloqueioDesbloqueioBean> listar(); " + e.toString());
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return bloqDesbloq;
	}


}
