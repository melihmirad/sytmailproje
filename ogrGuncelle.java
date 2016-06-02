package sytproje;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ogrGuncelle {
	String ogrNumara;
	String puan;
	
	public String getogrNumara(){
		return ogrNumara;
	}
	
	public void setogrNumara(String ogrNumara){
		this.ogrNumara=ogrNumara;
	}
	
	public String getpuan(){
		return puan;
	}
	
	public void setpuan(String puan){
		this.puan=puan;
	}
	
	public void guncelle(){
		try{
			FileInputStream fstream = new FileInputStream("C:\\Users\\Asus N56VZ\\workspace\\SytMailProje\\dosya.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            StringBuilder fileContent = new StringBuilder();
            
            while ((strLine = br.readLine()) != null) {
                String tokens[] = strLine.split(" ");
                if (tokens.length > 0) {
                    if (tokens[0].equals(ogrNumara)) {
                        tokens[3] =puan;
                      
                        String newLine = tokens[0] + " " + tokens[1] + " " + tokens[2] + " " + tokens[3];
                        fileContent.append(newLine);
                        fileContent.append(System.getProperty("line.separator"));
                    } else {
                        fileContent.append(strLine);
                        fileContent.append(System.getProperty("line.separator"));
                    }
                }
            }
            
            FileWriter fstreamWrite = new FileWriter("C:\\Users\\Asus N56VZ\\workspace\\SytMailProje\\dosya.txt");
            BufferedWriter out = new BufferedWriter(fstreamWrite);
            out.write(fileContent.toString());
            System.out.println("Girdiðiniz öðrencinin notu güncellenmiþtir");
            
            out.close();
            br.close();
			
		}catch(Exception e){
			System.err.println("Error: " + e.getMessage());
		}
		
	}
	
	public void sil(){
		try{
			FileInputStream fstream = new FileInputStream("C:\\Users\\Asus N56VZ\\workspace\\SytMailProje\\dosya.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            StringBuilder fileContent = new StringBuilder();
            
            while ((strLine = br.readLine()) != null) {
                // Print the content on the console
                System.out.println(strLine);
                String tokens[] = strLine.split(" ");
                if (tokens.length > 0) {
                    // Here tokens[0] will have value of ID
                	if (tokens[0].equals(ogrNumara)) {
                        //dont do anything
                    } else {
                        // update content as it is
                        fileContent.append(strLine);
                        fileContent.append(System.getProperty("line.separator"));
                    }
                }
            }
            
            FileWriter fstreamWrite = new FileWriter("C:\\Users\\Asus N56VZ\\workspace\\SytMailProje\\dosya.txt");
            BufferedWriter out = new BufferedWriter(fstreamWrite);
            out.write(fileContent.toString());
            
            out.close();
            br.close();
			
			
		}catch(Exception e){
			System.err.println("Error: " + e.getMessage());	
		}
		
	}
	
}
