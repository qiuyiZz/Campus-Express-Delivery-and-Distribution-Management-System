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
	// 创建三个接口的对象
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	// 创建包含用户名和密码的Login对象
	public Login(String userName, String userPwd) {
		this.userName = userName;
		this.userPwd = userPwd;
	}
	
	// 创建包含用户名和密码的Login对象
	public static Login loginCheck(String userName,String userPwd,String type) {
		Login su = new Login("USER_PWD", "1234userpwd");
		su.login();
		switch(type) {
		case "user":
			ArrayList<ArrayList> ru = su.select("users","userPwd", "userID="+userName+" and userPwd="+userPwd);
			//即使查询结果为空，ru也不是null，需要用isEmpty()判断
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

	// 执行登录和连接数据库操作
	public void login() {
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbURL = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Delivery";

		try {
			Class.forName(driverName);
			System.out.println("加载驱动成功！");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("加载驱动失败！");
		}
		try {
			connection = DriverManager.getConnection(dbURL, userName, userPwd);
			System.out.println("连接数据库成功！");
			System.out.println("\nID: " + userName + "\nwelcome!\n");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("SQL Server连接失败！");
		}
	}

	// table是表名，cols是需要选取的列名（全选为*），con是查询条件,无查询条件则输入null
	// 例：su.select("users","*",null) su.select(("users","*","userID=13120498011"))
	public ArrayList<ArrayList> select(String table, String cols, String con) {
		String command = "";
		command = "select " + cols + " from " + table;
		if (con != null)
			command += " where " + con;
		System.out.println(command);
		ArrayList<ArrayList> result = Methods.select(connection, command);
		return result;
	}

	// 插入新的一行，可选的属性可用null代替，每个属性值之间用逗号','分隔，非数字或datetime的属性值须用单引号''包裹
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

	// 更新记录中某属性的值，可以用来给null属性赋值，attrs和con的格式为：属性名=属性值，其中attrs是更新的值，con是锁定记录的条件
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

	// 删除某条记录，con的格式为：属性名=属性值
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

	// 更改列名，暂时应该用不到
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
