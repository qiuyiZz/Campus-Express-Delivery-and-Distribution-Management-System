package database;
import java.text.ParseException;
import java.util.ArrayList;

import dispatch.ReceivingProcess;

public class Register_Login {
	public static int[][] timeTable= {{1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1}};
	public static void main(String[] args) throws ParseException {
		
		Login defaultsu = new Login("USER_PWD","1234userpwd");
		defaultsu.login();
		
		Register(defaultsu,"13120498002","abc","12345","user");
		}
	
		//role分为user和员工的具体职位（管理员、收件员、发件员、派件员）
		public static Login Register(Login defaultsu,String userID,String username,String userPwd,String role) throws ParseException {
		//注册,根据用户类型返回对应的数据库login对象
			if(role.equals("user")) {
				defaultsu.insert("users",userID+",'"+username+"','"+userPwd+"','中央财经大学沙河校区'");
				Login su = Login.loginCheck(userID,userPwd,role);
				su.login();
				ReceivingProcess.InputTimeTable(su, userID, timeTable);
				ReceivingProcess.ApplyForDelay(su, userID, "1990-01-01", "1990-01-01");
				System.out.print("用户注册成功！");
				return su;
			}
			else {
				defaultsu.insert("staff",userID+",'"+username+"','"+role+"','"+userPwd+"'");
				Login ss = Login.loginCheck(userID,userPwd,"staff");
				ss.login();
				System.out.print("员工注册成功！");
				return ss;
			}
		}
		
		public static String UserLogin(Login su,String userID,String role) {
		//用户登录,有关判断语句在对应servlet中已经写好,此处仅返回密码供比对
			
			if(role.equals("用户")) {
				ArrayList<ArrayList> userInfo = su.select("users","*","userID="+userID);
				String UserPwd;
				if(!userInfo.isEmpty())
					UserPwd = userInfo.get(0).get(2).toString().trim();
				else
					UserPwd=null;
				return UserPwd;
			}
			else {
				ArrayList<ArrayList> staffInfo = su.select("staff","*","staffID="+userID);
				String StaffPwd;
				if(!staffInfo.isEmpty())
					StaffPwd = staffInfo.get(0).get(3).toString().trim();
				else StaffPwd=null;
				return StaffPwd;
			}
		}
		
		
}
