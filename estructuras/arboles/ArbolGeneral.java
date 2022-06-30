package estructuras.arboles;
import java.lang.Comparable;

import org.omg.IOP.TAG_MULTIPLE_COMPONENTS;

import estructuras.listas.ListaEnlazadaGenerica;
import estructuras.listas.ListaGenerica;
import estructuras.pilasColas.ColaGenerica;

public class ArbolGeneral<T> implements Comparable<T>{

	// No parece haber ninguan forma de agregar dentro de los hijos

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();

	public int compareTo(T n){
		return this.getDato() - n;
	}

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return !this.hijos.esVacia();
	}
	
	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}
	
	public ListaEnlazadaGenerica<T> preOrden() {
		return null;
	}
	
	public Integer altura() {
		// Falta implementar..
		return 0;
	}

	public Integer nivel(T dato) {
		// falta implementar
		return -1;
	}

	public Integer ancho() {
		// Falta implementar..
		return 0;
	}
	//--------------------------------------------------------------------------------------------
	public ListaGenerica<Integer> numerosImparesMayoresQuePreOrden(ArbolGeneral<Integer> a,Integer n){
	/*
		Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n” 
		pasados como parámetros, recorrido en preorden.  
	*/ 
	// Voy a suponer que los elementos no están ordenados porque no se especifica un orden
		ListaEnlazadaGenerica<Integer> aux = new ListaEnlazadaGenerica<Integer>();
		//
		if(a.getDato() > n){	
			aux.agregarFinal(a.getDato());
		}
		//
		if(a.tieneHijos()){
			ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
			ArbolGeneral<Integer> auxNodo;
			hijos.comenzar();
			for (int i = 0; i < hijos.tamanio(); i++) {
				auxNodo = hijos.proximo();
				if((auxNodo.getDato() > n) && (auxNodo.getDato() % 2 == 0)){
					aux.agregarFinal(hijos.elemento(i).getDato());
				}
				aux.agregarTodos(numerosImparesMayoresQuePreOrden(auxNodo,n));
			}
		}
		return(aux);
	}	
	public ListaGenerica<Integer> numerosImparesMayoresQueInOrden(ArbolGeneral<Integer> a,Integer n){
	/*
		Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n” 
		pasados como parámetros, recorrido en inorden.
	*/
		ListaEnlazadaGenerica<Integer> aux = new ListaEnlazadaGenerica<Integer>();
		//
		if(a.tieneHijos()){
			ArbolGeneral<Integer> auxNodo;
			ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
			hijos.comenzar();
			for (int i = 0; i < hijos.tamanio()-1; i++) {
				auxNodo = hijos.proximo();
				if((auxNodo.getDato() > n) && (auxNodo.getDato() % 2 == 0)){
					aux.agregarFinal(hijos.elemento(i).getDato());
				}
				aux.agregarTodos(numerosImparesMayoresQueInOrden(auxNodo,n));
			}
		}
		//
		if(a.getDato() > n){	
			aux.agregarFinal(a.getDato());
		}
		//
		if(a.tieneHijos()){
			ArbolGeneral<Integer> auxNodo;
			ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
			auxNodo = hijos.proximo();
			if((auxNodo.getDato() > n) && (auxNodo.getDato() % 2 == 0)){
				aux.agregarFinal(hijos.elemento(hijos.tamanio() - 1).getDato());
			}
			aux.agregarTodos(numerosImparesMayoresQueInOrden(auxNodo,n));
		}
		return(aux);
	}
	
	public ListaGenerica<Integer> numerosImparesMayoresQuePostOrden(ArbolGeneral<Integer> a,Integer n){
	/*
		Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n” 
		pasados como parámetros recorrido en postorden.
	*/
		ListaEnlazadaGenerica<Integer> aux = new ListaEnlazadaGenerica<Integer>();
		//
		if(a.tieneHijos()){
			if(a.getHijos().tamanio() > 1){
				ListaGenerica<ArbolGeneral<Integer>> hijos = a.getHijos();
				hijos.comenzar();
				for (int i = 1; i < hijos.tamanio(); i++) {
					ArbolGeneral<Integer> auxNodo = hijos.proximo();
					if((auxNodo.getDato() > n) && (auxNodo.getDato() % 2 == 0)){
						aux.agregarFinal(hijos.elemento(i).getDato());
					}
					aux.agregarTodos(numerosImparesMayoresQuePostOrden(auxNodo,n));
				}
			}
		}
		//
		if(a.getDato() > n){	
			aux.agregarFinal(a.getDato());
		}
		return(aux);
	}
	public ListaGenerica<T> numerosImparesMayoresQuePorNiveles(T n){

		ListaEnlazadaGenerica<T> listaNiveles;
		if(! this.esVacio()){
			ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
			ArbolGeneral<T> auxArbol = null;
			ArbolGeneral<T> auxHijos = null;

			cola.encolar(this);
			cola.encolar(null);

			while(! cola.esVacia()){

				listaNiveles  = new ListaEnlazadaGenerica<T>();

				auxArbol = cola.desencolar();
				auxArbol.getHijos().comenzar();

				while(auxArbol != null){
					if(auxArbol.getDato().compareTo(n) > 0){
						listaNiveles.agregarFinal(auxArbol.getDato());
					}
					for (int i = 0; i < auxArbol.getHijos().tamanio(); i++) {
						auxHijos = auxArbol.getHijos().proximo();
						if((auxHijos.getDato() > n){
							listaNiveles.agregarFinal(auxHijos.getDato());
						}
					}
					auxArbol = cola.desencolar();	
				}

				if((! cola.esVacia())){
					cola.encolar(null);
				}
			}
		}
		return listaNiveles;
	}
	public ListaEnlazadaGenerica<ListaEnlazadaGenerica<T>> listaNiveles(){
	/*
		Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n” 
		pasados como parámetros, recorrido por niveles.
	*/
		ListaEnlazadaGenerica<ListaEnlazadaGenerica<T>> listaNiveles = new ListaEnlazadaGenerica<ListaEnlazadaGenerica<T>>();
		if(! this.esVacio()){
			ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
			ArbolGeneral<T> auxArbol = null;
			ArbolGeneral<T> auxHijos = null;
			ListaEnlazadaGenerica<T> listaNivel;

			cola.encolar(this);
			cola.encolar(null);

			while(! cola.esVacia()){

				listaNivel = new ListaEnlazadaGenerica<T>();

				auxArbol = cola.desencolar();
				auxArbol.getHijos().comenzar();

				while(auxArbol != null){
					listaNivel.agregarFinal(auxArbol.getDato());
					for (int i = 0; i < auxArbol.getHijos().tamanio(); i++) {
						auxHijos = auxArbol.getHijos().proximo();
						listaNivel.agregarFinal(auxHijos.getDato());
					}
					auxArbol = cola.desencolar();	
				}

				listaNiveles.agregarFinal(listaNivel);

				if((! cola.esVacia())){
					cola.encolar(null);
				}
			}
		}
		return listaNiveles;
	}
}