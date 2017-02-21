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

public class RomCom extends Movie {

	private int jerks;
	private int friendzones;
	
	//constructor
	public RomCom(String title, int year, int duration, double rating, int jerks, int friendzones) {
		
		//call the data from movie
		super(title, year, duration, rating);
		
		//set the initialized variables equal to the parameters
		this.jerks = jerks;
		this.friendzones = friendzones;
		
		//validate all of the data
		super.setRating();
		super.checkYear();
		super.checkDuration();
		setJerks();
		setFriendzones();		
	}

	
	//getter for jerks
	public int getJerks(){
		return jerks;
	}
	
	//getter for friendzones
	public int getFriendzones(){
		return friendzones;
	}
	
	//setter for jerks
	public int setJerks(){
		
		//if there are too few jerks (<0)
		if (jerks < 0){
			throw new IllegalArgumentException("There must be at least 1 jerk!");
		}else if (jerks > 10){
			throw new IllegalArgumentException("That's too many jerks! There can't possibly be more than 10!");
		}else{
			return jerks;
		}
	}
	
	//setter for friendzones
	public int setFriendzones(){
		
		//if there are too few jerks (<0)
		if (friendzones < 0){
			throw new IllegalArgumentException("There must be at least 1 friendzone!");
		}else if (jerks > 10){
			throw new IllegalArgumentException("That's too many friendzones! There can't possibly be more than 10!");
		}else{
			return friendzones;
		}
	}
	
	//override Movie's toString()
	@Override
	public String toString(){
		
		String thisMovie = String.format("%s" + ": " + "%2d" + ", rating:" + "%.2f" + ", price:" + "%.2f" + ", jerks" + "%2d" + ", friendzones" + "%2d",
				title, year, setRating(), getPrice(), jerks, friendzones);
		
		return thisMovie;
	}
	
	//override Movie's get price method
	@Override
	public double getPrice(){
		
		price = (jerks + friendzones + year - duration) / 100;
		
		return price;
	}
	
}
