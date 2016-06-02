package sytproje;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.mail.*;
import javax.mail.internet.*;

@ManagedBean
@SessionScoped
public class mailKontrol{
	public void kontrol(){
		Properties properties = new Properties();
        properties.put("mail.pop3.host", "pop.gmail.com");
        properties.put("mail.pop3.port", "995");
        properties.put("mail.pop3.starttls.enable", "true");
        try{
    		Session emailSession = Session.getDefaultInstance(properties);
            
            Store store = emailSession.getStore("pop3s");
            store.connect("pop.gmail.com", "sytproje2016@gmail.com" , "qwert.12345");
            
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_WRITE);
            
            Message[] messages = emailFolder.getMessages();
            System.out.println(messages.length);
            
            File file = new File("C:\\Users\\Asus N56VZ\\workspace\\SytMailProje\\dosya.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bWriter = new BufferedWriter(fileWriter);
            
            for (int i = 0, n = messages.length; i < n; i++) {
                Message message = messages[i];
                
                /*System.out.println("---------------------------------");
                System.out.println("Email Number " + (i + 1));
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);*/
                Multipart multipart = (Multipart) message.getContent();
                BodyPart bodyPart = multipart.getBodyPart(0);
                
                String str = bodyPart.getContent().toString();
                String[] strDizi = str.split(":");
                String strbolme = strDizi[1];
                String[] strbolmeDizi = strbolme.split("-|\\n");
                
                for (int j = 0; j < strbolmeDizi.length; j++) {
                    System.out.println(" "+strbolmeDizi[j]);                
                }
                
                for(int k=1;k<strbolmeDizi.length;k++)
                {   
                	if(k==1){
                		bWriter.newLine();
                	}                	
                	bWriter.write(strbolmeDizi[k]+" ");
                    bWriter.write(strbolmeDizi[k+1]+" ");
                    bWriter.write("0");
                    if(k!=strbolmeDizi.length){
                    	bWriter.newLine();
                    }
                    k++;
                }                
                    
                String[] to = message.getFrom()[0].toString().split("<|>");
                sendSimpleMail(to[1]);                
            }
            bWriter.close();
            emailFolder.close(false);
            store.close();
        }catch(Exception e){
        	e.printStackTrace();
        }
		
	}
	
	public void sendSimpleMail(String toAddress){
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("sytproje2016@gmail.com", "qwert.12345");
                }
        });
        try{
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("sytproje2016@gmail.com"));
        
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));
        
        message.setSubject("Syt Proje Grubu Mesajýnýz Alýndý");
        message.setText("SYT Proje Grubunuz Listeye Eklenmiþtir.");
        Transport.send(message);
        }catch(MessagingException e){
        	throw new RuntimeException(e);
        }		
	}
}
