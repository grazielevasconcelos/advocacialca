package br.com.advocacialca.beans;

import java.io.Serializable;
import java.util.List;

public class RespostaCRUD  implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private boolean sucesso;
	private String mensagem;
	private String linkRedirecionamento;
	private String txtLinkRedirecionamento;

	public RespostaCRUD() { };

	public RespostaCRUD(boolean sucesso, String mensagem) {
		this.setSucesso(sucesso);
		this.setMensagem(mensagem);
	};
	
	public boolean isSucesso() {
		return sucesso;
	}

	public void setSucesso(boolean sucesso) {
		this.sucesso = sucesso;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getLinkRedirecionamento() {
		return linkRedirecionamento;
	}

	public void setLinkRedirecionamento(String linkRedirecionamento) {
		this.linkRedirecionamento = linkRedirecionamento;
	}

	public String getTxtLinkRedirecionamento() {
		return txtLinkRedirecionamento;
	}

	public void setTxtLinkRedirecionamento(String txtLinkRedirecionamento) {
		this.txtLinkRedirecionamento = txtLinkRedirecionamento;
	}

}
