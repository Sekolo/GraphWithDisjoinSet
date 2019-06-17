package Heap;

import Grafo.Arco;

//Implementaci�n en Java de la interfaz Heap
public interface Heap {
	
	//Funcion para insertar elementos en el heap manteniendo las propiedades de la estructura.
	public void insert(Arco element);
	
	//Funci�n para la extracci�n del minimo elemento del heap, manteniendo la propiedad de orden del heap.
	public Arco popMin();
}
