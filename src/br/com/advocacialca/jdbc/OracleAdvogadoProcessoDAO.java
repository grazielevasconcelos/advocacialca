package br.com.advocacialca.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.advocacialca.beans.AdvogadoBean;
import br.com.advocacialca.beans.AdvogadoProcessoBean;
import br.com.advocacialca.beans.PessoaBean;
import br.com.advocacialca.beans.ProcessoBean;
import br.com.advocacialca.beans.RespostaCRUD;
import br.com.advocacialca.interfaces.IAdvogadoProcessoDAO;
import br.com.advocacialca.logs.Logs;

public class OracleAdvogadoProcessoDAO implements IAdvogadoProcessoDAO {
	
	public RespostaCRUD cadastrar(AdvogadoProcessoBean advogadoProcesso){
		
		RespostaCRUD resp = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO AM_ADVOGADO_PROCESSO (nr_processo, cd_pessoa_adv, dt_inicio_participacao) VALUES (?, ?, ?)";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, advogadoProcesso.getProcesso().getNrProcesso());
			stmt.setInt(2, advogadoProcesso.getAdvogado().getPessoa().getCdPessoa());
			stmt.setDate(3, new java.sql.Date(advogadoProcesso.getDtInicioParticipacao().getTime().getTime()));
			
			stmt.execute();
			
			conn.commit();
			conn.setAutoCommit(true);
			
			resp = new RespostaCRUD(true, "Advogado associado ao processo com sucesso.");
			
		} catch (Exception e) {
			resp = new RespostaCRUD(false, e.toString());
			Logs.logger.info("OracleAdvogadoProcessoDAO; public void cadastrar(AdvogadoProcessoBean advogadoProcesso); " + e.toString());
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
		return resp;
	}
	
	
	public void atualizar(AdvogadoProcessoBean advogadoProcesso){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try{
			
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			
			String sql = "UPDATE AM_ADVOGADO_PROCESSO SET dt_inicio_participacao=? WHERE (nr_processo=? and cd_pessoa_adv=?)";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setDate(1, new java.sql.Date(advogadoProcesso.getDtInicioParticipacao().getTime().getTime()));
			stmt.setInt(2, advogadoProcesso.getProcesso().getNrProcesso());
			stmt.setInt(3, advogadoProcesso.getAdvogado().getPessoa().getCdPessoa());
			
			stmt.execute();
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch(Exception e) {
			Logs.logger.info("OracleAdvogadoProcessoDAO; public void atualizar(AdvogadoProcessoBean advogadoProcesso); " + e.toString());
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
	
	
	public AdvogadoProcessoBean consultar(int nrProcesso, int cdPessoaAdvogado){
		
		AdvogadoProcessoBean advogadoProcessoBean = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try{
			conn = AdvocaciaLCADBManager.obterConexao();
			
			String sql = "SELECT ADV_PROC.nr_processo, PROC.ds_processo, ADV_PROC.cd_pessoa_adv, PESSOA.nm_pessoa, ADV_PROC.dt_inicio_participacao FROM AM_ADVOGADO_PROCESSO ADV_PROC INNER JOIN AM_PROCESSO PROC ON ADV_PROC.nr_processo = PROC.nr_processo INNER JOIN AM_PESSOA PESSOA ON ADV_PROC.cd_pessoa_adv = PESSOA.cd_pessoa WHERE (adv_proc.nr_processo=? AND adv_proc.cd_pessoa_adv=?)";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, nrProcesso);
			stmt.setInt(2, cdPessoaAdvogado);
			
			rs = stmt.executeQuery();
			
			if(rs.next()){
				advogadoProcessoBean = new AdvogadoProcessoBean();
				ProcessoBean processoBean = new ProcessoBean();
				processoBean.setNrProcesso(rs.getInt("NR_PROCESSO"));
				processoBean.setDsProcesso(rs.getString("DS_PROCESSO"));
				
				PessoaBean pessoaBean = new PessoaBean();
				pessoaBean.setCdPessoa(rs.getInt("CD_PESSOA_ADV"));
				pessoaBean.setNmPessoa(rs.getString("NM_PESSOA"));
				AdvogadoBean advogadoBean = new AdvogadoBean();
				advogadoBean.setPessoa(pessoaBean);
				
				Calendar cal = Calendar.getInstance();
				java.sql.Date dtInicioParticipacao = rs.getDate("DT_INICIO_PARTICIPACAO");
				if (dtInicioParticipacao != null )
					cal.setTime(dtInicioParticipacao);
				
				advogadoProcessoBean.setProcesso(processoBean);
				advogadoProcessoBean.setAdvogado(advogadoBean);
				advogadoProcessoBean.setDtInicioParticipacao(cal);
			}
			
		} catch(Exception e) {
			Logs.logger.info("OracleAdvogadoProcessoDAO; public AdvogadoProcessoBean consultar(ProcessoBean processo, AdvogadoBean advogado); " + e.toString());
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
		
		return advogadoProcessoBean;
	}
	
	
	public List<AdvogadoProcessoBean> listar(int nrProcesso){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<AdvogadoProcessoBean> listaAdvogadoProcesso = null;
		
		try{
			conn = AdvocaciaLCADBManager.obterConexao();
			
			String sql = "SELECT ADV_PROC.nr_processo, PROC.ds_processo, ADV_PROC.cd_pessoa_adv, PESSOA.nm_pessoa, ADV_PROC.dt_inicio_participacao, ADVOGADO.nr_oab, ADVOGADO.ds_email FROM AM_ADVOGADO_PROCESSO ADV_PROC INNER JOIN AM_PROCESSO PROC ON ADV_PROC.nr_processo = PROC.nr_processo INNER JOIN AM_PESSOA PESSOA ON ADV_PROC.cd_pessoa_adv = PESSOA.cd_pessoa INNER JOIN AM_ADVOGADO ADVOGADO ON ADV_PROC.cd_pessoa_adv = ADVOGADO.cd_pessoa_adv WHERE ADV_PROC.nr_processo=?";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, nrProcesso);
			
			rs = stmt.executeQuery();
			
			while(rs.next()){
				if (listaAdvogadoProcesso == null)
					listaAdvogadoProcesso = new ArrayList<AdvogadoProcessoBean>();
				
				AdvogadoProcessoBean advogadoProcessoBean = new AdvogadoProcessoBean();
				
				ProcessoBean processoBean = new ProcessoBean();
				processoBean.setNrProcesso(rs.getInt("NR_PROCESSO"));
				processoBean.setDsProcesso(rs.getString("DS_PROCESSO"));
				
				PessoaBean pessoaBean = new PessoaBean();
				pessoaBean.setCdPessoa(rs.getInt("CD_PESSOA_ADV"));
				pessoaBean.setNmPessoa(rs.getString("NM_PESSOA"));
				AdvogadoBean advogadoBean = new AdvogadoBean();
				advogadoBean.setPessoa(pessoaBean);
				advogadoBean.setNrOAB(rs.getInt("NR_OAB"));
				advogadoBean.setDsEmail(rs.getString("DS_EMAIL"));
				
				Calendar cal = Calendar.getInstance();
				java.sql.Date dtInicioParticipacao = rs.getDate("DT_INICIO_PARTICIPACAO");
				if (dtInicioParticipacao != null )
					cal.setTime(dtInicioParticipacao);
				
				advogadoProcessoBean.setProcesso(processoBean);
				advogadoProcessoBean.setAdvogado(advogadoBean);
				advogadoProcessoBean.setDtInicioParticipacao(cal);
				
				listaAdvogadoProcesso.add(advogadoProcessoBean);				
			}
			
		} catch(Exception e) {
			Logs.logger.info("OracleAdvogadoProcessoDAO; public List<AdvogadoProcessoBean> listar(int nrProcesso); " + e.toString());
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
		
		return listaAdvogadoProcesso;
		
	}

}
