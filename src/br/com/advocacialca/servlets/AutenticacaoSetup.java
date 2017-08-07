package br.com.advocacialca.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.advocacialca.beans.AdvogadoBean;
import br.com.advocacialca.beans.PessoaBean;
import br.com.advocacialca.negocio.AutenticacaoBO;

public class AutenticacaoSetup extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static final int tipoLoginAdvogado = 1;
	private static final int tipoLoginSecretaria = 0;
	private static final String loginSecretaria = "secretaria";
	private static final String senhaSecretaria = "abc123";
       
    public AutenticacaoSetup() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("usuarioLogado", null);
		request.getRequestDispatcher("/WebSite/paginas/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String proximaPagina = "/WebSite/paginas/login.jsp?invalid=1";
		
		Object objLogin = request.getParameter("login");
		Object objSenha = request.getParameter("senha");
		Object objTipoUsuario = request.getParameter("tipoUsuario");
		
		if (objLogin != null && objSenha != null && objTipoUsuario != null) {
			
			int tipoUsuario = Integer.parseInt((String)objTipoUsuario);

			String login = (String)objLogin;
			String senha = (String)objSenha;
			
			PessoaBean usuarioLogado = null;
			
			switch (tipoUsuario) {
				case tipoLoginAdvogado:
					AutenticacaoBO autenticacaoBO = new AutenticacaoBO();
					AdvogadoBean advogadoBean = autenticacaoBO.logarAdvogado(login, senha);
					if (advogadoBean != null && advogadoBean.getPessoa() != null)
						usuarioLogado = advogadoBean.getPessoa();
					break;
				case tipoLoginSecretaria:
					if (login == loginSecretaria && senha == senhaSecretaria) {
						usuarioLogado = new PessoaBean();
						usuarioLogado.setCdPessoa(-1);
						usuarioLogado.setNmPessoa("Secretaria");
					}
					break;
			}
			
			if (usuarioLogado == null) {
				proximaPagina = "/WebSite/paginas/login.jsp?inv=1";
			} else {
				request.getSession().setAttribute("usuarioLogado", usuarioLogado);
				proximaPagina = "/WebSite/paginas/index.jsp";
			}
			
		}
		
		request.getRequestDispatcher(proximaPagina).forward(request, response);
		
	}

}
