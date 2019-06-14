package Heap;

//Implementación en Java de la clase MinHeap.
public class MinHeap implements Heap{
	private int [] heap; 
	private int size; 
	private int max_size; 
	private static final int FRONT = 1; 

	public MinHeap(int max_size) 
	{ 
		this.max_size = max_size; 
		this.size = 0; 
		heap = new int[this.max_size + 1]; 
		heap[0] = Integer.MIN_VALUE; 
	} 

	//Funcion para insertar elementos en el heap manteniendo las propiedades de la estructura.
	public void insert(int element) 
	{ 
		if (size < max_size) 
		{ 
			heap[++size] = element; 
			int current = size; 
	
			while (heap[current] < heap[parent(current)]) 
			{ 
				swap(current, parent(current)); 
				current = parent(current); 
			}
		} 
	} 

	//Función para la extracción del minimo elemento del heap, manteniendo la propiedad de orden del heap.
	public int popMin() 
	{ 
		int popped = heap[FRONT]; 
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
		if (pos >= (size / 2) && pos <= size) 
		{ 
			return true; 
		} 
		return false; 
	} 

	//Función para intercambiar de lugar dos elementos.
	private void swap(int fpos, int spos) 
	{ 
		int tmp; 
		tmp = heap[fpos]; 
		heap[fpos] = heap[spos]; 
		heap[spos] = tmp; 
	} 

	//Función para reordenar el elemento en esa posicion para mantener la propiedad de heap.
	private void minHeapify(int pos) 
	{ 
		if (!isLeaf(pos)) 
		{ 
			if (heap[pos] > heap[leftChild(pos)] || heap[pos] > heap[rightChild(pos)]) 
			{ 
				if (heap[leftChild(pos)] < heap[rightChild(pos)]) 
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
