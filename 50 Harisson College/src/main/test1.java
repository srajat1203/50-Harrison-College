package main;



import javax.persistence.EntityManager;

import customerTools.DBUtil;
	


	public class test1 {
		public static void main(String[] args) {
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			try {
				model.Hcdept cust = em.find(model.Hcdept.class, (long)2);
				System.out.println("1");
				System.out.println(cust.getName());
			} catch (Exception e){
				System.out.println(e);
			} finally {
				em.close();
				System.out.println("cerrado!");
			}
		}
	}

	
	

