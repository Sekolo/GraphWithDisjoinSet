package Grafo;
/**
 * Interface Graph No Dirigido
 * @author Reyes-Rodriguez-Merino, Departamento de Cs. e Ing. de la Computación, UNS.
 */
	public interface Graph_viejo{
		
		
		/**
		 * Devuelve el opuesto del vértice v,'w', del Edge e, (e,v)=w; ocurre un error si e no es incidente o emergente de v.
		 * @param v Vertice a obtener su opuesto.
		 * @param e Edge a obtener opuesto de v.
		 * @return El vertice opuesto de v, en el Edge e.
		 * @throws InvalidVertexException si vertice pasado por parametro es invalido.
		 * @throws InvalidEdgeException si Edge pasado por paramentro es invalido.
		 * @throws GraphException si vertice v y Edge e no se relacionan.
		 */
		public Vertex opposite(Vertex v, Edge e) throws Exception;
		
		/**
		 * Devuelve un arreglo conteniendo los vértices del Edge e.
		 * @param e Edge a obtener sus vertices.
		 * @return Un arreglo (de 2componentes) conteniendo los vértices del Edge e.
		 * @throws InvalidEdgeException si Edge pasado por parametro es invalido.
		 */
		public Vertex[] endVertices(Edge e) throws Exception;
		
		/**
		 * Comprueba si los vértices v y w son adyacentes.
		 * @param v Vertice 1 a probar su adyacencia.
		 * @param w Vertice 2 a probar su adyacencia.
		 * @return True si los vertices son adyacentes, sino false.
		 * @throws InvalidVertexException si cualquiera de los dos vertices, pasados por parametro, son invalidos. 
		 */
		public boolean areAdjacent(Vertex v, Vertex w) throws Exception;
		
		/**
		 * Reemplaza el rótulo del vértice v con x.
		 * @param v Vertice a remplazar su rotulo.
		 * @param x rotulo por el cual se va a remplazar rotulo de v
		 * @return Vertice con su nuevo rotulo.
		 * @throws InvalidVertexException si vertice es invalido.
		 */
		public int replace(Vertex v, int x) throws Exception;
		
		/**
		 * Reemplaza el rótulo del Edge e con x.
		 * @param e Edge a remplazar su rotulo.
		 * @param x rotulo por el cual se va aremplazar rotulo de e.
		 * @return Edge con su nuevo rotulo.
		 * @throws InvalidEdgeException si Edge es invalido.
		 */
		public int replace(Edge e, int x) throws Exception;
		
		/**
		 * Inserta y retorna un nuevo vértice con rótulo x.
		 * @param x Rotulo del nuevo vertice.
		 * @return El nuevo vertice con rotulo x.
		 */
		public Vertex insertVertex(int x);
		
		/**
		 * Inserta un Edge con rotulo x, entre v y w (v-w).
		 * @param v Vertice al cual se le asigna nuevo Edge E(E).
		 * @param w Vertice al cual se le asigna nuevo Edge E(I).
		 * @param x Rotulo del nuevo Edge
		 * @return Nuevo Edge con rotulo x, y vertices v y w.
		 * @throws InvalidVertexException si vertice pasado por parametro es Invalido.
		 */
		public Edge insertEdge(Vertex v, Vertex w, int x) throws Exception;
		
		/**
		 * Elimina el vertice v y elimina todos sus Edges adyacentes.
		 * @param v Vertice a eliminar.
		 * @return Rotulo de vertice eliminado.
		 * @throws InvalidVertexException si vertice pasado por parametro es Invalido.
		 */
		public Vertice removeVertex(Vertex v) throws Exception;
		
		/**
		 * Elimina Edge e y retorna el rotulo de este.
		 * @param e Edge a eliminar.
		 * @return Rotulo de Edge eliminado.
		 * @throws InvalidEdgeException si Edge pasado por parametro es Invalido.
		 */
		public int removeEdge(Edge e) throws Exception;
}