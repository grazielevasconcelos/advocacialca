package br.com.advocacialca.teste;

import java.util.Calendar;
import java.sql.Date;
import java.util.List;

import br.com.advocacialca.beans.AdvogadoBean;
import br.com.advocacialca.beans.AdvogadoHonorarioBean;
import br.com.advocacialca.beans.PessoaBean;
import br.com.advocacialca.beans.ProcessoBean;
import br.com.advocacialca.beans.TarefaBean;
import br.com.advocacialca.negocio.AdvogadoHonorarioBO;

public class TesteAdvogadoHonorario {

	@SuppressWarnings({ "deprecation", "unused" })
	public static boolean Testar() {
		
		boolean sucesso = true;
		
		try
		{
			AdvogadoHonorarioBean advogadoHonorario = new AdvogadoHonorarioBean(); 
			TarefaBean tBean = new TarefaBean();
			tBean.setCdTarefa(3);
			PessoaBean pessoa = new PessoaBean();
			pessoa.setCdPessoa(1);
			AdvogadoBean advogado = new AdvogadoBean();
			advogado.setPessoa(pessoa);
			ProcessoBean processo = new ProcessoBean();
			processo.setNrProcesso(1);
			Calendar cal = Calendar.getInstance();
			cal.set(2012, 11, 20);

			
			advogadoHonorario.setCdHonorario(15);
			advogadoHonorario.setProcesso(processo);
			advogadoHonorario.setAdvogado(advogado);
			advogadoHonorario.setTarefa(tBean);
			advogadoHonorario.setQtHoras(3);			
			advogadoHonorario.setDtHonorario(cal);
			advogadoHonorario.setDsObservacao("Observação: Isso é um Teste");
			
			AdvogadoHonorarioBO advogadoHonorarioBO = new AdvogadoHonorarioBO();

			
			List<AdvogadoHonorarioBean> advHon = advogadoHonorarioBO.listar(1);
			
			for(AdvogadoHonorarioBean adv : advHon){
				System.out.println(adv.getCdHonorario());
				System.out.println(adv.getProcesso().getNrProcesso());
				System.out.println(adv.getAdvogado().getPessoa().getCdPessoa());
				System.out.println(adv.getTarefa().getCdTarefa());
				System.out.println(adv.getDtHonorario());
				System.out.println(adv.getQtHoras());
				System.out.println(adv.getDsObservacao());
			}
			
		}
		catch (Exception e) {
			
			System.out.println("ERRO: TesteProcesso");
			
			sucesso = false;
		}
		
		return sucesso;
	}
}
