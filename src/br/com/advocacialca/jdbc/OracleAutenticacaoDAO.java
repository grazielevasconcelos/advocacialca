package br.com.advocacialca.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.advocacialca.beans.AdvogadoBean;
import br.com.advocacialca.beans.PessoaBean;
import br.com.advocacialca.interfaces.IAutenticacaoDAO;

public class OracleAutenticacaoDAO implements IAutenticacaoDAO {
	
	public PessoaBean logarSecretaria(String login, String senha) {
		
		return null;
		
	}

	public AdvogadoBean logarAdvogado(String login, String senha) {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		AdvogadoBean advBean = null;
		PessoaBean pessoaBean = null;
		
		try {
			
			conn = AdvocaciaLCADBManager.obterConexao();
			
			String sql = "SELECT" +
					" ADVOGADO.cd_pessoa_adv," +
					" PESSOA.nm_pessoa," +
					" ADVOGADO.nr_oab," +
					" ADVOGADO.nr_cpf," +
					" ADVOGADO.nr_rg," +
					" ADVOGADO.ds_email," +
					" ADVOGADO.ds_password" +
					" FROM" +
					" AM_ADVOGADO ADVOGADO" +
					" inner join AM_PESSOA PESSOA" +
					" on PESSOA.cd_pessoa = ADVOGADO.cd_pessoa_adv" +
					" WHERE ADVOGADO.DS_EMAIL = ? AND ADVOGADO.DS_PASSWORD = ?";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, login);
			stmt.setString(2, senha);
			
			rs = stmt.executeQuery();
			
			if(rs.next()){
				pessoaBean = new PessoaBean();
				pessoaBean.setCdPessoa(rs.getInt("cd_pessoa_adv"));
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

}
