package p2;

public class PilaGenerica<T>{

    private NodoGenerico<T> tope;
    private ListaEnlazadaGenerica<T> datos;

    public PilaGenerica(){
        this.datos = new ListaEnlazadaGenerica<T>();
        this.tope = null;
    }

    public void apilar(T n){
        this.datos.agregarFinal(n);
        this.tope = new NodoGenerico<T>();
        this.tope.setDato(n);
    }

    public T desapilar(){
        T aux = this.tope.getDato();
        this.datos.eliminarEn(this.datos.tamanio());
        if(! this.datos.esVacia()){
            this.tope = new NodoGenerico<T>();
            this.tope.setDato(this.datos.elemento(this.datos.tamanio()));
        }
        else
            this.tope = null;
        return aux;
    }

    public boolean esVacia(){
        return this.tope == null;
    }

    public NodoGenerico<T> tope(){
        return this.tope;
    }

}
