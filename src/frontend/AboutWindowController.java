package frontend;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class AboutWindowController {
    private Stage aboutWindowStage;

    public void setStage(Stage aboutWindowStage) {
            this.aboutWindowStage = aboutWindowStage;
    }

    @FXML
    private ScrollPane AboutScrollPane;
    @FXML
    public void AboutWindow_CloseButton() {
        this.aboutWindowStage.close();
    }
}
