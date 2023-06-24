package dispatch;
import java.util.Date;

import database.Login;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ReceivingProcess {

	public static void main(String[] args) {
	
	Login su = new Login("superuser", "1234567");
	su.login();
	//�������ݿ����
	
				
	}
	
	public static Received ExpressReceipt(Login su,String expressNumber,String expressCompany,String recipientTel,
			String recipientName,Double weight,String size,String status) throws ParseException //ǩ��¼��
	{	
		//�����и��ӣ���дYYYY�Ὣ��ݰ��ܸ�ʽ����DD�Ὣ���ڱ�Ϊ��һ��������������ǵ���
		SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
		String submissionTime = formatter1.format(now);
		String Now = formatter2.format(now);
		Date Nowaday = formatter2.parse(Now);
		Received DisPatch = new Received(expressNumber,expressCompany,recipientTel,recipientName,weight,size);
		DisPatch.Setstatus("��ǩ��");
		DisPatch.SetsubmissionTime(submissionTime);
		String attr_express = "'"+expressNumber+"','"+recipientTel+"','"+expressCompany+"','"+
				weight+"','"+size+"','"+DisPatch.Getstatus()+"'";
		String attr_dispatch = "'"+expressNumber+"','"+recipientTel+"','"+recipientName+
				"',getdate(),null,'2050-01-01 00:00:00','2050-01-01 00:00:00','"
					+ "2050-01-01 00:00:00','-','-'";
		su.insert("express",attr_express);
		su.insert("dispatch",attr_dispatch);
		System.out.println("�����¼�룡");
		su.update("report","signedQuantity=signedQuantity+1","dateID=convert(char(10),getdate(),120)");//����ÿ�ձ���ǩ������
		System.out.println("ÿ�ձ����Ѹ���");
		
		return DisPatch;
	}
	
	//�����ɼ���ʽ
	public static String AssignDeliveryMethod(Login su,String expressNumber,String recipientTel) //�����ɼ���ʽ
	{
		
		ArrayList<ArrayList> Delivery = su.select("express","*","expressNumber="+expressNumber);
		String size = Delivery.get(0).get(4).toString().trim();
		System.out.println(size);
		//��ȡ����������
		String method = "";
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
		String NowTime = dateFormat.format(now);//��ʽ��Ȼ������ַ�����
		ArrayList<ArrayList> delay = su.select("delayTable","*","userID="+recipientTel);
		String delayStartDate = delay.get(0).get(1).toString();
		String delayEndDate = delay.get(0).get(2).toString();
		//�������ݿ��е��ӳٿ�ʼʱ�����ӳٽ���ʱ��,�ֱ����ӳٱ��еĵڶ��͵�����
		
		if(NowTime.compareTo(delayStartDate)>0&&NowTime.compareTo(delayEndDate)<0) {
			method = "������";
		}
		else {
			if(size.equals("����")) 
				method = "������";
			else 
				method = "�����";
		    }
		su.update("dispatch","deliveryMethod='"+method+"'","expressNumber="+expressNumber);
		System.out.println("�ѷ����ɼ���ʽ��");
		return method; 
	}
	
	//��������ʱ��
	public static Date AssignDeliveryTime(Login su,String expressNumber,String recipientTel) throws ParseException //�����ɼ�ʱ��,�߼���"��������ɼ���ʽ�ɹ���",��ȷ�ϵ�������,�ŵ��ø÷���
	{ 
		Date now = new Date(); 
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String NowTime = dateFormat1.format(now);//��ʽ��Ȼ������ַ�����
		//
		String weekday;
		ArrayList<ArrayList> delay = su.select("delayTable","*","userID="+recipientTel);
		String delayStartDate = delay.get(0).get(1).toString();
		String delayEndDate = delay.get(0).get(2).toString();
		System.out.println(delayEndDate+","+NowTime.compareTo(delayStartDate));
		if(NowTime.compareTo(delayEndDate)<0) {
			weekday = DateTools.dateToWeek(delayEndDate);//��ȡ������"���ڼ�"
			System.out.println(1+weekday);
			NowTime=delayEndDate;
		}
		else {
			weekday = DateTools.dateToWeek(NowTime);
			System.out.println(2+weekday);
		}
		
		ArrayList<ArrayList> Time = su.select("timeTable", "*","userID="+recipientTel+" and WeekTime='"+weekday+"'");
		//����ʱ����������
		int Hours = 0; // ��¼��������ʱ��
		for (int i = 2; i < Time.get(0).size(); i++) //��ʱ����3�п�ʼѭ��
		{
			if(Time.get(0).get(i).toString().equals("1")) {
				if(i<8) {
					Hours = 6+(i-2)*2;
					break;
				}
				if(i==8) {
					Hours = 18;
					break;
				}
				if(i>8)
					Hours = 19+(i-9)*2;
				// ��Ϊ���ݿ��ж���2Сʱ��һ�Σ�ֻ��18-19����һСʱһ�Σ��ʷֶη�����
			}
		}
		DecimalFormat df = new DecimalFormat("00");
		String DelayDefaultTime1 = NowTime + " " + df.format(Hours) + ":00:00";
		Date DelayDefaultTime2 = dateFormat2.parse(DelayDefaultTime1);
		
		su.update("dispatch","remindTime='"+ DelayDefaultTime1+"'","expressNumber="+expressNumber);
		// �������������ʱ��(��������ʱ��)
		Integer randNum = (int)(Math.random()* (999999)+1);//����ȡ���룬����(0,999999]֮��������
        String pickupcode = String.format("%06d",randNum);//�������ǰ���в�0��ȷ��Ϊ6λ����
        System.out.print(pickupcode);
        
        su.update("dispatch","pickupcode="+pickupcode,"expressNumber="+expressNumber);//�����ݿ����ȡ������Ϣ
        System.out.println("�ѷ����������ʱ�䣡�ѷ���ȡ���룡");
		return DelayDefaultTime2;
		}
	
	public static ArrayList ReceivingQueryByExpressNumber(Login su,String expressNumber)
	{//���ݿ�ݵ��Ų鿴�����Ϣ
		ArrayList<ArrayList> Receipt = su.select("dispatch","*","expressNumber="+expressNumber);
			for (int i = 0; i < Receipt.get(0).size(); i++) {
				System.out.print(Receipt.get(0).get(i)+ "\t");
			}
		return Receipt;
	}
	
	public static ArrayList ReceivingQueryByRecipientTel(Login su,String recipientTel)
	{//�����û�id�鿴�����Ϣ
	    ArrayList<ArrayList> Receipt = su.select("dispatch","*","recipientTel="+recipientTel);
			for (int i = 0; i < Receipt.size(); i++) {
				for (int j = 0; j < (Receipt.get(i)).size(); j++)
					System.out.print(Receipt.get(i).get(j) + "\t");
				System.out.println();	
			}
		return Receipt;
     }
	
	//ʱ�����1������У�0����æ
	public static void InputTimeTable(Login su,String recipientTel,int[][] timeTable)
	{//��һ����дʱ���ʱ���ô˷���
		String[]Week = {"'��һ'","'�ܶ�'","'����'","'����'","'����'","'����'","'����'"};
		for(int i = 0;i<7;i++) {
			su.insert("timeTable",recipientTel+","+Week[i]+","+timeTable[i][0]
				+","+timeTable[i][1]+","+timeTable[i][2]+","+timeTable[i][3]
				+","+timeTable[i][4]+","+timeTable[i][5]+","+timeTable[i][6]
				+","+timeTable[i][7]+","+timeTable[i][8]);
	    }
		System.out.print("ʱ���������ϣ�");
	}
	
	public static void ChangeTimeTable(Login su,String recipientTel,int[][] timeTable)
	{//�����޸�ʱ���ʱ���ô˷���
		su.delete("timeTable", "userID="+recipientTel);
		InputTimeTable(su,recipientTel,timeTable);
		System.out.print("ʱ����޸���ϣ�");
	}
	
	public static String[] ApplyForDelay(Login su,String recipientTel,String delayStartDate,
			String delayEndDate) throws ParseException 
	{//�û������ӳ�ȡ��
		//�˴��������Ϊdate������ʹ��ע���ڵ����
		/*
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String DelayStartDate = dateFormat.format(delayStartDate);
		String DelayEndDate = dateFormat.format(delayEndDate);
		*/
		String[] Delay = {delayStartDate,delayEndDate};
		if(su.select("delayTable", "*", "userID="+recipientTel).isEmpty())
			su.insert("delayTable",recipientTel+",'"+delayStartDate+"','"+delayEndDate+"'");
		else su.update("delayTable","DelayStartDate='"+delayStartDate+"',DelayEndDate='"+delayEndDate+"'","userID="+recipientTel);
		//�����ݿ������ӳ���Ϣ
		System.out.println("�Ѹ����ӳ���Ϣ");
		return Delay;
		
	}
	
	public static void PickUp(Login su,String expressNumber) throws ParseException 
	{//�û�ȡ��
		SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		String Now = formatter1.format(now);
		Date Nowaday = formatter1.parse(Now);
		String pickup= formatter2.format(now);
		//Date pickupTime = formatter2.parse(Now);
		ArrayList<ArrayList> r = su.select("express","*","expressNumber="+expressNumber);
		
		su.update("dispatch","pickupTime=getdate()","expressNumber="+expressNumber);
		su.update("express","status='��ȡ��'","expressNumber="+expressNumber);
		//�޸Ŀ�����еĿ��״̬��ȡ��ʱ��
		
		String size = r.get(0).get(4).toString().trim();
		//��ȡ��ŵص�
		//
		ArrayList<ArrayList> r1 = su.select("dispatch","*","expressNumber="+expressNumber);
		String location=r1.get(0).get(8).toString().trim();
		
		//���������ǳ������������(��������������,��ȡ��ʱ�޸������ʣ������Ϣ)
		if(location.contains("��"))
		{
			su.update("cabinet","headroom=headroom+1","size='"+size+"'");
			//
			su.update("cabinet_details","isFull=0","cabinetID='"+location+"'");
			su.update("report","dateID='"+Now+"'","pickupQuantity=pickupQuantity+1");
		}
		//
		else if(location.contains("��")) {
			su.update("shlef","expressNum=expressNum-1","shelfID='"+location+"'");
			su.update("report","pickupQuantity=pickupQuantity+1","dateID=convert(char(10),getdate(),120)");
		}
		else System.out.println("���δ����");
		
		//����ÿ�ձ���,��ȡ����������1.
	}
	
}

