<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="br.com.advocacialca.beans.AdvogadoBean"%>
<%@page import="br.com.advocacialca.negocio.AdvogadoBO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
	<title>Advocacia LCA</title>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link type="text/css" rel="stylesheet" href="WebSite/estilos/main.css" />
	<link type="text/css" rel="stylesheet" href="../estilos/main.css" />
	<script type="text/javascript" src="../scripts/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="../scripts/main.js"></script>
	<script type="text/javascript" src="WebSite/scripts/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="WebSite/scripts/main.js"></script>
	
	<%
		AdvogadoBO advogadoBO = new AdvogadoBO();
		List<AdvogadoBean> advogados = advogadoBO.listar();
		if (advogados == null)
			advogados = new ArrayList<AdvogadoBean>();
	%>
	
	<script type="text/javascript">		
		$(document).ready(function() {

			//Preenche os dados automaticamente
			$('.login .cabecalho').toggle(
				<% for (AdvogadoBean adv : advogados) { %>
					
					function (){
						$('#login').val("<%= adv.getDsEmail() %>");
						$('#senha').val("<%= adv.getDsPassword() %>");
						$('#tipoAdvogado').click();	
					}, 
					
				<% } %>
			function () {
				$('#login').val("");
				$('#senha').val("");
			});
			
			//Validação formulário
			$('#formLogin .submit').mousedown(function(e){
				
				var login = $('#login').val();
				var senha = $('#senha').val();
				
				var itensMensagem = [];

				if (login == "")
					itensMensagem.push(msgsValidacaoClient.autenticacao.entrar.login_nao_informado);
				else if (login.length == "")
					itensMensagem.push(msgsValidacaoClient.autenticacao.entrar.login_invalido);
				
				if (senha == "")
					itensMensagem.push(msgsValidacaoClient.autenticacao.entrar.senha_nao_informada);
				else if (senha == "")
					itensMensagem.push(msgsValidacaoClient.autenticacao.entrar.senha_invalida);
			
				if (itensMensagem.length > 0) {
					mostrarMensagem(itensMensagem, "Ocorreu um erro ao efetuar login no sistema", "erro");
					e.preventDetault();
					return false;
				} else {
					$('#formLogin').submit();
				}
				
			});
		});		
	</script>
	
</head>
<body>
	<div class="login box centralizado">
		<div class="cabecalho">
			<h1>Advocacia LCA</h1>
		</div>
		<div class="corpo">			
			<%
				String loginAction = "";
				Object objSaindo = request.getAttribute("saindo");
				loginAction = objSaindo != null ? "./AutenticacaoSetup" : "../../AutenticacaoSetup";
			%>
			<form id="formLogin" action="<%= loginAction %>" method="post">
				<span>Login:</span><br /><input id="login" name="login" type="text" /><br />			
				<span>Senha:</span><br /><input id="senha" name="senha" type="password" /><br />
				
				<input type="radio" value="0" name="tipoUsuario" id="tipoSecretaria" checked="checked"/>
				<label for="tipoSecretaria" >Secretária</label>
				<input type="radio" value="1" name="tipoUsuario" id="tipoAdvogado" />
				<label for="tipoAdvogado" >Advogado</label><br />
				
				<br />
				
				<input type="reset" value="Limpar" />				
				<input type="button" value="Entrar" class="submit" />
			</form>
		</div>
	</div>
</body>
</html>