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

/*
	Assignment Description:
	
You just got hired for a job as a programmer at Amazon. 
They are not happy with their current software that keeps track of Amazon Prime Video inventory
and your first project is to write a new one. You need to implement the following classes.

• Movie
This abstract class represents a single movie offered by Amazon.
The class should provide toString() method. 
It should also have a getPrice() method. This method should be abstract and return a double.

• Action
The Action class represents an action movie.
Action extends Movie, adds some additional data, implements the getPrice() and overrides toString()
The class provides one constructor that takes five parameters (title, year, duration, rating and explosions). 
The constructor should validate the arguments 
and throw an IllegalArgumentException with a descriptive message if any of the values are invalid.

• RomCom
The RomCom class represents a romantic comedy.
RomCom extends Movie, adds some additional data, implements the getPrice() and overrides toString().
The class provides one constructor that takes six parameters (title, year, duration, rating, jerks and friendzones). 
The constructor should validate the arguments 
and throw an IllegalArgumentException with a descriptive message if any of the values are invalid.

• Inventory
This class represents the current inventory on a Amazon’s servers.
The class should be composed with an ArrayList of Movie objects. 
Your methods can work with the corresponding methods of the ArrayList class.

It must contain:
	• add takes a Movie object and has a void return type. 
		If a movie matching the title and year does not exist in the inventory, then the movie is added to the ArrayList. 
		If the movie already exists in the list, then throw a MovieInInventoryException with a descriptive message. 
	• remove takes the title and year as parameters and returns a boolean. 
		If the movie matching the title and year exist in the inventory remove it from the inventory and return true. 
		If the movie matching the title and year does not exist in the inventory, return false.
	• contains takes the title and year and returns a boolean. 
		If the movie matching the title and year exist in the inventory return true, else return false.
	• size takes no arguments and returns the number of movies in the inventory.
	• toString returns a multi-line String obj
	
• TestInventory 
TestInventory’s main method should load a file containing some movies and build objects of the right type for that movie 
and load them into the inventory. 
Moveover, the program needs to read in the file and populate the inventory with the movies from the file.


*/

public abstract class Movie implements Comparable<Movie> {

	private double rating;
	protected int year;
	protected int duration;
	protected String title;
	protected double price;
		
	public Movie(String title, int year, int duration, double rating){
		
		//set the initialized variables equal to the parameters
		this.title = title;
		this.year = year;
		this.duration = duration;
		this.rating = rating;
		
		//ensure the data is valid
		setRating();
		checkYear();
		checkDuration();	
		
		//call the to string method
		toString();
	}
	
	//abstract getter for price
	public abstract double getPrice();
	
	//getter for year
	public int getYear(){
		return year;
	}
	
	//getter for duration
	public int getDuration(){
		return duration;
	}
	
	//getter for title
	public String getTitle(){
		return title;
	}
	
	//getter for rating
	public double getRating(){
		return rating;
	}
	
	//setter for rating
	public double setRating(){
		//throw an error if the rating is invalid
		if (rating < 0.0 || rating > 4.0){
			throw new IllegalArgumentException("Rating must be between 0 and 4.");
		}else{
			return rating;
		}
	}
	
	//validate the year
	public void checkYear(){
		//throw an error if the year is invalid
		if (year < 1870 || year > 2016){
			throw new IllegalArgumentException("The year must be between 1870 and 2016");
		}
	}
	
	//validate the duration
	public void checkDuration(){
		//throw an error if the duration is invalid
		if (duration <= 0){
			throw new IllegalArgumentException("The movie must be longer than 0 minutes");
		}
	}
	
	
	//have a toString method to print out the data on the movie
	@Override
	public String toString(){
		
		String thisMovie = String.format("%s" + ":" + "%2d" + ",rating:" + "%.2f" + ",price:" + "%2.f", title, year, rating, price);
		
		return thisMovie;
	}
	
	public int compareTo(Movie movie){
		
		//check if the movie has the same year, if it does compare ratings
		if (this.year == movie.year){
			return Double.compare(movie.rating, this.rating);
		}
		//if the years are different return the earlier one
		else {
			return Integer.compare(this.year, movie.year);
		}
	}
	
}
