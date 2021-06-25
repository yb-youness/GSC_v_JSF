package com.gsc.dao;

import java.util.ArrayList;
import java.util.List;

import com.gsc.model.Client;
import com.gsc.util.HibernateUtil;
import org.hibernate.*;

public class ClientDao implements ClientOps{

	
	@SuppressWarnings("unused")
	@Override
	public void saveOrUpdateClient(Client cl) {
		

		 Transaction transaction = null;
		 Session session=null;
     
		 try {
	        	session = HibernateUtil.getSessionFactory().openSession();
		          transaction = session.beginTransaction();
		          session.saveOrUpdate(cl);
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
	public void deletClient(int id) {
		 Transaction transaction = null;
		 Session session=null;     
		 try {
	        	session = HibernateUtil.getSessionFactory().openSession();
		          transaction = session.beginTransaction();
					Client curent = (Client)session.load(Client.class, new Integer(id));
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
	public Client getOneClient(int id) {
		
		 Transaction transaction = null;
		 Session session=null;
		 Client curent = new Client();
		 try {
	        	session = HibernateUtil.getSessionFactory().openSession();
		          transaction = session.beginTransaction();
		          curent = (Client)session.load(Client.class, new Integer(id));
		         
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
	public List<Client> getAllClient() {
		
		 Transaction transaction = null;
		 Session session=null;
		// Client cl ;
		 List <Client> allClient = new ArrayList<Client>();
		 try {
	        	session = HibernateUtil.getSessionFactory().openSession();
		          transaction = session.beginTransaction();
		          Query query = session.createQuery("from Client");
		          allClient=query.list();
		          for(Client cl : allClient)
		        	  System.out.println(cl.toString());
		      
		        
		 } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }finally {
	        	transaction.commit();
	    
				session.close();
			}    
		
		
		return allClient;
	}


	
}
