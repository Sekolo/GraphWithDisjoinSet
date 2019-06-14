package Actividad15;

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
				if(conexo==1)
					RecorridoNivel(G,i);
				else
					Esconexo=false;
				
			}
			i++;
		}
		return Esconexo;
		
	}

	public void RecorridoNivel (Grafo G, int v)
	{
		Cola Q;
		visitado[v]=true;
		Q.add(v);
			while (!Q.empty()) 
			{
					x = Q.extract();
					
					foreach (v[y] adyacente a v[x]) 
					{
						if (!visitado[y]) 
							visitado[y]=true; 
						Q.add(y);
					}
			}
	}
	//O(|V|+|E|)

}
