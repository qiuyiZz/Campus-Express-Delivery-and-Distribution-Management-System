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
		
		//用户:填写基本信息
		Scanner input = new Scanner(System.in);
		System.out.println("输入寄件信息……");
		System.out.print("快递单号：");
		String expressNumber = input.nextLine();
		System.out.print("快递公司：");
		String expressCompany = input.nextLine();
		System.out.print("寄件人姓名：");
		String senderName = input.nextLine();
		System.out.print("寄件人电话：");
		String senderTel = input.nextLine();
		System.out.print("寄件地址");
		String senderAddress = input.nextLine();
		System.out.print("收件人姓名：");
		String recipientName = input.nextLine();
		System.out.print("收件人电话：");
		String recipientTel = input.nextLine();
		System.out.print("收件地址：");
		String recipientAddress = input.nextLine();
		System.out.print("质量：");
		String weight = input.nextLine();
		System.out.print("体积：");
		String size = input.nextLine();
		//System.out.print("价格：");
		//Double payment = input.nextDouble();
		
		//用户提交寄件信息，创建快件对象，插入数据库
		//但无状态信息，无寄件时间
		Post post=CreatePostParcel(su,expressNumber,expressCompany, senderName,senderTel, senderAddress, recipientName,
				recipientTel,recipientAddress,Double.parseDouble(weight),size);

		//员工：收入包裹，确认支付，已代收
		//已代收，寄件时间
		System.out.print("确认收入包裹（1）：");
		int check=input.nextInt();
		if(check==1) {
			setStatus(su,expressNumber,"已代收");
		}
		else {
			System.out.println("错误！重新输入");
		}
		
		//员工：发出包裹，已寄出
		//已寄出，寄出时间
		System.out.print("确认寄出包裹（2）：");
		check=input.nextInt();
		if(check==2) {
			//post.SetStatus("已寄出");
			setStatus(su,expressNumber,"已寄出");
		}
		else {
			System.out.println("错误！重新输入");
		}
		
	}
	
	public static Post CreatePostParcel() 
	{
		return new Post();
	}
	
	public static Post CreatePostParcel(Login su,String expressNumber,String expressCompany,String senderName, String senderTel, 
			String senderAddress, String recipientName, String recipientTel,String recipientAddress,Double weight, String size)
	{
		//根据weight计算payment：首重8元，续重5元
		Double payment=8+5*Math.ceil(weight-1);
				
		Post post = new Post(expressNumber, expressCompany,senderName,senderTel, senderAddress,recipientName, 
				recipientTel, recipientAddress,weight,size,payment);
		
		//存入数据库
		String attr1="'"+expressNumber+"','"+senderTel+"','"+expressCompany+"',"+weight+",'"+size+"','待寄'";
		String attr2="'"+expressNumber+"','"+senderName+"','"+senderTel+"','"+senderAddress+"','"
				+recipientName+"','"+recipientTel+"','"+recipientAddress+"','2050-01-01 00:00:00','2050-01-01 00:00:00',"+payment;
		su.insert("express", attr1);
		su.insert("post", attr2);
		su.update("report","postQuantity=postQuantity+1","dateID=convert(char(10),getdate(),120)");//更新每日报告签收数量
		System.out.println("每日报告已更新");
		//System.out.println("寄件信息已保存！");
		return post;
	}
	
	//由快递单号查询结果创建新对象
	public static Post GetPostParcel(Login su,String expressNumber) {
		//从数据库中查询
		String attrs="express.expressNumber,senderName,post.senderTel,senderAddress,recipientName,recipientTel,recipientAddress,weight,size,status,placeTime,postTime, payment";
		String con="expressNumber='"+expressNumber+"' and express.expressNumber=post.expressNumber";
		ArrayList<ArrayList> r = su.select("post,express",attrs, con);
		
		//查询结果唯一
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
	
	//由用户查询结果(senderTel)???
	public static Post GetUserPostParcel(Login su) {
		return new Post();
	}
	
	/*
	public static void InsertParcelInfo(Login su,String expressNumber,Double weight,String size,Double payment) {
		//新建对象
		Post post = GetPostParcel(su,expressNumber);	
		post.SetWeight(weight);
		post.SetSize(size);
		post.SetPayment(payment);
		
		//存入数据库
		String attrs="weight="+weight+",size=\'"+size+"\',payment="+payment;
		String con="expressNumber=\'"+expressNumber+"\'";
		su.update("post", attrs, con);
		
		System.out.println("寄件信息已更新！");
	}*/
	
	public static void setStatus(Login su,String expressNumber,String status) {
		//新建对象
		//Post post = GetPostParcel(su,expressNumber);
		//post.SetStatus(status);
		
		//Date day=new Date();    
		//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		
		//存入数据库
		String attrs1="status='"+status+"'";
		String attrs2="";
		if(status=="已代收") 
			attrs2="placeTime=getdate()";
		else if(status=="已寄出")
			attrs2="postTime=getdate()";
		
		String con="expressNumber='"+expressNumber+"'";
		su.update("express", attrs1, con);
		su.update("post", attrs2, con);
		
		//System.out.println("寄件状态已更新为："+status);
		//System.out.println("时间："+df.format(day)); 
	}

}
