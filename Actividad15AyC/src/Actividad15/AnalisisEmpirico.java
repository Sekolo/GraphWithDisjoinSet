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
import java.time.Duration;
import java.time.LocalTime;

import Grafo.Vertice;


public class AnalisisEmpirico{
	private static JsonToGrafo builder = new JsonToGrafo();
	private Grafo grafo;
	private static Utilidades util = new Utilidades(); 
	
	public static void main(String[] args) throws IOException {
		Utilidades uti = new Utilidades() ;
		ArrayList<Arco> kruk;
		try{
			Date date= new Date();

			Grafo grafo = builder.getGrafo(500,124000,true);	
			
			System.out.println("Grafo conexo con "+ grafo.getVerticesCount() + " nodos y "+ grafo.getArcosCount() + " arcos construido");
			
			//ver(grafo);
			
			LocalTime t1 = LocalTime.now(); 
			
			kruk = util.KruskalHeapCH(grafo);
			
			double execution1 = Duration.between(t1, LocalTime.now()).getNano();
			System.out.println("Tiempo KruskalHeapCH: "+ (execution1/1000000));
			
//			
//			LocalTime t2 = LocalTime.now(); 
//			
//			kruk = util.KruskalHeapSH(grafo);
//			
//			double execution2 = Duration.between(t2, LocalTime.now()).getNano();
//			System.out.println("Tiempo KruskalHeapSH: "+ (execution2/1000000));
//
//			LocalTime t3 = LocalTime.now(); 
//			
//			kruk = util.KruskalListaCH(grafo);
//			
//			double execution3 = Duration.between(t3, LocalTime.now()).getNano();
//			System.out.println("Tiempo KruskalListaCH: "+ (execution3/1000000));
//			
//			LocalTime t4 = LocalTime.now(); 
//			
//			kruk = util.KruskalListaSH(grafo);
//			
//			double execution4 = Duration.between(t4, LocalTime.now()).getNano();
//			System.out.println("Tiempo KruskalListaSH: "+ (execution4/1000000));
			
			
			LocalTime t5 = LocalTime.now(); 
			
			boolean rta = util.esConexo(grafo);
			double execution5 = Duration.between(t5, LocalTime.now()).getNano();
			System.out.println("Tiempo ConexoDisjoin: "+ (execution5/1000000));
			
//			LocalTime t6 = LocalTime.now(); 
//			
//			rta = util.esConexo(grafo);
//			double execution6 = Duration.between(t6, LocalTime.now()).getNano();
//			System.out.println("Tiempo ConexoDisjoin: "+ (execution6/1000000));
		
			if(rta)
				System.out.println("Grafo es conexo");
			else
				System.out.println("Grafo NO  es conexo..........");
			
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void ver(Grafo g) {
		ArrayList<Arco> arcos = g.getArcos();
		
		for(int i = 0; i < arcos.size(); i++) {
			System.out.println(i+": arco "+arcos.get(i).getV1().element() +" enlazado al nodo "+
									arcos.get(i).getV2().element()+
									" con valor: "+arcos.get(i).getPeso());
		}
	}


		
		
		
		
}
