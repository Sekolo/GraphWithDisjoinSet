package Grafo;

public class Arco {

		private Vertice nodo1;
		private Vertice nodo2;
		
		public Arco(Vertice i, Vertice j) {	
			this.nodo1 = i;
			this.nodo2 = j;
		}
		
		public Vertice getN1() {
			return nodo1;
		}
		
		public Vertice getN2() {
			return nodo2;
		}

}
