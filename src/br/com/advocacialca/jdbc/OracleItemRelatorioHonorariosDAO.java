package br.com.advocacialca.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.advocacialca.beans.ItemRelatorioHonorarios;
import br.com.advocacialca.interfaces.IItemRelatorioHonorariosDAO;
import br.com.advocacialca.logs.Logs;

public class OracleItemRelatorioHonorariosDAO implements IItemRelatorioHonorariosDAO {

	public List<ItemRelatorioHonorarios> listar(int nrProcesso) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<ItemRelatorioHonorarios> listaItemRel = null;
		
		try {
			
			conn = AdvocaciaLCADBManager.obterConexao();
			listaItemRel = new ArrayList<ItemRelatorioHonorarios>();
			
			String sql = "SELECT ADV_HONO.DT_HONORARIO DATA_HONO, PESS_ADV.NM_PESSOA ADVOGADO, HORA_ADV.VL_HORA * ADV_HONO.QT_HORAS VALOR FROM AM_PROCESSO PROC INNER JOIN AM_ADVOGADO_HONORARIO ADV_HONO ON PROC.NR_PROCESSO = ADV_HONO.NR_PROCESSO INNER JOIN AM_PESSOA PESS_ADV ON ADV_HONO.CD_PESSOA_ADV = PESS_ADV.CD_PESSOA INNER JOIN AM_HORA_ADVOGADO HORA_ADV ON ADV_HONO.CD_PESSOA_ADV = HORA_ADV.CD_PESSOA_ADV AND (EXTRACT(YEAR FROM HORA_ADV.DT_VIGENCIA) = EXTRACT(YEAR FROM ADV_HONO.DT_HONORARIO)) AND (EXTRACT(MONTH FROM HORA_ADV.DT_VIGENCIA) = EXTRACT(MONTH FROM ADV_HONO.DT_HONORARIO)) WHERE PROC.NR_PROCESSO = ? ORDER BY ADV_HONO.CD_HONORARIO";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, nrProcesso);
			
			rs = stmt.executeQuery();
			
			while(rs.next()){

				ItemRelatorioHonorarios item = new ItemRelatorioHonorarios();
				
				item.setDtTarefa(rs.getDate("DATA_HONO"));
				item.setNomeAdvogado(rs.getString("ADVOGADO"));
				item.setValorTarefa(rs.getFloat("VALOR"));
				
				listaItemRel.add(item);	
			}
			
		} catch(Exception e) {
			Logs.logger.info("OracleItemRelatorioHonorariosDAO; public List<ItemRelatorioHonorarios> listar(int nrProcesso); " + e.toString());
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
		
		
		return listaItemRel;
	}

}
