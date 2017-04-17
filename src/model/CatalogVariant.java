package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CatalogVariant {
    private StringProperty PRODCAT;
    private StringProperty VAR;

    public CatalogVariant(String PRODCAT, String VAR) {
        this.PRODCAT = new SimpleStringProperty(PRODCAT);
        this.VAR = new SimpleStringProperty(VAR);
    }

    public StringProperty getPRODCAT() {
        return this.PRODCAT;
    }

    public void setPRODCAT(String PRODCAT) {
        this.PRODCAT.setValue(PRODCAT);
    }

    public StringProperty getVAR() {
        return this.VAR;
    }

    public void setVAR(String VAR) {
        this.VAR.setValue(VAR);
    }
}
