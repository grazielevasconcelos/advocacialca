package br.com.advocacialca.interfaces;

import java.util.List;

import br.com.advocacialca.beans.PessoaBean;

public interface IPessoaDAO {
	public void cadastrar (PessoaBean pesBean);
	public void atualizar (PessoaBean pesBean);
	public void remover (int cdPessoa);
	public PessoaBean consultar (int cdPessoa);
	public List<PessoaBean> listar();
}
