package Cola;




/**
 * Interface Queue
 */

public interface Queue <Vertice>
{
	/**
	 * Devuelve la cantidad de elementos en la cola.
	 * @return Cantidad de elementos en la cola.
	 */
	public int size();
	
	/**
	 * Consulta si la cola est� vac�a.
	 * @return Verdadero si la cola est� vac�a, falso en caso contrario.
	 */
	public boolean isEmpty();
	
	/**
	 * Inspecciona el elemento que se encuentra en el frente de la cola.
	 * @return Elemento que se encuentra en el frente de la cola.
	 * @throws EmptyQueueException si la cola est� vac�a.
	 */
	public Vertice front() throws Exception;
	
	/**
	 * Inserta un elemento en el fondo de la cola.
	 * @param element Nuevo elemento a insertar.
	 */
	public void enqueue(Vertice element);
	
	/**
	 * Remueve el elemento en el frente de la cola.
	 * @return Elemento removido.
	 * @throws EmptyQueueException si la cola est� vac�a.
	 */
	public Vertice dequeue() throws Exception;
}