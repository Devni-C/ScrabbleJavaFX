package viewGUI;

import controllerGUI.ControllerGUI;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 *
 * @author 0404ragrau
 */
public class ViewButtons extends HBox {
    
    
        public ViewButtons(ControllerGUI ctrl) {
            Button btnOK = new Button();
            btnOK.setText("Valider");
            btnOK.setOnAction((ActionEvent event) -> {
                System.out.println("OK!");
                ctrl.validerCoup(ctrl.getListCasesTemp(), ctrl.getListJetonsJoues());
                
            });

            Button btnCancel = new Button();
            btnCancel.setText("Annuler");
            btnCancel.setOnAction((ActionEvent event) -> {
                System.out.println("Annuler!");
                ctrl.annulerDerniereLettre();
            });
            
            this.getChildren().addAll(btnOK, btnCancel);
            this.setSpacing(5);
            this.setAlignment(Pos.CENTER);

            
        }
    
    

    
    
    
}
