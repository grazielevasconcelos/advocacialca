package br.com.advocacialca.interfaces;

import java.util.List;

import br.com.advocacialca.beans.TipoCobrancaBean;

public interface ITipoCobrancaDAO {
	
    public void cadastrar(TipoCobrancaBean tipoCobrancaBean);
	public void atualizar(TipoCobrancaBean tipoCobrancaBean);
	public void remover(int idTipoCobranca);
	public TipoCobrancaBean consultar(int idTipoCobranca);
	public List<TipoCobrancaBean> listar();
	
}
