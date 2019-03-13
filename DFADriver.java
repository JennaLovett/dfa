import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

/************
 * To compile: javac.exe DFADriver.java
 * To run: java DFADriver
 */
public class DFADriver {



    public static void main(String args[]) throws IllegalArgumentException, ArrayIndexOutOfBoundsException, FileNotFoundException{
        String f;   //need for file
        String str;     //string to be tested for language inclusion
        if(args.length < 2) {       //checks if cmd line args are given or not
            System.out.println("Please enter a file name: ");
            Scanner s = new Scanner(System.in);
            f = s.next();
            System.out.println("Please enter a string: ");
            str = s.next();
            s.close();
        } else {        //if args given, save them
            f = args[0];
            str = args[1];
        }

        //boolean isAccepted = false;     //need

        /*String start = "";      //holds q0
        ArrayList<String> transition = new ArrayList<String>();     //holds transition input
        ArrayList<String> states = new ArrayList<String>();         //holds states input
        ArrayList<String> alphabet = new ArrayList<String>();       //holds alphabet (Sigma) input
        ArrayList<String> acceptStates = new ArrayList<String>();   //holds acceptStates*/
        String regex = "[{]|[}]|,|[(]|[)]|[-]|[>]";     //stays in main method
        Dfa dfa = new Dfa(str);
        try {
            Scanner scan = new Scanner(new File(f));        //create scanner object to read from file
            String s[] = scan.nextLine().split(regex);  //stays in main method

            /*** Getting the alphabet *********/
            for(int i = 0; i < s.length; i++) {
                if(s[i].equals("") || s[i].equals(" ")) {
                    continue;
                } else {
                    //alphabet.add(s[i]);
                    dfa.setSigma(s[i]);
                }
            }
            System.out.println();

            /*** Getting the states *********/
            s = scan.nextLine().split(regex);
            for(int i = 0; i < s.length; i++) {
                if(s[i].equals("") || s[i].equals(" ")) {
                    continue;
                } else {
                    //states.add(s[i]);
                    dfa.setState(s[i]);
                }
            }
            System.out.println();

            /*** Getting Start State **********/
            s = scan.nextLine().split(regex);
            //start = s[0];
            dfa.setStart(s[0]);


            /*** Getting Accept States *********/
            s = scan.nextLine().split(regex);
            for(int i = 0; i < s.length; i++) {
                if(s[i].equals("") || s[i].equals(" ")) {
                    continue;
                } else {
                    //acceptStates.add(s[i]);
                    dfa.setAcceptState(s[i]);
                }

            }
            System.out.println();

            /*** Getting Transition Function *********/
            //add vertices from states array
            //add edges from every triplet within transition array
            //vertex boolean isEndState and isStartState
            while(scan.hasNextLine()) {
                s = scan.nextLine().split(regex);
                for(int i = 0; i < s.length; i++) {
                    if(s[i].equals("")) {
                        continue;
                    } else {
                        //transition.add(s[i]);
                        dfa.setTransitions(s[i]);
                    }
                }
            }
            scan.close();
        } catch(FileNotFoundException | ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
            System.out.println("File name not given. Please enter " +
                    "the file name now.");
            f = args[0];
        }

        /*//map states to number -- rows
        HashMap<String, Integer> mappedStates = new HashMap<String, Integer>();
        for(int i = 0; i < states.size(); i++) {
            mappedStates.put(states.get(i), i);
        }

        //map alphabet to number -- cols
        HashMap<String, Integer> mappedAlphabet = new HashMap<String, Integer>();
        for(int i = 0; i < alphabet.size(); i++) {
            mappedAlphabet.put(alphabet.get(i), i);
        }

        //create a default transition matrix
        String transitionMatrix[][] = new String[states.size()][alphabet.size()];
        int count = 0;
        String begin, end, z;
        for(int row = 0; row < transitionMatrix.length; row++) {
            for(int col = 0; col < transitionMatrix[row].length; col++) {
                transitionMatrix[row][col] = "empty";
            }
        }
        //use the mapped values to create transition table
        for(int row = 0; row < transitionMatrix.length; row++) {
            for(int col = 0; col < transitionMatrix[row].length; col++) {
                //get first transition
                begin = transition.get(count);
                z = transition.get(count + 1);
                end = transition.get(count + 2);
                count+=3;
                //System.out.println(begin + " " + z + " " + end);
                transitionMatrix[mappedStates.get(begin)][mappedAlphabet.get(z)] = end;
            }
        }

        String currentState = start;
        String alpha = "";
        int x, y;
        System.out.print(currentState);
        for(int i = 0; i < str.length(); i++) {
            alpha = str.substring(i, i+1);
            x = mappedStates.get(currentState);
            y = mappedAlphabet.get(alpha);
            currentState = transitionMatrix[x][y];
            System.out.print(" ---" + alpha + "---> " + currentState);
        }
        System.out.println();
        if(acceptStates.contains(currentState)) {
            isAccepted = true;
        }

        System.out.println("Is the string " + str + " accepted? " + isAccepted); */
        dfa.mapStates();
        dfa.mapAlphabet();
        dfa.createTransitionMatrix();
        dfa.createDFA();
        dfa.checkString();

    }


}
