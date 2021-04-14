package Model;

import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Corpo {
	

	private int x,y=0;
	private int dx,dy;
	private Image imagem;
	private int altura,largura;
	private int bodyParts;
	private char direction = 'D';
	private int a[],b[];
	private static final int UNIT_SIZE=50;
	
	public Corpo() { //em que lugar o corpo vai surgir
		this.x = 100;
		this.y = 100;
	}

	public void load() {
		ImageIcon referencia = new ImageIcon("res\\konka.gif");
		imagem = referencia.getImage();
		altura = imagem.getHeight(null);
		largura = imagem.getWidth(null);
	}
	
	public void update() {
		x +=dx;
		y +=dy;
	}
	
	public void keypressed(KeyEvent tecla) { //quando pressionar alguma tecla ele vai fazer alguma ação
		int codigo = tecla.getExtendedKeyCode();
		if(codigo == KeyEvent.VK_UP) {
			dy=-2;
		}
		if(codigo == KeyEvent.VK_DOWN) {
			dy=2;
		}
		if(codigo == KeyEvent.VK_LEFT) {
			dx=-2;
		}
		if(codigo == KeyEvent.VK_RIGHT) {
			dx=2;
		}
		
	}
	public void keyRelease(KeyEvent tecla) { //quando pressionar alguma tecla ele vai fazer alguma ação
		int codigo = tecla.getExtendedKeyCode();
		if(codigo == KeyEvent.VK_UP) {
			dy=0;
		}
		if(codigo == KeyEvent.VK_DOWN) {
			dy=0;
		}
		if(codigo == KeyEvent.VK_LEFT) {
			dx=0;
		}
		if(codigo == KeyEvent.VK_RIGHT) {
			dx=0;
		}
		}
	
	public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                if (direction != 'D') {
                    direction = 'A';
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (direction != 'A') {
                    direction = 'D';
                }
                break;
            case KeyEvent.VK_UP:
                if (direction != 'S') {
                    direction = 'W';
                }
                break;
            case KeyEvent.VK_DOWN:
                if (direction != 'W') {
                    direction = 'S';
                }
                break;
            }
        }
public void move() {
        
		for (int i = bodyParts; i > 0; i--) {
            a[i] = a[i - 1];
            b[i] = b[i - 1];
        }

        switch (direction) {
        case 'W':
            b[0] = b[0] - UNIT_SIZE;
            break;
        case 'S':
            b[0] = b[0] + UNIT_SIZE;
            break;
        case 'A':
            a[0] = a[0] - UNIT_SIZE;
            break;
        case 'D':
            a[0] = a[0] + UNIT_SIZE;
            break;
        }
}
	
}
public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImagem() {
		return imagem;
	}
	}

