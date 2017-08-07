/* SCRIPTS UTILIZADOS EM TODAS AS P�GINAS ***************************************************************************************************************************************/

(function($){
	
	$(document).ready(function(){
		$('.cabecalho .menu').html(obterHtmlMenu());

		$('.voltar').click(function(){
			window.history.back();
		});
	});
	
})(jQuery);

/* FUNCIONALIDADES DIVERSAS ***************************************************************************************************************************************/

function filtrarRelatorio() {
	var seletorLinha = $(this).attr("seletorLinha");
	var termoPesquisado = $(this).val().toLowerCase();
	if (termoPesquisado == "") {
		$(seletorLinha).removeClass('hide');
	} else {					
		$(seletorLinha).each(function(){
			var possuiValor = false;
			var linhaAtual = $(this);
			if (!linhaAtual.hasClass('cabecalho') && !linhaAtual.hasClass('rodape')) {
				$('td', linhaAtual).each(function(){
					if ($(this).text().toLowerCase().indexOf(termoPesquisado) > -1)
						possuiValor = true;
				});
				if (!possuiValor) 
					linhaAtual.addClass('hide');
				else
					linhaAtual.removeClass('hide');
			}
		});
	}
	
	var linhasVisiveis = $(seletorLinha + ':visible td');
	
	if (linhasVisiveis.length == 0) {
		
		var entidadeLista = $(this).attr("entidadeLista");
		
		var itensMensagem = [msgsValidacaoClient.filtroPesquisaEmLista[entidadeLista]];
		
		mostrarMensagem(itensMensagem, "Erro ao aplicar filtro", "erro");
	}
}

/* VALIDA��O DE FORMUL�RIOS ***************************************************************************************************************************************/

function mensagem() {
	
	var novaMensagem = {
		titulo: "Erro ao efetuar opera��o",
		tipo: "erro",
		itens: [],
		add: function(item){ this.itens.push(item); }
	};
	
	return novaMensagem;
}

function mostrarMensagem(itens, titulo, tipo) {
	
	var paramsMensagem = new mensagem();

	paramsMensagem.tipo = tipo ? tipo : paramsMensagem.tipo;
	paramsMensagem.titulo = titulo ? titulo : paramsMensagem.titulo;
	
	for (var i=0; i < itens.length; i++)
		paramsMensagem.add(itens[i]);
	
	$('body').append(obterHtmlMensagem(paramsMensagem));
	
	$('.fecha-mensagem').live('click', function(){
		$('.modal').remove();
	});
	
}

var msgsValidacaoClient = {
	cadastros: {
		processo: {
			numero_processo_nao_informado: 'Informe o n�mero do processo',
			numero_processo_invalido: 'N�mero de processo inv�lido',
			data_abertura_nao_informada: 'Informe data de abertura do processo',
			data_abertura_invalida: 'Data de abertura do processo inv�lido',
			data_fechamento_nao_informada: 'Informe data de fechamento do processo',
			data_fechamento_invalida: 'Data de fechamento do processo inv�lido',
			desc_processo_nao_informada: 'Informe descri��o do processo',
			desc_processo_invalida: 'Descri��o inv�lida. Utilize apenas letras e n�meros',
			desc_observacao_invalida: 'Observa��o inv�lida. Utilize apenas letras e n�meros'
		},
		honorario: {
			numero_processo_nao_informado: 'Informe o n�mero do processo',
			numero_processo_invalido: 'N�mero de processo inv�lido',
			data_honorario_nao_informada: 'Informe a data do honor�rio',
			data_honorario_invalida: 'Data do honor�rio inv�lido',
			horas_honorario_nao_informado: 'Informe a quantidade de horas do honor�rio',
			horas_honorario_invalido: 'Quantidade de horas inv�lida',
			horas_honorario_fora_range: 'Quantidade de horas deve ser no minimo: 1 e no maximo: 24',
			desc_observacao_invalida: 'Observa��o inv�lida. Utilize apenas letras e n�meros'
		},
		pagamento: {
			a: '',
			b: '',
			c: ''
		},
	},
	relatorios: {
		numero_processo_nao_informado: 'Informe o n�mero do processo',
		numero_processo_invalido: 'N�mero de processo inv�lido'
	},
	autenticacao: {
		entrar: {
			login_nao_informado: 'Informe o login de usu�rio',
			login_invalido: 'Login de usu�rio inv�lido',
			senha_nao_informada: 'Informe a senha de usu�rio',
			senha_invalida: 'Senha de usu�rio inv�lida'
		},
		sair: {
			a: '',
			b: '',
			c: ''
		}
	},
	filtroPesquisaEmLista: {
		cliente: 'N�o foram encontrados Clientes a partir do termo digitado',
		processo: 'N�o foram encontrados Processos a partir do termo digitado',
		honorario: 'N�o foram encontrados Honor�rios a partir do termo digitado'
	},
	pesquisaRapida: {
		codigo_nao_informado: "Informe o c�digo a ser pesquisado",
		codigo_invalido: "C�digo inv�lido. O c�digo � num�rico"
	}
};

/* OBTEN��O DE HTML ***************************************************************************************************************************************/

function obterHtmlMenu() {

	var menuHtml = "".concat("<ul>")
	.concat("<li>")
	.concat("<a href='/AdvocaciaLCA/ListaClienteSetup'>Lista de Clientes</a>")
	.concat("</li>")
	.concat("<li>")
	.concat("<a class='' href='javascript:void(0);'>Relat�rios</a>")
	.concat("<div class='submenu'>")
	.concat("<ul>")
	.concat("<li><a href='/AdvocaciaLCA/RelatorioAudienciaSetup'>Relat�rio de Audi�ncias</a></li>")
	.concat("<li><a href='/AdvocaciaLCA/RelatorioHonorarioSetup'>Relat�rio de Honor�rios</a></li>")
	.concat("</ul>")
	.concat("</div>")
	.concat("</li>")
	.concat("<li>")
	.concat("<a class='' href='javascript:void(0);'>Honor�rios</a>")
	.concat("<div class='submenu'>")
	.concat("<ul>")
	.concat("<li><a href='/AdvocaciaLCA/CadastroHonorarioSetup'>Lan�ar Honor�rios</a></li>")
	.concat("<li><a href='/AdvocaciaLCA/ListaHonorarioSetup'>Lista de Honor�rios</a></li>")
	.concat("</ul>")
	.concat("</div>")
	.concat("</li>")
	.concat("<li><a href='/AdvocaciaLCA/ListaTitulosProcessoSetup'>Registrar Pagamentos</a></li>")
	.concat("</ul>");
	
	return menuHtml;

}

function obterHtmlMenuAdvogado() {

	var menuHtml = "".concat("<ul>")
	.concat("<li>")
	.concat("<a class='javascript:void(0);' href='javascript:void(0);'>Cadastros</a>")
	.concat("<div class='submenu'>")
	.concat("<ul>")
	.concat("<li><a href='javascript:void(0);'>Tipo de Honor�rio</a>")
	.concat("</li>")
	.concat("<li><a href='javascript:void(0);'>Tipo de Despesa</a>")
	.concat("</li>")
	.concat("<li><a href='javascript:void(0);'>Tipo de Causa</a>")
	.concat("</li>")
	.concat("<li><a href='javascript:void(0);'>F�runs</a>")
	.concat("</li>")
	.concat("<li><a href='javascript:void(0);'>Valor/Hora</a>")
	.concat("</li>")
	.concat("</ul>")
	.concat("</div></li>")
	.concat("<li><a class='' href='javascript:void(0);'>Financeiro</a>")
	.concat("<div class='submenu'>")
	.concat("<ul>")
	.concat("<li><a href='javascript:void(0);'>Lan�ar Despesas</a>")
	.concat("</li>")
	.concat("<li><a href='./CadastroHonorarioSetup'>Lan�ar Honor�rios</a>")
	.concat("</li>")
	.concat("</ul>")
	.concat("</div></li>")
	.concat("<li><a class='' href='javascript:void(0);'>Jur�dico</a>")
	.concat("<div class='submenu'>")
	.concat("<ul>")
	.concat("<li><a href='javascript:void(0);'>Agendar Audi�ncia</a>")
	.concat("</li>")
	.concat("</ul>")
	.concat("</div></li>")
	.concat("<li><a class='' href='javascript:void(0);'>Consulta</a>")
	.concat("<div class='submenu'>")
	.concat("<ul>")
	.concat("<li><a href='./ListaHonorarioSetup'>Listar Honor�rios</a></li>  ")
    .concat("<li><a href='./ListaClienteSetup'>Listar Clientes</a></li>  ")
	.concat("<li><a href='javascript:void(0);'>Consultar Processos</a></li>")
	.concat("</ul>")
	.concat("</div></li>")
	.concat("<li><a class='' href='javascript:void(0);'>Relat�rios</a>")
	.concat("<div class='submenu'>")
	.concat("<ul>")
	.concat("<li><a href='javascript:void(0);'>Processos</a>")
	.concat("</li>")
	.concat("<li><a href='javascript:void(0);'>Despesas</a>")
	.concat("</li>")
	.concat("<li><a href='javascript:void(0);'>Tarefas</a>")
	.concat("</li>")
	.concat("<li><a href='javascript:void(0);'>Receitas Anuais</a>")
	.concat("</li>")
	.concat("<li><a href='javascript:void(0);'>Pagamentos em Aberto</a>")
	.concat("</li>")
	.concat("<li><a href='./RelatorioAudienciaSetup'>Audi�ncias</a>")
	.concat("</li>")
	.concat("<li><a href='./RelatorioHonorarioSetup'>Honor�rios</a>")
	.concat("</li>")
	.concat("</ul>")
	.concat("</div></li>")
	
	return menuHtml;

}

function obterHtmlMenuSecretaria() {

	var menuHtml = "".concat("<ul>")
	.concat("<li>")
	.concat("<a class='' href='javascript:void(0);'>Cadastros</a>")
	.concat("<div class='submenu'>")
	.concat("<ul>")
	.concat("<li><a href='javascript:void(0);'>Cliente</a></li>")
	.concat("<li><a href='javascript:void(0);'>Advogado</a></li>")
	.concat("<li><a href='javascript:void(0);'>Tipo de Honor�rio</a></li>")
	.concat("<li><a href='javascript:void(0);'>Tipo de Despesa</a></li>")
	.concat("<li><a href='javascript:void(0);'>Tipo de Causa</a></li>")
	.concat("<li><a href='javascript:void(0);'>F�runs</a></li>")
	.concat("<li><a href='javascript:void(0);'>Tipo de Cobran�a</a></li>")
	.concat("<li><a href='javascript:void(0);'>Taxas</a></li>")
	.concat("<li><a href='javascript:void(0);'>Valor/Hora</a></li>")
	.concat("<li><a href='./ListaClienteSetup'>Processo</a></li>")
	.concat("</ul>")
	.concat("</div>")
	.concat("</li>")
	.concat("<li>")
	.concat("<a class='' href='javascript:void(0);'>Financeiro</a>")
	.concat("<div class='submenu'>")
	.concat("<ul>")
	.concat("<li><a href='javascript:void(0);'>Lan�ar Depesas</a></li>")
	.concat("<li><a href='./CadastroHonorarioSetup'>Lan�ar Honor�rios</a></li>")
	.concat("<li><a href='./ListaTitulosProcessoSetup'>Registrar Pagamentos</a></li>")
	.concat("<li><a href='javascript:void(0);'>Controlar Pagamentos em Atraso</a></li>")
	.concat("</ul>")
	.concat("</div>")
	.concat("</li>")
	.concat("<li>")
	.concat("<a class='' href='javascript:void(0);'>Jur�dico</a>")
	.concat("<div class='submenu'>")
	.concat("<ul>")
	.concat("<li><a href='javascript:void(0);'>Agendar Audi�ncia</a></li>  ")
	.concat("</ul>")
	.concat("</div>")
	.concat("</li>")
	.concat("<li>")
	.concat("<a class='' href='javascript:void(0);'>Consulta</a>")
	.concat("<div class='submenu'>")
	.concat("<ul>")
	.concat("<li><a href='./ListaHonorarioSetup'>Listar Honor�rios</a></li>  ")
    .concat("<li><a href='./ListaClienteSetup'>Listar Clientes</a></li>  ")
	.concat("<li><a href='javascript:void(0);'>Consultar Processos</a></li>")
	.concat("</ul>")
	.concat("</div>")
	.concat("</li>")
	.concat("<li>")
	.concat("<a class='' href='javascript:void(0);'>Relat�rios</a>")
	.concat("<div class='submenu'>")
	.concat("<ul>")
	.concat("<li><a href=''>Processos</a>")
	.concat("</li>")
	.concat("<li><a href=''>Despesas</a>")
	.concat("</li>")
	.concat("<li><a href=''>Tarefas</a>")
	.concat("</li>")
	.concat("<li><a href=''>Receitas Anuais</a>")
	.concat("</li>")
	.concat("<li><a href=''>Pagamentos em Aberto</a>")
	.concat("</li>")
	.concat("<li><a href='./RelatorioAudienciaSetup'>Audi�ncias</a>")
	.concat("</li>")
	.concat("<li><a href='./RelatorioHonorarioSetup'>Honor�rios</a>")
	.concat("</li>")
	.concat("</ul>")
	.concat("</div>")
	.concat("</li>")
                
	return menuHtml;

}

function obterHtmlMensagem(objMensagem) {

	var modalHtml = ""
	.concat("<div class='modal'>")
	.concat("<div class='mensagem centralizado border " + objMensagem.tipo + "'>")
	.concat("<div class='titulo'>")
	.concat("<!-- <img src='' /> -->")
	.concat("<span>" + objMensagem.titulo + "</span>")
	.concat("</div>")
	.concat("<div class='corpo'>")
	.concat("<ul>");
	
	for (var i=0; i < objMensagem.itens.length; i++)
		modalHtml = modalHtml.concat("<li>" + objMensagem.itens[i] + "</li>");
	
	modalHtml = modalHtml.concat("</ul>")
	.concat("</div>")
	.concat("<div class='rodape'>")
	.concat("<input type='button' value='Ok' class='fecha-mensagem' />")
	.concat("</div>")
	.concat("</div>")
	.concat("</div>");
	
	return modalHtml;
	
}

/* VALIDA��O DE CAMPOS ***************************************************************************************************************************************/

function validaData(data) {
	
	var regExp = /^(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[012])\/((19|20)[0-9]{2})$/;
	
	return !regExp.test(data);
	
}

function validaLetrasENumeros(data) {
	
	var regExp = /^([a-zA-Z0-9])/;
	
	return !regExp.test(data);
	
}

function horasTrabalhadas(hora){
	
	return true; //!(hora >= 1 || hora <= 24);
	
}


