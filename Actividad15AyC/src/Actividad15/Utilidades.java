
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
	
	public void RecorridoBFS (Grafo G)
	{
		int i=0;
		visitados=new boolean[G.getVerticesCount()];
		for (int j=0; j<G.getVerticesCount(); j++)
			visitados[j] = false;

		while (i<G.getVerticesCount())
		{		
			if (!visitados[i])
				MostrarGrafo(G,i);
			i++;
		}
		
	}
	private void MostrarGrafo (Grafo G,int i)
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
						{
							visitados[i]=true;
							System.out.print(a.getV1());
							System.out.print(a.getV2());
							System.out.print("valor");
							System.out.print(a.getPeso());
						}
						
						
						Q.enqueue(a.getV2());
					}
				} 
				catch (Exception e) 
				{
						e.printStackTrace();
				}
			}
	}
	
	
	int partition(int arr[], int low, int high) 
	{ 
		int pivot = arr[high]; 
		int i = (low-1); // index of smaller element 
		for (int j=low; j<high; j++) 
		{ 
			// If current element is smaller than or 
			// equal to pivot 
			if (arr[j] <= pivot) 
			{ 
				i++; 

				// swap arr[i] and arr[j] 
				int temp = arr[i]; 
				arr[i] = arr[j]; 
				arr[j] = temp; 
			} 
		} 

		// swap arr[i+1] and arr[high] (or pivot) 
		int temp = arr[i+1]; 
		arr[i+1] = arr[high]; 
		arr[high] = temp; 

		return i+1; 
	} 


	/* The main function that implements QuickSort() 
	arr[] --> Arreglo a ordenar, 
	low --> index inicial, 
	high --> index final */
	void sort(int arr[], int low, int high) 
	{ 
		if (low < high) 
		{ 
			/* pi is partitioning index, arr[pi] is 
			now at right place */
			int pi = partition(arr, low, high); 

			// Recursively sort elements before 
			// partition and after partition 
			sort(arr, low, pi-1); 
			sort(arr, pi+1, high); 
		} 
	} 

	

	 
} 




