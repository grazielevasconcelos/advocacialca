package br.com.advocacialca.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.advocacialca.logs.Logs;

import br.com.advocacialca.beans.ItemRelatorioAudiencias;
import br.com.advocacialca.interfaces.IItemRelatorioAudienciasDAO;

public class OracleItemRelatorioAudienciasDAO implements IItemRelatorioAudienciasDAO {

	public List<ItemRelatorioAudiencias> listar(int nrProcesso) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<ItemRelatorioAudiencias> listaItemRel = null;
		
		try {
			
			conn = AdvocaciaLCADBManager.obterConexao();
			listaItemRel = new ArrayList<ItemRelatorioAudiencias>();
			
			String sql = " SELECT" +
					" AUDIE.DT_HORA_AGENDA DATA_AUDIENCIA," +
					" NM_FORUM.NM_PESSOA NOME_FORUM," +
					" TIP_LOGR.DS_TIPO_LOGRADOURO TIPO_LOGRADOURO," +
					" ENDERECO.NM_LOGRADOURO NOME_RUA," +
					" END_REL.NR_ENDERECO NUMERO_ENDERECO," +
					" END_REL.DS_COMPLEMENTO," +
					" AUDIE.SL_FORUM SALA_FORUM" +
					" FROM" +
					" AM_PROCESSO PROC" +
					" INNER JOIN AM_AGENDA_AUDIENCIA AUDIE" +
					" ON PROC.NR_PROCESSO = AUDIE.NR_PROCESSO" +
					" INNER JOIN AM_PESSOA NM_FORUM" +
					" ON PROC.CD_PESSOA_FORUM = NM_FORUM.CD_PESSOA" +
					" INNER JOIN AM_PESSOA_ENDERECO END_REL" +
					" ON PROC.CD_PESSOA_FORUM = END_REL.CD_PESSOA" +
					" INNER JOIN AM_ENDERECO ENDERECO" +
					" ON END_REL.CD_ENDERECO = ENDERECO.CD_ENDERECO" +
					" INNER JOIN AM_TIPO_LOGRADOURO TIP_LOGR" +
					" ON ENDERECO.CD_TIPO_LOGRADOURO = TIP_LOGR.CD_TIPO_LOGRADOURO" +
					" WHERE PROC.NR_PROCESSO = ?";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, nrProcesso);
			
			rs = stmt.executeQuery();
			
			while(rs.next()){

				ItemRelatorioAudiencias item = new ItemRelatorioAudiencias();
				
				String enderecoCompleto = "";
				enderecoCompleto += rs.getString("TIPO_LOGRADOURO") + " ";
				enderecoCompleto += rs.getString("NOME_RUA") + ", ";
				enderecoCompleto += rs.getString("NUMERO_ENDERECO");
				
				String complemento = rs.getString("DS_COMPLEMENTO");
				if (complemento != null)
					enderecoCompleto +=  ", " + complemento;
				
				item.setEndereco(enderecoCompleto);
				item.setDtAudiencia(rs.getDate("DATA_AUDIENCIA"));
				item.setNomeForum(rs.getString("NOME_FORUM"));
				item.setSala(rs.getString("SALA_FORUM"));
				
				listaItemRel.add(item);	
			}
			
		} catch(Exception e) {
			Logs.logger.info("OracleItemRelatorioAudienciasDAO; public List<ItemRelatorioAudiencias> listar(int nrProcesso); " + e.toString());
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
