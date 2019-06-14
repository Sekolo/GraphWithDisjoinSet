package Grafo;

public class ArcoP implements Edge  {

		private Vertice nodo1;
		private Vertice nodo2;
		private int valor;
		
		public ArcoP(Vertice i, Vertice j, int v) {	
			this.nodo1 = i;
			this.nodo2 = j;
			valor = v;
		}
		
		public Vertice getN1() {
			return nodo1;
		}
		
		public Vertice getN2() {
			return nodo2;
		}
		
		public int getValue() {
			return valor;
		}
		
}
