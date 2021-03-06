import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JPanel;


public class Tabla extends JPanel implements MouseListener{	
	
	Thread t = null;
	Random r = new Random();
	private int alto = 20;
	private int ancho = 20;
	Juego juego= new Juego(alto, ancho);
	boolean iniciado = false;
	private int a = 0;
	private int b = 0;
	
	public Tabla() {
		setPreferredSize(new Dimension(400, 400));
		setBackground(Color.BLUE);
		juego.limpiarEspacio();
		juego.limpiarColocar();
		addMouseListener(this);
	}
	
	public void paint(Graphics g) {
		String celula;
		for(int i=0;i<alto; i++){
				for (int j=0; j<ancho; j++){
					celula = juego.getCelula(i, j);
					int y=(i*20);
					int x=(j*20);
					if (celula.equals("Viva")){
						g.setColor(Color.GREEN);
						g.fillOval(x, y, 20, 20);
					}
					
					if (celula.equals("Muerta")){
						g.setColor(Color.GRAY);
						g.fillOval(x, y, 20, 20);
					}
					
				}
		}
	}
	
	public void sigGen(){
		juego.siguienteGen();
		repaint();
	}

	public void start() {
	    if(t == null)
	    	iniciado = true;
	        t = new Thread(new Runnable(){
				public void run() {
					while (iniciado) {
					sigGen();
					repaint();
						try {
							Thread.sleep(300);
						} catch (InterruptedException e) {}
					}
				}
	        });
	    	t.start();
	    }
	public void stop(){
		iniciado = false;
		t = null;
	}
	
	public void limpiar(){
		juego.limpiarEspacio();
		repaint();
	}

	public void mouseClicked(MouseEvent e) {
		b = e.getX()/20;
		a = e.getY()/20;
		if (juego.matriz[a][b].equals("Muerta")){
			juego.matriz[a][b]="Viva";}
		else{juego.matriz[a][b]="Muerta";}
		repaint();
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}
	
}
