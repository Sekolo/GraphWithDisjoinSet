package Actividad15;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Cola.Cola;
import Cola.ColaImp;
import DisjoinSet.DisjoinSet;
import DisjoinSet.DisjoinSetImp;
import Grafo.Arco;
import Grafo.Grafo;
import Grafo.GrafoImp;
import Grafo.GrafoJson;
import java.util.Date;
import java.sql.Timestamp;
import Grafo.Vertice;


public class AnalisisEmpirico{
	
	//private static Utilidades uti = new Utilidades() ;
	private static JsonToGrafo builder = new JsonToGrafo();
	
	private Grafo grafo;
	//private static ArrayList<Arco> kruk;
	
		
		
		public static void main(String[] args) throws IOException {
			
			Utilidades uti = new Utilidades() ;
			ArrayList<Arco> kruk;
			try{
				Date date= new Date();
				
				Grafo grafo = builder.getGrafo(100,200,true);	
				
				Timestamp timestampini = new Timestamp(System.currentTimeMillis());
		        //System.out.println(timestampini);
		        long ini = timestampini.getTime();
		        //System.out.println(ini);
		        
		        
		        Conexo con = new Conexo();
				kruk = con.KruskalMerge(grafo);
				
				//System.out.println("Termino Kruskal...........");
				
				Timestamp timestampfin = new Timestamp(System.currentTimeMillis());
				//System.out.println(timestampfin);
				//long fin1 = timestampini.getTime();
				long fin = timestampfin.getTime();
				//long t1 = fin1 - ini;
				long t = fin - ini;
				//System.out.println("Transcurrio : "+ t1);
		        System.out.println("Transcurrio : "+ t +" milisegundos");
				
				/*
				long time = date.getTime();
			    System.out.println("Time in Milliseconds: " + time);
			    System.out.println();
			    Timestamp ts = new Timestamp(time);
			    System.out.println("Current Time Stamp: " + ts);
			    */
				
				System.out.println("Grafo conexo con "+ grafo.getVerticesCount() + " nodos y "+ grafo.getArcosCount() + " arcos construido");
				
				/*ArrayList<Arco> arcos = grafo.getArcos();
				
				System.out.println( "Lista de arcos ...");
				for(int i = 0; i < arcos.size(); i++) {
					System.out.println( "arco "+i+": El Nodo "+arcos.get(i).getV1().element()+
											" enlazado al "+ arcos.get(i).getV2().element()+
											" con peso: "+arcos.get(i).getPeso());
				}
				
				//conexo(grafo);
				
				System.out.println();
				System.out.println("Conexo con BFS...");
				
				if (uti.BFS(grafo)) 
					System.out.println("es conexo con BFS");
				else
					System.out.println("NO es conexo con BFS");
				
				
				
				
				
				
				
				System.out.println();
				System.out.println("Conexo con DisjoinSet...");
				if (con.cone(grafo))
					System.out.println( "El grafo es Conexo");
				else
					System.out.println( "No es conexo PAPA!!!! ");*/
				
				
				
				/*time = date.getTime();
			    System.out.println("Time in Milliseconds: " + time);
			    System.out.println();
			    ts = new Timestamp(time);
			    System.out.println("Current Time Stamp: " + ts);*/
			      
				System.out.println();
				System.out.println("Tamaño de arbol min:"+kruk.size());
			
				System.out.println();
				System.out.println("Arcos del cobrimiento minimo...");
				for(int i = 0; i < kruk.size(); i++) {
					System.out.println( "arco "+i+": El Nodo "+kruk.get(i).getV1().element()+
							" enlazado al nodo "+ kruk.get(i).getV2().element()+
							" con peso "+kruk.get(i).getPeso());
				}
				
				
				
				
				
				
				
				/*
				Conexo con = new Conexo();
				
				if (con.cone(grafo))
					System.out.println( "El grafo es Conexo");
				else
					System.out.println( "nooooooo es conexoooo!!!! ");
				
				ArrayList<Vertice> v = grafo.getVertices();
				
				Cola c = new ColaImp(v.size());		
				boolean [] vist = new boolean[v.size()]; 
				
				System.out.print( "Estos son los Vertices: ");
				for(int i = 0; i < v.size(); i++) {
					System.out.print( v.get(i).element() + " ");
					vist[i]= false;
				}
				
				System.out.println();
				
				LinkedList<Vertice> queue = new LinkedList<Vertice>(); 
				Vertice s =  v.get(0);
				  
		        // Mark the current node as visited and enqueue it 
		        vist[s.element()]=true; 
		        queue.add(s); 
		  
		        while (queue.size() != 0) { 
		            // Dequeue a vertex from queue and print it 
		            s = queue.poll(); 
		            
		            // Get all adjacent vertices of the dequeued vertex s 
		            // If a adjacent has not been visited, then mark it 
		            // visited and enqueue it 
		            // Iterator<Vertice> i = v[s].listIterator(); 
		            
		            for(int i = 0; i < v.size(); i++) {
		            
		                Vertice n = v.get(i); 
		                if (!vist[n.element()])  {
		                	
		                	for (int j = 0; j < n.getAdyacentes().size(); j++) {
		                		System.out.println( "El nodo "+ i +" tiene los arcos "+grafo.opposite(n, n.getAdyacentes().get(j)).element());
		                	}
		                    vist[n.element()] = true; 
		                    queue.add(n); 
		                } 
		            } 
		        }
		    
				*/
				
				
				//for(int i = 0; i < v.size(); i++) {
//					if (!vist[0] )
//						//System.out.print( "El nodo "+ i +" ");
//						c.enqueue(v.get(0));
//						
//						while (!c.isEmpty()) {
//								
//							Vertice v1 = c.dequeue();
//							vist[i] = true;
//							
//							for (int j = 0; j < v1.getAdyacentes().size(); j++) {
//								if (!vist[grafo.opposite(v1, v1.getAdyacentes().get(j)).element()]) {
//									c.enqueue(grafo.opposite(v1, v1.getAdyacentes().get(j)));
//									//System.out.print( "El nodo "+ i +" tiene los arcos "+ v.get(i).getAdyacentes().get(j).getV2().element()+" a "+v.get(i).getAdyacentes().get(j).getV1().element());
//									System.out.print( "El nodo "+ i +" tiene los arcos "+grafo.opposite(v.get(i), v.get(i).getAdyacentes().get(j)).element());
//									System.out.println();
//								}
//							}
//						}
//				//}
				
				//uti.RecorridoBFS(grafo);
				
				/*if (uti.BFS(grafo)) 
					System.out.println("es conexo con BFS");
				else
					System.out.println("NO es conexo con BFS");*/
				

		        
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			
			
			/*System.out.print("Camimo minimo de Kruskal: ");
			for(int i = 0; i< kruk.size(); i ++) {
				System.out.print(kruk.get(i)+"-- ");
			}*/
			
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
			String consulta = "curl http://cs.uns.edu.ar/~mom/AyC2019/grafo.php?nodos="+nodos+"&arcos="+arcos+"&conexo=1";   //&conexo=0
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
			
			//for (int i = 0; i < g.getArcos().size(); i++ ) {
				//System.out.println("nodo "+g.getArcos().get(i).getV1().element()+" arco con "+ g.getArcos().get(i).getV2().element()+" Valor: "+ g.getArcos().get(i).getPeso());
			//}
			
			
			
			
			System.out.println("-------------------------------------------");
			System.out.println("kruskal:");
			/*ArrayList<Arco> arr = uti.Kruskal(g);
			for (int i = 0; i < arr.size(); i++ ) {
				System.out.println("nodo "+ arr.get(i).getV1().element()+" arco con "+ arr.get(i).getV2().element()+" Valor: "+ arr.get(i).getPeso());			
			}*/
			
			System.out.println("llego hasta el fin del ciclo");
			
			
			

			
			
		}
		
		private static void conexo(Grafo g) {
			DisjoinSet conj=  new DisjoinSetImp(g.getVerticesCount());
			
			//for (int i = 0; i < g.getArcos().size(); i++ ) {
			//	conj.union(g.getArcos().get(i).getV1().element(), g.getArcos().get(i).getV2().element());
				
			//}
			
			if (conj.conexo())
				System.out.println("El grafo es conexo");
			else
				System.out.println("El grafo es NO conexo");
			
		}
		
	}
