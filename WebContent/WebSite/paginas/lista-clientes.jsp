<%@page import="br.com.advocacialca.beans.ClienteBean"%>
<%@page import="br.com.advocacialca.beans.PessoaBean"%>
<%@page import="java.util.List"%>
<html>
<head>
	<title>Advocacia LCA</title>
	<link type="text/css" rel="stylesheet" href="WebSite/estilos/main.css" />
	<script type="text/javascript" src="WebSite/scripts/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="WebSite/scripts/main.js"></script>
	<script type="text/javascript" src="WebSite/scripts/relatorios.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){			
			$('#filtrarClientePorNome').keyup(filtrarRelatorio);
			$('#addCliente').click(function(){
				var itensMensagem = ["A funcionalidade de cadastrar clientes não foi implementada"];
				mostrarMensagem(itensMensagem, "Ocorreu um erro", "erro");
			});
		});
	</script>
</head>
<body>
	<%
	PessoaBean usuarioLogado = null;
	Object objUsuarioLogado = request.getSession().getAttribute("usuarioLogado");
	if (objUsuarioLogado != null)
		usuarioLogado = (PessoaBean)objUsuarioLogado;
	%>
	<div class="site box centralizado-x">	
		<div class="cabecalho">
			<div class="informacoes-login">
				<span class="usuario-logado"><%= usuarioLogado.getNmPessoa() %></span> - 
				<a href="WebSite/paginas/login.jsp" class="sair">Sair</a>&emsp;
			</div>
			<div class="banner">
				<a href="./IndexSetup">
					<img class="logo" src="WebSite/estilos/images/logo.png"/>
				</a>
				<h1>Controle de processos e cobrança de honorários</h1>
				<h3>- Lista de Clientes</h3>
			</div>
			<div class="menu" />
		</div>		
		<div class="corpo">
			<div class="boxLista">
				<h3>Lista de Clientes</h3>
				<input id="filtrarClientePorNome" type="text" class="filtro-lista" value="" seletorLinha="table.relatorio tr" entidadeLista="cliente" />
				<input id="addCliente" type="button" class="acao-lista" value="Novo Cliente" />
				<br />
				<div class="boxRelatorio">
					<table class="relatorio" rules="rows" cellpadding="8px">
						<tr class="cabecalho">
							<th>Id</th>
							<th>Nome</th>
							<th>Razão Social</th>
							<th>Email</th>
							<th style="" width="55"></th>
						</tr>
						
						<% List<ClienteBean> clientes = (List<ClienteBean>)request.getAttribute("listaCliente"); 
						
						if (clientes != null) {
							for(ClienteBean cliente : clientes) {
							%>
								<tr>
									<td><%= cliente.getPessoa().getCdPessoa() %></td>
									<td><%= cliente.getPessoa().getNmPessoa() %>
									<td><%= cliente.getNmRazaoSocial() %></td>
									<td><%= cliente.getDsEmail() %></td>
									<td><a href="DetalheClienteSetup?cdCliente=<%= cliente.getPessoa().getCdPessoa() %>" ><img src="WebSite/estilos/images/editar.png" alt="Cadastrar Processo do Cliente" /></a></td>
								</tr>
							<% } %>
						<% } %>
					</table>
				</div>
			</div>
		</div>
		<div class="rodape">
			<strong>&copy; 2012 Advocacia LCA </strong>
			- Todos os direitos reservados. <br />
			<img src="WebSite/estilos/images/pixel.png" height="33" width="60" style="margin-top:6px;" />
		</div>
	</div>
</body>
</html>