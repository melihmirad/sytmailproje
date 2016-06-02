package sytproje;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class ogrBilgi {
	private String ogrNumara;
	private String ogrAdSoyad;
	private String ogrNot;
	
	public String getOgrNumara(){
		return ogrNumara;
	}
	
	public void setOgrNumara(String ogrNumara){
		this.ogrNumara=ogrNumara;
	}
	
	public String getOgrAdSoyad(){
		return ogrAdSoyad;
	}
	
	public void setOgrAdSoyad(String ogrAdSoyad){
		this.ogrAdSoyad=ogrAdSoyad;
	}
	
	public String getOgrNot(){
		return ogrNot;
	}
	
	public void setNot(String ogrNot){
		this.ogrNot=ogrNot;
	}
}
