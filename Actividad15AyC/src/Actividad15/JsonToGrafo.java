package Actividad15;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Grafo.ArcoPesado;
import Grafo.Grafo;
import Grafo.GrafoImp;
import Grafo.Vertice;
import Grafo.Arco;
import Grafo.VerticeImp;

public class JsonToGrafo {
	
	public Grafo getGrafo(int nodos, int arcos, boolean conx) throws Exception {
	
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
			return createG(gr);
		} catch (Exception e) {
			throw new Exception(jsonString);
		}
	}
		
	private static Grafo createG(GrafoObj grafoJson){
			
		ArrayList<Vertice> vertices = new ArrayList<Vertice>();
		ArrayList<Arco> arcos;
		
		for(int i = 0; i < grafoJson.nodos.length; i++) {
			Vertice v = new VerticeImp(i);
			vertices.add(i,v);
		}
			

		arcos = new ArrayList<Arco>();
			
		Object[][] arcosJson = grafoJson.arcos;
			
		for (int i = 0; i < arcosJson.length; i++){
				
			//ArrayList<Vertice> arcoLista = new ArrayList<>(); 
				
			//VerticeImp v1 = new VerticeImp(((Double) ((ArrayList) arcosJson[i][0]).get(0)).intValue());
			//VerticeImp v2 = new VerticeImp(((Double) ((ArrayList) arcosJson[i][0]).get(1)).intValue());
			
			int posV1 = ((Double) ((ArrayList) arcosJson[i][0]).get(0)).intValue();
			int posV2 = ((Double) ((ArrayList) arcosJson[i][0]).get(1)).intValue();
			
			Vertice v1 = vertices.get(posV1);
			Vertice v2 = vertices.get(posV2);
			
			//arcoLista.add(v1);
			//arcoLista.add(v2);
			Arco arco = new ArcoPesado(v1, v2, ((Double) arcosJson[i][1]).intValue());
				
			v1.addAdyacente(arco);
			v2.addAdyacente(arco);
			//arcos.add(arco); 
		
		}
		
		return new GrafoImp(vertices);
	}
			
	class GrafoObj {
		int[] nodos;
		Object[][] arcos;
	}
	

}
