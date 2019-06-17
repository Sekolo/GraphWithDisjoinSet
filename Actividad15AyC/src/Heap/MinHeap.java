package Heap;

import Grafo.Arco;
import Grafo.ArcoPesado;

//Implementación en Java de la clase MinHeap.
public class MinHeap implements Heap{
	private Arco [] heap; 
	private int size; 
	private int max_size; 
	private static final int FRONT = 1; 

	public MinHeap(int max_size) 
	{ 
		this.max_size = max_size; 
		this.size = 0; 
		heap = new Arco[this.max_size + 1];
		heap[0] = new ArcoPesado(null, null, Integer.MIN_VALUE); 
	} 

	//Funcion para insertar elementos en el heap manteniendo las propiedades de la estructura.
	public void insert(Arco element) 
	{ 
		if (size < max_size) 
		{ 
			heap[++size] = element; 
			int current = size; 
	
			while (heap[current].getPeso() < heap[parent(current)].getPeso()) 
			{ 
				swap(current, parent(current)); 
				current = parent(current); 
			}
		} 
	} 

	//Función para la extracción del minimo elemento del heap, manteniendo la propiedad de orden del heap.
	public Arco popMin() 
	{ 
		Arco popped = heap[FRONT]; 
		heap[FRONT] = heap[size--]; 
		minHeapify(FRONT); 
		return popped; 
	}
	
	//Función para solicitar el padre de un elemento.
	private int parent(int pos) 
	{ 
		return pos / 2; 
	} 

	//Función para solicitar el hijo izquierdo de un elemento.
	private int leftChild(int pos) 
	{ 
		return (2 * pos); 
	} 

	//Función para solicitar el hijo derecho de un elemento.
	private int rightChild(int pos) 
	{ 
		return (2 * pos) + 1; 
	} 

	//Función para consultar si elemento es hoja del heap.
	private boolean isLeaf(int pos) 
	{ 
		return (pos >= (size / 2) && pos <= size);
	} 

	//Función para intercambiar de lugar dos elementos.
	private void swap(int fpos, int spos) 
	{ 
		Arco tmp; 
		tmp = heap[fpos]; 
		heap[fpos] = heap[spos]; 
		heap[spos] = tmp; 
	} 

	//Función para reordenar el elemento en esa posicion para mantener la propiedad de heap.
	private void minHeapify(int pos) 
	{ 
		if (!isLeaf(pos)) 
		{ 
			if (heap[pos].getPeso() > heap[leftChild(pos)].getPeso() || heap[pos].getPeso() > heap[rightChild(pos)].getPeso()) 
			{ 
				if (heap[leftChild(pos)].getPeso() < heap[rightChild(pos)].getPeso()) 
				{ 
					swap(pos, leftChild(pos)); 
					minHeapify(leftChild(pos)); 
				}
				else 
				{ 
					swap(pos, rightChild(pos)); 
					minHeapify(rightChild(pos)); 
				} 
			} 
		} 
	} 
	
}
