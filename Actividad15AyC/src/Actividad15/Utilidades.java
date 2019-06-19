
package Actividad15;

import java.util.ArrayList;
import java.util.LinkedList;
import DisjoinSet.DisjoinSetImp;
import DisjoinSet.DisjoinSet;
import Grafo.Arco;
import Grafo.Vertice;
import Grafo.Grafo;
import Heap.Heap;
import Heap.MinHeap;

public class Utilidades {
	
	private boolean[] visitados;
	
	public void setVisitados(int n) {
		visitados = new boolean[n];
	}
	
	public boolean BFS (Grafo G)
	{
		
		boolean Esconexo = true;
		int i=0;
		// Genero mi arreglo de visitados
		setVisitados(G.getVerticesCount());
		// Seteo todos los visitados como false
		for (int j=0; j<G.getVerticesCount(); j++)
			visitados[j] = false;
		
		while (i<G.getVerticesCount() && Esconexo)
		{		// Accede con i=0 
			if (!visitados[i])
			{ //Si accede mas de una vez no es conexo
				if(i!=0) { 
					Esconexo = false;
				}
				else {
					RecorridoNivel(G);
				}
			}
			i++;
		}
		return Esconexo;
	}
	
	public void RecorridoNivel(Grafo G)
	{
		LinkedList<Vertice> queue = new LinkedList<Vertice>();
		// Obtengo el primer vertice
		Vertice v = G.getVertices().get(0);
		queue.add(v);
		visitados[v.element()]=true;
		// Hasta que la cola sea vacia
		while (queue.size() != 0) {	
			Vertice s = queue.poll(); 
					for (int j = 0; j < s.getAdyacentes().size(); j++) {
						try {
							//Obtengo el vertice opuesto a s
							Vertice Vady=G.opposite(s , s.getAdyacentes().get(j));
							//Si no fue visitado lo visito y lo agrego ala cola
							if (!visitados[Vady.element()])  {
								visitados[Vady.element()] = true; 
								queue.add(Vady); 
							}
						}
						catch(Exception e) {}
					}
					
				}
			
		
			
	}
	
	public ArrayList<Arco> Kruskal(Grafo G){
		//Creo el heap y el DisjoinSet con su tamaño correspondiente.
		//Ademas creo la lista donde voy a guardar el Arbol minimal de cubrimiento.
		System.out.println("Esto tiraa el null");
        Heap heap = new MinHeap(G.getArcosCount());
        DisjoinSet ds = new DisjoinSetImp(G.getVerticesCount());
        ArrayList<Arco> amc = new ArrayList<>();

   
        System.out.println("arranca kruskal por dentro");
             
        LinkedList<Vertice> queue = new LinkedList<Vertice>(); 
		
		visitados = new boolean[G.getVertices().size()];
		
		ArrayList<Vertice> verts = G.getVertices();
		
		for(int i = 0; i < verts.size() ; i++) {
			ds.makeSet(i);
			visitados[i] = false;
			}
		
		try {
			Vertice s =  verts.get(0);
			visitados[s.element()]=true; 
	        queue.add(s); 
			
			while (queue.size() != 0) {	
				
				s = queue.poll(); 
				
				for(int i = 0; i < verts.size(); i++) {
					
					Vertice n = verts.get(i);
					if (!visitados[n.element()])  {
                	
						for (int j = 0; j < n.getAdyacentes().size(); j++) {
							System.out.println("entre a los arcos");
							heap.insert(n.getAdyacentes().get(j));				
						}
						visitados[n.element()] = true; 
						queue.add(n); 
					} 
				} 
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
        

        //Recorro todos los vertices.
        int index = 0;
        while(index < G.getVerticesCount()-1){
        	//Tomo el arco de menor peso
            Arco edge = heap.popMin();
            //Checkeo a que set pertenece cada vertice del arco.
            int v1_set = ds.findSet(edge.getV1().element());
            int v2_set = ds.findSet(edge.getV2().element());

            //Si son diferentes los uno
            //Sino no los uno para evitar ciclos.
            if(v1_set!=v2_set){
            	amc.add(edge);
                index++;
                ds.union(v1_set,v2_set);
            }
        }
        
        return amc;
    }
} 




