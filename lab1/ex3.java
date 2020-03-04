import java.util.Scanner;

public class ex3{
    public static long sum(int n){
        long s=0;
        for(int i=5;i<=n;i+=5)
            if(i%3==0)
                s+=i;
        return s;
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("n= ");
        String nr=scanner.nextLine();
        int n=Integer.parseInt(nr);
        System.out.println(sum(n));
    }
}