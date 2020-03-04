import java.util.Scanner;

public class ex5{
    public static boolean prim(int n){
        if(n<=1) return false;
        if(n==2) return true;
        if(n%2==0) return false;
        for(int i=3;i*i<=n;i+=2){
            if(n%i==0) return false;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("n= ");
        String nr=scanner.nextLine();
        int n=Integer.parseInt(nr);
        System.out.println(prim(n));
    }
}