# DFA Final Project
## Theoretical Foundations - Spring 2019
### Author: Jenna Lovett
#### Language: Java

![alt text](https://github.com/JennaLovett/dfa/blob/master/dfa.jpg "DFA Image")

* The main program is located in DFADriver.java. This is the execution point of the program.
* The main program also houses the code that takes care of user input.
* The bulk of the computation takes place in Dfa.java.
* Dfa.java has multiple methods, all of which are commented for code readability.
* The main method holds a Dfa object, which will have one method called on it, construct()
* construct() is a method in Dfa.java that holds all other necessary functions
* All inputs are treated as strings throughout the program


### Details of Dfa.java methods
* setSigma(String a): adds a to the alphabet
* setState(String q): adds a state q to the states
* setAcceptState(String f): adds an accept state/final state to acceptStates
* setStart(String q0): sets the start state of the DFA
* setTransitions(String s): adds the transitions
* mapStates() and mapAlphabet(): both use unique hashmaps to map individual states and letters to corresponding ints which will correspond to rows and columns when constructing the transition matrix
* setDefaultTransitionMatrix(): sets each element in the transition matrix to "empty"
* createTransitionMatrix(): creates the transition matrix using mappedStates and mappedAlphabet
* createDFA(): iterates over the input string and finds the states for each part of the input, while also printing out a visual aid of the machine
* checkString(): checks if the string is in the language or not
* isInLanguage(): prints to the stdout if the string is in the language
* construct(): calls all necessary methods on a Dfa object

### Program Execution
1. Download repository
2. Open command prompt
3. cd into directory
4. type "javac.exe Dfa.java DFADriver.java" into cmd
5. type "java DFADriver test3.txt 00100"
6. type "java DFADriver test3.txt 11010"

Usage is java DFADriver "<filename>" "<test string>"