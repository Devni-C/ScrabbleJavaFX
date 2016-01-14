package model;

/**
 *
 * @author 0404ragrau
 */
public class Triple extends Case {
    
    private static final String TRIPLE = "\u001b[44m"; 
    private static final String RESET = "\u001B[0m";

    
    public Triple() {
        getChar();
    }

    @Override
    public String toString() {
        return TRIPLE + " " + getChar() + " " + RESET;
    }

    
}
