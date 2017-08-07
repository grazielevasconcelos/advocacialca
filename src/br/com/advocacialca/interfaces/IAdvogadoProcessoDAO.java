package br.com.advocacialca.interfaces;

import java.util.List;

import br.com.advocacialca.beans.AdvogadoProcessoBean;
import br.com.advocacialca.beans.RespostaCRUD;

public interface IAdvogadoProcessoDAO {
	
	public RespostaCRUD cadastrar(AdvogadoProcessoBean advogadoProcesso);
	public void atualizar(AdvogadoProcessoBean advogadoProcesso);
	public AdvogadoProcessoBean consultar(int nrProcesso, int cdPessoaAdvogado);
	public List<AdvogadoProcessoBean> listar(int nrProcesso);

}
