package br.com.advocacialca.interfaces;

import br.com.advocacialca.beans.AdvogadoBean;
import br.com.advocacialca.beans.PessoaBean;

public interface IAutenticacaoDAO {

	public PessoaBean logarSecretaria(String login, String senha);
	public AdvogadoBean logarAdvogado(String login, String senha);
	
}
