<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="br.com.advocacialca.beans.PessoaBean"%>
<%@page import="br.com.advocacialca.beans.RespostaCRUD"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Advocacia LCA</title>
	<link type="text/css" rel="stylesheet" href="WebSite/estilos/main.css" />
	<script type="text/javascript" src="WebSite/scripts/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="WebSite/scripts/main.js"></script>
	<script type="text/javascript" src="WebSite/scripts/relatorios.js"></script>
	<style>
		
		div.output.erro {
			width: 100%;
		}
		div.output.erro {
			border: 1px solid red;
		}
		div.output.sucesso {
			border: 1px solid green;
		}
		
		
		div.output > div.cabecalho, 
		div.output > div.chao  {
			padding-top: 10px;
			padding-left: 10px;
			height: 30px!important;
			font-weight: bolder;
			color: #EEE;
		}
		div.output.erro > div.cabecalho, 
		div.output.erro > div.chao  {
			color: #FFF;
			background-color: #F88;
		}
		div.output.sucesso > div.cabecalho, 
		div.output.sucesso > div.chao  {
			color: #444;
			background-color: #ADA;
		}
				
				
		div.output > div.cabecalho img.erro {
			height: 20px;
			float: right;
			margin-right: 10px;
		}
		div.output > div.cabecalho img.sucesso {
			height: 20px;
			float: right;
			margin-right: 10px;
		}
		
		
		div.output > div.corpo {
			padding-top: 10px;
			padding-left: 10px;
			padding-left: 10px;
			height: 180px;
			background-color: #FFF;
			overflow-y: scroll;
		}
		
		div.output > div.chao {
			height: 30px!important;
		} 
		
		
		a.output {
			text-align: left;
			font-weight: bolder;
		}
		a.output.erro {
			color: #FFF;
		}
		a.output.sucesso {
			color: #444;
		}
		
	</style>
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
				<h3>- Home</h3>
			</div>
			<div class="menu"/>
		</div>		
		<div class="corpo">
			<div class="pesquisa">
				<%
				RespostaCRUD respostaCRUD = null;
				Object objRespostaCRUD = request.getAttribute("respostaCRUD");
				if (objRespostaCRUD != null)
					respostaCRUD = (RespostaCRUD)objRespostaCRUD;
				%>
				<% if (respostaCRUD != null) { %>
					<% if (respostaCRUD.isSucesso()) { %>
						<div class="output sucesso">
							<div class="cabecalho">
								<img class="sucesso" src="WebSite/estilos/images/Accept.png"/>
								Operação efetuada com sucesso
							</div>
							<div class="corpo">
								<%= respostaCRUD.getMensagem() %>
							</div>
							<div class="chao">
								<a class="output sucesso" href="<%= respostaCRUD.getLinkRedirecionamento() %>">
									<%= respostaCRUD.getTxtLinkRedirecionamento() %>
								</a>
							</div>
						</div>
					<% } else { %>
						<div class="output erro">
							<div class="cabecalho">
								<img class="erro" src="WebSite/estilos/images/excluir.png"/>
								Ocorreu um erro no servidor
							</div>
							<div class="corpo">
								<%= respostaCRUD.getMensagem() %>
							</div>
							<div class="chao">
								<a class="output erro" href="<%= respostaCRUD.getLinkRedirecionamento() %>">
									<%= respostaCRUD.getTxtLinkRedirecionamento() %>
								</a>
							</div>
						</div>
					<% } %>
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








