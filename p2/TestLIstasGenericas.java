package p2;

import java.util.Scanner;

import estructuras.ListaEnlazadaGenerica;

public class TestLIstasGenericas {
    public static void Ejercicio_2_1_2(){
        /*
            Escriba una clase llamada TestListaEnlazadaGenerica<Integer> que reciba en su método
            main una secuencia de números, los agregue a un objeto de tipo
            ListaEnlazadaGenerica<Integer> y luego imprima los elementos de dicha lista.
        */
        Scanner s = new Scanner(System.in) ;
        ListaEnlazadaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();

        System.out.println("- Se leeran numeros hasta que ingrese -1000: \n");
        System.out.print("Ingrese un número: ");
        Integer n = s.nextInt();
        while(n != -1000){
            l.agregarFinal(n);
            System.out.print("Ingrese un número: ");
            n = s.nextInt();
        }

        System.out.println("\n - Se imprimiran los numeros en el orden ingresado: \n");

        l.comenzar();
        while(! l.fin()){
            System.out.println(l.proximo());
        }
        s.close();
    }

    public static void Ejercicio_2_1_3(){
        /*
            Escriba una clase llamada TestListaEnlazadaGenerica<Integer> que reciba en su método
            main una secuencia de números, los agregue a un objeto de tipo
            ListaEnlazadaGenerica<Integer> y luego imprima los elementos de dicha lista.
        */
        Scanner s = new Scanner(System.in) ;
        ListaEnlazadaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();

        System.out.println("- Se leeran numeros hasta que ingrese -1000: \n");
        System.out.print("Ingrese un número: ");
        Integer n = s.nextInt();
        while(n != -1000){
            l.agregarFinal(n);
            System.out.print("Ingrese un número: ");
            n = s.nextInt();
        }

        System.out.println("\n - Se imprimiran los numeros en el orden ingresado: \n");

        l.comenzar();
        while(! l.fin()){
            System.out.println(l.proximo());
        }

        s.close();
    }


    public static void imprimirListaInverso(ListaEnlazadaGenerica<Integer> l){
        /*
            Ejercicio_2_1_5:
            Escriba un método recursivo que imprima los elementos de una lista en sentido inverso.
            La lista la recibe por parámetro.
        */
        // Puede ser con arreglos o enlazada.
        if(! l.fin()){
            int n = l.proximo();
            imprimirListaInverso(l);
            System.out.println(n);
        }
        else{
            System.out.println("\nLista de Enteros de Fin a Principio:\n");
        }
    }

    public static void imprimirLista(ListaEnlazadaGenerica<Integer> l){
        /*
            Imprimer una lista que puede ser con arreglos o enlazada, como 2_1_5 pero desde el principio.
        */
        if(! l.fin()){
            int n = l.proximo();
            System.out.println(n);
            imprimirLista(l);
        }
    }

    public static void Ejercicio_2_1_5(){
        /*
            Ejercicio_2_1_5:
            Escriba un método recursivo que imprima los elementos de una lista en sentido inverso.
            La lista la recibe por parámetro.
        */
        Scanner s = new Scanner(System.in) ;
        ListaEnlazadaGenerica<Integer> l = new ListaEnlazadaGenerica<Integer>();

        System.out.println("- Se leeran numeros hasta que ingrese -1000: \n");
        System.out.print("Ingrese un número: ");
        Integer n = s.nextInt();
        while(n != -1000){
            l.agregarFinal(n);
            System.out.print("Ingrese un número: ");
            n = s.nextInt();
        }

        l.comenzar();
        imprimirListaInverso(l);

        s.close();
    }

    public static ListaEnlazadaGenerica<Integer> Ejercicio_2_1_6(int num){
        ListaEnlazadaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
        EvaluarNumeroSucesion(num, lista);
        lista.comenzar();
        System.out.println("\nLista de Enteros de Principio a Fin:\n");
        imprimirLista(lista);
        return lista;
    }

    public static void EvaluarNumeroSucesion(int n,ListaEnlazadaGenerica<Integer> l){
        l.agregarFinal(n);
        if(n != 1){
            if((n % 2) == 0){
                EvaluarNumeroSucesion(n/2,l);
            }
            else{
                EvaluarNumeroSucesion((3*n) + 1,l);
            }
        }
    }

    public static void imprimirListaAlumnos(ListaEnlazadaGenerica<Alumno> l){
        /*
            Imprimer una lista que puede ser con arreglos o enlazada, como 2_1_5 pero desde el principio.
        */
        Alumno a;
        if(! l.fin()){
            a = l.proximo();
            System.out.println(a.tusDatos());
            imprimirListaAlumnos(l);
        }
    }

    public static void Ejercicio_2_2(){
        /*
            Escriba una clase llamada TestListaEnlazadaGenerica que cree 4 objetos de tipo
            Estudiante (implementado en el TP01B) y los agregue a un objeto de tipo
            ListaEnlazadaGenerica usando los diferentes métodos de la lista y luego, imprima los
            elementos de dicha lista usando el método tusDatos().
        */
        ListaEnlazadaGenerica<Alumno> listaAlumnos = new ListaEnlazadaGenerica<Alumno>();
        Alumno a;
        for (int i = 0; i < 4; i++) {
            a = new Alumno("Nicolas " + i,
            "Bonoris " + i,
            "fakemail@gmail.com " + i,
            "Informatica " + i,
            "Prueba Comision " + i,
            "Calle Falsa 123 " + i
            );
            listaAlumnos.agregarFinal(a);
        }
        listaAlumnos.comenzar();
        imprimirListaAlumnos(listaAlumnos);
    } 
    /*

        Analice las implementaciones de la clase ListaGenerica<T> y sus subclases, luego
        responda:
            a)  ¿Qué diferencia observa entre las implementaciones de ListaEnlazadaGenerica y
                ListaDeEnterosEnlazada?
                - Sólo la declaración y referencias a tipos
            b)  ¿Cómo se define el nodo genérico? ¿Cómo se crea una instancia del mismo?
                - Se define en NodoGenerico.java, se instancia como:
                    NodoGenerico<Tipo> n = new NodoGenerico<Tipo>()
            c)  ¿Qué devuelve el método elemento() de la lista?
                - Devuelve el dato en la posición enviada, de tipo <Tipo>
            d)  ¿Cómo agregaría un método nuevo? Implemente un nuevo método de la lista que se
                llame agregar(T[]):boolean. El mismo debe agregar todos los elementos del arreglo
                que recibe como parámetro y retornar true si todos ellos fueron agregados.
                - Listorti

    */
    public static void main(String[] args) {
        //Ejercicio_2_1_2();
        //Ejercicio_2_1_3();
        //Ejercicio_2_1_5();
        Ejercicio_2_1_6(6);
    }
}
