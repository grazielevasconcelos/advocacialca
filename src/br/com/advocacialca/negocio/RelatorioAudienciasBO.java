package br.com.advocacialca.negocio;

import br.com.advocacialca.beans.ProcessoBean;
import br.com.advocacialca.beans.RelatorioAudienciasBean;

public class RelatorioAudienciasBO {

	public RelatorioAudienciasBean emitirRelatorio(int nrProcesso) {
		
		RelatorioAudienciasBean relatorio = null;
		
		ProcessoBO processoBO = new ProcessoBO();
		ClienteBO clienteBO = new ClienteBO();
		AdvogadoBO advogadoBO = new AdvogadoBO();
		ItemRelatorioAudienciasBO itemRelBO = new ItemRelatorioAudienciasBO();
		
		ProcessoBean processoBean = processoBO.consultar(nrProcesso);
		
		if (processoBean != null) {
			
			relatorio = new RelatorioAudienciasBean();
			
			relatorio.setProcesso(processoBean);
			relatorio.setCliente(clienteBO.consultar(relatorio.getProcesso().getCliente().getPessoa().getCdPessoa()));
			relatorio.setAdvogados(advogadoBO.listarPorProcesso(nrProcesso));
			relatorio.setItemsRelatorioAudiencias(itemRelBO.listar(nrProcesso));
			relatorio.setTelefones(clienteBO.obterTelefoneCliente(relatorio.getProcesso().getCliente().getPessoa().getCdPessoa()));
		}
		
		return relatorio;
		
	}
}
