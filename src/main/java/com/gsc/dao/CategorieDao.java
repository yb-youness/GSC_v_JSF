package com.gsc.dao;

import java.util.ArrayList;
import java.util.List;

import com.gsc.model.Categorie;
import com.gsc.util.HibernateUtil;
import org.hibernate.*;

public class CategorieDao implements CategorieOps{

	
	@SuppressWarnings("unused")
	@Override
	public void saveOrUpdateCategory(Categorie cat) {
		

		 Transaction transaction = null;
		 Session session=null;
     
		 try {
	        	session = HibernateUtil.getSessionFactory().openSession();
		          transaction = session.beginTransaction();
		          session.saveOrUpdate(cat);
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
	public Categorie getOneCategory(int id) {
		
		 Transaction transaction = null;
		 Session session=null;
		 Categorie curent = new Categorie();
		 try {
	        	session = HibernateUtil.getSessionFactory().openSession();
		          transaction = session.beginTransaction();
		          curent = (Categorie)session.load(Categorie.class, new Integer(id));
		         
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
	public List<Categorie> getAllCategory() {
		
		 Transaction transaction = null;
		 Session session=null;
		
		 List <Categorie> allCategory = new ArrayList<Categorie>();
		 try {
	        	session = HibernateUtil.getSessionFactory().openSession();
		          transaction = session.beginTransaction();
		          Query query = session.createQuery("from Categorie");
		          allCategory=query.list();
		  
		      
		        
		 } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }finally {
	        	transaction.commit();
	    
				session.close();
			}    
		
		
		return allCategory;
	}


	
}
