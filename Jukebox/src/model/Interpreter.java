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
	 * Attribute that models interpreter name
	 */
	private String name;
	
	/**
	 * TODO Complete documentation - check Jukebox class
	 * Attribute that models interpreter surname
	 */
	private String surname;
	
	/**
	 * TODO Complete documentation - check Jukebox class
	 * Attribute that models interpreter age
	 */
	private int age;
	
	//--------------------------------------------------------------------------
	// Relations: Enumerators
	// -------------------------------------------------------------------------
	
	/**
	 * TODO Complete documentation - check Jukebox class
	 * Enum that models the interpreter region 
	 */
	private Region region;
	

	//--------------------------------------------------------------------------
	// Methods
	// -------------------------------------------------------------------------
	
	/**
	 * TODO Complete documentation - check Jukebox class
	 * Method that creates a new instance of interpreter
	 * @param pName name of interpreter
	 * @param pSurname surname of interpreter
	 * @param pAge age of interpreter
	 * @param pRegion region of interpreter
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
	 * Method that returns interpreter name
	 * @return interpreter name
	 */
	public String getName() {
		return name;
	}

	/**
	 * TODO Complete documentation - check Jukebox class
	 * Method that returns interpreter surname
	 * @return interpreter surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * TODO Complete documentation - check Jukebox class
	 * Method that returns interpreter age
	 * @return interpreter age
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * TODO Complete documentation - check Jukebox class
	 * Method that returns interpreter region
	 * @return interpreter region
	 */
	public Region getRegion() {
		return region;
	}
	
	
}
