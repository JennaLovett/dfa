import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

/************
 * To compile: javac.exe DFADriver.java
 * To run: java DFADriver
 */
public class DFADriver {
    private static String file;
    private static String str;
    private static String regex;
    private static String s[];


    public static void main(String args[]) throws IllegalArgumentException, ArrayIndexOutOfBoundsException, FileNotFoundException{
        if(args.length < 2) {       //checks if cmd line args are given or not
            System.out.println("Please enter a file name: ");
            Scanner s = new Scanner(System.in);
            file = s.next();
            System.out.println("Please enter a string: ");
            str = s.next();
            s.close();
        } else {        //if args given, save them
            file = args[0];
            str = args[1];
        }

        regex = "[{]|[}]|,|[(]|[)]|[-]|[>]";
        Dfa dfa = new Dfa(str);

        try {
            Scanner scan = new Scanner(new File(file));        //create scanner object to read from file
            s = scan.nextLine().split(regex);

            /*** Getting the alphabet *********/
            for(int i = 0; i < s.length; i++) {
                if(s[i].equals("") || s[i].equals(" ")) {
                    continue;
                } else {
                    dfa.setSigma(s[i]);
                }
            }

            /*** Getting the states *********/
            s = scan.nextLine().split(regex);
            for(int i = 0; i < s.length; i++) {
                if(s[i].equals("") || s[i].equals(" ")) {
                    continue;
                } else {
                    dfa.setState(s[i]);
                }
            }

            /*** Getting Start State **********/
            s = scan.nextLine().split(regex);
            dfa.setStart(s[0]);


            /*** Getting Accept States *********/
            s = scan.nextLine().split(regex);
            for(int i = 0; i < s.length; i++) {
                if(s[i].equals("") || s[i].equals(" ")) {
                    continue;
                } else {
                    dfa.setAcceptState(s[i]);
                }
            }

            /*** Getting Transition Function *********/
            while(scan.hasNextLine()) {
                s = scan.nextLine().split(regex);
                for(int i = 0; i < s.length; i++) {
                    if(s[i].equals("")) {
                        continue;
                    } else {
                        dfa.setTransitions(s[i]);
                    }
                }
            }
            scan.close();
        } catch(FileNotFoundException | ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
            System.exit(0);
        }

        dfa.construct();
    }


}
