package model;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnector {
	
	private static DBConnector instance = new DBConnector();
	
	private DBConnector() {}
	
	public static DBConnector getInstance() {
		if(instance == null) {
			synchronized (DBConnector.class) {
				instance = new DBConnector();				
			}
		}
		return instance;
	}
	
	public Connection getConnection() throws NamingException, SQLException {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/mvcBoard");
		return ds.getConnection();
	}
}
