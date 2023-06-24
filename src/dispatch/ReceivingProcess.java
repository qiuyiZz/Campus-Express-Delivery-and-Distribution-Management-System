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
	//创建数据库对象
	
				
	}
	
	public static Received ExpressReceipt(Login su,String expressNumber,String expressCompany,String recipientTel,
			String recipientName,Double weight,String size,String status) throws ParseException //签收录入
	{	
		//这里有个坑，大写YYYY会将年份按周格式化，DD会将日期变为在一年里的天数而不是当月
		SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
		String submissionTime = formatter1.format(now);
		String Now = formatter2.format(now);
		Date Nowaday = formatter2.parse(Now);
		Received DisPatch = new Received(expressNumber,expressCompany,recipientTel,recipientName,weight,size);
		DisPatch.Setstatus("已签收");
		DisPatch.SetsubmissionTime(submissionTime);
		String attr_express = "'"+expressNumber+"','"+recipientTel+"','"+expressCompany+"','"+
				weight+"','"+size+"','"+DisPatch.Getstatus()+"'";
		String attr_dispatch = "'"+expressNumber+"','"+recipientTel+"','"+recipientName+
				"',getdate(),null,'2050-01-01 00:00:00','2050-01-01 00:00:00','"
					+ "2050-01-01 00:00:00','-','-'";
		su.insert("express",attr_express);
		su.insert("dispatch",attr_dispatch);
		System.out.println("快件已录入！");
		su.update("report","signedQuantity=signedQuantity+1","dateID=convert(char(10),getdate(),120)");//更新每日报告签收数量
		System.out.println("每日报告已更新");
		
		return DisPatch;
	}
	
	//分配派件方式
	public static String AssignDeliveryMethod(Login su,String expressNumber,String recipientTel) //分配派件方式
	{
		
		ArrayList<ArrayList> Delivery = su.select("express","*","expressNumber="+expressNumber);
		String size = Delivery.get(0).get(4).toString().trim();
		System.out.println(size);
		//获取快件体积参数
		String method = "";
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String NowTime = dateFormat.format(now);//格式化然后放入字符串中
		ArrayList<ArrayList> delay = su.select("delayTable","*","userID="+recipientTel);
		String delayStartDate = delay.get(0).get(1).toString();
		String delayEndDate = delay.get(0).get(2).toString();
		//查找数据库中的延迟开始时间与延迟结束时间,分别是延迟表中的第二和第三个
		
		if(NowTime.compareTo(delayStartDate)>0&&NowTime.compareTo(delayEndDate)<0) {
			method = "货架区";
		}
		else {
			if(size.equals("超大")) 
				method = "货架区";
			else 
				method = "自提柜";
		    }
		su.update("dispatch","deliveryMethod='"+method+"'","expressNumber="+expressNumber);
		System.out.println("已分配派件方式！");
		return method; 
	}
	
	//短信提醒时间
	public static Date AssignDeliveryTime(Login su,String expressNumber,String recipientTel) throws ParseException //分配派件时间,逻辑是"必须分配派件方式成功后",即确认当日配送,才调用该方法
	{ 
		Date now = new Date(); 
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String NowTime = dateFormat1.format(now);//格式化然后放入字符串中
		//
		String weekday;
		ArrayList<ArrayList> delay = su.select("delayTable","*","userID="+recipientTel);
		String delayStartDate = delay.get(0).get(1).toString();
		String delayEndDate = delay.get(0).get(2).toString();
		System.out.println(delayEndDate+","+NowTime.compareTo(delayStartDate));
		if(NowTime.compareTo(delayEndDate)<0) {
			weekday = DateTools.dateToWeek(delayEndDate);//获取当天是"星期几"
			System.out.println(1+weekday);
			NowTime=delayEndDate;
		}
		else {
			weekday = DateTools.dateToWeek(NowTime);
			System.out.println(2+weekday);
		}
		
		ArrayList<ArrayList> Time = su.select("timeTable", "*","userID="+recipientTel+" and WeekTime='"+weekday+"'");
		//查找时间表相关数据
		int Hours = 0; // 记录当日配送时点
		for (int i = 2; i < Time.get(0).size(); i++) //从时间表第3列开始循环
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
				// 因为数据库中都是2小时分一段，只有18-19点是一小时一段，故分段分析。
			}
		}
		DecimalFormat df = new DecimalFormat("00");
		String DelayDefaultTime1 = NowTime + " " + df.format(Hours) + ":00:00";
		Date DelayDefaultTime2 = dateFormat2.parse(DelayDefaultTime1);
		
		su.update("dispatch","remindTime='"+ DelayDefaultTime1+"'","expressNumber="+expressNumber);
		// 向快件表更新派送时间(短信提醒时间)
		Integer randNum = (int)(Math.random()* (999999)+1);//生成取件码，产生(0,999999]之间的随机数
        String pickupcode = String.format("%06d",randNum);//对随机数前进行补0，确保为6位数。
        System.out.print(pickupcode);
        
        su.update("dispatch","pickupcode="+pickupcode,"expressNumber="+expressNumber);//向数据库更新取件码信息
        System.out.println("已分配短信提醒时间！已分配取件码！");
		return DelayDefaultTime2;
		}
	
	public static ArrayList ReceivingQueryByExpressNumber(Login su,String expressNumber)
	{//根据快递单号查看快件信息
		ArrayList<ArrayList> Receipt = su.select("dispatch","*","expressNumber="+expressNumber);
			for (int i = 0; i < Receipt.get(0).size(); i++) {
				System.out.print(Receipt.get(0).get(i)+ "\t");
			}
		return Receipt;
	}
	
	public static ArrayList ReceivingQueryByRecipientTel(Login su,String recipientTel)
	{//根据用户id查看快件信息
	    ArrayList<ArrayList> Receipt = su.select("dispatch","*","recipientTel="+recipientTel);
			for (int i = 0; i < Receipt.size(); i++) {
				for (int j = 0; j < (Receipt.get(i)).size(); j++)
					System.out.print(Receipt.get(i).get(j) + "\t");
				System.out.println();	
			}
		return Receipt;
     }
	
	//时间表中1代表空闲，0代表繁忙
	public static void InputTimeTable(Login su,String recipientTel,int[][] timeTable)
	{//第一次填写时间表时调用此方法
		String[]Week = {"'周一'","'周二'","'周三'","'周四'","'周五'","'周六'","'周日'"};
		for(int i = 0;i<7;i++) {
			su.insert("timeTable",recipientTel+","+Week[i]+","+timeTable[i][0]
				+","+timeTable[i][1]+","+timeTable[i][2]+","+timeTable[i][3]
				+","+timeTable[i][4]+","+timeTable[i][5]+","+timeTable[i][6]
				+","+timeTable[i][7]+","+timeTable[i][8]);
	    }
		System.out.print("时间表输入完毕！");
	}
	
	public static void ChangeTimeTable(Login su,String recipientTel,int[][] timeTable)
	{//后续修改时间表时调用此方法
		su.delete("timeTable", "userID="+recipientTel);
		InputTimeTable(su,recipientTel,timeTable);
		System.out.print("时间表修改完毕！");
	}
	
	public static String[] ApplyForDelay(Login su,String recipientTel,String delayStartDate,
			String delayEndDate) throws ParseException 
	{//用户申请延迟取件
		//此处如果输入为date类型则使用注释内的语句
		/*
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String DelayStartDate = dateFormat.format(delayStartDate);
		String DelayEndDate = dateFormat.format(delayEndDate);
		*/
		String[] Delay = {delayStartDate,delayEndDate};
		if(su.select("delayTable", "*", "userID="+recipientTel).isEmpty())
			su.insert("delayTable",recipientTel+",'"+delayStartDate+"','"+delayEndDate+"'");
		else su.update("delayTable","DelayStartDate='"+delayStartDate+"',DelayEndDate='"+delayEndDate+"'","userID="+recipientTel);
		//向数据库输入延迟信息
		System.out.println("已更新延迟信息");
		return Delay;
		
	}
	
	public static void PickUp(Login su,String expressNumber) throws ParseException 
	{//用户取件
		SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		String Now = formatter1.format(now);
		Date Nowaday = formatter1.parse(Now);
		String pickup= formatter2.format(now);
		//Date pickupTime = formatter2.parse(Now);
		ArrayList<ArrayList> r = su.select("express","*","expressNumber="+expressNumber);
		
		su.update("dispatch","pickupTime=getdate()","expressNumber="+expressNumber);
		su.update("express","status='已取件'","expressNumber="+expressNumber);
		//修改快件表中的快件状态和取件时间
		
		String size = r.get(0).get(4).toString().trim();
		//获取存放地点
		//
		ArrayList<ArrayList> r1 = su.select("dispatch","*","expressNumber="+expressNumber);
		String location=r1.get(0).get(8).toString().trim();
		
		//如果快件不是超大件或已滞留(即存放在自提柜区,则取件时修改自提柜剩余量信息)
		if(location.contains("区"))
		{
			su.update("cabinet","headroom=headroom+1","size='"+size+"'");
			//
			su.update("cabinet_details","isFull=0","cabinetID='"+location+"'");
			su.update("report","dateID='"+Now+"'","pickupQuantity=pickupQuantity+1");
		}
		//
		else if(location.contains("层")) {
			su.update("shlef","expressNum=expressNum-1","shelfID='"+location+"'");
			su.update("report","pickupQuantity=pickupQuantity+1","dateID=convert(char(10),getdate(),120)");
		}
		else System.out.println("快件未派送");
		
		//更新每日报告,将取件数量增加1.
	}
	
}

