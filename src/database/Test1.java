package database;

import java.text.ParseException;

import dispatch.DeliveryProcess;
import dispatch.ReceivingProcess;

public class Test1 {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		//System.out.println("1��1��".replace('��', '_').replace("��", ""));
		Login su = new Login("superuser", "1234567");
		su.login();
		System.out.println(su.select("cabinet_details","count(*)",null).get(0).get(0).toString());
		//���ʱ���:0û��ʱ�䣬1��ʱ��
		int[][] timeTable= {{1,1,1,0,0,0,0,1,1},
				{0,1,1,0,0,0,0,0,1},
				{0,0,0,1,1,0,0,0,1},
				{0,1,1,1,1,1,1,1,1},
				{1,0,0,1,0,0,0,0,1},
				{0,1,1,1,1,1,1,1,0},
				{0,1,1,1,1,1,1,1,1}};
		//ReceivingProcess.InputTimeTable(su, "13120498001", timeTable);
		
		//�޸�ʱ���
		ReceivingProcess.ChangeTimeTable(su, "13120498001", timeTable);
		/*
		//ǩ��
		ReceivingProcess.ExpressReceipt(su, "202005228", "Բͨ", "13120498001", "student1", 1.00, "��", "��ǩ��");
		//ReceivingProcess.ExpressReceipt(su, "202005224", "�ϴ�", "13120498000", "student2", 1.5, "��", "��ǩ��");
		
		//�ӳٱ�
		ReceivingProcess.ApplyForDelay(su, "13120498001", "2020-05-20", "2020-05-21");
		
		//��ѯ�ɼ�
		DeliveryProcess.DeliveryQuery(su);
		
		//�����ɼ���ʽ
		ReceivingProcess.AssignDeliveryMethod(su, "202005228", "13120498001");
		//ReceivingProcess.AssignDeliveryMethod(su, "202005224", "13120498000");
		
		//��������ʱ���ȡ����
		ReceivingProcess.AssignDeliveryTime(su, "202005228", "13120498001");
		//ReceivingProcess.AssignDeliveryTime(su, "202005224", "13120498000");
		
		//��ѯ�ɼ�
		DeliveryProcess.DeliveryQuery(su);
		
		//ʵ���ɼ�
		DeliveryProcess.Delivery(su, "202005223", "�����","1��5��");
		DeliveryProcess.Delivery(su, "202005224", "������","5��5��");
		
		//��ѯ
		DeliveryProcess.DeliveryQueryByExpressNumber(su,"202005222");
		ReceivingProcess.ReceivingQueryByExpressNumber(su, "20200521");
		ReceivingProcess.ReceivingQueryByRecipientTel(su, "13120498000");
		
		//ȡ��
		ReceivingProcess.PickUp(su, "202005223");
		*/
	}

}
