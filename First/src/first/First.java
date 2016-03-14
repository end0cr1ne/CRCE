/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package first;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author universe
 */
public class First {

    static Map<String, List<String>> prod;

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner in = new Scanner(System.in);
        String str = "", s[];
        List<String> nt, t;
        prod = new HashMap();
        int prods;
        System.out.println("Enter the number productions: ");
        prods = in.nextInt();
        for (int i = 0; i < prods; i++) {
            str = in.next();
            prod.put((str.substring(0, str.indexOf(':'))),
                    Arrays.asList(str
                            .substring(str.indexOf(':') + 1)
                            .split("\\|")));
        }
        for (String key : prod.keySet()) {
            System.out.println(key + ": " + first(prod.get(key)));
        }
    }

    public static List<Character> first(List<String> s) {
        List<Character> first = new ArrayList(), temp;
        int e = 0;
        for (String i : s) {
            for (Character j : i.toCharArray()) {
                if (prod.containsKey("" + j)) {
                    temp = first(prod.get("" + j));
                    if (temp.remove(new Character('e'))) {
                        first.addAll(temp);
                        e++;
                    } else {
                        first.addAll(temp);
                        break;
                    }
                } else {
                    first.add(j);
                    break;
                }
            }
            if (e == i.length()) {
                first.add('e');
                e = 0;
            }
        }
        return first;
    }
}
