package GrafoTurbio;
public class ArcoL<V,E>implements Edge<E> {
	private E rotulo;
	private VerticeL<V,E> sucesor, predecesor;
	private Position<ArcoL<V,E>> posicionEnAdyacentesSuc, posicionEnAdyacentesPred;
	
	public ArcoL(E rot,VerticeL<V,E> pre, VerticeL<V,E> suc){
		rotulo= rot;
		predecesor= pre;
		sucesor= suc;
	}
	public void setRotulo(E x){
		rotulo=x;
	}
	public void setPosicionEnAdyacentesSuc(Position<ArcoL<V,E>> p) {
		 posicionEnAdyacentesSuc=p;
	}
	
	public void setPosicionEnAdyacentesPred(Position<ArcoL<V,E>> p) {
		 posicionEnAdyacentesPred=p;
	}
	
	public E element() {
		return rotulo; 
	}
	
	public VerticeL<V,E> getPredecesor() { 
		return predecesor;
	}
	
	public VerticeL<V,E> getSucesor() { 
		return sucesor;
	}
	
	public Position<ArcoL<V,E>>getPosicionEnAdyacentesSuc() {
		return posicionEnAdyacentesSuc;
	}
	public Position<ArcoL<V,E>>getPosicionEnAdyacentesPred() {
		return posicionEnAdyacentesPred;
	}
}