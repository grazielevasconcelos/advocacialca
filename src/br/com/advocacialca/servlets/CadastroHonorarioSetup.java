package br.com.advocacialca.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.advocacialca.beans.AdvogadoBean;
import br.com.advocacialca.beans.PessoaBean;
import br.com.advocacialca.beans.ProcessoBean;
import br.com.advocacialca.beans.TarefaBean;
import br.com.advocacialca.negocio.AdvogadoBO;
import br.com.advocacialca.negocio.ProcessoBO;
import br.com.advocacialca.negocio.TarefaBO;

public class CadastroHonorarioSetup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CadastroHonorarioSetup() {
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
			
			ProcessoBO processoBO = new ProcessoBO();
			List<ProcessoBean> listaProcesso = processoBO.listarPorAdvogado(cdAdvogado);
			request.setAttribute("listaProcesso", listaProcesso);
		}
		
		
		TarefaBO tarefaBO = new TarefaBO();
		List<TarefaBean> listaTarefaBean = tarefaBO.listar();
		request.setAttribute("listaTarefaBean", listaTarefaBean);
		
		request.getRequestDispatcher("/WebSite/paginas/cadastro-honorario.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
