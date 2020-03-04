import java.util.Scanner;

public class ex4{
    public static long fact(int n){
        long p=1;
        for(int i=2;i<=n;i++)
            p*=i;
        return p;
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("n= ");
        String nr=scanner.nextLine();
        int n=Integer.parseInt(nr);
        System.out.println(fact(n));
    }
}