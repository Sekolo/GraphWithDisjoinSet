package DisjoinSet;

//import java.util.ArrayList;


public class DisjoinSetImp implements DisjoinSet{
	private int[] padre;
	private int[] rank;
	
	
	public DisjoinSetImp(int n) {
		padre = new int [n];
		rank = new int[n];
		
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
	
	
	public void unionSinHeu(int x, int y) {
		linkSinHeu(findSetSinHeu(x), findSet(y));
	}
	
	private void linkSinHeu(int x, int y) {
		padre[x] = y;
		
		if (rank[x] == rank[y])
			rank[y] += 1;
	}
	
	public int findSet(int x) {
		if (padre[x] != x)
			padre[x]= findSet(padre[x]);
		
		return padre[x];
	}
	
	public int findSetSinHeu(int x) {
		if (padre[x] != x)
			return findSet(padre[x]);
		
		return padre[x];
	}
	

	
	public int[] getP() {
		return padre;
	}
	

}
