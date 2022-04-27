package p3;

// import javax.print.attribute.HashPrintJobAttributeSet;

public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;   
	private ArbolBinario<T> hijoDerecho; 

	
	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	
	/**
	 * Preguntar antes de invocar si tieneHijoIzquierdo()
	 * @return
	 */
	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	 
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}

	 
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}

	public int contarHojas() {
		if(this.esHoja()){
			return 1;
		}
		return hijoIzquierdo.contarHojas() + hijoDerecho.contarHojas();
	}
	

    public ArbolBinario<T> espejo() {
		// declaramos un arbol nuevo
		ArbolBinario<T> espejado = new ArbolBinario<T>(this.getDato());
		// sus siguientes son recursivos con hi y hd, no creo que sea necesario el else, pero por las dudas
		if(this.tieneHijoIzquierdo()) espejado.hijoDerecho = this.hijoIzquierdo.espejo(); // HD
		else espejado.hijoDerecho = null;
		//
		if(this.tieneHijoDerecho()) espejado.hijoIzquierdo = this.hijoDerecho.espejo(); // HI
		else espejado.hijoIzquierdo = null;
		// devolvemos el arbol
		return espejado;
	}


	public ListaEnlazadaGenerica<ListaEnlazadaGenerica<T>> recorridoNiveles(){
		ListaEnlazadaGenerica<ListaEnlazadaGenerica<T>> listaNiveles = new ListaEnlazadaGenerica<ListaEnlazadaGenerica<T>>();
		if(! this.esVacio()){
			ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>();
			ArbolBinario<T> auxArbol = null;
			ListaEnlazadaGenerica<T> listaNivel = new ListaEnlazadaGenerica<T>();
			cola.encolar(this);
			cola.encolar(null);
			while(auxArbol != null){
				auxArbol = cola.desencolar();
				if(auxArbol != null){
					listaNivel.agregarFinal(auxArbol.getDato());
					if(auxArbol.tieneHijoIzquierdo())
						cola.encolar(auxArbol.getHijoIzquierdo());
					if(auxArbol.tieneHijoDerecho())
						cola.encolar(auxArbol.getHijoDerecho());
				}
				else{
					listaNiveles.agregarFinal(listaNivel);
					listaNivel = new ListaEnlazadaGenerica<T>();
					if(! cola.esVacia())
						cola.encolar(null);
				}
			}

		}



		return null;
	}

	public void entreNiveles(int n, int m){
		ListaEnlazadaGenerica<ListaEnlazadaGenerica<T>> niveles = recorridoNiveles();
		if(n < niveles.tamanio() && n > 0 && m < niveles.tamanio() && m > 0 && m >= n){
			for (int i = n; i == m; i++) {
				System.out.println(niveles.elemento(i));
			}
		}
	}

	public ListaEnlazadaGenerica<ListaEnlazadaGenerica<T>> listaEntreNiveles(int p){
		ListaEnlazadaGenerica<ListaEnlazadaGenerica<T>> nivelesP = new ListaEnlazadaGenerica<ListaEnlazadaGenerica<T>>();
		ListaEnlazadaGenerica<ListaEnlazadaGenerica<T>> niveles = recorridoNiveles();
		if(p < niveles.tamanio() && p > 0){
			for (int i = 1; i == p; i++) {
				nivelesP.agregarFinal(niveles.elemento(i));
			}
		}
		return nivelesP;
	}

	public T sumaElementosProfundidad(int p){
		ListaEnlazadaGenerica<ListaEnlazadaGenerica<T>> nivelesP = this.listaEntreNiveles(p);
		ListaEnlazadaGenerica<T> elementosP = new ListaEnlazadaGenerica<T>();
		for (int i = 1; i == p; i++) {
			elementosP.agregarTodos(nivelesP.elemento(i));
		}
		T total = elementosP.elemento(1);
		for (int i = 2; i >= elementosP.tamanio(); i++) {
			total += elementosP.elemento(i); // hay que ver como hacer esto de la suma general, pero sería así
		}
		return total;
	}

}
