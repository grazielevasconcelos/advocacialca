package br.com.advocacialca.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.advocacialca.beans.ProcessoBean;
import br.com.advocacialca.beans.RespostaCRUD;
import br.com.advocacialca.beans.TelefoneBean;
import br.com.advocacialca.beans.TituloBean;
import br.com.advocacialca.negocio.ClienteBO;
import br.com.advocacialca.negocio.ProcessoBO;
import br.com.advocacialca.negocio.TituloBO;

public class ListaTitulosProcessoSetup extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	public ListaTitulosProcessoSetup() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WebSite/paginas/lista-titulos-processo.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String proximaPagina = "/WebSite/paginas/lista-titulos-processo.jsp";
		
		int nrProc = Integer.parseInt(request.getParameter("nrProcesso"));
		
		if (nrProc > 0) {

			ProcessoBO processoBO = new ProcessoBO();
			ProcessoBean processoBean = processoBO.consultar(nrProc);
			
			if (processoBean != null) {
				
				request.setAttribute("processo", processoBean);
			
				ClienteBO clienteBO = new ClienteBO();
				List<TelefoneBean> telefonesBean = clienteBO.obterTelefoneCliente(processoBean.getCliente().getPessoa().getCdPessoa());
				request.setAttribute("telefones", telefonesBean);
				
				TituloBO titulosBO = new TituloBO(); 
				List<TituloBean> titutlosBean = titulosBO.listar(nrProc);
				request.setAttribute("titulos", titutlosBean);
				
			} else {
				
				RespostaCRUD resp = new RespostaCRUD(false, "Não foi encontrado um processo de número " + nrProc);
				resp.setLinkRedirecionamento("./ListaTitulosProcessoSetup");
				resp.setTxtLinkRedirecionamento("Voltar para lista de títulos do processo");

				request.setAttribute("respostaCRUD", resp);
				proximaPagina = "/WebSite/paginas/output.jsp";
			}
		}
		
		request.getRequestDispatcher(proximaPagina).forward(request, response);
	}
}
