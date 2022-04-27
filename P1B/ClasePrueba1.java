package P1B;

public class ClasePrueba1 {
    public static void entreMedioFor(int a, int b){
        int i;
        for(i=a;i<=b;i++){
            System.out.println(i);
        }
    }

    public static void entreMedioWhile(int a, int b){
        int i = a;
        while(i<=b){
            System.out.println(i);
            i ++;
        }
    }

    public static void entreMedioRecursivo(int a, int b){
        if(a <= b){
            System.out.println(a);
            a++;
            entreMedioRecursivo(a,b);
        }
    }
}
