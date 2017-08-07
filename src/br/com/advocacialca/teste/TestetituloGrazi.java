package br.com.advocacialca.teste;

import java.util.List;

import br.com.advocacialca.beans.ProcessoBean;
import br.com.advocacialca.beans.TituloBean;
import br.com.advocacialca.negocio.TituloBO;

public class TestetituloGrazi {
	public static void main(String[] args) {
		TituloBO tituloBO = new TituloBO();
		ProcessoBean proc = new ProcessoBean();
		proc.setNrProcesso(1);
		proc.getNrProcesso();
		List<TituloBean> lista = tituloBO.listar(proc.getNrProcesso());
		 for(TituloBean titulo : lista){
		 	System.out.println("Numero titulo: " + titulo.getNrTitulo());
		 	System.out.println("Numero Processo: " + titulo.getProcesso().getNrProcesso());
		 	System.out.println("Numero Agencia Cedente: " + titulo.getNrAgenciaCedente());
		 	System.out.println("Data do Documento: " + titulo.getDtDocumento());
		 	System.out.println("Data de Vencimento: " + titulo.getDtVencimento());
		 	System.out.println("Valor do Documento: " + titulo.getVlDocumento());
		 	System.out.println("---------------------");
		 }
	}
}
