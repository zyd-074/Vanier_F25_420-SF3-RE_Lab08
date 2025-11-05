import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author CnFig
 */
public class PainterController implements Initializable {
    // Variables referring to GUI components
    @FXML
    private RadioButton black;
    @FXML
    private ToggleGroup colorGroup;
    @FXML
    private RadioButton red;
    @FXML
    private RadioButton green;
    @FXML
    private RadioButton blue;
    @FXML
    private RadioButton small;
    @FXML
    private ToggleGroup sizeGroup;
    @FXML
    private RadioButton medium;
    @FXML
    private RadioButton large;
    @FXML
    private Button undoBtn;
    @FXML
    private Button clearBtn;
    @FXML
    private Pane drawingAreaPane;
    
    // Variables for managing Painter State
    private PenSize radius = PenSize.MEDIUM;
    private Paint brushColor = Color.BLACK;

    /**
     * Initializes the controller class.
     */    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Controller Initialize
        black.setUserData(Color.BLACK);
        red.setUserData(Color.RED);
        blue.setUserData(Color.BLUE);
        green.setUserData(Color.GREEN);
        small.setUserData(PenSize.SMALL);
        medium.setUserData(PenSize.MEDIUM);
        large.setUserData(PenSize.LARGE);
    }

    @FXML
    private void colorRadioButtonSelected(ActionEvent event) {
        brushColor = (Paint) colorGroup.getSelectedToggle().getUserData();
    }

    @FXML
    private void sizeRadioButtonSelected(ActionEvent event) {
        radius = (PenSize) sizeGroup.getSelectedToggle().getUserData();
    }

    @FXML
    private void undoClicked(ActionEvent event) {
        int idx = drawingAreaPane.getChildren().size();
        if (idx > 0) {
            drawingAreaPane.getChildren().removeLast();
        }
    }

    @FXML
    private void clearClicked(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    private void drawingAreaMouseDragged(MouseEvent event) {
        Circle pen = new Circle(event.getX(), event.getY(),radius.getRadius(),brushColor);
        drawingAreaPane.getChildren().add(pen);
    }
    
    private enum PenSize {
        SMALL(2),
        MEDIUM(4),
        LARGE(6);
        
        private final int radius;
        PenSize(int radius) {this.radius = radius;}
        public int getRadius() {return radius;}
    }
}
