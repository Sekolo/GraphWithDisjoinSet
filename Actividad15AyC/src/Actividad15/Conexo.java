package Actividad15;

import java.lang.reflect.Array;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

import Cola.Cola;
import Cola.ColaImp;
import DisjoinSet.DisjoinSet;
import DisjoinSet.DisjoinSetImp;
import DisjoinSet.DisjoinSetImpSinH;
import Grafo.Arco;
import Grafo.Grafo;
import Grafo.Vertice;
import Grafo.VerticeImp;
import Heap.Heap;
import Heap.MinHeap;

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
			
//
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
	
	public boolean esConexo(Grafo g) {
		disj = new DisjoinSetImp(g.getVerticesCount());
		ArrayList<Vertice> verts = g.getVertices();
		
		for(int i = 0; i < verts.size(); i++) {
			disj.makeSet(i);
		}
		
		for(int i = 0; i < g.getArcosCount(); i++) {
			System.out.println(g.getArcos().get(i).getV1().element()+"uno con "+g.getArcos().get(i).getV2().element());
			disj.union(g.getArcos().get(i).getV1().element(),g.getArcos().get(i).getV2().element());
		}
		
		System.out.println("");
		int [] pa = disj.getP();
		for(int i = 0; i < pa.length; i++) {
			System.out.print( pa[i]);
		}
		System.out.println("");
		
		
		int raiz = disj.findSet(pa[0]);
		boolean conex = true;
		for (int i = 1; i < pa.length; i++) {
			if (disj.findSet(pa[i]) != raiz)
				conex = false;
		}
		return conex;
	
	}
	
	class ArcoComparator implements Comparator<Arco>{ 
       
        public int compare(Arco a, Arco a2) { 
            if (a.getPeso() > a2.getPeso()) 
                return 1; 
            else if (a.getPeso() < a2.getPeso())
                return -1; 
                            return 0; 
            } 
    }
	
	
	public ArrayList<Arco> Kruskal(Grafo G){
		//Creo el heap y el DisjoinSet con su tama�o correspondiente.
		//Ademas creo la lista donde voy a guardar el Arbol minimal de cubrimiento.
		
        //Heap heap = new MinHeap(G.getArcosCount());
		
		PriorityQueue<Arco> heap=new PriorityQueue<Arco> (G.getArcosCount(), new ArcoComparator());
        DisjoinSet ds = new DisjoinSetImp(G.getVerticesCount());
        ArrayList<Arco> amc = new ArrayList<Arco>();

        for(int i = 0; i < G.getVerticesCount(); i++) {
        	ds.makeSet(i);
        }
        
        //Inicializo el Heap con todos los arcos.
        for (int i = 0; i < G.getArcosCount() ; i++) {
            //G: heap.insert(G.getArcos().get(i));
        	heap.add(G.getArcos().get(i));
        }
        
        //System.out.println("Despues del isertar todos los elementos");
        Timestamp timestampini = new Timestamp(System.currentTimeMillis());
        //System.out.println(timestampini);
        long ini = timestampini.getTime();
        //long t = fin - ini;
       // System.out.println(ini);
   
        //Recorro todos los vertices.
        int index = 0;
        //System.out.println( "Kruskal Heuristico ... inicia el desapilado del Haep ...");
        while(index < G.getVerticesCount()-1){
        	//Tomo el arco de menor peso
           //G: Arco edge = heap.popMin();
        	Arco edge = heap.poll();
            /*System.out.println( "arco "+index+": El Nodo "+edge.getV1().element()+
					" enlazado al "+ edge.getV2().element()+
					" con peso: "+edge.getPeso());*/
            
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
	
	public ArrayList<Arco> KruskalSinH(Grafo G){
		//Creo el heap y el DisjoinSet con su tama�o correspondiente.
		//Ademas creo la lista donde voy a guardar el Arbol minimal de cubrimiento.
		
		PriorityQueue<Arco> heap = new PriorityQueue<Arco> (G.getArcosCount(), new ArcoComparator());
        //Heap heap = new MinHeap(G.getArcosCount());
        DisjoinSet ds = new DisjoinSetImpSinH(G.getVerticesCount());
        ArrayList<Arco> amc = new ArrayList<Arco>();

        for(int i = 0; i < G.getVerticesCount(); i++) {
        	ds.makeSet(i);
        }
        
        //Inicializo el Heap con todos los arcos.
        for (int i = 0; i < G.getArcosCount() ; i++) {
            //heap.insert(G.getArcos().get(i));
        	heap.add(G.getArcos().get(i));
        }
   
        //Recorro todos los vertices.
        int index = 0;
        //System.out.println( "Kruskal Lento ... inicia el desapilado del Haep ...");
        while(index < G.getVerticesCount()-1){
        	//Tomo el arco de menor peso
            //Arco edge = heap.popMin();
        	Arco edge = heap.poll();
        	
            /*System.out.println( "arco "+index+": El Nodo "+edge.getV1().element()+
					" enlazado al "+ edge.getV2().element()+
					" con peso: "+edge.getPeso());*/
            
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
        //System.out.println( );
        //System.out.println("llego al fin de Kruskal");
        return amc;
    }
	
	
//	public ArrayList<Arco> KruskaL(Grafo G){
//		//Creo el heap y el DisjoinSet con su tama�o correspondiente.
//		//Ademas creo la lista donde voy a guardar el Arbol minimal de cubrimiento.
//		
//        ArrayList<Arco> list = new ArrayList<Arco>(G.getVerticesCount()); 
//        //QuickSort algorithm = new QuickSort();
//        DisjoinSet ds = new DisjoinSetImpSinH(G.getVerticesCount());
//        ArrayList<Arco> amc = new ArrayList<>();
//        int [] arr = new int[G.getArcosCount()];
//
//        for(int i = 0; i < G.getVerticesCount(); i++) {
//        	ds.makeSet(i);
//        }
//        
//        //Inicializo el Heap con todos los arcos.
//        for (int i = 0; i < G.getArcosCount() ; i++) {
//        	list.add(G.getArcos().get(i));
//            //heap.insert(G.getArcos().get(i));
//        }
//        //Collections.sort(list); 
//   
//        //Recorro todos los vertices.
//        int index = 0;
//        System.out.println( "Kruskal Lento ... inicia el desapilado del Haep ...");
//        while(index < G.getVerticesCount()-1){
//        	//Tomo el arco de menor peso
//           // Arco edge = heap.popMin();
//            
//            /*System.out.println( "arco "+index+": El Nodo "+edge.getV1().element()+
//					" enlazado al "+ edge.getV2().element()+
//					" con peso: "+edge.getPeso());*/
//            
//            //check if adding this edge creates a cycle
//            //Checkeo a que set pertenece cada vertice del arco.
//            int v1_set = ds.findSet(edge.getV1().element());
//            int v2_set = ds.findSet(edge.getV2().element());
//
//            //Si son diferentes los uno
//            //Sino no los uno para evitar ciclos.
//            if(v1_set!=v2_set){
//            	amc.add(edge);
//                index++;
//                ds.union(v1_set,v2_set);
//            }
//        }
//        System.out.println( );
//        System.out.println("llego al fin de Kruskal");
//        return amc;
//    }
	
	class QuickSort {

	    private int input[];
	    private int length;

	    public void sort(int[] numbers) {

	        if (numbers == null || numbers.length == 0) {
	            return;
	        }
	        this.input = numbers;
	        length = numbers.length;
	        quickSort(0, length - 1);
	    }
	
	
	    private void quickSort(int low, int high) {
	    	int i = low;
	    	int j = high;

	    	// pivot is middle index
	    	int pivot = input[low + (high - low) / 2];

	    	// Divide into two arrays
	    	while (i <= j) {
	    		/**
	    		 * As shown in above image, In each iteration, we will identify a
	    		 * number from left side which is greater then the pivot value, and
	    		 * a number from right side which is less then the pivot value. Once
	    		 * search is complete, we can swap both numbers.
	    		 */
	    		while (input[i] < pivot) {
	    			i++;
	    		}
	    		while (input[j] > pivot) {
	    			j--;
	    		}
	    		if (i <= j) {
	    			//swap(i, j);
	    			int aux = i;
	    			i = j;
	    			j = aux;
	    			// move index to next position on both sides
	    			i++;
	    			j--;
	    		}
	    	}

	    	// calls quickSort() method recursively
	    	if (low < j) {
	    		quickSort(low, j);
	    	}

	    	if (i < high) {
	    		quickSort(i, high);
	    	}
	    }

	}

	//conMergesort

			public ArrayList<Arco> KruskalMergeConH(Grafo G){
				//Creo  DisjoinSet con su tama�o correspondiente.
				//Creo la lista donde voy a guardar el Arbol minimal de cubrimiento.
				//Lista de arcos auxiliar
				ArrayList<Arco> Larcos=new ArrayList<Arco>(G.getArcosCount());
				
				//ArrayList<Arco> Larcos=G.getArcos();
		        DisjoinSet ds = new DisjoinSetImp(G.getVerticesCount());
		        ArrayList<Arco> amc = new ArrayList<>();

		        for(int i = 0; i < G.getVerticesCount(); i++) {
		        	ds.makeSet(i);
		        }
		        System.out.println( "cant");
		        //Inicializo la nueva lista a ordenar.
		        for (int i = 0; i < G.getArcosCount() ; i++) {
		        	Arco a=G.getArcos().get(i);
		            Larcos.add(i,a);
		        }
		        //Ordeno La lista de arcos Larcos
		        MergeSort ob = new MergeSort();
		        ob.sort(Larcos, 0, Larcos.size()- 1); 
		        
		        int index = 0;
		        int i = 0;
		        System.out.println( "inicia el desapilado del Haep ...");
		        
		        while(index < G.getVerticesCount()-1){
		        	//Tomo el arco de menor peso
		        	
		            Arco edge = Larcos.get(i);
		            i++;
		            
		           
		            
		            System.out.println( "arco "+index+": El Nodo "+edge.getV1().element()+
							" enlazado al "+ edge.getV2().element()+
							" con peso: "+edge.getPeso());
		            
		           
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
		        
		        
		        System.out.println( );
		        System.out.println("llego al fin de Kruskal");
		        return amc;
			}
			
			public ArrayList<Arco> KruskalMergeSinH(Grafo G){
				//Creo  DisjoinSet con su tama�o correspondiente.
				//Creo la lista donde voy a guardar el Arbol minimal de cubrimiento.
				//Lista de arcos auxiliar
				ArrayList<Arco> Larcos=new ArrayList<Arco>(G.getArcosCount());
		        DisjoinSet ds = new DisjoinSetImpSinH(G.getVerticesCount());
		        ArrayList<Arco> amc = new ArrayList<>();

		        for(int i = 0; i < G.getVerticesCount(); i++) {
		        	ds.makeSet(i);
		        }
		        System.out.println( "cant");
		        //Inicializo la Lista con todos los arcos.
		        for (int i = 0; i < G.getArcosCount() ; i++) {
		        	Arco a=G.getArcos().get(i);
		            Larcos.add(i,a);
		        }
		        
		        MergeSort ob = new MergeSort();
		        ob.sort(Larcos, 0, Larcos.size()- 1);  
		        
		        int index = 0;
		        int i=0;
		        System.out.println( "inicia el desapilado del Haep ...");
		        
		        while(index < G.getVerticesCount()-1){
		        	//Tomo el arco de menor peso
		        	
		            Arco edge = Larcos.get(i);
		            i++;
		            System.out.println( "arco "+index+": El Nodo "+edge.getV1().element()+
							" enlazado al "+ edge.getV2().element()+
							" con peso: "+edge.getPeso());
		            
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
		        
		        System.out.println( );
		        System.out.println("llego al fin de Kruskal");
		        return amc;
			}
}
