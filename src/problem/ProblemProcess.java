package problem;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;

import database.Login;

public class ProblemProcess {
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Login su = new Login("superuser", "1234567");
		su.login();
		
		//定期检查取件表，添加问题件
		//schedule(任务，首次执行时间，执行周期）
		Timer timer1=new Timer();
		Timer_CheckReceived checkR=new Timer_CheckReceived();
		timer1.scheduleAtFixedRate(checkR, Calendar.getInstance().getTime(), 1000*60*60*2);//每次检查后2小时再次更新
		
		//转入滞留区，更新快件状态：已滞留
		Scanner input = new Scanner(System.in);
		System.out.println("输入快递单号：");
		String expressNumber=input.nextLine();
		System.out.println("确认快件转入滞留区（输入1）：");
		String check=input.nextLine();
		if(check.equals("1")) {
			setStatus(su,expressNumber,"已滞留");
		}
		else {
			System.out.println("错误！重新输入");
		}
		
		//发送信息
		System.out.println("输入快递单号：");
		expressNumber=input.nextLine();
		System.out.println("确认发送滞留件信息（输入2）：");
		check=input.nextLine();
		if(check.equals("2")) {
			sendMessage(su,expressNumber);
		}
		else {
			System.out.println("错误！重新输入");
		}
		
		//定期检查24小时内未取件
		Timer timer2=new Timer();
		Timer_CheckProblem checkP=new Timer_CheckProblem();
		timer2.scheduleAtFixedRate(checkP, Calendar.getInstance().getTime(), 1000*60*60*2);//每次检查后2小时再次更新
		
		//员工完成快件退还
		System.out.println("输入快递单号：");
		expressNumber=input.nextLine();
		System.out.println("确认退还快件（输入3）：");
		check=input.nextLine();
		if(check.equals("3")) {
			setExit(su,expressNumber,"退件");
			setStatus(su,expressNumber,"成功退件");
		}
		else {
			System.out.println("错误！重新输入");
		}
	}

	public Problem CreateProblemParcel() {
		return new Problem();
	}
	
	public static Problem CreateProblemParcel(Login su,String expressNumber,String expressCompany,String recipientTel,String recipientName,Double weight,String size) throws ParseException {
		String retentionCode=getRandomCode(6);//随机生成6位滞留取件码
		
		//创建对象
		Problem problem=new Problem(expressNumber,expressCompany,recipientTel,recipientName,weight,size,retentionCode,"待滞留");
		
		//存入数据库
		String attr1="status='待滞留'";
		String con1="expressNumber='"+expressNumber+"'";
		String attr2="'"+expressNumber+"','"+recipientTel+"','2050-01-01 00:00:00','未退出','2050-01-01 00:00:00','"+retentionCode+"'";
		su.update("express", attr1,con1);
		su.insert("problem", attr2);
		su.update("report","problemQuantity=problemQuantity+1","dateID=convert(char(10),getdate(),120)");//更新每日报告签收数量
		System.out.println("每日报告已更新");
		//System.out.println("已添加新的问题件！");
		
		return problem;
	}
	
	//由数据库字段查询结果创建新对象
	public static Problem GetProblemParcel(Login su,String expressNumber) throws ParseException {
		String attrs="express.expressNumber,express.recipientTel,expressCompany,recipientName,weight,size,status,retentionReminderTime,exitWay,exitTime,retentionCode";
		String con="express.expressNumber='"+expressNumber+"' and express.expressNumber=problem.expressNumber and dispatch.expressNumber=problem.expressNumber";
		ArrayList<ArrayList> r = su.select("express,problem,dispatch",attrs, con);
			
		//查询结果唯一
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String recipientTel= (String) r.get(0).get(1);
		String expressCompany = (String) r.get(0).get(2);
		String recipientName= (String) r.get(0).get(3); 
		Double weight= Double.parseDouble((String) r.get(0).get(4));
		String size= (String) r.get(0).get(5);
		String status= (String) r.get(0).get(6);
		Date retentionReminderTime= sdf.parse((String) r.get(0).get(7));
		String exitWay= (String) r.get(0).get(8);
		Date exitTime= sdf.parse((String) r.get(0).get(9));
		String retentionCode= (String) r.get(0).get(10);
			
		Problem problem=new Problem(expressNumber,expressCompany,recipientTel,recipientName,weight,size,status,	retentionReminderTime,exitWay,exitTime,retentionCode);	
		return problem;
	}
		
	//生成6位滞留取件码
	private static String getRandomCode(int length) {
		Random random = new Random();  
        StringBuffer valSb = new StringBuffer();  
        String charStr = "0123456789abcdefghijklmnopqrstuvwxyz";  
        int charLength = charStr.length();  
 
        for (int i = 0; i < length; i++) {  
            int index = random.nextInt(charLength);  
            valSb.append(charStr.charAt(index));  
        }  
        return valSb.toString();  
	}

	public static void setStatus(Login su,String expressNumber,String status) {
		//新建对象
		//Problem problem = GetProblemParcel(su,expressNumber);
		//problem.SetStatus(status);
		
		//Date day=new Date();    
		//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		
		//存入数据库
		String attrs="status='"+status+"'";
		String con="expressNumber='"+expressNumber+"'";
		su.update("express", attrs, con);
		
		//System.out.println("问题件状态已更新为："+status);
	}
	
	public static void setExit(Login su,String expressNumber,String exitWay) {
		//存入数据库
		String attrs="exitWay='"+exitWay+"',exitTime=getdate()";
		String con="expressNumber='"+expressNumber+"'";
		su.update("problem", attrs, con);

	}
	
	//发送滞留提醒
	public static void sendMessage(Login su,String expressNumber) throws ParseException {
		//新建对象
		Problem problem = GetProblemParcel(su,expressNumber);
		String recipientTel=problem.GetRecipientTel();
		String retentionCode=problem.GetRetentionCode();
		System.out.println("滞留件提醒短信已发送给："+recipientTel+"\t快递单号："+expressNumber+"\t取件码："+retentionCode);
		
		//滞留提醒时间
		//Date day=new Date();    
		//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		//String retentionReminderTime=df.format(day);
		//problem.SetRetentionReminderTime(df.parse(retentionReminderTime));
		
		//存入数据库：滞留提醒时间
		String attrs="retentionReminderTime=getdate()";
		String con="expressNumber='"+expressNumber+"'";
		su.update("problem", attrs, con);   
		
	}
	
}
