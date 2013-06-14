import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;


public class Interfaz extends JFrame {
    private JButton inicio, parar, siguiente, limpiar, continuar, salir;
    
    Tabla tabla = new Tabla();
    boolean iniciado = false;
    
	public Interfaz(){
		super("El juego de la vida");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(tabla, BorderLayout.CENTER);
		
		JToolBar t = new JToolBar();
        inicio = new JButton("Inicio");
        t.add(inicio);
        inicio.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		if (!iniciado) {
        			inicio.setText("Parar");
        			siguiente.setEnabled(false);
        			limpiar.setEnabled(false);
        			tabla.start();
        		}
        		else {
        			inicio.setText("Iniciar");
        			siguiente.setEnabled(true);
        			limpiar.setEnabled(true);
        			tabla.stop();
        		}
        		iniciado = !iniciado;
        	}
        });
        
               
        siguiente = new JButton("Sig. Gen");
        t.add(siguiente);
        siguiente.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		tabla.sigGen();
        	}
        });
        
        limpiar = new JButton("Limpiar");
        t.add(limpiar);
        limpiar.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		tabla.limpiar();
        	}
        });
        
        salir = new JButton("Salir");
        t.add(salir);
        salir.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		System.exit(0);
        	}
        });
		add(t, BorderLayout.PAGE_START);
		pack();
	}
	
	
	 public static void main(String[] args) {
		 new Interfaz().setVisible(true);
	 }

}
