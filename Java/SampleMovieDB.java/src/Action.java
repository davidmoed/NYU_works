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

public class Action extends Movie {
	
	private int explosions;
	
	
//	The class provides one constructor that takes five parameters (title, year, duration, rating and explosions).
	public Action(String title, int year, int duration, double rating,  int explosions){
		
		//call the data from Movie
		super(title, year, duration, rating);
		
		//set the initialized variable equal to the parameter
		this.explosions = explosions;
		
		//validate all of the data
		super.setRating();
		super.checkYear();
		super.checkDuration();
		setExplosions();
		
		//throw an error if the year is invalid
		if (year < 1870 || year > 2016){
			throw new IllegalArgumentException("The year must be between 1870 and 2016");
		}
		
		//throw an error if the duration is invalid
		if (duration <= 0){
			throw new IllegalArgumentException("The movie must be longer than 0 minutes");
		}
		
	}
	
	//getter for explosion
	public int getExplosion(){
		return explosions;
	}
	
	//setter for explosion
	public int setExplosions(){
		if (explosions < 0 || explosions > 1000){
			throw new IllegalArgumentException("There must be some explosions!");
		}else if (explosions > 1000){
			throw new IllegalArgumentException("That's way too many explosions! How could anyone survive?");
		}else{
			return explosions;
		}
	}

	//override Movie's toString()
	@Override
	public String toString(){
		
		String thisMovie = String.format("%s" + ": " + "%2d" + ", rating:" + "%.2f" + ", price:" + "%.2f" + ", explosions " + "%2d", 
				title, year, setRating(), getPrice(), explosions);
		
		return thisMovie;
	}

	//calculate the price for the movie
	public double getPrice(){
		
		//set the price for the movie
		price = (year + explosions * duration) / 1000;
		
		return price;
	}






}
