package br.com.advocacialca.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.advocacialca.beans.ClienteBean;
import br.com.advocacialca.beans.ProcessoBean;
import br.com.advocacialca.beans.RespostaCRUD;
import br.com.advocacialca.beans.TelefoneBean;
import br.com.advocacialca.negocio.ClienteBO;
import br.com.advocacialca.negocio.ProcessoBO;

public class DetalheClienteSetup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DetalheClienteSetup() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String proximaPagina = "/WebSite/paginas/detalhes-cliente.jsp";
		
		ClienteBO clienteBO = new ClienteBO();
		
		Object objCdCliente = request.getParameter("cdCliente");
		
		if (objCdCliente != null) {
			
			int cdCliente = Integer.parseInt((String)objCdCliente);
		
			if (cdCliente > 0) {
			
				ClienteBean cliente = clienteBO.consultar(cdCliente);
				
				if (cliente == null) {
					
					RespostaCRUD resp = new RespostaCRUD(false, "N‹o foi encontrado um cliente de nœmero " + cdCliente);
					resp.setLinkRedirecionamento("./ListaClienteSetup");
					resp.setTxtLinkRedirecionamento("Ir para lista de clientes");

					request.setAttribute("respostaCRUD", resp);
					proximaPagina = "/WebSite/paginas/output.jsp";
					
				} else {
					
					List<TelefoneBean> telefones = clienteBO.obterTelefoneCliente(cdCliente);
					
					ProcessoBO processoBO = new ProcessoBO();
					List<ProcessoBean> listaProcessosCliente = processoBO.listar(cliente.getPessoa().getCdPessoa());
					
					request.setAttribute("cliente", cliente);
					request.setAttribute("telefones", telefones);
					request.setAttribute("listaProcesso", listaProcessosCliente);
				}
			}
		}
		
		request.getRequestDispatcher(proximaPagina).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
