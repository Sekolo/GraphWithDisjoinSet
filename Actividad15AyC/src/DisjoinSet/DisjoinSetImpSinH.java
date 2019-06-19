package DisjoinSet;

import java.util.ArrayList;

//import java.util.ArrayList;


public class DisjoinSetImpSinH implements DisjoinSet{
	private int[] padre;
	//private int[] rank;
	private ArrayList<Integer> p;
	private ArrayList<Integer> ranking;
	
	public DisjoinSetImpSinH(int n) {
		//padre = new int [n];
		//rank = new int[n];
		
		p = new  ArrayList<Integer>(n);
		ranking = new  ArrayList<Integer>(n);
		/*for (int i=0; i<n;i++ ) {
			makeSet(i);
		}	*/
	}
	
	public void  makeSet(Integer n){
		//padre[n] = n;
		//rank[n] = 0;
		p.add(n);
		ranking.add(0);
	}
	
	public void union(int x, int y) {
		link(findSet(x), findSet(y));
	}
	
	
	// Naive implementation of find 
	int findR(int parent[], int i) 
	{ 
	    if (parent[i] == -1) 
	        return i; 
	    return findR(parent, parent[i]); 
	} 
	   
	// Naive implementation of union() 
	void UnionR(int parent[], int x, int y) 
	{ 
	    int xset = findR(parent, x); 
	    int yset = findR(parent, y); 
	    parent[xset] = yset; 
	}
	
	private void link(int x, int y) {
		//padre[y] = x;
		p.set(y, x); 
		//if (rank[x] == rank[y])
			//rank[y] += 1;
		if (ranking.get(x) == ranking.get(y)) {
			ranking.set(y, ranking.get(y) + 1);
		}
			
		
	}
	
	
	public int findSet(int x) {
		/*if (padre[x] != x)
			return findSet(padre[x]);*/
		
		if (p.get(x) != x)
			return findSet(p.get(x));
		return p.get(x);
	}
	
	
	public int[] getP() {
		return padre;
	}
	public ArrayList<Integer> getPadre() {
		return p;
	}

	@Override
	public boolean conexo() {
		// TODO Auto-generated method stub
		return false;
	}
	

}
