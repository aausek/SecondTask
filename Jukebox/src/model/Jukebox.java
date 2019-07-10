package model;

import java.util.ArrayList;

import ennumerators.Genre;

/**
 * Class that models a Jukebox
 * @author Pedro Guillermo Feij�o-Garc�a
 */
public class Jukebox 
{

	//--------------------------------------------------------------------------
	// Constants
	// -------------------------------------------------------------------------

	/**
	 * Constant that models the maximum possible number of top hits
	 */
	public final static int TOP_HITS = 10;

	//--------------------------------------------------------------------------
	// Attributes
	// -------------------------------------------------------------------------

	/**
	 * Attribute that models the number of existing albums in the jukebox
	 */
	private int numberOfExistingAlbums;

	/**
	 * Attribute that models the number of existing hits in the jukebox
	 */
	private int numberOfExistingHits;

	//--------------------------------------------------------------------------
	// Relations: Structures
	// -------------------------------------------------------------------------

	/**
	 * Vector that models the albums in the jukebox
	 */
	private ArrayList<Album> albums;

	/**
	 * Array that models the albums in the jukebox
	 */
	private Song[] hits;

	//--------------------------------------------------------------------------
	// Methods
	// -------------------------------------------------------------------------

	/**
	 * Method that creates an object (instance) of the Jukebox class<br>
	 * <b>post: </b>An instance of type Jukebox has been created<br>
	 */
	public Jukebox()
	{
		numberOfExistingAlbums = 0;
		numberOfExistingHits = 0;
		hits = new Song[TOP_HITS];

		//TODO Initialize albums
		albums = new ArrayList<Album>();
	}

	/**
	 * Method that returns the number of existing albums<br>
	 * @return the number of existing albums
	 */
	public int getNumberOfExistingAlbums()
	{
		//TODO Complete this method
		return numberOfExistingAlbums;
	}

	/**
	 * Method that returns the number of existing hits<br>
	 * @return the number of existing hits
	 */
	public int getNumberOfExistingHits()
	{
		//TODO Complete this method
		return numberOfExistingHits;
	}

	/**
	 * Method that adds an album to the jukebox<br>
	 * <b>pre: </b>The vector of albums has already been initialized.<br>
	 * <b>post: </b>An album has been added to the jukebox.<br>
	 * @param pName name of the new album<br>
	 * @param pGenre genre of the new album<br>
	 * @param pPrice price of the new album. pPrice >= 0.0<br>
	 * @param pInterpreter interpreter of the new album. pInterpreter != null<br>
	 * @return true if the album is created. Otherwise it returns false
	 */
	public boolean addAlbum(String pName, Genre pGenre, double pPrice, Interpreter pInterpreter)
	{
		boolean response = false;

		//TODO Complete this method
		Album existingAlbum = searchAlbum(pName);

		if(existingAlbum == null) {

			Album album = new Album(pName, pGenre, pPrice, pInterpreter);
			albums.add(album);
			numberOfExistingAlbums++;
			response = true;
		}
		return response;
	}

	/**
	 * Method that searches for an album in the jukebox<br>
	 * <b>pre: </b>The vector of albums has already been initialized.<br>
	 * @param pName name of the album it will look for. pName != null<br>
	 * @return the album if it exists. Otherwise null
	 */
	public Album searchAlbum(String pName)
	{
		Album response = null;

		//TODO Complete this method
		for (int i = 0; i < albums.size() && response == null; i++) {

			Album currentAlbum = albums.get(i);
			if(currentAlbum.getName().equalsIgnoreCase(pName)) {

				response = currentAlbum;
			}
		}

		return response;
	}
	
	/**
	 * Method that searches for a song in an album<br>
	 * <b>pre: </b>The vector of songs has already been initialized.<br>
	 * @param pName name of the song it will look for. pName != null<br>
	 * @return the song if it exists. Otherwise null
	 */
	public Song searchSong(String pNameSong, String pNameAlbum) {
		
		Song currentSong = null;

		Album theAlbum = searchAlbum(pNameAlbum);

		if(theAlbum != null)
		{
			//TODO Complete this method
			currentSong = theAlbum.searchSong(pNameSong);
		}

		return currentSong;
	}

	/**
	 * Method that adds a song to an album in the jukebox<br>
	 * <b>pre: </b>The vector of albums has already been initialized.<br>
	 * <b>post: </b>A song has been added to the jukebox.<br>
	 * @param pName name of the song to be added. pName != null<br>
	 * @param pDuration name of the song to be added. pDuration >= 0<br>
	 * @param pNameAlbum name of the album in which the song will be added. pNameAlbum != null<br>
	 * @return true if the song was added. Otherwise false
	 */
	public boolean addSong(String pName, int pDuration, String pNameAlbum)
	{
		boolean response = false;

		//TODO Complete this method
		Album album = searchAlbum(pNameAlbum);

		if(album != null) {      
			
			response = album.addSong(pName, pDuration);
		}
		return response;
	}

	/**
	 * Method that returns the most expensive album in the jukebox<br>
	 * <b>pre: </b>The vector of albums has already been initialized.<br>
	 * @return the most expensive album in the jukebox. If there are no albums, it should return null
	 */
	public Album getMostExpensiveAlbum()
	{
		Album mostExpensiveAlbum = null;

		//TODO Complete this method
		double maxPrice = 0.0;

		for (int i = 0; i < albums.size(); i++) {

			Album mostExpensive = albums.get(i);

			if(mostExpensiveAlbum == null) {

				mostExpensiveAlbum = mostExpensive;
			}
			else if(mostExpensive.getPrice()>maxPrice) {

				mostExpensiveAlbum = mostExpensive;
			}	
		}
		return mostExpensiveAlbum;
	}

	/**
	 * Method that returns the least expensive album in the jukebox<br>
	 * <b>pre: </b>The vector of albums has already been initialized.<br>
	 * @return the least expensive album in the jukebox. If there are no albums, it should return null
	 */
	public Album getLeastExpensiveAlbum()
	{
		Album leastExpensiveAlbum = null;

		//TODO Complete this method
		double minPrice = Integer.MAX_VALUE;

		for (int i = 0; i < albums.size(); i++) {

			Album leastExpensive = albums.get(i);

			if(leastExpensiveAlbum == null) {

				leastExpensiveAlbum = leastExpensive;
			}
			else if(leastExpensive.getPrice()<minPrice) {

				leastExpensiveAlbum = leastExpensive;
			}	
		}
		return leastExpensiveAlbum;
	}

	/**
	 * Method that returns the longest song of an existing album in the Jukebox<br>
	 * <b>pre: </b>The vector of albums has already been initialized.<br>
	 * @param pName name of the album of interest. pName != null <br>
	 * @return the longest song in the album in the Jukebox. If there are no albums, it should return null
	 */
	public Song getLongestSongInAlbum(String pName)
	{
		Song longestSong = null;

		Album theAlbum = searchAlbum(pName);

		if(theAlbum != null)
		{
			//TODO Complete this method
			longestSong = theAlbum.getLongestSong();
		}

		return longestSong;
	}

	/**
	 * Method that removes an album from the Jukebox<br>
	 * <b>pre: </b>The vector of albums has already been initialized.<br>
	 * <b>post: </b>An album has been removed from the Jukebox.<br>
	 * @param pName name of the album to remove. pName != null<br>
	 * @return true if the album was successfully removed. Otherwise false.
	 */
	public boolean removeAlbum(String pName)
	{
		boolean response = false;

		//TODO Complete this method
		for (int i = 0; i < albums.size() && response == false; i++) {

			Album searchedAlbum = albums.get(i);

			if(searchedAlbum != null) {
				
				albums.remove(i);
				numberOfExistingAlbums--;
				response = true;
			}	
		}
		return response;
	}

	/**
	 * Method that removes a song from an album in the jukebox<br>
	 * <b>pre: </b>The vector of albums has already been initialized.<br>
	 * <b>post: </b>A song has been removed from the jukebox.<br>
	 * @param pNameSong name of the song to remove. pNameSong != null<br>
	 * @param pNameAlbum name of the album to remove the song from. pNameAlbum != null<br>
	 * @return true if the song was successfully removed. Otherwise false.
	 */
	public boolean removeSongFromAlbum(String pNameSong, String pNameAlbum)
	{
		boolean response = false;
		
		Album album = searchAlbum(pNameAlbum);
		
		//TODO Complete this method
			if(album != null && album.getName().equals(pNameAlbum))
			{
				response = album.removeSong(pNameSong);
				response = true;
			}

		return response;
	}

	/**
	 * Method that searches for a hit in the jukebox<br>
	 * <b>pre: </b>The array of hits has already been initialized.<br>
	 * @param pName name of the hit. pName != null <br>
	 * @return the hit (type Song) if it exists. Otherwise it returns null
	 */
	public Song searchHit(String pName)
	{
		Song response = null;

		//TODO Complete this method
		for(int i = 0; i < hits.length; i++) {

			Song hit = hits[i];
			
			if(hit != null && hit.getName().equalsIgnoreCase(pName)) {

				response = hit;
			}
		}
		return response;
	}

	/**
	 * Method that adds an existing song to the array of hits in the jukebox<br>
	 * <b>pre: </b>The array of hits has already been initialized.<br>
	 * <b>pre: </b>The vector of albums has already been initialized.<br>
	 * <b>post: </b>A song has been added to the array of hits in the jukebox.<br>
	 * @param pNameSong name of the song that will be added to the hits array. pNameSong != null <br>
	 * @param pNameAlbum name of the album that has the song to be added to the array of hits. pNameAlbum != null <br>
	 * @return true if it was successfully added. Otherwise false
	 */
	public boolean addHit(String pNameSong, String pNameAlbum)
	{
		boolean response = false;

		Album myAlbum = searchAlbum(pNameAlbum);

		if(myAlbum != null)
		{
			Song hitToAdd = myAlbum.searchSong(pNameSong);
			Song currentHit = searchHit(pNameSong);
					
			if(currentHit == null && numberOfExistingHits < TOP_HITS) {
			//TODO Complete this method
			hits[numberOfExistingHits+1] = hitToAdd;
			numberOfExistingHits++;
			response = true;
			}
		}

		return response;
		
	}

	/**
	 * Method that removes a song from the array of hits in the jukebox<br>
	 * <b>pre: </b>The array of hits has already been initialized.<br>
	 * <b>post: </b>A song has been removed from the array of hits in the jukebox.<br>
	 * @param pName name of the song to be removed. pName != null<br>
	 * @return true if the song was successfully removed from the array of hits. Otherwise false
	 */
	public boolean removeHit(String pName)
	{
		boolean response = false;

		Song hitToRemove = searchHit(pName);

		//TODO Complete this method
		for (int i = 0; i < hits.length; i++) {

			if(hits[i] != null && hits[i].equals(hitToRemove)) {

				hits[i] = null;
				numberOfExistingHits--;
				response = true;
			} 
		}

		return response;
	}

	/**
	 * Method that returns the longest song in the array of hits<br>
	 * <b>pre: </b>The array of hits has already been initialized.<br>
	 * @return the longest song of the array of hits. If there are no songs, returns null.
	 */
	public Song getLongestHit()
	{
		Song longest = null;

		for (int i = 0; i < hits.length; i++) 
		{
			Song current = hits[i];

			if(longest == null)
			{
				longest = current;
			}

			else if(current != null && current.getDuration() > longest.getDuration())
			{
				longest = current;
			}
		}

		return longest;
	}

	/**
	 * Method that returns the shortest song in the array of hits<br>
	 * <b>pre: </b>The array of hits has already been initialized.<br>
	 * @return the shortest song of the array of hits. If there are no songs, returns null.
	 */
	public Song getShortestHit()
	{
		Song shortest = null;

		//TODO Complete this method
		for (int i = 0; i < hits.length; i++) {

			Song current = hits[i];

			if(shortest == null) {

				shortest = current;
				
			} else if(current != null && current.getDuration() < shortest.getDuration()) {

				shortest = current;
			}
		}

		return shortest;
	}

}
