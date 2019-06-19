package Actividad15;

import java.util.ArrayList;

import Grafo.Arco;

public class MergeSort {
	

	// Merges two subarrays of arr[]. 
	// Primer Subarreglo es A[l..m] 
	// Segundo Subarreglo es A[m+1..r] 
	void merge(ArrayList<Arco> arr, int l, int m, int r) 
	{ 
		//Busco el tamano de los dos arreglos a ser ordenados
		int n1 = m - l + 1; 
		int n2 = r - m; 

		// Creo arreglos Temporales 
		ArrayList<Arco> L= new ArrayList<Arco> (n1); 
		ArrayList<Arco> R = new ArrayList<Arco> (n2); 

		//Copio elementos a los arreglos temporales
		for (int i=0; i<n1; ++i)
			L.add(i, arr.get(l+i));
		for (int j=0; j<n2; ++j) 
			R.add(j, arr.get(m + 1+ j));
		


		//Merge de los subarreglos 
 
		//Indices iniciales de los arreglos temporales
		int i = 0, j = 0; 
 
		int k = l; 
		while (i < n1 && j < n2) 
		{ 
			if (L.get(i).getPeso() <= R.get(j).getPeso()) 
			{ 
				arr.set(k, L.get(i));
				i++; 
			} 
			else
			{ 
				arr.set(k, R.get(j));
				j++; 
			} 
			k++; 
		} 
	
		//Copio elementos a L si en caso existen
		while (i < n1) 
		{ 
			//arr[k] = L[i];
			arr.set(k, L.get(i));
			i++; 
			k++; 
		} 

		//Copio elementos a L si en caso existen
		while (j < n2) 
		{ 
			arr.set(k, R.get(j));
			j++; 
			k++; 
		} 
	} 

	
	void sort(ArrayList<Arco> arr, int l, int r) 
	{ 
		if (l < r) 
		{ 
			// Busco el Punto medio
			int m = (l+r)/2; 

			// Sort first and second halves 
			sort(arr, l, m); 
			sort(arr , m+1, r); 

			// Merge de las mitades ordenadas
			merge(arr, l, m, r); 
		} 
	} 

	
	
	} 

