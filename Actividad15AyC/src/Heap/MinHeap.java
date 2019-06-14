package Heap;

//Implementaci�n en Java de la clase MinHeap.
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

	//Funci�n para la extracci�n del minimo elemento del heap, manteniendo la propiedad de orden del heap.
	public int popMin() 
	{ 
		int popped = heap[FRONT]; 
		heap[FRONT] = heap[size--]; 
		minHeapify(FRONT); 
		return popped; 
	}
	
	//Funci�n para solicitar el padre de un elemento.
	private int parent(int pos) 
	{ 
		return pos / 2; 
	} 

	//Funci�n para solicitar el hijo izquierdo de un elemento.
	private int leftChild(int pos) 
	{ 
		return (2 * pos); 
	} 

	//Funci�n para solicitar el hijo derecho de un elemento.
	private int rightChild(int pos) 
	{ 
		return (2 * pos) + 1; 
	} 

	//Funci�n para consultar si elemento es hoja del heap.
	private boolean isLeaf(int pos) 
	{ 
		if (pos >= (size / 2) && pos <= size) 
		{ 
			return true; 
		} 
		return false; 
	} 

	//Funci�n para intercambiar de lugar dos elementos.
	private void swap(int fpos, int spos) 
	{ 
		int tmp; 
		tmp = heap[fpos]; 
		heap[fpos] = heap[spos]; 
		heap[spos] = tmp; 
	} 

	//Funci�n para reordenar el elemento en esa posicion para mantener la propiedad de heap.
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
