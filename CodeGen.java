import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by fwarr on 28-Mar-16.
 */
public class CodeGen {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        String in;
        char sym[];
        List regs = new ArrayList<Character>();
        do{
            in=s.next();
            sym=in.toCharArray();
            if(sym[0]=='='){
                for(char i:sym)if(!regs.contains(i) && Character.isAlphabetic(i)){
                    regs.add(i);
                }

                if(regs.contains(sym[2]))
                    System.out.println("MOV r" + regs.indexOf(sym[1]) + ", r" + regs.indexOf(sym[2]));
                else
                    System.out.println("MOV r" + regs.indexOf(sym[1]) + ", " + sym[2]);
            }
            else if(sym[0]=='+'||sym[0]=='-'||sym[0]=='*'||sym[0]=='/'){
                for(char i:sym)if(!regs.contains(i) && Character.isAlphabetic(i)){
                    regs.add(i);
                }

                switch(sym[0]){
                    case '+':
                        if(regs.contains(sym[2]))
                            System.out.println("ADD r" + regs.indexOf(sym[1]) + ", r" + regs.indexOf(sym[2]));
                        else
                            System.out.println("ADD r" + regs.indexOf(sym[1]) + ", " + sym[2]);

                        System.out.println("MOV r" + regs.indexOf(sym[3]) + ", r" + regs.indexOf(sym[1]));
                        break;

                    case '-':
                        if(regs.contains(sym[2]))
                            System.out.println("SUB r" + regs.indexOf(sym[1]) + ", r" + regs.indexOf(sym[2]));
                        else
                            System.out.println("SUB r" + regs.indexOf(sym[1]) + ", " + sym[2]);

                        System.out.println("MOV r" + regs.indexOf(sym[3]) + ", r" + regs.indexOf(sym[1]));
                        break;

                    case '*':
                        if(regs.contains(sym[2]))
                            System.out.println("MUL r" + regs.indexOf(sym[1]) + ", r" + regs.indexOf(sym[2]));
                        else
                            System.out.println("MUL r" + regs.indexOf(sym[1]) + ", " + sym[2]);

                        System.out.println("MOV r" + regs.indexOf(sym[3]) + ", r" + regs.indexOf(sym[1]));
                        break;

                    case '/':
                        if(regs.contains(sym[2]))
                            System.out.println("DIV r" + regs.indexOf(sym[1]) + ", r" + regs.indexOf(sym[2]));
                        else
                            System.out.println("DIV r" + regs.indexOf(sym[1]) + ", " + sym[2]);

                        System.out.println("MOV r" + regs.indexOf(sym[3]) + ", r" + regs.indexOf(sym[1]));
                        break;
                }
            }
        }while(sym.length!=0);
    }
}
/*
=w3e
MOV r0, 3
+w3e
ADD r0, 3
MOV r1, r0
-e7y
SUB r1, 7
MOV r2, r1
/eyw
DIV r1, r2
MOV r0, r1
=ey
MOV r1, r2
 */