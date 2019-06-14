package Grafo;

import java.util.ArrayList;

public interface Vertex  {
	
	public void setRotulo(int rot);

	public void addAdyacente(Edge a);
	
	public int element();
	
	public ArrayList<Edge> getAdyacentes();

}
