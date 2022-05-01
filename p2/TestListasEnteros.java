package p2;
import java.util.Scanner;

import estructuras.ListaDeEnteros;
import estructuras.ListaDeEnterosConArreglos;
import estructuras.ListaDeEnterosEnlazada;

public class TestListasEnteros {

    public static void Ejercicio_1_2(){
        /*
            Escriba una clase llamada TestListaDeEnterosConArreglos que reciba en su método
            main una secuencia de números, los agregue a un objeto de tipo
            ListaDeEnterosConArreglos y luego imprima los elementos de dicha lista.
        */
        Scanner s = new Scanner(System.in) ;
        ListaDeEnterosConArreglos l = new ListaDeEnterosConArreglos();

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

    public static void Ejercicio_1_3(){
        /*
            Escriba una clase llamada TestListaDeEnterosEnlazada que reciba en su método
            main una secuencia de números, los agregue a un objeto de tipo
            ListaDeEnterosEnlazada y luego imprima los elementos de dicha lista.
        */
        Scanner s = new Scanner(System.in) ;
        ListaDeEnterosEnlazada l = new ListaDeEnterosEnlazada();

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

    /*

        Ejercicio_1_4: ¿Qué diferencia encuentra entre las implementaciones de los puntos anteriores?

        - Entre estos dos últimos ejercicios la única diferencia que encontramos es la declaración de la
        lista "l"; el 2 es con arreglos y el 1 de tipo enlazada. Luego se deja todo exactamente igual.      

    */

    public static void imprimirListaInverso(ListaDeEnteros l){
        /*
            Ejercicio_1_5:
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

    public static void imprimirLista(ListaDeEnteros l){
        /*
            Imprimer una lista que puede ser con arreglos o enlazada, como 1_5 pero desde el principio.
        */
        if(! l.fin()){
            int n = l.proximo();
            System.out.println(n);
            imprimirLista(l);
        }
    }

    public static void Ejercicio_1_5(){
        /*
            Ejercicio_1_5:
            Escriba un método recursivo que imprima los elementos de una lista en sentido inverso.
            La lista la recibe por parámetro.
        */
        Scanner s = new Scanner(System.in) ;
        ListaDeEnterosEnlazada l = new ListaDeEnterosEnlazada();

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

    public static ListaDeEnterosEnlazada Ejercicio1_6(int num){
        ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada();
        EvaluarNumeroSucesion(num, lista);
        lista.comenzar();
        System.out.println("\nLista de Enteros de Principio a Fin:\n");
        imprimirLista(lista);
        return lista;
    }

    public static void EvaluarNumeroSucesion(int n,ListaDeEnterosEnlazada l){
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

    /*
        Ejercicio_1_7:
        a_ Si, se les puede dar comportamiento, pero al ser un override lo que tenemos en 
           todas sus implementaxiones en subclases, no sería muy necesario por ahora. La
           clase se define como abstracta ya que describe una "plantilla" para la creación de listas.
        b_ No cambia nada para nosotros, sólo elegimos el método y listo. Las definiciones de los
           se diferencian, pero la lógica del uso es la misma.
        c_ Las listas con arreglos tienen un indice 0..99, pero podemos usar sólo 1..99
    */
    public static void main(String[] args) {
        //Ejercicio_1_2();
        //Ejercicio_1_3();
        //Ejercicio_1_5();
        Ejercicio1_6(2048);
    }
}
