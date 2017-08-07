package br.com.advocacialca.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.advocacialca.beans.AdvogadoBean;
import br.com.advocacialca.beans.AdvogadoHonorarioBean;
import br.com.advocacialca.beans.PessoaBean;
import br.com.advocacialca.beans.ProcessoBean;
import br.com.advocacialca.beans.RespostaCRUD;
import br.com.advocacialca.beans.TarefaBean;
import br.com.advocacialca.interfaces.IAdvogadoHonorarioDAO;
import br.com.advocacialca.logs.Logs;

public class OracleAdvogadoHonorarioDAO implements IAdvogadoHonorarioDAO {
	
	public RespostaCRUD cadastrar(AdvogadoHonorarioBean advogadoHonorarioBean) {
		
		RespostaCRUD resp = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO AM_ADVOGADO_HONORARIO (cd_pessoa_adv, cd_tarefa, nr_processo, qt_horas, dt_honorario, ds_observacao) VALUES (?, ?, ?, ?, ?, ?)";
			
			stmt = conn.prepareStatement(sql); 

			stmt.setInt(1, advogadoHonorarioBean.getAdvogado().getPessoa().getCdPessoa());
			stmt.setInt(2, advogadoHonorarioBean.getTarefa().getCdTarefa());
			stmt.setInt(3, advogadoHonorarioBean.getProcesso().getNrProcesso());
			stmt.setInt(4, advogadoHonorarioBean.getQtHoras());
			stmt.setDate(5, new java.sql.Date(advogadoHonorarioBean.getDtHonorario().getTime().getTime()));
			stmt.setString(6, String.valueOf(advogadoHonorarioBean.getDsObservacao()));
			
			stmt.execute();
			
			conn.commit();
			conn.setAutoCommit(true);
			resp = new RespostaCRUD(true, "Honor‡rio cadastrado com sucesso.");
			
		} catch(Exception e) {
			resp = new RespostaCRUD(false, e.toString());
			Logs.logger.info("OracleAdvogadoHonorarioDAO; public void cadastrar(AdvogadoHonorarioBean tipoCobrancaBean); " + e.toString());
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

	public void atualizar(AdvogadoHonorarioBean advogadoHonorarioBean) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			
			String sql = "UPDATE AM_ADVOGADO_HONORARIO SET cd_pessoa_adv=?, cd_tarefa=?, nr_processo=?, qt_horas=?, dt_honorario=?, ds_observacao=? WHERE cd_honorario=?";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, advogadoHonorarioBean.getAdvogado().getPessoa().getCdPessoa());
			stmt.setInt(2, advogadoHonorarioBean.getTarefa().getCdTarefa());
			stmt.setInt(3, advogadoHonorarioBean.getProcesso().getNrProcesso());
			stmt.setInt(4, advogadoHonorarioBean.getQtHoras());
			stmt.setDate(5, new java.sql.Date(advogadoHonorarioBean.getDtHonorario().getTime().getTime()));
			stmt.setString(6, String.valueOf(advogadoHonorarioBean.getDsObservacao()));
			stmt.setInt(7, advogadoHonorarioBean.getCdHonorario());
			
			stmt.execute();
			
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch(Exception e) {
			Logs.logger.info("OracleAdvogadoHonorarioDAO; public void atualizar(AdvogadoHonorarioBean tipoCobrancaBean); " + e.toString());
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
			
			String sql = "DELETE FROM AM_ADVOGADO_HONORARIO WHERE cd_honorario = ?";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, idTipoHonorario);
			
			stmt.execute();
			
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch(Exception e) {
			Logs.logger.info("OracleAdvogadoHonorarioDAO; public void remover(int idTipoCobranca); " + e.toString());
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

	public AdvogadoHonorarioBean consultar(int idTipoCobranca) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		AdvogadoHonorarioBean advogadoHonorarioBean = new AdvogadoHonorarioBean();
		TarefaBean tBean = new TarefaBean();
		PessoaBean pessoaBean = new PessoaBean();
		AdvogadoBean advogadoBean = new AdvogadoBean();
		ProcessoBean processoBean = new ProcessoBean();
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			
			String sql = "SELECT TAREFA.cd_tarefa, ADV_HONORARIO.cd_pessoa_adv, ADV_HONORARIO.nr_processo, ADV_HONORARIO.qt_horas, ADV_HONORARIO.dt_honorario, ADV_HONORARIO.ds_observacao FROM AM_TAREFA TAREFA, AM_ADVOGADO_HONORARIO ADV_HONORARIO WHERE ADV_HONORARIO.cd_honorario=?";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, idTipoCobranca);
			
			rs = stmt.executeQuery();
			
			if (rs.next()) {
								
				
				advogadoHonorarioBean.setCdHonorario(idTipoCobranca);
				
				processoBean.setNrProcesso(rs.getInt("nr_processo"));
				advogadoHonorarioBean.setProcesso(processoBean);

				pessoaBean.setCdPessoa(rs.getInt("cd_pessoa_adv"));
				advogadoBean.setPessoa(pessoaBean);
				advogadoHonorarioBean.setAdvogado(advogadoBean);

				tBean.setCdTarefa(rs.getInt("cd_tarefa"));
				advogadoHonorarioBean.setTarefa(tBean);
				
				advogadoHonorarioBean.setQtHoras(rs.getInt("qt_horas"));
				
				Calendar cal = Calendar.getInstance();
				cal.setTime(rs.getDate("dt_honorario"));
				advogadoHonorarioBean.setDtHonorario(cal);
				advogadoHonorarioBean.setDsObservacao(rs.getString("ds_observacao"));
			}
			
		} catch(Exception e) {
			Logs.logger.info("OracleAdvogadoHonorarioDAO; public AdvogadoHonorarioBean consultar(int idTipoCobranca); " + e.toString());
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
		
		return advogadoHonorarioBean;
	}

	public List<AdvogadoHonorarioBean> listar(int idAdvogado) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<AdvogadoHonorarioBean> listaTipoCobrancaBean = new ArrayList<AdvogadoHonorarioBean>();
		ProcessoBean processoBean = new ProcessoBean();
		PessoaBean pessoaBean = new PessoaBean();
		AdvogadoBean advogadoBean = new AdvogadoBean();
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			
			String sql = "SELECT TAREFA.cd_tarefa, TAREFA.ds_tarefa, ADV_HONORARIO.cd_honorario, ADV_HONORARIO.cd_pessoa_adv, ADV_HONORARIO.nr_processo, ADV_HONORARIO.qt_horas, ADV_HONORARIO.dt_honorario, ADV_HONORARIO.ds_observacao FROM AM_TAREFA TAREFA INNER JOIN AM_ADVOGADO_HONORARIO ADV_HONORARIO ON TAREFA.cd_tarefa = ADV_HONORARIO.cd_tarefa WHERE ADV_HONORARIO.cd_pessoa_adv=? ORDER BY ADV_HONORARIO.nr_processo";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, idAdvogado);
			
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				AdvogadoHonorarioBean advogadoHonorarioBean = new AdvogadoHonorarioBean(); 

				advogadoHonorarioBean.setCdHonorario(rs.getInt("cd_honorario"));
				
				TarefaBean tBean = new TarefaBean();
				tBean.setCdTarefa(rs.getInt("cd_tarefa"));
				tBean.setDsTarefa(rs.getString("ds_tarefa"));
				advogadoHonorarioBean.setTarefa(tBean);
				
				processoBean = new ProcessoBean();
				processoBean.setNrProcesso(rs.getInt("nr_processo"));
				advogadoHonorarioBean.setProcesso(processoBean);
				
				pessoaBean.setCdPessoa(idAdvogado);
				advogadoBean.setPessoa(pessoaBean);
				advogadoHonorarioBean.setAdvogado(advogadoBean);
				
				advogadoHonorarioBean.setQtHoras(rs.getInt("qt_horas"));
				
				Calendar cal = Calendar.getInstance();
				cal.setTime(rs.getDate("dt_honorario"));
				advogadoHonorarioBean.setDtHonorario(cal);
				
				advogadoHonorarioBean.setDsObservacao(rs.getString("ds_observacao"));
				
				listaTipoCobrancaBean.add(advogadoHonorarioBean);
			}
			
		} catch(Exception e) {
			Logs.logger.info("OracleAdvogadoHonorarioDAO; public List<AdvogadoHonorarioBean> listar(int idAdvogado); " + e.toString());
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
