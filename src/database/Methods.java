package database;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;

public class Methods {
	// 获取列名
	public static String[] getCols(Connection connection, String table) {
		String s = "select * from " + table;
		try {
			PreparedStatement pre = connection.prepareStatement(s);
			ResultSet resultSet = pre.executeQuery();
			ResultSetMetaData data;
			if (resultSet != null)
				data = resultSet.getMetaData();
			else {
				data = null;
			}
			int l = data.getColumnCount();
			String[] cols = new String[l];
			for (int i = 0; i < l; i++)
				cols[i] = data.getColumnLabel(i + 1);
			return cols;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// 对数据库进行查询操作
	public static ArrayList<ArrayList> select(Connection connection, String s) {
		ArrayList result = new ArrayList<ArrayList>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(s);
			// 一般是select操作 executeUpdate更新删除操作
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet != null) {
				ResultSetMetaData countCo = resultSet.getMetaData();
				ArrayList cols = new ArrayList<>();
				for (int i = 1; i <= countCo.getColumnCount(); i++) {
					cols.add(countCo.getColumnLabel(i));
				}
				// 列名标题行
				//result.add(cols);
				// 将查询结果输出成二维数组的形式
				while (resultSet.next()) {
					ArrayList temp = new ArrayList<>();
					for (int i = 1; i <= countCo.getColumnCount(); i++) {
						temp.add(resultSet.getString(countCo.getColumnLabel(i)));
					}
					result.add(temp);
				}
				System.out.println("successful selection!");
				return result;
			} else {
				System.out.println("no result");
				return null;
			}

		} catch (SQLException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
		return null;
	}

	// 对数据库的增删改
	public static void updates(Connection connection, String s) throws ParseException {
		try {
			Statement stm = connection.createStatement();
			stm.executeUpdate(s);
			System.out.println("successful execution!");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
