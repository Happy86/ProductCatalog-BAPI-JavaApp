/*
 * @class   Main
 * @authors Tamino, Salvatore, Andreas (ADV Boeblingen, I32-2016/17)
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
        SAPVerbindung verbindung = new SAPVerbindung();
        verbindung.openConnectionToSAP(einstellungen.getClientSAP(),
                                       einstellungen.getLogin(),
                                       einstellungen.getPasswort(),
                                       einstellungen.getLanguage(),
                                       einstellungen.getServer(),
                                       einstellungen.getSystemNumber());

        // TODO: hier code einfuegen :-)


        // Verbindung zum SAP Server schlieszen.
        verbindung.closeConnectionToSAP();
    }
}
