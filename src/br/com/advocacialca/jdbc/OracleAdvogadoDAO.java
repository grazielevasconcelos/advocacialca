package br.com.advocacialca.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.advocacialca.beans.AdvogadoBean;
import br.com.advocacialca.beans.PessoaBean;
import br.com.advocacialca.interfaces.IAdvogadoDAO;
import br.com.advocacialca.logs.Logs;

public class OracleAdvogadoDAO implements IAdvogadoDAO {
	
	public void cadastrar (AdvogadoBean advBean){
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			String sql = null;
			sql = "INSERT INTO AM_ADVOGADO (cd_pessoa_adv, nr_OAB, nr_CPF,nr_RG,ds_email,ds_password) VALUES (?,?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1,advBean.getPessoa().getCdPessoa());
			stmt.setInt(2, advBean.getNrOAB());
			stmt.setLong(3, advBean.getNrCPF());
			stmt.setString(4, advBean.getNrRG());
			stmt.setString(5, advBean.getDsEmail());
			stmt.setString(6, advBean.getDsPassword());
			
			stmt.execute();
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch (Exception e) {
			Logs.logger.info("OracleAdvogadoDAO; public void cadastrar (AdvogadoBean advBean); " + e.toString());
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	public void atualizar (AdvogadoBean advBean){
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			String sql = null;
			
			sql = "UPDATE AM_ADVOGADO SET nr_OAB=?, nr_CPF=?,nr_RG=?,ds_email=?,ds_password=? WHERE cd_pessoa_adv = ?";
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, advBean.getNrOAB());
			stmt.setLong(2, advBean.getNrCPF());
			stmt.setString(3, advBean.getNrRG());
			stmt.setString(4, advBean.getDsEmail());
			stmt.setString(5, advBean.getDsPassword());
			stmt.setInt(6, advBean.getPessoa().getCdPessoa());
			
			stmt.execute();
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch (Exception e) {
			Logs.logger.info("OracleAdvogadoDAO; public void atualizar (AdvogadoBean advBean); " + e.toString());
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}	
			e.printStackTrace();
		}finally{
			try {
				conn.close();
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void remover (int cdAdvogado){
			Connection conn = null;
			PreparedStatement stmt = null;
			try {
				conn = AdvocaciaLCADBManager.obterConexao();
				conn.setAutoCommit(false);
				String sql = null;
				
				sql = "DELETE FROM AM_ADVOGADO WHERE cd_pessoa_adv = ?";
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, cdAdvogado);
				
				stmt.execute();
				conn.commit();
				conn.setAutoCommit(true);
				
			} catch (Exception e) {
				Logs.logger.info("OracleAdvogadoDAO; public void remover (int cdAdvogado); " + e.toString());
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
	
	public AdvogadoBean consultar(int cdAdvogado){
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			AdvogadoBean advBean = null;
			PessoaBean pessoaBean = null;
			
			try {
				
				conn = AdvocaciaLCADBManager.obterConexao();
				String sql = null;
				
				sql = "SELECT PESSOA.nm_pessoa, ADVOGADO.nr_oab, ADVOGADO.nr_cpf, ADVOGADO.nr_rg," +
						" ADVOGADO.ds_email, ADVOGADO.ds_password FROM AM_ADVOGADO ADVOGADO, AM_PESSOA PESSOA" +
						" WHERE PESSOA.cd_pessoa = ? AND PESSOA.cd_pessoa = ADVOGADO.cd_pessoa_adv";
				
				stmt = conn.prepareStatement(sql);
				
				stmt.setInt(1, cdAdvogado);
				
				rs = stmt.executeQuery();
				
				if(rs.next()){
					pessoaBean = new PessoaBean();
					pessoaBean.setCdPessoa(cdAdvogado);
					pessoaBean.setNmPessoa(rs.getString("nm_pessoa"));
					
					advBean = new AdvogadoBean();
					advBean.setPessoa(pessoaBean);
					advBean.setNrOAB(rs.getInt("nr_OAB"));
					advBean.setNrCPF(rs.getLong("nr_CPF"));
					advBean.setNrRG(rs.getString("nr_RG"));
					advBean.setDsEmail(rs.getString("ds_email"));
					advBean.setDsPassword(rs.getString("ds_password"));
				}
				
			} catch (Exception e) {
				Logs.logger.info("OracleAdvogadoDAO; public AdvogadoBean consultar(int cdAdvogado); " + e.toString());
				e.printStackTrace();
			}finally{
				try {
					rs.close();
					conn.close();
					stmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return advBean;
	}
		
	public List<AdvogadoBean> listar(){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		AdvogadoBean advBean = null;
		PessoaBean pessoaBean = null;
		List<AdvogadoBean> advogados = null;
		
		try {
			
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			String sql = null;
			
			sql = "SELECT PESSOA.cd_pessoa, PESSOA.nm_pessoa, ADVOGADO.nr_oab, ADVOGADO.nr_cpf, ADVOGADO.nr_rg," +
					" ADVOGADO.ds_email, ADVOGADO.ds_password FROM AM_ADVOGADO ADVOGADO, AM_PESSOA PESSOA" +
					" WHERE PESSOA.cd_pessoa = ADVOGADO.cd_pessoa_adv";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			advogados = new ArrayList<AdvogadoBean> ();
			
			while(rs.next()){
				pessoaBean = new PessoaBean();
				pessoaBean.setCdPessoa(rs.getInt("cd_pessoa"));
				pessoaBean.setNmPessoa(rs.getString("nm_pessoa"));
				
				advBean = new AdvogadoBean();
				advBean.setPessoa(pessoaBean);
				advBean.setNrOAB(rs.getInt("nr_OAB"));
				advBean.setNrCPF(rs.getLong("nr_CPF"));
				advBean.setNrRG(rs.getString("nr_RG"));
				advBean.setDsEmail(rs.getString("ds_email"));
				advBean.setDsPassword(rs.getString("ds_password"));
				
				advogados.add(advBean);
			}
			
		} catch (Exception e) {
			Logs.logger.info("OracleAdvogadoDAO; public List<AdvogadoBean> listar(); " + e.toString());
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return advogados;
	}	
		
	public List<AdvogadoBean> listarPorProcesso(int nrProcesso){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		AdvogadoBean advBean = null;
		PessoaBean pessoaBean = null;
		List<AdvogadoBean> advogados = null;
		
		try {
			
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			String sql = null;
			
			sql = "SELECT PESSOA.cd_pessoa, PESSOA.nm_pessoa, ADVOGADO.nr_oab, ADVOGADO.nr_cpf, ADVOGADO.nr_rg," +
					" ADVOGADO.ds_email, ADVOGADO.ds_password" +
					" FROM" +
					" AM_ADVOGADO ADVOGADO" +
					" INNER JOIN AM_PESSOA PESSOA" +
					" ON PESSOA.cd_pessoa = ADVOGADO.cd_pessoa_adv" +
					" INNER JOIN AM_ADVOGADO_PROCESSO" +
					" ON PESSOA.cd_pessoa = AM_ADVOGADO_PROCESSO.cd_pessoa_adv" +
					" WHERE AM_ADVOGADO_PROCESSO.nr_processo = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, nrProcesso);
			rs = stmt.executeQuery();
			
			advogados = new ArrayList<AdvogadoBean>();
			
			while(rs.next()){
				pessoaBean = new PessoaBean();
				pessoaBean.setCdPessoa(rs.getInt("cd_pessoa"));
				pessoaBean.setNmPessoa(rs.getString("nm_pessoa"));
				
				advBean = new AdvogadoBean();
				advBean.setPessoa(pessoaBean);
				advBean.setNrOAB(rs.getInt("nr_OAB"));
				advBean.setNrCPF(rs.getLong("nr_CPF"));
				advBean.setNrRG(rs.getString("nr_RG"));
				advBean.setDsEmail(rs.getString("ds_email"));
				advBean.setDsPassword(rs.getString("ds_password"));
				
				advogados.add(advBean);
			}
			
		} catch (Exception e) {
			Logs.logger.info("OracleAdvogadoDAO; public List<AdvogadoBean> listarPorProcesso(int nrProcesso); " + e.toString());
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return advogados;
	}

	public List<AdvogadoBean> obterPossiveisNovosAdvogados(int nrProcesso){
		List<AdvogadoBean> listaAdvogados = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		AdvogadoBean advogadoBean = null;
		PessoaBean pessoaBean = null;
		
		try{
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			
			String sql = "SELECT PESS.cd_pessoa, PESS.nm_pessoa, ADVOGADO.nr_oab, ADVOGADO.nr_cpf, ADVOGADO.nr_rg, ADVOGADO.ds_email, ADVOGADO.ds_password FROM AM_ADVOGADO ADVOGADO INNER JOIN AM_PESSOA PESS ON ADVOGADO.CD_PESSOA_ADV = PESS.CD_PESSOA INNER JOIN AM_ADVOGADO_TIPO_CAUSA ADV_TPCAUSA ON ADV_TPCAUSA.CD_PESSOA_ADV = ADVOGADO.CD_PESSOA_ADV WHERE ADV_TPCAUSA.CD_CAUSA = (SELECT CD_CAUSA FROM AM_PROCESSO PROC WHERE PROC.NR_PROCESSO = ?) AND ADVOGADO.CD_PESSOA_ADV NOT IN (SELECT ADV_PROC.CD_PESSOA_ADV FROM AM_ADVOGADO_PROCESSO ADV_PROC WHERE ADV_PROC.NR_PROCESSO = ?) ORDER BY ADVOGADO.CD_PESSOA_ADV";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, nrProcesso);
			stmt.setInt(2, nrProcesso);
			
			rs = stmt.executeQuery();
			
			while(rs.next()){
				if (listaAdvogados == null)
					listaAdvogados = new ArrayList<AdvogadoBean>();
				
				pessoaBean = new PessoaBean();
				pessoaBean.setCdPessoa(rs.getInt("cd_pessoa"));
				pessoaBean.setNmPessoa(rs.getString("nm_pessoa"));
				
				advogadoBean = new AdvogadoBean();
				advogadoBean.setPessoa(pessoaBean);
				advogadoBean.setNrOAB(rs.getInt("nr_OAB"));
				advogadoBean.setNrCPF(rs.getLong("nr_CPF"));
				advogadoBean.setNrRG(rs.getString("nr_RG"));
				advogadoBean.setDsEmail(rs.getString("ds_email"));
				advogadoBean.setDsPassword(rs.getString("ds_password"));
				
				listaAdvogados.add(advogadoBean);				
			}
			
		} catch (Exception e) {
			Logs.logger.info("OracleAdvogadoDAO; public List<AdvogadoBean> ObterPossiveisNovosAdvogados(int nrProcesso); " + e.toString());
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listaAdvogados;
	}	

}
