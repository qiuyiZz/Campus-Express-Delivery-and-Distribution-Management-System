package dispatch;
import java.util.ArrayList;

public class Staff {
	
	String staffID;
	String staffPassWord;
	String staffName;
	String department;
	
	public Staff(){
    	
    }
    
    public Staff(String staffID,String staffPassWord,String staffName,String department){
    	this.staffID = staffID;
    	this.staffPassWord = staffPassWord;
    	this.staffName = staffName;
    	this.department = department;
    }
	
    public String GetstaffID() {
    	return staffID;
    }
    
    public void SetstaffID(String staffID) {
    	this.staffID = staffID;
    } 
    
    public String GetstaffPassWord() {
    	return staffPassWord;
    }
    
    public void SetstaffPassWord(String staffPassWord) {
    	this.staffPassWord = staffPassWord;
    }
    
    public String GetstaffName() {
        	return staffName;
    }
        
    public void SetstaffName(String staffName) {
        	this.staffName = staffName;
    } 
    
    public String Getdepartment() {
    	return department;
    }
    
    public void Setdepartment(String department) {
    	this.department = department;
    } 
    
    public ArrayList StaffQurry() // 查询员工信息
    {
    	ArrayList<String> StaffInfo=new ArrayList<String>();
    	StaffInfo.add(GetstaffID());
    	StaffInfo.add(GetstaffPassWord());
    	StaffInfo.add(GetstaffName());
    	StaffInfo.add(Getdepartment());
    	
    	return StaffInfo;
    	
    }
}
