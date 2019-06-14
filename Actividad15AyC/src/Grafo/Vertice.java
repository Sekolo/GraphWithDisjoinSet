package Grafo;

import java.util.ArrayList;

public class Vertice {
	private int rotulo;
	private ArrayList<Arco> adyacentes;
	//private Position<VerticeL<V,E>> posicionEnNodos;
	
	public Vertice(int rot) {
		rotulo = rot;
		adyacentes = new ArrayList<Arco>();
	}
	
	public void setRotulo(int rot) {  
		rotulo = rot;
	}
	
	/*public void setPosicionEnNodos(Position<VerticeL<V,E>> p) { 
		posicionEnNodos=p;
	}*/
	
	public void addAdyacente(Arco a){
		adyacentes.add(a);
	}
	
	public int element() { 
		return rotulo; 
	}
	
	public ArrayList<Arco> getAdyacentes() {
		return adyacentes;
	}
	
	
	/*public Position<VerticeL<V,E>> getPosicionEnNodos(){
		return posicionEnNodos;
	}*/
}