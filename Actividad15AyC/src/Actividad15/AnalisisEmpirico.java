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
			
			Grafo grafo = builder.getGrafo(500,124000,true);	
			
			LocalTime t = LocalTime.now(); 
			
	        Conexo con = new Conexo();
			kruk = con.Kruskal(grafo);
			
			double execution = Duration.between(t, LocalTime.now()).getNano();
			System.out.println("Termino Kruskal...........Tiempo : "+ (execution/1000000));
			
			System.out.println("Grafo conexo con "+ grafo.getVerticesCount() + " nodos y "+ grafo.getArcosCount() + " arcos construido");
			
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
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
		System.out.println("-------------------------------------------");
		System.out.println("kruskal:");
		
		System.out.println("llego hasta el fin del ciclo");
	}
		
	private static void conexo(Grafo g) {
		DisjoinSet conj=  new DisjoinSetImp(g.getVerticesCount());
		
		if (conj.conexo())
			System.out.println("El grafo es conexo");
		else
			System.out.println("El grafo es NO conexo");
		
	}
		
}
