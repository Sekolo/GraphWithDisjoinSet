package GrafoTurbio;

public class DNodo<E> implements Position<E> {
	private DNodo<E> prev, next;
	private E dato;
	public DNodo(DNodo<E> p, DNodo<E> s, E d){
		prev=p;
		next=s;
		dato=d;
	}
	public DNodo(E d){
		prev=null;
		next=null;
		dato=d;
	}
	public void setNext(DNodo<E> s){
		next=s;
	}
	public void setPrev(DNodo<E> a){
		prev=a;
	}
	public void setElement(E e){
		dato=e;
	}
	public DNodo<E> getNext(){
		return next;
	}
	public DNodo<E> getPrev(){
		return prev;
	}
	public E element(){
		return dato;
	}

}
