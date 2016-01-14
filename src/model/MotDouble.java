package model;

/**
 *
 * @author 0404ragrau
 */
public class MotDouble extends Case {
    
    private static final String MOTDOUBLE = "\u001b[45m"; 
    private static final String RESET = "\u001B[0m";
    
    
    public MotDouble() {
        getChar();
    }
   
    @Override
    public String toString() {
        return MOTDOUBLE + " " + getChar() + " " + RESET;
    }
    
}
