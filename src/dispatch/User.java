package dispatch;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class User {
	String userID; //用户电话号码
	String userPassWord; //用户密码
	String userName; //用户姓名
	String delayStartDate; //用户延迟申请开始时间
	String delayEndDate; //用户延迟申请结束时间
	String [][] timeTable = new String[7][9]; //用户时间表

	
	public User(){
    	
    }
    
    public User(String userID, String userPassWord, String userName){
    	this.userID = userID;
    	this.userPassWord = userPassWord;
    	this.userName = userName;
    }
    
    public String GetuserID() {
    	return userID;
    }
    
    public void SetuserID(String userID) {
    	this.userID = userID;
    } 
    
    public String GetuserPassWord() {
    	return userPassWord;
    }
    
    public void SetuserPassWord(String userPassWord) {
    	this.userPassWord = userPassWord;
    }
    
    public String GetuserName() {
        	return userName;
    }
        
    public void SetuserName(String userName) {
        	this.userName = userName;
    }
    
    public String GetdelayStartDate() {
    	return delayStartDate;
    }
    
    public void SetdelayStartDate(String delayStartDate) {
    	this.delayStartDate = delayStartDate;
    } 
    
    public String GetdelayEndDate() {
    	return delayEndDate;
    }
    
    public void SetdelayEndDate(String delayEndDate) {
    	this.delayEndDate = delayEndDate;
    } 
    
    public String[][] GettimeTable() {
    	String[][] TimeTable = new String[7][9];
    	for(int i = 0;i<8;i++) {
    		for(int j = 0;i<10;i++) {
    			timeTable[i][j] = TimeTable[i][j];
    		}
    	}
    	return TimeTable;
    }
    
    public void SettimeTableEntirely(String[][] timeTable) {
    	for(int i = 0;i<8;i++) {
    		for(int j = 0;i<10;i++) {
    			this.timeTable[i][j] = timeTable[i][j];
    		}
    	}
    }
    
    public void SettimeTablePartly(String Weekday,String Time,String status) {
    	String[] week = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
    	String[] time = {"6 to 8","8 to 10","10 to 12","12 to 14","14 to 16","16 to 18","18 to 19","19 to 21","21 to 23"};
    	int i,j =0;
    	for(i = 0;i<8;i++) {
    		if(Weekday == week[i])
    			Weekday = i + "";
    	}
    	for(j = 0;i<10;i++) {
    		if(Time == time[j])
    			Time = j + "";
    	}
    	i = Integer.parseInt(Weekday);
    	j = Integer.parseInt(Time);
    	timeTable[i][j] = status;
    }
    
    public ArrayList UserQurry() // 查询取件信息
    {
    	ArrayList<String> UserInfo=new ArrayList<String>();
    	UserInfo.add(GetuserID());
    	UserInfo.add(GetuserPassWord());
    	UserInfo.add(GetuserName());
    	UserInfo.add(GetdelayStartDate());
    	UserInfo.add(GetdelayEndDate());
    	
    	return UserInfo;
    	
    }
    
}
