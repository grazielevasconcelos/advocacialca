package br.com.advocacialca.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.advocacialca.beans.RelatorioHonorariosBean;
import br.com.advocacialca.beans.RespostaCRUD;
import br.com.advocacialca.negocio.RelatorioHonorariosBO;

public class RelatorioHonorarioSetup extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public RelatorioHonorarioSetup() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WebSite/paginas/relatorio-honorarios.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String proximaPagina = "/WebSite/paginas/relatorio-honorarios.jsp";
		
		Object objNrProcesso = request.getParameter("nrProcesso");
		
		if (objNrProcesso != null) {
	
			int nrProcesso = Integer.parseInt((String)objNrProcesso);
			
			if (nrProcesso > 0) {
				
				RelatorioHonorariosBO relHonorariosBO = new RelatorioHonorariosBO();
				RelatorioHonorariosBean relHonorariosBean =  relHonorariosBO.emitirRelatorio(nrProcesso);		
				
				if (relHonorariosBean == null) {
					
					RespostaCRUD resp = new RespostaCRUD(false, "Não foi encontrado um processo de número " + objNrProcesso);
					resp.setLinkRedirecionamento("./RelatorioHonorarioSetup");
					resp.setTxtLinkRedirecionamento("Voltar para página de emissão de relatórios de honorários");

					request.setAttribute("respostaCRUD", resp);
					proximaPagina = "/WebSite/paginas/output.jsp";
					
				} else {
					
					request.setAttribute("relHonorarios", relHonorariosBean);
				}
			}
		}
		
		request.getRequestDispatcher(proximaPagina).forward(request, response);
	}
}
