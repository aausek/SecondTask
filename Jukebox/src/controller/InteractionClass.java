package controller;

import java.util.Scanner;

import model.Album;
import model.Interpreter;
import model.Jukebox;
import model.Song;
import ennumerators.Genre;
import ennumerators.Region;// Do we need this?

/**
 * Class that models the interaction window with the user.
 * @author Pedro Guillermo Feij�o-Garc�a
 */
public class InteractionClass 
{
	/**
	 * Main method of the application. It controls the execution of the program.
	 * @param args arguments input by the Java Virtual Machine and the environment.
	 */
	public static void main(String[] args) 
	{
		Jukebox model = new Jukebox();
		Scanner input = new Scanner(System.in);

		System.out.println("Welcome to JukeboxApp!");

		boolean continueExecution = true;
		while(continueExecution == true)
		{
			System.out.println("Please select one of the following actions:");
			System.out.println("Add a new album [1]");
			System.out.println("Add a new song to an existing album [2]");
			System.out.println("Add a new hit [3]");
			System.out.println("Search for an existing album [4]");
			System.out.println("Search for a song in an album [5]");
			System.out.println("Search for a hit [6]");
			System.out.println("Delete an album [7]");
			System.out.println("Delete a song from an existing album [8]");
			System.out.println("Delete a hit [9]");
			System.out.println("Retrieve the most expensive album [10]");
			System.out.println("Retrieve the least expensive album [11]");
			System.out.println("Retrieve the longest song in an existing album [12]");
			System.out.println("Retrieve longest hit [13]");
			System.out.println("Retrieve shortest hit [14]");
			System.out.println("Retrieve the number of existing albums [15]");
			System.out.println("Retrieve the number of existing hits [16]");


			String txtResponse = input.nextLine();
			int response = Integer.parseInt(txtResponse);

			//TODO Complete this method for each functional requirement

			//Add new album
			if(response == 1) {

				System.out.println("Please enter the interpreter first name");
				String nameInterpreter = input.nextLine();
				System.out.println("Please enter the interpreter last name");
				String surnameInterpreter = input.nextLine();
				System.out.println("Please enter the interpreter's age");
				String txtAge = input.nextLine();
				int ageInterpreter = Integer.parseInt(txtAge);
				System.out.println("Please enter the interpreter's region(1-6): 1-AFRICA, 2-ASIA, 3-AUSTRALIA, 4-EUROPE, 5-NORTH_AMERICA or 6-SOUTH_AMERICA");
				String txtRegion = input.nextLine();
				int inputRegion = Integer.parseInt(txtRegion);
				Region region = null; // Should display all region options

				if(inputRegion == 1) {

					region = Region.AFRICA;
				}
				else if(inputRegion == 2) {

					region = Region.ASIA;
				}
				else if(inputRegion == 3) {

					region = Region.AUSTRALIA;
				}
				else if(inputRegion == 4) {

					region = Region.EUROPE;
				}
				else if(inputRegion == 5) {

					region = Region.NORTH_AMERICA;
				}
				else if(inputRegion == 6) {

					region = Region.SOUTH_AMERICA;
				}

				Interpreter interpreter = new Interpreter(nameInterpreter, surnameInterpreter, ageInterpreter, region);

				System.out.println("Please enter album name");
				String nameAlbum = input.nextLine();
				System.out.println("Please enter album genre(1-5): 1-CLASSICAL, 2-GOSPEL, 3-HIPHOP, 4-RNB or 5-SALSA");
				String txtGenre = input.nextLine();
				int inputGenre = Integer.parseInt(txtGenre);
				Genre genre = null; // Should display all genre options
				System.out.println("Please enter album price");
				String txtPrice = input.nextLine();
				double priceAlbum = Double.parseDouble(txtPrice);

				if(inputGenre == 1) {

					genre = Genre.CLASSICAL;
				}
				else if(inputGenre == 2) {

					genre = Genre.GOSPEL;
				}
				else if (inputGenre == 3) {

					genre = Genre.HIPHOP;
				}
				else if (inputGenre == 4) {

					genre = Genre.RNB;
				}
				else if (inputGenre == 5) {

					genre = Genre.SALSA;
				}

				boolean methodAnswer = model.addAlbum(nameAlbum, genre, priceAlbum, interpreter);

				if(methodAnswer == true) {

					System.out.println("Your album was added successfully to the Jukebox!");
				}
				else {

					System.out.println("I'm sorry, please try again.");
				}
			}

			//Add new song to existing album
			else if(response == 2) {

				System.out.println("Please enter album name");
				String nameAlbum = input.nextLine();

				System.out.println("Please enter song name");
				String nameSong = input.nextLine();

				System.out.println("Please enter song duration");
				String txtDuration = input.nextLine();
				int durationSong = Integer.parseInt(txtDuration);

				boolean methodResponse = model.addSong(nameSong, durationSong, nameAlbum);

				if(methodResponse == true) {

					System.out.println("Song added to album!");
				}
				else {
					System.out.println("Apologies. The song was not added to the album.");
				}
			}

			//Add a new hit
			else if(response == 3) {

				System.out.println("Please enter song name");
				String nameSong = input.nextLine();

				System.out.println("Please enter album name");
				String nameAlbum = input.nextLine();

				boolean methodResponse = model.addHit(nameSong, nameAlbum);

				if(methodResponse == true) {

					System.out.println("Hit added to album!");
				}
				else {
					System.out.println("Apologies. The song was not added to the album.");
				}
			}

			//Search for album
			else if(response == 4) {

				System.out.println("Please enter album name");
				String nameAlbum = input.nextLine();

				Album searchedAlbum = model.searchAlbum(nameAlbum);

				if(searchedAlbum == null) {

					System.out.println("I'm sorry, there is not an album with the name " + nameAlbum.toUpperCase());
				}
				else {
					System.out.println("The album named "+ nameAlbum.toUpperCase() + " has the following info:");
					System.out.println("\t a. Genre: " + searchedAlbum.getGenre());
					System.out.println("\t b. Price: " + searchedAlbum.getPrice());
					System.out.println("\t d. Interpreter: " + searchedAlbum.getInterpreter().getName() + " " + searchedAlbum.getInterpreter().getSurname() + " " + searchedAlbum.getInterpreter().getAge() + " " + searchedAlbum.getInterpreter().getRegion());
					System.out.println("\t c. Number of Songs: " + searchedAlbum.getNumberOfExistingSongs());
				}
			}

			//Search for song in album
			else if(response == 5) {

				System.out.println("Please enter song name");
				String nameSong = input.nextLine();

				System.out.println("Please enter album name");
				String nameAlbum = input.nextLine();

				Song searchedSong = model.searchSong(nameSong, nameAlbum);

				if(searchedSong == null) {

					System.out.println("Apologies. The song was does not exist in the album " + nameAlbum);
				}
				else {
					System.out.println("The song " + nameSong + " is present in the album " + nameAlbum);
				}
			}

			//Search for hit
			else if(response == 6) {

				System.out.println("Please enter song name");
				String nameSong = input.nextLine();

				Song searchedHit = model.searchHit(nameSong);

				if(searchedHit == null) {

					System.out.println("Hit not present in the Jukebox!");
				}
				else {
					System.out.println("Your hit was found: " + nameSong);
				}
			}

			//Delete an album
			else if(response == 7) {

				System.out.println("Please enter album name");
				String nameAlbum = input.nextLine();

				boolean methodAnswer = model.removeAlbum(nameAlbum);

				if(methodAnswer == true) {

					System.out.println("Your album was successfully removed from the Jukebox!");
				}
				else {

					System.out.println("I'm sorry, the album " + nameAlbum + " does not exist in Jukebox.");
				}
			}

			//Delete song from album
			else if(response == 8) {

				System.out.println("Please enter song name");
				String nameSong = input.nextLine();
				System.out.println("Please enter album name");
				String nameAlbum = input.nextLine();

				boolean methodAnswer = model.removeSongFromAlbum(nameSong, nameAlbum);

				if(methodAnswer == true) {

					System.out.println("Your song was successfully removed from album " + nameAlbum);
				}
				else {

					System.out.println("I'm sorry, the song " + nameSong + " does not exist in Jukebox.");
				}
			}

			//Delete a hit
			else if(response == 9) {

				System.out.println("Please enter hit name");
				String nameSong = input.nextLine();

				boolean methodAnswer = model.removeHit(nameSong);

				if(methodAnswer == true) {

					System.out.println("Your hit was successfully removed from the Jukebox!");
				}
				else {

					System.out.println("I'm sorry, the hit " + nameSong + " does not exist in Jukebox.");
				}
			}

			//Retrieve most expensive album
			else if(response == 10) {

				Album mostExpensive = model.getMostExpensiveAlbum();

				if(mostExpensive == null) {

					System.out.println("There are no albums in the Jukebox!");
				}
				else {

					System.out.println("The most expensive album is: "+ mostExpensive.getName());
					System.out.println("\t a. Genre: " + mostExpensive.getGenre());
					System.out.println("\t b. Price: " + mostExpensive.getPrice());
					System.out.println("\t c. Number of Songs: " + mostExpensive.getNumberOfExistingSongs());
					System.out.println("\t d. Interpreter: " + mostExpensive.getInterpreter().getName() + " " + mostExpensive.getInterpreter().getSurname());
				}
			}

			//Retrieve least expensive album
			else if(response == 11) {

				Album leastExpensive = model.getLeastExpensiveAlbum();

				if(leastExpensive == null) {

					System.out.println("There are no albums in the Jukebox!");
				}
				else {

					System.out.println("The least expensive album is "+ leastExpensive.getName());
					System.out.println("\t a. Genre: " + leastExpensive.getGenre());
					System.out.println("\t b. Price: " + leastExpensive.getPrice());
					System.out.println("\t c. Number of Songs: " + leastExpensive.getNumberOfExistingSongs());
					System.out.println("\t d. Interpreter: " + leastExpensive.getInterpreter().getName() + " " + leastExpensive.getInterpreter().getSurname());
				}
			}

			//Retrieve longest song from existing album
			else if(response == 12) {

				System.out.println("Please enter album name");
				String nameAlbum = input.nextLine();

				Song longestSong = model.getLongestSongInAlbum(nameAlbum);

				if(longestSong == null) {

					System.out.println("I'm sorry, there are no songs in " + nameAlbum);
				}
				else {
					System.out.println("The album named "+ nameAlbum + " has the following longest song:");
					System.out.println("\t" + longestSong.getName());
				}
			}

			//Retrieve longest hit
			else if(response == 13) {

				Song longestHit = model.getLongestHit();

				if(longestHit == null) {

					System.out.println("I'm sorry, there are no hits in the Jukebox!");
				}
				else {
					System.out.println("The hit " + longestHit.getName() + " was found!");
				}
			}

			//Retrieve shortest hit
			else if(response == 14) {

				Song shortestHit = model.getShortestHit();

				if(shortestHit == null) {

					System.out.println("I'm sorry, there are no hits in the Jukebox!");
				}
				else {
					System.out.println("The hit " + shortestHit.getName() + " was found!");
				}
			}

			//Retrieve number of albums in Jukebox
			else if(response == 15) {

				int existingAlbums = model.getNumberOfExistingAlbums();

				System.out.println("The Jukebox has " + existingAlbums + " albums.");
			}

			//Retrieve number of hits in Jukebox
			else if(response == 16) {

				int existingHits = model.getNumberOfExistingHits();

				System.out.println("The Jukebox has " + existingHits + " hits.");
			}

			System.out.println("Would you like to keep using this app? Y | N");
			String responseContinue = input.nextLine();

			// continueExecution is true
			if(responseContinue.equals("N")) {

				continueExecution = false;
			}

			//input.close();
		}
	}
}

