package problem;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.TimerTask;

import database.Login;

public class Timer_CheckReceived extends TimerTask{

	@Override
	public void run() {//���ȡ������ȡ�����������48Сʱδȡ����
		// TODO Auto-generated method stub
		Login su = new Login("superuser", "1234567");
		su.login();
		
		//SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//long now = df2.parse(time).getTime();
		
		String attrs="express.expressNumber,express.recipientTel,expressCompany,recipientName,weight,size,location";
		String con="status='������' and actualDelivery<getdate()-2";//ʵ���ɼ�ʱ��൱ǰʱ�����48Сʱ
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
				//ת�������
				if(location.contains("��"))
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
