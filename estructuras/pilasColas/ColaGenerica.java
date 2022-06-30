package estructuras.pilasColas;

import estructuras.listas.ListaEnlazadaGenerica;
import estructuras.listas.NodoGenerico;

public class ColaGenerica<T>{

    private NodoGenerico<T> tope;
    private ListaEnlazadaGenerica<T> datos;

    public ColaGenerica(){
        this.datos = new ListaEnlazadaGenerica<T>();
        this.tope = null;
    }

    public void encolar(T n){
        this.datos.agregarInicio(n);
        this.tope = new NodoGenerico<T>();
        this.tope.setDato(n);
    }

    public T desencolar(){
        this.datos.eliminarEn(this.datos.tamanio());
        T aux = null;
        if(! this.datos.esVacia()){
            aux = tope.getDato();
            this.tope = new NodoGenerico<T>();
            this.tope.setDato(this.datos.elemento(this.datos.tamanio()));
        }
        else
            this.tope = null;
        return aux;
    }

    public boolean esVacia(){
        return this.datos == null;
    }

    public NodoGenerico<T> tope(){
        return this.tope;
    }

}
