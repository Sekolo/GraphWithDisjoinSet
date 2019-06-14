package Actividad15;
import java.util.ArrayList;

import Grafo.ArcoP;
import Grafo.Edge;
import Grafo.Vertice;


public class Pesado {
	
		private ArcoP arco;
		private int peso;
		
		public Pesado(ArrayList<Vertice> arcoLista, int peso) {
	
			this.arco = new ArcoP(arcoLista.get(0), arcoLista.get(1), peso);
			this.peso = peso;
			
		}

		
		public Edge get() {
			return arco; 
		}
		
		public int getPeso() {
			return peso;
		}
		
	

}
