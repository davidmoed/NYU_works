	/*
	 * Assignment: Pong Game: Assignment 5
	 * Net ID: djm552
	 * 
	 * Author: David Moed
	 * 
	 * Completion Time: 12 hours
	 *
	 */

/*
 Assignment description:
 
 For this assignment you need to write a program using classes provided by the Processing package 
 (specifically PApplet class, but you may use other classes).  
 Your program has to be interactive and it has to be developed using object oriented programming 
 (i.e.  things are represented using classes). Using good OOP practices will be a siginificant portion of your grade.
Implement ’Pong’ http://www.ponggame.org/ or ’Tic Tac Toe’ http://en.wikipedia.org/wiki/Tic-tac-toe. 
The game should be two player.

 */


package MyGame;

import processing.core.PApplet;

public class MyGame extends PApplet{
		
	//set initializers
	private GameBall a;
	private Bumpers playerOne;
	private Bumpers playerTwo;
	public static int playerOneScore = 0;
	public static int playerTwoScore = 0;
	public boolean startGame;

		
	public void setup() {
		// size the canvas
		size(500, 500);
		
		//create a circle
		a = new GameBall();
		
		//create the bumpers
		playerOne = new Bumpers('l');
		playerTwo = new Bumpers('r');
			    
	 } 
	
    public void draw() {
    	
    	//prompt the user to click to begin the game
    	if (startGame == false){
    		
    		
    		//erase the background and have the text pop up in blue
    		background(0);
    		fill(0,100,200);
    		textSize(36);
    		text("Welcome to pong", 100, 200);
    		text("Click anywhere to begin", 50, 250);
    		
    	}
    	else{
    		
    		
    		//while the scores are below 3 play the game
	    	if (playerOneScore < 3 && playerTwoScore < 3){
		    	// erase the background
		        background(0);
			       
		        	//set the colors for the text which appears on screen
			        fill(200,50,0);
			       
			        //have the score appear to the user on screen
			        textSize(32);
			        text("May the best ponger win!", 55, 450);
			        text("P1: "+playerOneScore, 100,100);
			        text("P2: "+playerTwoScore, 300,100);
			
			        //set the colors for the ball and bumpers
			        fill(0,100,200);
			        
			      //set the bounce movement for the ball
			        Bounce();
			        
			        //move the ball and bumpers
			        a.move();
			        playerOne.moveLeftBumperUp();
			        playerOne.moveLeftBumperDown();
			        playerTwo.moveRightBumperUp();
			        playerTwo.moveRightBumperDown();     
			       
			        //smooth the graphics
			        smooth();
			
			        //draw the ball and bumpers at their locations
			        ellipse(a.xPosition, a.yPosition, a.radius, a.radius);
			        rect(playerOne.xPosition, playerOne.yPosition, playerOne.width, playerOne.height);
			        rect(playerTwo.xPosition, playerTwo.yPosition, playerTwo.width, playerTwo.height);
		    	}
	    	
	    	else{
	    		
	    		//if someone wins, erase the game and show the user who won
	    		background(0);
	    		fill(random(255),random(255),random(255));
	    		textSize(40);
	    		text(higherScore(), 100, 250);	    
	    	}
    	}
    
    }
    //have the ball change direction if it hits the bumpers
	public void Bounce(){
		
		//if the ball hits the left bumper have it bounce the other way
		if(a.yPosition > playerOne.yPosition && a.yPosition < playerOne.yPosition + playerOne.height){
			if(a.xPosition - a.radius + 10 <= playerOne.xPosition + playerOne.width && a.xPosition >= playerOne.xPosition){
				
				//speed up the ball slightly
				a.xSpeed *=-1.07;
			}
		}
		
		//if the ball hits the right bumper have it bounce the other way
		if(a.yPosition > playerTwo.yPosition && a.yPosition < playerTwo.yPosition + playerTwo.height){
			if(a.xPosition + a.radius - 10 >= playerTwo.xPosition && a.xPosition<= playerTwo.xPosition + playerTwo.width){
				
				//speed up the ball slightly
				a.xSpeed *=-1.07;
			}
		}
		

	}	
	
	//keep track of the scores and who has the higher score
	public String higherScore(){
		if(playerOneScore > playerTwoScore){
			return "Player One Wins";
		}else{
			return "Player Two Wins";
		}
	}
	
	//set the boolean value controlling the game as true if the user clicks
	@Override
	public void mouseReleased() {
		startGame = true;
	}
	
	// set the boolean movement values based on the keys being pressed and held
	@Override
	public void keyPressed() {
		
		//if the left side player (player 1) holds down w or s, set the boolean to true
		if(key == 'w'){
			playerOne.pOneUp = true;
		}
		if(key == 's'){
			playerOne.pOneDown = true;
		}
		
		// if the right side player (player 2) holds down up or down, set the boolean to true
		if (key == CODED) {
			if(keyCode == UP){
				playerTwo.pTwoUp = true;
			}
			if(keyCode == DOWN){
				playerTwo.pTwoDown = true;
			}
		}
		
		
	}
	
	//set the movement variables to false if the user releases a key
	@Override
	public void keyReleased() {
		
		if(key == 'w'){			
			playerOne.pOneUp = false;
			
		}
		if(key == 's'){
			playerOne.pOneDown = false;
		}
		
		if (key == CODED) {
			if(keyCode == UP){
			    playerTwo.pTwoUp = false;
			}
			if(keyCode == DOWN){
				playerTwo.pTwoDown = false;
			}
		 }
			
	 }
	
	public static void main( String args []) { 
		PApplet.main(new String[] { "MyGame" });
	 }		
	
}
		 



