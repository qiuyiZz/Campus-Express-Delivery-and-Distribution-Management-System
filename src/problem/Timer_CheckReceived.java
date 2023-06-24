package problem;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.TimerTask;

import database.Login;

public class Timer_CheckReceived extends TimerTask{

	@Override
	public void run() {//检查取件表，提取问题件（超过48小时未取件）
		// TODO Auto-generated method stub
		Login su = new Login("superuser", "1234567");
		su.login();
		
		//SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//long now = df2.parse(time).getTime();
		
		String attrs="express.expressNumber,express.recipientTel,expressCompany,recipientName,weight,size,location";
		String con="status='已派送' and actualDelivery<getdate()-2";//实际派件时间距当前时间大于48小时
		ArrayList<ArrayList> r=su.select("express inner join dispatch on express.expressNumber=dispatch.expressNumber", attrs, con);
		
		for (int i = 0; i < r.size(); i++) {
			
			String expressNumber=r.get(i).get(0).toString().trim();
			String recipientTel= r.get(i).get(1).toString().trim();
			String expressCompany=r.get(i).get(2).toString().trim(); 
			String recipientName=r.get(i).get(3).toString().trim(); 
			Double weight=Double.parseDouble((String) r.get(i).get(4));
			String size= r.get(i).get(5).toString().trim();
			String location= r.get(i).get(6).toString().trim();
				
			try {
				Problem problem=ProblemProcess.CreateProblemParcel(su,expressNumber,expressCompany,recipientTel,recipientName,weight,size);
				//转移问题件
				if(location.contains("区"))
				{
					su.update("cabinet","headroom=headroom+1","size='"+size+"'");
					su.update("cabinet_details","isFull=0","cabinetID='"+location+"'");
				}
				else
					su.update("shlef","expressNum=expressNum-1","shelfID='"+location+"'");
				
				su.update("report","dateID=getdate()","problemQuantity=problemQuantity+1");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}

}
