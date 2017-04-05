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

import java.util.Arrays;
import java.util.Vector;

public class CatalogVariants {
    private Vector<String> variantenliste;

    public CatalogVariants(String[] variantenliste) {
        this.variantenliste = new Vector<String>();
        this.variantenliste.addAll(Arrays.asList(variantenliste));
    }

    public CatalogItems getItems(int variantenNummerAusVariantenliste) {
        return getItems(this.variantenliste.get(variantenNummerAusVariantenliste));
    }

    public CatalogItems getItems(String nameDerVariante) {
        // TODO: get CatalogItems from SAP as String array
        return new CatalogItems(new String[1]);
    }
}
