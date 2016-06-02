package sytproje;
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

@ManagedBean(name= "login")
@SessionScoped
public class login {
	String kullanici;
	String sifre;
	
	String[] kullanicilar={"melih","yigit","alper"};
	String[] sifreler={"12345","asdasd","zxc123"};
	
	public String getKullanici(){
		return kullanici;
	}

	public void setKullanici(String kullanici){
		this.kullanici=kullanici;
	}
	
	public String getSifre(){
		return sifre;		
	}
	
	public void setSifre(String sifre){
		this.sifre=sifre;
	}
	
	public String giris(){
		System.out.println(kullanici+sifre);
		System.out.println(kullanicilar[1]+sifreler[1]);
		for(int i=0;i<kullanicilar.length;i++){
			if(kullanici.equals(kullanicilar[i])){
				if(sifre.equals(sifreler[i])){
					return "anaSayfa";
				}
			}
		}
		return "Login";
	}
}
