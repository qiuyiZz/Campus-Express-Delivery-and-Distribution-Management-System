package problem;
import java.util.ArrayList;
import java.util.TimerTask;

import database.Login;

public class Timer_CheckProblem extends TimerTask{

	@Override
	public void run() {//����������24Сʱ���Ƿ�ȡ��
		// TODO Auto-generated method stub
		Login su = new Login("superuser", "1234567");
		su.login();
		
		//24Сʱ��δȡ����������Ϣ����Ϊ���˼�
		String attrs1="express.expressNumber,express.recipientTel";
		String con1="status='������' and retentionReminderTime<getdate()-1";//��������ʱ��൱ǰʱ�����24Сʱ
		ArrayList<ArrayList> r1=su.select("express inner join problem on express.expressNumber=problem.expressNumber", attrs1, con1);
		for (int i = 0; i < r1.size(); i++) {
			String expressNumber=(String) r1.get(i).get(0);
			String recipientTel=(String) r1.get(i).get(1);
			
			LastMessage(expressNumber,recipientTel);//���Ͷ���
			ProblemProcess.setStatus(su, expressNumber, "���˼�");
		}
		
		//24Сʱ����ȡ���������˳���ʽ
		String attrs2="express.expressNumber";
		String con2="status='��ȡ��' and express.expressNumber=problem.expressNumber";//�������ȡ��
		ArrayList<ArrayList> r2=su.select("express inner join problem on express.expressNumber=problem.expressNumber", attrs2, con2);
		for (int i = 0; i < r2.size(); i++) {
			String expressNumber=(String) r2.get(i).get(0);
			
			//�����˳�ϵͳ��ʽ��ʱ��
			ProblemProcess.setExit(su, expressNumber, "ȡ��");
		}	
	}
	
	public void LastMessage(String expressNumber,String recipientTel) {
		System.out.println("������δȡ���Ѷ����ѷ��͸���"+recipientTel+"\t��ݵ��ţ�"+expressNumber);
	}

}
