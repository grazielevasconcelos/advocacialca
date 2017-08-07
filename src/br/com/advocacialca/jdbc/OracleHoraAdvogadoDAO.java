package br.com.advocacialca.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.advocacialca.logs.Logs;

import br.com.advocacialca.beans.HoraAdvogadoBean;
import br.com.advocacialca.beans.PessoaBean;
import br.com.advocacialca.interfaces.IHoraAdvogadoDAO;

public class OracleHoraAdvogadoDAO implements IHoraAdvogadoDAO  {
	
	@Override
	public void cadastrar(HoraAdvogadoBean hrAdvBean) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			String sql = null;
			
			sql = "INSERT INTO AM_HORA_ADVOGADO (cd_pessoa_adv,dt_vigencia,vl_hora) VALUES (?,?,?)";
			stmt = conn.prepareStatement(sql);
			//Calendar calendar = Calendar.getInstance();
			//java.sql.Date javaSqlDate = new java.sql.Date(calendar.getTime().getTime());
			//stmt.setDate(2, hrAdvBean.getDtVigente(), calendar);
			
			stmt.setInt(1, hrAdvBean.getAdvogado().getCdPessoa());
			stmt.setDate(2, hrAdvBean.getDtVigente());
			stmt.setDouble(3, hrAdvBean.getVlHora());
			
			stmt.execute();
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch (Exception e) {
			Logs.logger.info("OracleHoraAdvogadoDAO; public void cadastrar(HoraAdvogadoBean hrAdvBean); " + e.toString());
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} e.printStackTrace();
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
	public void atualizar(HoraAdvogadoBean hrAdvBean) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			String sql = null;
			
			sql = "UPDATE AM_HORA_ADVOGADO SET (dt_vigencia,vl_hora) WHERE cd_pessoa_adv = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setDate(1, hrAdvBean.getDtVigente());
			stmt.setDouble(2, hrAdvBean.getVlHora());
			
			stmt.execute();
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch (Exception e) {
			Logs.logger.info("OracleHoraAdvogadoDAO; public void atualizar(HoraAdvogadoBean hrAdvBean); " + e.toString());
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} e.printStackTrace();
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
	public void remover(int cdHistorico) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			String sql = null;
			
			sql = "DELETE FROM AM_HORA_ADVOGADO WHERE cd_historico = ?";
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, cdHistorico);
			
			stmt.execute();
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch (Exception e) {
			Logs.logger.info("OracleHoraAdvogadoDAO; public void remover(int cdHistorico); " + e.toString());
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}e.printStackTrace();
		}
			try {
				conn.close();
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	@Override
	public HoraAdvogadoBean consultar(int cdHistorico) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		HoraAdvogadoBean hrAdvBean = new HoraAdvogadoBean();

		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			String sql = null;
			
			sql = "SELECT " +
				"AM_HORA_ADVOGADO.CD_HISTORICO, " +
				"ADV.NM_PESSOA," +	
				"AM_HORA_ADVOGADO.CD_PESSOA_ADV, " +
				"AM_HORA_ADVOGADO.DT_VIGENCIA, " +
				"AM_HORA_ADVOGADO.VL_HORA " +
				"FROM AM_HORA_ADVOGADO " +
				"INNER JOIN AM_PESSOA ADV " +
				"ON AM_HORA_ADVOGADO.CD_PESSOA_ADV = ADV.CD_PESSOA " +
				"WHERE CD_HISTORICO = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, cdHistorico);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				PessoaBean pAdv = new PessoaBean();
				pAdv.setCdPessoa(rs.getInt("cd_pessoa_adv"));
				pAdv.setNmPessoa(rs.getString("nm_pessoa"));
				hrAdvBean.setCdHistorico(cdHistorico);
				hrAdvBean.setAdvogado(pAdv);
				hrAdvBean.setDtVigente(rs.getDate("dt_vigencia"));
				hrAdvBean.setVlHora(rs.getDouble("vl_hora"));
			}
			
		} catch (Exception e) {
			Logs.logger.info("OracleHoraAdvogadoDAO; public HoraAdvogadoBean consultar(int cdHistorico); " + e.toString());
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
		return hrAdvBean;
	}

	@Override
	public List<HoraAdvogadoBean> listar() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		HoraAdvogadoBean hrAdvBean = new HoraAdvogadoBean();
		List <HoraAdvogadoBean> horaAdvogados = new ArrayList<HoraAdvogadoBean>();
		
		try {
			conn = AdvocaciaLCADBManager.obterConexao();
			conn.setAutoCommit(false);
			String sql = null;
			
			sql = "SELECT " +
					"AM_HORA_ADVOGADO.CD_HISTORICO, " +
					"ADV.NM_PESSOA," +	
					"AM_HORA_ADVOGADO.CD_PESSOA_ADV, " +
					"AM_HORA_ADVOGADO.DT_VIGENCIA, " +
					"AM_HORA_ADVOGADO.VL_HORA " +
					"FROM AM_HORA_ADVOGADO " +
					"INNER JOIN AM_PESSOA ADV " +
					"ON AM_HORA_ADVOGADO.CD_PESSOA_ADV = ADV.CD_PESSOA ";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			PessoaBean pAdv = new PessoaBean();
			while (rs.next()) {
				pAdv.setCdPessoa(rs.getInt("cd_pessoa_adv"));
				
				hrAdvBean.setCdHistorico(rs.getInt("cd_Historico"));
				hrAdvBean.setAdvogado((pAdv));
				hrAdvBean.setDtVigente(rs.getDate("dt_vigencia"));
				hrAdvBean.setVlHora(rs.getDouble("vl_hora"));
				
				horaAdvogados.add(hrAdvBean);
			}			
		} catch (Exception e) {
			Logs.logger.info("OracleHoraAdvogadoDAO; public List<HoraAdvogadoBean> listar(); " + e.toString());
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
		
		return horaAdvogados;
	}

}