/*
 * Assignment: Movie Inventory: Assignment 8
 * Net ID: djm552
 * 
 * Date: May 8th
 * 
 * Author: David Moed
 * 
 * Completion Time: 2 hours
 *
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

//import Inventory.MovieInventoryException;

public class TestInventory {

  public static void main(String[] args) throws FileNotFoundException {
    
	Inventory inv = new Inventory();
    
	java.io.File file = new java.io.File ("/Users/davidmoed/Documents/workspace/MoedDavidAssign7.java/src/movies_db.txt");
	
    //call the file so we can access it in a scanner object
    Scanner input = new Scanner (file);

    while (input.hasNextLine()) {
        
    	//save each line as a string
    	String line = input.nextLine();
    	
    	//split up each line by "-" and save each piece in a string array
        String [] splitLine = line.split ("-");
        
        try {
        	
        	//if there are 5 objects in the string array (Action has 5 parameters)
        	if (splitLine.length == 6){
        	
        		//cast the data so it is not all strings
        		int year = Integer.parseInt(splitLine[1]);
	        	int duration = Integer.parseInt(splitLine[2]);
	        	double rating = Double.parseDouble(splitLine[3]);
	        	int explosions = Integer.parseInt(splitLine[5]);
        	
	        //create a new action movie object with the pieces in the string array 	
        	Movie actionMovie = new Action(splitLine[0], year, duration, rating, explosions);
        	
        	//add the movie to the database
        	inv.add(actionMovie);
	        }
	        
        	//if there are 6 objects in the string array (RomCom has 6 parameters)
	        else if( splitLine.length == 7){
	        	
	        	//cast the data so it is not all strings
	        	int year = Integer.parseInt(splitLine[1]);
	        	int duration = Integer.parseInt(splitLine[2]);
	        	double rating = Double.parseDouble(splitLine[3]);
	        	int jerks = Integer.parseInt(splitLine[5]);
	        	int friendzones = Integer.parseInt(splitLine[6]);
	        	
	        	//create a new RomCom movie object with the pieces in the string array
	        	Movie romComMovie = new RomCom(splitLine[0], year, duration, rating, jerks, friendzones);
	        	
	        	//add the movie to the database
	        	inv.add(romComMovie);
	        }         
	        
	    }
        //check for duplicate movies
		catch (Inventory.MovieInventoryException e) {
		    System.err.println("Exception " + e.getMessage() + " for film " + splitLine[0] + ". No loading.");
		}
        //check for invalid data in the movie titles
        catch (IllegalArgumentException a){
		   System.err.println(a);
	   }
   }
    
    input.close();
   
    System.out.println("Inventory should now contain file contents." + "\n");    
    System.out.println(inv.toString());
    
    Movie starWars = new Action("Star Wars - A New Hope", 1977, 121, 3.8, 89);
    inv.add(starWars);
    
    Movie numberFour = new Action("I Am Number Four", 2011, 101, 3.2, 11);
    inv.add(numberFour);
    
    Movie someoneLikeYou = new RomCom("Someone Like You", 2011, 101, 3.2, 2, 5);
    inv.add(someoneLikeYou);
    
    Movie crazyStupidLove = new RomCom("Crazy, Stupid, Love 2", 2013, 113, 3.9, 1, 3);
    inv.add(crazyStupidLove);

    System.out.println("Inventory should now contain 13 movies. " + (inv.size() == 13));
    System.out.println();
    
    
    if(inv.remove(crazyStupidLove.getTitle(), crazyStupidLove.getYear())) {
      System.out.println("Successfully removed 'Crazy, Stupid, Love'");
      if(!inv.remove(crazyStupidLove.getTitle(), crazyStupidLove.getYear())) {
        System.out.println("Successfully ignored second remove attempt for 'Crazy, Stupid, Love'");
      }
    }
    
    try {
      inv.add(new RomCom("27 Dresses", 2008, 103, 4.4, 1, 1));
    } catch (IllegalArgumentException e) {
      System.out.println("Successfully threw exception on invalid parameter.");
    }
    
    try {
      inv.add(someoneLikeYou);
    } catch (Inventory.MovieInventoryException e) {
      System.out.println("Successfully threw exception on duplicate add attempt.");
    }

    System.out.println("Inventory should now contain 12 movies. " + (inv.size() == 12));
      
    System.out.println("Inventory should not contain 'The Matrix'? " + !inv.contains("The Matrix", 1999));
    System.out.println("Inventory should not contain 'Something Borrowed'? " + !inv.contains("Something Borrowed", 2009));
    System.out.println("Inventory should not contain '27 Dresses'? " + !inv.contains("27 Dressed", 2008));
    
    System.out.println("\n" + inv.toString());
  }

}
