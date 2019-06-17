package Grafo;

public class ArcoPesado implements Edge  {

		private Vertex vertice1;
		private Vertex vertice2;
		private int peso;
		
		public ArcoPesado(Vertex i, Vertex j, int p) {	
			this.vertice1 = i;
			this.vertice2 = j;
			peso = p;
		}
		
		public Vertex getV1() {
			return vertice1;
		}
		
		public Vertex getV2() {
			return vertice2;
		}
		
		public int getPeso() {
			return peso;
		}
		
}
