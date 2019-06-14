package Grafo;

import java.util.ArrayList;

import Actividad15.Pesado;
import GrafoTurbio.ArcoL;
import GrafoTurbio.GraphException;
import GrafoTurbio.VerticeL;

public class Grafo implements Graph {
	
	private int[] nodos;
	private ArrayList<Arco> arcos;


	
	public Vertice opposite(Vertice v, Arco e) throws Exception  {
		//VerticeL<V,E> vl= checkVertex(v);
		//ArcoL<V,E> al= checkEdge(e);
		if(e.getN1() == v)
			return e.getN2();
		else
			if(e.getN2()==v)
				return e.getN1();
			else
				throw new Exception("Error, vertice o arco pasado por parametro no se relacionan.");
	}



	@Override
	public Vertice[] endVertices(Arco e) throws Exception {
		Vertice[] vert = new Vertice[1];
		vert[0]= e.getN1();
		vert[1]= e.getN2();
		return vert;
		
	}



	@Override
	public boolean areAdjacent(Vertice v, Vertice w) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public Object replace(Vertice v, int x) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Object replace(Arco e, int x) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Vertice insertVertex(int x) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Arco insertEdge(Vertice v, Vertice w, int x) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Object removeVertex(Vertice v) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Object removeEdge(Arco e) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}