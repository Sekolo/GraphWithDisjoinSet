package Cola;




public class Cola<Vertice> implements Queue<Vertice> {
	//	<<		Atributos de instancia		>>
	private Vertice[] A;
	private int front, rear, cant;
	
	//	<<		Constructor		>>
	public Cola (int s){
		front=0;
		rear=0;
		cant=0;
		A=(Vertice[]) new Object[s];
	}
	//	<<		Comandos		>>
	public void enqueue(Vertice e)
	{
		//esta lleno
		if(cant== A.length)
		{
			Vertice[] aux= (Vertice[]) new Object[cant+1];
			for(int i=0; i<cant; i++)
				aux[i]= A[i];
			A= null;
			A= aux;
			}
		A[rear]= e;
		rear=rear+1;
		cant++;
	}
	public Vertice front() throws Exception{
		if(cant==0)
			throw new Exception("Error, cola vacia");
		else
			return A[front];
	}
	
	public Vertice dequeue() throws Exception{
		if (cant==0)
			throw new Exception("Error, cola vacia");
		else{
			Vertice aux= A[front];
			A[front]=null;
			//lo maté =)
		    front=front+1;
			cant--;
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
}
