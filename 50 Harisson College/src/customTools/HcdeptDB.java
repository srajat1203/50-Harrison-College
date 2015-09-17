package customTools;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Hcclass;
import model.Hcdept;



public class HcdeptDB {
	public static void insert(Hcdept user) {
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

	public static void update(Hcdept user) {
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

	public static void delete(Hcdept user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.remove(em.merge(user));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	public static Hcdept checkLogin(String username, String password){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		String qString = "select i from Hcdept i where i.username = '" + username + "' and i.password = '" + password + "'";
		TypedQuery<Hcdept> q = em.createQuery(qString, Hcdept.class);
		List<Hcdept> users;
		try{
			users = q.getResultList();
			if(users == null || users.isEmpty()){
				return null;
			}
		}finally{
			em.close();
		}
		return users.get(0);
	}
	
	public static List<Hcdept> getAllDepts(){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		String qString = "select i from Hcdept i";
		TypedQuery<Hcdept> q = em.createQuery(qString, Hcdept.class);
		List<Hcdept> users;
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
	
	
	public static List<Hcdept> getPeopleByCompanyName(String company){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		String qString = "select i from Customerspractice i where i.company like '%" + company + "%'";
		TypedQuery<Hcdept> q = em.createQuery(qString, Hcdept.class);
		List<Hcdept> users;
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
	
	public static Hcdept getDeptByID(int uid){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		String qString = "select i from Hcdept i where i.id = " + uid;
		TypedQuery<Hcdept> q = em.createQuery(qString, Hcdept.class);
		List<Hcdept> users;
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
	
	public static Hcdept getUserByName(String uname){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		String qString = "select i from Hcdept i where i.username = '" + uname + "'";
		TypedQuery<Hcdept> q = em.createQuery(qString, Hcdept.class);
		List<Hcdept> users;
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
	
	

	
	
	
}
