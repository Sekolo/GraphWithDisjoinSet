package Actividad15;

import java.util.ArrayList;

import Grafo.Arco;

public class MergeSort {

	// Merges two subarrays of arr[]. 
	// First subarray is arr[l..m] 
	// Second subarray is arr[m+1..r] 
	void merge(ArrayList<Arco> arr, int l, int m, int r) 
	{ 
		// Find sizes of two subarrays to be merged 
		int n1 = m - l + 1; 
		int n2 = r - m; 

		/* Create temp arrays */
		ArrayList<Arco> L= new ArrayList<Arco> (n1); 
		ArrayList<Arco> R = new ArrayList<Arco> (n2); 

		/*Copy data to temp arrays*/
		for (int i=0; i<n1; ++i)
			L.set(i, arr.get(l+i));
		//	L[i] = arr.get(l+i)//[l + i]; 
			
		for (int j=0; j<n2; ++j) 
			R.set(j, arr.get(m + 1+ j));
			//R[j] = arr[m + 1+ j];
		


		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays 
		int i = 0, j = 0; 

		// Initial index of merged subarry array 
		int k = l; 
		while (i < n1 && j < n2) 
		{ 
			if (L.get(i).getPeso() <= R.get(j).getPeso()) 
			{ 
				//arr[k] = L[i]; 
				arr.set(k, L.get(i));
				i++; 
			} 
			else
			{ 
				//arr[k] = R[j]; 
				arr.set(k, R.get(j));
				j++; 
			} 
			k++; 
		} 

		/* Copy remaining elements of L[] if any */
		while (i < n1) 
		{ 
			//arr[k] = L[i];
			arr.set(k, L.get(i));
			i++; 
			k++; 
		} 

		/* Copy remaining elements of R[] if any */
		while (j < n2) 
		{ 
			//arr[k] = R[j]; 
			arr.set(k, R.get(j));
			j++; 
			k++; 
		} 
	} 

	// Main function that sorts arr[l..r] using 
	// merge() 
	void sort(ArrayList<Arco> arr, int l, int r) 
	{ 
		if (l < r) 
		{ 
			// Find the middle point 
			int m = (l+r)/2; 

			// Sort first and second halves 
			sort(arr, l, m); 
			sort(arr , m+1, r); 

			// Merge the sorted halves 
			merge(arr, l, m, r); 
		} 
	} 

	
	
	} 
