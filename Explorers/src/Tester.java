/**
 * ExpDriver.java -- Driver class for the Explorers game. 
 *
 * @author  Jeff Pittges
 * @version Jun-2011
 */
import java.sql.SQLException;

public class Tester {
	public static void main(String[] args) throws SQLException {

		// ExpDataSource ds = new ExpFile();
		ExpDataSource ds = new ExpDB();

		// Test the data source
		ds.test();
		ds.close();
	}
}