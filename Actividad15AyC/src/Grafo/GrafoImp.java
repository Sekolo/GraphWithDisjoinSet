package Grafo;

import java.util.ArrayList;

public class GrafoImp implements Grafo {
	private ArrayList<Vertice> vertices;
	private ArrayList<Arco> arcos;
	
	public ArrayList<Arco> getArcos() {
		return arcos;
	}
	
	public ArrayList<Vertice> getVertices() {
		return vertices;
	}
	
	public int getVerticesCount(){
		return vertices.size();
	}
	
	public int getArcosCount(){
		return arcos.size();
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
}
