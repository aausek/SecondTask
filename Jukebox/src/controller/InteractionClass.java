package controller;

import java.util.Scanner;

import model.Album;
import model.Interpreter;
import model.Jukebox;

/**
 * Class that models the interaction window with the user.
 * @author Pedro Guillermo Feijóo-García
 */
public class InteractionClass 
{
	/**
	 * Main method of the application. It controls the excecution of the program.
	 * @param args arguments input by the Java Virtual Machine and the environment.
	 */
	public static void main(String[] args) 
	{
		Jukebox model = new Jukebox();
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to JukeboxApp!");
		
		
		boolean continueExcecution = true;
		while(continueExcecution == true)
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
		
		}
		
		input.close();
		
	}
}
