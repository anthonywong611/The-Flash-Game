import java.awt.event.*;
import javax.swing.*;

public class Warning extends JLabel implements ActionListener {
	
	private int recover;
	private boolean danger;
	private Timer timer;
	
	public Warning(int recover) {
		
		this.recover = recover;
		
		timer = new Timer(recover, this); //time taken to recover with the villains
		
	}
	
	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}
	
	public int getRecover() {
		return recover;
	}

	public void setRecover(int recover) {
		this.recover = recover;
	}

	public boolean getDanger() {
		return danger;
	}

	public void setDanger(boolean danger) {
		this.danger = danger;
	}

	public void reappear() {
		timer.start();
	}
	
	public void actionPerformed(ActionEvent event) {
		
		//if the villains are defeated 
		if(event.getSource() == timer) { //disappear with the villains
			
			this.timer.stop(); //when the recovery time is over
			this.setVisible(true); //appear with the villains again
			
		}
	}

}
