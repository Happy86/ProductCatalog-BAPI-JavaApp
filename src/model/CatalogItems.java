/*
 * @class   CatalogItems
 * @authors Tamino, Salvatore, Andreas (ADV Boeblingen, I32-2016/17)
 * @license ISC License (ISC)
 * @since   2017-03-29
 *
 * Diese Klasse repraesentiert ein alle CatalogItem die in einer
 * Katalogvariante vorkommen.
 */

package model;

import java.util.List;

import backend.ProductCatalog;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CatalogItems {
    private List<CatalogItem> katalogitems;
    private ObservableList<CatalogItem> itemObjekte;
    private ProductCatalog prodcat;
    private String s_variantenname;
    private String s_katalogname;

    public CatalogItems(String s_nameDerVariante, String s_nameDesKatalogs, ProductCatalog prodcat) {
        this.prodcat = prodcat;
        this.s_katalogname = s_nameDesKatalogs;
        this.s_variantenname = s_nameDerVariante;

        this.katalogitems = this.prodcat.getItems(this.s_katalogname, this.s_variantenname);
        for(CatalogItem item : this.katalogitems) {
            item.setVarianteKatalogUndProdcat(this.s_variantenname, this.s_katalogname, this.prodcat);
        }

        this.itemObjekte = FXCollections.observableArrayList(this.katalogitems);
    }

    public ObservableList<CatalogItem> getListOfItemObjekte() {
        return this.itemObjekte;
    }
}