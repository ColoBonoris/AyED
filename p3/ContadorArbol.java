package p3;

import estructuras.arboles.ArbolBinario;
import estructuras.listas.ListaEnlazadaGenerica;

public class ContadorArbol {
    private ArbolBinario<Integer> arbol;

    public ContadorArbol(){
        arbol = null;
    }

    public void agregarNumArbol(int n){
        ArbolBinario<Integer> a = this.arbol;
        agregarNumArbol(a,n);
    }

    private void agregarNumArbol(ArbolBinario<Integer> a, int n){
        if(a == null){
            a = new ArbolBinario<Integer>();
            a.setDato(n);
        }
        else{
            ArbolBinario<Integer> a2;
            if(n < a.getDato()){
                a2 = a.getHijoIzquierdo();
                agregarNumArbol(a2,n);
            }
            else{
                a2 = a.getHijoDerecho();
                agregarNumArbol(a2,n);
            }
        }
    }

    public ListaEnlazadaGenerica<Integer> numerosPares(){
        ListaEnlazadaGenerica<Integer> pares = new ListaEnlazadaGenerica<Integer>();
        numerosParesIn(this.arbol,pares);
        //numerosParesPos(this.arbol,pares);
        //numerosParesPre(this.arbol,pares);
        System.out.println(pares.tamanio());
        return pares;
    }

    public void numerosParesPre(ArbolBinario<Integer> a,ListaEnlazadaGenerica<Integer> pares){
        if(a != null){
            if(a.getDato() % 2 == 0) pares.agregarInicio(a.getDato());
            this.numerosParesPre(a.getHijoIzquierdo(),pares);
            this.numerosParesPre(a.getHijoDerecho(),pares);
        }
    }

    public void numerosParesPos(ArbolBinario<Integer> a,ListaEnlazadaGenerica<Integer> pares){
        if(a != null){
            this.numerosParesPos(a.getHijoIzquierdo(),pares);
            this.numerosParesPos(a.getHijoDerecho(),pares);
            if(a.getDato() % 2 == 0) pares.agregarFinal(a.getDato());
        }
    }

    public void numerosParesIn(ArbolBinario<Integer> a,ListaEnlazadaGenerica<Integer> pares){
        System.out.println(a.contarHojas());
        if(a != null){
            System.out.println("llega13");
            this.numerosParesIn(a.getHijoIzquierdo(),pares);
            if(a.getDato() % 2 == 0){
                pares.agregarFinal(a.getDato());
                System.out.println("llega12");
            }
            this.numerosParesIn(a.getHijoDerecho(),pares);
        }
    }
}
