package br.com.advocacialca.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.advocacialca.beans.AgendaAudienciaBean;
import br.com.advocacialca.beans.ProcessoBean;
import br.com.advocacialca.interfaces.IAgendaAudienciaDAO;
import br.com.advocacialca.logs.Logs;


public class OracleAgendaAudienciaDAO implements IAgendaAudienciaDAO {

	public void cadastrar(AgendaAudienciaBean agendaAudienciaBean) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO AM_PROCESSO (cd_pessoa_adv, nr_processo, dt_hora_agenda, sl_forum) VALUES (?, ?, TO_DATE(?, 'DD/MM/YYYY'), ?)";
			
			stmt = conn.prepareStatement(sql); 
			
			stmt.setInt(1, agendaAudienciaBean.getCdPessoaAdv());
			stmt.setInt(2, agendaAudienciaBean.getNumProcesso().getNrProcesso());
			stmt.setDate(3,new java.sql.Date(agendaAudienciaBean.getDtHoraAgenda().getTime().getTime()));
			stmt.setNull(4, agendaAudienciaBean.getSlForum());
			
			stmt.execute();
			
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch(Exception e) {
			Logs.logger.info("OracleAgendaAudienciaDAO; cadastrar(AgendaAudienciaBean agendaAudienciaBean); " + e.toString());
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

	public void atualizar(AgendaAudienciaBean agendaAudienciaBean) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			
			String sql = "UPDATE AM_AGENDA_AUDIENCIA SET cd_pessoa_adv=?, nr_processo=?, dt_hora_audiencia=?, sl_forum=? WHERE cd_agenda=?";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(2, agendaAudienciaBean.getCdPessoaAdv());
			stmt.setInt(3, agendaAudienciaBean.getNumProcesso().getNrProcesso());
			stmt.setDate(5,new java.sql.Date(agendaAudienciaBean.getDtHoraAgenda().getTime().getTime()));
			stmt.setNull(6, agendaAudienciaBean.getSlForum());
			stmt.setInt(1, agendaAudienciaBean.getCdAgenda());
			
			stmt.execute();
			
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch(Exception e) {
			Logs.logger.info("OracleAgendaAudienciaDAO; public void atualizar(AgendaAudienciaBean agendaAudienciaBean); " + e.toString());
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

	public void remover(int idAgendaAudiencia) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			
			String sql = "DELETE FROM AM_AGENDA_AUDIENCIA WHERE cd_agenda = ?";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, idAgendaAudiencia);
			
			stmt.execute();
			
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch(Exception e) {
			Logs.logger.info("OracleAgendaAudienciaDAO; public void remover(int idAgendaAudiencia); " + e.toString());
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

	public AgendaAudienciaBean consultar(int idAgendaAudiencia) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		AgendaAudienciaBean agendaAudienciaBean = new AgendaAudienciaBean();
		ProcessoBean procBean = new ProcessoBean();
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			
			String sql = "SELECT PROCESSO.nr_processo, AGNDAUDIENCIA.cd_pessoa_adv, AGNDAUDIENCIA.dt_hora_agenda, AGNDAUDIENCIA.sl_forum  FROMAM_PROCESSO PROCESSO, AM_AGENDA_AUDIENCIA AGNDAUDIENCIA WHERE SELECT PROCESSO.nr_processo, AGNDAUDIENCIA.cd_pessoa_adv, AGNDAUDIENCIA.dt_hora_agenda, AGNDAUDIENCIA.sl_forum  FROMAM_PROCESSO PROCESSO, AM_AGENDA_AUDIENCIA AGNDAUDIENCIA WHERE AGNDAUDIENCIA.cd_agenda";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, idAgendaAudiencia);
			
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				
				procBean.setNrProcesso(rs.getInt("nr_processo"));
				
				agendaAudienciaBean.setCdAgenda(idAgendaAudiencia);
				agendaAudienciaBean.setCdPessoaAdv(rs.getInt("cd_pessoa_adv"));
				
				Calendar cal = Calendar.getInstance();
				
				cal.setTime(rs.getDate("dt_hora_audiencia"));
				
				agendaAudienciaBean.setDtHoraAgenda(cal);
				agendaAudienciaBean.setSlForum('u');
			}
			
		} catch(Exception e) {
			Logs.logger.info("OracleAgendaAudienciaDAO; public AgendaAudienciaBean consultar(int idAgendaAudiencia); " + e.toString());
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
		
		return agendaAudienciaBean;
	}

	public List<AgendaAudienciaBean> listar() {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<AgendaAudienciaBean> listaAgendaAudienciaBean = new ArrayList<AgendaAudienciaBean>();
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			
			String sql = "SELECT PROCESSO.nr_processo, AGNDAUDIENCIA.cd_pessoa_adv, AGNDAUDIENCIA.dt_hora_agenda, AGNDAUDIENCIA.sl_forum  FROMAM_PROCESSO PROCESSO, AM_AGENDA_AUDIENCIA AGNDAUDIENCIA WHERE AGNDAUDIENCIA.cd_agenda";
			
			stmt = conn.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				AgendaAudienciaBean agendaAudienciaBean = new AgendaAudienciaBean();
				ProcessoBean procBean = new ProcessoBean();
				agendaAudienciaBean.setCdAgenda(rs.getInt("cd_agenda"));
				agendaAudienciaBean.setCdPessoaAdv(rs.getInt("cd_pessoa_adv"));
				procBean.setNrProcesso(rs.getInt("nr_processo"));
				agendaAudienciaBean.setCdPessoaAdv(rs.getInt("cd_pessoa_adv"));
				
				Calendar cal = Calendar.getInstance();
				
				cal.setTime(rs.getDate("dt_hora_audiencia"));
				
				agendaAudienciaBean.setDtHoraAgenda(cal);
				agendaAudienciaBean.setSlForum('1');
				
				listaAgendaAudienciaBean.add(agendaAudienciaBean);
			}
			
		} catch(Exception e) {
			Logs.logger.info("OracleAgendaAudienciaDAO; public List<AgendaAudienciaBean> listar(); " + e.toString());
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
		
		return listaAgendaAudienciaBean;
	}

	
}
