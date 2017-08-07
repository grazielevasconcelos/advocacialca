package br.com.advocacialca.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.advocacialca.beans.ClienteBean;
import br.com.advocacialca.beans.PessoaBean;
import br.com.advocacialca.interfaces.IClienteDAO;
import br.com.advocacialca.logs.Logs;

public class OracleClienteDAO implements IClienteDAO {
	
	@Override
	public void cadastrar(ClienteBean cliBean) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			String sql = null;
			
			sql ="INSERT INTO AM_CLIENTE (cd_pessoa_cliente, nm_razao_social, nr_cnpj, nr_insc_estadual," +
					" ds_email, ds_password) VALUES (?,?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, cliBean.getPessoa().getCdPessoa());
			stmt.setString(2, cliBean.getNmRazaoSocial());
			stmt.setLong(3, cliBean.getNrCNPJ());
			stmt.setLong(4, cliBean.getNrInscEstadual());
			stmt.setString(5, cliBean.getDsEmail());
			stmt.setString(6, cliBean.getDsPassword());
			
			stmt.execute();
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch (Exception e) {
			Logs.logger.info("OracleClienteDAO; public void cadastrar(ClienteBean cliBean); " + e.toString());
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
	public void atualizar(ClienteBean cliBean) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			String sql = null;
			
			sql = "UPDATE AM_CLIENTE SET nm_razao_social=?, nr_cnpj=?, nr_insc_estadual=?," +
					" ds_email=?, ds_password=? WHERE cd_pessoa_cliente = ?";
			stmt= conn.prepareStatement(sql);
			
			stmt.setString(1, cliBean.getNmRazaoSocial());
			stmt.setLong(2, cliBean.getNrCNPJ());
			stmt.setLong(3, cliBean.getNrInscEstadual());
			stmt.setString(4, cliBean.getDsEmail());
			stmt.setString(5, cliBean.getDsPassword());
			stmt.setInt(6, cliBean.getPessoa().getCdPessoa());
			
			stmt.execute();
			conn.commit();
			conn.setAutoCommit(true);
		
		} catch (Exception e) {
			Logs.logger.info("OracleClienteDAO; public void atualizar(ClienteBean cliBean); " + e.toString());
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
	public void remover(int cdCliente) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			String sql = null;
			
			sql = "DELETE FROM AM_CLIENTE WHERE cd_pessoa_cliente = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, cdCliente);
			
			stmt.execute();
			conn.commit();
			conn.setAutoCommit(true);
			

		} catch (Exception e) {
			Logs.logger.info("OracleClienteDAO; public void remover(int cdCliente); " + e.toString());
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
	public ClienteBean consultar(int cdCliente) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ClienteBean cliBean = null;
		PessoaBean pessoaBean = null;
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			String sql = null;
			
			sql = "SELECT PESSOA.nm_pessoa, CLIENTE.nm_razao_social, CLIENTE.nr_cnpj, CLIENTE.nr_insc_estadual," +
					" CLIENTE.ds_email, CLIENTE.ds_password FROM AM_CLIENTE CLIENTE, AM_PESSOA PESSOA " +
					"WHERE CLIENTE.cd_pessoa_cliente = ? AND PESSOA.cd_pessoa = CLIENTE.cd_pessoa_cliente";
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, cdCliente);
			rs = stmt.executeQuery();
			
			if(rs.next()){
				pessoaBean = new PessoaBean();
				pessoaBean.setCdPessoa(cdCliente);
				pessoaBean.setNmPessoa(rs.getString("nm_pessoa"));
				
				cliBean = new ClienteBean();
				cliBean.setPessoa(pessoaBean);
				cliBean.setNmRazaoSocial(rs.getString("nm_razao_social"));
				cliBean.setNrCNPJ(rs.getLong("nr_cnpj"));
				cliBean.setNrInscEstadual(rs.getLong("nr_insc_estadual"));
				cliBean.setDsEmail(rs.getString("ds_email"));
				cliBean.setDsPassword(rs.getString("ds_password"));
			}
					
		} catch (Exception e) {
			Logs.logger.info("OracleClienteDAO; public ClienteBean consultar(int cdCliente); " + e.toString());
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
		
		return cliBean;
	}

	@Override
	public List<ClienteBean> listar() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ClienteBean cliBean = null;
		List<ClienteBean> clientes = null;

		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			String sql = null;
			PessoaBean pessoaBean = null;
			
			sql = "SELECT PESSOA.cd_pessoa, PESSOA.nm_pessoa, CLIENTE.nm_razao_social, CLIENTE.nr_cnpj, " +
					"CLIENTE.nr_insc_estadual, CLIENTE.ds_email, CLIENTE.ds_password " +
					"FROM AM_CLIENTE CLIENTE, AM_PESSOA PESSOA WHERE CLIENTE.cd_pessoa_cliente = PESSOA.cd_pessoa" + 
					" ORDER BY PESSOA.cd_pessoa";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			clientes = new ArrayList<ClienteBean>();
			
			while(rs.next()){
				pessoaBean = new PessoaBean();
				pessoaBean.setCdPessoa(rs.getInt("cd_pessoa"));
				pessoaBean.setNmPessoa(rs.getString("nm_pessoa"));
				
				cliBean = new ClienteBean();
				cliBean.setPessoa(pessoaBean);
				cliBean.setNmRazaoSocial(rs.getString("nm_razao_social"));
				cliBean.setNrCNPJ(rs.getLong("nr_cnpj"));
				cliBean.setNrInscEstadual(rs.getLong("nr_insc_estadual"));
				cliBean.setDsEmail(rs.getString("ds_email"));
				cliBean.setDsPassword(rs.getString("ds_password"));
				
				clientes.add(cliBean);
			}
			
		} catch (Exception e) {
			Logs.logger.info("OracleClienteDAO; public List<ClienteBean> listar(); " + e.toString());
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
		return clientes;
	}
	
}
