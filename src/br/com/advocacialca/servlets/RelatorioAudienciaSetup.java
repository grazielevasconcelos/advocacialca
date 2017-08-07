package br.com.advocacialca.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.advocacialca.negocio.RelatorioAudienciasBO;
import br.com.advocacialca.beans.RelatorioAudienciasBean;
import br.com.advocacialca.beans.RespostaCRUD;

public class RelatorioAudienciaSetup extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public RelatorioAudienciaSetup() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WebSite/paginas/relatorio-audiencias.jsp").forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String proximaPagina = "/WebSite/paginas/relatorio-audiencias.jsp";
		
		Object objNrProcesso = request.getParameter("nrProcesso");
		
		if (objNrProcesso != null) {
			
			int nrProcesso = Integer.parseInt((String)objNrProcesso);
			
			if (nrProcesso > 0) {			
				
				RelatorioAudienciasBO relAudienciasBO = new RelatorioAudienciasBO();
				RelatorioAudienciasBean relAudienciasBean = relAudienciasBO.emitirRelatorio(nrProcesso);		

				if (relAudienciasBean == null) {
					
					RespostaCRUD resp = new RespostaCRUD(false, "Não foi encontrado um processo de número " + objNrProcesso);
					resp.setLinkRedirecionamento("./RelatorioAudienciaSetup");
					resp.setTxtLinkRedirecionamento("Voltar para página de emissão de relatório de audiências");

					request.setAttribute("respostaCRUD", resp);
					proximaPagina = "/WebSite/paginas/output.jsp";
					
				} else {
					
					request.setAttribute("relAudiencia", relAudienciasBean);
				}
			}
		}
		
		request.getRequestDispatcher(proximaPagina).forward(request, response);
	}

}
