package GrafoTurbio;

public class MapeoConLista<K,V> implements Map<K,V> {
	protected PositionList<Entrada<K,V>> s;
	public MapeoConLista(){
		s= new ListaDoblementeEnlazada<Entrada<K,V>>();
	}
	public int size() {
		return s.size();
	}

	public boolean isEmpty() {
		return s.size()==0;
	}

	public V get(K k) throws InvalidKeyException {
		checkKey(k);
		for(Position<Entrada<K,V>> p: s.positions())
			if(p.element().getKey().equals(k))
				return p.element().getValue();
		return null;
	}

	public V put(K k, V v) throws InvalidKeyException{
		checkKey(k);
			for(Position<Entrada<K,V>> p: s.positions())
				if(p.element().getKey().equals(k)){
					V aux= p.element().getValue();
					p.element().setValue(v);
					return aux;
				}
		s.addLast(new Entrada <K,V> (k, v));
		return null;
	}

	public V remove(K k) throws InvalidKeyException{
		checkKey(k);
		for(Position<Entrada<K,V>> p: s.positions())
			if(p.element().getKey().equals(k)){
				V v = p.element().getValue();
				try {
					s.remove(p);
				}catch (InvalidPositionException e){} 
				return v;
			}
	return null;
	}

	public Iterable<K> keys() {
		PositionList<K> l= new ListaDoblementeEnlazada<K>();
		for (Entry<K,V> e: s)
			l.addLast(e.getKey());
		return l;
	}

	public Iterable<V> values() {
		PositionList<V> l= new ListaDoblementeEnlazada<V>();
		for (Entry<K,V> e: s)
			l.addLast(e.getValue());
		return l;
	}

	public Iterable<Entry<K, V>> entries() {
		PositionList<Entry<K, V>> l= new ListaDoblementeEnlazada<Entry<K, V>>();
		for (Entry<K,V> e: s)
			l.addLast(e);
		return l;
	}
	private void checkKey(K k)throws InvalidKeyException {
		if(k==null)
			throw new InvalidKeyException("Clave Invalida");
	}
}