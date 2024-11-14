import java.util.Scanner;


public class VandC {
    public static void main(String[] args){

        String c,s,k="Y";
        int i,j;
        Scanner scan=new Scanner(System.in);


        do{
            System.out.print("Enter First number: ");
            i = scan.nextInt();
            System.out.print("Enter Second number: ");
            j= scan.nextInt();
            scan.nextLine();
            System.out.print("Enter Operator(+,-,*,/): ");
            s=scan.nextLine();


            if (s.equalsIgnoreCase("-")) {
                System.out.println("The Subtraction is "+(i-j));
            }else if(s.equalsIgnoreCase("+")) {
                System.out.println("The addition is "+(i+j));
            } else if (s.equalsIgnoreCase("*")) {
                System.out.println("The multiplication is "+(i*j));
            }else if(s.equalsIgnoreCase("/")) {
                System.out.println("The division is "+(i/j));
            } else {
                System.out.println("you might have entered a wrong input");
            }

            System.out.print("Do you want to perform any other operation(Y/N): ");
            c=scan.nextLine();
        }while(c.equalsIgnoreCase(k));


        scan.close();
    }
}
