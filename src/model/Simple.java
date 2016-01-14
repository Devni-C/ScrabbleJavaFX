package model;

/**
 *
 * @author 0404ragrau
 */
public class Simple extends Case {

    private static final String SIMPLE = "\u001b[40m";
    private static final String RESET = "\u001B[0m";
    
    
    public Simple() {
        getChar();
    }
       
    @Override
    public String toString() {
        return SIMPLE + " " + getChar() + " " + RESET;
    }

    
}
