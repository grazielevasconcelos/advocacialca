package br.com.advocacialca.teste;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import br.com.advocacialca.beans.BloqueioDesbloqueioBean;
import br.com.advocacialca.beans.HistBloqDesbloqBean;
import br.com.advocacialca.beans.ProcessoBean;
import br.com.advocacialca.negocio.HistBloqDesbloqBO;
import br.com.advocacialca.negocio.TituloPagoBO;

public class TesteHistBloqDesbloq {
	public static boolean Testar(){
	boolean sucesso = true;
	try {
		ProcessoBean procBean = new ProcessoBean();
		int nrProc = procBean.getNrProcesso();
		
		BloqueioDesbloqueioBean bloqDesbloqBean = new BloqueioDesbloqueioBean(); 
		long codBloqDesbloq = bloqDesbloqBean.getCdBloqDesbloq();
		
		nrProc = 4;
		codBloqDesbloq = 2;
		
		Calendar cal = Calendar.getInstance();
		Date data = new Date(cal.getTime().getTime());
		
		HistBloqDesbloqBean histBloqDesbloqBean = new HistBloqDesbloqBean();
		
		histBloqDesbloqBean.setProcesso(procBean);
		histBloqDesbloqBean.setBloqueioDesbloq(bloqDesbloqBean);
		histBloqDesbloqBean.setDtBloqueioDesbloq(Calendar.getInstance());
		
		HistBloqDesbloqBO histBloqDesbloqBO = new HistBloqDesbloqBO();
		
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		String dataBloqDesbloq = formatador.format(histBloqDesbloqBean.getDtBloqueioDesbloq().getTime().getTime());

		System.out.println(dataBloqDesbloq);
		
		
//		histBloqDesbloqBO.cadastrar(histBloqDesbloqBean);
//		histBloqDesbloqBO.consultar(procBean, data);
//		histBloqDesbloqBO.remover(procBean, data);
//		histBloqDesbloqBO.atualizar(histBloqDesbloqBean);
		List<HistBloqDesbloqBean>lista = histBloqDesbloqBO.listar();
		
		for(HistBloqDesbloqBean histbd : lista){
			System.out.println("número proceso: " + histbd.getProcesso().getNrProcesso());
			System.out.println("codigo bloqueio/desbloqueio: " + histbd.getBloqueioDesbloq().getCdBloqDesbloq());
			System.out.println("data bloqueio/desbloqueio: " + histbd.getDtBloqueioDesbloq());
		}
		
	} catch (Exception e) {
		System.out.println("ERRO : TESTE Historico bloqueio e Desbloqueio");
		e.printStackTrace();
	}
	
	return sucesso;
	
	}
}
