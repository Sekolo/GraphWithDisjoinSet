package Actividad15;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Grafo.ArcoPesado;
import Grafo.Edge;
import Grafo.Vertice;

public class JsonToGrafo {
	
	public static void getGrafo(int nodos, int arcos, boolean conx ) throws Exception {
	
		String consulta;

		if (conx) 
			consulta = "curl http://cs.uns.edu.ar/~mom/AyC2019/grafo.php?nodos="+nodos+"&arcos="+arcos+"&conexo=1";  
		else
			consulta = "curl http://cs.uns.edu.ar/~mom/AyC2019/grafo.php?nodos="+nodos+"&arcos="+arcos;

		
		Process process = Runtime.getRuntime().exec(consulta);
		InputStream inputSt = process.getInputStream();
		@SuppressWarnings("resource")
		Scanner s = new Scanner(inputSt).useDelimiter("\\A");
		String jsonString = s.hasNext() ? s.next() : "";
		System.out.println("Tengo el grafo en formato JSON. Lo convierto...");
		Gson gson = new GsonBuilder().create();
		try{
			GrafoObj gr = gson.fromJson(jsonString, GrafoObj.class);
			createG(gr);
		} catch (Exception e) {
			throw new Exception(jsonString);
		}
	}
		
	public static void createG(GrafoObj grafoJson){
			
		int[] nodos;
		ArrayList<Edge> arcos;
			
		nodos = grafoJson.nodos;
		arcos = new ArrayList<Edge>();
			
		Object[][] arcosJson = grafoJson.arcos;
			
		for (int i = 0; i < arcosJson.length; i++){
				
			ArrayList<Vertice> arcoLista = new ArrayList<>(); 
				
			Vertice v1 = new Vertice(((Double) ((ArrayList) arcosJson[i][0]).get(0)).intValue());
			Vertice v2 = new Vertice(((Double) ((ArrayList) arcosJson[i][0]).get(1)).intValue());
			arcoLista.add(v1);
			arcoLista.add(v2);
			Edge arco = new ArcoPesado(v1,v2, ((Double) arcosJson[i][1]).intValue());
				
			arcos.add(arco); 
		}
	}
			
	class GrafoObj {
		int[] nodos;
		Object[][] arcos;
	}
	

}
