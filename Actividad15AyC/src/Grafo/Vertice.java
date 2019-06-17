package Grafo;

import java.util.ArrayList;

public interface Vertice  {
	
	public void setRotulo(int rot);

	public void addAdyacente(Arco a);
	
	public int element();
	
	public ArrayList<Arco> getAdyacentes();

}
