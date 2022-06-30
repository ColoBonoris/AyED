package p4;


public class TestArbolesGenerales {
    /* Ejercicio_2:
    
    a)  ¿Qué recorridos conoce para recorrer en profundidad un árbol general? Explique brevemente.
        - InOrden, PostOrden y PreOrden recorren el arbol en profundidad, ya que hacen los recorridos
          rama por rama.

    b) ¿Qué recorridos conoce para recorrer por niveles un árbol general? Explique brevemente.
        - El recorrido "por niveles" (valga la redundancia) es el único que vimos al momento que recorra
          el arbol por niveles. Recorrerá un nivel completo, luego el nivel de los hijos inmediatos de
          los nodos recorridos y así seguirá hasta llegar al nivel (h-1).

    c)  ¿Existe alguna diferencia entre los recorridos preorden, postorden, inorden para recorrer los 
        árboles generales respecto de los árboles binarios? Justifique su respuesta.
        - Tendrán una definición explicitamente diferente, pero podemos relacionarlos de la forma en que
          el hijo izquierdo del AB puede reemplazarse por el hijo mas izquierdo del AG, mientras que el hijo
          derecho en AB puede reemplazarse por un recorrido secuencial entre todos los nodos hijos luego
          del más izquierdo.
          Asi:
            PreOrden:
                AB: R,I,D
                AG: R,MI,Ds
            PostOrden:
                AB: I,D,R
                AG: MI,Ds,R
            InOrden:
                AB: I,R,D
                AG: MI,R,Ds

    d) ¿Existe alguna noción de orden entre los elementos de un árbol general? Justifique su respuesta.
        - Esto siempre dependerá de la forma en la que el árbol esté pensado y construído; en general
          veremos que se ordenan como un arbol, y que la lista de nodos puede estar ordenada bajo el
          mismo criterio, para que el recorrido sea más eficiente sobre ellas.

    e)  En un árbol general se define el grado de un nodo como el número de hijos de ese nodo y el grado 
        del árbol como el máximo de los grados de los nodos del árbol. ¿Qué relación encuentra entre los 
        Árboles Binarios sin tener en cuenta la implementación? Justifique su respuesta.
        - Es el mismo concepto que el de la profundidad, cada nodo tiene su propio valor, y el valor
          que posee el arbol en esta variable es igual al máximo que perciban los nodos para la misma.
    
    */
    public static void main(String[] args) {
        
    }
}
