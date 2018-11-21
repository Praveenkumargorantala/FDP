package com.epam.bean;

import javax.servlet.http.Part;

public class IDProofBean {

	private String emailId;
	private String idProofName;
	//private byte[] image;
	Part filePart;
	
	
	public IDProofBean(String emailId, String idProofName, Part filePart) {
		super();
		this.emailId = emailId;
		this.idProofName = idProofName;
		this.filePart = filePart;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getIdProofName() {
		return idProofName;
	}
	public void setIdProofName(String idProofName) {
		this.idProofName = idProofName;
	}
	public Part getFilePart() {
		return filePart;
	}
	public void setFilePart(Part filePart) {
		this.filePart = filePart;
	}
	
	/*public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}*/
	
	
}


