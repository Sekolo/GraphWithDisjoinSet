
package Actividad15;

import java.util.ArrayList;

import Cola.ColaImp;
import DisjoinSet.DisjoinSetImp;
import DisjoinSet.DisjoinSet;
import Cola.Cola;
import Grafo.Arco;
import Grafo.Vertice;
import Grafo.Grafo;
import Heap.Heap;
import Heap.MinHeap;

public class Utilidades {
	
	private boolean[] visitados;
	
	public boolean BFS (Grafo G)
	{
		int conexo=0;
		boolean Esconexo=true;
		int i=0;
		visitados=new boolean[G.getVerticesCount()];
		for (int j=0; j<G.getVerticesCount(); j++)
			visitados[j] = false;

		while (i<G.getVerticesCount() && Esconexo)
		{		
			if (!visitados[i])
			{ 
				conexo++;
				if(conexo==1)
					RecorridoNivel(G,i);
				else
					Esconexo=false;
			}
			i++;
		}
		return Esconexo;
	}
	
	private void RecorridoNivel (Grafo G,int i)
	{
		Cola Q = new ColaImp(G.getVerticesCount());
		visitados[i]=true;
		Q.enqueue(G.getVertices().get(i));
			while (!Q.isEmpty()) 
			{
				try
				{
					Vertice x1 = Q.dequeue();
					for(Arco a: x1.getAdyacentes())
					{
						i++;
						if (!visitados[i]) 
						visitados[i]=true; 
						Q.enqueue(a.getV2());
					}
				} 
				catch (Exception e) 
				{
						e.printStackTrace();
				}
			}
	}
	
	public ArrayList<Arco> Kruskal(Grafo G){
		//Creo el heap y el DisjoinSet con su tamaño correspondiente.
		//Ademas creo la lista donde voy a guardar el Arbol minimal de cubrimiento.
        Heap heap = new MinHeap(G.getArcosCount());
        DisjoinSet ds = new DisjoinSetImp(G.getVerticesCount());
        ArrayList<Arco> amc = new ArrayList<>();

        //Inicializo el Heap con todos los arcos.
        for (int i = 0; i < G.getArcosCount() ; i++) {
            heap.insert(G.getArcos().get(i));
        }

        //Recorro todos los vertices.
        int index = 0;
        while(index < G.getVerticesCount()-1){
        	//Tomo el arco de menor peso
            Arco edge = heap.popMin();
            
            //check if adding this edge creates a cycle
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



