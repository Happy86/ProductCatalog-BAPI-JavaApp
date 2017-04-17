package frontend;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.CatalogItem;
import model.CatalogItems;
import model.CatalogList;
import model.CatalogVariant;
import model.CatalogVariants;

public class MainWindowController implements Initializable{
    private Stage mainWindowStage;
    private CatalogList Katalogliste;
    private CatalogVariants Katalogvarianten;
    private CatalogItems Katalogitems;

    @FXML
    private MenuItem ueberMenuItem = new MenuItem();

    @FXML
    private MenuItem beendenMenuItem = new MenuItem();

    private ObservableList<String> KataloglisteData;

    @FXML
    private ListView<String> ListViewKatalogliste = new ListView<String>();



    @FXML
    private void beendenMenuClicked() {
        this.mainWindowStage.close();
    }


    @FXML
    private TableView<CatalogVariant> TableViewVariantenliste = new TableView<CatalogVariant>();
    @FXML
    private TableColumn<CatalogVariant, String> tc_PRODCAT;
    @FXML
    private TableColumn<CatalogVariant, String> tc_VAR;
    @SuppressWarnings("unchecked")
    @FXML
    private void getVariantClicked() {
        this.tc_PRODCAT = new TableColumn<CatalogVariant, String>("PRODCAT");
        this.tc_VAR = new TableColumn<CatalogVariant, String>("VAR");
        System.out.println("CLEAR!");
        this.TableViewVariantenliste.getItems().clear();
        this.TableViewVariantenliste.getColumns().clear();

//        this.tc_PRODCAT.getColumns().clear();

        this.TableViewVariantenliste.setEditable(false);
        this.TableViewVariantenliste.getColumns().addAll(tc_PRODCAT, tc_VAR);

        int choice = this.ListViewKatalogliste.getSelectionModel().getSelectedIndex();
        String s_ausgewaehlter_katalog = this.Katalogliste.getKatalogliste().get(choice);
        System.out.println(s_ausgewaehlter_katalog);
        this.Katalogvarianten = this.Katalogliste.getVariants(s_ausgewaehlter_katalog);
        tc_PRODCAT.setCellValueFactory(celldata -> celldata.getValue().getPRODCAT());
        tc_VAR.setCellValueFactory(celldata -> celldata.getValue().getVAR());
        this.TableViewVariantenliste.setItems(this.Katalogvarianten.getListOfVariantenObjekten());
    }

    @FXML
    private TableView<CatalogItem> TableViewProduktliste = new TableView<CatalogItem>();
    @FXML
    private TableColumn<CatalogItem, String> tc_MATERIAL;
//    @FXML
//    private TableColumn<CatalogItem, String> tc_NAME;
//    @FXML
//    private TableColumn<CatalogItem, String> tc_TITLE;
    @FXML
    private TableColumn<CatalogItem, String> tc_AREA;
    @FXML
    private TableColumn<CatalogItem, String> tc_ITEM;
    @SuppressWarnings("unchecked")
    @FXML
    private void getItemsClicked() {
        this.tc_MATERIAL = new TableColumn<CatalogItem, String>("MATERIAL");
//        this.tc_NAME = new TableColumn<CatalogItem, String>("NAME");
//        this.tc_TITLE = new TableColumn<CatalogItem, String>("TITLE");
        this.tc_AREA = new TableColumn<CatalogItem, String>("AREA");
        this.tc_ITEM = new TableColumn<CatalogItem, String>("ITEM");
        System.out.println("CLEAR!");
        this.TableViewProduktliste.getItems().clear();
        this.TableViewProduktliste.getColumns().clear();

        this.TableViewProduktliste.setEditable(false);
        this.TableViewProduktliste.getColumns().addAll(tc_MATERIAL, tc_AREA, tc_ITEM);

        int choice = this.TableViewVariantenliste.getSelectionModel().getSelectedIndex();
        String s_ausgewaehlte_variante = this.Katalogvarianten.getVariantenliste().get(choice);
        System.out.println(s_ausgewaehlte_variante);
        this.Katalogitems = this.Katalogvarianten.getItems(s_ausgewaehlte_variante);
        tc_MATERIAL.setCellValueFactory(celldata -> celldata.getValue().getSPMatnr());
//        tc_NAME.setCellValueFactory(celldata -> celldata.getValue().getSPName());
//        tc_TITLE.setCellValueFactory(celldata -> celldata.getValue().getSPTitle());
        tc_AREA.setCellValueFactory(celldata -> celldata.getValue().getSPArea());
        tc_ITEM.setCellValueFactory(celldata -> celldata.getValue().getSPItem());
        this.TableViewProduktliste.setItems(this.Katalogitems.getListOfItemObjekte());
    }


    @FXML
    TextField tf_name = new TextField();
    @FXML
    TextField tf_title = new TextField();
    @FXML
    private void getItemClicked() {
        CatalogItem temp = this.TableViewProduktliste.getSelectionModel().getSelectedItem();
        temp.retrieveNameAndTitle();
        tf_name.setText(temp.getName());
        tf_title.setText(temp.getTitle());
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

    public void setKatalogliste(CatalogList Katalogliste) {
        this.Katalogliste = Katalogliste;
    }

    public void setKataloglisteData(ObservableList<String> liste) {
        this.KataloglisteData = liste;
    }

    public ObservableList<String> getKataloglisteData() {
        return this.KataloglisteData;
    }

    public void setListViewKatalogliste(ListView<String> liste) {
        this.ListViewKatalogliste = liste;
    }

    public ListView<String> getListViewKatalogliste() {
        return this.ListViewKatalogliste;
    }

    public void setStage(Stage mainWindowStage) {
        this.mainWindowStage = mainWindowStage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub

    }
}
