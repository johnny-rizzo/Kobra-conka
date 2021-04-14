import javax.swing.JFrame;

import Model.Fase;

public class GameFrame extends JFrame{
	
	
	GameFrame() {

	    add (new Fase());
		setTitle("Kobra Conka");
		setSize(1024,728);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);//controlar se maximiza ou não
		this.setVisible(true);
		

	}
	public static void main (String [] args) {
		new GameFrame();
	}
}

