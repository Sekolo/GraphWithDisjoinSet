package GrafoTurbio;

public class GrafoConMatriz<V,E> implements Graph<V,E>{

	protected PositionList<Vertex<V>> vertices;
	protected PositionList<Edge<E>> arcos;
	protected Edge<E>[][] matriz;
	protected int cantVertices;
	
	public GrafoConMatriz(int n){
		vertices= new ListaDoblementeEnlazada<Vertex<V>>();
		arcos= new ListaDoblementeEnlazada<Edge<E>>();
		cantVertices=0;
		matriz= (Edge<E>[][])new Object[n][n];
		//profe matriz= (Edge[][]) new ArcoM[n][n];
	}
	
	public Iterable<Vertex<V>> vertices() {
		PositionList<Vertex<V>> l= new ListaDoblementeEnlazada<Vertex<V>>();
		for(Vertex<V> v: vertices)
			l.addLast(v);
		return l;
	}

	public Iterable<Edge<E>> edges() {
		PositionList<Edge<E>> l=new ListaDoblementeEnlazada<Edge<E>>();
		for(Edge<E> e: arcos)	
			l.addLast(e);
		return l;
	}

	public Iterable<Edge<E>> incidentEdges(Vertex<V> v) throws InvalidVertexException {
		VerticeM<V> vm=checkVertex(v);
		int f= vm.getIndice();
		PositionList<Edge<E>> l= new ListaDoblementeEnlazada<Edge<E>>();
		for(int c=0; c< cantVertices; c++){
			if(matriz[f][c]!= null)
				l.addLast(matriz[f][c]);
		}
		return l;
	}

	public Vertex<V> opposite(Vertex<V> v, Edge<E> e)throws InvalidVertexException, InvalidEdgeException, GraphException {
		VerticeM<V> vm= checkVertex(v);
		ArcoM<V,E> am= checkEdge(e);
		if(am.getV1()==vm)
			return am.getV2();
		else
			if(am.getV2()==vm)
				return am.getV1();
			else
				throw new GraphException("Error, vertice o arco pasado por parametro no se relacionan.");
	}

	public Vertex<V>[] endVertices(Edge<E> e) throws InvalidEdgeException {
		ArcoM<V,E> am=checkEdge(e);
		Vertex<V>[] vt= (Vertex<V>[])new Object[2];
		vt[0]=am.getV1();
		vt[1]=am.getV2();
		return vt;
	}

	public boolean areAdjacent(Vertex<V> v, Vertex<V> w)throws InvalidVertexException {
		VerticeM<V> vm= checkVertex(v);
		VerticeM<V> wm= checkVertex(w);
		int i= vm.getIndice();
		int j= wm.getIndice();
		return matriz[i][j]!=null;
	}

	public V replace(Vertex<V> v, V x) throws InvalidVertexException {
		VerticeM<V> vm= checkVertex(v);
		V aux= vm.element();
		vm.setRotulo(x);
		return aux;
	}
	
	public E replace(Edge<E> e, E x) throws InvalidEdgeException {
		ArcoM<V,E> am= checkEdge(e);
		E aux= am.element();
		am.setRotulo(x);		
		return aux;
	}

	public Vertex<V> insertVertex(V x) {
		VerticeM<V> v= new VerticeM<V>(x, cantVertices++);
		vertices.addLast(v);
		try{
			v.setPosicionEnVertices(vertices.last());
		}catch(EmptyListException e){}
		return v;
	}

	public Edge<E> insertEdge(Vertex<V> v, Vertex<V> w, E x)throws InvalidVertexException {
		VerticeM<V> vm= checkVertex(v);
		VerticeM<V> wm= checkVertex(w);
		ArcoM<V,E> a= new ArcoM<V,E>(x,vm,wm);
		int f=vm.getIndice();
		int c=vm.getIndice();
		matriz[f][c]=matriz[c][f]=a;
		arcos.addLast(a);
		try{
			a.setPosicionEnArcos(arcos.last());
		}catch(EmptyListException i){}
		return a;
	}

	public V removeVertex(Vertex<V> v) throws InvalidVertexException {
		VerticeM<V> vm= checkVertex(v);
		int f=vm.getIndice();
		try{
			for(int c=0; c<cantVertices; c++)
				removeEdge(matriz[f][c]);
			vertices.remove(vm.getPositionEnVertices());
		}catch (InvalidPositionException i){}
		 catch(InvalidEdgeException u){}
		cantVertices--;
		return vm.element();
	}

	public E removeEdge(Edge<E> e) throws InvalidEdgeException{
		ArcoM<V,E> am= checkEdge(e);
		int i=am.getV1().getIndice();
		int j= am.getV2().getIndice();
		matriz[i][j]=matriz[j][i]= null;
		try{
			arcos.remove(am.getPosicionEnArcos());
		}catch(InvalidPositionException t){}
		return am.element();
	}
	private VerticeM<V> checkVertex(Vertex<V> v)throws InvalidVertexException{
		if(v== null)
			throw new InvalidVertexException("Vertice invalido");
		try{
			return(VerticeM<V>) v;
		}catch(ClassCastException e){}
		return null;
	}
	private ArcoM<V,E> checkEdge(Edge<E> e)throws InvalidEdgeException{
		if(e==null)
			throw new InvalidEdgeException("Arco invalido");
		try{
			return(ArcoM<V,E>) e;
		}catch(ClassCastException t){}
		return null;
	}
}
