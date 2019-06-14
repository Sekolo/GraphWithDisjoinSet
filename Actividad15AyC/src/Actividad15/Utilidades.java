
package Actividad15;

import Cola.Cola;

public class Utilidades {
	
	
	public boolean BFS (Grafo G)
	{
		boolean[] visitados;
		int CantVertices=G.getNodosCount();
		visitados=new boolean[CantVertices];
		int conexo=0;
		boolean Esconexo=true;
		int i=0;
		for (i=0; i<CantVertices; i++)
			visitados[i] = false;
			

		while (i<CantVertices && Esconexo)
		{		
			if (!visitados[i])
			{ 
				conexo++;
				if(conexo==1) {}
					//RecorridoNivel(G,i,visitados);
				else
					Esconexo=false;
				
			}
			i++;
		}
		return Esconexo;
		
	}
	
	/*
	public void RecorridoNivel (Grafo G, int v, boolean[] visitados)
	{
		Cola Q;
		visitados[v]=true;
		Q.enqueue(v);
			while (!Q.isEmpty()) 
			{
					x = Q.dequeue();
					//recorro las vertices z ady de y
					foreach (v[y] adyacente a v[x]) 
					{
						v++;
						if (!visitados[v]) 
							visitados[v]=true; 
						Q.enqueue(z);
					}
			}
	}*/
	//O(|V|+|E|)

}



