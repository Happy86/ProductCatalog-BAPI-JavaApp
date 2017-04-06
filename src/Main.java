import backend.Verbindungstest;

/*
 * @class   Main
 * @authors Tamino, Salvatore, Andreas (ADV Boeblingen, I32-2016/17)
 * @license ISC License (ISC)
 * @since   2017-03-29
 *
 * Diese Klasse dient zur initialisierung der Anwendung.
 *
 */

public class Main {
    public static void main(String[] args) {
        // Konfigurationsdatei auslesen.
        Config einstellungen = new Config("sap-zugangsdaten.properties");

        // Verbindung zum SAP Server aufbauen.
        SAPVerbindung verbindung = new SAPVerbindung(einstellungen);
        verbindung.openConnectionToSAP();

        // TODO: hier code einfuegen :-)
        new Verbindungstest(verbindung.getMConnection());

        // Verbindung zum SAP Server schlieszen.
        verbindung.closeConnectionToSAP();
    }
}
