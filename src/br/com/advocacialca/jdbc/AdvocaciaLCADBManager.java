package br.com.advocacialca.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class AdvocaciaLCADBManager {

	public static Connection obterConexao() throws Exception {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		return DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL","OPS$RM","");
		
	}
	
	//Banco Hendrik
	//return DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL","OPS$RM68294","291187");
}
