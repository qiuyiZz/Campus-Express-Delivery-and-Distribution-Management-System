package problem;
import java.util.ArrayList;
import java.util.TimerTask;

import database.Login;

public class Timer_CheckProblem extends TimerTask{

	@Override
	public void run() {//检查问题件，24小时内是否取件
		// TODO Auto-generated method stub
		Login su = new Login("superuser", "1234567");
		su.login();
		
		//24小时仍未取件，发送消息，设为待退件
		String attrs1="express.expressNumber,express.recipientTel";
		String con1="status='已滞留' and retentionReminderTime<getdate()-1";//滞留提醒时间距当前时间大于24小时
		ArrayList<ArrayList> r1=su.select("express inner join problem on express.expressNumber=problem.expressNumber", attrs1, con1);
		for (int i = 0; i < r1.size(); i++) {
			String expressNumber=(String) r1.get(i).get(0);
			String recipientTel=(String) r1.get(i).get(1);
			
			LastMessage(expressNumber,recipientTel);//发送短信
			ProblemProcess.setStatus(su, expressNumber, "待退件");
		}
		
		//24小时内已取件，设置退出方式
		String attrs2="express.expressNumber";
		String con2="status='已取件' and express.expressNumber=problem.expressNumber";//问题件已取件
		ArrayList<ArrayList> r2=su.select("express inner join problem on express.expressNumber=problem.expressNumber", attrs2, con2);
		for (int i = 0; i < r2.size(); i++) {
			String expressNumber=(String) r2.get(i).get(0);
			
			//设置退出系统方式，时间
			ProblemProcess.setExit(su, expressNumber, "取件");
		}	
	}
	
	public void LastMessage(String expressNumber,String recipientTel) {
		System.out.println("滞留件未取提醒短信已发送给："+recipientTel+"\t快递单号："+expressNumber);
	}

}
