package Grafo;

import java.util.ArrayList;
import java.util.LinkedList;

public class GrafoImp implements Grafo {
	private ArrayList<Vertice> vertices;
	private ArrayList<Arco> arcos;
	
	
	public GrafoImp(ArrayList<Vertice> vert, ArrayList<Arco> arc){
		vertices = vert;
		arcos = arc;
	}
	
	public GrafoImp(ArrayList<Vertice> vert, int c){
		vertices = vert;
		arcos = new ArrayList<Arco>(c); 
	}
	
	
	public ArrayList<Vertice> getVertices() {
		return vertices;
	}
	
	public int getVerticesCount(){
		return vertices.size();
	}
	
	
	public ArrayList<Arco> getArcos() {
		return arcos;
	}
	
	public ArrayList<Arco> getArcosAdj() {
		boolean[] visitados;
		LinkedList<Vertice> queue = new LinkedList<Vertice>(); 
	
		visitados = new boolean[this.getVertices().size()];
	
		ArrayList<Vertice> verts = this.getVertices();
	
		for(int i = 0; i < verts.size() ; i++) {
			//ds.makeSet(i);
			visitados[i] = false;
			//System.out.println("viste el grafo");
		
		}
	
		try {
			Vertice s =  verts.get(0);
			visitados[s.element()] = true; 
			queue.add(s); 
		
			while (queue.size() != 0) {	
			
			s = queue.poll(); 
			
				for(int i = 0; i < verts.size(); i++) {
				
					Vertice n = verts.get(i);
					if (!visitados[n.element()])  {
            	
						for (int j = 0; j < n.getAdyacentes().size(); j++) {
							System.out.println("entre a los arcos");
							arcos.add(n.getAdyacentes().get(j));
							//heap.insert(n.getAdyacentes().get(j));
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
		
	return arcos;
	
	}
	
	
	
	public Vertice opposite(Vertice v, Arco e) throws Exception  {
		if(e.getV1() == v)
			return e.getV2();
		else
			if(e.getV2()==v)
				return e.getV1();
			else
				throw new Exception("Error, vertice o Arco pasado por parametro no se relacionan.");
	}


	public Vertice[] endVertices(Arco e) throws Exception {
		Vertice[] vert = new Vertice[1];
		vert[0]= e.getV1();
		vert[1]= e.getV2();
		return vert;
		
	}


	public boolean areAdjacent(Vertice v, Vertice w) throws Exception {
		for(Arco a: v.getAdyacentes())
			if(a.getV1()== w || a.getV2()== v)
				return true;
		//si recorre todos los arcos de v y no encuentra, v y w no son ady.
		return false;

	}
	

	public int replace(Vertice v, int x) throws Exception {
		return 0;
	}

	public int replace(Arco e, int x) throws Exception {
		return 0;
	}

	public Vertice insertVertex(int x) {
		return null;
	}


	public Arco insertArco(Vertice v, Vertice w, int x) throws Exception {
		return null;
	}

	public Vertice removeVertex(Vertice v) throws Exception {
		return null;
	}

	public int removeArco(Arco e) throws Exception {
		return 0;
	}
	
	
	@SuppressWarnings("rawtypes")
	public GrafoImp(GrafoJson grafoJson){
		vertices = new ArrayList<Vertice>();
		for(int i=0; i < grafoJson.nodos.length; i++) {
			Vertice v = new VerticeImp(i);
			vertices.add(i,v);
		}
		arcos = new ArrayList<Arco>();
		
		Object[][] arcosJson = grafoJson.arcos;
		
		for (int i = 0; i<arcosJson.length; i++){
			Vertice v1 = new VerticeImp(((Double) ((ArrayList) arcosJson[i][0]).get(0)).intValue());
			Vertice v2 = new VerticeImp(((Double) ((ArrayList) arcosJson[i][0]).get(1)).intValue());
			Arco arco = new ArcoPesado(v1,v2, ((Double) arcosJson[i][1]).intValue());
			arcos.add(arco); 
		}
	}


	@Override
	public int getArcosCount() {
		return arcos.size();
	}
	
	
}
