package database;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;

public class Methods {
	// ��ȡ����
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

	// �����ݿ���в�ѯ����
	public static ArrayList<ArrayList> select(Connection connection, String s) {
		ArrayList result = new ArrayList<ArrayList>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(s);
			// һ����select���� executeUpdate����ɾ������
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet != null) {
				ResultSetMetaData countCo = resultSet.getMetaData();
				ArrayList cols = new ArrayList<>();
				for (int i = 1; i <= countCo.getColumnCount(); i++) {
					cols.add(countCo.getColumnLabel(i));
				}
				// ����������
				//result.add(cols);
				// ����ѯ�������ɶ�ά�������ʽ
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

	// �����ݿ����ɾ��
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
