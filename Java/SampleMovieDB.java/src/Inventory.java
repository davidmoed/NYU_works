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


import java.util.ArrayList;
import java.util.Collections;


public class Inventory {

	//create an array list of movie objects
	ArrayList<Movie> movieList = new ArrayList<Movie>();
	
	//create a method to add movies to the ArrayList
	public void add(Movie movie){
		
		//if the movie is already in the list throw an exception
		if (movieList.contains(movie)) {
			throw new MovieInventoryException(movie.title);
	      } 
		//else add the movie
		else {
	        movieList.add(movie);
	     
	       Collections.sort(movieList);
	     
	      }
	}
	
	//create a method to remove movies if they are in the list
	public boolean remove(String title, int year){
		
		if (movieList.contains(title) && movieList.contains(year)){
			
			int movieIndex = movieList.lastIndexOf(title);
			
			movieList.remove(movieList.get(movieIndex));
			
			Collections.sort(movieList);
			
			return true;
		}else{
			return false;
		}
	}
	
	//create a method to check if the list contains a movie
	public boolean contains(String title, int year){
		if (movieList.contains(title) && movieList.contains(year)){
			return true;
		}else{
			return false;
		}
	}

	//create a method that checks the size of the array list
	public int size(){
		return movieList.size();
	}

	//create a toString() method for the arrayList
	public String toString(){
		
		//create a string for the list
		String allMovies = "";
		
		//loop through the list
		for (int i = 0; i < movieList.size(); i++) {
			
			
			//add each movie to the string
			allMovies += movieList.get(i).toString() + "\n";
		
		}
		//return the string of movies
		return allMovies;
	}



	//create an inventory exception error
	public class MovieInventoryException extends RuntimeException { public MovieInventoryException(String title ) {
		super(title + " already in inventory."); }
		}


}
