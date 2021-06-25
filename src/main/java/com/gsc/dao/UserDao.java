package com.gsc.dao;

import com.gsc.model.User;
import com.gsc.util.HibernateUtil;



// Hibernate stuff 
import org.hibernate.*;


public class UserDao implements UserOps {



	
	
	// Methode To Check A single User 
	
	@SuppressWarnings("unused")
	@Override
	public boolean CheckUser(User user) {
		 boolean res = false;
		
		 Transaction transaction = null;
		 Session session=null;
			Long count ;           
      
		 try {
	        	session = HibernateUtil.getSessionFactory().openSession();
		          transaction = session.beginTransaction();
					Query queryObj = session.createQuery("select count(*) from User where email = :em and pass=:p").setString("em", user.getEmail()).setString("p", user.getPass());
                       
		          count = (Long) queryObj.uniqueResult();
		                 if(count>0 )
		                	 res=true;
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }finally {
	        	transaction.commit();
	    
				session.close();
			}
		 return res;
	}
	
	

}
