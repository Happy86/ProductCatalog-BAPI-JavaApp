import com.sap.mw.jco.JCO;

public class SAPVerbindung {
	private JCO.Client mConnection;

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

	public void closeConnectionToSAP() {
		this.mConnection.disconnect();
	}
	
	public JCO.Client getMConnection() {
		return this.mConnection;
	}
}
