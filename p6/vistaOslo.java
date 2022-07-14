package p6;
import estructuras.grafos.*;
import estructuras.listas.*;

public class vistaOslo {

    public ListaGenerica<String> paseoEnBici(Grafo<String> lugares, String destino,  int maxTiempo, ListaGenerica<String> lugaresRestringidos){
        ListaGenerica<Vertice<String>> lv = new ListaEnlazadaGenerica<Vertice<String>>();
        Vertice<String> v;
        ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
        boolean[] visitados = new boolean[lv.tamanio()];

        lv.comenzar();
        while(! lv.fin()){
            v = lv.proximo();
            if(v.dato() == "Ayuntamiento"){
                visitados[v.getPosicion() - 1] = true;
                dfs(lugares,v,destino,maxTiempo,lugaresRestringidos,camino,visitados,0);
                break;
            }
        }

        return camino;
    }

    private boolean dfs(Grafo<String> lugares, Vertice<String> v, String destino,  int maxTiempo, ListaGenerica<String> lugaresRestringidos, ListaGenerica<String> camino, boolean[] visitados, int peso){
        boolean cond = false;
        camino.agregarFinal(v.dato());
        visitados[v.getPosicion() - 1] = true;
        // caso fin
        if((v.dato() == destino)&&(peso < maxTiempo)){
            return true;
        }
        // caso recursivo
        else{
            Vertice<String> u;
            Arista<String> a;
            ListaGenerica<Arista<String>> la = lugares.listaDeAdyacentes(v);

            la.comenzar();
            while((! la.fin())&&(! cond)){
                a = la.proximo();
                u = a.verticeDestino();
                if(!(lugaresRestringidos.incluye(u.dato())) && (! visitados[v.getPosicion()]))
                    cond = dfs(lugares,u,destino,maxTiempo,lugaresRestringidos,camino,visitados,peso + a.peso());
            }
        }
        // retorno
        if(! cond){
            camino.eliminarEn(camino.tamanio());
            visitados[v.getPosicion() - 1] = false;
        }
        
        return cond;
    }
}
