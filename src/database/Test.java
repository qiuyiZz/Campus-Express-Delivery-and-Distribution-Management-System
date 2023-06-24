package database;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import post.Post;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
		String submissionTime = formatter1.format(now);
		String Now = formatter2.format(now);
		ArrayList<Post> a= new ArrayList<Post>(); 
		try {
			Date Nowaday = formatter2.parse(Now);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(submissionTime);
		//System.out.println(Nowaday);
		Login su = Login.loginCheck("13120498011", "5678", "user");
		su.login();
		ArrayList<ArrayList> r = su.select("users","*", "userID=13120498011");
		/*
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
		*/
		for (int i = 0; i < r.size(); i++) {
			for (int j = 0; j < (r.get(i)).size(); j++)
				System.out.print(r.get(i).get(j) + "\t");
			System.out.println();
		}
		
	}

}
