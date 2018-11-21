package com.epam.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;




import com.epam.bean.IDProofBean;
import com.epam.dao.IDProofDAO;
import com.epam.dbconnection.DatabaseConnection;

public class IDProofDAOImpl implements IDProofDAO {

	Connection connection = DatabaseConnection.getConnection();
	
	PreparedStatement preparedStatement = null;
	
	@Override
	public boolean updateIDProof(IDProofBean idProofBean) {
		
		try
		{
			 // constructs SQL statement
            String sql = "update idproof set image=? where emailid=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setBlob(1, idProofBean.getFilePart().getInputStream());
            statement.setString(2, idProofBean.getEmailId());
             
           /* if (idProofBean.getFilePart().getInputStream() != null) {
                // fetches input stream of the upload file for the blob column
                statement.setBlob(3, idProofBean.getFilePart().getInputStream());
            }*/
 
            // sends the statement to the database server
            int row = statement.executeUpdate();
            if (row > 0) {
                return true;
            }
            else
            {
            	return false;
            }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

}
