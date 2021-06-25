package com.gsc.dao;

import java.util.List;

import com.gsc.model.Categorie;;

public interface CategorieOps {
	
	public Categorie getOneCategory(int id);
	public List<Categorie>getAllCategory();
	public void saveOrUpdateCategory(Categorie cat);

}
