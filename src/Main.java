import com.sap.mw.jco.JCO;

public class Main {
	private static SAPVerbindung verbindung = new SAPVerbindung();

	public static void main(String[] args) {
		Config einstellungen = new Config("sap-zugangsdaten.properties");

		verbindung.openConnectionToSAP(einstellungen.getClientSAP(),
							einstellungen.getLogin(),
							einstellungen.getPasswort(),
							einstellungen.getLanguage(),
							einstellungen.getServer(),
							einstellungen.getSystemNumber());



		verbindung.closeConnectionToSAP();
	}
}
