package Grafo;

import java.util.ArrayList;

public class VerticeImp implements Vertice {
	private int rotulo;
	private ArrayList<Arco> adyacentes;
	
	public VerticeImp(int rot) {
		rotulo = rot;
		adyacentes = new ArrayList<Arco>();
	}
	
	public void setRotulo(int rot) {  
		rotulo = rot;
	}
	
	public void addAdyacente(Arco a){
		adyacentes.add(a);
	}
	
	public int element() { 
		return rotulo; 
	}
	
	public ArrayList<Arco> getAdyacentes() {
		return adyacentes;
	}
	
	
}