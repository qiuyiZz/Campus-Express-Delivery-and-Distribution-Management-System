package database;

import java.text.ParseException;

import dispatch.DeliveryProcess;
import dispatch.ReceivingProcess;

public class Test1 {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		//System.out.println("1区1号".replace('区', '_').replace("号", ""));
		Login su = new Login("superuser", "1234567");
		su.login();
		System.out.println(su.select("cabinet_details","count(*)",null).get(0).get(0).toString());
		//添加时间表:0没有时间，1有时间
		int[][] timeTable= {{1,1,1,0,0,0,0,1,1},
				{0,1,1,0,0,0,0,0,1},
				{0,0,0,1,1,0,0,0,1},
				{0,1,1,1,1,1,1,1,1},
				{1,0,0,1,0,0,0,0,1},
				{0,1,1,1,1,1,1,1,0},
				{0,1,1,1,1,1,1,1,1}};
		//ReceivingProcess.InputTimeTable(su, "13120498001", timeTable);
		
		//修改时间表
		ReceivingProcess.ChangeTimeTable(su, "13120498001", timeTable);
		/*
		//签收
		ReceivingProcess.ExpressReceipt(su, "202005228", "圆通", "13120498001", "student1", 1.00, "中", "已签收");
		//ReceivingProcess.ExpressReceipt(su, "202005224", "韵达", "13120498000", "student2", 1.5, "大", "已签收");
		
		//延迟表
		ReceivingProcess.ApplyForDelay(su, "13120498001", "2020-05-20", "2020-05-21");
		
		//查询派件
		DeliveryProcess.DeliveryQuery(su);
		
		//分配派件方式
		ReceivingProcess.AssignDeliveryMethod(su, "202005228", "13120498001");
		//ReceivingProcess.AssignDeliveryMethod(su, "202005224", "13120498000");
		
		//分配提醒时间和取件码
		ReceivingProcess.AssignDeliveryTime(su, "202005228", "13120498001");
		//ReceivingProcess.AssignDeliveryTime(su, "202005224", "13120498000");
		
		//查询派件
		DeliveryProcess.DeliveryQuery(su);
		
		//实际派件
		DeliveryProcess.Delivery(su, "202005223", "自提柜","1区5号");
		DeliveryProcess.Delivery(su, "202005224", "货架区","5号5层");
		
		//查询
		DeliveryProcess.DeliveryQueryByExpressNumber(su,"202005222");
		ReceivingProcess.ReceivingQueryByExpressNumber(su, "20200521");
		ReceivingProcess.ReceivingQueryByRecipientTel(su, "13120498000");
		
		//取件
		ReceivingProcess.PickUp(su, "202005223");
		*/
	}

}
