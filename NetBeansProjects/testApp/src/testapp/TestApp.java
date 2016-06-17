/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testapp;

import newpackage.*;
import newpackage2.*;
import java.util.*;

/**
 *
 * @author bar
 * see:
 * https://docs.oracle.com/javase/7/docs/api/java/lang/package-summary.html
 * https://docs.oracle.com/javase/7/docs/api/java/util/package-summary.html
 * https://docs.oracle.com/javase/7/docs/api/java/io/package-summary.html
 * 
 * The API DOC:
 * https://docs.oracle.com/javase/7/docs/api/
 * https://docs.oracle.com/javase/8/docs/api/
 * 
 */
public class TestApp {

    /**
     * @param args the command line arguments
     */
    /**
     * TestApp is a `my-first` Java Netbeans project that compiles to a jar and
     * includes a dependant library
     * See: testApp/build.xml on how to include jar files in the build after added via GUI
     * so you end up with a `static` jar.
     * in .bashrc and .bash_profile add jdk to path
     * PATH=$PATH:$HOME/.local/bin:$HOME/bin:/usr/local/jdk1.8.0_91/bin/
     *
     * run like: java -jar testApp.jar w
     * or
     * java -jar Combined-dist.jar ww
     *
     * to create documentation: javadoc -d html TestApp.java
     */
    public static void main(String[] args) {
        System.out.println(newpackage.NewClass.myLib());
        System.out.println(newpackage2.NewClass2.myLib());
        if (args.length == 0) {

            System.out.println("No Command Line arguments");

        } else {

            System.out.println("You provided " + args.length + " arguments");

            for (int i = 0; i < args.length; i++) {
                System.out.println("args[" + i + "]: " + args[i]);
            }
        }

        //Check number of arguments from the command line
        if (args.length != 2) {
            // throw new IllegalArgumentException("2 params nodig!");
        }

        //arrays in java are of limited use, try collections instead
        //This is an example how to iterate through and an associative array with various variable types 
        //hashmap = key-value pair
        Map<String, Float> artikelen = new HashMap<String, Float>();
        artikelen.put("schrijfblok", 1.2f);
        artikelen.put("balpen", 0.8f);
        toonInhoud(artikelen.keySet());
        toonInhoud(artikelen.values());
        printMap(artikelen);

        //change array
        //artikelen.pu("balpen", 0.9f);
        artikelen.put("balpen", 1f);
        printMap(artikelen);

        //treemap does automatically sort, but maybe a bit slow
        /*
        Map<String, String> kantoren = new TreeMap<String, String>();

        kantoren.put("10", "BOEKHOUDING");          // vullen van de Map
        kantoren.put("20", "ONDERZOEK");
        kantoren.put("30", "VERKOOP");
        kantoren.put("40", "PRODUCTIE");

        System.out.println(kantoren);              // toon complete Map
        System.out.println(kantoren.keySet());     // toon alle sleutels
        System.out.println(kantoren.values());     // toon alle waarden
        System.out.println(kantoren.entrySet());   // toon sleutel - waarde paren
        System.out.println(kantoren.get("30"));    // toon waarde bij sleutel "30"
         */
 /*
        //example case statement
        int dagen = 0;
        for (int x = 0; x < args.length; x++) {
            args[x] = args[x].toLowerCase();

            switch (args[x]) {
                case "januari":
                    dagen = dagen + 31;
                    break;
                case "februari":
                    dagen = dagen + 28;
                    break;
                case "maart":
                    dagen = dagen + 31;
                    break;
            }
        }
        System.out.println("Dagen:" + dagen);
         */
         /* 
         == -> is a reference comparison, i.e. both objects point to the same memory location
         .equals() -> evaluates to the comparison of values in the objects
         
          double prijs = Double.parseDouble(args[0]);
	  double aantal = Integer.parseInt(args[1]);
         */
         //try catch to stderr
         try {
            double prijs = Double.parseDouble("aaa");
         }
         catch (Exception e)
         {
            System.err.println("Ehm error handle "+ e);
         }
    }

    public static void printMap(Map mp) {
        Iterator it = mp.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
        }
    }

    public static void toonInhoud(Collection<?> c) {
        Iterator<?> i = c.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}
