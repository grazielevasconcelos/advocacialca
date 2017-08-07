package br.com.advocacialca.interfaces;

import java.util.List;

import br.com.advocacialca.beans.AdvogadoHonorarioBean;
import br.com.advocacialca.beans.RespostaCRUD;

public interface IAdvogadoHonorarioDAO {
	
    public RespostaCRUD cadastrar(AdvogadoHonorarioBean tipoCobrancaBean);
	public void atualizar(AdvogadoHonorarioBean tipoCobrancaBean);
	public void remover(int idTipoCobranca);
	public AdvogadoHonorarioBean consultar(int idTipoCobranca);
	public List<AdvogadoHonorarioBean> listar(int idAdvogado);
	
}
