/*
 * @class   Config
 * @authors Tamino, Salvatore, Andreas (ADV Boeblingen, I32-2016/17)
 * @license ISC License (ISC)
 * @since   2017-03-29
 * 
 * Diese Klasse dient dazu eine Java nach Properties Syntax formatierte
 * Datei zu parsen und als Attribute (ueber get-Methoden) zur Verfuegung
 * zu stellen.
 * 
 * Bei der Initialisierung des Objekts ist der Pfad samt Dateiname anzugeben.
 * 
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private String clientSAP;       // client number
    private String login;           // username
    private String passwort;        // password
    private String language;        // language
    private String server;          // SAP router
    private String systemNumber;    // system number

    private InputStream inputFile;
    private Properties propertiesObjekt = new Properties();

    /*
     * Config Konstruktor.
     * 
     * @param       String          Pfad inkl. Dateiname zur .properties Konfigurationsdatei.
     * @exception   IOException     IOException wenn die Konfigurationsdatei nicht vorhanden oder nicht lesbar ist.
     */
    public Config(String configpfad) {
        try {
            inputFile = new FileInputStream(configpfad);
            propertiesObjekt.load(inputFile);

            this.clientSAP = propertiesObjekt.getProperty("clientSAP");
            this.login = propertiesObjekt.getProperty("login");
            this.passwort = propertiesObjekt.getProperty("passwort");
            this.language = propertiesObjekt.getProperty("language");
            this.server = propertiesObjekt.getProperty("server");
            this.systemNumber = propertiesObjekt.getProperty("systemNumber");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    /*
     * @return String ClientSAP
     */
    public String getClientSAP() {
        return this.clientSAP;
    }

    /*
     * @return String login (Benutzername)
     */
    public String getLogin() {
        return this.login;
    }

    /*
     * @return String passwort
     */
    public String getPasswort() {
        return this.passwort;
    }

    /*
     * @return String language
     */
    public String getLanguage() {
        return this.language;
    }

    /*
     * @return String server (SAP Router)
     */
    public String getServer() {
        return this.server;
    }

    /*
     * @return String systemNumber
     */
    public String getSystemNumber() {
        return this.systemNumber;
    }
}
