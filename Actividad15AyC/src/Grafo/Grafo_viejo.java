package Grafo;

import java.util.ArrayList;

import GrafoTurbio.ArcoL;
import GrafoTurbio.EmptyListException;
import GrafoTurbio.VerticeL;


public class Grafo_viejo implements Graph_viejo {
	
	
	private ArrayList<Vertex> nodos;
	private ArrayList<Edge> Edges;
	
	
	public Grafo_viejo() {
		
	}

	
	public Vertex opposite(Vertex v, Edge e) throws Exception  {
		if(e.getV1() == v)
			return e.getV2();
		else
			if(e.getV2()==v)
				return e.getV1();
			else
				throw new Exception("Error, vertice o Edge pasado por parametro no se relacionan.");
	}



	@Override
	public Vertex[] endVertices(Edge e) throws Exception {
		Vertex[] vert = new Vertice[1];
		vert[0]= e.getV1();
		vert[1]= e.getV2();
		return vert;
		
	}


	public boolean areAdjacent(Vertex v, Vertex w) throws Exception {
		for(Edge a: v.getAdyacentes())
			if(a.getV1()==w || a.getV2()==v)
				return true;
		//si recorre todos los arcos de v y no encuentra, v y w no son ady.
		return false;

	}



	
	public int replace(Vertice v, int x) throws Exception {
		return 0;
	}



	
	public int replace(Edge e, int x) throws Exception {
		return 0;
	}



	
	public Vertice insertVertex(int x) {
		Vertice v= new Vertice(x);
		nodos.add(v);
		return v;
	}



}