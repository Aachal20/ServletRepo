package com.nt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.nt.model.User;

public class UserDAO {
	private static final String INSERT_USERS= "INSERT INTO USERS VALUES (USER_SEQ.NEXTVAL,?,?,?)";
	private static final String SELECT_USERS_BY_ID= "SELECT *  FROM  USERS WHERE ID=?";
	private static final String SELECT_ALL_USERS= "SELECT *  FROM  USERS";
	private static final String DELETE_USERS= "DELETE  FROM USERS WHERE ID=?";
	private static final String UPDATE_USERS= "UPDATE USERS SET NAME=?,EMAIL=?,COUNTRY=? WHERE ID=?";
	public UserDAO() {
	}

	/*
	 * protected Connection getPooledConnection() throws Exception { //create
	 * initialContext obj to establsih the connection with jndi registry
	 * InitialContext ic =new InitialContext(); DataSource ds=
	 * (DataSource)ic.lookup("java:/comp/env/DsJndi"); //only for tomcat //get
	 * pooled jdbc connection object Connection con =ds.getConnection(); return con;
	 * }
	 */
	protected Connection getPooledConnection() {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" ,"system" ,"manager");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void insertUser(User user) throws Exception {
		System.out.println(INSERT_USERS);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getPooledConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS)) {
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getCountry());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
//select user by ID
	public User selectUser(int id) throws Exception {
		User user = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getPooledConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERS_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				user = new User(id, name, email, country);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}

	public List<User> selectAllUsers() throws Exception {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<User> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getPooledConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				users.add(new User(id, name, email, country));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}

	public boolean deleteUser(int id) throws Exception {
		boolean rowDeleted;
		try (Connection connection = getPooledConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateUser(User user) throws Exception {
		boolean rowUpdated;
		try (Connection connection = getPooledConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS);) {
			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getCountry());
			statement.setInt(4, user.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}