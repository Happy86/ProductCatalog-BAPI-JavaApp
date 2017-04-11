package frontend;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainWindowController implements Initializable{
    private Stage mainWindowStage;

    @FXML
    private Button meinButton;
    @FXML
    private TextField meinTextfeld;
    @FXML
    private Label meinLabel;

    @FXML
    private MenuItem ueberMenuItem = new MenuItem();

    @FXML
    private MenuItem beendenMenuItem = new MenuItem();

    @FXML
    private void meinButtonClicked() {
        meinLabel.setText(this.meinTextfeld.getText());
    }

    @FXML
    private void beendenMenuClicked() {
        this.mainWindowStage.close();
    }

    @FXML
    private void neuesFensterButton() throws IOException {
        // in welcher klasse bin ich
        FXMLLoader loader = new FXMLLoader(MainWindowController.class.getResource("/frontend/AboutWindow.fxml"));
        ScrollPane root = loader.load();
        // tatsaechliche controller klasse des fxml files
        AboutWindowController controller = loader.getController();

        Stage primaryStage = new Stage();
        controller.setStage(primaryStage);

        primaryStage.setResizable(false);

        // make modal
        primaryStage.initOwner(this.mainWindowStage);
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        // primaryStage.showAndWait();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("About: ProductCatalog-BAPI-JavaApp");
        primaryStage.sizeToScene();
        primaryStage.show();
        primaryStage.setMinHeight(primaryStage.getHeight());
        primaryStage.setMinWidth(primaryStage.getWidth());
    }


    @FXML
    private void ueberMenuClicked() throws IOException {
                                            // in welcher klasse bin ich
        FXMLLoader loader = new FXMLLoader(MainWindowController.class.getResource("/frontend/AboutWindow.fxml"));
        ScrollPane root = loader.load();
        // tatsaechliche controller klasse des fxml files
        AboutWindowController controller = loader.getController();

        Stage primaryStage = new Stage();
        controller.setStage(primaryStage);

        primaryStage.setResizable(false);

        // make modal
        primaryStage.initOwner(this.mainWindowStage);
        primaryStage.initModality(Modality.APPLICATION_MODAL);

//        primaryStage.showAndWait();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("About: ProductCatalog-BAPI-JavaApp");
        primaryStage.sizeToScene();
        primaryStage.show();
        primaryStage.setMinHeight(primaryStage.getHeight());
        primaryStage.setMinWidth(primaryStage.getWidth());
    }

    public void setStage(Stage mainWindowStage) {
        this.mainWindowStage = mainWindowStage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub

    }
}
