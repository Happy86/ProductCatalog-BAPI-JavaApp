package backend;

import com.sap.mw.jco.IRepository;
import com.sap.mw.jco.JCO;
import com.sap.mw.jco.JCO.Repository;

public class ProductCatalog
{
  JCO.Client mConnection;

  public ProductCatalog(JCO.Client mConnection)
  {
      this.mConnection = mConnection;

//	  openConnectionToSAP(");//TODO
	  //openConnectionToSAP(");
    connectionAttributes();
//    closeConnectionToSAP();
  }

  public void connectionAttributes()
  {
      //System.out.println(mConnection.getAttributes());

	  JCO.Table tblCatalogs = getList();
	  for (int i=0; i<tblCatalogs.getNumRows(); i++)
	  {
		  tblCatalogs.setRow(i);
		  System.out.println(tblCatalogs.getString("PRODCAT"));
	  }


//In folgender Zeile wird er Name des Katalogsuebergeben
	  JCO.Table tblVariants = getVariants("PUMPS4SALE");
	  for (int i=0; i<tblVariants.getNumRows(); i++)
	  {
		  tblVariants.setRow(i);
		  System.out.println(tblVariants.getString("PRODCAT") + " --- " + tblVariants.getString("VARIANT"));
	  }

//In folgender Zeile wird der Name des Katalogs + der Variante uebergeben
	  JCO.Table tblItems = getItems("PUMPS4SALE", "001");
	  for (int i=0; i<tblItems.getNumRows(); i++)
	  {
		  tblItems.setRow(i);
		  System.out.println(tblItems.getString("ITEM") + " --- " + tblItems.getString("MATERIAL") + " --- " + tblItems.getString("SORTNR"));
	  }

	  //getItem benoetigt Katalogname + Variant + Area + Item
	  JCO.Table tblItemtexts = getItem("PUMPS4SALE", "001", "0000000001", "0000000001");
	  for (int i=0; i<tblItemtexts.getNumRows(); i++)
	  {
		  tblItemtexts.setRow(i);
		  System.out.println(tblItemtexts.getString("LAYOUT") + "';'" + tblItemtexts.getString("AREA") + "';'" + tblItemtexts.getString("ITEM") +
				  "';'" + tblItemtexts.getString("NAME") + "';'" + tblItemtexts.getString("LANGU"));
	  }
  }


  public JCO.Table getList()
  {
	  Repository mRepository = new JCO.Repository("MyRepository", mConnection);
	  JCO.Function function = this.createFunction( mRepository, "BAPI_ADV_MED_GET_LIST");
	  mConnection.execute( function);

	  return function.getTableParameterList().getTable("CATALOGS");
  }

  public JCO.Table getVariants(String s_catalog)
  {
	  Repository mRepository = new JCO.Repository("MyRepository", mConnection);
	  JCO.Function function = this.createFunction( mRepository, "BAPI_ADV_MED_GET_VARIANT_LIST");
	  function.getImportParameterList().setValue(s_catalog, "CATALOG");
	  mConnection.execute( function);

	  return function.getTableParameterList().getTable("VARIANTS");
  }

  public JCO.Table getItems(String s_catalog, String s_variant)
  {
	  Repository mRepository = new JCO.Repository("MyRepository", mConnection);
	  JCO.Function function = this.createFunction( mRepository, "BAPI_ADV_MED_GET_ITEMS");
	  function.getImportParameterList().setValue(s_catalog, "CATALOG");
	  function.getImportParameterList().setValue(s_variant, "VARIANT");
	  mConnection.execute(function);

	  return function.getTableParameterList().getTable("ITEMS");
  }

  public JCO.Table getItem(String s_catalog, String s_variant, String s_area, String s_item)
  {
	  Repository mRepository = new JCO.Repository("MyRepository", mConnection);
	  JCO.Function function = this.createFunction( mRepository, "BAPI_PRODCAT_GETITEM");
	  function.getImportParameterList().setValue(s_catalog, "CATALOG");
	  function.getImportParameterList().setValue(s_variant, "VARIANT");
	  function.getImportParameterList().setValue(s_item, "AREA");
	  function.getImportParameterList().setValue(s_item, "ITEM");
	  mConnection.execute(function);

	  return function.getTableParameterList().getTable("ITEMTEXTS");
  }

  public void openConnectionToSAP(String clientSAP, String login, String passwort, String language, String server, String systemNumber)
  {
      //Verbindungsdaten
      System.out.print("Verbinde mich mit SAP ... ");
      mConnection = JCO.createClient(clientSAP,
    		           login,
                       passwort,
                       language,
                       server,
                       systemNumber);
      //Verbindung herstellen
      mConnection.connect();
      System.out.println("verbunden");
      System.out.println("-------------------------------------------");
  }


  public void closeConnectionToSAP()
  {
    mConnection.disconnect();
   }

  private JCO.Function createFunction( IRepository mRepository, String name )
  {
    try
    {
      return mRepository.getFunctionTemplate( name.toUpperCase() ).getFunction();
    } catch( Exception ex ) {/*ok*/}
    return null;
  }

}//Ende der Klasse

