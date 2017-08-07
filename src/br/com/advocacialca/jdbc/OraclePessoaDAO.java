package br.com.advocacialca.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.advocacialca.beans.PessoaBean;
import br.com.advocacialca.interfaces.IPessoaDAO;
import br.com.advocacialca.logs.Logs;

public class OraclePessoaDAO implements IPessoaDAO {

	@Override
	public void cadastrar(PessoaBean pesBean) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			String sql = null;
			
			sql ="INSERT INTO AM_PESSOA (cd_pessoa, nm_pessoa) VALUES (?,?)";
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, pesBean.getCdPessoa());
			stmt.setString(2, pesBean.getNmPessoa());
			
			stmt.execute();
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch (Exception e) {
			Logs.logger.info("OraclePessoaDAO; public void cadastrar(PessoaBean pesBean); " + e.toString());
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}finally{
				try {
					stmt.close();
					conn.close();
				} catch (Exception e2) {
					e.printStackTrace();
				}
			}
		}
		
	}

	@Override
	public void atualizar(PessoaBean pesBean) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			String sql = null;
			
			sql = "UPDATE AM_PESSOA SET nm_pessoa=? WHERE cd_pessoa = ?";
			stmt= conn.prepareStatement(sql);
			
			stmt.setString(1, pesBean.getNmPessoa());
			stmt.setInt(2, pesBean.getCdPessoa());
			
			stmt.execute();
			conn.commit();
			conn.setAutoCommit(true);
		
		} catch (Exception e) {
			Logs.logger.info("OraclePessoaDAO; public void atualizar(PessoaBean pesBean); " + e.toString());
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void remover(int cdPessoa) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			String sql = null;
			
			sql = "DELETE FROM AM_PESSOA WHERE cd_pessoa = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, cdPessoa);
			
			stmt.execute();
			conn.commit();
			conn.setAutoCommit(true);
			

		} catch (Exception e) {
			Logs.logger.info("OraclePessoaDAO; public void remover(int cdPessoa); " + e.toString());
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public PessoaBean consultar(int cdPessoa) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		PessoaBean pesBean = new PessoaBean();
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			String sql = null;
			
			sql = "SELECT nm_pessoa FROM AM_PESSOA WHERE cd_pessoa= ?";
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, cdPessoa);
			rs = stmt.executeQuery();
			if(rs.next()){
				pesBean.setCdPessoa(cdPessoa);
				pesBean.setNmPessoa(rs.getString("nm_pessoa"));
				}
					
		} catch (Exception e) {
			Logs.logger.info("OraclePessoaDAO; public PessoaBean consultar(int cdPessoa); " + e.toString());
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return pesBean;
	}

	@Override
	public List<PessoaBean> listar() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		PessoaBean pesBean = null;
		List<PessoaBean> pessoas = null;

		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			String sql = null;
			
			sql = "SELECT cd_pessoa, nm_pessoa FROM AM_PESSOA";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			pessoas = new ArrayList<PessoaBean>();
			
			while(rs.next()){
				pesBean = new PessoaBean();
				pesBean.setCdPessoa(rs.getInt("cd_pessoa"));
				pesBean.setNmPessoa(rs.getString("nm_pessoa"));
				
				pessoas.add(pesBean);
			}
			
		} catch (Exception e) {
			Logs.logger.info("OraclePessoaDAO; public List<PessoaBean> listar(); " + e.toString());
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return pessoas;
	}
	
}
