import java.util.Scanner;

/**
 * Created by fwarr on 28-Mar-16.
 */
/*
* S->AB
* A->aA|b
* B->bB|a
*
* Test Cases
* aaabbbbba
* Accepted
*
* aaa
* Rejected
*/
public class RDP {
    static int i=0;
    static String in;
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        in = s.next();
        A();
        B();
        System.out.println("Accepted");
    }
    public static void A(){
        if(i>=in.length()){
            System.err.println("Rejected");
            System.exit(1);
        }

        if(in.charAt(i)=='a'){
            i++;
            A();
        }else if(in.charAt(i)=='b')i++;
        else {
            System.err.println("Rejected");
            System.exit(1);
        }
    }
    public static void B(){
        if(i>=in.length()){
            System.err.println("Rejected");
            System.exit(1);
        }

        if(in.charAt(i)=='b'){
            i++;
            B();
        }else if(in.charAt(i)=='a')i++;
        else {
            System.err.println("Rejected");
            System.exit(1);
        }
    }
}
