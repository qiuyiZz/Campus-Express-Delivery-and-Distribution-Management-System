package problem;
import java.util.Date;
import java.util.ArrayList;

public class Problem extends Parcel{
	String expressNumber; //��ݵ���
	String expressCompany; //��ݹ�˾����
	String recipientTel; //�ռ��˵绰��ָ���û�id
	String recipientName; //�ռ�������
	Double weight;//����
	String size;//�������
	String status;//���״̬
	Date retentionReminderTime;//��������ʱ��
	String exitWay;//�˳�ϵͳ��ʽ��ȡ��/�˼�����ѡ
	Date exitTime;//�˳�ϵͳʱ�䣬��ѡ
	String retentionCode;//����ȡ����
	
	public Problem(){
    }
	
	public Problem(String expressNumber,String expressCompany,String recipientTel,String recipientName,Double weight,String size,String retentionCode,String status){
    	this.expressNumber = expressNumber;
    	this.expressCompany=expressCompany;
    	this.recipientTel = recipientTel;
    	this.recipientName=recipientName;
    	this.weight=weight;
    	this.size=size;
    	this.retentionCode=retentionCode; 	
    	this.status=status;
    }
	
	public Problem(String expressNumber,String expressCompany,String recipientTel,String recipientName,Double weight,String size,String status,
			Date retentionReminderTime,String exitWay,Date exitTime,String retentionCode){
    	this.expressNumber = expressNumber;
    	this.expressCompany=expressCompany;
    	this.recipientTel = recipientTel;
    	this.recipientName=recipientName;
    	this.weight=weight;
    	this.size=size;
    	this.status=status;
    	this.retentionReminderTime=retentionReminderTime;
    	this.exitWay=exitWay;
    	this.exitTime=exitTime;
    	this.retentionCode=retentionCode; 	
    	
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
    
    public Date GetRetentionReminderTime() {
    	return retentionReminderTime;
    }
    
    public void SetRetentionReminderTime(Date retentionReminderTime) {
    	this.retentionReminderTime = retentionReminderTime;
    }
    
    public String GetExitWay() {
    	return exitWay;
    }
    
    public void SetExitWay(String exitWay) {
    	this.exitWay=exitWay;
    }
    
    public Date GetExitTime() {
    	return exitTime;
    }
    
    public void SetExitTime(Date exitTime) {
    	this.exitTime = exitTime;
    }
    
    public String GetRetentionCode() {
    	return retentionCode;
    }
    
    public void SetRetentionCode(String retentionCode) {
    	this.retentionCode = retentionCode;
    }
    /*
    //��ѯ������ݵ���
    public ArrayList searchProblemParcel(Login su, String expressNumber){
    	String s="expressNumber = "+expressNumber;
    	ArrayList<ArrayList> r = su.select("problem", "*", s);//����δ�޸�
    	return r;
    }
    
    //�޸ģ�����ݵ���
    public void updateProblemParcel(Login su,String field,String update,String expressNumber) {
    	String newS=field+"="+update;
    	String s="expressNumber = "+expressNumber;
    	su.update("problem", newS, s);//����δ�޸�
    }
	*/
}
