package P1B;


/*
    2. Escriba un método de clase que dado un número n devuelva un nuevo arreglo de
    tamaño n con los n primeros múltiplos enteros de n mayores o iguales que 1.
    Ejemplo: f(5) = [5; 10; 15; 20; 25]; f(k) = {nk/k : 1..k}
    Agregue al programa la posibilidad de probar con distintos valores de n
    ingresándolos por teclado, mediante el uso de System.in. La clase Scanner permite
    leer de forma sencilla valores de entrada.

    5. Dado un arreglo de valores tipo int se desea calcular el valor máximo, mínimo, y
    promedio en un único método. Escriba tres métodos de clase, donde respectivamente:
    a. Devuelva lo pedido por el mecanismo de retorno de un método en Java
    ("return").
    b. Devuelva lo pedido interactuando con algún parámetro (el parámetro no puede
    ser de tipo arreglo).
    c. Devuelva lo pedido sin usar parámetros ni la sentencia "return".

*/

public class generadorVectores {

    //------------------------------------------------ P1BE1
    public static int[] generarVectorMultiplos(int n){
        int i;
        int[] v = new int[n];
        for(i=1;i<=n;i++){
            v[i-1] = n * i;
        }
        return v;
    }
    //------------------------------------------------
    public static void imprimirVector(int[] v){
        for (int i = 0; i < v.length; i++) {
            System.out.println(v[i]);
        }
    }
    //------------------------------------------------ P1BE5
    private static int minVector(int[] v){
        int min = 999999;
        if(v != null){
            min = v[0];
            for (int i = 1; i < v.length; i++) {
                if(v[i] < min){
                    min = v[i];
                }
            }
        }
        return min;
    }
    private static int maxVector(int[] v){
        int max = -999999;
        if(v != null){
            max = v[0];
            for (int i = 1; i < v.length; i++) {
                if(v[i] > max){
                    max = v[i];
                }
            }
        }
        return max;
    }

    public static int promVector(int[] v){
        int prom = 0;
        if(v != null){
            prom = v[0];
            for (int i = 1; i < v.length; i++) {
                prom = prom + v[i];
            }
            prom = prom / v.length;
        }
        return prom;
    }
    //------------------------------------------------
    public static int[] minPromMax(int[] v){
        int[] v1 = new int[3];
        v1[0] = minVector(v);
        v1[1] = maxVector(v);
        v1[2] = promVector(v);
        return v1;
    }
    public static void minPromMax(int[] v, Integer min, Integer max, Integer prom){
        min = minVector(v);
        max = maxVector(v);
        prom = promVector(v);
    }
    public static void minPromMax(){
        // No sé cómo podría hacer esta otra, con variables globales? No creo que sea tan nasty
    }
    //------------------------------------------------
}
