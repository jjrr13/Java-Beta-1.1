package demoproyecto;

 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Seisa
 */
public class ConexionBD {
    Connection con;
    Statement st;
    
    public ConexionBD(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/demoproyecto", "root", "");
            st= con.createStatement();
        } catch (Exception ex) {
            Logger.getLogger(Estudiantes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modificaBD(String Sql){
        try {
            st.executeUpdate(Sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet consultaBD(String Sql){
        ResultSet rsTemp= null;
        
        try { 
            rsTemp= st.executeQuery(Sql);
                    } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rsTemp;
    }
}

