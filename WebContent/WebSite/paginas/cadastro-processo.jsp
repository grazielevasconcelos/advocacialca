<%@page import="br.com.advocacialca.beans.TipoCobrancaBean"%>
<%@page import="br.com.advocacialca.beans.PessoaBean"%>
<%@page import="br.com.advocacialca.beans.TipoCausaBean"%>
<%@page import="br.com.advocacialca.beans.ForumBean"%>
<%@page import="java.util.List"%>
<%@page import="br.com.advocacialca.beans.ClienteBean"%>
<html>
<head>
	<title>Advocacia LCA</title>
	<link type="text/css" rel="stylesheet" href="WebSite/estilos/main.css" />
	<script type="text/javascript" src="WebSite/scripts/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="WebSite/scripts/main.js"></script>
	<script type="text/javascript" src="WebSite/scripts/relatorios.js"></script>
	<script type="text/javascript">		
		$(document).ready(function(){

			$('#cadProcesso .submit').mousedown(function(e){
				
				var nrProcesso = $('#nrProcesso').val();
				var dataAbertura = $('#dataAbertura').val();
				var dataFechamento = $('#dataFechamento').val();
				var dsProcesso = $('#dsProcesso').val();
				var dsObservacao = $('#dsObservacao').val();
				
				var itensMensagem = [];
				
				if (nrProcesso.trim() == "")
					itensMensagem.push(msgsValidacaoClient.cadastros.processo.numero_processo_nao_informado);
				else if (isNaN(nrProcesso))
					itensMensagem.push(msgsValidacaoClient.cadastros.processo.numero_processo_invalido);
				
				if (dataAbertura.trim() == "")
					itensMensagem.push(msgsValidacaoClient.cadastros.processo.data_abertura_nao_informada);
				else if (validaData(dataAbertura))
					itensMensagem.push(msgsValidacaoClient.cadastros.processo.data_abertura_invalida);
				
				//if (dataFechamento.trim() == "")
				//	itensMensagem.push(msgsValidacaoClient.cadastros.processo.data_fechamento_nao_informada);
				//else if (validaData(dataFechamento))
				//	itensMensagem.push(msgsValidacaoClient.cadastros.processo.data_fechamento_invalida);
				
				if (dsProcesso.trim() == "")
					itensMensagem.push(msgsValidacaoClient.cadastros.processo.desc_processo_nao_informada);
				else if (validaLetrasENumeros(dsProcesso))
					itensMensagem.push(msgsValidacaoClient.cadastros.processo.desc_processo_invalida);
				
				if (validaLetrasENumeros(dsObservacao))
					itensMensagem.push(msgsValidacaoClient.cadastros.processo.desc_observacao_invalida);
				
				if (itensMensagem.length > 0) {
					mostrarMensagem(itensMensagem, "Ocorreu um erro cadastrar o processo ", "erro");
					e.preventDetault();
					return false;
				} else {
					$('#cadProcesso').submit();
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
				<h3>- Cadastro de Processo</h3>
			</div>
			<div class="menu" />
		</div>		
		<div class="corpo">
			<form id="cadProcesso" action="CadastraProcesso" method="POST">
				<input type="hidden" name="tipoManutencao" value="cadastro"/>
				<% ClienteBean clienteBean = (ClienteBean)request.getAttribute("clienteBean"); %>
				<table class="cadastro" frame="box" rules="none" cellpadding="8px">
					<tr>
						<td>Cliente:</td>
						<td>
							<input type="text" name="nomeCliente" disabled="disabled" value="<%= clienteBean.getPessoa().getNmPessoa() %>" />
							<input type="hidden" name="cdCliente" value="<%= clienteBean.getPessoa().getCdPessoa() %>"/>
						</td>
					</tr>
					<tr>
						<td>Nr. Processo:</td>
						<td>
							<input type="text" name="nrProcesso" id="nrProcesso" maxlength="9"  />
						</td>
					</tr>
					<tr>
						<td>Fórum:</td>
						<td>
							<% List<ForumBean> listaForumBean = (List<ForumBean>)request.getAttribute("listaForumBean"); %>
							<select name="forum" id="forum">
								<% for(ForumBean forumBean : listaForumBean){%>
								<option value="<%= forumBean.getPessoa().getCdPessoa() %>"><%= forumBean.getPessoa().getNmPessoa() %></option>
								<% } %>
							</select>
						</td>
					</tr>
					<tr>
						<td>Tipo de causa:</td>
						<td>
							<% List<TipoCausaBean> listaTipoCausaBean = (List<TipoCausaBean>)request.getAttribute("listaTipoCausaBean"); %>
							<select name="tipoCausa" id="tipoCausa">
								<% for(TipoCausaBean tipoCausaBean : listaTipoCausaBean){ %>
								<option value="<%= tipoCausaBean.getCdCausa() %>"><%= tipoCausaBean.getDsCausa() %></option>
								<% } %>
							</select>
						</td>
					</tr>
					<tr>
						<td>Tipo de cobrança:</td>
						<td>
							<% List<TipoCobrancaBean> listaTipoCobrancaBean = (List<TipoCobrancaBean>)request.getAttribute("listaTipoCobrancaBean"); %>
							<select name="tipoCobranca" id="tipoCobranca">
								<% for(TipoCobrancaBean tipoCobrancaBean : listaTipoCobrancaBean){ %>
								<option value="<%= tipoCobrancaBean.getCdCobranca() %>"><%= tipoCobrancaBean.getDsCobranca() %></option>
								<% } %>
							</select>
						</td>
					</tr>
					<tr>
						<td>Vencimento do Pagamento:</td>
						<td>
							<select name="dataVencimento" id="dataVencimento">
								<% for(int cont = 1; cont<32; cont++){ %>
									<option value="<%= cont %>">Dia <%= cont %></option>
								<%} %>
							</select>
						</td>
					</tr>
					<tr>
						<td>Data de Abertura:</td>
						<td>
							<input type="text" name="dataAbertura" id="dataAbertura" />
						</td>
					</tr>
					<tr>
						<td>Data de Fechamento:</td>
						<td>
							<input type="text" name="dataFechamento" id="dataFechamento" />
						</td>
					</tr>
					<tr>
						<td>Descrição do Processo:</td>
						<td>
							<textarea rows="3" cols="30" name="dsProcesso" id="dsProcesso"></textarea>
						</td>
					</tr>
					<tr>
						<td>Observações do Processo:</td>
						<td>
							<textarea rows="3" cols="30" name="dsObservacao" id="dsObservacao"></textarea><br />
						</td>
					</tr>
					<tr class="buttons">
						<td colspan="2">
							<input type="button" value="Novo" class="submit" />
							<input type="reset" value="Limpar" />
							<input type="button" value="Bloquear" />
							<input type="button" value="Voltar" class="voltar" />
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div class="rodape">
			<strong>&copy; 2012 Advocacia LCA </strong>
			- Todos os direitos reservados. <br />
			<img src="WebSite/estilos/images/pixel.png" height="33" width="60" style="margin-top:6px;" />
		</div>
	</div>
</body>
</html>
	