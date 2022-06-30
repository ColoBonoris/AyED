package p6;
/*
 Ejercicio 4

    a. Implemente en JAVA una clase llamada Recorridos ubicada dentro del paquete ejercicio5
        cumpliendo la siguiente especificación:
        dfs(Grafo<T> grafo): ListaGenerica <T> // Retorna una lista de vértices con el recorrido en
        profundidad del grafo recibido como parámetro.
        bfs(Grafo<T> grafo): ListaGenerica <T>// Retorna una lista de vértices con el recorrido en amplitud
        del grafo recibido como parámetro.
    b. Estimar los órdenes de ejecución de los métodos anteriores
 */

import estructuras.grafos.*;
import estructuras.listas.*;
import estructuras.pilasColas.*;

public class ClaseRecorridos<T> {


// DFS
    public ListaGenerica<Vertice<T>> DFS(Grafo<T> g){
        /* 
            main:dfs (grafo)
                inicializar marca en false (arreglo de booleanos);
                para cada vértice v del grafo
                    si v no está visitado
                        dfs(v);
        */
        ListaGenerica<Vertice<T>> lg = g.listaDeVertices();
        ListaEnlazadaGenerica<Vertice<T>> recorrido = new ListaEnlazadaGenerica<Vertice<T>>();
        int n = lg.tamanio();

        boolean[] visitados = new boolean[n];
        int i;
        for(i=1;i<=n;i++){
            visitados[i] = false;
        }

        lg.comenzar();
        for(i=1;i<=n;i++){
            if(! visitados[i])
                DFS(lg.elemento(i), g, visitados,recorrido);
        }

        return recorrido;
    }

    public void DFS(Vertice<T> v, Grafo<T> g, boolean[] visitados, ListaGenerica<Vertice<T>> recorrido){
        /* 
            dfs (v: vértice)
                marca[v]:= visitado;
                para cada nodo w adyacente a v
                    si w no está visitado
                        dfs(w);
        */
        visitados[v.getPosicion()] = true;
        recorrido.agregarFinal(v);

        ListaGenerica<Arista<T>> ady = g.listaDeAdyacentes(v);
        int n = ady.tamanio();
        Vertice<T> w;
        for(int i=1;i<=n;i++){
            w = ady.elemento(i).verticeDestino();
            if(! visitados[w.getPosicion()]){
                DFS(w, g, visitados, recorrido);
            }
        }
    }


//BFS
    public ListaGenerica<Vertice<T>> BFS(Grafo<T> g){
        /*
            1. Encolar el vértice origen u.
            2. Marcar el vértice u como visitado.
            3. Procesar la cola.
            4. Desencolar u de la cola
            5.  adyacente a u,(u,v) Є E,
            6. si v no ha sido visitado
            7. encolar y visitar v
        */
        ListaGenerica<Vertice<T>> lg = g.listaDeVertices();
        ListaEnlazadaGenerica<Vertice<T>> recorrido = new ListaEnlazadaGenerica<Vertice<T>>();
        int n = lg.tamanio();
        ColaGenerica<Vertice<T>> Q = new ColaGenerica<Vertice<T>>();
        boolean[] visitados = new boolean[n];

        int i;
        Vertice <T> v;

        lg.comenzar();
        Vertice <T> u = lg.proximo();
        Q.encolar(u);
        recorrido.agregarFinal(u);
        visitados[u.getPosicion()] = true;

        while( ! (lg.fin() | Q.esVacia()) ){
            u = Q.desencolar();
            ListaGenerica<Arista<T>> lu = g.listaDeAdyacentes(u);
            lu.comenzar();
            for(i=1;i<=lu.tamanio();i++){
                v = lu.proximo().verticeDestino();
                if(! visitados[v.getPosicion()]){
                    visitados[v.getPosicion()] = true;
                    recorrido.agregarFinal(v);
                    Q.encolar(v);
                }
            }
        }
        
        return recorrido;
    }

}
