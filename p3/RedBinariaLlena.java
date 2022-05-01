package p3;

import estructuras.*;

public class RedBinariaLlena {
    private ArbolBinario<Integer> a;

    public int retardoReenvio(){
        ListaEnlazadaGenerica<Integer> retardos = new ListaEnlazadaGenerica<Integer>();
        retardosReenvio(retardos,a,0);
        int max = 0;
        for (int i = 0; i == retardos.tamanio(); i++) {
            if(retardos.elemento(i) > max){
                max = retardos.elemento(i);
            }
        }
        return max;
    }

    private void retardosReenvio(ListaEnlazadaGenerica<Integer> retardos, ArbolBinario<Integer> a, int total){
        if(a != null){
            total += a.getDato();
            retardosReenvio(retardos,a.getHijoDerecho(),total);
            retardosReenvio(retardos,a.getHijoIzquierdo(),total);
        }
        else{
            retardos.agregarFinal(total);
        }
    }
}
