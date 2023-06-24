package post;
import java.util.ArrayList;
import java.util.Date;

public class Post {
	String expressNumber; //��ݵ���
	String expressCompany; //��ݹ�˾����
	String senderTel; //�ļ��˵绰��ָ���û�id
	String senderName; //�ļ�������
	String senderAddress;//�ļ���ַ
	String recipientTel; //�ռ��˵绰
	String recipientName; //�ռ�������
	String recipientAddress;//�ռ���ַ
	Double weight;//����
	String size;//�������
	String status;//���״̬
	Date placeTime = new Date(); //�ļ�ʱ�䣬
	Date postTime = new Date();//�ĳ�ʱ�䣬������ɿ�ݹ�˾ʱ��ֵ
	Double payment;//֧�����
	
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
