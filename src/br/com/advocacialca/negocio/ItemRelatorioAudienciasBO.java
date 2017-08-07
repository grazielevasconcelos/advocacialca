package br.com.advocacialca.negocio;

import java.util.List;

import br.com.advocacialca.beans.ItemRelatorioAudiencias;
import br.com.advocacialca.factory.DAOFactory;
import br.com.advocacialca.factory.DAOFactory.TipoBD;
import br.com.advocacialca.jdbc.OracleItemRelatorioAudienciasDAO;

public class ItemRelatorioAudienciasBO {

	public List<ItemRelatorioAudiencias> listar(int nrProcesso) {

		OracleItemRelatorioAudienciasDAO dao = (OracleItemRelatorioAudienciasDAO) DAOFactory.getDAOFactory(TipoBD.ORACLE).getItemRelatorioAudienciasDAO();
		return dao.listar(nrProcesso);
	}
	
}
