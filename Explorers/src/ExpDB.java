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
	Connection conn = null;
	public String nickname, username;
	public int EID;
	Explorer exp;

	public ExpDB() throws SQLException {
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

		String user, pass, query;
		user = "jcoss";
		pass = "nikebial";
		query = "select * from explorer";

		try {
			// Connection conn =
			// DriverManager.getConnection("jdbc:oracle:thin:@Picard.radford.edu:1521:teaching",
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@Picard2.radford.edu:1521:itec2", user,
					pass);
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while (rset.next()) {
				System.out.println(rset.getString("EID") + "  "
						+ rset.getString("name") + "  "
						+ rset.getString("username"));

				this.EID = rset.getInt("EID");
				this.nickname = rset.getString("name");
				this.username = rset.getString("username");

			}

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
	public Explorer getExplorer(String s) {

		exp = new Explorer(EID, nickname, username, 0);
		System.out.println(exp.toString());

		return exp;
	}

	/**
	 * getRoomDescr() -- returns a description of the given room
	 * 
	 * @param roomNum
	 *            - number of the target room.
	 * @returns A string describing the given room, empty string if not found.
	 */
	public String getRoomDescr(int roomNum) {
		String roomDescr = "";

		return roomDescr;
	}

	/**
	 * move() -- move the given explorer to the next room.
	 * 
	 * @param exp
	 *            -- the explorer to be moved
	 */
	public void move(Explorer exp) {
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
	}
}
