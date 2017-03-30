/*
 * @class   SAPVerbindung
 * @authors Tamino, Salvatore, Andreas (ADV Boeblingen, I32-2016/17)
 * @since   2017-03-29
 * 
 * Diese Klasse wird dazu verwendet um die Verbindung mit dem SAP Server
 * aufzubauen. Beim Verbindungsaufbau sind die Zugangsdaten anzugeben.
 * 
 */

import com.sap.mw.jco.JCO;

public class SAPVerbindung {
    private JCO.Client mConnection;

    /*
     * Diese Methode baut eine Verbindung mit einem SAP Server auf und
     * hinterlegt diese im privaten Attribut 'mConnection' (getMConnection).
     * 
     * @param String clientSAP
     * @param String login
     * @param String passwort
     * @param String language
     * @param String server
     * @param String systemNumber
     * 
     */
    public void openConnectionToSAP(String clientSAP,
                                    String login,
                                    String passwort,
                                    String language,
                                    String server,
                                    String systemNumber) {
        // Verbindungsdaten
        System.out.print("Verbinde mich mit SAP ... ");
        this.mConnection = JCO.createClient(clientSAP, login, passwort, language, server, systemNumber);
        // Verbindung herstellen
        this.mConnection.connect();
        System.out.println("verbunden");
        System.out.println("-------------------------------------------");
    }

    /*
     * Diese Methode schlieszt die Verbindung zum SAP Server.
     * 
     */
    public void closeConnectionToSAP() {
        this.mConnection.disconnect();
    }

    /*
     * Uber diese Methode kann man auf das Attribut mConnection zugreifen.
     * 
     * @return JCO.Client mConnection
     * 
     */
    public JCO.Client getMConnection() {
        return this.mConnection;
    }
}
