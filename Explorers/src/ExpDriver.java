/**
 * ExpDriver.java -- Driver class for the Explorers game. 
 *
 * @author  Jeff Pittges
 * @version Jun-2011
 */
import java.sql.SQLException;
import java.util.Scanner;

public class ExpDriver {
	public static void main(String[] args) throws SQLException {
		final int END_ROOM = -1; // designates an end room

		// ExpDataSource ds = new ExpFile();
		ExpDataSource ds = new ExpDB();

		// Test the data source
		ds.test();

		/********************/
		/* Get the Explorer */
		/********************/
		Scanner scan = new Scanner(System.in);

		// prompt for the player's username
		System.out.print("\nEnter username: ");
		String username = scan.next();

		Explorer exp = null;
		try {
			exp = ds.getExplorer(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// describe the explorer
		if (exp != null)
			System.out.println("\n" + exp);
		else
			System.out.println("\nExplorer for " + username + " not found\n");

		/*****************/
		/* Play the game */
		/*****************/
		System.out.println(exp.getRoomNum());
		// move through all of the rooms
		while (exp.getRoomNum() != END_ROOM) {

			// describe the explorer's room
			System.out.println(ds.getRoomDescr(exp.getRoomNum()));
			System.out.println("Move Forward? y/n");

			if (scan.next() == "y") {
				// move the explorer to the next room
				ds.move(exp);
			}

		}

		// close the data source
		ds.close();
	}
}