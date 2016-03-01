package viewGUI;

import controllerGUI.ControllerGUI;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.Jeton;


/**
 *
 * @author 0404ragrau
 */
public abstract class ViewCase extends StackPane {

    
    private Text lettre;
    Rectangle carreCase;
    private final ViewGrille viewGrille;
    private ControllerGUI ctrl;
    private final int x, y;
    private final String cssCasesGrilleDefault
                = "-fx-stroke: black;\n"
                + "-fx-stroke-width: 1;\n"
//                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);"
            ;
    final String cssJetonTemp
                = "-fx-stroke: black;\n"
                + "-fx-stroke-width: 1;\n"
                + "-fx-stroke-dash-array: 4 4 4 4;\n"
                + "-fx-stroke-dash-offset: 4;\n"
//                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);"
            ;
    Color JETON_COLOR = Color.web("ffffcc");
    Color TEMP_COLOR = Color.web("fffff3");
    
    
    public ViewCase(int x, int y, String lettre, ViewGrille viewGrille, ControllerGUI ctrl) {
        this.x = x;
        this.y = y;
        this.viewGrille = viewGrille;
        
        initCarreCase();
        initLettreCase(lettre);
        
        this.getChildren().add(this.lettre); 

        this.setOnDragOver((event) -> {
    
            if (!ctrl.caseJouee(x, y)) {     
                System.out.println("accepte drag n drop");
                event.acceptTransferModes(TransferMode.ANY);
                event.consume();
            } 
        });
        
        this.setOnDragDropped((event) -> {

            boolean success = false;
            System.out.println(viewGrille.getCourant());
            System.out.println("coucou");
            Jeton j = ((ViewJeton) event.getGestureSource()).getCourant();
            ctrl.placerLettreTemp(x, y, j);
            this.getChildren().add(ctrl.getTemp());
            
//            setStyleCaseJouee();
//            setStyleLettreCaseJouee();

            success = true;
            event.setDropCompleted(success);
            event.consume();

        });   
    }
    
    private void initCarreCase() {
        carreCase = new Rectangle(40, 40, Color.PURPLE);
        carreCase.setArcWidth(10);
        carreCase.setArcHeight(10);
        carreCase.setStyle(cssCasesGrilleDefault);
        this.getChildren().add(carreCase);
    }
    
    private void initLettreCase(String lettre) {   
        this.lettre = new Text(lettre.toUpperCase());
        this.lettre.setFont(new Font("Serif", 24));
        this.lettre.setFill(Color.BLACK);
        this.lettre.setStyle("-fx-font-weight: bold");
    }
    
//    public void setStyleCaseJouee() {
//        carreCase = new Rectangle(40, 40, Color.web("ffffcc"));
//        carreCase.setArcWidth(10);
//        carreCase.setArcHeight(10);
//        carreCase.setStyle(cssDefault);
//        this.getChildren().add(carreCase);
//    }
//    
//    private void setStyleLettreCaseJouee() {
//        System.out.println(viewGrille.getCourant().getChar());
//        this.lettre = new Text(viewGrille.getCourant().getStr().toUpperCase());
//        this.lettre.setFont(new Font("Serif", 24));
//        this.lettre.setFill(Color.BLACK);
//        this.lettre.setStyle("-fx-font-weight: bold");
//        this.getChildren().add(this.lettre);
//    }
        
   
    public Text getLettre() {
        return lettre;
    }
    
    public void setLettre(String lettre) {
        this.lettre = new Text(viewGrille.getCourant().getStr().toUpperCase());
//        this.lettre.setFont(new Font("Serif", 24));
//        this.lettre.setFill(Color.BLACK);
//        this.lettre.setStyle("-fx-font-weight: bold");
    }
    
    public Rectangle getCarreCase() {
        return carreCase;
    }   
    
//    public void setCarreCase() {
//        carreCase.setArcWidth(10);
//        carreCase.setArcHeight(10);
//        carreCase.setStyle(cssDefault);
//    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    

    
    
    abstract public void affiche();



    //        this.setOnDragDone((event) -> {
//            System.out.println("remove jeton");
//                       
//            Jeton jj = ((ViewJeton) event.getGestureSource()).courant;
//            if (!ctrl.caseJouee(x, y)) {
//                ctrl.removeJeton(jj);
//            }
//   
//            for (Jeton j : ctrl.getChevalet().getChev())
//                System.out.println(j);
//            
//            event.consume();
//        
//        });
    }
  


