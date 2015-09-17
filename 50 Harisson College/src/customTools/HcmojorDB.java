package customTools;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Hcclass;
import model.Hccourse;
import model.Hcdept;
import model.Hcmojor;

public class HcmojorDB {

	
	public static List<Hcmojor> getAllMajors(){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		String qString = "select i from Hcmojor i";
		TypedQuery<Hcmojor> q = em.createQuery(qString, Hcmojor.class);
		List<Hcmojor> users;
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
	
	
	
	public static void insert(Hcmojor user) {
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
	
	
	
	public static Hcmojor getMajorByID(int uid){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		String qString = "select i from Hcmojor i where i.id = " + uid;
		TypedQuery<Hcmojor> q = em.createQuery(qString, Hcmojor.class);
		List<Hcmojor> users;
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
	
	
	
	public static void update(Hcmojor user) {
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
	
	
	
}
