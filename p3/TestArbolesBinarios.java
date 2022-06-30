package p3;
import estructuras.listas.ListaEnlazadaGenerica;

public class TestArbolesBinarios {
    public static void Ejercicio_3(){
        /*
            Defina una clase Java denominada ContadorArbol cuya función principal es proveer métodos de
            validación sobre árboles binarios de enteros. Para ello la clase tiene como variable de instancia un
            ArbolBinario<Integer>. Implemente en dicha clase un método denominado numerosPares() que
            devuelve en una estructura adecuada (sin ningún criterio de orden) todos los elementos pares del
            árbol (divisibles por 2). Defina la clase dentro del paquete tp03.ejercicio3

                a) Implemente el método realizando un recorrido InOrden.
                b) Implemente el método realizando un recorrido PostOrden.
        */
        ContadorArbol contador = new ContadorArbol();
        for (int i = 0; i < 15; i++) {
            contador.agregarNumArbol(i);
        }
        ListaEnlazadaGenerica<Integer> pares = contador.numerosPares();
        for (int i = 0; i < pares.tamanio(); i++) {
            System.out.println(pares.elemento(i));
        }
    }

    public static void Ejercicio_4(){
        /*
            Una red binaria es una red que posee una topología de árbol binario lleno. Por ejemplo:
            Los nodos que conforman una red binaria llena tiene la particularidad de que todos ellos conocen
            cuál es su retardo de reenvío. El retardo de reenvío se define como el período comprendido entre
            que un nodo recibe un mensaje y lo reenvía a sus dos hijos.

            Su tarea es calcular el mayor retardo posible, en el camino que realiza un mensaje desde la raíz
            hasta llegar a las hojas en una red binaria llena.

                Nota: asuma que cada nodo tiene el dato de retardo de reenvío expresado en cantidad de segundos.

            a) Indique qué estrategia (recorrido en profundidad o por niveles) utilizará para resolver el
                problema.
            b) Cree una clase Java llamada RedBinariaLlena (dentro del paquete tp03.ejercicio4)
                donde implementará lo solicitado en el método retardoReenvio():int
        */
        /* a_ Vamos a recorrer el camino hasta cada hoja, sumando el total de retardo. Cuando llegamos a una hoja
                agregamos el resultado a una lista de Integer. Luego calculamos un máximo en esa lista y ese será
                el retardo máximo en el envío de un mensaje en una red binaria.
        */
        // b_
        RedBinariaLlena red = new RedBinariaLlena();
        // se debería llenar antes
        System.out.println(red.retardoReenvio());
    } 

    public static void main(String[] args) {
        Ejercicio_3();
        Ejercicio_4();
    }  
}
