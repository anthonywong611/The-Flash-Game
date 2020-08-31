import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.util.Timer;

import javax.swing.*;

public class TheFlashIntroPage extends JFrame implements ActionListener {
	
	JPanel info = new JPanel();
	JLabel explanation = new JLabel();
	JLabel portal = new JLabel();
	JLabel kidFlash = new JLabel();
	JLabel wallyWest = new JLabel();
	JLabel opening = new JLabel();
	JLabel title = new JLabel("GLOBAL CRISIS");
	JButton run = new JButton("Run");
	Timer openingTimer = new Timer();
	Font font = new Font("Discovery", Font.LAYOUT_LEFT_TO_RIGHT, 50);
	Font font1 = new Font("Discovery", Font.LAYOUT_LEFT_TO_RIGHT, 25);
			
	public TheFlashIntroPage() {
		
		Frame(); 
		Opening();
		Title(); 
		Panel();
		KidFlash();
		Explanation();
		Button();
		Background();
		repaint();
		
	}

	private void Frame() {
		
		setSize(1366, 725);
		setTitle("THE FLASH: GLOBAL CRISIS");
		setResizable(false);
		setLayout(null);
		setVisible(true);
		
	}
	
	private void Opening() {
		
		opening.setIcon(new ImageIcon(new ImageIcon("images/opening.gif").getImage().getScaledInstance(1366, 725, 0)));
		opening.setBounds(0, 0, 1366, 725);
		add(opening);
		
		/*
		 * This opening timer code is obtained from the introduction page made 
		 * by Tom in the previous project Laptop Advisor Test
		 */
		
		openingTimer.schedule(new TimerTask() {
			  @Override
			  public void run() {
				  opening.setVisible(false);
				  repaint();
				  title.setVisible(true);
				  run.setVisible(true);
				  portal.setVisible(true);
				  info.setVisible(true);
			  }
			}, 2350);
		
	}
	
	private void Title() {
		
		title.setBounds(433, 50, 500, 100);
		title.setFont(font);
		title.setForeground(Color.RED);
		title.setVisible(false);
		add(title);
		
	}
	
	private void Panel() {
		
		//the panel that holds the images, text, and button
		
		/* The panel's opacity and colour got adjusted on line 89
		 * Source: https://stackoverflow.com/questions/24559167/how-to-make-a-jpanel-semi-transparent
		 */
		
		info.setBackground(new Color(70, 140, 140, 190)); 
		info.setBounds(150, 150, 1066, 475);
		info.setLayout(null);
		info.setVisible(false);
		add(info);
		
	}
	
	private void KidFlash() {
		
		//KidFlash Label
		wallyWest.setIcon(new ImageIcon(new ImageIcon("images/kidFlash.png").getImage().getScaledInstance(225, 425, 0)));
		wallyWest.setBounds(25, 0, 225, 425);
		info.add(wallyWest);
		
		//KidFlash's name Label
		kidFlash.setText("KID FLASH");
		kidFlash.setFont(font1);
		kidFlash.setForeground(Color.YELLOW);
		kidFlash.setBounds(50, 425, 200, 25);
		info.add(kidFlash);
		
	}
	
	private void Explanation() {
		
		//explanation of the game
		explanation.setBounds(260, 0, 750, 450);
		explanation.setFont(new Font("Calibri", Font.CENTER_BASELINE, 17));
		explanation.setForeground(Color.WHITE);
		info.add(explanation);
		explanation.setText("<html>Barry Allen!! My name is Wally West, Kid Flash. My Earth is in great danger right now "
				+ "and I came all the way to your Earth to ask for your help!! The Rogues and the evil speedsters had joined "
				+ "forces and the worse thing was that the Trickster has set up a bomb somewhere in Central City that can, once "
				+ "blow up, turn the entire city into ashes!! I need you to come to my Earth! The Rouges and the evil speedsters "
				+ "led by your worst enemy, Eobard Thawne, the Reverse Flash, spread out across the world in many different major "
				+ "cities, attacking and trampling on innocent lives. I need you to run around the world to save from them the "
				+ "cities and the people, while Jay and I will be looking for the bomb. Unfortunately, the metahuman prisons have "
				+ "been destroyed, which means you will have to keep runnig around them to open up a portal and"
				+ " imprison them in the speedforce. The speedsters will bring themselves and the rest of the Rogues back to the "
				+ "cities. It is only a matter of time. If you find yourself overwhelmed by the situation, there "
				+ "are some lightning bolts scattering across the world that you can collect. Press 'F' on the keyboard to throw "
				+ "lightning bolts on them. But there is very limited amount of these lightning bolts so make sure you will make "
				+ "good use of it. I know this might seem a bit abrupt but ... I need you to run!! Barry! Run!!");	
	}

	private void Button() {
		
		//the button on the bottom right of the panel that 
		//actually starts the game
		run.setBounds(850, 400, 120, 50);
		run.setFont(font1);
		run.setForeground(Color.RED);
		run.setBackground(Color.WHITE);
		run.setFocusable(false);
		run.addActionListener(this);
		info.add(run);
		
	}
	
	private void Background() {
		
		//the background gif
		portal.setIcon(new ImageIcon(new ImageIcon("images/timePortal.gif").getImage().getScaledInstance(1366, 725, 0)));
		portal.setBounds(0, 0, 1366, 725);
		portal.setVisible(false);
		add(portal);
		
	}

	public void actionPerformed(ActionEvent event) {
		
		//if the 'run' button is clicked on
		if(event.getSource() == run) {
			dispose(); //close this frame
			new TheFlashGUI();  //call up the GUI class
		}

	}
	
}
