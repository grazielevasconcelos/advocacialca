package br.com.advocacialca.interfaces;

import java.util.List;
import br.com.advocacialca.beans.TarefaBean;

public interface ITarefaDAO {
	
	public TarefaBean consultar(int cdTarefa);
	public void cadastrar(TarefaBean tarefaBean);
	public void atualizar(TarefaBean tarefaBean);
	public void remover(int cdTarefa);
	public List<TarefaBean> listar();

}
