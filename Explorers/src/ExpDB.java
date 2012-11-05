/**
 * ExpDB.java -- implements a database data source for the Explorers game.
 *
 * @author  Jeff Pittges
 * @version Jun-2011
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExpDB implements ExpDataSource {
	String user = "jcoss";
	String pass = "nikebial";
	Connection conn;

	public ExpDB() {
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			// Connection conn =
			// DriverManager.getConnection("jdbc:oracle:thin:@Picard.radford.edu:1521:teaching",
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@Picard2.radford.edu:1521:itec2", user,
					pass);

		} catch (SQLException e) {
			System.out.println("Could not load the db" + e);
		}

	}

	/**
	 * getExplorer() -- retrieve the explorer
	 * 
	 * @param username
	 *            -- name of the player who controls this explorer
	 * @returns - An explorer, null if not found.
	 */
	public Explorer getExplorer(String username) {
		Explorer exp = null;
		String userName = "";
		String name = "";
		int room = 0;
		int EID = 0;

		String query = "select * from explorer where Username = '" + username
				+ "'";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while (rset.next()) {
				userName = rset.getString("Username");
				name = rset.getString("Name");
				EID = rset.getInt("EID");
				room = rset.getInt("Room");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Explorer(EID, name, userName, room);
	}

	/**
	 * getRoomDescr() -- returns a description of the given room
	 * 
	 * @param roomNum
	 *            - number of the target room.
	 * @returns A string describing the given room, empty string if not found.
	 */
	public String getRoomDescr(int roomNum) {

		String query = "select Descr from room where RID = '" + roomNum + "'";

		String description = "null value";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(query);

			while (rset.next()) {
				description = rset.getString("Descr");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return description;
	}

	/**
	 * move() -- move the given explorer to the next room.
	 * 
	 * @param exp
	 *            -- the explorer to be moved
	 */
	public void move(Explorer exp) {
		String query = "Select next from Room a INNER JOIN explorer b "
				+ "ON a.RID = b.Room " + "where EID = '" + exp.getExpID() + "'";

		int next_room = 0;
		try {

			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(query);

			while (rset.next()) {
				next_room = rset.getInt("next");
			}

			String DML = "UPDATE explorers SET room = " + next_room
					+ " WHERE EID = '" + exp.getExpID() + "'";
			int rowsUpdated = stmt.executeUpdate(DML);

			if (rowsUpdated == 1) {
				System.out.println("Successful move.");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * close() -- performs any cleanup before the program terminates.
	 */
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void test() {
		String query = "select * from explorer";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while (rset.next()) {
				System.out.println(rset.getString("EID") + "  "
						+ rset.getString("Username"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
