package br.com.advocacialca.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.advocacialca.beans.ForumBean;
import br.com.advocacialca.beans.PessoaBean;
import br.com.advocacialca.interfaces.IForumDAO;
import br.com.advocacialca.logs.Logs;


public class OracleForumDAO implements IForumDAO {
	
	public ForumBean consultar(int cdPessoaForum){
		
		ForumBean forumBean = null;
		PessoaBean pessoaBean = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			
			String sql = "SELECT PESSOA.nm_pessoa, FORUM.ds_forum FROM AM_PESSOA PESSOA, AM_FORUM FORUM" +
					" WHERE PESSOA.cd_pessoa = FORUM.cd_pessoa_forum AND PESSOA.cd_pessoa = ?";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, cdPessoaForum);
			
			rs = stmt.executeQuery();
			
			if(rs.next()){
				pessoaBean = new PessoaBean();
				pessoaBean.setCdPessoa(cdPessoaForum);
				pessoaBean.setNmPessoa(rs.getString("nm_pessoa"));
				
				forumBean = new ForumBean();
				forumBean.setPessoa(pessoaBean);
				forumBean.setDsForum(rs.getString("DS_FORUM"));
			}
		} catch(Exception e) {
			Logs.logger.info("OracleForumDAO; public ForumBean consultar(int cdPessoaForum); " + e.toString());
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
		
		return forumBean;
	}
	
	public void cadastrar(ForumBean forumBean){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO AM_FORUM (CD_PESSOA_FORUM, DS_FORUM) VALUES (?,?)";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, forumBean.getPessoa().getCdPessoa());
			stmt.setString(2, forumBean.getDsForum());
			
			stmt.execute();
			
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch(Exception e) {
			Logs.logger.info("OracleForumDAO; public void cadastrar(ForumBean forumbean); " + e.toString());
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
	
	public void atualizar(ForumBean forumbean){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			
			String sql = "UPDATE AM_FORUM SET DS_FORUM=? WHERE CD_PESSOA_FORUM = ?";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, forumbean.getDsForum());
			stmt.setInt(2, forumbean.getPessoa().getCdPessoa());
			
			stmt.execute();
			
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch(Exception e) {
			Logs.logger.info("OracleForumDAO; public void atualizar(ForumBean forumbean); " + e.toString());
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
	
	public void remover(int cdPessoaForum){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			
			String sql = "DELETE FROM AM_FORUM WHERE CD_PESSOA_FORUM = ?";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, cdPessoaForum);
			
			stmt.execute();
			
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch(Exception e) {
			Logs.logger.info("OracleForumDAO; public void remover(int cdPessoaForum); " + e.toString());
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

	public List<ForumBean> listar() {
		
		PessoaBean pessoaBean = null;
		ForumBean forumBean = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<ForumBean> listaForumBean = null;
		
		try {
			
			conn = AdvocaciaLCADBManager.obterConexao();
			listaForumBean = new ArrayList<ForumBean>();
			
			String sql = "SELECT PESSOA.cd_pessoa, PESSOA.nm_pessoa, FORUM.ds_forum FROM AM_PESSOA PESSOA," +
					" AM_FORUM FORUM WHERE PESSOA.cd_pessoa = FORUM.cd_pessoa_forum";
			
			stmt = conn.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			while(rs.next()){
				pessoaBean = new PessoaBean();
				pessoaBean.setCdPessoa(rs.getInt("cd_pessoa"));
				pessoaBean.setNmPessoa(rs.getString("nm_pessoa"));
				
				forumBean = new ForumBean();
				forumBean.setPessoa(pessoaBean);
				forumBean.setDsForum(rs.getString("DS_FORUM"));
				
				listaForumBean.add(forumBean);
				
			}
			
		} catch(Exception e) {
			Logs.logger.info("OracleForumDAO; public List<ForumBean> listar(); " + e.toString());
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
		
		
		return listaForumBean;
	}
	
}
