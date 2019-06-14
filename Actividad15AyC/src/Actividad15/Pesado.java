package Actividad15;
import java.util.ArrayList;

import Grafo.Arco;
import Grafo.Vertice;


public class Pesado {
	
		private Arco arco;
		private int peso;
		
		public Pesado(ArrayList<Vertice> arcoLista, int peso) {
	
			this.arco = new Arco(arcoLista.get(0), arcoLista.get(1));
			this.peso = peso;
			
		}

		
		public Arco get() {
			return arco; 
		}
		
		public int getPeso() {
			return peso;
		}
		
	

}
