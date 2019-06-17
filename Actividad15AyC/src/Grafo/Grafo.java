package Grafo;

import java.util.ArrayList;

public interface Grafo {
	
	public ArrayList<Vertice> getVertices();
	
	public int getVerticesCount();
	
	public int getArcosCount();
	
	
	/**
	 * Devuelve el opuesto del vértice v,'w', del Arco e, (e,v)=w; ocurre un error si e no es incidente o emergente de v.
	 * @param v Vertice a obtener su opuesto.
	 * @param e Arco a obtener opuesto de v.
	 * @return El vertice opuesto de v, en el Arco e.
	 * @throws InvalidVertexException si vertice pasado por parametro es invalido.
	 * @throws InvalidArcoException si Arco pasado por paramentro es invalido.
	 * @throws GraphException si el vertice v y el Arco e no se relacionan.
	 */
	public Vertice opposite(Vertice v, Arco e) throws Exception;
	
	/**
	 * Devuelve un arreglo conteniendo los vértices del Arco e.
	 * @param e Arco a obtener sus vertices.
	 * @return Un arreglo (de 2componentes) conteniendo los vértices del Arco e.
	 * @throws InvalidArcoException si el Arco pasado por parametro es invalido.
	 */
	public Vertice[] endVertices(Arco e) throws Exception;
	
	/**
	 * Comprueba si los vértices v y w son adyacentes.
	 * @param v Vertice 1 a probar su adyacencia.
	 * @param w Vertice 2 a probar su adyacencia.
	 * @return True si los vertices son adyacentes, sino false.
	 * @throws InvalidVertexException si cualquiera de los dos vertices, pasados por parametro, son invalidos. 
	 */
	public boolean areAdjacent(Vertice v, Vertice w) throws Exception;
	
	/**
	 * Reemplaza el rótulo del vértice v con x.
	 * @param v Vertice a remplazar su rotulo.
	 * @param x rotulo por el cual se va a remplazar rotulo de v
	 * @return Vertice con su nuevo rotulo.
	 * @throws InvalidVertexException si el vertice es invalido.
	 */
	public int replace(Vertice v, int x) throws Exception;
	
	/**
	 * Reemplaza el rótulo del Arco e con x.
	 * @param e Arco a remplazar su rotulo.
	 * @param x rotulo por el cual se va aremplazar rotulo de e.
	 * @return Arco con su nuevo rotulo.
	 * @throws InvalidArcoException si el Arco es invalido.
	 */
	public int replace(Arco e, int x) throws Exception;
	
	/**
	 * Inserta y retorna un nuevo vertice con rótulo x.
	 * @param x Rotulo del nuevo vertice.
	 * @return El nuevo vertice con rotulo x.
	 */
	public Vertice insertVertex(int x);
	
	/**
	 * Inserta un Arco con rotulo x, entre v y w (v-w).
	 * @param v Vertice al cual se le asigna nuevo Arco.
	 * @param w Vertice al cual se le asigna nuevo Arco.
	 * @param x Rotulo del nuevo Arco
	 * @return Nuevo Arco con rotulo x, y vertices v y w.
	 * @throws InvalidVertexException si el vertice pasado por parametro es Invalido.
	 */
	public Arco insertArco(Vertice v, Vertice w, int x) throws Exception;
	
	/**
	 * Elimina el vertice v y elimina todos sus Arcos adyacentes.
	 * @param v Vertice a eliminar.
	 * @return Rotulo de vertice eliminado.
	 * @throws InvalidVertexException si el vertice pasado por parametro es Invalido.
	 */
	public Vertice removeVertex(Vertice v) throws Exception;
	
	/**
	 * Elimina Arco e y retorna el rotulo de este.
	 * @param e Arco a eliminar.
	 * @return Rotulo de Arco eliminado.
	 * @throws InvalidArcoException si el Arco pasado por parametro es Invalido.
	 */
	public int removeArco(Arco e) throws Exception;


}
