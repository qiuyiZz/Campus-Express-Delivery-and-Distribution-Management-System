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
		
		//���ڼ��ȡ������������
		//schedule(�����״�ִ��ʱ�䣬ִ�����ڣ�
		Timer timer1=new Timer();
		Timer_CheckReceived checkR=new Timer_CheckReceived();
		timer1.scheduleAtFixedRate(checkR, Calendar.getInstance().getTime(), 1000*60*60*2);//ÿ�μ���2Сʱ�ٴθ���
		
		//ת�������������¿��״̬��������
		Scanner input = new Scanner(System.in);
		System.out.println("�����ݵ��ţ�");
		String expressNumber=input.nextLine();
		System.out.println("ȷ�Ͽ��ת��������������1����");
		String check=input.nextLine();
		if(check.equals("1")) {
			setStatus(su,expressNumber,"������");
		}
		else {
			System.out.println("������������");
		}
		
		//������Ϣ
		System.out.println("�����ݵ��ţ�");
		expressNumber=input.nextLine();
		System.out.println("ȷ�Ϸ�����������Ϣ������2����");
		check=input.nextLine();
		if(check.equals("2")) {
			sendMessage(su,expressNumber);
		}
		else {
			System.out.println("������������");
		}
		
		//���ڼ��24Сʱ��δȡ��
		Timer timer2=new Timer();
		Timer_CheckProblem checkP=new Timer_CheckProblem();
		timer2.scheduleAtFixedRate(checkP, Calendar.getInstance().getTime(), 1000*60*60*2);//ÿ�μ���2Сʱ�ٴθ���
		
		//Ա����ɿ���˻�
		System.out.println("�����ݵ��ţ�");
		expressNumber=input.nextLine();
		System.out.println("ȷ���˻����������3����");
		check=input.nextLine();
		if(check.equals("3")) {
			setExit(su,expressNumber,"�˼�");
			setStatus(su,expressNumber,"�ɹ��˼�");
		}
		else {
			System.out.println("������������");
		}
	}

	public Problem CreateProblemParcel() {
		return new Problem();
	}
	
	public static Problem CreateProblemParcel(Login su,String expressNumber,String expressCompany,String recipientTel,String recipientName,Double weight,String size) throws ParseException {
		String retentionCode=getRandomCode(6);//�������6λ����ȡ����
		
		//��������
		Problem problem=new Problem(expressNumber,expressCompany,recipientTel,recipientName,weight,size,retentionCode,"������");
		
		//�������ݿ�
		String attr1="status='������'";
		String con1="expressNumber='"+expressNumber+"'";
		String attr2="'"+expressNumber+"','"+recipientTel+"','2050-01-01 00:00:00','δ�˳�','2050-01-01 00:00:00','"+retentionCode+"'";
		su.update("express", attr1,con1);
		su.insert("problem", attr2);
		su.update("report","problemQuantity=problemQuantity+1","dateID=convert(char(10),getdate(),120)");//����ÿ�ձ���ǩ������
		System.out.println("ÿ�ձ����Ѹ���");
		//System.out.println("������µ��������");
		
		return problem;
	}
	
	//�����ݿ��ֶβ�ѯ��������¶���
	public static Problem GetProblemParcel(Login su,String expressNumber) throws ParseException {
		String attrs="express.expressNumber,express.recipientTel,expressCompany,recipientName,weight,size,status,retentionReminderTime,exitWay,exitTime,retentionCode";
		String con="express.expressNumber='"+expressNumber+"' and express.expressNumber=problem.expressNumber and dispatch.expressNumber=problem.expressNumber";
		ArrayList<ArrayList> r = su.select("express,problem,dispatch",attrs, con);
			
		//��ѯ���Ψһ
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
		
	//����6λ����ȡ����
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
		//�½�����
		//Problem problem = GetProblemParcel(su,expressNumber);
		//problem.SetStatus(status);
		
		//Date day=new Date();    
		//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		
		//�������ݿ�
		String attrs="status='"+status+"'";
		String con="expressNumber='"+expressNumber+"'";
		su.update("express", attrs, con);
		
		//System.out.println("�����״̬�Ѹ���Ϊ��"+status);
	}
	
	public static void setExit(Login su,String expressNumber,String exitWay) {
		//�������ݿ�
		String attrs="exitWay='"+exitWay+"',exitTime=getdate()";
		String con="expressNumber='"+expressNumber+"'";
		su.update("problem", attrs, con);

	}
	
	//������������
	public static void sendMessage(Login su,String expressNumber) throws ParseException {
		//�½�����
		Problem problem = GetProblemParcel(su,expressNumber);
		String recipientTel=problem.GetRecipientTel();
		String retentionCode=problem.GetRetentionCode();
		System.out.println("���������Ѷ����ѷ��͸���"+recipientTel+"\t��ݵ��ţ�"+expressNumber+"\tȡ���룺"+retentionCode);
		
		//��������ʱ��
		//Date day=new Date();    
		//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		//String retentionReminderTime=df.format(day);
		//problem.SetRetentionReminderTime(df.parse(retentionReminderTime));
		
		//�������ݿ⣺��������ʱ��
		String attrs="retentionReminderTime=getdate()";
		String con="expressNumber='"+expressNumber+"'";
		su.update("problem", attrs, con);   
		
	}
	
}
