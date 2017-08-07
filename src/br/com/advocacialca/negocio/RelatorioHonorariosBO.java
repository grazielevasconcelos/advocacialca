package br.com.advocacialca.negocio;

import br.com.advocacialca.beans.ProcessoBean;
import br.com.advocacialca.beans.RelatorioHonorariosBean;

public class RelatorioHonorariosBO {

	public RelatorioHonorariosBean emitirRelatorio(int nrProcesso) {
		
		RelatorioHonorariosBean relatorio = null;
		
		ProcessoBO processoBO = new ProcessoBO();
		AdvogadoBO advogadoBO = new AdvogadoBO();
		ClienteBO clienteBO = new ClienteBO();
		ItemRelatorioHonorariosBO itemRelBO = new ItemRelatorioHonorariosBO();
		
		ProcessoBean processoBean = processoBO.consultar(nrProcesso);
		
		if (processoBean != null) {
			
			relatorio = new RelatorioHonorariosBean();
		
			relatorio.setProcesso(processoBO.consultar(nrProcesso));
			relatorio.setCliente(clienteBO.consultar(relatorio.getProcesso().getCliente().getPessoa().getCdPessoa()));
			relatorio.setItemsRelatorioHonorario(itemRelBO.listar(nrProcesso));
			relatorio.setAdvogados(advogadoBO.listarPorProcesso(nrProcesso));
			relatorio.setTelefones(clienteBO.obterTelefoneCliente(relatorio.getProcesso().getCliente().getPessoa().getCdPessoa()));
		}
			
		return relatorio;
		
	}
}
