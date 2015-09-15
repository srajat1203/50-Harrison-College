package DB;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import customerTools.DBUtil;
import model.Hccourse;
import model.Hcuser;




public class HccourseDB {


	public static List<Hccourse> getclass(Hcuser user) 
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryStr = "SELECT p FROM Hccourse p where p.hcuser = :user"  ;
		
		//String queryStr = "SELECT l FROM Shoplineitem l where l.order_id = " + oid;
		List<Hccourse> Hccourse = null;
        
		
		
		try
		{
			Query query = em.createQuery(queryStr)
					.setParameter("user", user);
			Hccourse =  query.getResultList();
			System.out.println("Hccourse.size = " + Hccourse.size());
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
		return Hccourse;
	}
	
	
	
	
	public static Hccourse getline(long crnid )
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try
		{
			
			Hccourse Hccourse = em.find(Hccourse.class, crnid);
			//System.out.println(products);
			return Hccourse;
			
			
		}
		finally
		{
			em.close();
		}
		
	
	
	}
	
	
	public static List<Hccourse> getAllCourse()
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		//String queryStr = "SELECT p FROM Hccourse p  ORDER BY p.productName";
		String queryStr = "SELECT p FROM Hccourse p";
		List<Hccourse> hccourse = null;
		try
		{
			Query query = em.createQuery(queryStr);
			hccourse =  query.getResultList();
			System.out.println("size = " + hccourse.size());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			em.close();
		}
		return hccourse;
	}
	
	
	
	
}
	
	

