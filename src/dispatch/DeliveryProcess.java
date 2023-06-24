package dispatch;

import java.util.Date;
import database.Login;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DeliveryProcess {
	//派件相关方法,由员工调用

	public static void main(String[] args) {
		
		Login ss = new Login("superuser", "1234567");
		ss.login();
		//创建数据库对象

	}
	
	public static ArrayList DeliveryQuery(Login ss) {
	// 查询所有待派送的快件,即状态为"已签收"
		ArrayList<ArrayList> Delivery = ss.select("express","*","status='已签收'");
		for (int i = 0; i < Delivery.size(); i++) {
			for (int j = 0; j < (Delivery.get(i)).size(); j++)
				System.out.print(Delivery.get(i).get(j) + "\t");
			System.out.println();	
		}
	return Delivery;
	}
	
	public static ArrayList DeliveryQueryByExpressNumber(Login ss,String expressNumber)
	{//根据快递单号查看派件信息
		ArrayList<ArrayList> Delivery = ss.select("dispatch","*","expressNumber="+expressNumber);
		if(!Delivery.get(0).get(5).toString().trim().equals("已签收")) {
		//若该快件状态不为"已签收",即已派送,则显示提示信息
			System.out.print("该快递单号下不存在待派送的快件！");
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
	//员工根据快递单号删除某快件信息
		ss.delete("dispatch","expressNumber="+expressNumber);
		System.out.print("该快件信息已被删除");
	}

	public static String Delivery(Login ss,String expressNumber,String type,String location) throws ParseException {
	//员工根据快递单号派送快件
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
		ArrayList<ArrayList> delivery = ss.select("dispatch","*","expressNumber="+expressNumber);
		if(delivery.isEmpty())
			return "不存在该快递单号！";
		Date now = new Date();
		String remindTime = delivery.get(0).get(5).toString().trim();
		String Now = formatter.format(now);
		Date Nowaday = formatter.parse(Now);
		Date RemindTime = formatter1.parse(remindTime);
		//获取特定格式的Date类型当前时间和提醒时间
		/*
		if(Nowaday.before(RemindTime)) {
			System.out.print("当前不是该快件的可派送时间");
			return "当前不是该快件的可派送时间";
		}
		*/
		//数据库中字符串有format形式，需要去掉多余空格
		String method=(String) ss.select("dispatch", "deliveryMethod", "expressNumber="+expressNumber).get(0).get(0).toString().trim();
		if(!method.equals(type)) {
			System.out.println("分配方式不符合要求"+method+" "+type);
			return "分配方式不符合要求"+method;
		}
		if(type=="自提柜") {
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
		    		ss.update("express","status='已派送'","expressNumber="+expressNumber);
		    		System.out.println("成功加入自提柜"+location+"!");
		    		return "成功加入自提柜"+location+"!";
		    	}
		    	else {
		    		System.out.println("自提柜与快件大小不匹配");
		    		return "自提柜与快件大小不匹配";
		    	}
		    }
		    else {
		    	System.out.println("该自提柜非空");
		    	return "该自提柜非空";
		    }
		}
		else {
		    ss.update("dispatch", "location='"+location+"',actualDelivery=getdate()", "expressNumber="+expressNumber);
		   	ss.update("shelf", "expressNum=expressNum+1", "shelfID='"+location+"';");
		   	//
		   	ss.update("express","status='已派送'","expressNumber="+expressNumber);
		    System.out.println("成功加入货架区"+location+"!");
		    return "成功加入货架区"+location+"!";
		}
	}
	
}
