<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="br.com.advocacialca.beans.PessoaBean"%>
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
			
			function atualizaLinkPesquisa(){
				
				var link = $('#tipoPesquisa').val(); 
				
				var cdPesquisa = $('#cdPesquisa').val();
				
				var linkCompleto = (cdPesquisa.trim() == "" || isNaN(cdPesquisa)) ? "javascript:void(0);" : link + cdPesquisa;		
				
				$('#pesquisaRapida').attr('href', linkCompleto);
			}
			
			$('#cdPesquisa').keyup(atualizaLinkPesquisa);

			$('#tipoPesquisa').change(atualizaLinkPesquisa);
			
			$('#pesquisaRapida').click(function(){
				
				var cdPesquisa = $('#cdPesquisa').val();
				
				var itensMensagem = [];
				
				if (cdPesquisa.trim() == "")
					itensMensagem.push(msgsValidacaoClient.pesquisaRapida.codigo_nao_informado);
				else if (isNaN(cdPesquisa))
					itensMensagem.push(msgsValidacaoClient.pesquisaRapida.codigo_invalido);
				
				if (itensMensagem.length > 0) {
					mostrarMensagem(itensMensagem, "Ocorreu executar a pesquisa", "erro");
					e.preventDetault();
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
				<h3>- Home</h3>
			</div>
			<div class="menu">
				<ul>
					<li>
						<a href="./ListaClienteSetup">Lista de Clientes</a>
					</li>
					<li>
						<a class="" href="javascript:void(0);">Relatórios</a>
						<div class="submenu">
							<ul>
								<li><a href="./RelatorioAudienciaSetup">Relatório de Audiências</a></li>
								<li><a href="./RelatorioHonorarioSetup">Relatório de Honorários</a></li>
							</ul>
						</div>
					</li>
					<li>
						<a class="" href="javascript:void(0);">Honorários</a>
						<div class="submenu">
							<ul>
								<li><a href="./CadastroHonorarioSetup">Lançar Honorários</a></li>
								<li><a href="./ListaHonorarioSetup">Lista de Honorários</a></li>
							</ul>
						</div>
					</li>
					<li><a href="./ListaTitulosProcessoSetup">Registrar Pagamentos</a></li>
				</ul>
			</div>
		</div>		
		<div class="corpo">
			<table class="cadastro" frame="box" rules="none" cellpadding="8px">
				<tr>
					<td>Tipo de Pesquisa:</td>
					<td>
						<select id="tipoPesquisa">
							<option value="./PreparaCadastroProcesso?nrProcesso=">Processo</option>
							<option value="./DetalheClienteSetup?cdCliente=">Cliente</option>
							<option value="./AdvogadosProcesso?nrProcesso=">Advogados do Processo</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>Código:</td>
					<td>
						<input type="text" id="cdPesquisa" maxlength="9"/>
					</td>
				</tr>
				<tr class="buttons">
					<td colspan="2">
						<a href="javascript:void(0);" id="pesquisaRapida">
							<input type="button" value="Pesquisar" />
						</a>
						<input type="button" value="Voltar" class="voltar" />
					</td>
				</tr>
			</table>
		</div>
		<div class="rodape">
			<strong>&copy; 2012 Advocacia LCA </strong>
			- Todos os direitos reservados. <br />
			<img src="WebSite/estilos/images/pixel.png" height="33" width="60" style="margin-top:6px;" />
		</div>
	</div>
</body>
</html>