<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.List"%>
<%@page import="br.com.advocacialca.beans.PessoaBean"%>
<%@page import="br.com.advocacialca.beans.TelefoneBean"%>
<%@page import="br.com.advocacialca.beans.RelatorioHonorariosBean"%>
<%@page import="br.com.advocacialca.beans.ItemRelatorioHonorarios"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Advocacia LCA</title>
	<link type="text/css" rel="stylesheet" href="WebSite/estilos/main.css" />
	<script type="text/javascript" src="WebSite/scripts/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="WebSite/scripts/main.js"></script>
	<script type="text/javascript" src="WebSite/scripts/relatorios.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			
			$('#emitirRel .submit').mousedown(function(e){
				
				var idProcesso = $('#nrProcesso').val();
				
				var itensMensagem = [];

				if (idProcesso.trim() == "")
					itensMensagem.push(msgsValidacaoClient.relatorios.numero_processo_nao_informado);
				else if (isNaN(idProcesso))
					itensMensagem.push(msgsValidacaoClient.relatorios.numero_processo_invalido);
				
				if (itensMensagem.length > 0) {
					mostrarMensagem(itensMensagem, "Ocorreu um gerar o Relatório de Audiências", "erro");
					e.preventDetault();
					return false;
				} else {
					$('#emitirRel').submit();
				}
				
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
				<h3>- Emitir relatório de Honorários do Processo</h3>
			</div>
			<div class="menu" />
		</div>		
		<div class="corpo">
			<% 
			
			Object objRel = (RelatorioHonorariosBean)request.getAttribute("relHonorarios"); 
			
			RelatorioHonorariosBean relHonorariosBean = null;
			
			if(objRel != null)
				relHonorariosBean = (RelatorioHonorariosBean)objRel;
			
			String nrProcesso = relHonorariosBean != null ? String.valueOf(relHonorariosBean.getProcesso().getNrProcesso()) : "";
			
			%>
			<form id="emitirRel" method="post" action="./RelatorioHonorarioSetup">
				<h3>Nr. Processo</h3>
				<input type="text" class="filtro-lista" value="<%= nrProcesso %>" id="nrProcesso" name="nrProcesso" maxlength="9"/>
				<input type="button" class="acao-lista submit" value="Emitir Relatório" />
			</form>
			<br />
			
			<% if (relHonorariosBean != null) { %>
			
				<table class="cabecalho border" frame="box" rules="rows" cellpadding="8px">
					<tr>
						<th>Nome do Cliente</th>
						<td><%= relHonorariosBean.getCliente().getPessoa().getNmPessoa() %></td>
					</tr>
					<% for (TelefoneBean telefone : relHonorariosBean.getTelefones()) { %>
					<tr>
						<th>Telefone <%= telefone.getTipoTelefone().getDsTipoTelefone() %></th>
						<td>
							(<%= telefone.getNrDDD() %>)&ensp;<%= telefone.getNrTelefone() %>
						</td>
					</tr>
					<% } %>
					<tr>
						<th>Número do Processo</th>
						<td><%= relHonorariosBean.getProcesso().getNrProcesso() %></td>
					</tr>
					<tr>
						<th>Descrição do Processo</th>
						<td><%= relHonorariosBean.getProcesso().getDsProcesso() %> </td>
					</tr>
				</table>
				<br />
				<div class="boxRelatorio">				
					<table class="relatorio" rules="rows" cellpadding="8px">
						<thead>					
							<tr>
								<th>Data da tarefa</th>
								<th>Nome do Advogado</th>
								<th>Valor da tarefa</th>
							</tr>
						</thead>
						<tbody>
						<% float total = 0; %>
						<% for (ItemRelatorioHonorarios item : relHonorariosBean.getItemsRelatorioHonorario()) { %>
							<% total += item.getValorTarefa(); %>
							<tr>
								<td><%= item.getDtTarefa() %></td>
								<td><%= item.getNomeAdvogado() %></td>
								<td><%= item.getValorTarefa() %></td>
							</tr>
						<%} %>
						</tbody>
						<tfoot>
							<th colspan="2" style="text-align:right;">Total</th>
							<% DecimalFormat df = new DecimalFormat("0.##"); %>
							<% String dx = df.format(total); %>
							<td><%= dx %></td>
						</tfoot>
					</table>
				</div>
				
			<%} %>
		</div>
		<div class="rodape">
			<strong>&copy; 2012 Advocacia LCA </strong>
			- Todos os direitos reservados. <br />
			<img src="WebSite/estilos/images/pixel.png" height="33" width="60" style="margin-top:6px;" />
		</div>
	</div>
</body>
</html>