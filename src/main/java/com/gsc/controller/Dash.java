package com.gsc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import com.gsc.dao.CategorieDao;
import com.gsc.dao.CategorieOps;
import com.gsc.dao.ClientDao;
import com.gsc.dao.ClientOps;
import com.gsc.dao.CommandeDao;
import com.gsc.dao.CommandeOps;
import com.gsc.dao.ProduitDao;
import com.gsc.dao.ProduitOps;
import com.gsc.model.AllCmd;
import com.gsc.model.Categorie;
import com.gsc.model.Client;
import com.gsc.model.Commande;
import com.gsc.model.Produit;

@ManagedBean
public class Dash {
	private Client cl;
	private Categorie cat;
	private Produit prod;
	private Commande cmd;
	private String catvalue;
	private String cltval;
	private String prodval;
	
	
	// Lists
	private List<Client> listcl;
	private List<Categorie> listcat;
	private Map<String, String> listdropcat;
	private Map<String, String> listdropclient;
	private Map<String, String> listdropProduit;//Pour remplire la liste des produits.
	private List<AllCmd> allCmd ;
		
	
	private List<Produit> listprod;

	
	public Dash () {
		cl = new Client();
		cat = new Categorie();
		prod = new Produit();
		cmd = new Commande();
		Showclients();
		ShowCat();
		ShowProduit();
		loadCattoDrop();
		loadClientDrop();//Charger la liste des clients 
		loadProductDrop();
		ListCommande();
		
//		//  Show 
//		
//	   
	}
	
	
	public String ListCommande() {
		
		 CommandeOps clops = new CommandeDao();
		 
		 allCmd=clops.getAllCommande();
		 
		
	    	return "commande?faces-redirect=true&msg=true";
	}
	
	
	// Deconect 
	public  String dec() {
		
		// Destroy  Session 
		return "login";
	}
	
	 // Add Or Update Cl
	public String AddClient() {
		  ClientOps clops = new ClientDao();
		            clops.saveOrUpdateClient(cl);
		        
		    
		return "clients?faces-redirect=true&msg=true";
	}

	// Show Clients 
	public String Showclients() {
		 ClientOps clops = new ClientDao();
		   listcl = clops.getAllClient();		
		return "clients";
	}
	
	
	// Show Cat

	public String ShowCat() {
		 CategorieOps clops = new CategorieDao();
		   listcat = clops.getAllCategory();
		   
		   return "categorie";
	}
	
	
	// Show Cat

	public String ShowProduit() {
		 ProduitOps clops = new ProduitDao();
		   listprod = clops.getAllProduit();
		   
		   return "categorie";
	}
	
	
	
	
	// Add Or Category Cat
	public String AddCategory() {
		CategorieOps catops = new CategorieDao();
   	catops.saveOrUpdateCategory(cat);
		  
	
	return "categorie?faces-redirect=true&msg=true";
		 
	}

	
	
	
	 // Add Or Update Product
	public String AddProduit() {
		  prod.setCategorieId(Integer.parseInt(catvalue));
	    
		  ProduitOps p = new  ProduitDao();
		             p.saveOrUpdateProduit(prod);
		return "produit?faces-redirect=true&msg=true";
	}
	
	// Add Or Update Commande
		public String Addcommand() {
			  cmd.setIdclient(Integer.parseInt(cltval));
			  cmd.setIdProduit(Integer.parseInt(prodval));
		    
			  CommandeOps C = new  CommandeDao();
			  
			             C.saveOrUpdateCommande(cmd);
			 
			return "commande?faces-redirect=true&msg=true";
		}

	//Recuperer la liste des categories qui se trouve dans la base de donnes
	 private void loadCattoDrop() {
		 
		 CategorieOps clops = new CategorieDao();
		 List<Categorie> list = clops.getAllCategory();
		  listdropcat = new HashMap<String, String>();
		 for(Categorie c : list) {
			 listdropcat.put(c.getCatId().toString(), c.getLibeleCat());
		 }
	 }
	
	

	
	//Recuperer la liste des clients qui se trouve dans la base de donnes
	 private void loadClientDrop() {
		 
		 ClientOps cltops = new ClientDao();
		 List<Client> listC = cltops.getAllClient();
		  listdropclient = new HashMap<String, String>();
		 for(Client cll : listC) {
			 listdropclient.put(cll.getIdClient().toString(), cll.getNom());
		 }
	 }
	
	 
	 

		//Recuperer la liste des produits qui se trouve dans la base de donnes
		 private void loadProductDrop() {
			 
			 ProduitOps cltops = new ProduitDao();
			 List<Produit> listC = cltops.getAllProduit();
			  listdropProduit = new HashMap<String, String>();
			 for(Produit Prod : listC) {
				 listdropProduit.put(Prod.getProduitId().toString(), Prod.getLibele());
			 }
		 }
		
	// Get and Sets 
	
	
	public List<Categorie> getListcat() {
		//ShowCat();
		return listcat;
	}

	public void setListcat(List<Categorie> listcat) {
		this.listcat = listcat;
	}

	public Client getCl() {
		return cl;
	}


	public void setCl(Client cl) {
		this.cl = cl;
	}


	public Categorie getCat() {
		 
		return cat;
	}


	public void setCat(Categorie cat) {
		this.cat = cat;
	}


	public Produit getProd() {
		return prod;
	}


	public void setProd(Produit prod) {
		this.prod = prod;
	}


	public Commande getCmd() {
	
		return cmd;
	}


	public void setCmd(Commande cmd) {
		this.cmd = cmd;
	}

	public List<Client> getListcl() {
		//Showclients();
		return listcl;
	}

	public void setListcl(List<Client> listcl) {
		this.listcl = listcl;
	}



	public Map<String, String> getListdropcat() {
		return listdropcat;
	}

	public void setListdropcat(Map<String, String> listdropcat) {
		this.listdropcat = listdropcat;
	}
	
	

	public String getCltval() {
		return cltval;
	}



	public void setCltval(String cltval) {
		this.cltval = cltval;
	}
	

	public String getProdval() {
		return prodval;
	}



	public void setProdval(String prodval) {
		this.prodval = prodval;
	}



	public Map<String, String> getListdropclient() {
		return listdropclient;
	}



	public void setListdropclient(Map<String, String> listdropclient) {
		this.listdropclient = listdropclient;
	}


	

	public Map<String, String> getListdropProduit() {
		return listdropProduit;
	}



	public void setListdropProduit(Map<String, String> listdropProduit) {
		this.listdropProduit = listdropProduit;
	}



	public String getCatvalue() {
		return catvalue;
	}



	public void setCatvalue(String catvalue) {
		this.catvalue = catvalue;
	}
	



	public List<Produit> getListprod() {
		return listprod;
	}



	public void setListprod(List<Produit> listprod) {
		this.listprod = listprod;
	}



	public List<AllCmd> getAllCmd() {
		
		return allCmd;
	}



	public void setAllCmd(List<AllCmd> allCmd) {
		this.allCmd = allCmd;
	}
	
	
	
	
	
	
	
	
	
	
  
}
