package GrafoTurbio;
public class VerticeL<V,E> implements Vertex<V> {
	private V rotulo;
	private PositionList<ArcoL<V,E>> adyacentes;
	private Position<VerticeL<V,E>> posicionEnNodos;
	
	public VerticeL( V rot) {
		rotulo = rot;
		adyacentes = new ListaDoblementeEnlazada<ArcoL<V,E>>();
	}
	
	public void setRotulo(V rot) {  
		rotulo= rot;
	}
	
	public void setPosicionEnNodos(Position<VerticeL<V,E>> p) { 
		posicionEnNodos=p;
	}
	
	public void addAdyacente(ArcoL<V,E> a){
		adyacentes.addLast(a);
	}
	
	public V element() { 
		return rotulo; 
	}
	
	public PositionList<ArcoL<V,E>> getAdyacentes() {
		return adyacentes;
	}
	
	
	public Position<VerticeL<V,E>> getPosicionEnNodos(){
		return posicionEnNodos;
	}
}