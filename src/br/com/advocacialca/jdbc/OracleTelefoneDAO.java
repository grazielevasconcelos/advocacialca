package br.com.advocacialca.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.advocacialca.beans.TelefoneBean;
import br.com.advocacialca.beans.TipoTelefoneBean;
import br.com.advocacialca.interfaces.ITelefoneDAO;
import br.com.advocacialca.logs.Logs;

public class OracleTelefoneDAO implements ITelefoneDAO {
	
	public TelefoneBean consultar(long cdTelefone){
		
		TelefoneBean telefoneBean = new TelefoneBean();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try{
			
			conn = AdvocaciaLCADBManager.obterConexao();
			
			String sql = "SELECT (cd_telefone, cd_pessoa, cd_tipo_telefone, nr_ddd, nr_telefone) FROM AM_TELEFONE WHERE cd_telefone = ?";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setLong(1, cdTelefone);
			
			rs = stmt.executeQuery(sql);
			
			if (rs.next()){
				telefoneBean.setCdTelefone(cdTelefone);
				telefoneBean.getPessoa().setCdPessoa(rs.getInt("cd_pessoa"));
				telefoneBean.getTipoTelefone().setCdTipoTelefone(rs.getInt("cd_tipo_telefone"));
				telefoneBean.setNrDDD(rs.getInt("nr_ddd"));
				telefoneBean.setNrTelefone(rs.getInt("nr_telefone"));
			}
			
			
		} catch(Exception e) {
			Logs.logger.info("OracleTelefoneDAO; public TelefoneBean consultar(long cdTelefone); " + e.toString());
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
		return telefoneBean;
	}
	
	public void cadastrar(TelefoneBean telefoneBean){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try{
			
			conn = AdvocaciaLCADBManager.obterConexao();
			
			String sql = "INSERT INTO AM_TELEFONE (cd_telefone, cd_pessoa, cd_tipo_telefone, nr_ddd, nr_telefone) VALUES (?, ?, ?, ?, ?)";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setLong(1, telefoneBean.getCdTelefone());
			stmt.setInt(2, telefoneBean.getPessoa().getCdPessoa());
			stmt.setInt(3, telefoneBean.getTipoTelefone().getCdTipoTelefone());
			stmt.setInt(4, telefoneBean.getNrDDD());
			stmt.setInt(5, telefoneBean.getNrTelefone());
			
			stmt.execute();
			
			conn.commit();
			conn.setAutoCommit(true);
			
		}catch(Exception e) {
			Logs.logger.info("OracleTelefoneDAO; public void cadastrar(TelefoneBean telefoneBean); " + e.toString());
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
	
	public void atualizar(TelefoneBean telefoneBean){
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try{
			
			conn = AdvocaciaLCADBManager.obterConexao();
			
			String sql = "UPDATE AM_TELEFONE SET cd_telefone=?, cd_pessoa=?, cd_tipo_telefone, nr_ddd=?, nr_telefone=?";
						
			stmt = conn.prepareStatement(sql);
			
			stmt.setLong(1, telefoneBean.getCdTelefone());
			stmt.setInt(2, telefoneBean.getPessoa().getCdPessoa());
			stmt.setInt(3, telefoneBean.getTipoTelefone().getCdTipoTelefone());
			stmt.setInt(4, telefoneBean.getNrDDD());
			stmt.setInt(5, telefoneBean.getNrTelefone());
			
			stmt.execute();

			conn.commit();
			conn.setAutoCommit(true);
			
		}catch(Exception e) {
			Logs.logger.info("OracleTelefoneDAO; public void atualizar(TelefoneBean telefoneBean); " + e.toString());
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
	
	public void remover(long cdTelefone){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try{			
			conn = AdvocaciaLCADBManager.obterConexao();
			
			String sql = "DELETE FROM AM_TELEFONE WHERE cd_telefone=?";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setLong(1, cdTelefone);
			
			stmt.execute();
			
		}catch(Exception e) {
			Logs.logger.info("OracleTelefoneDAO; public void remover(long cdTelefone); " + e.toString());
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
	
	public List<TelefoneBean> listar(int idCliente){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<TelefoneBean> listaTelefoneBean = new ArrayList<TelefoneBean>();
		
		try{
			
			conn = AdvocaciaLCADBManager.obterConexao();
			
			String sql = " SELECT " +
					" TEL.CD_TELEFONE," +
					" TP_TEL.CD_TIPO_TELEFONE," +
					" TP_TEL.DS_TIPO_TELEFONE, " +
					" TEL.NR_DDD, " +
					" TEL.NR_TELEFONE " +
					" FROM " +
					" AM_TELEFONE TEL " +
					" INNER JOIN AM_TIPO_TELEFONE TP_TEL " +
					" ON TEL.CD_TIPO_TELEFONE = TP_TEL.CD_TIPO_TELEFONE " +
					" WHERE " +
					" TEL.CD_PESSOA = ?";
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, idCliente);
			rs = stmt.executeQuery();
			
			
			while(rs.next()){
				TipoTelefoneBean tpTelBean = new TipoTelefoneBean();
				tpTelBean.setCdTipoTelefone(rs.getInt("cd_tipo_telefone"));
				tpTelBean.setDsTipoTelefone(rs.getString("ds_tipo_telefone"));
				
				TelefoneBean telefoneBean = new TelefoneBean();
				telefoneBean.setCdTelefone(rs.getLong("cd_telefone"));
				telefoneBean.setTipoTelefone(tpTelBean);
				telefoneBean.setNrDDD(rs.getInt("nr_ddd"));
				telefoneBean.setNrTelefone(rs.getInt("nr_telefone"));
				listaTelefoneBean.add(telefoneBean);
			}	
			
		}catch(Exception e) {
			Logs.logger.info("OracleTelefoneDAO; public List<TelefoneBean> listar(int idCliente); " + e.toString());
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
		
		return listaTelefoneBean;
	}

}
