package problem;
import java.util.Date;
import java.util.ArrayList;

public class Problem extends Parcel{
	String expressNumber; //快递单号
	String expressCompany; //快递公司名称
	String recipientTel; //收件人电话，指代用户id
	String recipientName; //收件人姓名
	Double weight;//质量
	String size;//体积区间
	String status;//快件状态
	Date retentionReminderTime;//滞留提醒时间
	String exitWay;//退出系统方式，取件/退件，可选
	Date exitTime;//退出系统时间，可选
	String retentionCode;//滞留取件码
	
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
    //查询：按快递单号
    public ArrayList searchProblemParcel(Login su, String expressNumber){
    	String s="expressNumber = "+expressNumber;
    	ArrayList<ArrayList> r = su.select("problem", "*", s);//表名未修改
    	return r;
    }
    
    //修改：按快递单号
    public void updateProblemParcel(Login su,String field,String update,String expressNumber) {
    	String newS=field+"="+update;
    	String s="expressNumber = "+expressNumber;
    	su.update("problem", newS, s);//表名未修改
    }
	*/
}
