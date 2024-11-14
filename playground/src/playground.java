import java.util.Scanner;

public class playground {
    public static void main(String[] args){
        int i=2;
        Scanner scan=new Scanner(System.in);

        while(i>=0){
            System.out.print("Please enter 0 to disconnect");
            i= scan.nextInt();
            System.out.println("You have entered "+i);

        }

    }
}
