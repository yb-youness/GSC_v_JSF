package com.gsc.dao;

import java.util.List;
import com.gsc.model.Produit;;

public interface ProduitOps {
	
	public Produit getOneProduit(int id);
	public List<Produit>getAllProduit();
	public void saveOrUpdateProduit(Produit prod);
	public void deletProduit(int id);


}
