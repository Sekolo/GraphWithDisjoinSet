package DisjoinSet;

import java.util.ArrayList;

//import java.util.ArrayList;


public class DisjoinSetImpSinH implements DisjoinSet{
	private int[] padre;
	//private int[] rank;
	private ArrayList<Integer> p;
	private ArrayList<Integer> ranking;
	
	public DisjoinSetImpSinH(int n) {
		
		
		p = new  ArrayList<Integer>(n);
		ranking = new  ArrayList<Integer>(n);
		
	}
	
	public void  makeSet(Integer n){

		p.add(n);
		ranking.add(0);
	}
	
	public void union(int x, int y) {
		link(findSet(x), findSet(y));
	}
	
	
	
	int findR(int parent[], int i) 
	{ 
	    if (parent[i] == -1) 
	        return i; 
	    return findR(parent, parent[i]); 
	} 
	   
 
	void UnionR(int parent[], int x, int y) 
	{ 
	    int xset = findR(parent, x); 
	    int yset = findR(parent, y); 
	    parent[xset] = yset; 
	}
	
	private void link(int x, int y) {
	
		p.set(y, x); 
		
		if (ranking.get(x) == ranking.get(y)) {
			ranking.set(y, ranking.get(y) + 1);
		}
			
		
	}
	
	
	public int findSet(int x) {
		
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


	

}
