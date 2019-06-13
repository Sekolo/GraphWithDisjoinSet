package GrafoTurbio;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class ListaIterator<E> implements Iterator<E> {
	
	protected PositionList<E> L;
	protected Position<E> cursor;
	
	public ListaIterator(PositionList<E> lista){
		L=lista;
		try{
		cursor=(L.isEmpty()? null:L.first());
		}catch(EmptyListException  o){};
	}
	
	public E next(){
		
		if(cursor==null)
			throw new NoSuchElementException("No hay siguiente.");
		else{
			E toReturn=cursor.element();
			try{
				cursor=(cursor==L.last()? null:L.next(cursor));
				return toReturn;
				}
			catch(EmptyListException o){return null;}
			catch(InvalidPositionException p){return null;}
			catch(BoundaryViolationException v){return null;}
		
		}
	
	}
	
	public boolean hasNext(){
		return cursor!=null;
	}

}