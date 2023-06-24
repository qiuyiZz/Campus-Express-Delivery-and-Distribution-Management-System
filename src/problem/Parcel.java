package problem;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Parcel {
	
	String expressNumber; //��ݵ���
	String recipientTel; //�ռ��˵绰��ָ���û�id
	String expressCompany; //��ݹ�˾����
	Double weight;//����
	String size;//�������
	String status;//���״̬

    public Parcel(){
    	
    }
    
    public Parcel(String expressNumber, String recipientTel, String expressCompany){
    	this.expressNumber = expressNumber;
    	this.recipientTel = recipientTel;
    	this.expressCompany = expressCompany;
    }
    
    public String GetExpressNumber() {
    	return expressNumber;
    }
    
    public void SetExpressNumber(String expressNumber) {
    	this.expressNumber = expressNumber;
    }
    
    public String GetRecipientTel() {
    	return recipientTel;
    }
    
    public void SetRecipientTel(String recipientTel) {
    	this.recipientTel = recipientTel;
    }
    
    public String GetxEpressCompany() {
    	return expressCompany;
    }
    
    public void SetExpressCompany(String expressCompany) {
    	this.expressCompany = expressCompany;
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
    
    public ArrayList ReceiptQurry() // ��ѯȡ����Ϣ
    {
    	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    	ArrayList<String> ParcelInfo=new ArrayList<String>();
    	ParcelInfo.add(GetExpressNumber());
    	ParcelInfo.add(GetRecipientTel());
    	ParcelInfo.add(GetxEpressCompany());
    	ParcelInfo.add((GetWeight()+""));
    	ParcelInfo.add(GetSize());
    	ParcelInfo.add(GetStatus());
    	
    	return ParcelInfo;
    	
    }
    
    
    
    


}
