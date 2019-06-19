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
	
	public static void main(String[] args) throws IOException {
		Utilidades uti = new Utilidades() ;
		ArrayList<Arco> kruk;
		try{
			Date date= new Date();

			Grafo grafo = builder.getGrafo(5,5,false);	
			ver(grafo);
			
			LocalTime t = LocalTime.now(); 
			
	        Conexo con = new Conexo();
			kruk = con.Kruskal(grafo);
			
			double execution = Duration.between(t, LocalTime.now()).getNano();
			System.out.println("Termino Kruskal...........Tiempo : "+ (execution/1000000));
			
			System.out.println("Grafo conexo con "+ grafo.getVerticesCount() + " nodos y "+ grafo.getArcosCount() + " arcos construido");
			
			
			if(con.cone(grafo))
				System.out.println("Grafo es conexo con Recorrido");
			else
				System.out.println("Grafo NO  es conexo..........con Recorrido");
			
			if(con.esConexo(grafo))
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
