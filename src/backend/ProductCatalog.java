package backend;

import java.util.Vector;

import com.sap.mw.jco.IRepository;
import com.sap.mw.jco.JCO;
import com.sap.mw.jco.JCO.Repository;

public class ProductCatalog
{
  JCO.Client mConnection;

  public ProductCatalog(JCO.Client mConnection)
  {
      this.mConnection = mConnection;
      connectionAttributes();

  }

  public void connectionAttributes()//<---das ist eine Entwickler-Test-Methode
  {
      //System.out.println(mConnection.getAttributes());

	  Vector<String> v_ProductCatalogs = getList();
	  for (int i=0; i<v_ProductCatalogs.size(); i++)
	  {
		  System.out.println(v_ProductCatalogs.get(i));
	  }

      Vector<String> v_Variants = getVariants("PUMPS4SALE");
      for (int i=0; i<v_Variants.size(); i++)
      {
          System.out.println(v_Variants.get(i));
      }

//In folgender Zeile wird er Name des Katalogsuebergeben
	 /* JCO.Table tblVariants = getVariants("PUMPS4SALE");
	  for (int i=0; i<tblVariants.getNumRows(); i++)
	  {
		  tblVariants.setRow(i);
		  System.out.println(tblVariants.getString("PRODCAT") + " --- " + tblVariants.getString("VARIANT"));
	  }
*/
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


  public Vector<String> getList()
  {
	  Repository mRepository = new JCO.Repository("MyRepository", mConnection);
	  JCO.Function function = this.createFunction( mRepository, "BAPI_ADV_MED_GET_LIST");
	  mConnection.execute( function);
	  JCO.Table tbl_ProductCatalogs = function.getTableParameterList().getTable("CATALOGS");


	  Vector<String> v_ProductCatalogs = new Vector<String>(tbl_ProductCatalogs.getNumRows(), 1);
      for (int i=0; i<tbl_ProductCatalogs.getNumRows(); i++)
         {
              tbl_ProductCatalogs.setRow(i);
              v_ProductCatalogs.add(tbl_ProductCatalogs.getString("PRODCAT"));
         }
      return v_ProductCatalogs;
  }

  public Vector<String> getVariants(String s_catalog)
  {
	  Repository mRepository = new JCO.Repository("MyRepository", mConnection);
	  JCO.Function function = this.createFunction( mRepository, "BAPI_ADV_MED_GET_VARIANT_LIST");
	  function.getImportParameterList().setValue(s_catalog, "CATALOG");
	  mConnection.execute( function);
	  JCO.Table tbl_Variants = function.getTableParameterList().getTable("VARIANTS");

	  Vector<String> v_Variants = new Vector<String>(20, 1);
	  for (int i=0; i<tbl_Variants.getNumRows(); i++)
	  {
	      tbl_Variants.setRow(i);
	      v_Variants.add(tbl_Variants.getString("VARIANT"));
	  }


	  return v_Variants;
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

