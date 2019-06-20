package DisjoinSet;

import java.util.ArrayList;

import Grafo.Vertice;

public interface DisjoinSet {
	
	public void  makeSet(Integer n);
	
	public void union(int x, int y);
	
	public int findSet(int x);
	
	public int[] getP();
	
}
