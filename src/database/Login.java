package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;

public class Login {
	private String userName;
	private String userPwd;
	// ���������ӿڵĶ���
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	// ���������û����������Login����
	public Login(String userName, String userPwd) {
		this.userName = userName;
		this.userPwd = userPwd;
	}
	
	// ���������û����������Login����
	public static Login loginCheck(String userName,String userPwd,String type) {
		Login su = new Login("USER_PWD", "1234userpwd");
		su.login();
		switch(type) {
		case "user":
			ArrayList<ArrayList> ru = su.select("users","userPwd", "userID="+userName+" and userPwd="+userPwd);
			//��ʹ��ѯ���Ϊ�գ�ruҲ����null����Ҫ��isEmpty()�ж�
			if(ru.isEmpty()) {
				System.out.println("wrong userID or wrong password");
				return null;
			}
			else {
				Login user=new Login("Users", "1234users");
				return user;
			}
		case "staff":
			ArrayList<ArrayList> rs = su.select("staff","*", "staffID="+userName+" and staffPwd="+userPwd);
			if(rs.isEmpty()) {
				System.out.println("wrong staffID or wrong password");
				return null;
			}
			else {
				Login staff=new Login("Staff", "1234staff");
				return staff;
			}
		default:
			System.out.println("wrong login type");
			return null;
		}
		
		
	}

	// ִ�е�¼���������ݿ����
	public void login() {
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbURL = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Delivery";

		try {
			Class.forName(driverName);
			System.out.println("���������ɹ���");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("��������ʧ�ܣ�");
		}
		try {
			connection = DriverManager.getConnection(dbURL, userName, userPwd);
			System.out.println("�������ݿ�ɹ���");
			System.out.println("\nID: " + userName + "\nwelcome!\n");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("SQL Server����ʧ�ܣ�");
		}
	}

	// table�Ǳ�����cols����Ҫѡȡ��������ȫѡΪ*����con�ǲ�ѯ����,�޲�ѯ����������null
	// ����su.select("users","*",null) su.select(("users","*","userID=13120498011"))
	public ArrayList<ArrayList> select(String table, String cols, String con) {
		String command = "";
		command = "select " + cols + " from " + table;
		if (con != null)
			command += " where " + con;
		System.out.println(command);
		ArrayList<ArrayList> result = Methods.select(connection, command);
		return result;
	}

	// �����µ�һ�У���ѡ�����Կ���null���棬ÿ������ֵ֮���ö���','�ָ��������ֻ�datetime������ֵ���õ�����''����
	public void insert(String table, String attrs) {
		String command = "insert into " + table + " values(" + attrs + ");";
		System.out.println(command);
		try {
			Methods.updates(connection, command);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ���¼�¼��ĳ���Ե�ֵ������������null���Ը�ֵ��attrs��con�ĸ�ʽΪ��������=����ֵ������attrs�Ǹ��µ�ֵ��con��������¼������
	public void update(String table, String attrs, String con) {
		String command = "update " + table + " set " + attrs;
		if (con != null)
			command += " where " + con;
		System.out.println(command);
		try {
			Methods.updates(connection, command);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ɾ��ĳ����¼��con�ĸ�ʽΪ��������=����ֵ
	public void delete(String table, String con) {
		String command = "delete from " + table + " where " + con;
		System.out.println(command);
		try {
			Methods.updates(connection, command);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ������������ʱӦ���ò���
	public void alter(String table, String con) {
		String command = "alter " + table + " " + con;
		System.out.println(command);
		try {
			Methods.updates(connection, command);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
