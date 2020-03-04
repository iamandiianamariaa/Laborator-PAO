import java.util.Scanner;

public class ex2{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("First number:");
        String nr1=scanner.nextLine();
        System.out.println("Second number:");
        String nr2=scanner.nextLine();
        int x=Integer.parseInt(nr1);
        int y=Integer.parseInt(nr2);
        if(x==y) 
            System.out.println(x+"=="+y);
        else if(x!=y){
            System.out.println(x+"!="+y);
            if(x<y)
                System.out.println(x+"<"+y);
            else
                System.out.println(x+">"+y);
        }
     
    }
}