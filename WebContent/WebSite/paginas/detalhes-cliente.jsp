<%@page import="br.com.advocacialca.beans.TipoCausaBean"%>
<%@page import="br.com.advocacialca.beans.PessoaBean"%>
<%@page import="br.com.advocacialca.negocio.TipoCausaBO"%>
<%@page import="br.com.advocacialca.beans.ProcessoBean"%>
<%@page import="br.com.advocacialca.beans.TelefoneBean"%>
<%@page import="br.com.advocacialca.beans.ClienteBean"%>
<%@page import="java.util.List"%>
<html>
<head>
	<title>Advocacia LCA</title>
	<link type="text/css" rel="stylesheet" href="WebSite/estilos/main.css" />
	<script type="text/javascript" src="WebSite/scripts/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="WebSite/scripts/main.js"></script>
	<script type="text/javascript" src="WebSite/scripts/relatorios.js"></script>
	<% ClienteBean cliente = (ClienteBean)request.getAttribute("cliente"); %>
	<script type="text/javascript">
		$(document).ready(function(){			
			$('#filtrarProcessoPorNome').keyup(filtrarRelatorio);
			
			$('#addProcesso').click(function(){
				window.location = "PreparaCadastroProcesso?cdCliente=<%= cliente.getPessoa().getCdPessoa() %>";
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
				<h3>- Página do Cliente</h3>
			</div>
			<div class="menu" />
		</div>		
		<div class="corpo">
			<h3>Dados do Cliente</h3>
			<table class="cabecalho border" frame="box" rules="rows" cellpadding="8px">
				<tr>
					<th>Cliente</th>
					<td><%= cliente.getPessoa().getNmPessoa() %></td>
				</tr>
				<tr>
					<th>Razão Social</th>
					<td><%= cliente.getNmRazaoSocial() %></td>
				</tr>
				<tr>
					<th>CNPJ</th>
					<td><%= cliente.getNrCNPJ() %></td>
				</tr>
				<tr>
					<th>Inscrição Estadual</th>
					<td><%= cliente.getNrInscEstadual() %></td>
				</tr>
				<% List<TelefoneBean> listaTelefones = (List<TelefoneBean>)request.getAttribute("telefones");%>
				<% if (listaTelefones != null) { %>
					<%for(TelefoneBean telefone : listaTelefones) { %>
					<tr>
						<th>Telefone <%= telefone.getTipoTelefone().getDsTipoTelefone() %>:</th>
						<td>
								(<%= telefone.getNrDDD() %>) <%= telefone.getNrTelefone() %><br>
						</td>
					</tr>
					<% } %>
				<% } %>
				<tr>
					<th>Email</th>
					<td><%= cliente.getDsEmail() %></td>
				</tr>
			</table>
			<div class="boxLista">
				<h3>Lista de Processos do Cliente</h3>
				<input id="filtrarProcessoPorNome" type="text" class="filtro-lista" value="" seletorLinha="table.relatorio tr" entidadeLista="processo" />
				<input id="addProcesso" type="button" class="acao-lista" value="Novo Processo" />
				<br />
				<% List<ProcessoBean> listaProcessos = (List<ProcessoBean>)request.getAttribute("listaProcesso"); %>
				<% if (listaProcessos != null) { %>
					<div class="boxRelatorio">
						<table class="relatorio" rules="rows" cellpadding="8px">
							<tr class="cabecalho">
								<th>No. Processo</th>
								<th>Descrição</th>
								<th>Tipo de Causa</th>
								<th></th>
								<th style="" width="50px"></th>
							</tr>
							<% for(ProcessoBean processo : listaProcessos){ %>
							<tr>
								<td><%=processo.getNrProcesso() %></td>
								<td><%= processo.getDsProcesso() %></td>
								<td><%= processo.getTipoCausa().getDsCausa() %></td>
								<td><a href="PreparaCadastroProcesso?nrProcesso=<%= processo.getNrProcesso() %>"><img src="WebSite/estilos/images/editar.png" /></a></td>
								<td><a href="AdvogadosProcesso?nrProcesso=<%= processo.getNrProcesso() %>"><img src="WebSite/estilos/images/incluir.png"/></a></td>
							</tr>
							<% } %>
						</table>
					</div>
				<% } %>
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