package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import DBUtil.DBUtil;
import model.Hccourse;



public class HccourseDB {
	public static void insert(Hccourse user) {
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

	public static void update(Hccourse user) {
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

	public static void delete(Hccourse user) {
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
	
	public static Hccourse checkLogin(String username, String password){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		String qString = "select i from Hccourse i where i.username = '" + username + "' and i.password = '" + password + "'";
		TypedQuery<Hccourse> q = em.createQuery(qString, Hccourse.class);
		List<Hccourse> users;
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
	
	public static List<Hccourse> getAllCourses(){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		String qString = "select i from Hccourse i";
		TypedQuery<Hccourse> q = em.createQuery(qString, Hccourse.class);
		List<Hccourse> users;
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
	
	
	public static List<Hccourse> getPeopleByCompanyName(String company){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		String qString = "select i from Customerspractice i where i.company like '%" + company + "%'";
		TypedQuery<Hccourse> q = em.createQuery(qString, Hccourse.class);
		List<Hccourse> users;
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
	
	public static Hccourse getCourseByID(int uid){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		String qString = "select i from Hccourse i where i.id = " + uid;
		TypedQuery<Hccourse> q = em.createQuery(qString, Hccourse.class);
		List<Hccourse> users;
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
	
	public static Hccourse getUserByName(String uname){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();	
		String qString = "select i from Hccourse i where i.username = '" + uname + "'";
		TypedQuery<Hccourse> q = em.createQuery(qString, Hccourse.class);
		List<Hccourse> users;
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
