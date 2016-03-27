import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by fwarr on 27-Mar-16.
 */
public class LexicalAnalyzer {
    public static void main(String args[]) throws FileNotFoundException {
        Scanner s = new Scanner(new File("conf.txt"));
        Scanner in = new Scanner(new File("inp.txt"));
        String sym;
        List ops= new ArrayList<String>(), keys= new ArrayList<String>();
        while(s.hasNext()){
            sym=s.next();
            if(sym.equalsIgnoreCase("operators")){
               ops.addAll(Arrays.asList(s.nextLine().split("\\s+")));
            }
            else if(sym.equalsIgnoreCase("keywords")){
                keys.addAll(Arrays.asList(s.nextLine().split("\\s+")));
            }
        }

        int k=0,o=0,i=0;
        while(in.hasNext()){
            sym = in.next();
            if(ops.contains(sym))o++;
            else if(keys.contains(sym))k++;
            else if(sym.matches("-?\\d+(\\.\\d+)?"));
            else i++;
        }
        System.out.println(ops + "\n" + keys + "\nKeywords: "+k+"\nOperators: "+o+"\nIdentifiers: "+i);
    }
}
