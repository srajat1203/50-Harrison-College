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

	public static List<Hcenrolledclass> rosterOfStudent(Hcclass hcclass) {
		System.out.println("in db roster of student for this class "+hcclass.getCrn());
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String query = "SELECT h FROM Hcenrolledclass h WHERE h.hcclass=:hcclass";
		System.out.println(query);
		List<Hcenrolledclass> students = null;
		System.out.println(query);

		TypedQuery<Hcenrolledclass> q = em.createQuery(query, Hcenrolledclass.class);
		q.setParameter("hcclass", hcclass);
		try {
			System.out.println("in try");
			students = q.getResultList();
			System.out.println(students.get(0).getHcuser().getName());

		} catch (Exception e) {
		} finally {
			em.close();
		}
		return students;
	}
	
	public static EntityManagerFactory getEmFactory() {
		return emf;
	}

	public static Hcclass selectclass(long id) {
		System.out.println("in db class " +id);
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String query = "SELECT h FROM Hcclass h WHERE h.crn =" +id ;
		System.out.println(query);
		TypedQuery<Hcclass> q = em.createQuery(query, Hcclass.class);
		Hcclass returnclass = null;
		try {
			System.out.println("in try class");
			returnclass = q.getSingleResult();

		} catch (Exception e) {
		} finally {
			em.close();
		}
		return returnclass;
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