package br.com.advocacialca.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.advocacialca.beans.TipoCausaBean;
import br.com.advocacialca.interfaces.ITipoCausaDAO;
import br.com.advocacialca.logs.Logs;

public class OracleTipoCausaDAO implements ITipoCausaDAO {
	public void cadastrar(TipoCausaBean tipoCausaBean) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO AM_TIPO_CAUSA (ds_Causa) VALUES (?)";
			
			stmt = conn.prepareStatement(sql); 
			
			stmt.setString(1, String.valueOf(tipoCausaBean.getDsCausa()));
			
			stmt.execute();
			
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch(Exception e) {
			Logs.logger.info("OracleTipoCausaDAO; public void cadastrar(TipoCausaBean tipoCausaBean); " + e.toString());
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

	public void atualizar(TipoCausaBean tipoCausaBean) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			
			String sql = "UPDATE AM_TIPO_CAUSA SET ds_Causa=? WHERE cd_Causa=?";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, String.valueOf(tipoCausaBean.getDsCausa()));
			stmt.setInt(2, tipoCausaBean.getCdCausa());			
			
			stmt.execute();
			
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch(Exception e) {
			Logs.logger.info("OracleTipoCausaDAO; public void atualizar(TipoCausaBean tipoCausaBean); " + e.toString());
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

	public void remover(int idTipoCausa) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			
			String sql = "DELETE FROM AM_TIPO_CAUSA WHERE cd_Causa=?";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, idTipoCausa);
			
			stmt.execute();
			
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch(Exception e) {
			Logs.logger.info("OracleTipoCausaDAO; public void remover(int idTipoCausa); " + e.toString());
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

	public TipoCausaBean consultar(int idTipoCausa) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		TipoCausaBean tipoCausaBean = new TipoCausaBean();
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			
			String sql = "SELECT ds_Causa FROM AM_TIPO_CAUSA WHERE cd_Causa=?";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, idTipoCausa);
			
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				tipoCausaBean.setCdCausa(idTipoCausa);
				tipoCausaBean.setDsCausa(rs.getString("ds_Causa"));
			}
			
		} catch(Exception e) {
			Logs.logger.info("OracleTipoCausaDAO; public TipoCausaBean consultar(int idTipoCausa); " + e.toString());
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
		
		return tipoCausaBean;
	}

	public List<TipoCausaBean> listar() {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<TipoCausaBean> listaTipoCausaBean = new ArrayList<TipoCausaBean>();
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			
			String sql = "SELECT cd_Causa, ds_Causa FROM AM_TIPO_CAUSA";
			
			stmt = conn.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				TipoCausaBean tipoCausaBean = new TipoCausaBean(); 
				
				tipoCausaBean.setCdCausa(rs.getInt("cd_Causa"));
				tipoCausaBean.setDsCausa(rs.getString("ds_Causa"));
				
				listaTipoCausaBean.add(tipoCausaBean);
			}
			
		} catch(Exception e) {
			Logs.logger.info("OracleTipoCausaDAO; public List<TipoCausaBean> listar(); " + e.toString());
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
		
		return listaTipoCausaBean;
	}

}