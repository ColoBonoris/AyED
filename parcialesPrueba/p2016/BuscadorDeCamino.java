package parcialesPrueba.p2016;

import estructuras.grafos.*;
import estructuras.listas.*;

public class BuscadorDeCamino {
    /**
     * Devuelve la cantidad de caminos que vuelven al origen.
     * Grafo no dirigido, con peso < 1 sin bs, sino hay.
     * 
     * @author Nico
     * 
     * @param inicio
     * @param estaciones
     * 
     * @return
     */
    public static int buscarCaminosBicisenda(Grafo<Character> estaciones, char inicio){
        ListaGenerica<Vertice<Character>> le = estaciones.listaDeVertices();
        int pos = -1;
        Vertice<Character> v = null;

        le.comenzar();
        while(! le.fin()){
            v = le.proximo();
            if(v.dato() == inicio){
                pos = v.getPosicion();
                break;
            }
        }

        if(pos == -1) return 0;

        int n = le.tamanio();
        boolean[] visitados = new boolean[n];
        for(int i=1;i<=n;i++) visitados[i] = false;

        return buscarCaminosBicisenda(v, estaciones, inicio, visitados.clone());
    }

    private static int buscarCaminosBicisenda(Vertice<Character> v, Grafo<Character> estaciones, char inicio, boolean[] visitados){
        ListaGenerica<Arista<Character>> ady = estaciones.listaDeAdyacentes(v);
        Arista<Character> a;
        Vertice<Character> u;
        int cant = 0;

        visitados[v.getPosicion()] = true;

        ady.comenzar();
        while(! ady.fin()){
            a = ady.proximo();
            u = a.verticeDestino();
            if(a.peso() > 0){
                if(u.dato() == inicio) cant ++;
                else if(! visitados[u.getPosicion()]) cant += buscarCaminosBicisenda(u, estaciones, inicio, visitados.clone());
            }
        }

        return cant;
    }
}
