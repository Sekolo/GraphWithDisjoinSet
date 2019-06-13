package GrafoTurbio;
public class ArcoM<V,E> implements Edge<E> {
	private E rotulo;
	private Position<Edge<E>> posicionEnArcos;
	private VerticeM<V> v1, v2;
	
	public ArcoM( E rot, VerticeM<V> va, VerticeM<V> vb ) {
		rotulo = rot; 
		v1 = va; 
		v2 = vb; 
	}
	
	public void setPosicionEnArcos( Position<Edge<E>> p ) { 
		posicionEnArcos = p; 
	}
	
	public void setRotulo(E rot) { 
		rotulo = rot; 
	}
	
	public E element() { 
		return rotulo; 
	}
	
	public Position<Edge<E>> getPosicionEnArcos() { 
		return posicionEnArcos; 
	}
	public VerticeM<V> getV1() { 
		return v1; 
	}
	public VerticeM<V> getV2() { 
		return v2; 
	}
}