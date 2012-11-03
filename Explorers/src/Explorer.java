
/**
 * Represents a single explorer in the Explorer's game.
 * 
 * @author  Jeff Pittges 
 * @version Jun-2011
 */
public class Explorer
{
    // instance variables 
	private int		 expID;			// unique identifier for this explorer 
    private String   expName;		// the name of this explorer 
	private String	 username;		// username of the player who controls this explorer 
	private int		 roomNum;		// number of the room the explorer is in 

    /**
     * Constructs one Explorer 
     */
    public Explorer(int _expID, String _expName, String _username, int _roomNum)
    {
        // initialize instance variables
		this.expID    = _expID;
        this.expName  = _expName; 
		this.roomNum  = _roomNum; 
		this.username = _username;
    }

	public int getRoomNum()
	{
		return this.roomNum;
	}

	public void setRoomNum(int _roomNum)
	{
		this.roomNum = _roomNum; 
	}

	public int getExpID()
	{
		return this.expID; 
	}

    public String toString()
    {
        String explorer = "";
        explorer += "Explorer: " + this.expName + "\n";
        
        return explorer;
    }
}



















