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
	
		//role��Ϊuser��Ա���ľ���ְλ������Ա���ռ�Ա������Ա���ɼ�Ա��
		public static Login Register(Login defaultsu,String userID,String username,String userPwd,String role) throws ParseException {
		//ע��,�����û����ͷ��ض�Ӧ�����ݿ�login����
			if(role.equals("user")) {
				defaultsu.insert("users",userID+",'"+username+"','"+userPwd+"','����ƾ���ѧɳ��У��'");
				Login su = Login.loginCheck(userID,userPwd,role);
				su.login();
				ReceivingProcess.InputTimeTable(su, userID, timeTable);
				ReceivingProcess.ApplyForDelay(su, userID, "1990-01-01", "1990-01-01");
				System.out.print("�û�ע��ɹ���");
				return su;
			}
			else {
				defaultsu.insert("staff",userID+",'"+username+"','"+role+"','"+userPwd+"'");
				Login ss = Login.loginCheck(userID,userPwd,"staff");
				ss.login();
				System.out.print("Ա��ע��ɹ���");
				return ss;
			}
		}
		
		public static String UserLogin(Login su,String userID,String role) {
		//�û���¼,�й��ж�����ڶ�Ӧservlet���Ѿ�д��,�˴����������빩�ȶ�
			
			if(role.equals("�û�")) {
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
