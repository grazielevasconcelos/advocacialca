package br.com.advocacialca.interfaces;

import java.util.List;

import br.com.advocacialca.beans.AdvogadoBean;

public interface IAdvogadoDAO {
	public void cadastrar (AdvogadoBean advBean);
	public void atualizar (AdvogadoBean advBean);
	public void remover (int cdAdvogado);
	public AdvogadoBean consultar(int cdAdvogado);
	public List<AdvogadoBean> listar();
	public List<AdvogadoBean> listarPorProcesso(int nrProcesso);
	public List<AdvogadoBean> obterPossiveisNovosAdvogados(int nrProcesso);
}
