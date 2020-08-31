import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Random;

public class TheFlashGUI extends JFrame implements KeyListener, ActionListener{

	public static final int FRAME_WIDTH = 1366;
	public static final int FRAME_HEIGHT = 725;

	//classes and fields
	public static Flash flash = new Flash();
	public static Attack[][] attack = new Attack[10][24];
	public static SpeedForce speedforce = new SpeedForce();
	public static Villain[] villain = new Villain[10];
	public static City[] city = new City[10];
	public static CityHealthBar[] cityHealthBar = new CityHealthBar[10];
	public static Warning[] warning = new Warning[10];
	public static JLabel[] fire = new JLabel[10];
	public static LightningBolt[][] lightningBolt = new LightningBolt[10][20];

	//music
	public static Clip music;  //background music
	public static Clip defeat;   //sound effect of the flash running through the enemy
	public static Clip collectLightning;  //sound effect when the lightning bolts are collected
	public static Clip lightningAttack;  //sound effect when the lightning bolts are released to attack

	Random rand = new Random();

	//basic background labels
	Font font1 = new Font("Discovery", Font.ITALIC, 25); 
	Font font2 = new Font("Discovery", Font.LAYOUT_LEFT_TO_RIGHT, 14);
	JLabel world = new JLabel();  //the map in the background
	JLabel ocean = new JLabel();  //the ocean in the background
	JLabel score = new JLabel();  
	JLabel speedForce = new JLabel("SPEEDFORCE");
	JButton result = new JButton ("RESULT");  //the "exit" button on the bottom right hand side
	JPanel collection = new JPanel();  //panel to hold the villains label showing the amount of villains defeated
	Villains[] villains = new Villains[10];
	public static JLabel[] scores = new JLabel[10];

	public TheFlashGUI() {

		//frame setup
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setLayout(null);
		setTitle("The Flash: Global Crisis");
		setResizable(false);
		setVisible(true);
		addKeyListener(this);

		collection();
		villains();
		speedForce();
		score();
		
		//The Flash
		flash.setBounds(flash.getX(), flash.getY(), 100, 100);
		add(flash);
		
		LightningBoltAttack();

		//city setup 
		for(int x = 0; x < city.length; x++) {

			if(x == 0)
				city[x] = new City(100, 100);
			else if (x == 1)
				city[x] = new City(300, 300);
			else if (x == 2)
				city[x] = new City(400, 400);
			else if (x == 3)
				city[x] = new City(600, 150);
			else if (x == 4)
				city[x] = new City(750, 225);
			else if (x == 5)
				city[x] = new City(800, 425);
			else if (x == 6)
				city[x] = new City(850, 100);
			else if (x == 7)
				city[x] = new City(1200, 475);
			else if (x == 8)
				city[x] = new City(850, 275);
			else if (x == 9)
				city[x] = new City(1112, 225);

			city[x].setBounds(city[x].getStartX(), city[x].getStartY(), 0, 0);
			add(city[x]);
		}	

		//villain labels
		for(int x = 0; x < villain.length; x++) {

			if(x == 0)
				villain[x] = new Villain("reverseFlash", 500, 3000, rand.nextInt(2) * 1000 + 1000, false);
			else if (x == 1)
				villain[x] = new Villain("captainCold", 250, 4000, rand.nextInt(2) * 1000 + 1000, false);
			else if (x == 2)
				villain[x] = new Villain("blackFlash", 500, 3500, rand.nextInt(2) * 1000 + 1000, false);
			else if (x == 3)
				villain[x] = new Villain("captainBoomerang", 450, 5000, rand.nextInt(2) * 1000 + 1000, false);
			else if (x == 4)
				villain[x] = new Villain("godSpeed", 600, 3000, rand.nextInt(2) * 1000 + 1000, false);
			else if (x == 5)
				villain[x] = new Villain("grodd", 800, 6000, rand.nextInt(2) * 1000 + 1000, false);
			else if (x == 6)
				villain[x] = new Villain("killerFrost", 250, 2500, rand.nextInt(2) * 1000 + 1000, false);
			else if (x == 7)
				villain[x] = new Villain("rival", 450, 3500, rand.nextInt(2) * 1000 + 1000, false);
			else if (x == 8)
				villain[x] = new Villain("savitar", 700, 3000, rand.nextInt(2) * 1000 + 1000, false);
			else if (x == 9)
				villain[x] = new Villain("zoom", 600, 4000, rand.nextInt(2) * 1000 + 1000, false);

			villain[x].setBounds(city[x].getStartX(), city[x].getStartY(), 50, 50);
			add(villain[x]);

		}

		lightningBolt();

		//warning signs when the villains show up
		for(int x = 0; x < warning.length; x++) {
			warning[x] = new Warning(villain[x].getRecover());
			warning[x].setIcon(new ImageIcon(new ImageIcon("images/warning.gif").getImage().getScaledInstance(50, 50, 0)));
			warning[x].setBounds(city[x].getStartX() + 50, city[x].getStartY(), 50, 50);
			warning[x].setVisible(true);
			add(warning[x]);
		}

		//fire labels of cities destroyed 
		for(int x = 0; x < fire.length; x++) {
			fire[x] = new JLabel();
			fire[x].setIcon(new ImageIcon(new ImageIcon("images/destroyed.gif").getImage().getScaledInstance(50, 50, 0)));
			fire[x].setBounds(city[x].getStartX(), city[x].getStartY(), 50, 50);
			fire[x].setVisible(false);
			add(fire[x]);
		}

		//city health bar set up
		for(int x = 0; x < cityHealthBar.length; x++) {

			if(x == 0)
				cityHealthBar[x] = new CityHealthBar(100, 150, villain[x].getRecover(), villain[x].getAttack());
			else if (x == 1)
				cityHealthBar[x] = new CityHealthBar(300, 350, villain[x].getRecover(), villain[x].getAttack());
			else if (x == 2)
				cityHealthBar[x] = new CityHealthBar(400, 450, villain[x].getRecover(), villain[x].getAttack());
			else if (x == 3)
				cityHealthBar[x] = new CityHealthBar(600, 200, villain[x].getRecover(), villain[x].getAttack());
			else if (x == 4)
				cityHealthBar[x] = new CityHealthBar(750, 275, villain[x].getRecover(), villain[x].getAttack());
			else if (x == 5)
				cityHealthBar[x] = new CityHealthBar(800, 475, villain[x].getRecover(), villain[x].getAttack());
			else if (x == 6)
				cityHealthBar[x] = new CityHealthBar(850, 150, villain[x].getRecover(), villain[x].getAttack());
			else if (x == 7)
				cityHealthBar[x] = new CityHealthBar(1200, 525, villain[x].getRecover(), villain[x].getAttack());
			else if (x == 8)
				cityHealthBar[x] = new CityHealthBar(850, 325, villain[x].getRecover(), villain[x].getAttack());
			else if (x == 9)
				cityHealthBar[x] = new CityHealthBar(1112, 275, villain[x].getRecover(), villain[x].getAttack());

			cityHealthBar[x].setBounds(city[x].getStartX(), city[x].getStartY() + 50, 50, 10);
			add(cityHealthBar[x]);

		}

		exit();
		world();
		ocean();
		music();
		repaint();
	}

	private void LightningBoltAttack() {
		
		//200 attacking lightning bolts moving across the screen
		for(int x = 0; x < attack.length; x++) {

			for(int y = 0; y < attack[0].length; y++) {
				attack[x][y] = new Attack(68 * y, 62 * x); //locations of each of the lightning bolts
				attack[x][y].setBounds(attack[x][y].getStartX(), attack[x][y].getStartY(), 50, 50);
				attack[x][y].setVisible(false); //set all of the lightning bolts invisible - only appear when attacking
				add(attack[x][y]);
			}
		}
	}

	private void lightningBolt() {
		
		//200 lightning bolts laying across the screen
		for(int x = 0; x < lightningBolt.length; x++) {

			for(int y = 0; y < lightningBolt[0].length; y++) {
				lightningBolt[x][y] = new LightningBolt(false); //each of the lightning bolts are initially incollectable
				lightningBolt[x][y].setBounds(68 * y, 62 * x, 35, 35);
				lightningBolt[x][y].setVisible(false); //set all of the lightning bolts to false since they are all uncollectable
				add(lightningBolt[x][y]);
			}
		}
		
		/*/
		 * the following codes in this method was obtained from Tom
		 */
		
		boolean [] temp = new boolean [20]; //temporary boolean array to choose collectable lightning bolts
		
		for(int row = 0; row < 10; row++){ //for each of the 10 rows of lightning bolt
			
			for(int column = 0; column < 20; column++) //for each of the 20 columns
				temp [column] = false;  //set each of lightning bolt the column to false
			
			for(int combo = 0; combo < 2; combo++){ //randomly pick 2 lightning bolt out of 20
				
				int random;  //input the random number
				
				do{ //keep regenerating random number until a new number is generated 
					random = (int) (Math.random() * 20); //generate a random number between 0 and 19
				} while (temp[random]); //if the same number has already been generated

				temp[random] = true; //set the23 randomly selected lightning bolt on each row to true
			}
			
			for(int column = 0; column < 20; column++) {
				lightningBolt[row][column].setVisible(temp[column]); //set these 2 lightning bolts visible
				lightningBolt[row][column].setCollectable(temp[column]); //set them to collectable 
			}
		}
	}

	private void speedForce() {
		
		//speedforce label
		speedForce.setBounds(50, 25, 300, 25);
		speedForce.setFont(font1);
		speedForce.setForeground(Color.YELLOW);
		add(speedForce);

		//speedforce progress bar - collection speedforce energy
		speedforce.setBounds(50, 50, 300, 25);
		add(speedforce); 
		
	}

	private void villains() {
		
		//villains label inside the panel
		for(int x = 0; x < villains.length; x++) {

			if(x == 0)
				villains[x] = new Villains("reverseFlash");
			else if (x == 1)
				villains[x] = new Villains("captainCold");
			else if (x == 2)
				villains[x] = new Villains("blackFlash");
			else if (x == 3)
				villains[x] = new Villains("captainBoomerang");
			else if (x == 4)
				villains[x] = new Villains("godSpeed");
			else if (x == 5)
				villains[x] = new Villains("grodd");
			else if (x == 6)
				villains[x] = new Villains("killerFrost");
			else if (x == 7)
				villains[x] = new Villains("rival");
			else if (x == 8)
				villains[x] = new Villains("savitar");
			else if (x == 9)
				villains[x] = new Villains("zoom");

			villains[x].setBounds(4 + 116 * x, 5, 50, 50);
			collection.add(villains[x]);

		}
	}

	private void score() {
		
		//score label setup in the panel
		for(int x = 0; x < scores.length; x++) {
			
			scores[x] = new JLabel(": 0");
			scores[x].setFont(new Font("Calibri", Font.BOLD, 35));
			scores[x].setForeground(Color.WHITE);
			scores[x].setBounds(58 + 116 * x, 5, 50, 50);
			scores[x].setLayout(null);
			collection.add(scores[x]);

		}
	}

	private void collection() {
		
		//panel setup that holds the villains images and scores
		collection.setBounds(50, 620, 1150, 60);
		collection.setBackground(Color.GRAY);
		collection.setBorder(BorderFactory.createLineBorder(Color.black));
		collection.setLayout(null);
		add(collection);	
		
	}

	private void ocean() {
		
		//ocean background setup
		ocean.setIcon(new ImageIcon(new ImageIcon("images/ocean.jpg").getImage().getScaledInstance(1366, 725, 0)));
		ocean.setBounds(0, 0, 1366, 725);
		add(ocean);
		
	}

	private void world() {
		
		//map background setup
		world.setIcon(new ImageIcon(new ImageIcon("images/map.png").getImage().getScaledInstance(1336, 600, 0)));
		world.setBounds(10, 50, 1336, 600);
		add(world);
		
	}

	private void exit() {
		
		//the 'exit' button on the bottm right
		result.setBounds(1226, 600, 112, 50);
		result.setFont(font2);
		result.addActionListener(this);
		result.setVisible(true);	
		result.setFocusable(false);
		add(result);
		
	}

	public static void music() {

		/*
		 * all the music codes in this program was the exact same codes obtained from Tom
		 */
		
		//backgroundmusic
		try {
			music = AudioSystem.getClip();
			music.open(AudioSystem.getAudioInputStream(new File("Justice League Unlimited - Full Theme (HQ).wav")));
			FloatControl gainControl = (FloatControl) TheFlashGUI.music.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-15);
			music.start();	
		}catch(Exception e){
			System.out.println("Error");		
		}
	}

	public void keyPressed(KeyEvent event) {

		if(event.getKeyCode() >= 37 && event.getKeyCode() <= 40) {
			flash.run(event.getKeyCode());	
		}
		
		if(speedforce.getAccumulate() != 0) { //if the speedforce bar is not empty
			if(event.getKeyCode() == 70) { //the player can press 'f' to release lightning bolts
				flash.shoot(event.getKeyCode());
				speedforce.setAccumulate(speedforce.getAccumulate() - 1); //speedforce bar decrement by one each time 
				speedforce.setValue(speedforce.getAccumulate());
			}
		}
	
	}

	public void keyReleased(KeyEvent event) {

		if(event.getKeyCode() >= 37 && event.getKeyCode() <= 40) {

			if(event.getKeyCode() == 37) {
				flash.setLeft(false);
			} else if(event.getKeyCode() == 38) {
				flash.setUp(false);
			} else if(event.getKeyCode() == 39) {
				flash.setRight(false);
			} else if(event.getKeyCode() == 40) {
				flash.setDown(false);
			}

		} 
		
		if (event.getKeyCode() == 70) { //if 'F' is released
			flash.setFire(false); //the flash is no longer releasing lightning bolt
		}
	}

	public void keyTyped(KeyEvent event) {}

	public void actionPerformed(ActionEvent event) {

		//when the 'result' button is clicked
		if(event.getSource() == result) { 
			new Result(); // call up the Result class
		} 
		
	}


}
