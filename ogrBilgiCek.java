package sytproje;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ogrBilgiCek {
	public List<ogrBilgi> getOgrencilerTablosu() throws IOException{
		String[] sutunlar= new String[4];
		FileReader dosyaOku= new FileReader("C:\\Users\\Asus N56VZ\\workspace\\SytMailProje\\dosya.txt");
		BufferedReader tutOku=new BufferedReader(dosyaOku);
		
		String veri;
		veri = tutOku.readLine();
		List<ogrBilgi> liste= new ArrayList<>();
		
		System.out.println("burda hat var1");
		while(veri!= null){
			sutunlar=veri.split(" ");
			ogrBilgi gecici=new ogrBilgi();
			gecici.setOgrNumara(sutunlar[0]);			
			gecici.setOgrAdSoyad(sutunlar[1]+" "+sutunlar[2]);
			System.out.println(gecici.getOgrAdSoyad());			
			gecici.setNot(sutunlar[3]);
			System.out.println(gecici.getOgrNot());			
			liste.add(gecici);			
			veri = tutOku.readLine();			
		}
		
		tutOku.close();
		return liste;
	}
}
