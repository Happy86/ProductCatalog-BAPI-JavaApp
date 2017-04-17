/*
 * @class   CatalogVariants
 * @authors Tamino, Salvatore, Andreas (ADV Boeblingen, I32-2016/17)
 * @license ISC License (ISC)
 * @since   2017-03-29
 *
 * CatalogVariants repraesentiert alle Katalogvarianten eines einzelnen
 * Katalogs.
 */

package model;

import java.util.List;
import java.util.Vector;

import backend.ProductCatalog;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CatalogVariants {
    private Vector<String> variantenliste;
    private ObservableList<CatalogVariant> variantenObjekte = FXCollections.observableArrayList();
    private ProductCatalog prodcat;
    private String s_nameDesKatalogs;

    public CatalogVariants(String s_nameDesKatalogs, ProductCatalog prodcat) {
        this.prodcat = prodcat;
        this.s_nameDesKatalogs = s_nameDesKatalogs;

        this.variantenliste = this.prodcat.getVariants(s_nameDesKatalogs);

        for(String var : this.variantenliste) {
//            System.out.println(s_nameDesKatalogs + " - " + var);
            this.variantenObjekte.add(new CatalogVariant(s_nameDesKatalogs, var));
        }

    }

    public CatalogItems getItems(int i_variantenNummerAusVariantenliste) {
        return getItems(this.variantenliste.get(i_variantenNummerAusVariantenliste));
    }

    public CatalogItems getItems(String s_nameDerVariante) {
        // TODO: get CatalogItems from SAP as String array
        return new CatalogItems(s_nameDerVariante, this.s_nameDesKatalogs, this.prodcat);
    }

    public Vector<String> getVariantenliste() {
        return this.variantenliste;
    }

    public List<String> getListOfVariantenliste() {
        return this.variantenliste;
    }

    public ObservableList<CatalogVariant> getListOfVariantenObjekten() {
        return this.variantenObjekte;
    }
}
