/**
 * ExpDB.java -- implements a database data source for the Explorers game.
 *
 * @author  Jeff Pittges
 * @version Jun-2011
 */
import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class ExpDB implements ExpDataSource 
{
	Connection conn = null; 

    /**
     * getExplorer() -- retrieve the explorer 
     *
	 * @param username -- name of the player who controls this explorer
     * @returns - An explorer, null if not found.
     */
	public Explorer getExplorer(String username)
	{
		Explorer exp = null;

		return exp;
	}
    
	/**
     * getRoomDescr() -- returns a description of the given room 
     *
     * @param roomNum - number of the target room. 
     * @returns A string describing the given room, empty string if not found. 
     */
    public String getRoomDescr(int roomNum)
	{
		String roomDescr = ""; 

		return roomDescr; 
	}

	/**
     * move() -- move the given explorer to the next room.
     *  
     * @param exp -- the explorer to be moved 
     */
    public void move(Explorer exp)
	{
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


