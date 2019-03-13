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
        setDefaultTransitionMatrix(transitionMatrix);
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

    public void setDefaultTransitionMatrix(String t[][]) {
        for(int row = 0; row < t.length; row++) {
            for(int col = 0; col < t[row].length; col++) {
                t[row][col] = "empty";
            }
        }
    }
}
