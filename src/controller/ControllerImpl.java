package controller;

import java.awt.Point;
import java.util.Scanner;
import model.Chevalet;
import model.Grille;
import model.Jeton;
import model.Mot;
import view.View;

/**
 *
 * @author 0404ragrau
 */
public class ControllerImpl implements Controller {
    
    
    private final Grille grille = new Grille();
    private final View vue;
    private final Chevalet chevalet = new Chevalet();
    private final Scanner scanner = new Scanner(System.in);
    private Mot mot = new Mot();
    private char CHAR_FIN_MOT = '/';


    public ControllerImpl() {
        this.vue = new View(this);
        grille.addObserver(vue);
        chevalet.addObserver(vue);
        lancer();
    }

    
    public boolean exists(char c){
        for(Jeton j : chevalet.getChev()){
            if(j.getChar()==c){
                return true;
            }
        }
        return false;
    }
    
    public Mot getMot() {
        return this.mot;
    }
    
    public Chevalet getChevalet() {
        return this.chevalet;
    }
    
    public Grille getGrille() {
        return this.grille;
    }
    
    public char getCh() {
        char ch = scanner.next().charAt(0);
            
            while (!exists(ch) && ch != CHAR_FIN_MOT) {
                System.out.println("vous ne possédez pas cette lettre sur votre chevalet");
                ch = scanner.next().charAt(0);  
            
        }
        return ch;
    }
    
    
    public void positionnerLettre(Point pt, char ch) {

        grille.getCase(pt).setChar(ch);
        Jeton j = chevalet.getJeton(ch);
//        System.out.println("j : " + j.getChar());
        mot.ajouterJetonMot(j);
        chevalet.removeJeton(ch);
        grille.notif();
        chevalet.notif();   
    }
    
    
    public void lancer() {
        grille.notif();
        chevalet.notif();
//        grille.initGrille();
//        grille.notif();
//        chevalet.notif();
//        grille.initGrille();
//        vue.afficherChevalet();
//        vue.afficherGrille();
//        vue.choisirLettre();
//        vue.choisirPosition();
//        grille.placerLettreGrille();    
    }

  
    public static void main(String[] args) {
    
        ControllerImpl control = new ControllerImpl();

    }   
}
