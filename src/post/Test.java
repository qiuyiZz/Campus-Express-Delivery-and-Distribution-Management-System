package post;


import java.text.SimpleDateFormat;
import java.util.ArrayList;

import database.Login;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Login su = new Login("superuser", "1234567");
		su.login();
		su.delete("users", "userID=13120498011");
		su.insert("users", "13120498011,\'你好\',1234");
		su.update("users", "userPwd=5678", "userID=13120498011");

		// SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// System.out.println(df.format(System.currentTimeMillis()));
		// 向数据库中加入datetime类型的内容需要使用getdate()函数
		//
		su.delete("dispatch", "recipientTel=13120498011");
		su.insert("dispatch", "1111,13120498011,\'你好\',getdate(),\'自提柜\',null,null,null,null,null");
		su.update("dispatch", "remindTime=getdate()", "recipientTel=13120498011");

		ArrayList<ArrayList> r = su.select("dispatch", "*", "recipientTel=13120498011");
		for (int i = 0; i < r.size(); i++) {
			for (int j = 0; j < (r.get(i)).size(); j++)
				System.out.print(r.get(i).get(j) + "\t");
			System.out.println();
		}
	}

}
