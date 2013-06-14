import java.util.Random;
import java.util.Scanner;


public class Juego {
	protected String matriz[][];
	private int contaGeneraciones = 0;
	private int alto;
	private int ancho;
	Random r = new Random();

	
	public Juego(int alto, int ancho){
		this.alto = alto;
		this.ancho = ancho;
		matriz = new String[alto][ancho];
		limpiarEspacio();
	}
	
	public String getCelula(int i, int j){
		return matriz[i][j];
	}
	
	public void limpiarEspacio(){
		for (int i = 0;i<matriz.length;i++){
			for (int j = 0;j<matriz[i].length;j++){
				matriz[i][j] = "Muerta";
			}
		}
		contaGeneraciones = 0;
	}
	
	public void limpiarColocar(){
		for(int i = 0;i<matriz.length;i++){
			for (int j = 0;j<matriz[i].length;j++){
				matriz[r.nextInt(20)][r.nextInt(20)] = "Viva";
			}
		}
		
	}
	
	public void siguienteGen(){
		int contaVivas;
		//supervivencia
		for(int i = 0;i<matriz.length;i++){
			for (int j = 0;j<matriz[i].length;j++){ 					//recorre el vector
				contaVivas = -1;
				for (int x = i-1;x<=i+1;x++){
					for (int z = j-1;z<=j+1;z++){ 		//recorre alrededor de una celula
						try {
							if (matriz[x][z].equals("Viva") || matriz[x][z].equals("Moribunda"))
								contaVivas++;
						} catch (IndexOutOfBoundsException e) {}	//try catch porque en los bordes se sale de rango
					}
				}
				if (matriz[i][j].equals("Viva") && (contaVivas > 3 || contaVivas < 2))
					matriz[i][j] = "Moribunda";											//Soledad y superpoblacion
				else if (matriz[i][j].equals("Muerta") && contaVivas == 2)
					matriz[i][j] = "Nacer";												//Nacimiento
			}
		}
		for(int i = 0;i<matriz.length;i++)
			for (int j = 0;j<matriz[i].length;j++){
				if(matriz[i][j].equals("Moribunda")){
					matriz[i][j] = ("Muerta");
				}
				else if(matriz[i][j].equals("Nacer")){
					matriz[i][j] = ("Viva");
				}
			}
		}
	
}
