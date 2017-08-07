package br.com.advocacialca.interfaces;

import java.util.List;

import br.com.advocacialca.beans.ForumBean;

public interface IForumDAO {
	
	public ForumBean consultar(int cdPessoaForum);
	public void cadastrar(ForumBean forumbean);
	public void atualizar(ForumBean forumbean);
	public void remover(int cdPessoaForum);
	public List<ForumBean> listar();

}
