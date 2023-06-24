package dispatch;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;


public class Received {
	
	String expressNumber; //��ݵ���
	String recipientTel; //�ռ��˵绰��ָ���û�id
	String recipientName; //�ռ�������
	String expressCompany; //��ݹ�˾����
	Double weight;//����
	String size;//�������
	String status;//���״̬
	String submissionTime; //ǩ��ʱ�䣬���״̬Ϊ����ǩ�ա�ʱ�����и�ֵ
	String remindTime; //��������ʱ�䣬���㷨�ó�
	String actualDelivery; //ʵ���ɼ�ʱ�䣬���״̬Ϊ�������͡�ʱ�����и�ֵ
	String pickupTime; // ȡ��ʱ�䣬���״̬Ϊ����ȡ����ʱ�����и�ֵ
    String location; //��ŵص㣬���㷨����
    String pickupCode; //ȡ���롣���㷨����
    
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
       
    public ArrayList ReceiptQurry() // ��ѯȡ����Ϣ
    {
    	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    	ArrayList<String> ReceiptInfo=new ArrayList<String>();
    	ReceiptInfo.add(GetexpressNumber());
    	ReceiptInfo.add(GetrecipientTel());
    	ReceiptInfo.add(GetrecipientName());
    	ReceiptInfo.add((Getweight()+""));
    	ReceiptInfo.add(Getsize());
    	ReceiptInfo.add(Getstatus());
    	ReceiptInfo.add("ǩ��ʱ��:"+sf.format(submissionTime));
    	ReceiptInfo.add("��������ʱ��:"+sf.format(remindTime));
    	ReceiptInfo.add("ʵ���ɼ�ʱ��:"+sf.format(actualDelivery));
    	ReceiptInfo.add("ȡ��ʱ��:"+sf.format(pickupTime));
    	ReceiptInfo.add(Getlocation());
    	ReceiptInfo.add(GetpickupCode());
    	
    	return ReceiptInfo;
    	
    }





}
