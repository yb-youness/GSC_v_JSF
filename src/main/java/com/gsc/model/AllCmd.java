package com.gsc.model;

public class AllCmd {

	private String libeleProduit;
	private String nomclient;
	private String prenomclient;
	private String adress;
	private int quantite;
	private String datecmd;
	private double prix;
	
	public AllCmd() {}

	public String getLibeleProduit() {
		return libeleProduit;
	}

	public void setLibeleProduit(String libeleProduit) {
		this.libeleProduit = libeleProduit;
	}

	public String getNomclient() {
		return nomclient;
	}

	public void setNomclient(String nomclient) {
		this.nomclient = nomclient;
	}

	public String getPrenomclient() {
		return prenomclient;
	}

	public void setPrenomclient(String prenomclient) {
		this.prenomclient = prenomclient;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public String getDatecmd() {
		return datecmd;
	}

	public void setDatecmd(String datecmd) {
		this.datecmd = datecmd;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "AllCmd [libeleProduit=" + libeleProduit + ", nomclient=" + nomclient + ", prenomclient=" + prenomclient
				+ ", adress=" + adress + ", quantite=" + quantite + ", datecmd=" + datecmd + ", prix=" + prix + "]";
	} ;
	
	
	
	
	
	
	
	
	
}
