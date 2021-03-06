package model;

import java.awt.Point;
import java.util.HashSet;
import java.util.Observable;
import java.util.Set;

/**
 *
 * @author 0404ragrau
 */
public class Grille extends Observable {
    
    private final Case[][] grille;
    public static final int DIM = 15;

    private static final Set<Point> simples = new HashSet<>();
    private static final Set<Point> doubles = new HashSet<>();
    private static final Set<Point> triples = new HashSet<>();
    private static final Set<Point> motsDoubles = new HashSet<>();
    private static final Set<Point> motsTriples = new HashSet<>();
    
    
    public Grille() {
        this.grille = new Case[DIM][DIM];
        initGrille();
    }

    public Case getCase(Point pt) {
        return this.grille[pt.x][pt.y];
    }
    public Case getCase(int x, int y) {
        return this.grille[x][y];
    }
    
    
    public String getCaseType(Jeton j) {
        Point pt = new Point(j.getX(), j.getY());
        
        if (motsTriples.contains(pt))
            return "motTriple";
        else if(motsDoubles.contains(pt))
            return "motDouble";
        else if (triples.contains(pt))
            return "triple";
        else if (doubles.contains(pt))
            return "double";
        else
            return "simple";
    }
  
//    public void setCase(int x, int y, char lettre) {
//        this.grille[x][y].setLettre(lettre);   
//    }
    
    public void setCase(int x, int y, Jeton j) {
        this.grille[x][y].setJeton(j);
    }
    
    public char getLettreAt(int x, int y) {
        return getCase(x,y).getChar();
    }
    
    public boolean caseJouee(int x, int y) {
        return !(getLettreAt(x,y) == ' ');
    }
    
    public boolean isEmpty() {
        return (getLettreAt(7,7) == ' ');
    }
    
    public boolean jAtCenter(int x, int y) {
        return x == DIM/2 && y == DIM/2;

    }
    
    public Jeton getJetonAt(int x, int y) {
        return getCase(x,y).getJeton();
    }
    
    public int getLastXLeft(Jeton j) {
        int posX = j.getX();
        int posY = j.getY();
        
        while (caseJouee(posX-1,posY))
            posX--;
        
        return posX;
    }
    
    public int getLastYUp(Jeton j) {
        int posX = j.getX();
        int posY = j.getY();
        
        while (caseJouee(posX,posY-1))
            posY--;
        
        return posY;
    }
    
    public int getLastXRight(Jeton j) {
        int posX = j.getX();
        int posY = j.getY();
        
        while (caseJouee(posX+1,posY))
            posX++;
        
        return posX;
    }
    
    public int getLastYDown(Jeton j) {
        int posX = j.getX();
        int posY = j.getY();
        
        while (caseJouee(posX,posY+1))
            posY++;
        
        return posY;
    }
    
    
    public boolean watchUp(Jeton j) {
        if (j.getY() == 0)
            return false;
        return caseJouee(j.getX(), j.getY() - 1);
    }

    public boolean watchRight(Jeton j) {
        if (j.getX() == DIM-1)
            return false;
        return caseJouee(j.getX() + 1, j.getY());
    }

    public boolean watchDown(Jeton j) {
        if (j.getY() == DIM-1)
            return false;
        return caseJouee(j.getX(), j.getY() + 1);
    }

    public boolean watchLeft(Jeton j) {
        if (j.getX() == 0)
            return false;
        return caseJouee(j.getX() - 1, j.getY());
    }

    public boolean watchAround(Jeton j) {
        return watchUp(j) || watchRight(j) || watchDown(j) || watchLeft(j);
    }
    
   
    public void notif() {
        setChanged();
        notifyObservers();
    }
    
    private void initGrille() {
                
        doubles.add(new Point(0, 3));
        doubles.add(new Point(0, DIM-4));
        doubles.add(new Point(2, 6));
        doubles.add(new Point(2, DIM-7));
        
        doubles.add(new Point(3, 0));
        doubles.add(new Point(3, 7));
        doubles.add(new Point(3, DIM-1));
        
        doubles.add(new Point(6, 2));
        doubles.add(new Point(6, 6));
        doubles.add(new Point(6, DIM-7));
        doubles.add(new Point(6, DIM-3));
        
        doubles.add(new Point(7, 3));
        doubles.add(new Point(7, DIM-4));
        
        doubles.add(new Point(DIM-7, 2));
        doubles.add(new Point(DIM-7, 6));
        doubles.add(new Point(DIM-7, DIM-7));
        doubles.add(new Point(DIM-7, DIM-3));
        
        doubles.add(new Point(DIM-4, 0));
        doubles.add(new Point(DIM-4, 7));
        doubles.add(new Point(DIM-4, DIM-1));
        
        doubles.add(new Point(DIM-3, 6));
        doubles.add(new Point(DIM-3, DIM-7));
        doubles.add(new Point(DIM-1, 3));
        doubles.add(new Point(DIM-1, DIM-4));
        
        triples.add(new Point(1,5));
        triples.add(new Point(1, DIM-6));
        triples.add(new Point(5,1));
        triples.add(new Point(5,5));
        triples.add(new Point(5, DIM-6));
        triples.add(new Point(5,DIM-2));
        
        triples.add(new Point(DIM-6, 1));
        triples.add(new Point(DIM-6, 5));
        triples.add(new Point(DIM-6, DIM-6));
        triples.add(new Point(DIM-6,DIM-2));
        triples.add(new Point(DIM-2, 5));
        triples.add(new Point(DIM-2, DIM-6));        
        
        motsDoubles.add(new Point(1, 1));
        motsDoubles.add(new Point(2, 2));
        motsDoubles.add(new Point(3, 3));
        motsDoubles.add(new Point(4, 4));
        motsDoubles.add(new Point(1, DIM-2));
        motsDoubles.add(new Point(2, DIM-3));
        motsDoubles.add(new Point(3, DIM-4));
        motsDoubles.add(new Point(4, DIM-5));
        
        motsDoubles.add(new Point(7, 7));
        
        motsDoubles.add(new Point(DIM-2, DIM-2));
        motsDoubles.add(new Point(DIM-3, DIM-3));
        motsDoubles.add(new Point(DIM-4, DIM-4));
        motsDoubles.add(new Point(DIM-5, DIM-5));
        motsDoubles.add(new Point(DIM-5, 4));
        motsDoubles.add(new Point(DIM-4, 3));
        motsDoubles.add(new Point(DIM-3, 2));
        motsDoubles.add(new Point(DIM-2, 1));

        motsTriples.add(new Point(0, 0));
        motsTriples.add(new Point(0, 7));
        motsTriples.add(new Point(0, DIM - 1));
        motsTriples.add(new Point(7, 0));
        motsTriples.add(new Point(7, DIM-1));
        motsTriples.add(new Point(DIM - 1, 0));
        motsTriples.add(new Point(DIM - 1, 7));
        motsTriples.add(new Point(DIM - 1, DIM - 1));
                
 
        for (int li = 0; li < DIM; ++li) {
            for (int co = 0; co < DIM; ++co) {
                Point pt = new Point(li, co);
                if (doubles.contains(pt))     
                    grille[li][co] = new Double();
                
                else if (triples.contains(pt)) 
                    grille[li][co] = new Triple();

                else if (motsDoubles.contains(pt))      
                    grille[li][co] = new MotDouble();

                else if (motsTriples.contains(pt))  
                    grille[li][co] = new MotTriple();
                
                else 
                    grille[li][co] = new Simple();         
            }
        }
    }
}



