import java.util.Scanner;

public class ex6{
    public static int fibo(int n){
        int a=1,b=1,sum=0;
        for(int i=2;i<n;i++){
            sum=a+b;
            a=b;
            b=sum;
        }
        return sum;
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("n= ");
        String nr=scanner.nextLine();
        int n=Integer.parseInt(nr);
        System.out.println(fibo(n));
    }
}