package p2;

import estructuras.pilasColas.PilaGenerica;

public class TestPilasColas {

    private static String abiertos = "([{";
    private static String cerrados = ")]}";
    private static String aceptados = "{[()]}";
    /*
        Considere un string de caracteres S, el cual comprende únicamente los caracteres: (,),[,],{,}.
        Decimos que S está balanceado si tiene alguna de las siguientes formas:
        S = "" S es el string de longitud cero.
        S = "(T)"
        S = "[T]"
        S = "{T}"
        S = "TU"
        Donde ambos T y U son strings balanceados. Por ejemplo, "{( ) [ ( ) ] }" está balanceado, pero
        "( [ ) ]" no lo está.
    */
        
    /* Ejercicio_4_A
    
        Indique que estructura de datos utilizará para resolver este problema y como la utilizará.
        
        Vamos a usar una pila, el algoritmo va a tener las anotaciones que lo describen, mucho texto

    */
    public static boolean esNormalizado(String s) {
        // Creamos la pila y llamamos al método recursivo

        // Evaluar caracteres validos acá
        if(s.length() % 2 != 0) return false; // Aprovecha el caso con caracteres impares para devolver derecho falso

        PilaGenerica<String> pila = new PilaGenerica<String>();
        return esNormalizado(pila,s);
    }

    private static boolean esNormalizado(PilaGenerica<String> pila, String s){
        /*
            Ejercicio_4_A:
            Implemente una clase llamada tp02.ejercicio4.TestBalanceo (pase por máquina), cuyo
            objetivo es determinar si un String dado está balanceado. El String a verificar es un parámetro
            de entrada (no es un dato predefinido).
        */
        if(! s.equals("")){
            // Caso no vacío
            if(aceptados.contains(String. valueOf(s.charAt(0)))){
                // Caso caracter aceptado
                if(abiertos.contains(String. valueOf(s.charAt(0)))){
                    // Caso es signo abierto
                    pila.apilar(String. valueOf(s.charAt(0)));
                    return esNormalizado(pila,s.substring(1,s.length()));
                }
                else{
                    //Caso es caracter cerrado
                    if(pila.esVacia()){
                        return false;
                    }
                    else{
                        String s0 = pila.desapilar();
                        if(abiertos.indexOf(s0) == cerrados.indexOf(s)){
                            return esNormalizado(pila,s.substring(1,s.length()));
                        }
                        else{
                            return false;
                        }
                    }
                }
            }
            else{
                // Caso en el que contenga algun caracter no permitido
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        esNormalizado("([{}])");
    }

}
