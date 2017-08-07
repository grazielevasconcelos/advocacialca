package br.com.advocacialca.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.advocacialca.beans.TarefaBean;
import br.com.advocacialca.interfaces.ITarefaDAO;
import br.com.advocacialca.logs.Logs;

public class OracleTarefaDAO implements ITarefaDAO {
	public TarefaBean consultar(int cdTarefa) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		TarefaBean tarefaBean = new TarefaBean();
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			
			String sql = "SELECT * FROM AM_TAREFA WHERE CD_TAREFA = ?";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, cdTarefa);
			
			rs = stmt.executeQuery();
			
			if (rs.next()){
				tarefaBean.setCdTarefa(cdTarefa);
				tarefaBean.setDsTarefa(rs.getString("DS_TAREFA"));
			}
			
		} catch(Exception e) {
			Logs.logger.info("OracleTarefaDAO; public TarefaBean consultar(int cdTarefa); " + e.toString());
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
		
		return tarefaBean;
		
	}

	public void cadastrar(TarefaBean tarefaBean) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO AM_TAREFA (CD_TAREFA, DS_TAREFA) VALUES (?,?)";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, tarefaBean.getCdTarefa());
			stmt.setString(2, tarefaBean.getDsTarefa());
			
			stmt.execute();
			
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch(Exception e) {
			Logs.logger.info("OracleTarefaDAO; public void cadastrar(TarefaBean tarefaBean); " + e.toString());
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

	public void atualizar(TarefaBean tarefaBean) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			
			String sql = "UPDATE AM_TAREFA SET DS_TAREFA=? WHERE CD_TAREFA=?";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, tarefaBean.getDsTarefa());
			stmt.setInt(2, tarefaBean.getCdTarefa());
			
			stmt.execute();
			
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch(Exception e) {
			Logs.logger.info("OracleTarefaDAO; public void atualizar(TarefaBean tarefaBean); " + e.toString());
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

	public void remover(int cdTarefa) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			
			String sql = "DELETE FROM AM_TAREFA WHERE CD_TAREFA=?";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, cdTarefa);
			
			stmt.execute();
			
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch(Exception e) {
			Logs.logger.info("OracleTarefaDAO; public void remover(int cdTarefa); " + e.toString());
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

	public List<TarefaBean> listar() {
		
		List<TarefaBean> listaTarefaBean = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = AdvocaciaLCADBManager.obterConexao();
			listaTarefaBean = new ArrayList<TarefaBean>();			
			
			String sql = "SELECT CD_TAREFA,DS_TAREFA FROM AM_TAREFA";
			
			stmt = conn.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			while(rs.next()){
				
				TarefaBean tarefaBean = new TarefaBean();
				
				tarefaBean.setCdTarefa(rs.getInt("CD_TAREFA"));
				tarefaBean.setDsTarefa(rs.getString("DS_TAREFA"));
				
				listaTarefaBean.add(tarefaBean);
				
			}
			
		} catch(Exception e) {
			Logs.logger.info("OracleTarefaDAO; public List<TarefaBean> listar(); " + e.toString());
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
		
		return listaTarefaBean;
	}

}
