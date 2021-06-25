package com.gsc.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gsc.model.AllCmd;
import com.gsc.model.Commande;
import com.gsc.util.HibernateUtil;

public class CommandeDao implements CommandeOps {
	
	
	@SuppressWarnings("unused")
	@Override
	public void saveOrUpdateCommande(Commande cm) {
		

		 Transaction transaction = null;
		 Session session=null;
     
		 try {
	        	session = HibernateUtil.getSessionFactory().openSession();
		          transaction = session.beginTransaction();
		          session.saveOrUpdate(cm);
		 } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }finally {
	        	transaction.commit();
	    
				session.close();
			}    
	}

	@Override
	public void deletCommande(int id) {
		 Transaction transaction = null;
		 Session session=null;     
		 try {
	        	session = HibernateUtil.getSessionFactory().openSession();
		          transaction = session.beginTransaction();
		          Commande curent = (Commande)session.load(Commande.class, new Integer(id));
		          session.delete(curent);
		 } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }finally {
	        	transaction.commit();
	    
				session.close();
			}    
		
	}

	@Override
	public Commande getOneCommande(int id) {
		
		 Transaction transaction = null;
		 Session session=null;
		 Commande curent = new Commande();
		 try {
	        	session = HibernateUtil.getSessionFactory().openSession();
		          transaction = session.beginTransaction();
		          curent = (Commande)session.load(Commande.class, new Integer(id));
		         
		          System.out.println(curent.toString());
		        
		 } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }finally {
	        	transaction.commit();
	    
				session.close();
			}    
		
	
		return curent;
	}
    
	@SuppressWarnings("unchecked")
	@Override
	public List<AllCmd> getAllCommande() {
		
		 Transaction transaction = null;
		 Session session=null;
		
		 List <AllCmd> allCommand = new ArrayList<AllCmd>();
		 try {
	        	session = HibernateUtil.getSessionFactory().openSession();
		          transaction = session.beginTransaction();
		          Query query = session.createSQLQuery("select * FROM commande INNER JOIN produit p on p.ProduitId=commande.id_produit INNER JOIN client c on c.id_client=\r\n" + 
		          		"commande.idclient;");
	
		          List<Object[]> rows = query.list();
		          for(Object[] row : rows){
		        	  AllCmd cmdd=new AllCmd();
		        	  cmdd.setAdress(row[4].toString()); cmdd.setQuantite(Integer.parseInt(row[5].toString()));
		        	  cmdd.setDatecmd(row[6].toString());cmdd.setLibeleProduit(row[8].toString());
		        	  cmdd.setPrix(Double.parseDouble(row[10].toString()));cmdd.setNomclient(row[13].toString());
		        	  cmdd.setPrenomclient(row[14].toString());
		        	  allCommand.add(cmdd);
		          }
		        	
		 } 
		          catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }finally {
	        	transaction.commit();
	    
				session.close();
			}    
		
		
		return allCommand;
	}

	
	
	
	
	
	
	
	

}
