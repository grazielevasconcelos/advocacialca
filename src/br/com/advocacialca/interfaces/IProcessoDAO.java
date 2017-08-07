package br.com.advocacialca.interfaces;

import java.util.List;

import br.com.advocacialca.beans.ProcessoBean;
import br.com.advocacialca.beans.RespostaCRUD;

public interface IProcessoDAO {
	
	public RespostaCRUD cadastrar(ProcessoBean processoBean);
	public RespostaCRUD atualizar(ProcessoBean processoBean);
	public void remover(int idProcesso);
	public ProcessoBean consultar(int idProcesso);
	public List<ProcessoBean> listar(int idCliente);
	public List<ProcessoBean> listarPorAdvogado(int idAdvogado);

}