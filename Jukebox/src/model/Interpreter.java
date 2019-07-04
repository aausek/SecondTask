package model;

import ennumerators.Region;

/**
 * TODO Complete documentation - check Jukebox class
 */
public class Interpreter
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
	private String surname;
	
	/**
	 * TODO Complete documentation - check Jukebox class
	 */
	private int age;
	
	//--------------------------------------------------------------------------
	// Relations: Enumerators
	// -------------------------------------------------------------------------
	
	/**
	 * TODO Complete documentation - check Jukebox class
	 */
	private Region region;
	

	//--------------------------------------------------------------------------
	// Methods
	// -------------------------------------------------------------------------
	
	/**
	 * TODO Complete documentation - check Jukebox class
	 */
	public Interpreter(String pName, String pSurname, int pAge, Region pRegion)
	{
		name = pName;
		surname = pSurname;
		age = pAge;
		region = pRegion;
	}

	
	/**
	 * TODO Complete documentation - check Jukebox class
	 */
	public String getName() {
		return name;
	}

	/**
	 * TODO Complete documentation - check Jukebox class
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * TODO Complete documentation - check Jukebox class
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * TODO Complete documentation - check Jukebox class
	 */
	public Region getRegion() {
		return region;
	}
	
	
}
