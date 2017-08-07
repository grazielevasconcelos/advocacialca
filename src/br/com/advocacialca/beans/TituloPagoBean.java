package br.com.advocacialca.beans;

import java.io.Serializable;
import java.util.Calendar;

	/**
	 * Classe de um titulo pago
	 * @author Pixel
	 */

public class TituloPagoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public TituloPagoBean(){}
	
	private TituloBean titulo;
	private Calendar dtPagamento;
    private double vlPago;

    
    /**
	 *  Método para retorno de um título
	 *  @param titulo Código do título
	 *  @return titulo Retorna o título
	 */
	
	public TituloBean getTitulo() {
		return titulo;
	}
	public void setTitulo(TituloBean titulo) {
		this.titulo = titulo;
	}
	
	/**
	 *  Método para retorno da data do pagamento
	 *  @param dtPagamento Data do pagamento
	 *  @return dtPagamento Retorna a data do pagamento 
	 */
	
	public Calendar getDtPagamento() {
		return dtPagamento;
	}
	public void setDtPagamento(Calendar dtPagamento) {
		this.dtPagamento = dtPagamento;
	}
	
	/**
	 *  Método para retorno do valor pago
	 *  @param vlPago Valor pago
	 *  @return vlPago Retorna o valor pago
	 */
	
	public double getVlPago() {
		return vlPago;
	}
	public void setVlPago(double vlPago) {
		this.vlPago = vlPago;
	}
	
}
