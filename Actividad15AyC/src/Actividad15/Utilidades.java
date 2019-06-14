
package Actividad15;

import java.util.ArrayList;

import Cola.Cola;
import Grafo.Edge;
import Grafo.Vertice;

public class Utilidades {
	
	private boolean[] visitados;
	private ArrayList<Vertice> MisVertices;
	private int CantVertices;
	
	public  Utilidades(int cant,ArrayList<Vertice>ver)
	{
		
		visitados=new boolean[cant];
		MisVertices=ver;
		CantVertices=cant;
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
		Cola<Vertice> Q = new Cola<Vertice>(G.getNodosCount());
		visitados[i]=true;
		Q.enqueue(MisVertices.get(i));
			while (!Q.isEmpty()) 
			{
				try
				{
					Vertice x1 =  (Vertice) Q.dequeue();
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

}



