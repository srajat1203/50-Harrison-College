package customTools;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.*;

public class DBUtil {
	private static final EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("50 Harisson College");

	public static EntityManagerFactory getEmFactory() {
		return emf;
	}

	
	
	public static Hcuser selectuser(long id) {
		System.out.println(id);
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String query = "SELECT h FROM Hcuser h WHERE h.userid =" +id ;
		System.out.println(query);
		TypedQuery<Hcuser> q = em.createQuery(query, Hcuser.class);
		Hcuser user = null;
		try {
			System.out.println("in try");
			user = q.getSingleResult();

		} catch (Exception e) {
		} finally {
			em.close();
		}
		return user;
	}
	
	
	public static List<Hcclass> selectClassesByInstroctorForCurrentSemester(Hcuser hcuser, String semseter) {
		System.out.println("in db get list " +hcuser.getUserid());
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String query = "SELECT h FROM Hcclass h WHERE h.semester='"+semseter+"' and h.hcuser=:hcuser and h.enable = 1";
		List<Hcclass> clsess = null;
		System.out.println(query);
		TypedQuery<Hcclass> q = em.createQuery(query, Hcclass.class);
		System.out.println(q);
		q.setParameter("hcuser", hcuser);
		try {
			System.out.println("in try");
			clsess = q.getResultList();
			System.out.println(clsess.get(0).getCrn());

		} catch (Exception e) {
		} finally {
			em.close();
		}
		return clsess;
	}
}