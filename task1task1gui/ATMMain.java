package task1task1gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ATMMain {
	
	private static final String URL="jdbc:mysql://localhost:3306/atm_simulation";
	private static final String USER="demostudent";
	private static final String PASSWORD="demostudent";
	
	private static Connection connection;
	
	
	
	public ATMMain() {
		
	}

	public static void main(String[] args) {  
		
		try {
			// loading JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// establishing a connection
			setConnection(DriverManager.getConnection(URL,USER,PASSWORD));
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
			
		Starting starting= new Starting();
		starting.startingFrame();
		
		
	}

	public static Connection getConnection() {
		return connection;
	}

	public static void setConnection(Connection connection) {
		ATMMain.connection = connection;
	}
	
	public static void insertCurrentBalance(int curr_balance,String tran) {
		String sql ="INSERT INTO debit_credit VALUES(?,?)";
		try(PreparedStatement preparedStatement=connection.prepareStatement(sql)){
			preparedStatement.setString(1,tran);
			preparedStatement.setInt(2,curr_balance);
			preparedStatement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static int fetchAccountBalance() {
		String sql="SELECT current_balance FROM debit_credit";
		int curr_balance = 0;
		try(PreparedStatement preparedStatement=connection.prepareStatement(sql)){
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				curr_balance=Integer.parseInt(resultSet.getString("current_balance"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return curr_balance;
	}
	
	public static void changePin(int num) {
		String sql="UPDATE pin_table SET pin_num=?";
		try(PreparedStatement preparedStatement=connection.prepareStatement(sql)){
			String temp=String.valueOf(num);
			preparedStatement.setString(1, temp);
			preparedStatement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static int fetchPin() {
		String sql="SELECT pin_num FROM pin_table";
		int pin_num = 0;
		try(PreparedStatement preparedStatement=connection.prepareStatement(sql)){
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				pin_num=Integer.parseInt(resultSet.getString("pin_num"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return pin_num;
	}

	public static void insertTransaction(String tran) {
		String sql="INSERT INTO transaction_history_table VALUES(?)";
		try(PreparedStatement preparedStatement=connection.prepareStatement(sql)){
			preparedStatement.setString(1,tran);
			preparedStatement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static String fetchTransaction() {
		StringBuilder trans=new StringBuilder();
		String sql="SELECT hist FROM transaction_history_table";
		try(PreparedStatement preparedStatement=connection.prepareStatement(sql)){
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				String his=resultSet.getString("hist");
				trans.append(his).append("\n");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return trans.toString();
	}
}
