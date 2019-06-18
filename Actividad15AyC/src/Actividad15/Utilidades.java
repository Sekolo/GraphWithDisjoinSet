
package Actividad15;

import java.util.ArrayList;
import java.util.LinkedList;

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
	
	public void setVisitados(int n) {
		visitados = new boolean[n];
	}
	
	public boolean BFS (Grafo G)
	{
		boolean Esconexo = true;
		int i=0;
		for (int j=0; j<G.getVerticesCount(); j++)
			visitados[j] = false;

		while (i<G.getVerticesCount() && Esconexo)
		{		
			if (!visitados[i])
			{ 
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
		Vertice v = G.getVertices().get(0);
		queue.add(v);
		visitados[v.element()]=true;
		while (queue.size() != 0) {	
			Vertice s = queue.poll(); 
			for(int i = 0; i < G.getVertices().size(); i++) {
				
				Vertice n = G.getVertices().get(i); 
				if (!visitados[n.element()])  {
	        	
					for (int j = 0; j < n.getAdyacentes().size(); j++) {
	        		
						visitados[n.element()] = true; 
						queue.add(n); 
						
					}
					//visitados[n.element()] = true; 
					//queue.add(n); 
				}
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

       /* //Inicializo el Heap con todos los arcos.
        for (int i = 0; i < G.getArcosCount() ; i++) {
          //  heap.insert(G.getArcos().get(i));
        }*/
   
        System.out.println("arranca kruskal por dentro");
             
        LinkedList<Vertice> queue = new LinkedList<Vertice>(); 
		
		visitados = new boolean[G.getVertices().size()];
		
		ArrayList<Vertice> verts = G.getVertices();
		
		for(int i = 0; i < verts.size() ; i++) {
			ds.makeSet(i);
			visitados[i] = false;
			System.out.println("viste el grafo");
			
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
							//ds.union(n.element(), G.opposite(n, n.getAdyacentes().get(j)).element());
							
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
	
	public void RecorridoBFS (Grafo G) {
		int i=0;
		visitados=new boolean[G.getVerticesCount()];
		for (int j=0; j<G.getVerticesCount(); j++)
			visitados[j] = false;

		while (i < G.getVerticesCount())  {
			
			if (!visitados[i])
				MostrarGrafo(G,i);
			i++;
		}
		
	}
	private void MostrarGrafo (Grafo G,int i) {
		Cola Q = new ColaImp(G.getVerticesCount());
		visitados[i]=true;
		Q.enqueue(G.getVertices().get(i));
			while (!Q.isEmpty())  {
				try {
					Vertice x1 = Q.dequeue();
					for(Arco a: x1.getAdyacentes()) {
						i=a.getV2().element()-1;
						if (!visitados[i]) {
							visitados[i]=true;
							System.out.print(a.getV1());
							System.out.print(a.getV2());
							System.out.print("valor");
							System.out.print(a.getPeso());
						}
						
						
						Q.enqueue(a.getV2());
					}
				} 
				catch (Exception e) {
						e.printStackTrace();
				}
			}
	}
	
	
	int partition(int arr[], int low, int high) { 
		int pivot = arr[high]; 
		int i = (low-1); // index of smaller element 
		for (int j=low; j<high; j++)  { 
			// If current element is smaller than or 
			// equal to pivot 
			if (arr[j] <= pivot) { 
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
	void sort(int arr[], int low, int high) { 
		if (low < high) { 
			/* pi is partitioning index, arr[pi] is 
			now at right place */
			int pi = partition(arr, low, high); 

			// Recursively sort elements before 
			// partition and after partition 
			sort(arr, low, pi-1); 
			sort(arr, pi+1, high); 
		} 
	} 

	
public boolean cone(Grafo g) {
		
		
		
		LinkedList<Vertice> queue = new LinkedList<Vertice>(); 
		
		visitados = new boolean[g.getVertices().size()];
		
		ArrayList<Vertice> verts = g.getVertices();
		
		for(int i = 0; i < verts.size() ; i++) {
			
			visitados[i] = false;
		}
		
		try {	
			Vertice s =  verts.get(0);
			visitados[s.element()]=true; 
	        queue.add(s); 
			
			while (queue.size() != 0) {	
				
				
				s = queue.poll(); 
				
            
				for(int i = 0; i < verts.size(); i++) {
					
					Vertice n = verts.get(i); //i.next(); 
					if (!visitados[n.element()])  {
                	
						for (int j = 0; j < n.getAdyacentes().size(); j++) {
                		
							disj.union(n.element(),g.opposite(n , n.getAdyacentes().get(j)).element());
							
						}
						visitados[n.element()] = true; 
						queue.add(n); 
					} 
			} 
        }
	 
} 




