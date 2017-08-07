package br.com.advocacialca.interfaces;

import java.util.List;
import br.com.advocacialca.beans.TipoTelefoneBean;

public interface ITipoTelefoneDAO {
	
	public void cadastrar(TipoTelefoneBean tipoTipoTelefoneBean);
	public void atualizar(TipoTelefoneBean tipoTipoTelefoneBean);
	public void remover(int idTipoTelefone);
	public TipoTelefoneBean consultar(int idTipoTelefone);
	public List<TipoTelefoneBean> listar();

}
