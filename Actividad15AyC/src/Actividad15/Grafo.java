package Actividad15;

import java.util.ArrayList;

import Grafo.ArcoP;
import Grafo.Edge;
import Grafo.Vertice;

public class Grafo {
	private int[] nodos;
	private ArrayList<Edge> arcos;

	/*class Pesado {
		private Arco arco;
		private int peso;
		
		private Pesado(ArrayList<Integer> arcoLista, int peso) {
			// TODO Auto-generated constructor stub
			this.arco = new Arco(arcoLista.get(0), arcoLista.get(1));
			this.peso = peso;
			
		}

		class Arco {
			private int nodo1;
			private int nodo2;
			
			public Arco(int i, int j) {
				// TODO Auto-generated constructor stub
				this.nodo1 = i;
				this.nodo2 = j;
			}
			
			public int getN1() {
				return nodo1;
			}
			public int getN2() {
				return nodo2;
			}
		}
		
		public Arco get() {
			return arco; 
		}
		
		public int getPeso() {
			return peso;
		}
		
	}*/
	
	public ArrayList<Edge> getArcos() {
		return arcos;
	}
	
	public int getNodosCount(){
		return this.nodos.length;
	}
	
	public int getArcosCount(){
		return this.arcos.size();
	}
	

	@SuppressWarnings("rawtypes")
	public Grafo(GrafoObj grafoJson){
		this.nodos = grafoJson.nodos;
		this.arcos = new ArrayList<Edge>();
		
		Object[][] arcosJson = grafoJson.arcos;
		
		for (int i = 0; i<arcosJson.length; i++){
			
			ArrayList<Vertice> arcoLista = new ArrayList<>(); 
			
			Vertice v1 = new Vertice(((Double) ((ArrayList) arcosJson[i][0]).get(0)).intValue());
			Vertice v2 = new Vertice(((Double) ((ArrayList) arcosJson[i][0]).get(1)).intValue());
			arcoLista.add(v1);
			arcoLista.add(v2);
			Edge arco = new ArcoP(v1,v2, ((Double) arcosJson[i][1]).intValue());
			//Pesado pesado = new Pesado(arcoLista, ((Double) arcosJson[i][1]).intValue());
			this.arcos.add(arco); 
		}
	}
	
	public static class GrafoObj {
		int[] nodos;
		Object[][] arcos;
	}

}
