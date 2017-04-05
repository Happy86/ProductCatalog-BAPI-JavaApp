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

import java.util.Arrays;
import java.util.Vector;

public class CatalogList {
    private Vector<String> katalogliste;

    public CatalogList(String[] katalogliste) {
        this.katalogliste = new Vector<String>();
        this.katalogliste.addAll(Arrays.asList(katalogliste));
    }

    public CatalogVariants getVariants(int katalogNummerAusKataloglistenVektor) {
        return getVariants(katalogliste.get(katalogNummerAusKataloglistenVektor));
    }

    public CatalogVariants getVariants(String nameDesKatalogs) {
        // TODO: get variants from given catalog from SAP as String array
        return new CatalogVariants(new String[1]);
    }

    /**
     * @return the katalogliste
     */
    public Vector<String> getKatalogliste() {
        return katalogliste;
    }

}
