package model;

import java.util.ArrayList;

import ennumerators.Genre;

/**
 * TODO Complete documentation - check Jukebox class
 */
public class Album 
{
	//--------------------------------------------------------------------------
	// Constants
	// -------------------------------------------------------------------------
	/**
	 * TODO Complete documentation - check Jukebox class
	 * 
	 * *****IGNORE THIS?******
	 * 
	 */
	public static final int NUMBER_SONGS = 12;

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
	 * Attribute that models song price
	 */
	private double price;

	/**
	 * TODO Complete documentation - check Jukebox class
	 * Attribute that models number of existing songs
	 */
	private int numberOfExistingSongs;

	/**
	 * TODO Complete documentation - check Jukebox class
	 * Attribute that models interpreter class
	 */
	private Interpreter interpreter;

	//--------------------------------------------------------------------------
	// Relations: Enumerators
	// -------------------------------------------------------------------------

	/**
	 * TODO Complete documentation - check Jukebox class
	 * Enum that models song genre in Jukebox
	 */
	private Genre genre;

	//--------------------------------------------------------------------------
	// Relations: Structures
	// -------------------------------------------------------------------------

	/**
	 * TODO Complete documentation - check Jukebox class
	 * Vector that models the songs in Jukebox
	 */
	private ArrayList<Song> songs;

	//--------------------------------------------------------------------------
	// Methods
	// -------------------------------------------------------------------------
	/**
	 * TODO Complete documentation - check Jukebox class
	 * Method that creates an instance of Album
	 * @param pName name of new album<br>
	 * @param pGenre genre of new album<br>
	 * @param pPrice price of new album<br>
	 * @param pInterpreter interpreter of new album. pInterpreter != null<br>
	 */
	public Album(String pName, Genre pGenre, double pPrice, Interpreter pInterpreter)
	{
		name = pName;
		genre = pGenre;
		price = pPrice;
		interpreter = pInterpreter;
		numberOfExistingSongs = 0;

		songs = new ArrayList<Song>();
	}

	/**
	 * TODO Complete documentation - check Jukebox class
	 * Method created an instance of song
	 * <b>pre: </b>The vector of songs has already been initialized.<br>
	 * <b>post: </b>A song has been added to the Jukebox.<br>
	 * @param pName name of new song
	 * @param pDuration duration of new song
	 * @return true if song is created, otherwise returns false
	 */
	public boolean addSong(String pName, int pDuration)
	{
		boolean response = false;

		Song existingSong = searchSong(pName);

		if(existingSong == null)
		{
			Song song = new Song(pName, pDuration);
			songs.add(song);
			numberOfExistingSongs++;
			response = true;
		}

		return response;
	}

	/**
	 * TODO Complete documentation - check Jukebox class
	 * Method that searches for a song in Jukebox<br>
	 * <b>pre: </b>The vector of songs has already been initialized.<br>
	 * @param pName name of song used in the search. pName != null<br>
	 * @return the song name if it exists, otherwise null
	 */
	public Song searchSong(String pName)
	{
		Song response = null;

		for (int i = 0; i < songs.size() && response == null; i++) 
		{
			Song currentSong = songs.get(i);
			if(currentSong.getName().equals(pName))
			{
				response = currentSong;
			}
		}

		return response;
	}

	/**
	 * TODO Complete documentation - check Jukebox class
	 * Method that searches for the longest song in Jukebox<br>
	 * <b>pre: </b>The vector of songs has already been initialized.<br>
	 * @return longest song if it exists
	 */
	public Song getLongestSong()
	{
		Song longest = null;

		for (int i = 0; i < songs.size(); i++) 
		{
			Song current = songs.get(i);
			if(longest == null)
			{
				longest = current;
			}
			else if(current.getDuration()>longest.getDuration())
			{
				longest = current;
			}
		}

		return longest;
	}

	/**
	 * TODO Complete documentation - check Jukebox class
	 * Method that removes a song from Jukebox<br>
	 * <b>pre: </b>The vector of songs has already been initialized.<br>
	 * <b>post: </b>A song has been removed from the Jukebox.<br>
	 * @param pName name of song to be removed <br>
	 * @return true if song is successfully removed, otherwise returns false
	 */
	public boolean removeSong(String pName)
	{
		boolean response = false;

		for (int i = 0; i < songs.size() && response == false; i++) 
		{
			Song current = songs.get(i);
			if(current.getName().equals(pName))
			{
				songs.remove(i);
				response = true;
			}
		}

		return response;
	}


	/**
	 * TODO Complete documentation - check Jukebox class
	 * Method that returns album name
	 * @return album name
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * TODO Complete documentation - check Jukebox class
	 * Method that returns genre enum
	 * @return album genre
	 */
	public Genre getGenre() 
	{
		return genre;
	}

	/**
	 * TODO Complete documentation - check Jukebox class
	 * Method that returns album price
	 * @return album price
	 */
	public double getPrice() 
	{
		return price;
	}

	/**
	 * TODO Complete documentation - check Jukebox class
	 * Method that returns number of existing songs
	 * @return number of existing songs
	 */
	public int getNumberOfExistingSongs() 
	{
		return numberOfExistingSongs;
	}

	/**
	 * TODO Complete documentation - check Jukebox class
	 * Method that returns interpreter object
	 * @return interpreter instance
	 */
	public Interpreter getInterpreter() 
	{
		return interpreter;
	}


}
