package progAssign3.java;

/*
 Assignment Parameters:

In this assignment, you will implement a micro-version of Facebook 
using hash tables and linked lists to allow an open-ended number of friends and gain efficiency..
Specifically, your program will accept from input a sequence of commands of the following forms, one command to a line:

• P <name>  
– Create a person record of the specified name. You may assume that no two people have the same name.

• F <name1> <name2>
— Record that the two specified people are friends.

• L <name>
— Print out the friends of the specified person.

• Q <name1> <name2>
— Check whether the two people are friends. If so, print “Yes”; if not, print “No”

•U <name1> <name2>
— Record that the two specified people are no longer friends.

• X – terminate the program.
*/

/*
 Code sources:

hashtable code taken from: https://docs.oracle.com/javase/7/docs/api/java/util/Hashtable.html
	keySetTterator code from: http://javarevisited.blogspot.com/2011/12/how-to-traverse-or-loop-hashmap-in-java.html
linkedlist code taken from https://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html
Iterator code taken from: https://docs.oracle.com/javase/7/docs/api/java/util/AbstractSequentialList.html#iterator()
	Iterator code implementation from http://crunchify.com/how-to-iterate-through-linkedlist-instance-in-java/
*/


import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Set;
import java.util.Scanner;

class Person {
	private String name;
	LinkedList<Person> friends= new LinkedList<Person>();
	
	public String getName(){
		return this.name;
	}
	
	public Person (String name) {
		this.name = name;
	}
	
	public LinkedList<Person> getFriends() {
		return friends;
	}
	
	//check if two people are already friends
	public boolean areFriends (Person b) {

		Iterator<Person> iterate = friends.iterator();

		while(iterate.hasNext()) {
			
			Person a = (Person) iterate.next();
			
			if(a.getName().equals(b.getName())){
				return true;
			}
		}
		return false;
	}

	//add two people as friends as long as they are not friends already
	public void addFriend(Person b) {
		if(!areFriends(b)) {
			friends.addFirst(b);
			b.friends.addFirst(this);
			System.out.println(this.getName() + " and " + b.getName() + " are now friends");
		} else {
			System.out.println("Sorry, but you are already friends.");			
		}
	}
	
	
	public String printAllFriends(){

		Iterator<Person> iterate = friends.iterator();
		
		String friendNames="";
		
		while(iterate.hasNext()){
			Person friend = (Person) iterate.next();
			
			friendNames += friend.getName().toString() + ", ";
		    	
		}
		return friendNames;
	}	
}


public class MicroFB2 {
	
	//create hashtables for all people and all friends
	private static Hashtable<String, Person> allPeople = new Hashtable<String, Person>();
	private static Hashtable<String, Boolean> allFriends = new Hashtable<String, Boolean>();	
	
	//create a method to find each person
	public static Person findPerson(String person) { 	
		
		//set the keyset
		Set<String> keySet = allPeople.keySet();
		
		//loop through the hashtable using a keyset iterator
		Iterator<String> keySetIterator = keySet.iterator();
				
		while (keySetIterator.hasNext()){
			
			String key = keySetIterator.next();
			
			if (key.equals(person)) {
				return allPeople.get(person);
			}			
		}
		return null;
		
	}
		
	//add a new person to the hashtable
	public static void addPerson(String name){
		Person person = new Person(name);
		
		allPeople.put(name,person);
	}
		
	//Check if two people exist
	public static boolean validPeople(String x, String y) {
		return (findPerson(x) != null && findPerson(y) != null);
	}
	
	//Check if one person exists
	public static boolean validPerson(String x) {
		return (findPerson(x) != null);
	}
	
	//Make two names into a key format for allFriends
	public static String makeKey(String x,String y){

		String names="";
		names=x+"*"+y;
		
		return names;
	}
			
	//Assign two people as friends 
	public static void assignFriend(String x, String y){
		
		if (!x.equals(y)) {
			
			findPerson(x).addFriend(findPerson(y)); 
			
			allFriends.put(makeKey(x,y),true);
			
		} else {
			System.out.println("These people could not become friends.");
		}
	}
	
	//list all the friends of a person
	public static void list(String name){
		String a = findPerson(name).printAllFriends();
		System.out.println(a);
		
	}
	
	//check if two people are friends
	public static boolean areFriends(String x, String y){
				
		String combo1 = x+"*"+y;
		String combo2 = y+"*"+x;
		
		if (!allFriends.isEmpty()) {
			Set<String> keySet = allFriends.keySet();
			
			//loop through the hashtable using a keyset iterator
			Iterator<String> keySetIterator = keySet.iterator();
			
			while (keySetIterator.hasNext()) {
				String key = keySetIterator.next();
				
				if(key.equals(combo1) || key.equals(combo2)){
						return true;
				}
			}
		}
		return false;
	}


	public static void main(String[] args) {
		
		System.out.println("Enter a command:");
		
		Scanner sc = new Scanner(System.in);
		String line;
		String command;
		
				
		while (sc.hasNextLine()) {
			
			line = sc.nextLine();
			
			Scanner firstWord = new Scanner(line);	
			
			
			command = firstWord.next(); 
	
			if(command.equals("X")) {
				System.out.println("Goodbye!");
				break;
			}
			
			else if(command.equals("P")) { 
				String name1 = firstWord.next();
				
				if (!(validPerson(name1))){
					addPerson(name1);
					System.out.println(name1 + " added.");
				} else {
					System.out.println("This person already exists.");
				}
				
				System.out.println("Enter another command:");
			 } 
			 
			else if(command.equals("F")) { 
				String name1 = firstWord.next();
				String name2 = firstWord.next();			
					
				if (!(name1.equals(name2))) {				
					assignFriend(name1, name2);
				}
				
				System.out.println("Enter another command:");
			 } 
			 
			else if(command.equals("U"))  { 
				
				String name1 = firstWord.next();
				String name2 = firstWord.next();
				
				if (validPeople(name1,name2)) {
					
					if(areFriends(name1,name2)){
					    
						//Delete each person from the linked list of friends of the other person.
						findPerson(name1).friends.remove(findPerson(name2));
						findPerson(name2).friends.remove(findPerson(name1));
						
						String thisFriend = name1+"*"+name2;
						String otherFriend = name2+"*"+name1;
						
						allFriends.remove(thisFriend);
						allFriends.remove(otherFriend);
						
						System.out.println(name1 + " and " + name2 + " are no longer friends.");
					} else {
						System.out.println("These people were not friends.");
					}
				}
				System.out.println("Enter another command:");
			 } 
			
			else if(command.equals("L")) { 
				String name1 = firstWord.next();
				
				if (validPerson(name1)){
					list(name1);
				}
				
				System.out.println("Enter another command:");
			 } 
			 
			else if(command.equals("Q")) { 
				
				String name1 = firstWord.next();
				String name2 = firstWord.next();
				
				if (validPeople(name1,name2)){
					
					if (areFriends(name1,name2)) {
						System.out.println(name1.toString()+" "+ "and"+" "+ name2.toString()+" "+"are friends.");
					} else {
						System.out.println(name1.toString()+" "+ "and"+" "+ name2.toString()+" "+"are not friends.");
					}
				}
				
				System.out.println("Enter another command:");
			 }
			firstWord.close();
		 } 
		sc.close();
	}			 
}
