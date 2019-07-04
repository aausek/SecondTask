package model;

/**
 * TODO Complete documentation - check Jukebox class
 */
public class Song 
{
	
	//--------------------------------------------------------------------------
	// Attributes
	// -------------------------------------------------------------------------
	
	/**
	 * TODO Complete documentation - check Jukebox class
	 * Attribute that models song name 
	 */
	private String name;
	
	/**
	 * TODO Complete documentation - check Jukebox class
	 * Attribute that models song duration
	 */
	private int duration;
	
	//--------------------------------------------------------------------------
	// Methods
	// -------------------------------------------------------------------------
	
	/**
	 * TODO Complete documentation - check Jukebox class
	 * Method that creates an instance of Song class
	 * @param pName of the new song
	 * @param pDuration of the new song
	 */
	public Song(String pName, int pDuration)
	{
		name = pName;
		duration = pDuration;
	}

	/**
	 * TODO Complete documentation - check Jukebox class
	 * Method that returns the song name
	 * @return the song name 
	 */
	public String getName() 
	{
		return name;
	}


	/**
	 * TODO Complete documentation - check Jukebox class
	 * Method that returns song duration
	 * @return the song duration
	 */
	public int getDuration() 
	{
		return duration;
	}
	
	
	
}
