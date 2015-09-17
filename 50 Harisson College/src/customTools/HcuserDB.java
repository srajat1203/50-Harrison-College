package customTools;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Hcclass;
import model.Hcclassroom;
import model.Hccourse;
import model.Hcuser;

public class HcuserDB {

	
	public static List<Hcuser> getinstructor(Hcclass hcclass) 
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryStr = "SELECT p FROM Hcclass p where p.hcclasses = :hcclass"  ;
		
		//String queryStr = "SELECT l FROM Shoplineitem l where l.order_id = " + oid;
		List<Hcuser> hcuser = null;
        
		
		
		try
		{
			Query query = em.createQuery(queryStr)
					.setParameter("hcclass",hcclass);
			hcuser =  query.getResultList();
			System.out.println("hccuser.size = " + hcuser.size());
			//System.out.println("size = " + user.getType() + user);
		}
		
		
		
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			em.close();
		}
		return hcuser;
	}
	
	
	
	
	
	public static Hcuser getclassroom(long instructorid)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try
		{
			Hcuser hcuser = em.find(Hcuser.class, instructorid);
			return hcuser;
		}
		finally
		{
			em.close();
		}
	}
	
	
	public static List<Hcuser> getAllUsers(){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		String qString = "select i from Hcuser i";
		TypedQuery<Hcuser> q = em.createQuery(qString, Hcuser.class);
		List<Hcuser> users;
		try{
			users = q.getResultList();
			if(users == null || users.isEmpty()){
				users = null;
			}
		}finally{
			em.close();
		}
		return users;
	}
	
	
	
	public static Hcuser getUserByID(int uid){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		String qString = "select i from Hcuser i where i.userid = " + uid;
		TypedQuery<Hcuser> q = em.createQuery(qString, Hcuser.class);
		List<Hcuser> users;
		try{
			users = q.getResultList();
			if(users == null || users.isEmpty()){
				users = null;
			}
		}finally{
			em.close();
		}
		return users.get(0);
	}
	

	public static void update(Hcuser user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(user);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	
	public static void insert(Hcuser user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(user);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	} 
	
}
