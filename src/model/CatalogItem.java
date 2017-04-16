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
    private String mat_nr;
    private String name;
    private String title;
    private String area;
    private String item;

    public CatalogItem(String mat_nr, String name, String title, String area, String item) {
        this.mat_nr = mat_nr;
        this.name = name;
        this.title = title;
        this.area = area;
        this.item = item;
    }

    public String getMatnr() {
        return mat_nr;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getArea() {
        return area;
    }

    public String getItem() {
        return item;
    }

}
