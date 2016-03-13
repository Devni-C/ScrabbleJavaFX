
package viewGUI;

import controllerGUI.ControllerGUI;
import javafx.scene.paint.Color;
import model.Jeton;

/**
 *
 * @author raphaelgrau
 */
public class ViewCaseTemp extends ViewCase {
    
    private final ControllerGUI ctrl;
    private final Jeton j;
    private final Color TEMP_COLOR = Color.web("ffffcc");//Color.SNOW;
    private final String cssJetonTemp = "-fx-stroke:yellow; -fx-stroke-width: 2;\n"
//                + "-fx-stroke-dash-array: 4 4 4 4;\n"
//                + "-fx-stroke-dash-offset: 4;\n"
//                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);"
            ;

    
    public ViewCaseTemp(int x, int y, String lettre, Jeton j, ViewGrille viewGrille, ControllerGUI ctrl) {
        super(x, y, lettre, viewGrille, ctrl);
        this.ctrl = ctrl;
        this.j = j;
        setColorCase(TEMP_COLOR);
        setStyleCase(cssJetonTemp);
        setLettre(lettre);
    }
    
    public Jeton getJeton() {
        return j;
    }
    
    public Jeton getJetonCourant() {
        return ctrl.getCourant();
    }
    
    public String getLettreViewCaseTemp() {
        return getLettre().toString();
    }
    
    public int getPosX() {
        return getX();
    }
    
    public int getPosY() {
        return getY();
    }
    
//    public boolean viewCaseTempExist(int x, int y) {
//        return getX() == x && getY() == y;
//    }
    
  
    @Override
    public void affiche() {
    }
    
}
