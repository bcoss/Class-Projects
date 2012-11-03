/**
 * ExpFile.java -- implements a file-based data source for the Explorers game.
 *
 * @author  Jeff Pittges
 * @version Jun-2011
 */
import java.io.*;
import java.util.Scanner;

public class ExpFile implements ExpDataSource 
{
	private final String ROOM_FILENAME     = "room.csv";
	private final String EXPLORER_FILENAME = "explorer.csv";

    /**
     * getExplorer() -- retrieve the explorer 
     *
	 * @param username -- name of the player who controls this explorer 
     * @returns - An explorer, null if not found.
     */
    public Explorer getExplorer(String _username)
	{
		Explorer exp = null;

		try 
		{
			boolean found = false; 
			Scanner fileScan = new Scanner(new File(EXPLORER_FILENAME));
		
			while (fileScan.hasNext() && !found)
			{
		   	   Scanner lineScan = new Scanner(fileScan.nextLine());
	 		   lineScan.useDelimiter(",");

			   String username = lineScan.next();
			   int    expID    = lineScan.nextInt();
	 		   String expName  = lineScan.next();
	 		   int    roomNum  = lineScan.nextInt();

			   if (username.equals(_username))
			   {
				  found = true; 
	 		      exp = new Explorer(expID, expName, username, roomNum);
			   }
			}
		}
		catch (IOException exception) 
		{
		    System.out.println("Unable to open file " + EXPLORER_FILENAME);
		}

		return exp;
	}
    
    /**
     * getRoomDescr() -- returns a description of the given room 
     *
     * @param roomNum - number of the target room. 
     * @returns A string describing the given room, empty string if not found. 
     */
    public String getRoomDescr(int _roomNum)
	{
		String roomDescr = "";

		try
		{
			boolean found = false; 
			Scanner fileScan = new Scanner(new File(ROOM_FILENAME));
		
			while (fileScan.hasNext() && !found)
			{
		   	   Scanner lineScan = new Scanner(fileScan.nextLine());
	 		   lineScan.useDelimiter(",");

			   String name = lineScan.next();
			   String descr = lineScan.next();
			   int    roomNum  = lineScan.nextInt();
			   int    nextRoom = lineScan.nextInt();

			   if (roomNum == _roomNum)
			   {
				   roomDescr += "Room: " + roomNum;
				   roomDescr += " " + name + "\n";
				   roomDescr += descr + "\n";
			   }
			}
		}
	
		catch (IOException exception)
		{
		    System.out.println("Unable to open file " + ROOM_FILENAME);
		}
		return roomDescr; 
	}

    /**
     * move() -- move the given explorer to the next room.
     *  
	 * @param exp - the explorer to be moved 
     */
	public void move(Explorer exp)
	{
		int currRoom = exp.getRoomNum();

		// Get the connection from the explorer's current room 
		try
		{
			boolean found = false; 
			Scanner fileScan = new Scanner(new File(ROOM_FILENAME));
		
			while (fileScan.hasNext() && !found)
			{
		   	   Scanner lineScan = new Scanner(fileScan.nextLine());
	 		   lineScan.useDelimiter(",");

			   String name = lineScan.next();
			   String descr = lineScan.next();
			   int    roomNum  = lineScan.nextInt();
			   int    nextRoom = lineScan.nextInt();

			   // is this room the current room?  
			   if (roomNum == currRoom)
			   {
				  found = true; 
				  exp.setRoomNum(nextRoom);
			   }
			}
		}
	
		catch (IOException exception)
		{
		    System.out.println("Unable to open file " + ROOM_FILENAME);
		}
	}

	/**
	 * close() -- performs any cleanup before the program terminates. 
	 */
	public void close()
	{
	}

	public void test()
	{
	}
}


