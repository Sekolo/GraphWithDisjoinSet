import java.io.IOException;
import java.io.InputStream;
import java.util.PriorityQueue;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



	public class AnalisisEmpirico{
		
		public static void main(String[] args) throws IOException {
			
			try{
				Grafo grafo = getGrafo(500,65000);
				
				System.out.println("Grafo conexo con "+ grafo.getNodosCount() + " nodos y "+ grafo.getArcosCount() + " arcos construido");
				
				
				
				ver(grafo);
				
				conexo(grafo);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			
			/*
			 * Generar varios grafos de diferente configuración y buscar 
			 * árbol de cubrimiento minimal para cada uno. 
			 * 
			 * Medir el rendimiento usando timestamps.
			 * 
			 */
			
			
		}

		private static Grafo getGrafo(int nodos, int arcos) throws Exception {
			// TODO Auto-generated method stub
			String consulta = "curl http://cs.uns.edu.ar/~mom/AyC2019/grafo.php?nodos="+nodos+"&arcos="+arcos+"&conexo=1";//+"&conexo=0"
			Process process = Runtime.getRuntime().exec(consulta);
			InputStream inputSt = process.getInputStream();
			@SuppressWarnings("resource")
			Scanner s = new Scanner(inputSt).useDelimiter("\\A");
			String jsonString = s.hasNext() ? s.next() : "";
			System.out.println("Tengo el grafo en formato JSON. Lo convierto...");
			Gson gson = new GsonBuilder().create();
			try{
				Grafo.GrafoObj gr = gson.fromJson(jsonString, Grafo.GrafoObj.class);
				return new Grafo(gr);
			} catch (Exception e) {
				throw new Exception(jsonString);
			}
		}
		
		
		private static void ver(Grafo g) {
			
			for (int i = 0; i < g.getArcos().size(); i++ ) {
				System.out.println("nodo "+g.getArcos().get(i).get().getN1()+" arco con "+ g.getArcos().get(i).get().getN2());
				
			}
		}
		
		private static void conexo(Grafo g) {
			DisjoinSet conj=  new DisjoinSet(g.getNodosCount());
			
			for (int i = 0; i < g.getArcos().size(); i++ ) {
				conj.union(g.getArcos().get(i).get().getN1(), g.getArcos().get(i).get().getN2());
				
			}
			
			if (conj.conexo())
				System.out.println("El grafo es conexo");
			else
				System.out.println("El grafo es NO conexo");
			
		}
		
		
		private static boolean spereTree(Grafo g) {
			DisjoinSet conj=  new DisjoinSet(g.getNodosCount());
			
			
			PriorityQueue<Pesado> minHeap = new PriorityQueue<Pesado>();
			
			for (int i = 0; i < g.getArcos().size(); i++ ) {
				minHeap.add(g.getArcos().get(i));
			}
			
			for (int i = 0; i < g.getArcos().size(); i++ ) {
			}
			
			return true;
		
		
		}
		
	}
