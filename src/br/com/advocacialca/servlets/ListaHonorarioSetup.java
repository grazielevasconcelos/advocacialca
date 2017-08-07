package br.com.advocacialca.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.advocacialca.beans.AdvogadoBean;
import br.com.advocacialca.beans.AdvogadoHonorarioBean;
import br.com.advocacialca.beans.PessoaBean;
import br.com.advocacialca.negocio.AdvogadoBO;
import br.com.advocacialca.negocio.AdvogadoHonorarioBO;

public class ListaHonorarioSetup extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public ListaHonorarioSetup() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Object objUsuarioLogado = request.getSession().getAttribute("usuarioLogado");
		
		if (objUsuarioLogado != null) {
			
			PessoaBean usuarioLogado = (PessoaBean)objUsuarioLogado;
			
			int cdAdvogado = usuarioLogado.getCdPessoa();
			
			AdvogadoBO advogadoBO = new AdvogadoBO();
			AdvogadoBean advogado = advogadoBO.consultar(cdAdvogado);
			request.setAttribute("advogado", advogado);
			
			AdvogadoHonorarioBO advHonBO = new AdvogadoHonorarioBO();
			List<AdvogadoHonorarioBean> listaAdvHon = advHonBO.listar(cdAdvogado);
			request.setAttribute("listaAdvHon", listaAdvHon);
			
		}
		
		request.getRequestDispatcher("/WebSite/paginas/lista-honorarios.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
