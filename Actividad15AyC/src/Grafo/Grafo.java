package Grafo;

import java.util.ArrayList;

import GrafoTurbio.ArcoL;
import GrafoTurbio.EmptyListException;
import GrafoTurbio.VerticeL;


public class Grafo implements Graph {
	
	
	private ArrayList<Vertex> nodos;
	private ArrayList<Edge> Edges;
	
	
	public Grafo() {
		
	}

	
	public Vertice opposite(Vertex v, Edge e) throws Exception  {
		if(e.getN1() == v)
			return e.getN2();
		else
			if(e.getN2()==v)
				return e.getN1();
			else
				throw new Exception("Error, vertice o Edge pasado por parametro no se relacionan.");
	}



	@Override
	public Vertice[] endVertices(Edge e) throws Exception {
		Vertice[] vert = new Vertice[1];
		vert[0]= e.getN1();
		vert[1]= e.getN2();
		return vert;
		
	}


	public boolean areAdjacent(Vertex v, Vertex w) throws Exception {
		for(Edge a: v.getAdyacentes())
			if(a.getN1()==w || a.getN2()==v)
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



	
	public Edge insertEdge(Vertice v, Vertice w, int x) throws Exception {
		
		return null;
	}



	@Override
	public Vertice removeVertex(Vertice v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public int removeEdge(Edge e) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public Vertice opposite(Vertice v, Edge e) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean areAdjacent(Vertice v, Vertice w) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}



}