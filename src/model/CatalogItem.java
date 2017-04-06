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

public class CatalogItem {
    private String name;
    private String title;

    public CatalogItem(String name, String title) {
        this.name = name;
        this.title = title;
    }


    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }
}
