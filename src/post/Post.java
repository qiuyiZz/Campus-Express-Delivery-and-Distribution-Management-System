package post;
import java.util.ArrayList;
import java.util.Date;

public class Post {
	String expressNumber; //快递单号
	String expressCompany; //快递公司名称
	String senderTel; //寄件人电话，指代用户id
	String senderName; //寄件人姓名
	String senderAddress;//寄件地址
	String recipientTel; //收件人电话
	String recipientName; //收件人姓名
	String recipientAddress;//收件地址
	Double weight;//质量
	String size;//体积区间
	String status;//快件状态
	Date placeTime = new Date(); //寄件时间，
	Date postTime = new Date();//寄出时间，快件交由快递公司时赋值
	Double payment;//支付金额
	
	public Post(){
    }
	
	public Post(String expressNumber,String expressCompany,String senderName, String senderTel, String senderAddress,String recipientTel, 
			String recipientName, String recipientAddress,Double weight, String size,Double payment){
    	this.expressNumber = expressNumber;
    	this.expressCompany=expressCompany;
    	this.senderTel = senderTel;
    	this.senderName=senderName;
    	this.senderAddress=senderAddress;
    	this.recipientTel=recipientTel;
    	this.recipientName=recipientName;
    	this.recipientAddress=recipientAddress;
    	this.weight=weight;
    	this.size=size;
    	this.payment=payment;
    }
	
	public Post(String expressNumber, String senderName, String senderTel, String senderAddress,String recipientTel, String recipientName, String recipientAddress,
			Double weight, String size,String status,Date placeTime,Date postTime,Double payment){
    	this.expressNumber = expressNumber;
    	this.senderTel = senderTel;
    	this.senderName=senderName;
    	this.senderAddress=senderAddress;
    	this.recipientTel=recipientTel;
    	this.recipientName=recipientName;
    	this.recipientAddress=recipientAddress;
    	this.weight=weight;
    	this.size=size;
    	this.status=status;
    	this.placeTime=placeTime;
    	this.postTime=postTime;
    	this.payment=payment;
    }
	
	public String GetExpressNumber() {
		return expressNumber;
	}
	
	public void SetExpressNumber(String expressNumber) {
    	this.expressNumber = expressNumber;
    }
	
	public String GetExpressCompany() {
    	return expressCompany;
    }
    
    public void SetExpressCompany(String expressCompany) {
    	this.expressCompany = expressCompany;
    }
    
    public String GetSenderTel() {
    	return senderTel;
    }
    
    public void SetSenderTel(String senderTel) {
    	this.senderTel = senderTel;
    }
    
    public String GetSenderName() {
    	return senderName;
    }
    
    public void SetSenderName(String senderName) {
    	this.senderName = senderName;
    }
    
    public String GetSenderAddress() {
    	return senderName;
    }
    
    public void SetSenderAddress(String senderAddress) {
    	this.senderAddress = senderAddress;
    }
    
    public String GetRecipientTel() {
    	return recipientTel;
    }
    
    public void SetRecipientTel(String recipientTel) {
    	this.recipientTel = recipientTel;
    }
    
    public String GetRecipientName() {
    	return recipientName;
    }
    
    public void SetRecipientName(String recipientName) {
    	this.recipientName = recipientName;
    }
    
    public String GetRecipientAddress() {
    	return recipientName;
    }
    
    public void SetRecipientAddress(String recipientAddress) {
    	this.recipientAddress = recipientAddress;
    }
    
    public Double GetWeight() {
    	return weight;
    }
    
    public void SetWeight(Double weight) {
    	this.weight = weight;
    }
    
    public String GetSize() {
    	return size;
    }
    
    public void SetSize(String size) {
    	this.size = size;
    }
    
    public String GetStatus() {
    	return status;
    }
    
    public void SetStatus(String status) {
    	this.status = status;
    }
    
    public Date GetPlaceTime() {
    	return placeTime;
    }
    
    public void SetPlaceTime(Date placeTime) {
    	this.placeTime=placeTime;
    }
    
    public Date GetPostTime() {
    	return postTime;
    }
    
    public void SetPostTime(Date postTime) {
    	this.postTime=postTime;
    }
    
    public Double GetPayment() {
    	return payment;
    }
    
    public void SetPayment(Double payment) {
    	this.payment=payment;
    }
    
}
