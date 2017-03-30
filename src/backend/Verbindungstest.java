package backend;

import java.awt.EventQueue;

import com.sap.mw.jco.*;
import com.sap.mw.jco.JCO.Repository;

public class Verbindungstest
{
  JCO.Client mConnection;
    
  public Verbindungstest()
  {
//	  openConnectionToSAP(");//TODO
	  //openConnectionToSAP(");
    connectionAttributes();
    closeConnectionToSAP();
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
	  
	  
//In folgender Zeile wird er Name des Katalogs �bergeben
	  JCO.Table tblVariants = getVariants("PUMPS4SALE"); 
	  for (int i=0; i<tblVariants.getNumRows(); i++)
	  {
		  tblVariants.setRow(i);
		  System.out.println(tblVariants.getString("PRODCAT") + " --- " + tblVariants.getString("VARIANT")); 
	  }
	  
//In folgender Zeile wird der Name des Katalogs + der Variante �bergeben
	  JCO.Table tblItems = getItems("PUMPS4SALE", "001"); 
	  for (int i=0; i<tblItems.getNumRows(); i++)
	  {
		  tblItems.setRow(i);
		  System.out.println(tblItems.getString("ITEM") + " --- " + tblItems.getString("MATERIAL") + " --- " + tblItems.getString("SORTNR")); 
	  }
	  
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
  
  public static void main(String [] args)
  {
      Verbindungstest app = new Verbindungstest();
    
//    EventQueue.invokeLater(new Runnable() {
//
//        @Override
//        public void run() {
//        	ProductCatalogGUI md = new ProductCatalogGUI();
//            md.setVisible(true);
//        }
//    });
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

