package br.com.advocacialca.interfaces;

import java.util.List;

import br.com.advocacialca.beans.ItemRelatorioAudiencias;

public interface IItemRelatorioAudienciasDAO {

	public List<ItemRelatorioAudiencias> listar(int nrProcesso);
}
