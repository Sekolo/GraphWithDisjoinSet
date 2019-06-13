package GrafoTurbio;


public class ColaConArregloCircular<E> implements Queue<E> {
	//	<<		Atributos de instancia		>>
	private E[] A;
	private int front, rear, cant;
	
	//	<<		Constructor		>>
	public ColaConArregloCircular (int s){
		front=0;
		rear=0;
		cant=0;
		A=(E[]) new Object[s];
	}
	//	<<		Comandos		>>
	public void enqueue(E e){
		if(cant== A.length){
			E[] aux= (E[]) new Object[cant+1];
			for(int i=0; i<cant; i++)
				aux[i]= A[i];
			A= null;
			A= aux;}
		A[rear]= e;
		rear=(rear+1)%(A.length);
		cant++;
	}
	public E front() throws EmptyQueueException{
		if(cant==0)
			throw new EmptyQueueException("Error, cola vacia");
		else
			return A[front];
	}
	
	public E dequeue() throws EmptyQueueException{
		if (cant==0)
			throw new EmptyQueueException("Error, cola vacia");
		else{
			E aux= A[front];
			A[front]=null;
			//lo maté =)
		    front=(front+1)%A.length;
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
