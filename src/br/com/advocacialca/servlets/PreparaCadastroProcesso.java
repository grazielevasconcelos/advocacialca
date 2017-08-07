package br.com.advocacialca.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.advocacialca.beans.ClienteBean;
import br.com.advocacialca.beans.ForumBean;
import br.com.advocacialca.beans.ProcessoBean;
import br.com.advocacialca.beans.TipoCausaBean;
import br.com.advocacialca.beans.TipoCobrancaBean;
import br.com.advocacialca.negocio.ClienteBO;
import br.com.advocacialca.negocio.ForumBO;
import br.com.advocacialca.negocio.ProcessoBO;
import br.com.advocacialca.negocio.TipoCausaBO;
import br.com.advocacialca.negocio.TipoCobrancaBO;

public class PreparaCadastroProcesso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PreparaCadastroProcesso() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	ForumBO forumBO = new ForumBO();
    	List<ForumBean> listaForumBean = forumBO.listar();
    	request.setAttribute("listaForumBean", listaForumBean);
    	
    	TipoCausaBO tipoCausaBO = new TipoCausaBO();
    	List<TipoCausaBean> listaTipoCausaBean = tipoCausaBO.listar();
    	request.setAttribute("listaTipoCausaBean", listaTipoCausaBean);
    	
    	TipoCobrancaBO tipoCobrancaBO = new TipoCobrancaBO();
    	List<TipoCobrancaBean> listaTipoCobrancaBean = tipoCobrancaBO.listar();
    	request.setAttribute("listaTipoCobrancaBean", listaTipoCobrancaBean);
    	
		Object objNrProcesso = request.getParameter("nrProcesso");
		Object objCdCliente = request.getParameter("cdCliente");
		
		if(objNrProcesso != null){
			int nrProcesso = Integer.parseInt((String)objNrProcesso);
			ProcessoBO processoBO = new ProcessoBO();
			ProcessoBean processoBean = processoBO.consultar(nrProcesso);
			request.setAttribute("processoBean", processoBean);
			request.getRequestDispatcher("WebSite/paginas/altera-processo.jsp").forward(request, response);
		}else if(objCdCliente != null){
			int cdCliente = Integer.parseInt((String)objCdCliente);
			ClienteBO clienteBO = new ClienteBO();
			ClienteBean clienteBean = clienteBO.consultar(cdCliente);
			request.setAttribute("clienteBean", clienteBean);
			request.getRequestDispatcher("WebSite/paginas/cadastro-processo.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
