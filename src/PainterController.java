import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;
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
    
    // Idx of last drawing 
    private Stack<Integer> idxUndo = new Stack<>();

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
        int idx = drawingAreaPane.getChildren().size() - 1;
        if (!idxUndo.isEmpty()) {
            int goalIdx = idxUndo.peek();
            if (idx > goalIdx) {
                for (int i = idx; i > goalIdx; i--) {
                    drawingAreaPane.getChildren().remove(i);
                }
            idxUndo.pop();
            }
        }
    }

    @FXML
    private void clearClicked(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    private void drawingAreaMouseDragged(MouseEvent event) {
        Circle pen = new Circle(event.getX(), event.getY(),radius.getRadius(),brushColor);
        double leftBorder = drawingAreaPane.getTranslateX() + radius.getRadius();
        double rightBorder = drawingAreaPane.getTranslateX() + drawingAreaPane.getWidth() - radius.getRadius();
        double topBorder = drawingAreaPane.getTranslateY() + radius.getRadius();
        double bottomBorder = drawingAreaPane.getTranslateY() + drawingAreaPane.getHeight() - radius.getRadius();
        if (event.getX() > leftBorder && event.getX() < rightBorder && event.getY() > topBorder && event.getY() < bottomBorder) {
            drawingAreaPane.getChildren().add(pen);
        }
    }
    
    @FXML
    private void saveIdx(MouseEvent event) {
        idxUndo.push(drawingAreaPane.getChildren().size() - 1);
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
