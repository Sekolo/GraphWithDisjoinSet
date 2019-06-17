package Heap;

import Grafo.Edge;

//Implementación en Java de la interfaz Heap
public interface Heap {
	
	//Funcion para insertar elementos en el heap manteniendo las propiedades de la estructura.
	public void insert(Edge element);
	
	//Función para la extracción del minimo elemento del heap, manteniendo la propiedad de orden del heap.
	public Edge popMin();
}
