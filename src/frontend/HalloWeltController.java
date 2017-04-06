package frontend;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HalloWeltController {
    @FXML
    private Button meinButton;
    @FXML
    private TextField meinTextfeld;
    @FXML
    private Label meinLabel;

    @FXML
    private void meinButtonClicked() {
        meinLabel.setText(this.meinTextfeld.getText());
    }

    @FXML
    private void neuesFensterButton() throws IOException {
                                            // in welcher klasse bin ich
        FXMLLoader loader = new FXMLLoader(HalloWeltController.class.getResource("/frontend/HalloWelt.fxml"));
        ScrollPane root = loader.load();
        // tatsaechliche controller klasse des fxml files
        HalloWeltController controller = loader.getController();
        Stage primaryStage = new Stage();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hallo Welt Fenstertitel");
        primaryStage.sizeToScene();
        primaryStage.show();
        primaryStage.setMinHeight(primaryStage.getHeight());
        primaryStage.setMinWidth(primaryStage.getWidth());
    }
}
