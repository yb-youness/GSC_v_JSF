package com.gsc.dao;

import com.gsc.model.Produit;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.gsc.util.HibernateUtil;

public class ProduitDao implements ProduitOps{

	public ProduitDao() {
	
	}

	@SuppressWarnings("unused")
	@Override
	public void saveOrUpdateProduit(Produit prod) {
		

		 Transaction transaction = null;
		 Session session=null;
     
		 try {
	        	session = HibernateUtil.getSessionFactory().openSession();
		          transaction = session.beginTransaction();
		          session.saveOrUpdate(prod);
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
	public void deletProduit(int id) {
		 Transaction transaction = null;
		 Session session=null;     
		 try {
	        	session = HibernateUtil.getSessionFactory().openSession();
		          transaction = session.beginTransaction();
					Produit curent = (Produit)session.load(Produit.class, new Integer(id));
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
	public Produit getOneProduit(int id) {
		
		 Transaction transaction = null;
		 Session session=null;
		 Produit curent = new Produit();
		 try {
	        	session = HibernateUtil.getSessionFactory().openSession();
		          transaction = session.beginTransaction();
		          curent = (Produit)session.load(Produit.class, new Integer(id));
		         
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
	public List<Produit> getAllProduit() {
		
		 Transaction transaction = null;
		 Session session=null;
		
		 List <Produit> allProduit = new ArrayList<Produit>();
		 try {
	        	session = HibernateUtil.getSessionFactory().openSession();
		          transaction = session.beginTransaction();
		          Query query = session.createQuery("from Produit");
		          allProduit=query.list();
		          for(Produit pd : allProduit)
		        	  System.out.println(pd.toString());
		      
		        
		 } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }finally {
	        	transaction.commit();
	    
				session.close();
			}    
		
		
		return allProduit;
	}

	
	
	
}
