package p6;

import estructuras.grafos.*;
import estructuras.listas.*;
import estructuras.pilasColas.*;
/*

    Un poderoso e inteligente virus de computadora infecta cualquier computadora
    en 1 minuto, logrando infectar toda la red de una empresa con cientos de
    computadoras. Dado un grafo que representa las conexiones entre las
    computadoras de la empresa, y una computadora ya infectada, escriba un
    programa en Java que permita determinar el tiempo que demora el virus en
    infectar el resto de las computadoras. Asuma que todas las computadoras
    pueden ser infectadas, no todas las computadoras tienen conexión directa entre
    sí, y un mismo virus puede infectar un grupo de computadoras al mismo tiempo
    sin importar la cantidad.

*/


public class parcialRed {
    
    public int minutosInfeccionRed(Grafo<Integer> g, Integer pos){
        int aux_minutos = 0;

        ListaGenerica<Vertice<Integer>> lg = g.listaDeVertices();
        Vertice<Integer> infectada = lg.elemento(pos);
        lg.comenzar();

        ColaGenerica<Vertice<Integer>> Q = new ColaGenerica<Vertice<Integer>>();
        boolean[] visitados = new boolean[lg.tamanio()];

        visitados[infectada.getPosicion() - 1] = true;
        Q.encolar(infectada);
        Q.encolar(null);

        Vertice<Integer> v;
        ListaGenerica<Arista<Integer>> a;
        while(! Q.esVacia()){
            v = Q.desencolar();
            if(v != null){
                a = g.listaDeAdyacentes(v);
                a.comenzar();
                while(! a.fin()){
                    if(! visitados[v.getPosicion() - 1]){
                        visitados[v.getPosicion() - 1] = true;
                        Q.encolar(v);
                    }
                }
            }
            else if(! Q.esVacia()){
                aux_minutos ++ ;
                Q.encolar(null);
            }
        }

        return aux_minutos;
    }


}
