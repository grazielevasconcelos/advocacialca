package br.com.advocacialca.teste;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import br.com.advocacialca.beans.ProcessoBean;
import br.com.advocacialca.beans.TituloBean;
import br.com.advocacialca.negocio.ClienteBO;
import br.com.advocacialca.negocio.ProcessoBO;
import br.com.advocacialca.negocio.TituloBO;

public class TesteTituloMain {
	public static void main(String[] args) {
		TituloBO tituloBO = new TituloBO();
		
		ProcessoBO processoBO = new ProcessoBO();
		ClienteBO clienteBO = new ClienteBO();

		ProcessoBean processoBean = new ProcessoBean();
		processoBean.setNrProcesso(1);
		
//		Calendar cal = Calendar.getInstance();
//		Date data = new Date(cal.getTime().getTime());
		
		TituloBean tituloBean = new TituloBean();
		tituloBean.setNrTitulo(1);
		tituloBean.setNrAgenciaCedente(2);
		tituloBean.setDtDocumento(Calendar.getInstance());
		tituloBean.setDtVencimento(Calendar.getInstance());
		tituloBean.setVlDocumento(Float.parseFloat("1800"));
		
		List<TituloBean> titulos = tituloBO.listar(processoBean.getNrProcesso());
		for(TituloBean tit : titulos){
		System.out.println("Num. titulo: " + tit.getNrTitulo());
		System.out.println("Agencia: " + tit.getNrAgenciaCedente());
		System.out.println("Valor do documento: " + tit.getVlDocumento());
		System.out.println("Data doc. : " + tit.getDtDocumento() );
		System.out.println("Data venc. : " + tit.getDtVencimento());
		System.out.println("Processo: " + tit.getProcesso());
		System.out.println("Total Valor: " + tit.getTotal());
		}
	}
}
