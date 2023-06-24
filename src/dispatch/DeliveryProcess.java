package dispatch;

import java.util.Date;
import database.Login;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DeliveryProcess {
	//�ɼ���ط���,��Ա������

	public static void main(String[] args) {
		
		Login ss = new Login("superuser", "1234567");
		ss.login();
		//�������ݿ����

	}
	
	public static ArrayList DeliveryQuery(Login ss) {
	// ��ѯ���д����͵Ŀ��,��״̬Ϊ"��ǩ��"
		ArrayList<ArrayList> Delivery = ss.select("express","*","status='��ǩ��'");
		for (int i = 0; i < Delivery.size(); i++) {
			for (int j = 0; j < (Delivery.get(i)).size(); j++)
				System.out.print(Delivery.get(i).get(j) + "\t");
			System.out.println();	
		}
	return Delivery;
	}
	
	public static ArrayList DeliveryQueryByExpressNumber(Login ss,String expressNumber)
	{//���ݿ�ݵ��Ų鿴�ɼ���Ϣ
		ArrayList<ArrayList> Delivery = ss.select("dispatch","*","expressNumber="+expressNumber);
		if(!Delivery.get(0).get(5).toString().trim().equals("��ǩ��")) {
		//���ÿ��״̬��Ϊ"��ǩ��",��������,����ʾ��ʾ��Ϣ
			System.out.print("�ÿ�ݵ����²����ڴ����͵Ŀ����");
			return new ArrayList<ArrayList>();
		}
		else {
			for (int i = 0; i < Delivery.get(0).size(); i++) {
				System.out.print(Delivery.get(0).get(i)+ "\t");
			}
			return Delivery;
		}
    }
	
	public static void DeliveryDelete(Login ss,String expressNumber) {
	//Ա�����ݿ�ݵ���ɾ��ĳ�����Ϣ
		ss.delete("dispatch","expressNumber="+expressNumber);
		System.out.print("�ÿ����Ϣ�ѱ�ɾ��");
	}

	public static String Delivery(Login ss,String expressNumber,String type,String location) throws ParseException {
	//Ա�����ݿ�ݵ������Ϳ��
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
		ArrayList<ArrayList> delivery = ss.select("dispatch","*","expressNumber="+expressNumber);
		if(delivery.isEmpty())
			return "�����ڸÿ�ݵ��ţ�";
		Date now = new Date();
		String remindTime = delivery.get(0).get(5).toString().trim();
		String Now = formatter.format(now);
		Date Nowaday = formatter.parse(Now);
		Date RemindTime = formatter1.parse(remindTime);
		//��ȡ�ض���ʽ��Date���͵�ǰʱ�������ʱ��
		/*
		if(Nowaday.before(RemindTime)) {
			System.out.print("��ǰ���Ǹÿ���Ŀ�����ʱ��");
			return "��ǰ���Ǹÿ���Ŀ�����ʱ��";
		}
		*/
		//���ݿ����ַ�����format��ʽ����Ҫȥ������ո�
		String method=(String) ss.select("dispatch", "deliveryMethod", "expressNumber="+expressNumber).get(0).get(0).toString().trim();
		if(!method.equals(type)) {
			System.out.println("���䷽ʽ������Ҫ��"+method+" "+type);
			return "���䷽ʽ������Ҫ��"+method;
		}
		if(type=="�����") {
		    int isFull=Integer.parseInt((String) ss.select("cabinet_details", "isFull", "cabinetID='"+location+"'").get(0).get(0));
		    if(isFull==0) {
		    	String express_size=ss.select("express", "size", "expressNumber="+expressNumber).get(0).get(0).toString().trim();
		    	String cabinet_size=ss.select("cabinet_details", "size", "cabinetID='"+location+"';").get(0).get(0).toString().trim();
		    	System.out.println(express_size+","+cabinet_size);
		    	if(express_size.equals(cabinet_size)) {
		    		ss.update("dispatch", "location='"+location+"',actualDelivery=getdate()", "expressNumber="+expressNumber);
		    		ss.update("cabinet_details", "isFull=1", "cabinetID='"+location+"';");
		    		ss.update("cabinet","headroom=headroom-1","size='"+cabinet_size+"'");
		    		//
		    		ss.update("express","status='������'","expressNumber="+expressNumber);
		    		System.out.println("�ɹ����������"+location+"!");
		    		return "�ɹ����������"+location+"!";
		    	}
		    	else {
		    		System.out.println("�����������С��ƥ��");
		    		return "�����������С��ƥ��";
		    	}
		    }
		    else {
		    	System.out.println("�������ǿ�");
		    	return "�������ǿ�";
		    }
		}
		else {
		    ss.update("dispatch", "location='"+location+"',actualDelivery=getdate()", "expressNumber="+expressNumber);
		   	ss.update("shelf", "expressNum=expressNum+1", "shelfID='"+location+"';");
		   	//
		   	ss.update("express","status='������'","expressNumber="+expressNumber);
		    System.out.println("�ɹ����������"+location+"!");
		    return "�ɹ����������"+location+"!";
		}
	}
	
}
