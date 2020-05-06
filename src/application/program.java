package application;

import java.util.*;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.*;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;
import db.DbException;
import interfaces.tela_inicio;

public class program {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		
		
		
		
		boolean criacao=false;//declara que o banco de dados não foi criado e está sendo criado pela primeira vez
		
		try {
			Connection conn = null;//declara a conexão como nula, não me pergunte pra que!
			conn = DB.getConnectionExist();//estabelece conexão com o MYSQL
		Statement s = conn.createStatement();//tranfere a criação de comandos de MYSQL para s
		s.executeUpdate("CREATE DATABASE banco_de_jogos");//cria o banco de dados banco_de_jogos
		s.executeUpdate("CREATE TABLE `banco_de_jogos`.`jogos` ("
				  +"`ID` INT NOT NULL AUTO_INCREMENT,"
				  +"`Nome` VARCHAR(45) NOT NULL,"
				  +"`Nome_jogo` VARCHAR(45) NOT NULL,"
				  +"`Data` VARCHAR(45) NOT NULL,"
				  +"PRIMARY KEY (`ID`))");  
		s.executeUpdate("USE banco_de_jogos");//executa a database para usar como padrão
		s.close();//encerra s
		criacao=true;//retorna o valor como banco de dados criado
		}catch(SQLException e){
			
			Connection conn = null;//declara a conexão como nula, não me pergunte pra que!
			conn = DB.getConnection();//estabelece conexão com o MYSQL
			Statement s = conn.createStatement(); //tranfere a criação de comandos de MYSQL para s
			s.executeUpdate("USE banco_de_jogos");//executa a database para usar como padrão
			s.close();//encerra s
			
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						tela_inicio frame = new tela_inicio();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		if(criacao==true) {//verifica se o banco de dados já foi criado, caso sim ele executa a primeira tela da interface
			
			
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tela_inicio frame = new tela_inicio();//inicia a primeira tela
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		}
		/*
		Connection conn = null;
		conn = DB.getConnection();
		try {
		Statement s = conn.createStatement();
		s.executeUpdate("CREATE DATABASE novoDb");
		s.close();
		}catch(SQLException e){
			throw new DbException(e.getMessage());
		}
		*/
	}
	public static void conectar_ao_banco() {//estabelece conexão com o banco de dados
		Connection conn = DB.getConnection();
		
	}
	public static void desconectar_do_banco() {//encerra a conexão com o banco de dados
		DB.closeConnection();
	}
	public static void recuperar_dados() {//resgata os dados do BD e os mostra na ordem dita
		
		
		Connection conn = null; //conectar
		Statement st = null; //buscar os departamentos do banco de dados
		ResultSet rs = null; //resultado da consulta
		try {
			conn = DB.getConnection(); 
			st = conn.createStatement(); 
			rs= st.executeQuery("Select * from jogos");
			while(rs.next()) {
				System.out.println(rs.getInt("ID")+" | "+rs.getString("Nome")+" | "+rs.getString("Nome_jogo")+" | "+rs.getString("Data"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatemant(st);
			DB.closeConnection();
		}

		
		
		
	}
	
	public static void inserir_dados(String Nome,String Nome_jogo) {//insere novos dados ao BD
		
		Date data = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("H:m d/M/y");
		String dataformatada = formatar.format(data);
		Connection conn = null;
		PreparedStatement st = null;
		
		
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement(
					"INSERT INTO jogos"
					+"(Nome,Nome_jogo,Data)"
					+"VALUES"
					+"(?,?,?)");
			 
			st.setString(1,  Nome );
			st.setString(2, Nome_jogo);
			st.setNString(3, dataformatada);
			
			st.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void atualizar_dados_nome(String Nome,int Id) {
		Date data = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("H:m d/M/y");
		String dataformatada = formatar.format(data);
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement(
					"UPDATE jogos "
					+"SET Nome = ? , Data = ? "
					+"WHERE "
					+ "ID = ? ");
			st.setString(1, Nome);
			st.setString(2, dataformatada);
			st.setInt(3,Id);	
			st.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void atualizar_dados_jogo(String Jogo,int Id) {
	

		Date data = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("H:m d/M/y");
		String dataformatada = formatar.format(data);
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement(
					"UPDATE jogos "
					+"SET Nome_jogo = ? , Data = ? "
					+"WHERE ID = ? ");
			
			st.setString(1, Jogo);
			st.setString(2, dataformatada);
			st.setInt(3,Id);
			
			st.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	
	
		
		
	}
	
	public static void deletar_dados(String Id) {
	

		int ID = Integer.parseInt(Id);
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement(
					"DELETE FROM jogos "
					+ "WHERE "
					+ "ID = ? "
					);
			st.setInt(1, ID);
			st.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	
	}


	

}
