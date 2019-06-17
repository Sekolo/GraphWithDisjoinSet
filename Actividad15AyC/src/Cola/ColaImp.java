package Cola;

import Grafo.Vertice;

public class ColaImp implements Cola {
	//	<<		Atributos de instancia		>>
	private Vertice[] vertices;
	private int front, rear, cant;
	private int sInicial;
	
	//	<<		Constructor		>>
	public ColaImp (int s){
		front=0;
		rear=0;
		cant=0;
		vertices= new Vertice[s];
		sInicial = s;
	}
	//	<<		Comandos		>>
	public void enqueue(Vertice e)
	{
		//esta lleno
		if(cant== vertices.length)
		{
			Vertice[] aux= new Vertice[cant+1];
			for(int i=0; i<cant; i++)
				aux[i]= vertices[i];
			vertices= null;
			vertices= aux;
			}
		vertices[rear]= e;
		rear=rear+1;
		cant++;
	}
	public Vertice front() throws Exception{
		if(cant==0)
			throw new Exception("Error, cola vacia");
		else
			return vertices[front];
	}
	
	public Vertice dequeue() throws Exception{
		if (cant==0)
			throw new Exception("Error, cola vacia");
		else{
			Vertice aux= vertices[front];
			vertices[front]=null;
		    front=front+1;
			cant--;
			if(cant==0) {
				resize();
			}
			return aux;
		}
	}
	//	<<		Consultas		>>
	public boolean isEmpty(){
		return cant==0;
	}
	
	public int size(){
		return cant;
	}
	
	private void resize() {
		front=0;
		rear=0;
		cant=0;
		vertices= new Vertice[sInicial];
	}
	
}
