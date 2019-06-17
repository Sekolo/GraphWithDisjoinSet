package Grafo;

import java.util.ArrayList;

public class Vertice implements Vertex {
	private int rotulo;
	private ArrayList<Edge> adyacentes;
	
	public Vertice(int rot) {
		rotulo = rot;
		adyacentes = new ArrayList<Edge>();
	}
	
	public void setRotulo(int rot) {  
		rotulo = rot;
	}
	
	public void addAdyacente(Edge a){
		adyacentes.add(a);
	}
	
	public int element() { 
		return rotulo; 
	}
	
	public ArrayList<Edge> getAdyacentes() {
		return adyacentes;
	}
	
	
}