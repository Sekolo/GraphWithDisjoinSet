package Heap;

public class MinHeap {
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

	public int popMin() 
	{ 
		int popped = heap[FRONT]; 
		heap[FRONT] = heap[size--]; 
		minHeapify(FRONT); 
		return popped; 
	}
	
	public void print() 
    { 
        for (int i = 1; i <= size / 2; i++) { 
            System.out.print(" Padre: " + heap[i] 
                             + ", Hijo izquierdo: " + heap[2 * i] 
                             + ", Hijo derecho: " + heap[2 * i + 1]); 
            System.out.println(); 
        } 
    } 
	
	private int parent(int pos) 
	{ 
		return pos / 2; 
	} 

	private int leftChild(int pos) 
	{ 
		return (2 * pos); 
	} 

	private int rightChild(int pos) 
	{ 
		return (2 * pos) + 1; 
	} 

	private boolean isLeaf(int pos) 
	{ 
		if (pos >= (size / 2) && pos <= size) 
		{ 
			return true; 
		} 
		return false; 
	} 

	private void swap(int fpos, int spos) 
	{ 
		int tmp; 
		tmp = heap[fpos]; 
		heap[fpos] = heap[spos]; 
		heap[spos] = tmp; 
	} 

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
