package customTools;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Hcclass;
import model.Hcclassroom;
import model.Hccourse;


public class HcclassroomDB {

	
	
	public static List<Hcclassroom> getAllClassrooms(){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		String qString = "select i from Hcclassroom i";
		TypedQuery<Hcclassroom> q = em.createQuery(qString, Hcclassroom.class);
		List<Hcclassroom> users;
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
	
	
	public static void insert(Hcclassroom user) {
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
	
	public static Hcclassroom getClassroomByID(int uid){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		String qString = "select i from Hcclassroom i where i.id = " + uid;
		TypedQuery<Hcclassroom> q = em.createQuery(qString, Hcclassroom.class);
		List<Hcclassroom> users;
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
	
	
	public static void update(Hcclassroom user) {
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
