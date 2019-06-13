package GrafoTurbio;
/**
 * Interface Map
 * @author Iñaki Barreix y Sebastian Benamo, alumnos de Estructuras de Datos(2015), Departamento de Cs. e Ing. de la Computación, UNS.
 */

public interface Map<K,V>{
	/**
	 * Consulta la cantidad de entradas de M.
	 * @return Cantidad de entradas de M.
	 */
	public int size();
	
	/**
	 * Consulta si M está vacío.
	 * @return Verdadero si la M está vacío, falso en caso contrario.
	 */
	public boolean isEmpty();
	
	/**
	 * Devuelve el valor de entrada K
	 * @param k A obtener su valor
	 * @return Si M contiene entrada con clave igual a K, valor de V. Sino null.
	 */
	public V get(K k) throws InvalidKeyException;
	
	/** 
	 * Agrega una entrada <k,v> a M
	 * @param k Clave a agregar o cambiar su contenido.
	 * @param v Valor a asignar clave K.
	 * @return Si M ya tiene una entrada 'e' con clave k, valor antiguio de 'e'. Sino, devuelve null. 
	 * 
	 */
	public V put (K k, V v) throws InvalidKeyException;
	
	/**
	 * Remueve de M la entrada con clave K.
	 * @param k Clave a eliminar de M.
	 * @return Si M tiene entrada con clave K, su valor. Sino, devuelve null.
	 */
	public V remove (K k) throws InvalidKeyException;
	
	/**
	 * Retorna Una coleccion iterable de las claves en M.
	 * @return Una coleccion iterable de las claves en M.
	 */
	public Iterable<K> keys();
	
	/**
	 * Retorna Una coleccion iterable con los valores de las claves almacenadas en M.
	 * @return Una coleccion iterable con los valores de las claves almacenadas en M.
	 */
	public Iterable<V> values();
	
	/**
	 * Retorna Una coleccion iterable con las entradas de M.
	 * @return Una coleccion iterable con las entradas de M.
	 */
	public Iterable<Entry<K,V>> entries();
}