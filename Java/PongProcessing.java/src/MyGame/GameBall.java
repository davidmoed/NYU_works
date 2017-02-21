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


public class GameBall extends PApplet {

		  //set initializers
		  public float xPosition;
		  public float yPosition;
		  public float xSpeed;
		  public float ySpeed;
		  public float radius;
		  public float canvasX = 500;
		  public float canvasY = 500;
		  

		  //create the game ball
		  public GameBall() {
		    this.xPosition = 250;
		    this.yPosition = 250;
		    this.xSpeed = 2;
		    this.ySpeed = 2;
		    this.radius = 25;
		    this.canvasX = 500;
		    this.canvasY = 500;
		  }

		  //move the ball according to its speed
		  public void move() {
		    
			//change our position based on the speed
		    this.xPosition += this.xSpeed;
		    this.yPosition += this.ySpeed;

		    //if someone scores on the right side
		    if (this.xPosition > this.canvasX + 100) {
		        //put us back on the canvas in the center
		        this.xPosition = this.canvasX/4;
		        this.yPosition = this.canvasY/2;
		        
		        //add one point to the player who scores
		        MyGame.playerOneScore++;
		        
		        //reset the speed
		        this.xSpeed = 2;
		        
		      }
		    
		    //if the ball scores on the left side
		    if (this.xPosition < -100) {
		        //put us back on the canvas in the center
		    	this.xPosition = this.canvasX - 400;
		        this.yPosition = this.canvasY/2;
		        
		        //add one point to the player who scores
		        MyGame.playerTwoScore++;
		        
		        //reset the speed
		        this.xSpeed = 2;

		      }
		      
		    //if it hits the bottom of the canvas have the ball bounce
		    if (this.yPosition > this.canvasY){
		      	
		    	this.yPosition = this.canvasY;
		      	
		      	this.ySpeed *= -1;
		    }
		      
		    //if it hits the top of the canvas have the ball bounce
		    if (this.yPosition < 0){
		      	
		    	this.yPosition = 0;
		      	
		      	this.ySpeed *= -1;
		    }
		      
		  }
		  
}