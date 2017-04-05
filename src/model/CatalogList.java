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


    /**
     * @return the katalogliste
     */
    public Vector<String> getKatalogliste() {
        return katalogliste;
    }

    /**
     * @param katalogliste the katalogliste to set
     */
    public void setKatalogliste(Vector<String> katalogliste) {
        this.katalogliste = katalogliste;
    }


}
