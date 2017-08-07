package br.com.advocacialca.negocio;

import java.util.List;

import br.com.advocacialca.beans.ItemRelatorioHonorarios;
import br.com.advocacialca.factory.DAOFactory;
import br.com.advocacialca.factory.DAOFactory.TipoBD;
import br.com.advocacialca.jdbc.OracleItemRelatorioHonorariosDAO;

public class ItemRelatorioHonorariosBO {

	public List<ItemRelatorioHonorarios> listar(int nrProcesso) {

		OracleItemRelatorioHonorariosDAO dao = (OracleItemRelatorioHonorariosDAO) DAOFactory.getDAOFactory(TipoBD.ORACLE).getItemRelatorioHonorariosDAO();
		return dao.listar(nrProcesso);
	}
	
}
