package p2;

public class ColaGenerica<T>{

    private NodoGenerico<T> tope;
    private ListaEnlazadaGenerica<T> datos;

    public ColaGenerica(){
        this.datos = new ListaEnlazadaGenerica<T>();
        this.tope = null;
    }

    public void encolar(NodoGenerico<T> n){
        this.datos.agregarInicio(n.getDato());
        this.tope = n;
    }

    public void desencolar(){
        this.datos.eliminarEn(this.datos.tamanio());
        if(! this.datos.esVacia()){
            this.tope = new NodoGenerico<T>();
            this.tope.setDato(this.datos.elemento(this.datos.tamanio()));
        }
        else
            this.tope = null;
    }

    public boolean esVacia(){
        return this.tope == null;
    }

    public NodoGenerico<T> tope(){
        return this.tope;
    }

}
