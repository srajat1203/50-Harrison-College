package DBUtil;

import javax.persistence.EntityManager; 
import javax.persistence.EntityManagerFactory; 
import javax.persistence.Persistence; 

public class DBUtil {
	private static final EntityManagerFactory emf =
			Persistence.createEntityManagerFactory("50 Harisson College");
	public static EntityManagerFactory getEmFactory() {
		return emf; 
	} 
}