package model;

/**
 *
 * @author 0404ragrau
 */
public class MotTriple extends Case {
    
    private static final String MOTTRIPLE = "\u001b[41m";
    private static final String RESET = "\u001B[0m";
    
    
    public MotTriple() {
        getChar();
    }
   
    @Override
    public String toString() {
        return MOTTRIPLE + " " + getChar() + " " + RESET;
    }
    
}
