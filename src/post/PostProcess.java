package post;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import database.Login;

public class PostProcess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Login su = new Login("superuser", "1234567");
		su.login();
		
		//�û�:��д������Ϣ
		Scanner input = new Scanner(System.in);
		System.out.println("����ļ���Ϣ����");
		System.out.print("��ݵ��ţ�");
		String expressNumber = input.nextLine();
		System.out.print("��ݹ�˾��");
		String expressCompany = input.nextLine();
		System.out.print("�ļ���������");
		String senderName = input.nextLine();
		System.out.print("�ļ��˵绰��");
		String senderTel = input.nextLine();
		System.out.print("�ļ���ַ");
		String senderAddress = input.nextLine();
		System.out.print("�ռ���������");
		String recipientName = input.nextLine();
		System.out.print("�ռ��˵绰��");
		String recipientTel = input.nextLine();
		System.out.print("�ռ���ַ��");
		String recipientAddress = input.nextLine();
		System.out.print("������");
		String weight = input.nextLine();
		System.out.print("�����");
		String size = input.nextLine();
		//System.out.print("�۸�");
		//Double payment = input.nextDouble();
		
		//�û��ύ�ļ���Ϣ������������󣬲������ݿ�
		//����״̬��Ϣ���޼ļ�ʱ��
		Post post=CreatePostParcel(su,expressNumber,expressCompany, senderName,senderTel, senderAddress, recipientName,
				recipientTel,recipientAddress,Double.parseDouble(weight),size);

		//Ա�������������ȷ��֧�����Ѵ���
		//�Ѵ��գ��ļ�ʱ��
		System.out.print("ȷ�����������1����");
		int check=input.nextInt();
		if(check==1) {
			setStatus(su,expressNumber,"�Ѵ���");
		}
		else {
			System.out.println("������������");
		}
		
		//Ա���������������Ѽĳ�
		//�Ѽĳ����ĳ�ʱ��
		System.out.print("ȷ�ϼĳ�������2����");
		check=input.nextInt();
		if(check==2) {
			//post.SetStatus("�Ѽĳ�");
			setStatus(su,expressNumber,"�Ѽĳ�");
		}
		else {
			System.out.println("������������");
		}
		
	}
	
	public static Post CreatePostParcel() 
	{
		return new Post();
	}
	
	public static Post CreatePostParcel(Login su,String expressNumber,String expressCompany,String senderName, String senderTel, 
			String senderAddress, String recipientName, String recipientTel,String recipientAddress,Double weight, String size)
	{
		//����weight����payment������8Ԫ������5Ԫ
		Double payment=8+5*Math.ceil(weight-1);
				
		Post post = new Post(expressNumber, expressCompany,senderName,senderTel, senderAddress,recipientName, 
				recipientTel, recipientAddress,weight,size,payment);
		
		//�������ݿ�
		String attr1="'"+expressNumber+"','"+senderTel+"','"+expressCompany+"',"+weight+",'"+size+"','����'";
		String attr2="'"+expressNumber+"','"+senderName+"','"+senderTel+"','"+senderAddress+"','"
				+recipientName+"','"+recipientTel+"','"+recipientAddress+"','2050-01-01 00:00:00','2050-01-01 00:00:00',"+payment;
		su.insert("express", attr1);
		su.insert("post", attr2);
		su.update("report","postQuantity=postQuantity+1","dateID=convert(char(10),getdate(),120)");//����ÿ�ձ���ǩ������
		System.out.println("ÿ�ձ����Ѹ���");
		//System.out.println("�ļ���Ϣ�ѱ��棡");
		return post;
	}
	
	//�ɿ�ݵ��Ų�ѯ��������¶���
	public static Post GetPostParcel(Login su,String expressNumber) {
		//�����ݿ��в�ѯ
		String attrs="express.expressNumber,senderName,post.senderTel,senderAddress,recipientName,recipientTel,recipientAddress,weight,size,status,placeTime,postTime, payment";
		String con="expressNumber='"+expressNumber+"' and express.expressNumber=post.expressNumber";
		ArrayList<ArrayList> r = su.select("post,express",attrs, con);
		
		//��ѯ���Ψһ
		String expressCompany=(String) r.get(0).get(1);
		String senderName = (String) r.get(0).get(2);
		String senderTel = (String) r.get(0).get(3);
		String senderAddress = (String) r.get(0).get(4);
		String recipientName= (String) r.get(0).get(5);
		String recipientTel = (String) r.get(0).get(6);
		String recipientAddress = (String) r.get(0).get(7);
		Double weight = (Double) r.get(0).get(8);
		String size= (String) r.get(0).get(9);
		String status= (String) r.get(0).get(10);
		Date placeTime= (Date) r.get(0).get(11);
		Date postTime= (Date) r.get(0).get(12);
		Double payment= (Double) r.get(0).get(13);
		
		Post post=new Post(expressNumber,senderName,senderTel, senderAddress,recipientName,recipientTel, recipientAddress,
				 weight, size,status,placeTime,postTime, payment);	
		return post;
	}
	
	//���û���ѯ���(senderTel)???
	public static Post GetUserPostParcel(Login su) {
		return new Post();
	}
	
	/*
	public static void InsertParcelInfo(Login su,String expressNumber,Double weight,String size,Double payment) {
		//�½�����
		Post post = GetPostParcel(su,expressNumber);	
		post.SetWeight(weight);
		post.SetSize(size);
		post.SetPayment(payment);
		
		//�������ݿ�
		String attrs="weight="+weight+",size=\'"+size+"\',payment="+payment;
		String con="expressNumber=\'"+expressNumber+"\'";
		su.update("post", attrs, con);
		
		System.out.println("�ļ���Ϣ�Ѹ��£�");
	}*/
	
	public static void setStatus(Login su,String expressNumber,String status) {
		//�½�����
		//Post post = GetPostParcel(su,expressNumber);
		//post.SetStatus(status);
		
		//Date day=new Date();    
		//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		
		//�������ݿ�
		String attrs1="status='"+status+"'";
		String attrs2="";
		if(status=="�Ѵ���") 
			attrs2="placeTime=getdate()";
		else if(status=="�Ѽĳ�")
			attrs2="postTime=getdate()";
		
		String con="expressNumber='"+expressNumber+"'";
		su.update("express", attrs1, con);
		su.update("post", attrs2, con);
		
		//System.out.println("�ļ�״̬�Ѹ���Ϊ��"+status);
		//System.out.println("ʱ�䣺"+df.format(day)); 
	}

}
