/*
 * @class   SAPVerbindung
 * @authors Tamino, Salvatore, Andreas (ADV Boeblingen, I32-2016/17)
 * @license ISC License (ISC)
 * @since   2017-03-29
 * 
 * Diese Klasse wird dazu verwendet um die Verbindung mit dem SAP Server
 * aufzubauen. Beim Verbindungsaufbau sind die Zugangsdaten anzugeben.
 * 
 */

import com.sap.mw.jco.JCO;

public class SAPVerbindung {
    private Config einstellungen;
    private JCO.Client mConnection;


    /*
     * Konstruktor dem ein Einstellungsobjekt uebergeben wird.
     *
     * @param   Config    Objekt mit Zugangsdaten
     */
    public SAPVerbindung(Config einstellungen) {
        // Einstellungsobjekt in den Attribut speichern
        this.einstellungen = einstellungen;

        // Verbindungsobjekt (JCO.Client) mit Zugangsdaten befuellen
        this.mConnection = JCO.createClient(this.einstellungen.getClientSAP,
                                            this.einstellungen.getLogin,
                                            this.einstellungen.getPasswort,
                                            this.einstellungen.getLanguage,
                                            this.einstellungen.getServer,
                                            this.einstellungen.getSystemNumber);
    }

    /*
     * Diese Methode baut eine Verbindung mit einem SAP Server auf und
     * hinterlegt diese im privaten Attribut 'mConnection' (getMConnection).
     */
    public void openConnectionToSAP() {
        System.out.print("Verbinde mich mit SAP ... ");
        // Verbindung herstellen
        this.mConnection.connect();
        System.out.println("verbunden");
        System.out.println("-------------------------------------------");
    }

    /*
     * Diese Methode schlieszt die Verbindung zum SAP Server.
     */
    public void closeConnectionToSAP() {
        this.mConnection.disconnect();
    }

    /*
     * Uber diese Methode kann man auf das Attribut mConnection zugreifen.
     * 
     * @return JCO.Client mConnection
     */
    public JCO.Client getMConnection() {
        return this.mConnection;
    }
}
