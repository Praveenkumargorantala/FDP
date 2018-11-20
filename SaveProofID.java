package com.epam.test;

import java.io.File;
import java.io.FileInputStream;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.epam.domain.IDProofPojo;

public class SaveProofID {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration cfg = null;
		SessionFactory factory = null;
		Session ses = null;
		cfg = new Configuration();
		cfg = cfg.configure("/com/epam/cfgs/Hibernate.cfg.xml");
		factory = cfg.buildSessionFactory();
		ses = factory.openSession();
		
		IDProofPojo id = new IDProofPojo();
		id.setEmailId("raju@gmail.com");
		id.setIdProofName("VoterID");
		
		File file = new File("C:\\mavan-hibernate-image-mysql.gif");
        byte[] bFile = new byte[(int) file.length()];
        
        try {
	     FileInputStream fileInputStream = new FileInputStream(file);
	     //convert file into array of bytes
	     fileInputStream.read(bFile);
	     fileInputStream.close();
        } catch (Exception e) {
	     e.printStackTrace();
        }
        ses.beginTransaction();
        id.setImage(bFile);
        
        ses.save(id);
        ses.close();
        factory.close();
        
        
		
				
		
	}

}
