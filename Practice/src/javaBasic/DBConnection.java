/**
 * 
 */
package javaBasic;

import java.sql.*;

import javax.swing.plaf.synth.SynthSeparatorUI;

/**
 * @author A1SKIVA4
 *
 */
public class DBConnection {
	
	public static void main(String []args) {
		
		try {
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3036/emp","root","root");
			Statement stm = con.createStatement();
			ResultSet rs  = stm.executeQuery("Select * from emp");
			if(rs.next()) {
				rs.getString(0);
				rs.getString(1);
			}
	System.out.println(rs);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
