package br.com.advocacialca.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.advocacialca.beans.ClienteBean;
import br.com.advocacialca.negocio.ClienteBO;

public class ListaClienteSetup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListaClienteSetup() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClienteBO clienteBO = new ClienteBO();
		List<ClienteBean> lista = clienteBO.listar();
		
		request.setAttribute("listaCliente", lista);
		request.getRequestDispatcher("/WebSite/paginas/lista-clientes.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
