package DisjoinSet;

//import java.util.ArrayList;


public class DisjoinSetImpSinH implements DisjoinSet{
	private int[] padre;
	private int[] rank;
	
	public DisjoinSetImpSinH(int n) {
		padre = new int [n];
		rank = new int[n];
		/*for (int i=0; i<n;i++ ) {
			makeSet(i);
		}	*/
	}
	
	public void  makeSet(Integer n){
		padre[n] = n;
		rank[n] = 0;
	}
	
	public void union(int x, int y) {
		link(findSet(x), findSet(y));
	}
	
	private void link(int x, int y) {
		padre[x] = y;
		
		if (rank[x] == rank[y])
			rank[y] += 1;
	}
	
	
	public int findSet(int x) {
		if (padre[x] != x)
			return findSet(padre[x]);
		
		return padre[x];
	}
	
	
	public int[] getP() {
		return padre;
	}

	@Override
	public boolean conexo() {
		// TODO Auto-generated method stub
		return false;
	}
	

}
