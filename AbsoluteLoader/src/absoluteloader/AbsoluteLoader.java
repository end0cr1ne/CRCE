/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package absoluteloader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author universe
 */
public class AbsoluteLoader {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader in = new BufferedReader(new FileReader("inp.txt"));
        String str,s[];
        int plen=0,ps=0;
        while ((str = in.readLine()) != null) {
            s = str.split("\\s+");
            
            if(s[0].equalsIgnoreCase("T")){
                int len = 2*Integer.parseInt(s[2], 16),tlen=0,ctr=0,st= Integer.parseInt(s[1], 16);
                
                if(ps != 0)
                while(plen<(st-ps))
                {
                    System.out.print("x");
                    ctr++;
                    tlen++;
                    if(ctr>=6){
                        System.out.print(" ");
                        ctr=0;
                    }
                }
                
                System.out.print("\n"+s[1]+" ");
                for(int i=3;i<s.length;i++)
                {
                    tlen+=s[i].length();
                    ctr+=s[i].length();
                    if(ctr>=6){
                        ctr=0;
                    }
                    if(tlen<=len)System.out.print(s[i]+" ");
                }
              plen =len;
              ps=st;
            }
        }
    }
    
}
