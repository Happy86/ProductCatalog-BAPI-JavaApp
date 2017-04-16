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

import java.util.Arrays;
import java.util.Vector;

public class CatalogItems {
    private Vector<String> katalogitems;

    public CatalogItems(String[] itemliste) {
        this.katalogitems = new Vector<String>();
        this.katalogitems.addAll(Arrays.asList(itemliste));
    }

    public CatalogItem getItem(int itemNummerAusKatalogitems) {
        return getItem(this.katalogitems.get(itemNummerAusKatalogitems));
    }

    public CatalogItem getItem(String nameDesItems) {
        // TODO: get CatalogItem from SAP and pass name and title to new CatalogItem object
        return new CatalogItem("mat_nr", "name", "title", "area", "item");
    }
}