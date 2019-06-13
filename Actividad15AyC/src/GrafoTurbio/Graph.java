package GrafoTurbio;
/**
 * Interface Graph No Dirigido
 * @author Iñaki Barreix y Sebastian Benamo, alumnos de Estructuras de Datos(2015), Departamento de Cs. e Ing. de la Computación, UNS.
 */
	public interface Graph<V, E> {
		/**
		 * Devuelve una colección iterable con todos los vértices del grafo.
		 * @return Una colección iterable con todos los vértices del grafo.
		 */
		public Iterable<Vertex<V>> vertices();
		
		/**
		 * Devuelve una colección iterable con todos los arcos del grafo.
		 * @return Una colección iterable con todos los arcos del grafo.
		 */
		public Iterable<Edge<E>> edges();
		
		/**
		 * Devuelve una colección iterable con todos los arcos incidentes(L) sobre un vértice v.
		 * @param v Vertice a obtener todos sus arcos incidentes.
		 * @return Una colección iterable con todos los arcos incidentes sobre un vértice v.
		 * @throws InvalidVertexException si vertice pasado por parametro es invalido.
		 */
		public Iterable<Edge<E>> incidentEdges(Vertex<V> v) throws InvalidVertexException;
		
		/**
		 * Devuelve el opuesto del vértice v,'w', del arco e, (e,v)=w; ocurre un error si e no es incidente o emergente de v.
		 * @param v Vertice a obtener su opuesto.
		 * @param e Arco a obtener opuesto de v.
		 * @return El vertice opuesto de v, en el arco e.
		 * @throws InvalidVertexException si vertice pasado por parametro es invalido.
		 * @throws InvalidEdgeException si arco pasado por paramentro es invalido.
		 * @throws GraphException si vertice v y arco e no se relacionan.
		 */
		public Vertex<V> opposite(Vertex<V> v, Edge<E> e) throws InvalidVertexException, InvalidEdgeException, GraphException;
		
		/**
		 * Devuelve un arreglo conteniendo los vértices del arco e.
		 * @param e Arco a obtener sus vertices.
		 * @return Un arreglo (de 2componentes) conteniendo los vértices del arco e.
		 * @throws InvalidEdgeException si arco pasado por parametro es invalido.
		 */
		public Vertex<V> [] endVertices(Edge<E> e) throws InvalidEdgeException;
		
		/**
		 * Comprueba si los vértices v y w son adyacentes.
		 * @param v Vertice 1 a probar su adyacencia.
		 * @param w Vertice 2 a probar su adyacencia.
		 * @return True si los vertices son adyacentes, sino false.
		 * @throws InvalidVertexException si cualquiera de los dos vertices, pasados por parametro, son invalidos. 
		 */
		public boolean areAdjacent(Vertex<V> v, Vertex<V> w) throws InvalidVertexException;
		
		/**
		 * Reemplaza el rótulo del vértice v con x.
		 * @param v Vertice a remplazar su rotulo.
		 * @param x rotulo por el cual se va a remplazar rotulo de v
		 * @return Vertice con su nuevo rotulo.
		 * @throws InvalidVertexException si vertice es invalido.
		 */
		public V replace(Vertex<V> v, V x) throws InvalidVertexException;
		
		/**
		 * Reemplaza el rótulo del arco e con x.
		 * @param e Arco a remplazar su rotulo.
		 * @param x rotulo por el cual se va aremplazar rotulo de e.
		 * @return Arco con su nuevo rotulo.
		 * @throws InvalidEdgeException si arco es invalido.
		 */
		public E replace(Edge<E> e, E x) throws InvalidEdgeException;
		
		/**
		 * Inserta y retorna un nuevo vértice con rótulo x.
		 * @param x Rotulo del nuevo vertice.
		 * @return El nuevo vertice con rotulo x.
		 */
		public Vertex<V> insertVertex(V x);
		
		/**
		 * Inserta un arco con rotulo x, entre v y w (v-w).
		 * @param v Vertice al cual se le asigna nuevo arco E(E).
		 * @param w Vertice al cual se le asigna nuevo arco E(I).
		 * @param x Rotulo del nuevo arco
		 * @return Nuevo arco con rotulo x, y vertices v y w.
		 * @throws InvalidVertexException si vertice pasado por parametro es Invalido.
		 */
		public Edge<E> insertEdge(Vertex<V> v, Vertex<V> w, E x) throws InvalidVertexException;
		
		/**
		 * Elimina el vertice v y elimina todos sus arcos adyacentes.
		 * @param v Vertice a eliminar.
		 * @return Rotulo de vertice eliminado.
		 * @throws InvalidVertexException si vertice pasado por parametro es Invalido.
		 */
		public V removeVertex(Vertex<V> v) throws InvalidVertexException;
		
		/**
		 * Elimina arco e y retorna el rotulo de este.
		 * @param e Arco a eliminar.
		 * @return Rotulo de arco eliminado.
		 * @throws InvalidEdgeException si arco pasado por parametro es Invalido.
		 */
		public E removeEdge(Edge<E> e) throws InvalidEdgeException, InvalidPositionException;
}