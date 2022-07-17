package p6;

import estructuras.grafos.*;
import estructuras.listas.*;

public class Mapa {
    private Grafo<String> mapaCiudades;

    /*
     * Esto en realidad se hace en el método público de cada uno, pero generalicé un
     * poco
     *** VERIFICACIÓN EXISTENCIA DE NODOS
     */
    private boolean buscarOrigen(String origen) {
        ListaGenerica<Vertice<String>> lv = mapaCiudades.listaDeVertices();
        lv.comenzar();
        Vertice<String> v;
        while (!lv.fin()) {
            v = lv.proximo();
            if (v.dato() == origen)
                return true;
        }
        return false;
    }

    private boolean buscarDestino(String destino) {
        ListaGenerica<Vertice<String>> lv = mapaCiudades.listaDeVertices();
        lv.comenzar();
        Vertice<String> v;
        while (!lv.fin()) {
            v = lv.proximo();
            if (v.dato() == destino)
                return true;
        }
        return false;
    }

    /*
     * Retorna la lista de ciudades que se deben atravesar para ir de ciudad1 a
     * ciudad2 en caso que se pueda
     * llegar, si no retorna la lista vacía. (Sin tener en cuenta el combustible).
     *** 
     * PRIMER CAMINO
     */
    public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2) {
        ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
        ListaGenerica<Vertice<String>> lv = mapaCiudades.listaDeVertices();
        boolean[] visitados = new boolean[lv.tamanio()];

        if ((!buscarDestino(ciudad1)) | (!buscarOrigen(ciudad1)))
            return camino;

        Vertice<String> v;
        lv.comenzar();
        while (!lv.fin()) {
            v = lv.proximo();
            if (v.dato() == ciudad1)
                break;
        }

        devolverCamino(v, visitados, camino, ciudad1, ciudad2);

        return camino;
    }

    private boolean devolverCamino(Vertice<String> v, boolean[] visitados, ListaGenerica<String> camino, String ciudad1,
            String ciudad2) {
        boolean cond = false;
        visitados[v.getPosicion() - 1] = true;
        camino.agregarFinal(v.dato());
        // Caso Encontrado
        if (v.dato() == ciudad2) {
            return true;
        }
        // Caso Recursivo
        else {
            ListaGenerica<Arista<String>> la = mapaCiudades.listaDeAdyacentes(v);
            Vertice<String> u;
            la.comenzar();
            while (!cond && !la.fin()) {
                u = la.proximo().verticeDestino();
                if (!visitados[u.getPosicion() - 1])
                    cond = devolverCamino(u, visitados, camino, ciudad1, ciudad2);
            }
        }
        // Retorno
        if (!cond)
            camino.eliminarEn(v.getPosicion());

        return cond;
    }

    /*
     * Retorna la lista de ciudades que forman un camino desde ciudad1 a ciudad2,
     * sin pasar por las ciudades
     * que están contenidas en la lista ciudades pasada por parámetro, si no existe
     * camino retorna la lista
     * vacía. (Sin tener en cuenta el combustible).
     *** 
     * PRIMER CAMINO CON EXCEPCIONES
     */
    public ListaGenerica<String> devolverCaminoExceptuando(String ciudad1, String ciudad2,
            ListaGenerica<String> ciudadesRestringidas) {
        ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
        ListaGenerica<Vertice<String>> lv = mapaCiudades.listaDeVertices();
        boolean[] visitados = new boolean[lv.tamanio()];

        Vertice<String> v;
        lv.comenzar();
        while (!lv.fin()) {
            v = lv.proximo();
            if (v.dato() == ciudad1)
                break;
        }

        devolverCaminoExceptuando(v, visitados, camino, ciudad1, ciudad2, ciudadesRestringidas);

        return camino;
    }

    private boolean devolverCaminoExceptuando(Vertice<String> v, boolean[] visitados, ListaGenerica<String> camino,
            String ciudad1, String ciudad2, ListaGenerica<String> ciudadesRestringidas) {
        boolean cond = false;
        visitados[v.getPosicion() - 1] = true;
        camino.agregarFinal(v.dato());
        // Caso Encontrado
        if (v.dato() == ciudad2) {
            return true;
        }
        // Caso Recursivo
        else {
            ListaGenerica<Arista<String>> la = mapaCiudades.listaDeAdyacentes(v);
            Vertice<String> u;
            la.comenzar();
            while (!cond && !la.fin()) {
                u = la.proximo().verticeDestino();
                if ((!visitados[u.getPosicion() - 1]) && !(ciudadesRestringidas.incluye(u.dato())))
                    cond = devolverCaminoExceptuando(u, visitados, camino, ciudad1, ciudad2, ciudadesRestringidas);
            }
        }
        // Retorno
        if (!cond)
            camino.eliminarEn(v.getPosicion());

        return cond;
    }

    /*
     * Retorna la lista de ciudades que forman el camino más corto para llegar de
     * ciudad1 a ciudad2, si no
     * existe camino retorna la lista vacía. (Las rutas poseen la distancia). (Sin
     * tener en cuenta el
     * combustible).
     *** 
     * CAMINO MINIMO
     */
    public ListaGenerica<String> caminoMasCorto(String ciudad1, String ciudad2) {
        ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
        ListaGenerica<Vertice<String>> lv = mapaCiudades.listaDeVertices();
        boolean[] visitados = new boolean[lv.tamanio()];

        if ((!buscarDestino(ciudad1)) | (!buscarOrigen(ciudad1)))
            return camino;

        Vertice<String> v;
        lv.comenzar();
        while (!lv.fin()) {
            v = lv.proximo();
            if (v.dato() == ciudad1)
                break;
        }

        caminoMasCorto(v,visitados,camino,new ListaEnlazadaGenerica<String>(),ciudad1,ciudad2,-1,0);

        return camino;
    }

    private void caminoMasCorto(Vertice<String> v, boolean[] visitados, ListaGenerica<String> camino,
    ListaGenerica<String> actual, String ciudad1, String ciudad2, Integer pesoMin, int peso) {
        visitados[v.getPosicion() - 1] = true;
        actual.agregarFinal(v.dato());
        // Caso Encontrado
        if ((v.dato() == ciudad2) && ((peso < pesoMin) | (pesoMin == -1))) {
            // Actualizamos los mínimos
            camino = actual.clonar();
            pesoMin = peso;
        }
        // Caso Recursivo
        else {
            ListaGenerica<Arista<String>> la = mapaCiudades.listaDeAdyacentes(v);
            Vertice<String> u;
            Arista<String> a;
            int pesoActual;
            la.comenzar();
            while (!la.fin()) {
                a = la.proximo();
                u = a.verticeDestino();
                pesoActual = peso + a.peso();
                if (!visitados[u.getPosicion() - 1]  && (pesoActual < pesoMin))
                    caminoMasCorto(u, visitados, camino, actual, ciudad1, ciudad2, pesoMin, pesoActual);
            }
        }
        // Retorno
        actual.eliminarEn(actual.tamanio());
        visitados[v.getPosicion()] = false;
    }

    /*
     * Retorna la lista de ciudades que forman un camino para llegar de ciudad1
     * a ciudad2. El auto no debe quedarse sin combustible y no puede cargar. Si no
     * existe camino retorna la
     * lista vacía.
     *** 
     * CAMINO CON UN PESO MÁXIMO
     */
    public ListaGenerica<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
        ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
        ListaGenerica<Vertice<String>> lv = mapaCiudades.listaDeVertices();
        boolean[] visitados = new boolean[lv.tamanio()];

        if ((!buscarDestino(ciudad1)) | (!buscarOrigen(ciudad1)))
            return camino;

        Vertice<String> v;
        lv.comenzar();
        while (!lv.fin()) {
            v = lv.proximo();
            if (v.dato() == ciudad1)
                break;
        }

        caminoSinCargarCombustible(v,visitados,camino,ciudad1,ciudad2,tanqueAuto);
        return camino;
    }

    private boolean caminoSinCargarCombustible(Vertice<String> v, boolean[] visitados, ListaGenerica<String> camino,
    String ciudad1, String ciudad2, int tanqueAuto) {
        boolean cond = false;
        visitados[v.getPosicion() - 1] = true;
        camino.agregarFinal(v.dato());
        // Caso Encontrado
        if (v.dato() == ciudad2) {
            return true;
        }
        // Caso Recursivo
        else {
            ListaGenerica<Arista<String>> la = mapaCiudades.listaDeAdyacentes(v);
            Vertice<String> u;
            Arista<String> a;
            la.comenzar();
            while (!cond && !la.fin()) {
                a = la.proximo();
                u = a.verticeDestino();
                if ((!visitados[u.getPosicion() - 1])&&((tanqueAuto - a.peso()) >= 0))
                    cond = caminoSinCargarCombustible(u, visitados, camino, ciudad1, ciudad2, (tanqueAuto - a.peso()));
            }
        }
        // Retorno
        if (!cond){
            camino.eliminarEn(v.getPosicion());
            visitados[v.getPosicion()] = false;
        }

        return cond;
    }

    /*
     * Retorna la lista de ciudades que forman un camino para
     * llegar de ciudad1 a ciudad2 teniendo en cuenta que el auto debe cargar la
     * menor cantidad de veces. El
     * auto no se debe quedar sin combustible en medio de una ruta, además puede
     * completar su tanque al
     * llegar a cualquier ciudad. Si no existe camino retorna la lista vacía.
     * 
     * *** MÁXIMO PESO TEMPORAL Y MINIMA CANTIDAD DE CONSUMICIONES DEL MISMO
     */
    public ListaGenerica<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
        ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
        ListaGenerica<Vertice<String>> lv = mapaCiudades.listaDeVertices();
        boolean[] visitados = new boolean[lv.tamanio()];

        if ((!buscarDestino(ciudad1)) | (!buscarOrigen(ciudad1)))
            return camino;

        Vertice<String> v;
        lv.comenzar();
        while (!lv.fin()) {
            v = lv.proximo();
            if (v.dato() == ciudad1)
                break;
        }

        caminoConMenorCargaDeCombustible(v,visitados,camino,new ListaEnlazadaGenerica<String>(),ciudad1,ciudad2,tanqueAuto,tanqueAuto,0,0);
        return camino;
    }

    private void caminoConMenorCargaDeCombustible(Vertice<String> v, boolean[] visitados, ListaGenerica<String> camino, ListaGenerica<String> actual,
    String ciudad1, String ciudad2, int tanqueAuto, int maxTanque, int cargas, Integer minCargas) {
        visitados[v.getPosicion() - 1] = true;
        actual.agregarFinal(v.dato());
        // Caso Encontrado
        if((v.dato() == ciudad2)&&(cargas < minCargas)){
            // Actualiza mínimos
            camino = actual.clonar();
            minCargas = cargas;
        }
        // Caso Recursivo
        else {
            ListaGenerica<Arista<String>> la = mapaCiudades.listaDeAdyacentes(v);
            Vertice<String> u;
            Arista<String> a;
            la.comenzar();
            while (!la.fin()) {
                a = la.proximo();
                u = a.verticeDestino();
                // Si hay que cargar, carga y cuenta la carga
                if((tanqueAuto - a.peso()) <=  0){
                    if((!visitados[u.getPosicion() - 1])&&(cargas+1 < minCargas))
                        caminoConMenorCargaDeCombustible(u,visitados,camino,actual,ciudad1,ciudad2,maxTanque,maxTanque,cargas++,minCargas);
                // Si no hay que cargar sigue descontando del tanque
                }else if(!visitados[u.getPosicion() - 1]){
                    caminoConMenorCargaDeCombustible(u,visitados,camino,actual,ciudad1,ciudad2,tanqueAuto - a.peso(),maxTanque,cargas,minCargas);
                }
            }
        }
        // Retorno
        actual.eliminarEn(v.getPosicion());
        visitados[v.getPosicion()] = false;
    }
}
