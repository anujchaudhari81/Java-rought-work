import java.util.Scanner;

public class fibonacci {
    public static void main(String[] args){

        int k=0,l=1;
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter number: ");
        int ip=scan.nextInt();

        if(ip == 1){
            System.out.println(k);
        }else{
            System.out.print(k+" "+l);
        }

        for(int i=3; i<= ip;i++){
            int p=k+l;
            System.out.print(" "+p);
            k=l;
            l=p;
        }




    }
}
