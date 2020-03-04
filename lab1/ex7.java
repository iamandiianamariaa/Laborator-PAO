import java.util.Scanner;

public class ex7{
    public static int fact_prim(int n){
        int d=2;
        while(n!=1){
            while(n%d==0){
            n/=d;
        }
            d++;
        }
        return d-1;
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("n= ");
        String nr=scanner.nextLine();
        int n=Integer.parseInt(nr);
        System.out.println(fact_prim(n));
    }
}