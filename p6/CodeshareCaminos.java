package p6;

import estructuras.grafos.*;
import estructuras.listas.*;

public class CodeshareCaminos {
  
  import estructuras.grafos.*;
  import estructuras.listas.*;
  import estructuras.pilasColas.*;
  
  /**
   * Busca el vertice con el valor recibido.
   */
  private Vertice<String> buscarVertice(Grafo<String> g, String dato) {
      ListaGenerica<Vertice<String>> vertices = grafo.listaDeVerices();
      Vertice<String> v;
      vertices.comenzar(); 
      while (!vertices.fin()) {
        v = vertices.proximo();
        if (v.dato().equals(dato)) {
          return v;
        }
      }
      return null;
  }
  /*
  * PRIMER CAMINO
  */
  public ListaGenerica<String> primerCamino (Grafo<String> grafo,String origen, String destino) {
  
    ListaGenerica<String> resultado = new ListaEnlazadaGenerica<String>();
    boolean [] marcas = new boolean [grafo.listaDeVertices().tamanio() + 1];
    ListaGenerica<Vertice<String>> vertices = grafo.listaDeVertices();
    Vertice<String> v = this.buscarVertice(grafo,origen);   
  
    if (v !=null){
      dfsNormal(v,grafo, destino, marcas, resultado);
    }
  
    return resultado;
  }
  
  private boolean dfsNormal(Vertice<String> v, Grafo<String> grafo, String destino, boolean[] marcas, ListaGenerica<String> resultado){

    resultado.agregarFinal(v.dato());
    marcas[v.getPosicion()] = true;
    boolean llega = false;
    // Base
    if(v.dato().equals(destino)){
      return true;
    }
    // Recursivo
    ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(v);
    adyacentes.comenzar();
    while(! adyacentes.fin() && !llega){
        Vertice<String> u = adyacentes.proximo().verticeDestino(); 
        if(! marcas[u.getPosicion()]){
          llega = dfsNormal(u,grafo, destino, marcas, resultado); 
        }
    }
    // Retorno
    if(! llega) {
      resultado.eliminarEn(resultado.tamanio());
    }
    return llega;
  }
  
  //_____________________________________________________________________________________________________________________________________________
  //PRIMER CAMINO CON EXCEPCIONES
  private boolean dfsExcepciones(Vertice<String> v, Grafo<String> grafo, String destino, boolean[] marcas, ListaGenerica<String> resultado){
    resultado.agregarFinal(v.dato());
    marcas[v.getPosicion()] = true;
    boolean llega = false;
    //PastaBase
    if(v.dato().equals(destino)){
      return true;
    }
    //Recursivo
    else{
      ListaGenerica<Arista<String>> adyacentes = grafo.ListaDeAdyacentes(v);
      adyacentes.comenzar();
            while(! adyacentes.fin() && !llega){
                  Vertice<String> u = adyacentes.proximo().verticeDestino(); 
              if(!restringidas.incluye(u.dato()) && !marca[u.getPosicion()]) {
              llega = dfsNormal(u,grafo, destino, marcas, resultado); 
          }
      }
    }
    //Retorno
    if(!llega) {
      resultado.eliminarEn(resultado.tamanio());
      //resultado.eliminar(v.dato());
    }
    return llega;
  }                                             
   /*
   *   CAMINO MINIMO
   */
  public ListaGenerica<String> caminoMenorPeso(Grafo<String> grafo,String origen, String destino){
    // boolean [] marcas = new boolean [grafo.ListaDeAdyacentes().tamanio() + 1]; mal
    Resultado res = new Resultado();
    boolean [] marcas = new boolean [grafo.listaDeVerices().tamanio() + 1];
    ListaGenerica<Vertice<String>> vertices = grafo.listaDeVerices();
    
    Vertice<String> v;   
    boolean encontro = false;
    vertices.comenzar(); 
    while (!vertices.fin() && !encontro) {
        v = vertices.proximo();
        encontro = v.dato().equals(origen);   
    }
    if (encontro){
      dfsMenorCamino(v,grafo, destino, marcas, res, new ListaEnlazadaGenerica<String>(),0);
    }  
    return res.camino;
  }
    
  public class Resultado {
    public int costo = Integer.MAX_VALUE;
    public ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
    
    boolean existeResultado() {
      return costo < Integer.MAX_VALUE;
    }
  }
  
  private void dfsMenorCamino(Vertice<String> v, Grafo<String> grafo, String destino, boolean[] marcas, Resultado resultado, ListaGenerica<String> actual, int pesoAcumulado) {
    actual.agregarFinal(v.dato());
    marcas[v.getPosicion()] = true;
    // Caso encontrado
    if(v.dato().equals(destino)){
      resultado.camino = actual.clonar();
      resultado.costo = pesoAcumulado;
    }
    // Caso recursivo
    else{
      ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(v);
      adyacentes.comenzar();
      while (!adyacentes.fin()) {
      Arista<String> a = adyacentes.proximo();
      Vertice<String> u = a.verticeDestino();
      int pesoActual = pesoAcumulado + a.peso(); 
        if (!marcas[u.getPosicion()] && pesoActual < resultado.costo){
          dfsMenorCamino(u, grafo, destino, marcas, resultado, actual, pesoActual);
        }
      }
    }
    // Retorno
    actual.eliminarEn(actual.tamanio());
    marcas[v.getPosicion()] = false;
  }
  
      /*CAMINO CON UN PESO MÁXIMO*/
  private boolean dfsMaximo(Vertice<String> v, Grafo<String> grafo, String destino, boolean [] marcas, ListaGenerica<String> resultado, int pesoAcumulado, int maximo){
    marcas[v.getPosicion()] = true; 
    resultado.agregarFinal(v.dato());
    boolean llega = false;
    // Caso Encontrado
    if (v.dato().equals(destino)) {
        return true;
    }
    // Caso Recursivo
    else{
      ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(v); 
      adyacentes.comenzar();
      while(! adyacentes.fin() && !llega){
        Arista<String> a = adyacentes.proximo();
          Vertice<String> u  = a.verticeDestino();
        int pesoActual = pesoAcumulado + a.peso();
          if(! marcas[v.getPosicion()] && ! (pesoActual <= maximo)){ // Ver mucho el problema
          llega = dfs(u, grafo, destino, marcas, resultado, pesoActual , maximo);
        }
      }
    }
    // Retorno
    if(! llega){
      resultado.eliminarEn(resultado.tamanio());
      marcas[v.getPosicion()] = false; 
    }
    
    return llega;
  }
    /*
   
   * CAMINO CON UN PESO MINMO
   */
  public ListaGenerica<String> caminoConMinimo(Grafo<String> grafo,String origen, String destino, int minimo){
    ListaGenerica<String> resultado = new ListaEnlazadaGenerica<String>();
    boolean [] marcas = new boolean [grafo.listaDeAdyacentes().tamanio() + 1];
    ListaGenerica<Vertice<String>> vertices = grafo.listaDeVerices();
    Vertice<String> v;   
    boolean encontro = false;
    vertices.comenzar(); 
    while (!vertices.fin() && !encontro) {
        v = vertices.proximo();
        encontro = v.dato().equals(origen);   
    }
    if (encontro){
        dfs(v, grafo, destino, marcas, resultado, 0 , minimo);
    }
    return resultado;
  }
  
private boolean dfs(Vertice<String> v, Grafo<String> grafo, String destino, boolean [] marcas, ListaGenerica<String> resultado, int pesoAcumulado, int minimo){
    marcas[v.getPosicion()] = true; 
      resultado.agregarFinal(v.dato());
    boolean llega = false;
    // Caso Encontrado
    if (v.dato().equals(destino)&&(pesoAcumulado >= minimo)) {
        return true;
    }
    // Caso Recursivo
      else if(! v.dato().equals(destino)){
        ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(v); 
        adyacentes.comenzar();
      while(! adyacentes.fin() && !llega){
        Arista<String> a = adyacentes.proximo();
          Vertice<String> u  = a.verticeDestino();
          if(! marcas[v.getPosicion()]){ // Ver mucho el problema
          llega = dfs(u, grafo, destino, marcas, resultado, pesoAcumulado + a.peso() , minimo);
        }
      }
    }
    // Retorno
    if(! llega){
      resultado.eliminarEn(resultado.tamanio());
      marcas[v.getPosicion()] = false; 
    }
    
    return llega;
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
  public ListaGenerica<String> caminoMenoresConsumicionesPesoTemporal(Grafo<String> g, String origen, String destino, int maxTanque){
      ListaGenerica<String> resultado = ListaEnlazadaGenerica<String>();
    boolean [] marcas = new boolean [grafo.ListaDeAdyacentes().tamanio() + 1];
    ListaGenerica<Vertice<String>> vertices = grafo.listaDeVerices();
    Vertice<String> v;   
    boolean encontro = false;
    vertices.comenzar(); 
    while (!vertices.fin() && !encontro) {
        v = vertices.proximo();
        encontro = v.dato().equals(origen);   
    }
    if (encontro){
          ResultadoTanque resTemp = new ResultadoTanque();
          dfs(v,grafo,origen,destino,marcas,resTemp,maxTanque,maxTanque,0);
          if(ResultadoTanque.camino )
    }
    return resultado;
  }

  public Class ResultadoTanque(){
    public int maximo = -1; 
    public ListaGenerica<String> camino;
    
  }

  private void dfs(Vertice<String> v, Grafo<String> grafo, String destino, boolean[] marcas, ResultadoTanque resultado, int tanqueAuto, int tanqueActual, int cargasActuales) {
    // Preparación
    actual.agregarFinal();
    marcas[v.getPosicion] = true;
    // Caso base
    if(v.dato().equals(destino) && (cargasActuales < cargasMin)){
        cargasMin = cargasActuales;
        resultado = actual.clonar();
    }
    // Caso recursivo
    else{
      ListaGenerica<Arista<String>> adyacentes
      Arista<String> a;
      Vertice<String> u;
      adyacentes.comenzar();
      while(! adyacentes.fin()){
          a = adyacentes.proximo();
          u = a.verticeDestino();
          int pesoActual = tanqueActual - a.peso();
          if(! marcas[v.getPosicion()]){
              if(tanque actual >= 0)&&(cargasActuales+1 < cargasMin)
                    dfs(u,grafo,destino,marcas,resultado,actual,tanqueAuto,tanqueAuto,cargasActuales +1,cargasMin)
              else
                    dfs(u,grafo,destino,marcas,resultado,actual,tanqueAuto,pesoActual,cargasActuales,cargasMin)
          }
      }
    }
    // Retorno
    actual.eliminar(v.dato());
    marcas[v.getPosicion] = false;
  }
  
}  }