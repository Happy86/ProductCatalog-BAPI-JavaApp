import frontend.MainWindowController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import backend.ProductCatalog;

/*
 * @class   Main
 * @authors Tamino, Salvatore, Andreas (ADV Boeblingen, I32-2016/17)
 * @license ISC License (ISC)
 * @since   2017-03-29
 *
 * Diese Klasse dient zur initialisierung der Anwendung.
 *
 */

public class Main extends Application{
    public static void main(String[] args) {
        // Konfigurationsdatei auslesen.
        Config einstellungen = new Config("sap-zugangsdaten.properties");

        // Verbindung zum SAP Server aufbauen.
//        SAPVerbindung verbindung = new SAPVerbindung(einstellungen);
//        verbindung.openConnectionToSAP();

        // TODO: hier code einfuegen :-)

        Application.launch(args);
//        new ProductCatalog(verbindung.getMConnection());

        // Verbindung zum SAP Server schlieszen.
//        verbindung.closeConnectionToSAP();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/frontend/MainWindow.fxml"));
        ScrollPane root = loader.load();
        MainWindowController controller = loader.getController();

        controller.setStage(primaryStage);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ProductCatalog-BAPI-JavaApp");
        primaryStage.sizeToScene();
        primaryStage.show();
        primaryStage.setMinHeight(primaryStage.getHeight());
        primaryStage.setMinWidth(primaryStage.getWidth());
    }
}
