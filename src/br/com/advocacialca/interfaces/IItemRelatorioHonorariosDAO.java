package br.com.advocacialca.interfaces;

import java.util.List;

import br.com.advocacialca.beans.ItemRelatorioHonorarios;

public interface IItemRelatorioHonorariosDAO {

	public List<ItemRelatorioHonorarios> listar(int nrProcesso);
}
