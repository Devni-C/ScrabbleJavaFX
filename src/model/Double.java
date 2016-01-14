package model;

/**
 *
 * @author 0404ragrau
 */
public class Double extends Case {

    private static final String DOUBLE = "\u001b[46m"; 
    private static final String RESET = "\u001B[0m";
    
    
    public Double() {
        getChar();
    }
    
    @Override
    public String toString() {
        return DOUBLE + " " + getChar() + " " + RESET;
    }

    
}
