/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macroprocessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author universe
 */
public class MacroProcessor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        pass2(pass1());
    }

    public static HashMap pass1() throws FileNotFoundException, IOException {
        BufferedReader in = new BufferedReader(new FileReader("inp.txt"));
        PrintWriter mdtf = new PrintWriter(new File("mdt.txt"));
        PrintWriter mntf = new PrintWriter(new File("mnt.txt"));
        String str, s[], buff = "", name = null;
        HashMap<String, String> mdt = new HashMap(),mnt = new HashMap();
        boolean reading = false;
        while ((str = in.readLine()) != null) {
            s = str.split("\\s+");
            if (s[1].equalsIgnoreCase("macro")) {
                reading = true;
                buff = "";
                name = null;
                continue;
            }
            if (s[1].equalsIgnoreCase("mend")) {
                reading = false;
                mdt.put(name, buff);
                mnt.put(name, Integer.toString(mdt.size()));
                System.out.println(mdt);
            }
            
            if (reading) {
                if (name == null) {
                    name = str.trim();
                    buff ="";
                    buff=in.readLine();
                } else {
                    buff = buff + System.lineSeparator() + str;
                }
            }

            System.out.println(Arrays.asList(s));
        }
        mntf.print(mnt);
        mdtf.print(mdt);
        
        mdtf.close();
        mntf.close();
        in.close();
        
        
        return mdt;
    }

    public static void pass2(HashMap mdt) throws FileNotFoundException, IOException {
        PrintWriter out = new PrintWriter(new File("out.txt"));
        BufferedReader in = new BufferedReader(new FileReader("inp.txt"));
        String str, s[];
        boolean start = false;

        while ((str = in.readLine()) != null) {
            s = str.split("\\s+");

            if (s[1].equalsIgnoreCase("START") && start == false) {
                start = true;
            }
            if (start) {
                if (mdt.containsKey(s[1])) {
                    out.println(mdt.get(s[1]));
                } else {
                    out.println(str);
                }
            }
        }
        in.close();
        out.close();
    }
}
