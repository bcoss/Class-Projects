/**
 * ExpDataSource.java -- interface for accessing data for the Explorer's game.
 *
 * @author  Jeff Pittges
 * @version Jun-2011
 */
public interface ExpDataSource
{
	/**
	 * getExplorer() -- retrieve the explorer 
	 *
	 * @param username -- name of the player who controls this explorer 
	 * @returns - An explorer, null if not found.
	 */
	public Explorer getExplorer(String username);
	
	/**
	 * getRoomDescr() -- returns a description of the given room 
	 *
	 * @param roomNum - number of the target room. 
	 * @returns A string describing the given room, empty string if not found. 
	 */
	public String getRoomDescr(int roomNum);

    /**
     * move() -- move the given explorer to the next room.
     *  
	 * @param exp -- the explorer to be moved 
     */
	public void move(Explorer exp); 

	/**
	 * close() -- performs any cleanup before the program terminates. 
	 */
	public void close(); 

	public void test(); 
}


