package DB;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Hcclass;
import model.Hccourse;
import model.Hcuser;
import customerTools.DBUtil;

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
	
	

	
	
	
}
