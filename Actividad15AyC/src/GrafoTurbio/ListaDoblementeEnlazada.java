package GrafoTurbio;
import java.util.Iterator;
public class ListaDoblementeEnlazada<E> implements PositionList<E> {
	protected DNodo<E> cabeza, cola;
	protected int cant;
	public ListaDoblementeEnlazada(){
		cant=0;
		cabeza=new DNodo<E>(null,null,null);
		cola= new DNodo<E>(cabeza,null,null);
		cabeza.setNext(cola);
	}
	public int size(){
		return cant;
	}
	public boolean isEmpty(){
		return cant==0;
	}
	public Position<E> first() throws EmptyListException{
		if(cant==0)
			throw new EmptyListException ("Lista vacia");
		else
			return cabeza.getNext();
	}
	public Position<E> last() throws EmptyListException{
		if(cant==0)
			throw new EmptyListException ("Lista vacia");
		else
			return cola.getPrev();
	}
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException{
		DNodo<E> n= checkPosition(p);
		if(n.getNext()== cola)
			throw new BoundaryViolationException("El elemento es el ultimo de la lista");
			return n.getNext();
	}
	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException{
		DNodo<E> n= checkPosition(p);
		if(n.getPrev()== cabeza)
			throw new BoundaryViolationException("El elemento es el primero de la lista");
		else
			return n.getPrev();
	}
	public void addFirst(E e){
		DNodo<E> n=new DNodo<E>(cabeza,cabeza.getNext(), e);
		cabeza.setNext(n);
		n.getNext().setPrev(n);
		cant++;
	}
	public void addLast(E e){
		DNodo<E> n=new DNodo<E>(cola.getPrev(),cola, e);
		cola.setPrev(n);
		n.getPrev().setNext(n);
		cant++;
	}
	public void addAfter(Position<E> p, E e) throws InvalidPositionException{
		DNodo<E> ant= checkPosition(p);
		DNodo<E> nuevo= new DNodo<E> (ant,ant.getNext(),e);
		ant.setNext(nuevo);
		nuevo.getNext().setPrev(nuevo);
		cant++;
	}
	public void addBefore(Position<E> p, E e) throws InvalidPositionException{
		DNodo<E> sig= checkPosition(p);
		DNodo<E> nuevo= new DNodo<E> (sig.getPrev(),sig,e);
		sig.setPrev(nuevo);
		nuevo.getPrev().setNext(nuevo);
		cant++;
	}
	public E remove(Position<E> p) throws InvalidPositionException{
		DNodo<E> n= checkPosition(p);
		if(cant==0)
			throw new InvalidPositionException("No se puede eliminar en lista vacia");
		else{
			n.getPrev().setNext(n.getNext());
			n.getNext().setPrev(n.getPrev());
			cant--;
		}
		return n.element();
	}
	public E set(Position<E> p,E e) throws InvalidPositionException{
		if(cant==0)
			throw new InvalidPositionException("Error al querer remplazar algo en una lista vacia");
			DNodo<E> n= checkPosition(p);
			E aux= n.element();
			n.setElement(e);
		return aux;
	}
	public Iterator<E> iterator(){
		return new ListaIterator<E>(this);
	}
	public Iterable<Position<E>> positions(){
		PositionList<Position<E>> l= new ListaDoblementeEnlazada<Position<E>>();
		if(cant!=0){
			DNodo<E> n= cabeza.getNext();
			while(n!= cola){
				l.addLast(n);
				n=n.getNext();
			}			
	}
		return l;
	}
	private DNodo<E> checkPosition(Position<E> p) throws InvalidPositionException{
		if(p==null)
			throw new InvalidPositionException("Posicion vacia");
		if(p==cabeza)
			throw new InvalidPositionException("Posicion cabeza, no valido");
		if(p==cola)
			throw new InvalidPositionException("Posicion cola, no valido");
		try{
			return (DNodo<E>) p;
		}catch (ClassCastException e){ throw new InvalidPositionException("Mal casteo");
		}
		}
}