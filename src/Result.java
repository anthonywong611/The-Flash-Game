import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Result extends JFrame implements ActionListener {
	
	int[] villainScore = new int[10]; //array of scores of each villains
	JLabel scores = new JLabel(); //label of the actual scores number
	JLabel totalScore = new JLabel(); //label on top
	JButton exit = new JButton("EXIT"); 
	JLabel background = new JLabel(new ImageIcon(new ImageIcon("images/flashBackground.png").getImage().getScaledInstance(1366, 725, 0)));
	Font font = new Font("Calibri", Font.BOLD + Font.ITALIC, 200);
	int mark = 0; //use to store all the scores
	
	public Result() {
		
		//frame setup
		setSize(1366, 725);
		setTitle("The Flash: Global Crisis");
		setResizable(false);
		setLayout(null);
		setVisible(true);
	
		//top label setup
		totalScore.setBounds(125, 100, 700, 100);
		totalScore.setText("TOTAL SCORE: ");
		totalScore.setFont(new Font("Discovery", Font.LAYOUT_LEFT_TO_RIGHT, 50));
		totalScore.setForeground(Color.RED);
		add(totalScore);
		
		//actual scores number setup
		scores.setBounds(175, 200, 600, 200);
		scores.setFont(font);
		add(scores);
		
		//button setup
		exit.setBounds(250, 500, 200, 100);
		exit.setFont(new Font("Discovery", Font.LAYOUT_LEFT_TO_RIGHT, 30));
		exit.setForeground(Color.BLACK);
		exit.setFocusable(false);
		exit.addActionListener(this);
		add(exit);
		
		//give each of the villains a score
		for(int x = 0; x < villainScore.length; x++) {
			villainScore[x] = 10 * x + 10;
		}
		
		//background setup
		background.setBounds(0, 0, 1366, 725);
		add(background);
		
		//calculating the total scores
		for(int x = 0; x < TheFlashGUI.villain.length; x++) {
			//add up all the amount of each villains defeated
			mark += villainScore[x] * TheFlashGUI.villain[x].getScoreCount(); //score of the villain * amount of defeat
		}
		
		scores.setText(String.valueOf(mark)); //change the actual scores label to the total mark
			
	}
	
	public void actionPerformed(ActionEvent event) {
		
		//if the exit button is cliked
		if(event.getSource() == exit) {
			dispose(); //close the frame
			System.exit(0); //stop the program
		}
		
	}

}
