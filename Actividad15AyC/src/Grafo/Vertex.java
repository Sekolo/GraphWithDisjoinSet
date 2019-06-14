package Grafo;

import java.util.ArrayList;

public interface Vertex<E>  {
	
	public void setRotulo(int rot);

	public void addAdyacente(Edge a);
	
	public int element();
	
	public ArrayList<Edge> getAdyacentes();

}
