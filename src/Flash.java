import java.awt.event.*;
import java.io.File;
import java.util.Set;
import java.util.TreeSet;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.FloatControl;
import javax.swing.*;

public class Flash extends JLabel implements ActionListener {
	
	public static final ImageIcon[][] IMAGE = {
	
/*orange*/	{new ImageIcon(new ImageIcon("images/flash00.png").getImage().getScaledInstance(100, 100, 0)), new ImageIcon(new ImageIcon("images/flash07.png").getImage().getScaledInstance(100, 100, 0)), new ImageIcon(new ImageIcon("images/flash08.png").getImage().getScaledInstance(100, 100, 0)), new ImageIcon(new ImageIcon("images/flash09.png").getImage().getScaledInstance(100, 100, 0))},
			{new ImageIcon(new ImageIcon("images/flash20.png").getImage().getScaledInstance(100, 100, 0)), new ImageIcon(new ImageIcon("images/flash27.png").getImage().getScaledInstance(100, 100, 0)), new ImageIcon(new ImageIcon("images/flash28.png").getImage().getScaledInstance(100, 100, 0)), new ImageIcon(new ImageIcon("images/flash29.png").getImage().getScaledInstance(100, 100, 0))},
			{new ImageIcon(new ImageIcon("images/flash20.png").getImage().getScaledInstance(100, 100, 0)), new ImageIcon(new ImageIcon("images/flash27.png").getImage().getScaledInstance(100, 100, 0)), new ImageIcon(new ImageIcon("images/flash28.png").getImage().getScaledInstance(100, 100, 0)), new ImageIcon(new ImageIcon("images/flash29.png").getImage().getScaledInstance(100, 100, 0))},
			{new ImageIcon(new ImageIcon("images/flash20.png").getImage().getScaledInstance(100, 100, 0)), new ImageIcon(new ImageIcon("images/flash27.png").getImage().getScaledInstance(100, 100, 0)), new ImageIcon(new ImageIcon("images/flash28.png").getImage().getScaledInstance(100, 100, 0)), new ImageIcon(new ImageIcon("images/flash29.png").getImage().getScaledInstance(100, 100, 0))},
			{new ImageIcon(new ImageIcon("images/flash00.png").getImage().getScaledInstance(100, 100, 0)), new ImageIcon(new ImageIcon("images/flash07.png").getImage().getScaledInstance(100, 100, 0)), new ImageIcon(new ImageIcon("images/flash08.png").getImage().getScaledInstance(100, 100, 0)), new ImageIcon(new ImageIcon("images/flash09.png").getImage().getScaledInstance(100, 100, 0))},
/*red*/		{new ImageIcon(new ImageIcon("images/flash00.png").getImage().getScaledInstance(100, 100, 0)), new ImageIcon(new ImageIcon("images/flash01.png").getImage().getScaledInstance(100, 100, 0)), new ImageIcon(new ImageIcon("images/flash02.png").getImage().getScaledInstance(100, 100, 0)), new ImageIcon(new ImageIcon("images/flash03.png").getImage().getScaledInstance(100, 100, 0))},
			{new ImageIcon(new ImageIcon("images/flash20.png").getImage().getScaledInstance(100, 100, 0)), new ImageIcon(new ImageIcon("images/flash21.png").getImage().getScaledInstance(100, 100, 0)), new ImageIcon(new ImageIcon("images/flash22.png").getImage().getScaledInstance(100, 100, 0)), new ImageIcon(new ImageIcon("images/flash23.png").getImage().getScaledInstance(100, 100, 0))},
			{new ImageIcon(new ImageIcon("images/flash20.png").getImage().getScaledInstance(100, 100, 0)), new ImageIcon(new ImageIcon("images/flash21.png").getImage().getScaledInstance(100, 100, 0)), new ImageIcon(new ImageIcon("images/flash22.png").getImage().getScaledInstance(100, 100, 0)), new ImageIcon(new ImageIcon("images/flash23.png").getImage().getScaledInstance(100, 100, 0))},
			{new ImageIcon(new ImageIcon("images/flash20.png").getImage().getScaledInstance(100, 100, 0)), new ImageIcon(new ImageIcon("images/flash21.png").getImage().getScaledInstance(100, 100, 0)), new ImageIcon(new ImageIcon("images/flash22.png").getImage().getScaledInstance(100, 100, 0)), new ImageIcon(new ImageIcon("images/flash23.png").getImage().getScaledInstance(100, 100, 0))},
			{new ImageIcon(new ImageIcon("images/flash00.png").getImage().getScaledInstance(100, 100, 0)), new ImageIcon(new ImageIcon("images/flash01.png").getImage().getScaledInstance(100, 100, 0)), new ImageIcon(new ImageIcon("images/flash02.png").getImage().getScaledInstance(100, 100, 0)), new ImageIcon(new ImageIcon("images/flash03.png").getImage().getScaledInstance(100, 100, 0))},
/*blue*/	{new ImageIcon(new ImageIcon("images/flash00.png").getImage().getScaledInstance(100, 100, 0)), new ImageIcon(new ImageIcon("images/flash04.png").getImage().getScaledInstance(100, 100, 0)), new ImageIcon(new ImageIcon("images/flash05.png").getImage().getScaledInstance(100, 100, 0)), new ImageIcon(new ImageIcon("images/flash06.png").getImage().getScaledInstance(100, 100, 0))},
			{new ImageIcon(new ImageIcon("images/flash20.png").getImage().getScaledInstance(100, 100, 0)), new ImageIcon(new ImageIcon("images/flash24.png").getImage().getScaledInstance(100, 100, 0)), new ImageIcon(new ImageIcon("images/flash25.png").getImage().getScaledInstance(100, 100, 0)), new ImageIcon(new ImageIcon("images/flash26.png").getImage().getScaledInstance(100, 100, 0))},
			{new ImageIcon(new ImageIcon("images/flash20.png").getImage().getScaledInstance(100, 100, 0)), new ImageIcon(new ImageIcon("images/flash24.png").getImage().getScaledInstance(100, 100, 0)), new ImageIcon(new ImageIcon("images/flash25.png").getImage().getScaledInstance(100, 100, 0)), new ImageIcon(new ImageIcon("images/flash26.png").getImage().getScaledInstance(100, 100, 0))},
			{new ImageIcon(new ImageIcon("images/flash20.png").getImage().getScaledInstance(100, 100, 0)), new ImageIcon(new ImageIcon("images/flash24.png").getImage().getScaledInstance(100, 100, 0)), new ImageIcon(new ImageIcon("images/flash25.png").getImage().getScaledInstance(100, 100, 0)), new ImageIcon(new ImageIcon("images/flash26.png").getImage().getScaledInstance(100, 100, 0))},
			{new ImageIcon(new ImageIcon("images/flash00.png").getImage().getScaledInstance(100, 100, 0)), new ImageIcon(new ImageIcon("images/flash04.png").getImage().getScaledInstance(100, 100, 0)), new ImageIcon(new ImageIcon("images/flash05.png").getImage().getScaledInstance(100, 100, 0)), new ImageIcon(new ImageIcon("images/flash06.png").getImage().getScaledInstance(100, 100, 0))}

	};
	
	private static final int MOVE_AMOUNT = 50;
	private static final int START_X = 150;
	private static final int START_Y = 150;
	
	public int direction;  //0 - left, 1 - up, 2 - right, 3 - down
	private int speed;   //speed of the flash running
	private int dx;  
	private int dy;
	private boolean left, up, right, down;  //used to remember the key pressed 
	private boolean left1 = true;  //used to see if the flash is already facing the left side
	private int deathCounter = 0;  //count how many villains the flash has defeated 
	private int lost = 0;
	private boolean fire = false; //used to see if the flash is releasing lightning bolts
	private int runState = 0; //0-standing, 1-start running, 2-running, 3-still running, 4-finish running
	private Timer[] RunTimer = new Timer[3]; //0 - orange lightning, 1 - red lighting, 2 - blue lightning
											//the flash gets faster and faster 

	public Flash() {
		
		speed = 60;
		
		setLocation(START_X, START_Y);
		setIcon(IMAGE[0][0]);
				
		RunTimer[0] = new Timer(speed, this); //original speed of the flash - orange lightning
	}
	
	/*
	 * getters and setters setup
	 */
	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}
	
	public Timer[] getRunTimer() {
		return RunTimer;
	}

	public void setRunTimer(Timer[] runTimer) {
		RunTimer = runTimer;
	}

	public boolean getLeft1() {
		return left1;
	}
	
	public void setLeft1(boolean left1) {
		this.left1 = left1;
	}
	
	public boolean getLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean getUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean getRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean getDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public int getRunState() {
		return runState;
	}

	public void setRunState(int runState) {
		this.runState = runState;
	}

	public int getDeathCounter() {
		return deathCounter;
	}

	public void setDeathCounter(int deathCounter) {
		this.deathCounter = deathCounter;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
		
	public boolean isFire() {
		return fire;
	}

	public void setFire(boolean fire) {
		this.fire = fire;
	}

	public int getLost() {
		return lost;
	}

	public void setLost(int lost) {
		this.lost = lost;
	}

	public void run(int arrowDirection) {
		
		direction = arrowDirection - 37;   
		
		//facing of the Flash in terms of movement
		if(direction == 0) {  //if it goes left
			left1 = true;      //remember that the flash is facing the left
		} else if (direction == 2) {  //if it goes right
			left1 = false;     //leave it since the default is right 
		} 
			
		if(direction == 1 || direction == 3) { //if it goes up or down
			if(getLeft1() == true)    //while it is already facing the left direction
				direction = 4;     //keep facing the left direction while going up or down
		}
		
		if(arrowDirection == 37)
			left = true; //remember the left key
		else if(arrowDirection == 38)
			up = true;  //remember the up key
		else if(arrowDirection == 39)
			right = true;  //remember the right key
		else if(arrowDirection == 40)
			down = true;  //remember the down key
		
		dx = 0;
		dy = 0;
		
		if(left)  //when going left
			dx = -MOVE_AMOUNT;
		if(right) //when going right
			dx = MOVE_AMOUNT;
		if(up)  //when going up
			dy = -MOVE_AMOUNT;
		if(down) //when going down
			dy = MOVE_AMOUNT;
		
		/*This has to be set in order to prevent overlap of the timers*/
		if(deathCounter < 10) //if less than 10 villains are defeated 
			RunTimer[0].start();  //keep the flash running at the original speed with orange lighting
		else if(deathCounter < 20)  //if less than 20 villains are defeated 
			RunTimer[1].start();  //keep the flash running at level 2 speed with red lightning
		else if(deathCounter > 20) //if more than 20 villains have been defeated 
			RunTimer[2].start();  //keep the flash running at level 3 speed with blue lightning
				
	}
	
	public void shoot(int f) {
		
		if(f == 70) //when the key "F" is pressed
			fire = true;  //flash is firing lighting bolts 

	}

	public void actionPerformed(ActionEvent event) {
		
		for(int x = 0; x < RunTimer.length; x++) {
			
			//when the flash is running
			if(event.getSource() == RunTimer[x]) {
				
				/*
				 * line 238 to 266 were taken from the frogger
				 */
				
				runState++;
				
				if(runState == 4) {
					
					runState = 1;
					
				} else if(runState == 3) {
					
					this.setLocation(getX() + dx/2, getY() + dy/2);
					
				} else if (runState == 2) {
					
					this.setLocation(getX() + dx/2, getY() + dy/2);
					
				}
				
				this.setIcon(IMAGE[direction + 5 * x][runState]); 
				
				//when the flash goes out of the screen horizontally
				if(getX() > TheFlashGUI.FRAME_WIDTH + getWidth()) {
					setLocation(-getWidth(), getY());
				} else if (getX() < -getWidth())
				setLocation(TheFlashGUI.FRAME_WIDTH, getY());
			
				//when the flash goes out of the screen vertically
				if(getY() > TheFlashGUI.FRAME_HEIGHT + getHeight()) {
					setLocation(1366 - getX(), TheFlashGUI.FRAME_HEIGHT);
				} else if (getY() < - getHeight())
					setLocation(1366 - getX(), -getHeight());
			
				//when the flash is attacking the villains
				for(int index = 0; index < TheFlashGUI.villain.length; index++) {
					
					for(int indey = 0; indey < TheFlashGUI.lightningBolt[0].length; indey++) {
						
						if(getBounds().intersects(TheFlashGUI.villain[index].getBounds())) { //when the flash touches the villains
							
							//if the villains still haven't completely destroyed the city and the warning sign will still pop up to show signs of danger
							if(TheFlashGUI.villain[index].getMissionComplete() == false)  {
								TheFlashGUI.villain[index].setHealth(TheFlashGUI.villain[index].getHealth() - 1); //villains lose one point of health
								
								if(TheFlashGUI.villain[index].getHealth() == 0) {  //if the villains lose all the health
									
									deathCounter++;  //increment the amount of villains defeated by one
									TheFlashGUI.villain[index].setVisible(false);  //defeated villains disappeared
									TheFlashGUI.warning[index].setVisible(false);  //warning signs disappeared with the villains
									TheFlashGUI.cityHealthBar[index].getHealthTimer().stop();   //city health bars stop decrementing 
									TheFlashGUI.cityHealthBar[index].safe(); //the cities will be safe until the villains appear again
									TheFlashGUI.villain[index].reborn();  //defeated villains enter dormant state
									TheFlashGUI.warning[index].reappear();  //warning signs enter dormant state
									TheFlashGUI.villain[index].setScoreCount(TheFlashGUI.villain[index].getScoreCount() + 1); //add one to the score
									TheFlashGUI.scores[index].setText(String.valueOf(TheFlashGUI.villain[index].count())); //set the score
								
									//background sound effect when the flash defeats the villains
									try {
										TheFlashGUI.defeat = AudioSystem.getClip();
										TheFlashGUI.defeat.open(AudioSystem.getAudioInputStream(new File("running.wav")));
										TheFlashGUI.defeat.start();	
									}catch(Exception e){
										System.out.println("Error");		
									}
								} 
							}	
							 
						  //when the flash touches the lightning bolts floating around the map
						} else if(getBounds().intersects(TheFlashGUI.lightningBolt[index][indey].getBounds())) {
							
							//if the lighting bolts are collectable and visible
							if(TheFlashGUI.lightningBolt[index][indey].getCollectable() == true) { 
								TheFlashGUI.lightningBolt[index][indey].setVisible(false); //disappear once touched
								TheFlashGUI.lightningBolt[index][indey].setCollectable(false); //no longer collectable
								TheFlashGUI.speedforce.setAccumulate(TheFlashGUI.speedforce.getAccumulate() + 1); //increment the value of the speed force bar by one
								TheFlashGUI.speedforce.setValue(TheFlashGUI.speedforce.getAccumulate()); //set that value in the speed force bar
								
								//background sound effect when the lightning bolts are collected
								try {
									TheFlashGUI.collectLightning = AudioSystem.getClip();
									TheFlashGUI.collectLightning.open(AudioSystem.getAudioInputStream(new File("electriccurrent.wav")));
									FloatControl gainControl = (FloatControl) TheFlashGUI.collectLightning.getControl(FloatControl.Type.MASTER_GAIN);
									gainControl.setValue(-25);
									TheFlashGUI.collectLightning.start();	
								}catch(Exception e){
									System.out.println("Error");		
								}
							}
						} 
							
					}
					
					if(TheFlashGUI.cityHealthBar[index].getTime() == 0) { //if the city health bars run out
						lost++;
						TheFlashGUI.villain[index].setMissionComplete(true); //villains complete their mission and the flash cannot do anything anymore
						//the original images of the villains got replaced with fire representing the destruction of the city
						TheFlashGUI.villain[index].setIcon(new ImageIcon(new ImageIcon("images/destroyed.gif").getImage().getScaledInstance(50, 50, 0)));
						TheFlashGUI.warning[index].setIcon(null); //get ride of the warning signs so it doesn't appear regardless
					} 
								
				}
				
				
				for(int w = 0; w < TheFlashGUI.attack.length; w++) {
					
					for(int z = 0; z < TheFlashGUI.attack[0].length; z++) {
						
						if(fire == true) { //if the flash is firing the lightning bolts
							
								//if the flash touches any of the invisible moving lightning bolts 
								if(getBounds().intersects(TheFlashGUI.attack[w][z].getBounds())) {
										
										TheFlashGUI.attack[w][z].setVisible(true); //set those touched lightning bolts visible
										TheFlashGUI.attack[w][z].getDisappeared().start();	//start the timer that makes the lightning bolt disappeared
										
										//background sound effect when the flash releases attacking lightnig bolts
										try {
											TheFlashGUI.lightningAttack = AudioSystem.getClip();
											TheFlashGUI.lightningAttack.open(AudioSystem.getAudioInputStream(new File("lightningAttack.wav")));
											TheFlashGUI.lightningAttack.start();	
										}catch(Exception e){
											System.out.println("Error");		
										}		
								}			
						}
					}
				}
				
				
				//if certain amounts of enemies are defeated
				if(deathCounter == 10 * x + 10) { //the flash can receive upgrade in lightning and speed
					
					/* Due to the setup of the array, the flash will stop running when the deathCounter is exactly at 30
					 * the only way to get the flash running normally again is to defeat one more villain so that the
					 * deathCounter is no longer at 30. In order to prevent this from happening, the following if statement 
					 * is to be carried out to make sure that it will not happen
					 */
					
					if(deathCounter == 30) { //if exactly 30 villains are defeated
						RunTimer[x].start(); //don't stop the flash, keep him running at level 3 speed with blue lightning
					} else {	
						RunTimer[x].stop(); //stop the original timer
						speed = 40 - 15 * x;  //input a faster speed for the next timer 
						RunTimer[x + 1] = new Timer(speed, this);  
						RunTimer[x + 1].start();  //now the flash runs in a faster speed with different colour of lightning
					}
				}
				
			} 
			
		}
		
	}
	
}	
