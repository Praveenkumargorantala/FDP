package com.epam.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.epam.bean.IDProofBean;
import com.epam.daoimpl.IDProofDAOImpl;
import com.epam.dao.IDProofDAO;

/**
 * Servlet implementation class UpdateIDProofServlet
 */
public class UpdateIDProofServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateIDProofServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html"); 
	    PrintWriter out = response.getWriter();
	    
	    String emailID = request.getParameter("emailID"); 
		  String typeOfIDProof = request.getParameter("typeOfIDProof");
		  
		  InputStream inputStream = null; // input stream of the upload file
	         
	        // obtains the upload file part in this multipart request
	        Part filePart = request.getPart("photo");
	        if (filePart != null) {
	            // prints out some information for debugging
	            System.out.println(filePart.getName());
	            System.out.println(filePart.getSize());
	            System.out.println(filePart.getContentType());
	             
	            // obtains input stream of the upload file
	            inputStream = filePart.getInputStream();
	            
	            IDProofBean idProofBean = new IDProofBean(emailID,typeOfIDProof,filePart);
	            IDProofDAO  idProofDAO= new IDProofDAOImpl();
	            
	            if(idProofDAO.updateIDProof(idProofBean)) {
	                out.println("IDProof has been successfully updated"); 
	            } 
	            else { 
	                out.println("IDProof could not be updated");
	            }
	        }
	}

}
