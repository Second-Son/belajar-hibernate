package hibernate;

import java.sql.Timestamp;

import org.hibernate.Session;

import hibernate.model.Employee;
import hibernate.util.HibernateUtil;

import hibernate.model.Employee;
import hibernate.model.BaseClass;;

public class MainApp {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		String result = getNativeQuery( session, "select version()");
		System.out.println(result);
		
		simpanPegawai(session);
		
		session.getTransaction().commit();
		session.close();
		
		HibernateUtil.shutdown();
		
	}
	
	private static Integer simpanPegawai(Session session) {
		Employee emp = new Employee();
		emp.setNama("Yusuf");
		emp.setAlamat("Jln Abcd");
		emp.setIdEntry("user1");
		emp.setTglEntry(new Timestamp(System.currentTimeMillis()));
		return (Integer) session.save(emp);
	}
	
	
	private static String getNativeQuery(Session session, String sql) {
		
		return (String) session.createNativeQuery(sql).getSingleResult();
	}
	
	
}
