/*
 * @class   Main
 * @authors Tamino, Salvatore, Andreas (ADV Boeblingen, I32-2016/17)
 * @license ISC License (ISC)
 * @since   2017-03-29
 *
 * Diese Klasse dient zur initialisierung der Anwendung.
 *
 */

import backend.ProductCatalog;
import frontend.MainWindowController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import model.CatalogList;


public class Main extends Application{
    private SAPVerbindung verbindung;

    public static void main(String[] args) {
        // Anwendungsstart mit JavaFX (GUI)
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/frontend/MainWindow.fxml"));
        ScrollPane root = loader.load();
        MainWindowController controller = loader.getController();

        Config einstellungen = new Config("sap-zugangsdaten.properties");
        verbindung = new SAPVerbindung(einstellungen);
        verbindung.openConnectionToSAP();
        ProductCatalog prodcatObjekt = new ProductCatalog(verbindung.getMConnection());
        CatalogList Katalogliste = new CatalogList(prodcatObjekt);
        controller.setKatalogliste(Katalogliste);

        controller.setKataloglisteData(FXCollections.observableList(Katalogliste.getListOfKatalogliste()));
        controller.getListViewKatalogliste().setItems(controller.getKataloglisteData());


        controller.setStage(primaryStage);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ProductCatalog-BAPI-JavaApp");
        primaryStage.sizeToScene();
        primaryStage.show();
        primaryStage.setMinHeight(primaryStage.getHeight());
        primaryStage.setMinWidth(primaryStage.getWidth());
    }

    @Override
    public void stop(){
        // Beim schlieszen des letzten Fensters die Verbindung zum SAP Server schlieszen.
        System.out.println("Beende Programm, schließe Verbindung zum SAP Server.");
        this.verbindung.closeConnectionToSAP();
    }
}
