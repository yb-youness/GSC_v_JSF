package com.gsc.dao;

import java.util.List;

import com.gsc.model.AllCmd;
import com.gsc.model.Commande;;

public interface CommandeOps {
	
	public Commande getOneCommande(int id);
	public List<AllCmd>getAllCommande();
	public void saveOrUpdateCommande(Commande cl);
	public void deletCommande(int id);

}
