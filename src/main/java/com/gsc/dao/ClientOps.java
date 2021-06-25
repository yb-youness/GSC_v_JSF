package com.gsc.dao;

import java.util.List;

import com.gsc.model.Client;

public interface ClientOps {

	public Client getOneClient(int id);
	public List<Client>getAllClient();
	public void saveOrUpdateClient(Client cl);
	public void deletClient(int id);
	
}
