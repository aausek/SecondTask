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
	 */
	private String name;
	
	/**
	 * TODO Complete documentation - check Jukebox class
	 */
	private int duration;
	
	//--------------------------------------------------------------------------
	// Methods
	// -------------------------------------------------------------------------
	
	/**
	 * TODO Complete documentation - check Jukebox class
	 */
	public Song(String pName, int pDuration)
	{
		name = pName;
		duration = pDuration;
	}

	/**
	 * TODO Complete documentation - check Jukebox class
	 */
	public String getName() 
	{
		return name;
	}


	/**
	 * TODO Complete documentation - check Jukebox class
	 */
	public int getDuration() 
	{
		return duration;
	}
	
	
	
}
