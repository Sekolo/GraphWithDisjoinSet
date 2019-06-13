package GrafoTurbio;
public class VerticeM<V> implements Vertex<V> {
	private V rotulo;
	private int indice;
	private Position<Vertex<V>> posicionEnVertices;
	
	public VerticeM(V rot, int ind) { 
		rotulo = rot;
		ind = indice; 
	}
	public void setPosicionEnVertices(Position<Vertex<V>> p ) {
		posicionEnVertices = p; 
	}
	public void setRotulo(V rot) { 
		rotulo = rot; 
	}
	public int getIndice() { 
		return indice; 
	}
	public Position<Vertex<V>> getPositionEnVertices() { 
		return posicionEnVertices; 
	}
	public V element() { 
		return rotulo; 
	}
}