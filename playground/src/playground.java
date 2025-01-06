import java.util.Scanner;

public class playground {
    public static void main(String[] args) {

       Scanner scan=new Scanner(System.in);
       System.out.println("Enter a number to divide 10 by: ");

       try {
           int ip = scan.nextInt();
           int result = 10 / ip;
           System.out.println("Your result is " + result);
       }catch(Exception e){
           System.out.println("There was an error "+e.getMessage());
       }finally {
           scan.close();
       }
    }
}

