import java.util.ArrayList;
import java.util.HashMap;

public class Dfa {

    private ArrayList<String> alphabet;
    private ArrayList<String> states;
    private ArrayList<String> acceptStates;
    private ArrayList<String> transitions;
    HashMap<String, Integer> mappedStates;
    HashMap<String, Integer> mappedAlphabet;
    String transitionMatrix[][];
    private String q0;
    private String currentState;
    private boolean isAccepted;
    private String str;


    public Dfa(String str) {
        alphabet = new ArrayList<>();
        states = new ArrayList<>();
        acceptStates = new ArrayList<>();
        transitions = new ArrayList<>();
        mappedStates = new HashMap<>();
        mappedAlphabet = new HashMap<>();
        transitionMatrix = new String[states.size()][alphabet.size()];
        setDefaultTransitionMatrix();
        isAccepted = false;
        this.str = str;

    }

    public void setSigma(String a) {
        alphabet.add(a);
    }

    public void setState(String q) {
        states.add(q);
    }

    public void setAcceptState(String f) {
        acceptStates.add(f);
    }

    public void setStart(String q0) {
        this.q0 = q0;
    }

    public void setTransitions(String s) {
        transitions.add(s);
    }

    public void mapStates() {
        for(int i = 0; i < states.size(); i++) {
            mappedStates.put(states.get(i), i);
        }
    }

    public void mapAlphabet() {
        for(int i = 0; i < alphabet.size(); i++) {
            mappedAlphabet.put(alphabet.get(i), i);
        }
    }

    public void setDefaultTransitionMatrix() {
        for(int row = 0; row < transitionMatrix.length; row++) {
            for(int col = 0; col < transitionMatrix[row].length; col++) {
                transitionMatrix[row][col] = "empty";
            }
        }
    }

    public void createTransitionMatrix() {
        String begin, z, end;
        int count = 0;
        for(int row = 0; row < transitionMatrix.length; row++) {
            for(int col = 0; col < transitionMatrix[row].length; col++) {
                begin = transitions.get(count);
                z = transitions.get(count + 1);
                end = transitions.get(count + 2);
                count+=3;
                transitionMatrix[mappedStates.get(begin)][mappedAlphabet.get(z)] = end;
            }
        }
    }

    public void createDFA() {
        currentState = q0;
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
    }

    public void checkString() {
        if(acceptStates.contains(currentState)) {
            isAccepted = true;
        } else {
            isAccepted = false;
        }
    }

    public void isInLanguage() {
        if(isAccepted) {
            System.out.println("The string " + str + " is in the Language.");
        } else {
            System.out.println("The string " + str + " is not in the Language.");
        }
    }

}
