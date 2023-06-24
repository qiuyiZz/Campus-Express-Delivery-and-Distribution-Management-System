package dispatch;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;


public class Received {
	
	String expressNumber; //快递单号
	String recipientTel; //收件人电话，指代用户id
	String recipientName; //收件人姓名
	String expressCompany; //快递公司名称
	Double weight;//质量
	String size;//体积区间
	String status;//快件状态
	String submissionTime; //签收时间，快件状态为“已签收”时，进行赋值
	String remindTime; //短信提醒时间，由算法得出
	String actualDelivery; //实际派件时间，快件状态为“已配送”时，进行赋值
	String pickupTime; // 取件时间，快件状态为“已取件”时，进行赋值
    String location; //存放地点，由算法生成
    String pickupCode; //取件码。由算法生成
    
    public Received(){
    	
    }
    
    public Received(String expressNumber,String expressCompany,String recipientTel,String recipientName,Double weight,String size){
    	this.expressNumber = expressNumber;
    	this.expressCompany = expressCompany;
    	this.recipientTel = recipientTel;
    	this.recipientName = recipientName;
    	this.weight = weight;
    	this.size = size;
    }
    
    
	public String GetexpressNumber() {
    	return expressNumber;
    }
    
    public void SetexpressNumber(String expressNumber) {
    	this.expressNumber = expressNumber;
    }
    
    public String GetexpressCompany() {
    	return expressCompany;
    }
    
    public void SetexpressCompany(String expressCompany) {
    	this.expressCompany = expressCompany;
    }
    public String GetrecipientTel() {
    	return recipientTel;
    }
    
    public void SetrecipientTel(String recipientTel) {
    	this.recipientTel = recipientTel;
    }
    
    public String GetrecipientName() {
    	return recipientName;
    }
    
    public void SetrecipientName(String recipientName) {
    	this.recipientName = recipientName;
    }
    
    public Double Getweight() {
    	return weight;
    }
    
    public void Setweight(Double weight) {
    	this.weight = weight;
    }
    
    public String Getsize() {
    	return size;
    }
    
    public void Setsize(String size) {
    	this.size = size;
    }
    
    public String Getstatus() {
    	return status;
    }
    
    public void Setstatus(String status) {
    	this.status = status;
    }
    
    public String GetsubmissionTime() {
    	return submissionTime;
    }
    
    public void SetsubmissionTime(String submissionTime) {
    	this.submissionTime = submissionTime;
    }
    
    public String GetremindTime() {
    	return remindTime;
    }
    
    public void SetremindTime(String remindTime) {
    	this.remindTime = remindTime;
    }
    
    public String GetactualDelivery() {
    	return actualDelivery;
    }
    
    public void SetactualDelivery(String actualDelivery) {
    	this.actualDelivery = actualDelivery;
    }
    
    public String GetpickupTime() {
    	return pickupTime;
    }
    
    public void SetpickupTime(String pickupTime) {
    	this.pickupTime = pickupTime;
    }
    
    public String Getlocation() {
    	return location;
    }
    
    public void Setlocation(String location) {
    	this.location = location;
    }
    
    public String GetpickupCode() {
    	return pickupCode;
    }
    
    public void SetpickupCode(String pickupCode) {
    	this.pickupCode = pickupCode;
    }
       
    public ArrayList ReceiptQurry() // 查询取件信息
    {
    	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    	ArrayList<String> ReceiptInfo=new ArrayList<String>();
    	ReceiptInfo.add(GetexpressNumber());
    	ReceiptInfo.add(GetrecipientTel());
    	ReceiptInfo.add(GetrecipientName());
    	ReceiptInfo.add((Getweight()+""));
    	ReceiptInfo.add(Getsize());
    	ReceiptInfo.add(Getstatus());
    	ReceiptInfo.add("签收时间:"+sf.format(submissionTime));
    	ReceiptInfo.add("短信提醒时间:"+sf.format(remindTime));
    	ReceiptInfo.add("实际派件时间:"+sf.format(actualDelivery));
    	ReceiptInfo.add("取件时间:"+sf.format(pickupTime));
    	ReceiptInfo.add(Getlocation());
    	ReceiptInfo.add(GetpickupCode());
    	
    	return ReceiptInfo;
    	
    }





}
