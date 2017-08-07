package br.com.advocacialca.interfaces;

import java.sql.Date;
import java.util.List;

import br.com.advocacialca.beans.HistBloqDesbloqBean;
import br.com.advocacialca.beans.ProcessoBean;
import br.com.advocacialca.beans.RespostaCRUD;

public interface IHistBloqDesbloqDAO {
	
	public RespostaCRUD cadastrar (HistBloqDesbloqBean hisBloDesbloqBean);
	public void atualizar (HistBloqDesbloqBean hisBloDesbloqBean);
	public void remover (ProcessoBean processo, Date dtBloqueioDesbloq);
	public HistBloqDesbloqBean consultar (ProcessoBean processo, Date dtBloqueioDesbloq);
	public List<HistBloqDesbloqBean> listar ();
	
}
