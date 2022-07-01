package parcialesPrueba;

import estructuras.grafos.*;
import estructuras.listas.*;

public class BuscadorDeCamino {
    /**
     * Este método debería devolver un camino de una ciudad origen a otra destino, saltando las rutas mayores a distanciaMaxima.
     * Recibe lo recién mencionado y devuelve null si no existe dicho camino.
     * 
     * @author Nico
     * 
     * @param ciudades
     * @param origen
     * @param destino
     * @param distanciaMaxima
     * 
     * @return
     */
    public static ListaGenerica<String> caminoDistanciaMaxima(Grafo<String> ciudades, String origen, String destino, int distanciaMaxima){

        int pos = -1;
        Vertice<String> v = null;
        ListaGenerica <Vertice<String>> lc = ciudades.listaDeVertices();
        boolean[] visitados = new boolean[lc.tamanio()];
        
        lc.comenzar();
        while(! lc.fin() && pos == -1){
            v = lc.proximo();
            if(v.dato().equals(origen)){
                pos = v.getPosicion();
            }
        }

        if(pos == -1){
            return null;
        }
        
        visitados[pos] = true;
        return caminoDistanciaMaxima(v, ciudades, origen, destino, distanciaMaxima, visitados);
    }

    private static ListaGenerica<String> caminoDistanciaMaxima(Vertice<String> v, Grafo<String> ciudades, String origen, String destino, int distanciaMaxima, boolean[] visitados){
        
        ListaGenerica<Arista<String>> ady = ciudades.listaDeAdyacentes(v);
        ListaGenerica <String> camino = null;
        Arista<String> a;
        Vertice<String> u;

        visitados[v.getPosicion()] = true;
        
        ady.comenzar();
        while(! ady.fin()){
            a = ady.proximo();
            u = a.verticeDestino();
            if(a.peso() <= distanciaMaxima && (! visitados[u.getPosicion()])){
                if(u.dato() != destino){
                    camino = caminoDistanciaMaxima(u, ciudades, origen, destino, distanciaMaxima, visitados);
                    if(camino != null){
                        camino.agregarInicio(v.dato());
                        return camino;
                    }
                }
                else{
                    camino = new ListaEnlazadaGenerica<String>();
                    camino.agregarInicio(u.dato());
                    return camino;
                }
            }
        }

        return null;
    }

}
