/*
 * Assignment: Pong Game: Assignment 5
 * Net ID: djm552
 * 
 * Author: David Moed
 * 
 * Completion Time: 12 hours
 *
 */


package MyGame;

import processing.core.PApplet;

public class Bumpers extends PApplet{
	
	public float xPosition;
	public float yPosition;
	public float ySpeed;
	public float height = 80;
	public float width = 15;
	public float canvasX = 500;
	public float canvasY = 500;
	public boolean pOneUp;
	public boolean pOneDown;
	public boolean pTwoUp;
	public boolean pTwoDown;

	//create a bumper for each side of the canvas
	public Bumpers(char Side){
		
		//make the left bumper
		if (Side == 'l'){
			xPosition = 5;
			yPosition = canvasY/2;
			this.ySpeed = 3;
		}
		
		//make the right bumper
		else{
			xPosition = canvasX - 20;
			yPosition = canvasY/2;
			this.ySpeed = 3;
		}
	}
	
	
	//move the left bumper based on the booleans
	public void moveLeftBumperUp() {
	
		//if the movement value is true move the bumper up
		if (this.pOneUp == true){
			this.yPosition -= this.ySpeed;
		}
		
		 //make sure the bumper does not go off the top of the canvas
	    if (this.yPosition < 0){
	      	this.yPosition = 1;
	      	

	    }
	}
	
	public void moveLeftBumperDown(){
		//if the movement value is true move the bumper down
		if (this.pOneDown == true){
			this.yPosition += this.ySpeed;
		}
	    
		//make sure the bumper does not go off the end of the canvas
	    if (this.yPosition > this.canvasY - height){
	      	
	    	this.yPosition = this.canvasY - height -1;
	      	

	      }
	   
	  }
	
	  // move the right bumper based on the booleans
	  public void moveRightBumperUp() {
		  
		//if the movement value is true move the bumper up
		if (this.pTwoUp == true){
			this.yPosition -= this.ySpeed;
		}
		
	    //make sure the bumper does not go off the top of the canvas
	    if (this.yPosition < 0){
	      	
	    	this.yPosition = 1;
	      	
	    }
	  }
	  
	  public void moveRightBumperDown(){
		//if the movement value is true move the bumper down
		if (this.pTwoDown == true){
			this.yPosition += this.ySpeed;
		}
	    
		//make sure the bumper does not go off the end of the canvas
	    if (this.yPosition > this.canvasY - height){
	      	
	    	  this.yPosition = this.canvasY - height - 1;
	      	
	      }
	    
	  }

	  
	
	
}
