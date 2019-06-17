
package Actividad15;

import java.util.ArrayList;

import Cola.Cola;
import Grafo.Edge;
import Grafo.Vertex;

public class Utilidades {
	
	private boolean[] visitados;
	private ArrayList<Vertex> MisVertices;
	private int CantVertices;
	private ArrayList<Edge> MisArcos;
	private int CantArcos;
	
	public  Utilidades(ArrayList<Vertex> vertices, ArrayList<Edge> arcos)
	{
		
		visitados=new boolean[vertices.size()];
		MisVertices=vertices;
		CantVertices=vertices.size();
		MisArcos=arcos;
		CantArcos=arcos.size();
	}
	
	public boolean BFS (Grafo G)
	{
		int conexo=0;
		boolean Esconexo=true;
		int i=0;
		for (int j=0; j<CantVertices; j++)
			visitados[j] = false;
			

		while (i<CantVertices && Esconexo)
		{		
			if (!visitados[i])
			{ 
				//visitados[i]=true;
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
		Cola<Vertex> Q = new Cola<Vertex>(G.getNodosCount());
		visitados[i]=true;
		Q.enqueue(MisVertices.get(i));
			while (!Q.isEmpty()) 
			{
				try
				{
					Vertex x1 = Q.dequeue();
					for(Edge a: x1.getAdyacentes())
					{
						i++;
						if (!visitados[i]) 
						visitados[i]=true; 
						Q.enqueue(a.getN2());
					}
				} 
				catch (Exception e) 
				{
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
			}
	}
	//O(|V|+|E|)
	
	/*
	public void kruskalMST(){
        PriorityQueue<Edge> pq = new PriorityQueue<>(allEdges.size(), Comparator.comparingInt(o -> o.weight));

        //add all the edges to priority queue, //sort the edges on weights
        for (int i = 0; i <allEdges.size() ; i++) {
            pq.add(allEdges.get(i));
        }

        //create a parent []
        int [] parent = new int[vertices];

        //makeset
        makeSet(parent);

        ArrayList<Edge> mst = new ArrayList<>();

        //process vertices - 1 edges
        int index = 0;
        while(index<vertices-1){
            Edge edge = pq.remove();
            //check if adding this edge creates a cycle
            int x_set = find(parent, edge.source);
            int y_set = find(parent, edge.destination);

            if(x_set==y_set){
                //ignore, will create cycle
            }else {
                //add it to our final result
                mst.add(edge);
                index++;
                union(parent,x_set,y_set);
            }
        }
        //print MST
        System.out.println("Minimum Spanning Tree: ");
        printGraph(mst);
    }*/
}



