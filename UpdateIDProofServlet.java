package com.epam.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
@MultipartConfig
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
		System.out.println("in doGet()");
		doPost(request, response);
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("in doPost()");
		response.setContentType("text/html"); 
	    PrintWriter out = response.getWriter();
	    
	    String emailID = request.getParameter("emailID"); 
		  String typeOfIDProof = request.getParameter("typeOfIdProof");
		  
		  System.out.println("emailID="+emailID);
		  System.out.println("typeOfIDProof="+typeOfIDProof);
		  System.out.println("part="+ request.getPart("idProof"));
		  InputStream inputStream = null; // input stream of the upload file
	         
	        // obtains the upload file part in this multipart request
	        Part filePart = request.getPart("idProof");
	        System.out.println(filePart);
	        if (filePart != null) {
	            // prints out some information for debugging
	            System.out.println(filePart.getName());
	            System.out.println(filePart.getSize());
	            System.out.println(filePart.getContentType());
	             
	            // obtains input stream of the upload file
	            inputStream = filePart.getInputStream();
	            
	            System.out.println("in UpdateIDProofServlet: before create object of IDProofBean");
	            IDProofBean idProofBean = new IDProofBean(emailID,typeOfIDProof,filePart);
	            IDProofDAO  idProofDAO= new IDProofDAOImpl();
	            
	            if(idProofDAO.updateIDProof(idProofBean)) {
	                //out.println("IDProof has been successfully updated");
	            	response.sendRedirect("UpdateSucess.jsp");
	            } 
	            else { 
	                //out.println("IDProof could not be updated");
	            	response.sendRedirect("UpdateFailure.jsp");
	                
	            }
	        }
	}

}
