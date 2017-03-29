import com.sap.mw.jco.JCO;

public class Main {
	public static void main(String[] args) {
		Config einstellungen = new Config("sap-zugangsdaten.properties");

		SAPVerbindung verbindung = new SAPVerbindung();
		verbindung.openConnectionToSAP(einstellungen.getClientSAP(),
							einstellungen.getLogin(),
							einstellungen.getPasswort(),
							einstellungen.getLanguage(),
							einstellungen.getServer(),
							einstellungen.getSystemNumber());



		verbindung.closeConnectionToSAP();
	}
}
