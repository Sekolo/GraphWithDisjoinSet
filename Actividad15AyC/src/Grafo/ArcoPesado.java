package Grafo;

public class ArcoPesado implements Arco  {

		private Vertice vertice1;
		private Vertice vertice2;
		private int peso;
		
		public ArcoPesado(Vertice i, Vertice j, int p) {	
			this.vertice1 = i;
			this.vertice2 = j;
			peso = p;
		}
		
		public Vertice getV1() {
			return vertice1;
		}
		
		public Vertice getV2() {
			return vertice2;
		}
		
		public int getPeso() {
			return peso;
		}
		
}
