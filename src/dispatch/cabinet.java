package dispatch;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class cabinet {
	String cabinetID; //自提柜ID
	int capacity = 80; // 自提柜容量
	int headroom = 80; // 自提柜剩余容量
	static int[][] cabinetStatus=new int[8][10]; //false表示可用
	

	public cabinet(){
		
    }
	
	public cabinet(String cabinetID,int capacity,int headroom) {
		this.cabinetID = cabinetID;
		this.capacity = capacity;
		this.headroom = headroom;
		}

	public String GetcabinetID() {
		return cabinetID;
	}

	public void SetcabinetID(String cabinetID) {
		this.cabinetID = cabinetID;
	}
	
	public int Getcapacity() {
		return capacity;
	}

	public void Setcapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public int Getheadroom() {
		return headroom;
	}

	public void Setheadroom(int headroom) {
		this.headroom = headroom;
	}
	
	public static int[][] GetcabinetStatus(){
		return cabinetStatus;
	}
	
	public static void ReSetcabinetStatus() {
		for(int i = 0;i<8;i++) {
			for(int j = 0;j<10;j++) {
				cabinetStatus[i][j] = 0; 
			}
		}
	}
	
	public void deposit(int i,int j) //存入快件
	{
		if(cabinetStatus[i][j] == 0) {
			cabinetStatus[i][j] = 1;
			headroom -= 1;
		}
		else {
			System.out.print("该区域已被占用");
		}
		
	}
	
	public void TakeOut(int i,int j) //取出快件
	{
		if(cabinetStatus[i][j] == 1) {
			cabinetStatus[i][j] = 0;
			headroom += 1;
		}
		else {
			System.out.print("该区域未存入快件");
		}
	}
	
	public ArrayList CabinetQurry() // 查询取件信息
    {
    	ArrayList CabinetInfo=new ArrayList();
    	CabinetInfo.add(cabinetID);
    	CabinetInfo.add(capacity);
    	CabinetInfo.add(headroom);
    	CabinetInfo.add(cabinetStatus);
    	
    	return CabinetInfo;
	
    }
}
