package DB;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Hcclass;
import model.Hcclassroom;
import model.Hccourse;
import customerTools.DBUtil;

public class ClassroomDB {

	

	public static List<Hcclassroom> getclass(Hccourse course) 
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryStr = "SELECT p FROM Hcclass p where p. = :user"  ;
		
		//String queryStr = "SELECT l FROM Shoplineitem l where l.order_id = " + oid;
		List<Hcclass> hcclass = null;
        
		
		
		try
		{
			Query query = em.createQuery(queryStr)
					.setParameter("course",course);
			hcclass =  query.getResultList();
			System.out.println("hcclass.size = " + hcclass.size());
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
		return hcclass;
	}
	
}
