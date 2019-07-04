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
	 */
	public static final int NUMBER_SONGS = 12;
	
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
	private double price;
	
	/**
	 * TODO Complete documentation - check Jukebox class
	 */
	private int numberOfExistingSongs;
	
	/**
	 * TODO Complete documentation - check Jukebox class
	 */
	private Interpreter interpreter;
	
	//--------------------------------------------------------------------------
	// Relations: Enumerators
	// -------------------------------------------------------------------------
	
	/**
	 * TODO Complete documentation - check Jukebox class
	 */
	private Genre genre;
	
	//--------------------------------------------------------------------------
	// Relations: Structures
	// -------------------------------------------------------------------------
	
	/**
	 * TODO Complete documentation - check Jukebox class
	 */
	private ArrayList<Song> songs;
	
	//--------------------------------------------------------------------------
	// Methods
	// -------------------------------------------------------------------------
	/**
	 * TODO Complete documentation - check Jukebox class
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
		}
		
		return response;
	}
	
	/**
	 * TODO Complete documentation - check Jukebox class
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
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * TODO Complete documentation - check Jukebox class
	 */
	public Genre getGenre() 
	{
		return genre;
	}

	/**
	 * TODO Complete documentation - check Jukebox class
	 */
	public double getPrice() 
	{
		return price;
	}

	/**
	 * TODO Complete documentation - check Jukebox class
	 */
	public int getNumberOfExistingSongs() 
	{
		return numberOfExistingSongs;
	}

	/**
	 * TODO Complete documentation - check Jukebox class
	 */
	public Interpreter getInterpreter() 
	{
		return interpreter;
	}
	
	
}
