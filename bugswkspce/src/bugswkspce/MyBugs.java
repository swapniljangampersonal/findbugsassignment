package bugswkspce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MyBugs {
	String[] values = null;
	private void emptySynchronized() {
        synchronized (this) {
            // Forgot implementation
        }
    }
 
    /**
     * Sleep in synchronized.
     * 
     * @throws InterruptedException
     *             the interrupted exception
     */
    private void sleepInSynchronized() throws InterruptedException {
        synchronized (this) {
            Thread.sleep(5000);
        }
    }
    
 // Note that values is a String array in the code below.
    //
    public void setValues(String[] somevalues) {
            this.values = somevalues;
            String namesString = null;
            StringBuilder query = new StringBuilder();
            query.append( "select * from user u where u.name in (" + namesString + ")" );
            try {
            	Connection connection = DriverManager.getConnection(  
            			"jdbc:mysql://localhost:3306/sonoo","root","root");  ;
                PreparedStatement statement = connection.prepareStatement(query.toString());
                ResultSet resultSet = statement.executeQuery();
            } catch(Exception e) {
            	
            }
    }
    
    
}