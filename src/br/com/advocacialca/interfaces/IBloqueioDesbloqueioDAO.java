package br.com.advocacialca.interfaces;

import java.util.List;

import br.com.advocacialca.beans.BloqueioDesbloqueioBean;

public interface IBloqueioDesbloqueioDAO {
	public void cadastrar (BloqueioDesbloqueioBean bloqDesbloqBean);
	public void atualizar (BloqueioDesbloqueioBean bloqDesbloqBean);
	public void remover (long cdBloqDesbloq);
	public BloqueioDesbloqueioBean consultar (long cdBloqDesbloq);
	public List <BloqueioDesbloqueioBean> listar();
}
