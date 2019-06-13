package Actividad15;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class DisjoinSet {
	private int[] padre;
	private int[] rank;
	private int tam;
	
	public DisjoinSet(int n) {
		padre = new int [n];
		rank = new int[n];
		tam = n;
		
		for (int i=0; i<n;i++ ) {
			makeSet(i);
		}
			
	}
	
	public void  makeSet(Integer n){
		padre[n] = n;
		rank[n] = 0;
	}
	
	public void union(int x, int y) {
		link(findSet(x), findSet(y));
	}
	
	private void link(int x, int y) {
		if (rank[x] > rank[y])
			padre[y] = x;
		else
			padre[x] = y;
		
		if (rank[x] == rank[y])
			rank[y] += 1;
	}
	
	public int findSet(int x) {
		if (padre[x] != x)
			padre[x]= findSet(padre[x]);
		
		return padre[x];
	}
	
	
	public boolean conexo() {
		int raiz = findSet(padre[0]);
		boolean conex = true;
		for (int i = 1; i < padre.length; i++) {
			if (findSet(padre[i]) != raiz)
				conex = false;
		}
		
		return conex;
	}
	
	
	/*public boolean spereTree() {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(tam);
		
		for ()
		
		for (int i = 0; i < padre.length; i++ ) {
			minHeap.add(padre[])
		}
	}*/
	

}
