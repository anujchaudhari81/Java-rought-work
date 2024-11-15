import java.util.Scanner;

public class playground {
    public static void main(String[] args) {
    Scanner scan=new Scanner(System.in);
    System.out.print("Enter a string:");
    String str=scan.nextLine();
    System.out.print("reversed string is "+revString(str));
    scan.close();
    }


    public static String revString(String str) {
        if(str.isEmpty()||str.length()==1){
            return str;
        }

        return str.charAt(str.length()-1)+revString(str.substring(0,str.length()-1));

    }
}

