package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.*;
import java.util.Properties;

public class DB {

	private static Connection conn = null;
	
	public static Connection getConnection() { //metodo para iniciar conexão com banco de dados
		if(conn==null) {
			
			try {
				Properties props = loadProperties(); //carregando o metodo Load properties
				String url = props.getProperty("dburl"); // verificar o caminho do banco de usando o marcador dburl
				conn = DriverManager.getConnection(url,props);
			}catch(SQLException e){
				throw new DbException(e.getMessage());//executa metodo de exeption para evitar que o codigo trave
			}
		}
		return conn;
	}
	
	public static Connection getConnectionExist() { //metodo para iniciar conexão com banco de dados
		if(conn==null) {
			try {
				Properties props = loadPropertiesNew();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url,props);
			}catch(SQLException e){
				throw new DbException(e.getMessage());//executa metodo de exeption para evitar que o codigo trave
			}
		}
		return conn;
	}
	
	public static void closeConnection() { // metodo para fechar uma conexão com o banco de dados
		if(conn != null) {
			try {
			conn.close();
			}catch(SQLException e){
				throw new DbException(e.getMessage());//executa metodo de exeption para evitar que o codigo trave
			}
		}
	}
	
	private static Properties loadProperties(){//metodo para pegar dados do arquivo texto db.properties
		try (FileInputStream fs = new FileInputStream ("db.properties")){//acessa o arquivo texto
			Properties props = new Properties();
			props.load(fs);
			return props;
		}
		catch (IOException e) {
			throw new DbException(e.getMessage());//executa metodo de exeption para evitar que o codigo trave
		}
	}
	
	private static Properties loadPropertiesNew(){//metodo para pegar dados do arquivo texto db.propertiesNew
		try (FileInputStream fs = new FileInputStream ("db.propertiesNew")){ //acessa o arquivo texto
			Properties props = new Properties(); // transfere o acesso para props
			props.load(fs); // carrega os dados
			return props; // retorna o valor
		}
		catch (IOException e) {
			throw new DbException(e.getMessage());//executa metodo de exeption para evitar que o codigo trave
		}
	}
	
	public static void closeStatemant(Statement st) {
		if(st!=null) {
			try {
				st.close();
			}catch(SQLException e) {
				throw new DbException(e.getMessage());//executa metodo de exeption para evitar que o codigo trave
			}
		}
	}
	public static void closeResultSet(ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			}catch(SQLException e) {
				throw new DbException(e.getMessage());//executa metodo de exeption para evitar que o codigo trave
			}
		}
	}
}
