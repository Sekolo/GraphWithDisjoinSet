package GrafoTurbio;

public class GrafoConLista<V,E> implements Graph<V,E> {
	
	protected PositionList<VerticeL<V,E>> nodos;
	
	public GrafoConLista(){
		nodos= new ListaDoblementeEnlazada<VerticeL<V,E>>();
	}
	
	public Iterable<Vertex<V>> vertices() {
		PositionList<Vertex<V>> l = new ListaDoblementeEnlazada<Vertex<V>>();
		for(VerticeL<V,E> v: nodos){
			l.addLast(v);
		}
		return l;
	}

	public Iterable<Edge<E>> edges(){
		PositionList<Edge<E>> lista= new ListaDoblementeEnlazada<Edge<E>>();
		for(VerticeL<V,E> v: nodos){
			for(ArcoL<V,E> e: v.getAdyacentes()){
				if(!esta(e,lista))
					lista.addLast(e);
			}
		}
		return lista;
	}
	
	private boolean esta(Edge<E> e, PositionList<Edge<E>> l){
		for(Edge<E> arco: l)
			if(e==arco)
				return true;
		return false;
	}

	public Iterable<Edge<E>> incidentEdges(Vertex<V> v)
			throws InvalidVertexException {
		VerticeL<V,E> vl=checkVertex(v);
		PositionList<Edge<E>> lista= new ListaDoblementeEnlazada<Edge<E>>();
		for(ArcoL<V,E> e : vl.getAdyacentes())
				lista.addLast(e);
		return lista;
	}

	public Vertex<V> opposite(Vertex<V> v, Edge<E> e)
			throws InvalidVertexException, InvalidEdgeException, GraphException {
		VerticeL<V,E> vl= checkVertex(v);
		ArcoL<V,E> al= checkEdge(e);
		if(al.getPredecesor()==vl)
			return al.getSucesor();
		else
			if(al.getSucesor()==vl)
				return al.getPredecesor();
			else
				throw new GraphException("Error, vertice o arco pasado por parametro no se relacionan.");
	}

	public Vertex<V>[] endVertices(Edge<E> e) throws InvalidEdgeException {
		ArcoL<V,E> el=checkEdge(e); 
		Vertex<V>[] a= (Vertex<V>[]) new Object[2];
		a[0]=el.getPredecesor();
		a[1]=el.getSucesor();
		return a;
	}

	public boolean areAdjacent(Vertex<V> v, Vertex<V> w)
			throws InvalidVertexException {
		VerticeL<V,E> vl= checkVertex(v);
		VerticeL<V,E> wl= checkVertex(w);
		for(ArcoL<V,E> a: vl.getAdyacentes())
			if(a.getPredecesor()==wl || a.getSucesor()==vl)
				return true;
		//si recorre todos los arcos de v y no encuentra, v y w no son ady.
		return false;
	}

	public V replace(Vertex<V> v, V x) throws InvalidVertexException {
		VerticeL<V,E> vl= checkVertex(v);
		V aux= vl.element();
		vl.setRotulo(x);
		return aux;
	}

	public E replace(Edge<E> e, E x) throws InvalidEdgeException {
		ArcoL<V,E> al= checkEdge(e);
		E aux= al.element();
		al.setRotulo(x);
		return aux;
	}

	public Vertex<V> insertVertex(V x) {
		VerticeL<V,E> v= new VerticeL<V,E>(x);
		nodos.addLast(v);
		try{
			v.setPosicionEnNodos(nodos.last());
		}catch(EmptyListException e){}
		return v;
	}

	public Edge<E> insertEdge(Vertex<V> v, Vertex<V> w, E x)throws InvalidVertexException {
		VerticeL<V,E> vl=checkVertex(v);
		VerticeL<V,E> wl=checkVertex(w);
		ArcoL<V,E> arco= new ArcoL<V,E>(x,vl,wl);
		vl.addAdyacente(arco);
		wl.addAdyacente(arco);
		try{
			arco.setPosicionEnAdyacentesPred(vl.getAdyacentes().last());
			arco.setPosicionEnAdyacentesSuc(wl.getAdyacentes().last());
		}catch(EmptyListException e){}
		return arco;
		// porque es NO dirigido, si fuera dirigido hacer solo en solo nodo.
	}

	public V removeVertex(Vertex<V> v) throws InvalidVertexException {
		VerticeL<V,E> vl= checkVertex(v);
		V aux=vl.element();
		try{
			for(ArcoL<V,E> arco: vl.getAdyacentes())
					this.removeEdge(arco);
			nodos.remove(vl.getPosicionEnNodos());
		}catch(InvalidPositionException e){}
		catch(InvalidEdgeException i){}
		return aux;
	}

	public E removeEdge(Edge<E> e) throws InvalidEdgeException{
		ArcoL<V,E> el=checkEdge(e);
		E aux= el.element();
		try{ //SE ELIMINA ARCO DE LA LISTA DE  ADY de V (pred) y W(suc) 
			el.getPredecesor().getAdyacentes().remove(el.getPosicionEnAdyacentesPred());
			el.getSucesor().getAdyacentes().remove(el.getPosicionEnAdyacentesSuc());
		}catch(InvalidPositionException t){}
		return aux;
	}
	
	private VerticeL<V,E> checkVertex(Vertex<V> v) throws InvalidVertexException{
		if(v==null)
			throw new InvalidVertexException("Vertice Invalido");
		try{
			return (VerticeL<V,E>) v;
		}catch(ClassCastException e){}
		return null;
	}
	private ArcoL<V,E> checkEdge(Edge<E> e) throws InvalidEdgeException{
		if(e== null)
			throw new InvalidEdgeException("Arco Invalido");
		try{
			return (ArcoL<V,E>) e;
		}catch(ClassCastException i){}
		return null;
	}
	public PositionList<Vertex<V>> BFSShell(){
		Map<VerticeL<V,E>,Boolean> map= new MapeoConLista<VerticeL<V,E>,Boolean>();
		PositionList<Vertex<V>> camino= new ListaDoblementeEnlazada<Vertex<V>>();
		try{
			for(VerticeL<V,E> v: nodos)
				map.put(v, false);
		for(VerticeL<V,E> v: nodos)
			if(map.get(v)==true)
				BFS(v, camino, map);
		}catch(InvalidKeyException k){}
		return camino;
	}
	private void BFS(VerticeL<V,E> v, PositionList<Vertex<V>> recorrido, Map<VerticeL<V,E>,Boolean> map){
		Queue<VerticeL<V,E>> cola= new ColaConArregloCircular<VerticeL<V,E>>(30);
		cola.enqueue(v);
		try{
			while(!cola.isEmpty()){			
				v= cola.dequeue();
				recorrido.addLast(v);
				map.put(v, false);
				for(ArcoL<V,E> a : v.getAdyacentes()){
					if(a.getPredecesor()== v){
						if(map.get(a.getSucesor())==false)
							cola.enqueue(a.getSucesor());
					}
					else
						if(map.get(a.getPredecesor())== false)
							cola.enqueue(a.getPredecesor());
				}
			}
		}catch(EmptyQueueException Q){}
	     	catch(InvalidKeyException I){}
	}
	
	private boolean BFS2(Graph<V,E> g, Vertex<V> or, Vertex<V> dest, 
			Map<Vertex<V>, Boolean> marc,Map<Vertex<V>,Vertex<V>> ant){
		Queue<Vertex<V>> cola= new ColaConArregloCircular<Vertex<V>>(10);
		cola.enqueue(or);
		try{
			marc.put(or, true);
			while(!cola.isEmpty()){
				Vertex<V> w= cola.dequeue();
				if(w==dest)
					return true;
				else{
					for(Edge<E> e: g.incidentEdges(w)){
						Vertex<V> op= g.opposite(w, e);
						if(marc.get(op)== false){
							cola.enqueue(op);
							marc.put(op, true);
						}
					}
				}				
			}
		}catch(InvalidKeyException ie){}
		catch(InvalidVertexException ive){}
		catch(InvalidEdgeException iee){}
		catch(EmptyQueueException eqe){}
		catch(GraphException e){}
		return false;
	}

	private int recosto(Graph<V,Integer> g){
		int costo=0;
		try{
		for(Vertex<V> v: g.vertices())
			for(Edge<Integer> e: g.incidentEdges(v))
				costo+=e.element();
		}catch(InvalidVertexException iee){}
		return costo;
	}
}