package Ungraded;

public class fun {
    public static void main(String[] args) {
        int i=0, suma=0;
        while (i<10){
            for (i=0;i<10;++i){
                suma+=1;
            }
            System.out.println(i);
            i++;
        }
        System.out.println(suma);

        System.out.println(abs(-230));
    }

    static int abs(int n){
        return n*((2*n+1)%2);
    }
}
