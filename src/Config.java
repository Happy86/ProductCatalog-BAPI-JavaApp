import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
	private String clientSAP;		// client number
	private String login;			// username
	private String passwort;		// password
	private String language;		// language
	private String server;			// SAP router
	private String systemNumber;	// system number

	private InputStream inputFile;
	private Properties propertiesObjekt = new Properties();
	
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


	public String getClientSAP() {
		return this.clientSAP;
	}

	public String getLogin() {
		return this.login;
	}

	public String getPasswort() {
		return this.passwort;
	}

	public String getLanguage() {
		return this.language;
	}

	public String getServer() {
		return this.server;
	}

	public String getSystemNumber() {
		return this.systemNumber;
	}
}
