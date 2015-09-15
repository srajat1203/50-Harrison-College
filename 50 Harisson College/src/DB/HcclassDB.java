package DB;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import customerTools.DBUtil;
import model.Hcclass;
import model.Hcuser;




public class HcclassDB {


	public static List<Hcclass> getclass(Hcuser user) 
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryStr = "SELECT p FROM Hcclass p where p.hcuser = :user"  ;
		
		//String queryStr = "SELECT l FROM Shoplineitem l where l.order_id = " + oid;
		List<Hcclass> hcclass = null;
        
		
		
		try
		{
			Query query = em.createQuery(queryStr)
					.setParameter("user", user);
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
	
	
	
	
	public static Hcclass getline(long crnid )
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try
		{
			
			Hcclass hcclass = em.find(Hcclass.class, crnid);
			//System.out.println(products);
			return hcclass;
			
			
		}
		finally
		{
			em.close();
		}
		
	
	
	}
}
	
	

