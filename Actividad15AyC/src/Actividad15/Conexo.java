package Actividad15;

import java.util.ArrayList;
import java.util.LinkedList;

import Cola.Cola;
import Cola.ColaImp;
import DisjoinSet.DisjoinSet;
import DisjoinSet.DisjoinSetImp;
import Grafo.Arco;
import Grafo.Grafo;
import Grafo.Vertice;
import Grafo.VerticeImp;

public class Conexo {
	
	private boolean[] visitados;
	
	private DisjoinSet disj;
	
	public boolean cone(Grafo g) {
		
		//ColaImp c = new ColaImp(g.getVertices().size());
		disj = new DisjoinSetImp(g.getVertices().size());
		
		LinkedList<Vertice> queue = new LinkedList<Vertice>(); 
		
		visitados = new boolean[g.getVertices().size()];
		
		ArrayList<Vertice> verts = g.getVertices();
		
		for(int i = 0; i < verts.size() ; i++) {
			disj.makeSet(i);
			visitados[i] = false;
		}
		
		try {	
			Vertice s =  verts.get(0);
			visitados[s.element()]=true; 
	        queue.add(s); 
			
			while (queue.size() != 0) {	
				
				// Dequeue a vertex from queue and print it 
				s = queue.poll(); 
				//System.out.print(s.element()+" "); 
			  
				// Get all adjacent vertices of the dequeued vertex s 
				// If a adjacent has not been visited, then mark it 
				// visited and enqueue it 
				// Iterator<Vertice> i = v[s].listIterator(); 
            
				for(int i = 0; i < verts.size(); i++) {
					//while (i.hasNext()) 
					//{ 
					Vertice n = verts.get(i); //i.next(); 
					if (!visitados[n.element()])  {
                	
						for (int j = 0; j < n.getAdyacentes().size(); j++) {
                		
							disj.union(n.element(),g.opposite(n , n.getAdyacentes().get(j)).element());
							//System.out.println( "El nodo "+ i +" tiene los arcos "+g.opposite(n , n.getAdyacentes().get(j)).element());
						}
						visitados[n.element()] = true; 
						queue.add(n); 
					} 
			} 
        }
			
//			for(int i = 0; i < verts.size() ; i++) {
//				ArrayList<Arco> adj = verts.get(i).getAdyacentes();
//				c.enqueue(verts.get(i));
//				for(int j = 0; j < verts.size() ; j++) {
//					
//					Vertice op = g.opposite(verts.get(i), verts.get(i).getAdyacentes().get(j));
//					
//					if (visitados[op.element()] = false) {
//						
//						disj.union(verts.get(i).element(), op.element());
//						visitados[op.element()] = true;
//					}
//				}
//			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int[] padre = disj.getP();
		
		int raiz = disj.findSet(padre[0]);
		boolean conex = true;
		
		System.out.print( "Vector de DisjoinSet: ");
		for (int i = 1; i < padre.length; i++) {
			System.out.print( padre[i]+" ");
			if (disj.findSet(padre[i]) != raiz)
				conex = false;
		}
		System.out.println( "aqui termina el vector ");
		System.out.println();
		return conex;
		
		
	}
	
	
	
	

}
