package br.com.advocacialca.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.advocacialca.beans.TipoCobrancaBean;
import br.com.advocacialca.interfaces.ITipoCobrancaDAO;
import br.com.advocacialca.logs.Logs;

public class OracleTipoCobrancaDAO implements ITipoCobrancaDAO {

	public void cadastrar(TipoCobrancaBean tipoCobrancaBean) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO AM_TIPO_COCBRANCA (cd_cobranca , ds_cobranca, tx_juros, vl_mora_diaria) VALUES (?, ?, ?, ?)";
			
			stmt = conn.prepareStatement(sql); 
			
			stmt.setInt(1, tipoCobrancaBean.getCdCobranca());
			stmt.setString(2, String.valueOf(tipoCobrancaBean.getDsCobranca()));
			stmt.setDouble(3, tipoCobrancaBean.getTxJuros());
			stmt.setDouble(4, tipoCobrancaBean.getVlMoraDiaria());
			
			stmt.execute();
			
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch(Exception e) {
			Logs.logger.info("OracleTipoCobrancaDAO; public void cadastrar(TipoCobrancaBean tipoCobrancaBean); " + e.toString());
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

	public void atualizar(TipoCobrancaBean tipoCobrancaBean) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			
			String sql = "UPDATE AM_TIPO_COBRANCA SET ds_cobranca = ?, tx_juros = ?, vl_mora_diaria =? WHERE cd_cobranca=?";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setDouble(1, tipoCobrancaBean.getVlMoraDiaria());
			stmt.setDouble(2, tipoCobrancaBean.getTxJuros());
			stmt.setString(3, String.valueOf(tipoCobrancaBean.getDsCobranca()));
			stmt.setInt(4, tipoCobrancaBean.getCdCobranca());
			stmt.execute();
			
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch(Exception e) {
			Logs.logger.info("OracleTipoCobrancaDAO; public void atualizar(TipoCobrancaBean tipoCobrancaBean); " + e.toString());
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

	public void remover(int idTipoHonorario) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			
			String sql = "DELETE FROM AM_TIPO_COBRANCA WHERE cd_honorario = ?";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, idTipoHonorario);
			
			stmt.execute();
			
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch(Exception e) {
			Logs.logger.info("OracleTipoCobrancaDAO; public void remover(int idTipoHonorario); " + e.toString());
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

	public TipoCobrancaBean consultar(int idTipoCobranca) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		TipoCobrancaBean tipoCobrancaBean = new TipoCobrancaBean();
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			
			String sql = "SELECT ds_cobranca, tx_juros, vl_mora_diaria FROM AM_TIPO_COBRANCA WHERE cd_cobranca=?";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, idTipoCobranca);
			
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				tipoCobrancaBean.setCdCobranca(idTipoCobranca);
				tipoCobrancaBean.setDsCobranca(rs.getString("ds_cobranca"));
				tipoCobrancaBean.setTxJuros(rs.getDouble("tx_juros"));
				tipoCobrancaBean.setVlMoraDiaria(rs.getDouble("vl_mora_diaria"));
			}
			
		} catch(Exception e) {
			Logs.logger.info("OracleTipoCobrancaDAO; public TipoCobrancaBean consultar(int idTipoCobranca); " + e.toString());
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
		
		return tipoCobrancaBean;
	}

	public List<TipoCobrancaBean> listar() {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<TipoCobrancaBean> listaTipoCobrancaBean = new ArrayList<TipoCobrancaBean>();
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			
			String sql = "SELECT cd_cobranca, ds_cobranca, tx_juros, vl_mora_diaria FROM AM_TIPO_COBRANCA";
			
			stmt = conn.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				TipoCobrancaBean tipoCobrancaBean = new TipoCobrancaBean(); 
				
				tipoCobrancaBean.setCdCobranca(rs.getInt("cd_cobranca"));
				tipoCobrancaBean.setDsCobranca(rs.getString("ds_cobranca"));
				tipoCobrancaBean.setTxJuros(rs.getDouble("tx_juros"));
				tipoCobrancaBean.setVlMoraDiaria(rs.getDouble("vl_mora_diaria"));
				
				listaTipoCobrancaBean.add(tipoCobrancaBean);
			}
			
		} catch(Exception e) {
			Logs.logger.info("OracleTipoCobrancaDAO; public List<TipoCobrancaBean> listar(); " + e.toString());
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
		
		return listaTipoCobrancaBean;
	}
}
