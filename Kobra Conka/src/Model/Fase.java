package Model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fase extends JPanel implements ActionListener{ //atulizar a tela(action listner)

	private Image fundo;
	private Corpo corpo;
	private Timer timer;
	static final int SCREEN_WIDTH = 900;
    static final int SCREEN_HEIGHT = 650;
    static final int DELAY = 1000;
	
	public Fase() {
		setFocusable(true);
		setDoubleBuffered(true);
		
		ImageIcon referencia = new ImageIcon("res\\background-preto.jpg");
		fundo = referencia.getImage();
		
		corpo = new Corpo();
		corpo.load();//carregar a imagem do corpo
		
		addKeyListener(new TecladoAdapter());//instanciou o teclado
			
		timer = new Timer(5, this);// velocidade do ambiente
		timer.start();
	}
	
	
	public void paint(Graphics g) {
		
		Graphics graficos = (Graphics) g;
		graficos.drawImage(fundo, 0, 0, null);
		graficos.drawImage(corpo.getImagem(), corpo.getX(), corpo.getY(), this);
		g.dispose();
		/*for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
            g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
            g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
        }*/
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		corpo.update();
		repaint();
		
	}
	
	private class TecladoAdapter extends KeyAdapter {
		
		@Override
		public void keyPressed(KeyEvent e) {
			corpo.keypressed(e);
	}
		/*@Override
		public void keyReleased(KeyEvent e) {
			corpo.keyRelease(e);
		
	}*/
}
}




