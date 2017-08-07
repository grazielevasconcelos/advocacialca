package br.com.advocacialca.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.advocacialca.beans.TipoTelefoneBean;
import br.com.advocacialca.interfaces.ITipoTelefoneDAO;
import br.com.advocacialca.logs.Logs;

public class OracleTipoTelefoneDAO implements ITipoTelefoneDAO {

	public void cadastrar(TipoTelefoneBean tipoTelefoneBean) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO AM_TIPO_TELEFONE (cd_tipo_telefone, ds_tipo_telefone) VALUES (?, ?)";
			
			stmt = conn.prepareStatement(sql); 
			
			stmt.setString(1, String.valueOf(tipoTelefoneBean.getDsTipoTelefone()));
			
			stmt.execute();
			
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch(Exception e) {
			Logs.logger.info("OracleTipoTelefoneDAO; public void cadastrar(TipoTelefoneBean tipoTelefoneBean); " + e.toString());
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

	public void atualizar(TipoTelefoneBean tipoTelefoneBean) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			
			String sql = "UPDATE AM_TIPO_TELEFONE SET ds_tipo_telefone =? WHERE cd_tipo_telefone=?";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, String.valueOf(tipoTelefoneBean.getDsTipoTelefone()));
			stmt.setInt(2, tipoTelefoneBean.getCdTipoTelefone());			
			
			stmt.execute();
			
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch(Exception e) {
			Logs.logger.info("OracleTipoTelefoneDAO; public void atualizar(TipoTelefoneBean tipoTelefoneBean); " + e.toString());
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

	public void remover(int cdTipoTelefone) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			
			String sql = "DELETE FROM AM_TIPO_TELEFONE WHERE cd_tipo_telefone=?";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, cdTipoTelefone);
			
			stmt.execute();
			
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch(Exception e) {
			Logs.logger.info("OracleTipoTelefoneDAO; public void remover(int cdTipoTelefone); " + e.toString());
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

	public TipoTelefoneBean consultar(int cdTipoTelefone) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		TipoTelefoneBean tipoTelefoneBean = new TipoTelefoneBean();
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			
			String sql = "SELECT ds_tipo_telefone FROM AM_TIPO_TELEFONE WHERE cd_tipo_telefone=?";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, cdTipoTelefone);
			
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				tipoTelefoneBean.setCdTipoTelefone(cdTipoTelefone);
				tipoTelefoneBean.setDsTipoTelefone(rs.getString("ds_tipo_telefone"));
			}
			
		} catch(Exception e) {
			Logs.logger.info("OracleTipoTelefoneDAO; public TipoTelefoneBean consultar(int cdTipoTelefone); " + e.toString());
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
		
		return tipoTelefoneBean;
	}

	public List<TipoTelefoneBean> listar() {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<TipoTelefoneBean> listaTipoTelefoneBean = new ArrayList<TipoTelefoneBean>();
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			
			String sql = "SELECT cd_tipo_telefone, ds_tipo_telefone FROM AM_TIPO_TELEFONE";
			
			stmt = conn.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				TipoTelefoneBean tipoTelefoneBean = new TipoTelefoneBean(); 
				
				tipoTelefoneBean.setCdTipoTelefone(rs.getInt("cd_tipo_telefone"));
				tipoTelefoneBean.setDsTipoTelefone(rs.getString("ds_tipo_telefone"));
				
				listaTipoTelefoneBean.add(tipoTelefoneBean);
			}
			
		} catch(Exception e) {
			Logs.logger.info("OracleTipoTelefoneDAO; public List<TipoTelefoneBean> listar(); " + e.toString());
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
		
		return listaTipoTelefoneBean;
	}

}