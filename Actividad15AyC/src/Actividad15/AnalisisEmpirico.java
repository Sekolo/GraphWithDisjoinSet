package Actividad15;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import DisjoinSet.DisjoinSet;
import DisjoinSet.DisjoinSetImp;
import Grafo.Grafo;
import Grafo.GrafoImp;
import Grafo.GrafoJson;

public class AnalisisEmpirico{
		
		public static void main(String[] args) throws IOException {
			
			try{
				Grafo grafo = getGrafo(5,4);
				
				System.out.println("Grafo conexo con "+ grafo.getVerticesCount() + " nodos y "+ grafo.getArcosCount() + " arcos construido");
				
				
				
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
			String consulta = "curl http://cs.uns.edu.ar/~mom/AyC2019/grafo.php?nodos="+nodos+"&arcos="+arcos+"&conexo=0";   //&conexo=0
			Process process = Runtime.getRuntime().exec(consulta);
			InputStream inputSt = process.getInputStream();
			@SuppressWarnings("resource")
			Scanner s = new Scanner(inputSt).useDelimiter("\\A");
			String jsonString = s.hasNext() ? s.next() : "";
			System.out.println("Tengo el grafo en formato JSON. Lo convierto...");
			Gson gson = new GsonBuilder().create();
			try{
				GrafoJson gr = gson.fromJson(jsonString, GrafoJson.class);
				return new GrafoImp(gr);
			} catch (Exception e) {
				System.out.print("Cortó");
				throw new Exception(jsonString);
			}
		}
		
		
		private static void ver(Grafo g) {
			
			for (int i = 0; i < g.getArcos().size(); i++ ) {
				System.out.println("nodo "+g.getArcos().get(i).getV1().element()+" arco con "+ g.getArcos().get(i).getV2().element());
				
			}
		}
		
		private static void conexo(Grafo g) {
			DisjoinSet conj=  new DisjoinSetImp(g.getVerticesCount());
			
			for (int i = 0; i < g.getArcos().size(); i++ ) {
				conj.union(g.getArcos().get(i).getV1().element(), g.getArcos().get(i).getV2().element());
				
			}
			
			if (conj.conexo())
				System.out.println("El grafo es conexo");
			else
				System.out.println("El grafo es NO conexo");
			
		}
		
	}
