/*
 * Name - Anthony Wong
 * 
 * Date of Submission: June 9th, 2017
 * 
 * Course Code: ICS3U1 - 03
 * Instructor: Mr.Fernandes
 * 
 * Title: The Flash: Global Crisis
 * 
 * Description: 
 * 		Barry Allen, the Flash, is called by kid Flash, Wally West to help protect the cities of his Earth from the
 * 	crazy attacks of The Rogues and the evil speedsters.
 * 
 * Features:
 *  1) flash's lightning and speed upgrade: change colour of lightning and increase speed
 *  2) lightning bolts collection: run around the world to collect lightning bolts 
 *  3) lightning bolts attack: throw lightning bolts at villains for attack
 *  4) background music: lit Justice League animation theme!!
 *  
 * Major Skills:
 *  1) Getters and Setters
 *  2) Classes, Fields, and Objects
 *  3) Control Structures and Methods
 *  4) Constructors
 *  
 *  Area of Concerns: 
 *  	One thing I fail to make in this game is the randomization of the location of villains
 *  as well as their recovering and attacking abilities. They all stay at the same spots and has 
 *  the same abilities throughout the entire game which makes the game less engaged and more predictable.
 *  Another thing I fail is the unidirection of the attacking lightning bolts. When the flash is releasing 
 *  the lightning bolts in either of the horizontal directions, if the flash changes direction after 
 *  the lighting bolts are released, the released lightning bolts will also change direction with the flash 
 *  in midair which doesn't obey the laws of physics. 
 *  
 */

public class TheFlashGlobalCrisis {
	
	public static void main(String[] args) {
		new TheFlashIntroPage();
	}
}
