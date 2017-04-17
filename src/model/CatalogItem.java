/*
 * @class   CatalogItem
 * @authors Tamino, Salvatore, Andreas (ADV Boeblingen, I32-2016/17)
 * @license ISC License (ISC)
 * @since   2017-03-29
 *
 * Diese Klasse repraesentiert ein einzelnes CatalogItem.
 *
 */

package model;

import backend.ProductCatalog;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CatalogItem {
    private StringProperty sp_mat_nr;
    private StringProperty sp_name;
    private StringProperty sp_title;
    private StringProperty sp_area;
    private StringProperty sp_item;
    private String s_mat_nr;
    private String s_name;
    private String s_title;
    private String s_area;
    private String s_item;
    private ProductCatalog prodcat;
    private String s_variant;
    private String s_catalog;

    public CatalogItem(String s_mat_nr, String s_name, String s_title, String s_area, String s_item) {
        this.sp_mat_nr = new SimpleStringProperty(s_mat_nr);
        this.sp_name = new SimpleStringProperty(s_name);
        this.sp_title = new SimpleStringProperty(s_title);
        this.sp_area = new SimpleStringProperty(s_area);
        this.sp_item = new SimpleStringProperty(s_item);
        this.s_mat_nr = s_mat_nr;
        this.s_name = s_name;
        this.s_title = s_title;
        this.s_area = s_area;
        this.s_item = s_item;
    }

    public void setVarianteKatalogUndProdcat(String s_nameDerVariante,
                                             String s_nameDesKatalogs,
                                             ProductCatalog prodcat) {
        this.prodcat = prodcat;
        this.s_variant = s_nameDerVariante;
        this.s_catalog = s_nameDesKatalogs;
    }

    public void retrieveNameAndTitle() {
        CatalogItem temp = this.prodcat.getItem(this.s_catalog, this.s_variant, this.s_area, this.s_item);
        this.s_name = temp.getName();
        this.sp_name = temp.getSPName();
        this.s_title = temp.getTitle();
        this.sp_title = temp.getSPTitle();
    }

    public String getMatnr() {
        return this.s_mat_nr;
    }

    public String getName() {
        return this.s_name;
    }

    public String getTitle() {
        return this.s_title;
    }

    public String getArea() {
        return this.s_area;
    }

    public String getItem() {
        return this.s_item;
    }

    //
    public StringProperty getSPMatnr() {
        return this.sp_mat_nr;
    }

    public StringProperty getSPName() {
        return this.sp_name;
    }

    public StringProperty getSPTitle() {
        return this.sp_title;
    }

    public StringProperty getSPArea() {
        return this.sp_area;
    }

    public StringProperty getSPItem() {
        return this.sp_item;
    }

}
