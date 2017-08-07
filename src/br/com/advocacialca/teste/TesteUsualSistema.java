package br.com.advocacialca.teste;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import br.com.advocacialca.beans.*;
import br.com.advocacialca.logs.Logs;
import br.com.advocacialca.negocio.*;

public class TesteUsualSistema {

	public static void main(String[] args) {
		
		//testarCadastrarProcesso();
		
		//testarRelHONORARIOS();
		
		//testarRelAUDIENCIAS();
		
		//testarCadastrarHonorarios();
		
		testarListarProcesso();
		
		//Logs.logger.info("Clientes listados: " + clienteBean.size());
	}
	
	private static void testarListarProcesso() {

		ClienteBO clienteBO = new ClienteBO();
		ProcessoBO processoBO = new ProcessoBO();

		List<ProcessoBean> processos = processoBO.listar(4);
		
		for (ProcessoBean proc : processos) {
			System.out.println(proc.getCdResultado());
			System.out.println(proc.getCliente());
			System.out.println(proc.getCliente().getPessoa().getCdPessoa());
			System.out.println(proc.getCliente().getPessoa().getNmPessoa());
			System.out.println(proc.getDdDiaVencimento());
			System.out.println(proc.getDsObservacao());
			System.out.println(proc.getDsProcesso());
			System.out.println(proc.getDtAbertura());
			System.out.println(proc.getDtFechamento());
			System.out.println(proc.getForum().getPessoa().getCdPessoa());
			System.out.println(proc.getForum().getPessoa().getNmPessoa());
			System.out.println(proc.getForum().getDsForum());
			System.out.println(proc.getNrProcesso());
			System.out.println(proc.getTipoCausa().getCdCausa());
			System.out.println(proc.getTipoCausa().getDsCausa());
			System.out.println(proc.getTipoCobranca().getCdCobranca());
			System.out.println(proc.getTipoCobranca().getDsCobranca());
			System.out.println(proc.getTipoCobranca().getTxJuros());
			System.out.println(proc.getTipoCobranca().getVlMoraDiaria());
		}
	}
	
	private static void testarCadastrarHonorarios() {
		
		AdvogadoBO advogadoBO = new AdvogadoBO();
		AdvogadoBean advogadoBean = advogadoBO.consultar(1);
		
		System.out.println("Advogado: " + advogadoBean.getPessoa().getNmPessoa());
		
		ProcessoBO processoBO = new ProcessoBO();
		List<ProcessoBean> listaProcessos = processoBO.listarPorAdvogado(advogadoBean.getPessoa().getCdPessoa());

		System.out.println("Processos do Advogado: ");
		for (ProcessoBean proc : listaProcessos)
			System.out.println("\tProcesso: " + proc.getNrProcesso());
		
		TarefaBO tarefaBO = new TarefaBO();
		List<TarefaBean> listaTarefas = tarefaBO.listar();

		System.out.println("Tipos Tarefas: ");
		for (TarefaBean tarefa : listaTarefas)
			System.out.println("\tTarefa: " + tarefa.getDsTarefa());
		
		AdvogadoHonorarioBO advHonorarioBO = new AdvogadoHonorarioBO();
		
		AdvogadoHonorarioBean advHonorarioBean = new AdvogadoHonorarioBean();
		
		advHonorarioBean.setAdvogado(advogadoBean);
		advHonorarioBean.setTarefa(listaTarefas.get(1));
		advHonorarioBean.setDsObservacao("Obs");

		Calendar dtHonorario = Calendar.getInstance();
		dtHonorario.set(10,10,2010);

		advHonorarioBean.setDtHonorario(dtHonorario);
		advHonorarioBean.setProcesso(listaProcessos.get(1));
		advHonorarioBean.setQtHoras(34);
		
		//advHonorarioBO.cadastrar(advHonorarioBean);
		
		List<AdvogadoHonorarioBean> listaAdvogadoHonorarioBean = advHonorarioBO.listar(advogadoBean.getPessoa().getCdPessoa());
		
		System.out.println("Honorarios do advogado");
		for (AdvogadoHonorarioBean honorario : listaAdvogadoHonorarioBean)
			System.out.println("\tHonorario - qtd_horas: " + honorario.getQtHoras());
	}
	
	private static void testarRelAUDIENCIAS() {
		
		RelatorioAudienciasBO relAudienciasBO = new RelatorioAudienciasBO();
		RelatorioAudienciasBean relAudienciasBean =  relAudienciasBO.emitirRelatorio(1);

		System.out.println("\n\nRelat—rio de Audi�ncias:");
		System.out.println("Cliente: " + relAudienciasBean.getCliente().getPessoa().getNmPessoa());
		System.out.println("Processo: " + relAudienciasBean.getProcesso().getNrProcesso());

		System.out.println("Telefones: ");
		for (TelefoneBean telefone : relAudienciasBean.getTelefones())
			System.out.println("\tTelefone: " + telefone.getTipoTelefone().getDsTipoTelefone() + " - " + telefone.getNrTelefone());
		
		System.out.println("Advogados: ");
		for (AdvogadoBean advogado : relAudienciasBean.getAdvogados())
			System.out.println("\tAdvogado: " + advogado.getPessoa().getNmPessoa());
		
		System.out.println("Itens: ");
		for (ItemRelatorioAudiencias item : relAudienciasBean.getItemsRelatorioAudiencias()) {
			System.out.println("\tItem: ");
			System.out.println("\t\tData: " + item.getDtAudiencia());
			System.out.println("\t\tForum: " + item.getNomeForum());
			System.out.println("\t\tSala: " + item.getSala());
			System.out.println("\t\tEndereco: " + item.getEndereco());
		}
		
	}

	private static void testarRelHONORARIOS() {
		
		RelatorioHonorariosBO relHonorariosBO = new RelatorioHonorariosBO();
		RelatorioHonorariosBean relHonorariosBean =  relHonorariosBO.emitirRelatorio(1);

		System.out.println("\n\nRelat—rio de Honor‡rios:");
		System.out.println("Cliente: " + relHonorariosBean.getCliente().getPessoa().getNmPessoa());
		System.out.println("Processo: " + relHonorariosBean.getProcesso().getNrProcesso());

		System.out.println("Telefones: ");
		for (TelefoneBean telefone : relHonorariosBean.getTelefones())
			System.out.println("\tTelefone: " + telefone.getTipoTelefone().getDsTipoTelefone() + " - " + telefone.getNrTelefone());
		
		System.out.println("Itens: ");
		for (ItemRelatorioHonorarios item : relHonorariosBean.getItemsRelatorioHonorario()) {
			System.out.println("\tItem: ");
			System.out.println("\t\tData: " + item.getDtTarefa());
			System.out.println("\t\tAdvogado: " + item.getNomeAdvogado());
			System.out.println("\t\tValor: " + item.getValorTarefa());
		}
		
	}
	
	private static void testarCadastrarProcesso() {
		
		ClienteBO clienteBO = new ClienteBO();
		
		//Valida lista de clientes
		List<ClienteBean> listaClientes =  clienteBO.listar();
	
		for (ClienteBean cliente : listaClientes)			
			System.out.println("Cliente: " + cliente.getPessoa().getNmPessoa());
		
		//Valida consultar clientes
		ClienteBean clienteBean = clienteBO.consultar(listaClientes.get(0).getPessoa().getCdPessoa());
		
		ProcessoBO processoBO = new ProcessoBO();
		
		//Valida alterar processo e consultar processo
		ProcessoBean processoConsultado = processoBO.consultar(100);
		processoConsultado.setDsObservacao("heheheh");
		processoBO.atualizar(processoConsultado);
		
		/*
		ForumBO forumBO = new ForumBO();
		TipoCausaBO tipoCausaBO = new TipoCausaBO();
		TipoCobrancaBO tipoCobrancaBO = new TipoCobrancaBO();

		
		//Testa listas para combos usados em cadastrar processo: Forum, TipoCausa e TipoCobranca
		ForumBean forumBean = forumBO.listar().get(1);
		TipoCausaBean tipoCausa = tipoCausaBO.listar().get(1);
		TipoCobrancaBean tipoCobranca = tipoCobrancaBO.listar().get(1);
		
		//Valida cadastrar processo
		ProcessoBean novoProcesso = new ProcessoBean();
		novoProcesso.setCdCausa(tipoCausa.getCdCausa());
		novoProcesso.setCdCobranca(tipoCobranca.getCdCobranca());
		novoProcesso.setCdPessoaCliente(clienteBean.getPessoa().getCdPessoa());
		novoProcesso.setCdPessoaForum(forumBean.getPessoa().getCdPessoa());
		novoProcesso.setCdResultado(1);
		novoProcesso.setDdDiaVencimento(10);
		novoProcesso.setDsObservacao("Obs");
		novoProcesso.setDsProcesso("Desc");
		

		Calendar dtAberturo = Calendar.getInstance();
		dtAberturo.set(10,10,2010);

		Calendar dtFechamento = Calendar.getInstance();
		dtFechamento.set(10,10,2010);

		novoProcesso.setDtAbertura(dtAberturo);
		novoProcesso.setDtFechamento(dtFechamento);
		novoProcesso.setNrProcesso(101);
		processoBO.cadastrar(novoProcesso);
		*/
		
		List<ProcessoBean> processosDoCliente = processoBO.listar(clienteBean.getPessoa().getCdPessoa());
		
		for (ProcessoBean p : processosDoCliente)			
			System.out.println("Processo: " + p.getNrProcesso());
	}
}





