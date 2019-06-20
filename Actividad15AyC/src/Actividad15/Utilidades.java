
package Actividad15;

import java.util.ArrayList;
import java.util.LinkedList;
import DisjoinSet.DisjoinSetImp;
import DisjoinSet.DisjoinSetImpSinH;
import DisjoinSet.DisjoinSet;
import Grafo.Arco;
import Grafo.Vertice;
import Grafo.Grafo;
import Heap.Heap;
import Heap.MinHeap;



public class Utilidades {
	
	private boolean[] visitados;
	private DisjoinSet disj;
	
	public void setVisitados(int n) {
		visitados = new boolean[n];
	}
	
	public boolean BFS (Grafo G)
	{
		// Genero mi arreglo de visitados
		setVisitados(G.getVerticesCount());
		// Seteo todos los visitados como false
		for (int j=0; j<G.getVerticesCount(); j++)
			visitados[j] = false;
		
		RecorridoNivel(G);
			
		
		return EsConexo(G);
	}
	public boolean EsConexo(Grafo G)
	{
		boolean Conexo=true;
		int i=0;
		while(i < G.getVerticesCount() && Conexo)
		{
			if(!visitados[i])
				Conexo=false;
			i++;
		}
		return Conexo;
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
						catch(Exception e) {
							e.printStackTrace();
						}
					}
					
				}
			
		
			
	}

	
	public boolean esConexo(Grafo g) {
		disj = new DisjoinSetImp(g.getVerticesCount());
		ArrayList<Vertice> verts = g.getVertices();
	
		for(int i = 0; i < verts.size(); i++) {
			disj.makeSet(i);
		}
	
		for(int i = 0; i < g.getArcosCount(); i++) {
			disj.union(g.getArcos().get(i).getV1().element(),g.getArcos().get(i).getV2().element());
		}
	
		int [] pa = disj.getP();
	
		int raiz = disj.findSet(pa[0]);
		boolean conex = true;
		for (int i = 1; i < pa.length; i++) {
			if (disj.findSet(pa[i]) != raiz)
				conex = false;
		}	
		return conex;

	}



	public ArrayList<Arco> KruskalHeapCH(Grafo G){
		//Creo el heap y el DisjoinSet con su tamaño correspondiente.
		//Ademas creo la lista donde voy a guardar el Arbol minimal de cubrimiento.
		
	    Heap heap = new MinHeap(G.getArcosCount());
	    DisjoinSet ds = new DisjoinSetImp(G.getVerticesCount());
	    ArrayList<Arco> amc = new ArrayList<Arco>();
	
	    for(int i = 0; i < G.getVerticesCount(); i++) {
	    	ds.makeSet(i);
	    }
	    
	    //Inicializo el Heap con todos los arcos.
	    for (int i = 0; i < G.getArcosCount() ; i++) {
	        heap.insert(G.getArcos().get(i));
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

	public ArrayList<Arco> KruskalHeapSH(Grafo G){
		//Creo el heap y el DisjoinSet con su tamaño correspondiente.
		//Ademas creo la lista donde voy a guardar el Arbol minimal de cubrimiento.
		Heap heap = new MinHeap(G.getArcosCount());
	    DisjoinSet ds = new DisjoinSetImpSinH(G.getVerticesCount());
	    ArrayList<Arco> amc = new ArrayList<Arco>();
	
	    for(int i = 0; i < G.getVerticesCount(); i++) {
	    	ds.makeSet(i);
	    }
	    
	    //Inicializo el Heap con todos los arcos.
	    for (int i = 0; i < G.getArcosCount() ; i++) {
	        heap.insert(G.getArcos().get(i));
	    	
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


	public ArrayList<Arco> KruskalListaCH(Grafo G){
		//Creo  DisjoinSet con su tamaño correspondiente.
		//Creo la lista donde voy a guardar el Arbol minimal de cubrimiento.
		//Lista de arcos auxiliar
		ArrayList<Arco> Larcos=new ArrayList<Arco>(G.getArcosCount());
		DisjoinSet ds = new DisjoinSetImp(G.getVerticesCount());
		ArrayList<Arco> amc = new ArrayList<>();
		for(int i = 0; i < G.getVerticesCount(); i++) {
		       ds.makeSet(i);
		 }
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
		 while(index < G.getVerticesCount()-1){
		    //Tomo el arco de menor peso
		     Arco edge = Larcos.get(i);
		     	i++;
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
		
	public ArrayList<Arco> KruskalListaSH(Grafo G){
		//Creo  DisjoinSet con su tamaño correspondiente.
		//Creo la lista donde voy a guardar el Arbol minimal de cubrimiento.
		//Lista de arcos auxiliar
		ArrayList<Arco> Larcos=new ArrayList<Arco>(G.getArcosCount());
		DisjoinSet ds = new DisjoinSetImpSinH(G.getVerticesCount());
		ArrayList<Arco> amc = new ArrayList<>();

		for(int i = 0; i < G.getVerticesCount(); i++) {
			ds.makeSet(i);
		}
		//Inicializo la Lista con todos los arcos.
		for (int i = 0; i < G.getArcosCount() ; i++) {
			Arco a=G.getArcos().get(i);
			Larcos.add(i,a);
		}
	        
		MergeSort ob = new MergeSort();
		ob.sort(Larcos, 0, Larcos.size()- 1);  
     
		int index = 0;
		int i=0;
		while(index < G.getVerticesCount()-1){
			//Tomo el arco de menor peso
			Arco edge = Larcos.get(i);
			i++;
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
