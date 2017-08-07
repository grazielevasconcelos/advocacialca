package br.com.advocacialca.teste;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import br.com.advocacialca.beans.ProcessoBean;
import br.com.advocacialca.negocio.ProcessoBO;

public class TesteProcesso {

	public static boolean Testar() {
		
		boolean sucesso = true;
		
		try
		{
			ProcessoBean processoBean = new ProcessoBean();
			
			processoBean.setNrProcesso(5);
			
			Calendar dtAbertura = Calendar.getInstance();
			dtAbertura.set(2012, 11, 10);
			
			Calendar dtFechamento = Calendar.getInstance();
			dtFechamento.set(2012, 10, 2);
			
			/*
			processoBean.setCdPessoaForum(9);
			processoBean.setCdPessoaCliente(6);
			processoBean.setCdCausa(1);
			processoBean.setCdCobranca(1);
			processoBean.setDsProcesso("Descrição");
			processoBean.setDtAbertura(dtAbertura);
			processoBean.setDtFechamento(dtFechamento);
			processoBean.setDdDiaVencimento(12);
			processoBean.setCdResultado(1);
			processoBean.setDsObservacao("Observação do processo");
			*/
			
			ProcessoBO processoBO = new ProcessoBO();
			
			//Teste de cadastro
			//processoBO.cadastrar(processoBean);
			
			//Teste de atualização
			//processoBO.atualizar(processoBean);
	
			//Teste de consulta
			/*ProcessoBean processo = processoBO.consultar(1);
			System.out.println(processo.getNrProcesso());
			System.out.println(processo.getCdPessoaForum());
			System.out.println(processo.getCdPessoaCliente());
			System.out.println(processo.getCdCausa());
			System.out.println(processo.getCdCobranca());
			System.out.println(processo.getDsProcesso());
			System.out.println(processo.getDtAbertura());
			System.out.println(processo.getDtFechamento());
			System.out.println(processo.getDdDiaVencimento());
			System.out.println(processo.getCdResultado());
			System.out.println(processo.getDsObservacao());
			*/
			//Teste de lista
			List<ProcessoBean> listaProcessos = processoBO.listar(4);
			for(ProcessoBean processo : listaProcessos){
				System.out.println(processo.getNrProcesso());
				System.out.println(processo.getForum().getPessoa().getNmPessoa());
				System.out.println(processo.getCliente().getPessoa().getNmPessoa());
				System.out.println(processo.getTipoCausa().getDsCausa());
				System.out.println(processo.getTipoCobranca().getDsCobranca());
				System.out.println(processo.getDsProcesso());
				System.out.println(processo.getDtAbertura());
				System.out.println(processo.getDtFechamento());
				System.out.println(processo.getDdDiaVencimento());
				System.out.println(processo.getCdResultado());
				System.out.println(processo.getDsObservacao());
				
			}
		
		}
		catch (Exception e) {
			
			System.out.println("ERRO: TesteProcesso");
			
			sucesso = false;
		}
		
		return sucesso;
	}

}
