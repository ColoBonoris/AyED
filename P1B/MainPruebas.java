package P1B;

import java.util.Scanner;

public class MainPruebas {
    public static void main(String[] args){
        generadorVectores generador = new generadorVectores();
        Scanner s = new Scanner(System.in) ;
        System.out.print("Ingrese la cantidad de pruebas que quiere hacer: ");
        int i,n,k = s.nextInt();
        int[] v1;
        for(i=1;i<=k;i++){
            System.out.print("Ingrese el indice del vector " + i + ": ");
            n = s.nextInt();
            v1 = generador.generarVectorMultiplos(n);
            generador.imprimirVector(v1);
        }
        System.out.println("Au revoir");

        s.close();
    }
}

