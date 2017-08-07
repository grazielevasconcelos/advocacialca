package br.com.advocacialca.teste;

import java.util.Calendar;
import java.util.List;

import br.com.advocacialca.beans.AdvogadoBean;
import br.com.advocacialca.beans.AdvogadoProcessoBean;
import br.com.advocacialca.beans.PessoaBean;
import br.com.advocacialca.beans.ProcessoBean;
import br.com.advocacialca.negocio.AdvogadoProcessoBO;

public class TesteAdvogadoProcesso {
	
	public boolean Testar(){
		
		boolean sucesso = true;
		
		try{
			AdvogadoProcessoBO advProcBO = new AdvogadoProcessoBO();
		
		
		AdvogadoProcessoBean advogadoProcesso = new AdvogadoProcessoBean();
		
		ProcessoBean processo = new ProcessoBean();
		processo.setNrProcesso(5);
		advogadoProcesso.setProcesso(processo);
		
		AdvogadoBean advogado = new AdvogadoBean();
		PessoaBean pessoa = new PessoaBean();
		pessoa.setCdPessoa(2);
		advogado.setPessoa(pessoa);
		advogadoProcesso.setAdvogado(advogado);
		
		Calendar dtInicioParticipacao = Calendar.getInstance();
		dtInicioParticipacao.set(2012, 10, 3);
		advogadoProcesso.setDtInicioParticipacao(dtInicioParticipacao);
		
		advProcBO.atualizar(advogadoProcesso);
		
//		AdvogadoProcessoBean advProc = advProcBO.consultar(1, 1);
//		System.out.println(advProc.getProcesso().getNrProcesso());
//		System.out.println(advProc.getProcesso().getDsProcesso());
//		System.out.println(advProc.getAdvogado().getPessoa().getCdPessoa());
//		System.out.println(advProc.getAdvogado().getPessoa().getNmPessoa());
//		System.out.println(advProc.getDtInicioParticipacao());
		
//		List<AdvogadoProcessoBean> lista = advProcBO.listar(1);
//		
//		for(AdvogadoProcessoBean advProcBean : lista){
//			System.out.println(advProcBean.getProcesso().getNrProcesso());
//			System.out.println(advProcBean.getProcesso().getDsProcesso());
//			System.out.println(advProcBean.getAdvogado().getPessoa().getCdPessoa());
//			System.out.println(advProcBean.getAdvogado().getPessoa().getNmPessoa());
//			System.out.println(advProcBean.getDtInicioParticipacao());
//		}
		
		
		} catch(Exception e){
			sucesso = false;
		}
		
		return sucesso;
	}
	
	public static void main(String[] args) {
		
		TesteAdvogadoProcesso teste = new TesteAdvogadoProcesso();
		
		System.out.println(teste.Testar());
		
	}

}
