package backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.sap.mw.jco.IRepository;
import com.sap.mw.jco.JCO;
import com.sap.mw.jco.JCO.Repository;

import model.CatalogItem;

public class ProductCatalog
{
  JCO.Client mConnection;

  public ProductCatalog(JCO.Client mConnection)
  {
      this.mConnection = mConnection;
//      connectionAttributes();
  }

  public void connectionAttributes()//<---das ist eine Entwickler-Test-Methode
  {
      System.out.println(mConnection.getAttributes());

      System.out.println("\n\nGET LIST");
	  Vector<String> v_ProductCatalogs = getList();
	  for (int i=0; i<v_ProductCatalogs.size(); i++)
	  {
		  System.out.println(v_ProductCatalogs.get(i));
	  }

	  System.out.println("\n\nGET VARIANTS");
      Vector<String> v_Variants = getVariants("PUMPS4SALE");
      for (int i=0; i<v_Variants.size(); i++)
      {
          System.out.println(v_Variants.get(i));
      }

      System.out.println("\n\nGET ITEMS");
	  List<CatalogItem> l_Items = getItems("PUMPS4SALE", "001");
	  for (int i=0; i<l_Items.size(); i++)
	  {
		  System.out.println(l_Items.get(i).getArea() + " --- " + l_Items.get(i).getItem() + " --- " +
		                     l_Items.get(i).getMatnr() + " --- " + l_Items.get(i).getName() + " --- " +
		                     l_Items.get(i).getTitle());
	  }

	  System.out.println("\n\nGET ITEM");
	  CatalogItem CI = getItem("PUMPS4SALE", "001", "0000000001", "0000000001");
	  System.out.println(CI.getMatnr() + " --- " + CI.getName() + " --- " + CI.getTitle() + " --- " +
	                      CI.getArea() + " --- " + CI.getItem());
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

	  Vector<String> v_Variants = new Vector<String>(tbl_Variants.getNumRows(), 1);
	  for (int i=0; i<tbl_Variants.getNumRows(); i++)
	  {
	     tbl_Variants.setRow(i);
	     v_Variants.add(tbl_Variants.getString("VARIANT"));
	  }
	  return v_Variants;
  }

  public List<CatalogItem> getItems(String s_catalog, String s_variant)
  {
	  Repository mRepository = new JCO.Repository("MyRepository", mConnection);
	  JCO.Function function = this.createFunction( mRepository, "BAPI_ADV_MED_GET_ITEMS");
	  function.getImportParameterList().setValue(s_catalog, "CATALOG");
	  function.getImportParameterList().setValue(s_variant, "VARIANT");
	  mConnection.execute(function);
      JCO.Table tbl_Items = function.getTableParameterList().getTable("ITEMS");

      List<CatalogItem> al_CatalogItems = new ArrayList<CatalogItem>();
   //   Vector<String> v_Items = new Vector<String>(tbl_Items.getNumRows(), 1);
      for (int i=0; i<tbl_Items.getNumRows(); i++)
      {
         tbl_Items.setRow(i);
  //       v_Items.add(tbl_Items.getString("MATERIAL"));
         al_CatalogItems.add(new CatalogItem(tbl_Items.getString("MATERIAL"),
                                             null,
                                             null,
                                             tbl_Items.getString("AREA"),
                                             tbl_Items.getString("ITEM")));
      }
	  return al_CatalogItems;
  }

  public CatalogItem getItem(String s_catalog, String s_variant, String s_area, String s_item)
  {
      Repository mRepository = new JCO.Repository("MyRepository", mConnection);
      JCO.Function function = this.createFunction( mRepository, "BAPI_PRODCAT_GETITEM");
      function.getImportParameterList().setValue(s_catalog, "CATALOG");
      function.getImportParameterList().setValue(s_variant, "VARIANT");
      function.getImportParameterList().setValue(s_area, "AREA");
      function.getImportParameterList().setValue(s_item, "ITEM");
      mConnection.execute(function);
      JCO.Table tbl_Itemtexts = function.getTableParameterList().getTable("ITEMTEXTS");
      JCO.Structure tbl_Itemdetails = function.getExportParameterList().getStructure("ITEMDETAIL");

      return new CatalogItem(tbl_Itemdetails.getString("MATERIAL"), tbl_Itemtexts.getString("NAME"),
                             tbl_Itemtexts.getString("TITLE"), s_area, s_item);
  }

/*  public CatalogItem getItem(String s_catalog, String s_variant, String s_area, String s_item)
  {
	  Repository mRepository = new JCO.Repository("MyRepository", mConnection);
	  JCO.Function function = this.createFunction( mRepository, "BAPI_PRODCAT_GETITEM");
	  function.getImportParameterList().setValue(s_catalog, "CATALOG");
	  function.getImportParameterList().setValue(s_variant, "VARIANT");
	  function.getImportParameterList().setValue(s_area, "AREA");
	  function.getImportParameterList().setValue(s_item, "ITEM");
	  mConnection.execute(function);
	  JCO.Table tblItemtexts = function.getTableParameterList().getTable("ITEMTEXTS");


	  for (int i=0; i<tblItemtexts.getNumRows(); i++)
	  {
	     tblItemtexts.setRow(i);
	     System.out.println(tblItemtexts.getString("LAYOUT") + "';'" + tblItemtexts.getString("AREA") + "';'" + tblItemtexts.getString("ITEM") +
	        "';'" + tblItemtexts.getString("NAME") + "';'" + tblItemtexts.getString("LANGU"));
	  }

	  return new CatalogItem(s_item, tblItemtexts.getString("NAME"))
  }*/

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

