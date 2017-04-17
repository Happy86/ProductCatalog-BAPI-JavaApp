/*
 * @class   CatalogList
 * @authors Tamino, Salvatore, Andreas (ADV Boeblingen, I32-2016/17)
 * @license ISC License (ISC)
 * @since   2017-03-29
 *
 * CatalogList repraesentiert alle Kataloge die aus dem SAP System
 * abgerufen werden konnten.
 *
 */

package model;

import java.util.List;
import java.util.Vector;

import backend.ProductCatalog;

public class CatalogList {
    private Vector<String> katalogliste;
    private ProductCatalog prodcat;

    public CatalogList(ProductCatalog prodcat) { //Vector<String> katalogliste
        this.prodcat = prodcat;
        this.katalogliste = this.prodcat.getList();
//        this.katalogliste.addAll(Arrays.asList(katalogliste));
    }

    public CatalogVariants getVariants(int i_katalogNummerAusKataloglistenVektor) {
        return getVariants(katalogliste.get(i_katalogNummerAusKataloglistenVektor));
    }

    public CatalogVariants getVariants(String s_nameDesKatalogs) {
        // TODO: get variants from given catalog from SAP as String array
        return new CatalogVariants(s_nameDesKatalogs, this.prodcat);
    }

    /**
     * @return the katalogliste
     */
    public Vector<String> getKatalogliste() {
        return this.katalogliste;
    }

    public List<String> getListOfKatalogliste() {
        return this.katalogliste;
    }
}
