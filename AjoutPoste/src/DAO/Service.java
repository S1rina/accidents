package DAO;


import java.sql.*;

public class Service {
	Connection con ;
	Statement stmt ;
	public Statement connect(){
		
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			 System.out.println("connexion en cours 1 !!!") ;             
			 con= DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_des_accidents","root","");
			 System.out.println("connexion en cours 2 !!!") ;   
			  stmt= con.createStatement();
		
                              
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
		return stmt;
		
}

}
